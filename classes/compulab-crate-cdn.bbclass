# Use the crates.io CDN with the BitBake crate fetcher shipped in Kirkstone.
# Install before recipe parsing so fetch URL initialization uses the CDN too.
python compulab_crate_cdn_handler() {
    from bb.fetch2.crate import Crate

    original = Crate._crate_urldata_init
    if getattr(original, '_compulab_crate_cdn', False):
        return

    def crate_urldata_init(self, ud, d):
        upstream = ud.url.startswith('crate://crates.io/')
        original(self, ud, d)
        api_prefix = 'https://crates.io/api/v1/crates/'
        if upstream and ud.url.startswith(api_prefix):
            ud.url = 'https://static.crates.io/crates/' + ud.url[len(api_prefix):]

    crate_urldata_init._compulab_crate_cdn = True
    Crate._crate_urldata_init = crate_urldata_init
}

addhandler compulab_crate_cdn_handler
compulab_crate_cdn_handler[eventmask] = "bb.event.ConfigParsed"

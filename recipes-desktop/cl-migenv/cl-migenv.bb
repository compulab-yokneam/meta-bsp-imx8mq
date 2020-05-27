DESCRIPTION = "CompuLab Environmet Migration tool"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a9098b71f5540144c2860fb801498f"
MAINTAINER = "Valentin Raevsky <valentin@compulab.com>"

PR = "r1"

SRC_URI = " \
	file://cl-migenv \
	file://COPYING \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/local/bin/
	install -m 0755 ${S}/cl-migenv ${D}/usr/local/bin/cl-migenv
}

FILES_${PN} = " \
	/usr/local/bin/cl-migenv \
"

RDEPENDS_${PN} = "bash dialog u-boot-fw-utils"
PACKAGE_ARCH = "all"

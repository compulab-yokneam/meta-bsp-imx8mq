DESCRIPTION = "CompuLab Environmet Migration tools"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a9098b71f5540144c2860fb801498f"

PR = "r1"

SRC_URI = " \
	file://cl-migenv \
	file://COPYING \
"

S = "${WORKDIR}"

do_install() {
	mkdir -p ${D}/usr/local/bin/
	cp ${S}/cl-migenv ${D}/usr/local/bin/
}

FILES_${PN} = " \
	/usr/local/bin/* \
"

RDEPENDS_${PN} = "bash dialog"
PACKAGE_ARCH = "all"

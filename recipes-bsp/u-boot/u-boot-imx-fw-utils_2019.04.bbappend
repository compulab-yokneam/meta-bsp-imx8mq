FILESEXTRAPATHS_prepend := "${THISDIR}/compulab/imx8mq:${THISDIR}/${PN}:"

LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC = "git://github.com/nxp-imx/uboot-imx.git;protocol=https"
SRCBRANCH = "imx_v2020.04_5.4.24_2.1.0"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "4979a99482f7e04a3c1f4fb55e3182395ee8f710"
include compulab/imx8mq.inc

SRC_URI_append_cl-som-imx8 += "\
	file://cl_setenv \
"

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake envtools
}

do_install_append () {
	install -d ${D}/sbin
	install -m 0755 ${WORKDIR}/cl_setenv ${D}/sbin/
}

RDEPENDS_${PN} += "bash"

FILES_${PN} += "/sbin/cl_setenv"

RPROVIDES_${PN} += "u-boot-fw-utils"

COMPATIBLE_MACHINE = "cl-som-imx8"

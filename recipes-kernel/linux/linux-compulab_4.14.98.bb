# Copyright (C) 2019 CompuLab LTD.

SUMMARY = "CompuLab Linux Kernel"
DESCRIPTION = "CompuLab Linux Kernel"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-imx-src-${PV}.inc

DEPENDS += "lzop-native bc-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/compulab/imx8mq:"
include compulab/imx8mq.inc

do_configure_append () {
    oe_runmake ${MACHINE}_defconfig
}

KERNEL_MODULE_AUTOLOAD += "goodix"
KERNEL_MODULE_AUTOLOAD += "snd_soc_wm8731"

COMPATIBLE_MACHINE = "cl-som-imx8"

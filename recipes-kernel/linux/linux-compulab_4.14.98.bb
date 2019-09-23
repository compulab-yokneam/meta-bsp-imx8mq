# Copyright (C) 2019 CompuLab LTD.

SUMMARY = "CompuLab Linux Kernel"
DESCRIPTION = "CompuLab Linux Kernel"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-imx-src-${PV}.inc

DEPENDS += "lzop-native bc-native"

include linux.inc

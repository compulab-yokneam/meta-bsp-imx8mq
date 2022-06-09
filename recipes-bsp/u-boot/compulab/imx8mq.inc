SRC_URI_append_cl-som-imx8 = " \
	file://0000-cl-som-imx8-Add-basic-support.patch \
	file://0001-cl-som-imx8-Update-env-tool-and-conf.patch \
	file://0002-eeprom-Update-field-and-layout.patch \
	file://0003-bi_dram-Skip-zero-size-banks.patch \
	file://0004-soc-Don-t-take-the-rom_pointer-into-account.patch \
	file://0005-mem-Test-only-the-first-bank.patch \
	file://0006-compulab-mx8mq-ddr-Add-0x01060008-support.patch \
	file://0007-cl-som-imx8-config-Enable-fastboot.patch \
	file://0008-cl-som-imx8-Enable-PCIE_VPH.patch \
	file://0009-plat-imx8mq-ddr-Add-Kingston-4G-support.patch \
	file://0010-plat-imx8mq-ddr-Add-Alien-1G-support.patch \
	file://0011-cl-som-imx8-net-Enable-phy-Realtek-RTL8211E.patch \
	file://0012-net-enable-random-mac-if-the-som-eeprom-is-empty.patch \
	file://cl-som-imx8_defconfig \
"

# U-Boot CompuLab

## Features
* LPDDR4 memory type recognition by means of mr[5-8].
* Supports all available CompuLab memory configurations.
* Supports the NXP 2-op/3-op revisions.
* Saves the boot environment on the boot media at this location:

| offset | size |
|---|---|
| 0x1000 | 0x4000 |

* Supports these boot devices:

| device | u-boot | linux | 
|---|---|---|
|sd-card<br>SD-iMX8.P13|FSL_SDHC: 1 (SD)|mmcblk1|
|eMMC|FSL_SDHC: 0 (eMMC)<br>user: **mmc partconf 0 0 0 0**<br>boot: **mmc partconf 0 0 1 0**<br>view current state: **mmc partconf 0**<br>get the emmc info: **mmc dev 0; mmc info**<br>|user: mmcblk0<br>boot: mmcblk0boot0|

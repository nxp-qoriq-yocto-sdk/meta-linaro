DESCRIPTION = "Linaro Kernel For Vexpress/KVM"

SRCREV_kernel="2f6335c9bd85b9ed191fa6944abe80e744befce5"
PV = "4.0+git${SRCPV}"
SRC_URI_append = " git://git.linaro.org/git/kernel/linux-linaro-tracking.git;protocol=http;branch=linux-linaro;name=kernel "
require linaro-kernel.inc

KERNEL_DEVICETREE = "vexpress-v2p-ca15-tc1.dtb"
BOOTARGS_COMMON = "root=/dev/mmcblk0p2 console=ttyAMA0 consolelog=9 mem=1024M rw rootwait"
COMPATIBLE_HOST = "arm.*"
KERNEL_IMAGETYPE = "zImage"

do_configure_prepend() {
    . ../ubuntu-ci/configs/vexpress.cfg
    ARCH=arm scripts/kconfig/merge_config.sh -m $linaro_base_config_frags $ubuntu_config_frag $board_config_frags
}

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-set-flag-to-build-in-lp64-mode-for-ilp32-toolchain.patch \
file://0001-Link-using-64-bits.patch \
"

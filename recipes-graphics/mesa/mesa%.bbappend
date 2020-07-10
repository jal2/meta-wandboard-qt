PACKAGECONFIG_append=" etnaviv kmsro "

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# add pending etnaviv patches to fix MSAA
SRC_URI += "\
	file://8b300b5a23e17ba1912ad7d43aa8b826730b4265.patch \
	file://4de2a8637ffa775e68dc64f7a56d22acf571f5f0.patch \
	file://8fb05b5d366fceac8743df554ba229e54267f19e.patch \
	file://3bf4ba5766d8aa6715f68d38d4403ec4266afa41.patch \
	file://ef8a684273e3d5d4d05a1a183b2d4c1b3d695805.patch \
	"
	

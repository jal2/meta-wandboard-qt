PACKAGECONFIG_GL = "gbm gles2 kms"
PACKAGECONFIG_GL += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'eglfs', '', d)} \
"
PACKAGECONFIG += "fontconfig freetype accessibility"

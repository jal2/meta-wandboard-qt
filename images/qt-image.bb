SUMMARY = "A Qt development image"

require images/basic-dev-image.bb

inherit populate_sdk_qt5

IMAGE_INSTALL += " \
    root-upgrader \
    u-boot-scr \
    ${SECURITY_TOOLS} \
"

EXTRA_IMAGE_FEATURES = "debug-tweaks empty-root-password"

MULTIMEDIA += "\
                gstreamer1.0 \
                gstreamer1.0-plugins-base \
                gstreamer1.0-plugins-good \
                gstreamer1.0-plugins-bad \
                gstreamer1.0-plugins-ugly \
                gstreamer1.0-libav \
                gstreamer1.0-vaapi \
                "
WAYLAND = "\
		wayland \
		weston \
	"

QT5 = "\
                qtbase-plugins \
                qtbase-tools \
                qtdeclarative \
                qtdeclarative-tools \
                qtdeclarative-qmlplugins \
                qtmultimedia \
                qtmultimedia-plugins \
                qtmultimedia-qmlplugins \
                qtgraphicaleffects \
                qtquickcontrols \
                qtquickcontrols-qmlplugins \
                qtvirtualkeyboard \
                qtquickcontrols2 \
                qttools \
                qtwayland \
                "
FONTS += "\
                ttf-dejavu-sans \
                ttf-dejavu-sans-mono \
                ttf-dejavu-sans-condensed \
                ttf-dejavu-serif \
                ttf-dejavu-serif-condensed \
                ttf-dejavu-common \
                "

IMAGE_INSTALL += "\
		${QT5} \
                ${MULTIMEDIA} \
                ${FONTS} \
	"

export IMAGE_BASENAME = "qt-image"

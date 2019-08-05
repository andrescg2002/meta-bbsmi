do_install_append () {
    echo "syrus ALL=(ALL) ALL" > ${D}${sysconfdir}/sudoers.d/001_users
}

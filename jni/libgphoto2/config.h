/* config.h.  Generated from config.h.in by configure.  */
/* config.h.in.  Generated from configure.ac by autoheader.  */

/* Whether we have flex and bison for GP2DDB */
/* #undef ENABLED_GP2DDB */

/* Define to 1 if translation of program messages to the user's native
   language is requested. */
// #define ENABLE_NLS 1

/* The gettext domain we're using */
#define GETTEXT_PACKAGE "libgphoto2-2"

/* The C compiler we're using */
#define HAVE_CC "gcc"

/* Define if the GNU dcgettext() function is already present or preinstalled.
   */
#define HAVE_DCGETTEXT 1

/* Define to 1 if you have the <dirent.h> header file, and it defines `DIR'.
   */
#define HAVE_DIRENT_H 1

/* Define to 1 if you have the <dlfcn.h> header file. */
#define HAVE_DLFCN_H 1

/* define if we have LIBGD and its headers */
#define HAVE_GD 1

/* Define to 1 if you have the `getopt' function. */
#define HAVE_GETOPT 1

/* Define to 1 if you have the <getopt.h> header file. */
#define HAVE_GETOPT_H 1

/* Define to 1 if you have the `getopt_long' function. */
#define HAVE_GETOPT_LONG 1

/* Define if the GNU gettext() function is already present or preinstalled. */
#define HAVE_GETTEXT 1

/* Define to 1 if you have the `gmtime_r' function. */
#define HAVE_GMTIME_R 1

/* Define if you have the iconv() function. */
/* #define HAVE_ICONV 1 */

/* Define to 1 if you have the <inttypes.h> header file. */
#define HAVE_INTTYPES_H 1

/* whether we compile with libexif support */
#define HAVE_LIBEXIF 1

/* whether we use a version of libexif with ExifData.ifd[[]] */
#define HAVE_LIBEXIF_IFD 1

/* Define to 1 if you have the `ibs' library (-libs). */
/* #undef HAVE_LIBIBS */

/* define if we found LIBJPEG and its headers */
#define HAVE_LIBJPEG 1

/* Define to 1 if you have the <limits.h> header file. */
#define HAVE_LIMITS_H 1

/* Define to 1 if you have the <locale.h> header file. */
// #define HAVE_LOCALE_H 1

/* Whether libltdl (of libtool fame) is present */
#define HAVE_LTDL 1

/* Define to 1 if you have the <mcheck.h> header file. */
#define HAVE_MCHECK_H 1

/* Define to 1 if you have the <memory.h> header file. */
#define HAVE_MEMORY_H 1

/* Define to 1 if you have the `mkdir' function. */
#define HAVE_MKDIR 1

/* Define to 1 if you have the <ndir.h> header file, and it defines `DIR'. */
/* #undef HAVE_NDIR_H */

/* Define to 1 if you have the `snprintf' function. */
#define HAVE_SNPRINTF 1

/* Define to 1 if you have the `sprintf' function. */
#define HAVE_SPRINTF 1

/* Define to 1 if you have the `statfs' function. */
#define HAVE_STATFS 1

/* Define to 1 if you have the <stdint.h> header file. */
#define HAVE_STDINT_H 1

/* Define to 1 if you have the <stdlib.h> header file. */
#define HAVE_STDLIB_H 1

/* Define to 1 if you have the `strcpy' function. */
#define HAVE_STRCPY 1

/* Define to 1 if you have the `strdup' function. */
#define HAVE_STRDUP 1

/* Define to 1 if you have the <strings.h> header file. */
#define HAVE_STRINGS_H 1

/* Define to 1 if you have the <string.h> header file. */
#define HAVE_STRING_H 1

/* Define to 1 if you have the `strncpy' function. */
#define HAVE_STRNCPY 1

/* Define to 1 if `f_bavail' is member of `struct statfs'. */
#define HAVE_STRUCT_STATFS_F_BAVAIL 1

/* Define to 1 if `f_bfree' is member of `struct statfs'. */
#define HAVE_STRUCT_STATFS_F_BFREE 1

/* Define to 1 if `f_favail' is member of `struct statfs'. */
/* #undef HAVE_STRUCT_STATFS_F_FAVAIL */

/* Define to 1 if `f_blocks' is member of `struct statvfs'. */
/* #undef HAVE_STRUCT_STATVFS_F_BLOCKS */

/* Define to 1 if you have the <sys/dir.h> header file, and it defines `DIR'.
   */
/* #undef HAVE_SYS_DIR_H */

/* Define to 1 if you have the <sys/mount.h> header file. */
#define HAVE_SYS_MOUNT_H 1

/* Define to 1 if you have the <sys/ndir.h> header file, and it defines `DIR'.
   */
/* #undef HAVE_SYS_NDIR_H */

/* Define to 1 if you have the <sys/param.h> header file. */
#define HAVE_SYS_PARAM_H 1

/* Define to 1 if you have the <sys/select.h> header file. */
#define HAVE_SYS_SELECT_H 1

/* Define to 1 if you have the <sys/statfs.h> header file. */
#define HAVE_SYS_STATFS_H 1

/* Define to 1 if you have the <sys/stat.h> header file. */
#define HAVE_SYS_STAT_H 1

/* Define to 1 if you have the <sys/time.h> header file. */
#define HAVE_SYS_TIME_H 1

/* Define to 1 if you have the <sys/types.h> header file. */
#define HAVE_SYS_TYPES_H 1

/* Define to 1 if you have the <sys/user.h> header file. */
#define HAVE_SYS_USER_H 1

/* Define to 1 if you have the <sys/vfs.h> header file. */
#define HAVE_SYS_VFS_H 1

/* whether struct tm has tm_gmtoff field */
#define HAVE_TM_GMTOFF 1

/* Define to 1 if you have the <unistd.h> header file. */
#define HAVE_UNISTD_H 1

/* Define to 1 if you have the `vsnprintf' function. */
#define HAVE_VSNPRINTF 1

/* Define as const if the declaration of iconv() needs const. */
#define ICONV_CONST 

/* gphoto development mailing list */
#define MAIL_GPHOTO_DEVEL "<gphoto-devel@lists.sourceforge.net>"

/* gphoto translation mailing list */
#define MAIL_GPHOTO_TRANSLATION "<gphoto-translation@lists.sourceforge.net>"

/* gphoto user mailing list */
#define MAIL_GPHOTO_USER "<gphoto-user@lists.sourceforge.net>"

/* Define to 1 if your C compiler doesn't accept -c and -o together. */
/* #undef NO_MINUS_C_MINUS_O */

/* Name of package */
#define PACKAGE "libgphoto2"

/* Define to the address where bug reports for this package should be sent. */
#define PACKAGE_BUGREPORT "gphoto-devel@lists.sourceforge.net"

/* Define to the full name of this package. */
#define PACKAGE_NAME "libgphoto2 photo camera library"

/* Define to the full name and version of this package. */
#define PACKAGE_STRING "libgphoto2 photo camera library 2.4.10.1"

/* Define to the one symbol short name of this package. */
#define PACKAGE_TARNAME "libgphoto2"

/* Define to the version of this package. */
#define PACKAGE_VERSION "2.4.10.1"

/* Define to 1 if you have the ANSI C header files. */
#define STDC_HEADERS 1

/* Define to 1 if your <sys/time.h> declares `struct tm'. */
/* #undef TM_IN_SYS_TIME */

/* camera list with support status */
#define URL_DIGICAM_LIST "http://www.teaser.fr/~hfiguiere/linux/digicam.html"

/* gphoto project home page */
#define URL_GPHOTO_HOME "http://www.gphoto.org/"

/* gphoto sourceforge project page */
#define URL_GPHOTO_PROJECT "http://sourceforge.net/projects/gphoto"

/* jphoto home page */
#define URL_JPHOTO_HOME "http://jphoto.sourceforge.net/"

/* information about using USB mass storage */
#define URL_USB_MASSSTORAGE "http://www.linux-usb.org/USB-guide/x498.html"

/* Version number of package */
#define VERSION "2.4.10.1"

/* Define to 1 if your processor stores words with the most significant byte
   first (like Motorola and SPARC, unlike Intel and VAX). */
/* #undef WORDS_BIGENDIAN */

/* Number of bits in a file offset, on hosts where this is settable. */
/* #undef _FILE_OFFSET_BITS */

/* Define for large files, on AIX-style hosts. */
/* #undef _LARGE_FILES */

/* Define to empty if `const' does not conform to ANSI C. */
/* #undef const */

/* Define to `__inline__' or `__inline' if that's what the C compiler
   calls it, or to nothing if 'inline' is not supported under any name.  */
#ifndef __cplusplus
/* #undef inline */
#endif

/* Define to `unsigned int' if <sys/types.h> does not define. */
/* #undef size_t */

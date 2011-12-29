/* library.c uses langinfo functions without checking for their presence */

#define CODESET "UTF-8"
#define nl_langinfo(x) (0)


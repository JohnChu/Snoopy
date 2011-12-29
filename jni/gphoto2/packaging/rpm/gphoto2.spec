Summary: Command line interface to libgphoto2
Name: gphoto2
Version: 2.4.10
Release: 1
License: LGPL
Group: Applications/Multimedia
BuildRoot: %{_tmppath}/%{name}-%{version}-root
Source: http://www.gphoto.org/dist/gphoto2-2.4.10.tar.gz
Url: http://www.gphoto.org/
ExcludeArch: s390 s390x
Provides: gphoto2
PreReq: libgphoto2-devel

%description
gphoto2 is a command line client to for the libgphoto2. It allows to
use gPhoto software from a terminal or from a script shell to perform
any camera operation that can be done. This is the main user interface.

%prep
rm -rf "${RPM_BUILD_DIR}/%{name}-%{version}"

%setup -q -n %{name}-%{version}

%build
%configure
make

%install
rm -rf "${RPM_BUILD_ROOT}"
make DESTDIR=%{?buildroot:%{buildroot}} install

%files
%defattr(-,root,root)
%{_bindir}/gphoto2   
%{_mandir}/man1/*   
%{_datadir}/locale/*

package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.ReferenceHolder;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import io.appmetrica.analytics.locationapi.internal.LocationClient;
/* loaded from: classes4.dex */
public final class Ia {
    public static volatile Ia F;
    public volatile C0307ha C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f489a;
    public volatile C0736yg b;
    public volatile Z6 c;
    public volatile C0223e3 e;
    public volatile C0764zj f;
    public volatile T g;
    public volatile C0274g2 h;
    public volatile PlatformIdentifiers i;
    public volatile Hf j;
    public volatile V3 k;
    public volatile C0461nf l;
    public volatile xo m;
    public volatile C0564rj n;
    public volatile C0129ac o;
    public Al p;
    public volatile C0740yk r;
    public volatile InterfaceC0258fc w;
    public volatile C0419ln x;
    public volatile C0616tl y;
    public volatile Kd z;
    public final Ha q = new Ha();
    public final C0459nd s = new C0459nd();
    public final C0509pd t = new C0509pd();
    public final C0319hm u = new C0319hm();
    public final C0441mk v = new C0441mk();
    public final C0209de A = new C0209de();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0615tk D = new C0615tk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0565rk d = new C0565rk();

    public Ia(Context context) {
        this.f489a = context;
    }

    public static void a(Context context) {
        if (F == null) {
            synchronized (Ia.class) {
                if (F == null) {
                    F = new Ia(context.getApplicationContext());
                }
            }
        }
    }

    public static Ia j() {
        return F;
    }

    public final C0419ln A() {
        C0419ln c0419ln;
        C0419ln c0419ln2 = this.x;
        if (c0419ln2 == null) {
            synchronized (this) {
                c0419ln = this.x;
                if (c0419ln == null) {
                    c0419ln = new C0419ln(this.f489a);
                    this.x = c0419ln;
                }
            }
            return c0419ln;
        }
        return c0419ln2;
    }

    public final synchronized xo B() {
        if (this.m == null) {
            this.m = new xo(this.f489a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Rm a2 = Qm.a(C0560rf.class);
                    Context context = this.f489a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0560rf c0560rf = (C0560rf) a3.read();
                    this.j = new Hf(this.f489a, a3, new C0735yf(), new C0511pf(c0560rf), new Gf(), new C0710xf(this.f489a), new Cf(j().x()), new C0585sf(), c0560rf, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final T b() {
        T t;
        T t2 = this.g;
        if (t2 == null) {
            synchronized (this) {
                t = this.g;
                if (t == null) {
                    t = new T(this.f489a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0274g2 c() {
        C0274g2 c0274g2;
        C0274g2 c0274g22 = this.h;
        if (c0274g22 == null) {
            synchronized (this) {
                c0274g2 = this.h;
                if (c0274g2 == null) {
                    c0274g2 = new C0274g2(this.f489a, AbstractC0299h2.a());
                    this.h = c0274g2;
                }
            }
            return c0274g2;
        }
        return c0274g22;
    }

    public final C0423m2 d() {
        return k().b;
    }

    public final V3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Rm a2 = Qm.a(O3.class);
                    Context context = this.f489a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new V3(this.f489a, a3, new W3(), new J3(), new Z3(), new C0291gj(this.f489a), new X3(x()), new K3(), (O3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f489a;
    }

    public final Z6 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new Z6(new Y6(x()));
                }
            }
        }
        return this.c;
    }

    public final C0307ha h() {
        C0307ha c0307ha;
        C0307ha c0307ha2 = this.C;
        if (c0307ha2 == null) {
            synchronized (this) {
                c0307ha = this.C;
                if (c0307ha == null) {
                    c0307ha = new C0307ha(this.f489a);
                    this.C = c0307ha;
                }
            }
            return c0307ha;
        }
        return c0307ha2;
    }

    public final PermissionExtractor i() {
        C0616tl c0616tl = this.y;
        if (c0616tl != null) {
            return c0616tl;
        }
        synchronized (this) {
            C0616tl c0616tl2 = this.y;
            if (c0616tl2 != null) {
                return c0616tl2;
            }
            C0616tl c0616tl3 = new C0616tl(o().c.getAskForPermissionStrategy());
            this.y = c0616tl3;
            return c0616tl3;
        }
    }

    public final C0129ac k() {
        C0129ac c0129ac;
        C0129ac c0129ac2 = this.o;
        if (c0129ac2 == null) {
            synchronized (this) {
                c0129ac = this.o;
                if (c0129ac == null) {
                    c0129ac = new C0129ac(new C0146b3(this.f489a, this.d.a()), new C0423m2());
                    this.o = c0129ac;
                }
            }
            return c0129ac;
        }
        return c0129ac2;
    }

    public final InterfaceC0258fc l() {
        InterfaceC0258fc interfaceC0258fc;
        InterfaceC0258fc interfaceC0258fc2 = this.w;
        if (interfaceC0258fc2 == null) {
            synchronized (this) {
                interfaceC0258fc = this.w;
                if (interfaceC0258fc == null) {
                    Context context = this.f489a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0258fc = new C0309hc();
                    } else {
                        interfaceC0258fc = new C0284gc(context, new C0458nc(), locationClient);
                    }
                    this.w = interfaceC0258fc;
                }
            }
            return interfaceC0258fc;
        }
        return interfaceC0258fc2;
    }

    public final InterfaceC0258fc m() {
        return l();
    }

    public final C0509pd n() {
        return this.t;
    }

    public final C0740yk o() {
        C0740yk c0740yk;
        C0740yk c0740yk2 = this.r;
        if (c0740yk2 == null) {
            synchronized (this) {
                c0740yk = this.r;
                if (c0740yk == null) {
                    c0740yk = new C0740yk();
                    this.r = c0740yk;
                }
            }
            return c0740yk;
        }
        return c0740yk2;
    }

    public final Kd p() {
        Kd kd;
        Kd kd2 = this.z;
        if (kd2 == null) {
            synchronized (this) {
                kd = this.z;
                if (kd == null) {
                    kd = new Kd(this.f489a, new ko());
                    this.z = kd;
                }
            }
            return kd;
        }
        return kd2;
    }

    public final C0209de q() {
        return this.A;
    }

    public final PlatformIdentifiers r() {
        PlatformIdentifiers platformIdentifiers;
        PlatformIdentifiers platformIdentifiers2 = this.i;
        if (platformIdentifiers2 == null) {
            synchronized (this) {
                platformIdentifiers = this.i;
                if (platformIdentifiers == null) {
                    platformIdentifiers = new PlatformIdentifiers(b(), c());
                    this.i = platformIdentifiers;
                }
            }
            return platformIdentifiers;
        }
        return platformIdentifiers2;
    }

    public final Hf s() {
        C();
        return this.j;
    }

    public final C0736yg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0736yg(this.f489a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final C0564rj u() {
        C0564rj c0564rj;
        C0564rj c0564rj2 = this.n;
        if (c0564rj2 == null) {
            synchronized (this) {
                c0564rj = this.n;
                if (c0564rj == null) {
                    c0564rj = new C0564rj(this.f489a);
                    this.n = c0564rj;
                }
            }
            return c0564rj;
        }
        return c0564rj2;
    }

    public final synchronized C0764zj v() {
        return this.f;
    }

    public final C0565rk w() {
        return this.d;
    }

    public final C0461nf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0461nf(C0627u7.a(this.f489a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 y() {
        if (this.p == null) {
            Al al = new Al(this.f489a);
            this.p = al;
            this.u.a(al);
        }
        return this.p;
    }

    public final C0319hm z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

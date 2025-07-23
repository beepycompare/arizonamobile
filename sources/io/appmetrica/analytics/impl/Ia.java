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
    public volatile C0306ha C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f489a;
    public volatile C0735yg b;
    public volatile Z6 c;
    public volatile C0222e3 e;
    public volatile C0763zj f;
    public volatile T g;
    public volatile C0273g2 h;
    public volatile PlatformIdentifiers i;
    public volatile Hf j;
    public volatile V3 k;
    public volatile C0460nf l;
    public volatile xo m;
    public volatile C0563rj n;
    public volatile C0128ac o;
    public Al p;
    public volatile C0739yk r;
    public volatile InterfaceC0257fc w;
    public volatile C0418ln x;
    public volatile C0615tl y;
    public volatile Kd z;
    public final Ha q = new Ha();
    public final C0458nd s = new C0458nd();
    public final C0508pd t = new C0508pd();
    public final C0318hm u = new C0318hm();
    public final C0440mk v = new C0440mk();
    public final C0208de A = new C0208de();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0614tk D = new C0614tk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0564rk d = new C0564rk();

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

    public final C0418ln A() {
        C0418ln c0418ln;
        C0418ln c0418ln2 = this.x;
        if (c0418ln2 == null) {
            synchronized (this) {
                c0418ln = this.x;
                if (c0418ln == null) {
                    c0418ln = new C0418ln(this.f489a);
                    this.x = c0418ln;
                }
            }
            return c0418ln;
        }
        return c0418ln2;
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
                    Rm a2 = Qm.a(C0559rf.class);
                    Context context = this.f489a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0559rf c0559rf = (C0559rf) a3.read();
                    this.j = new Hf(this.f489a, a3, new C0734yf(), new C0510pf(c0559rf), new Gf(), new C0709xf(this.f489a), new Cf(j().x()), new C0584sf(), c0559rf, "[PreloadInfoStorage]");
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

    public final C0273g2 c() {
        C0273g2 c0273g2;
        C0273g2 c0273g22 = this.h;
        if (c0273g22 == null) {
            synchronized (this) {
                c0273g2 = this.h;
                if (c0273g2 == null) {
                    c0273g2 = new C0273g2(this.f489a, AbstractC0298h2.a());
                    this.h = c0273g2;
                }
            }
            return c0273g2;
        }
        return c0273g22;
    }

    public final C0422m2 d() {
        return k().b;
    }

    public final V3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Rm a2 = Qm.a(O3.class);
                    Context context = this.f489a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new V3(this.f489a, a3, new W3(), new J3(), new Z3(), new C0290gj(this.f489a), new X3(x()), new K3(), (O3) a3.read(), "[ClidsInfoStorage]");
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

    public final C0306ha h() {
        C0306ha c0306ha;
        C0306ha c0306ha2 = this.C;
        if (c0306ha2 == null) {
            synchronized (this) {
                c0306ha = this.C;
                if (c0306ha == null) {
                    c0306ha = new C0306ha(this.f489a);
                    this.C = c0306ha;
                }
            }
            return c0306ha;
        }
        return c0306ha2;
    }

    public final PermissionExtractor i() {
        C0615tl c0615tl = this.y;
        if (c0615tl != null) {
            return c0615tl;
        }
        synchronized (this) {
            C0615tl c0615tl2 = this.y;
            if (c0615tl2 != null) {
                return c0615tl2;
            }
            C0615tl c0615tl3 = new C0615tl(o().c.getAskForPermissionStrategy());
            this.y = c0615tl3;
            return c0615tl3;
        }
    }

    public final C0128ac k() {
        C0128ac c0128ac;
        C0128ac c0128ac2 = this.o;
        if (c0128ac2 == null) {
            synchronized (this) {
                c0128ac = this.o;
                if (c0128ac == null) {
                    c0128ac = new C0128ac(new C0145b3(this.f489a, this.d.a()), new C0422m2());
                    this.o = c0128ac;
                }
            }
            return c0128ac;
        }
        return c0128ac2;
    }

    public final InterfaceC0257fc l() {
        InterfaceC0257fc interfaceC0257fc;
        InterfaceC0257fc interfaceC0257fc2 = this.w;
        if (interfaceC0257fc2 == null) {
            synchronized (this) {
                interfaceC0257fc = this.w;
                if (interfaceC0257fc == null) {
                    Context context = this.f489a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0257fc = new C0308hc();
                    } else {
                        interfaceC0257fc = new C0283gc(context, new C0457nc(), locationClient);
                    }
                    this.w = interfaceC0257fc;
                }
            }
            return interfaceC0257fc;
        }
        return interfaceC0257fc2;
    }

    public final InterfaceC0257fc m() {
        return l();
    }

    public final C0508pd n() {
        return this.t;
    }

    public final C0739yk o() {
        C0739yk c0739yk;
        C0739yk c0739yk2 = this.r;
        if (c0739yk2 == null) {
            synchronized (this) {
                c0739yk = this.r;
                if (c0739yk == null) {
                    c0739yk = new C0739yk();
                    this.r = c0739yk;
                }
            }
            return c0739yk;
        }
        return c0739yk2;
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

    public final C0208de q() {
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

    public final C0735yg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0735yg(this.f489a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final C0563rj u() {
        C0563rj c0563rj;
        C0563rj c0563rj2 = this.n;
        if (c0563rj2 == null) {
            synchronized (this) {
                c0563rj = this.n;
                if (c0563rj == null) {
                    c0563rj = new C0563rj(this.f489a);
                    this.n = c0563rj;
                }
            }
            return c0563rj;
        }
        return c0563rj2;
    }

    public final synchronized C0763zj v() {
        return this.f;
    }

    public final C0564rk w() {
        return this.d;
    }

    public final C0460nf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0460nf(C0626u7.a(this.f489a).c());
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

    public final C0318hm z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

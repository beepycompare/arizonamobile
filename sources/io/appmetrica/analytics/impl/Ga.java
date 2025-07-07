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
public final class Ga {
    public static volatile Ga F;
    public volatile C0262fa C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f443a;
    public volatile C0691wg b;
    public volatile W6 c;
    public volatile C0230e3 e;
    public volatile C0694wj f;
    public volatile T g;
    public volatile C0279g2 h;
    public volatile PlatformIdentifiers i;
    public volatile Ff j;
    public volatile V3 k;
    public volatile C0416lf l;
    public volatile uo m;
    public volatile C0495oj n;
    public volatile Yb o;
    public C0721xl p;
    public volatile C0670vk r;
    public volatile InterfaceC0214dc w;
    public volatile C0349in x;
    public volatile C0547ql y;
    public volatile Id z;
    public final Fa q = new Fa();
    public final C0414ld s = new C0414ld();
    public final C0464nd t = new C0464nd();
    public final C0249em u = new C0249em();
    public final C0371jk v = new C0371jk();
    public final C0164be A = new C0164be();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0546qk D = new C0546qk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0496ok d = new C0496ok();

    public Ga(Context context) {
        this.f443a = context;
    }

    public static void a(Context context) {
        if (F == null) {
            synchronized (Ga.class) {
                if (F == null) {
                    F = new Ga(context.getApplicationContext());
                }
            }
        }
    }

    public static Ga j() {
        return F;
    }

    public final C0349in A() {
        C0349in c0349in;
        C0349in c0349in2 = this.x;
        if (c0349in2 == null) {
            synchronized (this) {
                c0349in = this.x;
                if (c0349in == null) {
                    c0349in = new C0349in(this.f443a);
                    this.x = c0349in;
                }
            }
            return c0349in;
        }
        return c0349in2;
    }

    public final synchronized uo B() {
        if (this.m == null) {
            this.m = new uo(this.f443a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Om a2 = Nm.a(C0516pf.class);
                    Context context = this.f443a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0516pf c0516pf = (C0516pf) a3.read();
                    this.j = new Ff(this.f443a, a3, new C0690wf(), new C0466nf(c0516pf), new Ef(), new C0665vf(this.f443a), new Af(j().x()), new C0541qf(), c0516pf, "[PreloadInfoStorage]");
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
                    t = new T(this.f443a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0279g2 c() {
        C0279g2 c0279g2;
        C0279g2 c0279g22 = this.h;
        if (c0279g22 == null) {
            synchronized (this) {
                c0279g2 = this.h;
                if (c0279g2 == null) {
                    c0279g2 = new C0279g2(this.f443a, AbstractC0304h2.a());
                    this.h = c0279g2;
                }
            }
            return c0279g2;
        }
        return c0279g22;
    }

    public final C0428m2 d() {
        return k().b;
    }

    public final V3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Om a2 = Nm.a(O3.class);
                    Context context = this.f443a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new V3(this.f443a, a3, new W3(), new J3(), new Z3(), new C0221dj(this.f443a), new X3(x()), new K3(), (O3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f443a;
    }

    public final W6 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new W6(new V6(x()));
                }
            }
        }
        return this.c;
    }

    public final C0262fa h() {
        C0262fa c0262fa;
        C0262fa c0262fa2 = this.C;
        if (c0262fa2 == null) {
            synchronized (this) {
                c0262fa = this.C;
                if (c0262fa == null) {
                    c0262fa = new C0262fa(this.f443a);
                    this.C = c0262fa;
                }
            }
            return c0262fa;
        }
        return c0262fa2;
    }

    public final PermissionExtractor i() {
        C0547ql c0547ql = this.y;
        if (c0547ql != null) {
            return c0547ql;
        }
        synchronized (this) {
            C0547ql c0547ql2 = this.y;
            if (c0547ql2 != null) {
                return c0547ql2;
            }
            C0547ql c0547ql3 = new C0547ql(o().c.getAskForPermissionStrategy());
            this.y = c0547ql3;
            return c0547ql3;
        }
    }

    public final Yb k() {
        Yb yb;
        Yb yb2 = this.o;
        if (yb2 == null) {
            synchronized (this) {
                yb = this.o;
                if (yb == null) {
                    yb = new Yb(new C0153b3(this.f443a, this.d.a()), new C0428m2());
                    this.o = yb;
                }
            }
            return yb;
        }
        return yb2;
    }

    public final InterfaceC0214dc l() {
        InterfaceC0214dc interfaceC0214dc;
        InterfaceC0214dc interfaceC0214dc2 = this.w;
        if (interfaceC0214dc2 == null) {
            synchronized (this) {
                interfaceC0214dc = this.w;
                if (interfaceC0214dc == null) {
                    Context context = this.f443a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0214dc = new C0264fc();
                    } else {
                        interfaceC0214dc = new C0239ec(context, new C0413lc(), locationClient);
                    }
                    this.w = interfaceC0214dc;
                }
            }
            return interfaceC0214dc;
        }
        return interfaceC0214dc2;
    }

    public final InterfaceC0214dc m() {
        return l();
    }

    public final C0464nd n() {
        return this.t;
    }

    public final C0670vk o() {
        C0670vk c0670vk;
        C0670vk c0670vk2 = this.r;
        if (c0670vk2 == null) {
            synchronized (this) {
                c0670vk = this.r;
                if (c0670vk == null) {
                    c0670vk = new C0670vk();
                    this.r = c0670vk;
                }
            }
            return c0670vk;
        }
        return c0670vk2;
    }

    public final Id p() {
        Id id;
        Id id2 = this.z;
        if (id2 == null) {
            synchronized (this) {
                id = this.z;
                if (id == null) {
                    id = new Id(this.f443a, new ho());
                    this.z = id;
                }
            }
            return id;
        }
        return id2;
    }

    public final C0164be q() {
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

    public final Ff s() {
        C();
        return this.j;
    }

    public final C0691wg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0691wg(this.f443a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final C0495oj u() {
        C0495oj c0495oj;
        C0495oj c0495oj2 = this.n;
        if (c0495oj2 == null) {
            synchronized (this) {
                c0495oj = this.n;
                if (c0495oj == null) {
                    c0495oj = new C0495oj(this.f443a);
                    this.n = c0495oj;
                }
            }
            return c0495oj;
        }
        return c0495oj2;
    }

    public final synchronized C0694wj v() {
        return this.f;
    }

    public final C0496ok w() {
        return this.d;
    }

    public final C0416lf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0416lf(C0557r7.a(this.f443a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 y() {
        if (this.p == null) {
            C0721xl c0721xl = new C0721xl(this.f443a);
            this.p = c0721xl;
            this.u.a(c0721xl);
        }
        return this.p;
    }

    public final C0249em z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

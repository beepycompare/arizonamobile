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
    public volatile C0254fa C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f444a;
    public volatile C0683wg b;
    public volatile W6 c;
    public volatile C0222e3 e;
    public volatile C0686wj f;
    public volatile T g;
    public volatile C0271g2 h;
    public volatile PlatformIdentifiers i;
    public volatile Ff j;
    public volatile V3 k;
    public volatile C0408lf l;
    public volatile uo m;
    public volatile C0487oj n;
    public volatile Yb o;
    public C0713xl p;
    public volatile C0662vk r;
    public volatile InterfaceC0206dc w;
    public volatile C0341in x;
    public volatile C0539ql y;
    public volatile Id z;
    public final Fa q = new Fa();
    public final C0406ld s = new C0406ld();
    public final C0456nd t = new C0456nd();
    public final C0241em u = new C0241em();
    public final C0363jk v = new C0363jk();
    public final C0156be A = new C0156be();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0538qk D = new C0538qk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0488ok d = new C0488ok();

    public Ga(Context context) {
        this.f444a = context;
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

    public final C0341in A() {
        C0341in c0341in;
        C0341in c0341in2 = this.x;
        if (c0341in2 == null) {
            synchronized (this) {
                c0341in = this.x;
                if (c0341in == null) {
                    c0341in = new C0341in(this.f444a);
                    this.x = c0341in;
                }
            }
            return c0341in;
        }
        return c0341in2;
    }

    public final synchronized uo B() {
        if (this.m == null) {
            this.m = new uo(this.f444a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Om a2 = Nm.a(C0508pf.class);
                    Context context = this.f444a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0508pf c0508pf = (C0508pf) a3.read();
                    this.j = new Ff(this.f444a, a3, new C0682wf(), new C0458nf(c0508pf), new Ef(), new C0657vf(this.f444a), new Af(j().x()), new C0533qf(), c0508pf, "[PreloadInfoStorage]");
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
                    t = new T(this.f444a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0271g2 c() {
        C0271g2 c0271g2;
        C0271g2 c0271g22 = this.h;
        if (c0271g22 == null) {
            synchronized (this) {
                c0271g2 = this.h;
                if (c0271g2 == null) {
                    c0271g2 = new C0271g2(this.f444a, AbstractC0296h2.a());
                    this.h = c0271g2;
                }
            }
            return c0271g2;
        }
        return c0271g22;
    }

    public final C0420m2 d() {
        return k().b;
    }

    public final V3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Om a2 = Nm.a(O3.class);
                    Context context = this.f444a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new V3(this.f444a, a3, new W3(), new J3(), new Z3(), new C0213dj(this.f444a), new X3(x()), new K3(), (O3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f444a;
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

    public final C0254fa h() {
        C0254fa c0254fa;
        C0254fa c0254fa2 = this.C;
        if (c0254fa2 == null) {
            synchronized (this) {
                c0254fa = this.C;
                if (c0254fa == null) {
                    c0254fa = new C0254fa(this.f444a);
                    this.C = c0254fa;
                }
            }
            return c0254fa;
        }
        return c0254fa2;
    }

    public final PermissionExtractor i() {
        C0539ql c0539ql = this.y;
        if (c0539ql != null) {
            return c0539ql;
        }
        synchronized (this) {
            C0539ql c0539ql2 = this.y;
            if (c0539ql2 != null) {
                return c0539ql2;
            }
            C0539ql c0539ql3 = new C0539ql(o().c.getAskForPermissionStrategy());
            this.y = c0539ql3;
            return c0539ql3;
        }
    }

    public final Yb k() {
        Yb yb;
        Yb yb2 = this.o;
        if (yb2 == null) {
            synchronized (this) {
                yb = this.o;
                if (yb == null) {
                    yb = new Yb(new C0145b3(this.f444a, this.d.a()), new C0420m2());
                    this.o = yb;
                }
            }
            return yb;
        }
        return yb2;
    }

    public final InterfaceC0206dc l() {
        InterfaceC0206dc interfaceC0206dc;
        InterfaceC0206dc interfaceC0206dc2 = this.w;
        if (interfaceC0206dc2 == null) {
            synchronized (this) {
                interfaceC0206dc = this.w;
                if (interfaceC0206dc == null) {
                    Context context = this.f444a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0206dc = new C0256fc();
                    } else {
                        interfaceC0206dc = new C0231ec(context, new C0405lc(), locationClient);
                    }
                    this.w = interfaceC0206dc;
                }
            }
            return interfaceC0206dc;
        }
        return interfaceC0206dc2;
    }

    public final InterfaceC0206dc m() {
        return l();
    }

    public final C0456nd n() {
        return this.t;
    }

    public final C0662vk o() {
        C0662vk c0662vk;
        C0662vk c0662vk2 = this.r;
        if (c0662vk2 == null) {
            synchronized (this) {
                c0662vk = this.r;
                if (c0662vk == null) {
                    c0662vk = new C0662vk();
                    this.r = c0662vk;
                }
            }
            return c0662vk;
        }
        return c0662vk2;
    }

    public final Id p() {
        Id id;
        Id id2 = this.z;
        if (id2 == null) {
            synchronized (this) {
                id = this.z;
                if (id == null) {
                    id = new Id(this.f444a, new ho());
                    this.z = id;
                }
            }
            return id;
        }
        return id2;
    }

    public final C0156be q() {
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

    public final C0683wg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0683wg(this.f444a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final C0487oj u() {
        C0487oj c0487oj;
        C0487oj c0487oj2 = this.n;
        if (c0487oj2 == null) {
            synchronized (this) {
                c0487oj = this.n;
                if (c0487oj == null) {
                    c0487oj = new C0487oj(this.f444a);
                    this.n = c0487oj;
                }
            }
            return c0487oj;
        }
        return c0487oj2;
    }

    public final synchronized C0686wj v() {
        return this.f;
    }

    public final C0488ok w() {
        return this.d;
    }

    public final C0408lf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0408lf(C0549r7.a(this.f444a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 y() {
        if (this.p == null) {
            C0713xl c0713xl = new C0713xl(this.f444a);
            this.p = c0713xl;
            this.u.a(c0713xl);
        }
        return this.p;
    }

    public final C0241em z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

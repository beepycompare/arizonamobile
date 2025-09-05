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
public final class Na {
    public static volatile Na F;
    public volatile C0429ma C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f589a;
    public volatile Hg b;
    public volatile C0194d7 c;
    public volatile C0293h3 e;
    public volatile Ij f;
    public volatile T g;
    public volatile C0318i2 h;
    public volatile PlatformIdentifiers i;
    public volatile Nf j;
    public volatile Y3 k;
    public volatile C0611tf l;
    public volatile Go m;
    public volatile Aj n;
    public volatile C0250fc o;
    public Jl p;
    public volatile Hk r;
    public volatile InterfaceC0379kc w;
    public volatile C0644un x;
    public volatile Cl y;
    public volatile Qd z;
    public final Ma q = new Ma();
    public final C0584sd s = new C0584sd();
    public final C0634ud t = new C0634ud();
    public final C0544qm u = new C0544qm();
    public final C0666vk v = new C0666vk();
    public final C0355je A = new C0355je();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Ck D = new Ck();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Ak d = new Ak();

    public Na(Context context) {
        this.f589a = context;
    }

    public static void a(Context context) {
        if (F == null) {
            synchronized (Na.class) {
                if (F == null) {
                    F = new Na(context.getApplicationContext());
                }
            }
        }
    }

    public static Na j() {
        return F;
    }

    public final C0644un A() {
        C0644un c0644un;
        C0644un c0644un2 = this.x;
        if (c0644un2 == null) {
            synchronized (this) {
                c0644un = this.x;
                if (c0644un == null) {
                    c0644un = new C0644un(this.f589a);
                    this.x = c0644un;
                }
            }
            return c0644un;
        }
        return c0644un2;
    }

    public final synchronized Go B() {
        if (this.m == null) {
            this.m = new Go(this.f589a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    AbstractC0132an a2 = Zm.a(C0711xf.class);
                    Context context = this.f589a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0711xf c0711xf = (C0711xf) a3.read();
                    this.j = new Nf(this.f589a, a3, new Ef(), new C0661vf(c0711xf), new Mf(), new Df(this.f589a), new If(j().x()), new C0736yf(), c0711xf, "[PreloadInfoStorage]");
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
                    t = new T(this.f589a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0318i2 c() {
        C0318i2 c0318i2;
        C0318i2 c0318i22 = this.h;
        if (c0318i22 == null) {
            synchronized (this) {
                c0318i2 = this.h;
                if (c0318i2 == null) {
                    c0318i2 = new C0318i2(this.f589a, AbstractC0343j2.a());
                    this.h = c0318i2;
                }
            }
            return c0318i2;
        }
        return c0318i22;
    }

    public final C0473o2 d() {
        return k().b;
    }

    public final Y3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    AbstractC0132an a2 = Zm.a(R3.class);
                    Context context = this.f589a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new Y3(this.f589a, a3, new Z3(), new M3(), new C0165c4(), new C0516pj(this.f589a), new C0113a4(x()), new N3(), (R3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f589a;
    }

    public final C0194d7 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new C0194d7(new C0168c7(x()));
                }
            }
        }
        return this.c;
    }

    public final C0429ma h() {
        C0429ma c0429ma;
        C0429ma c0429ma2 = this.C;
        if (c0429ma2 == null) {
            synchronized (this) {
                c0429ma = this.C;
                if (c0429ma == null) {
                    c0429ma = new C0429ma(this.f589a);
                    this.C = c0429ma;
                }
            }
            return c0429ma;
        }
        return c0429ma2;
    }

    public final PermissionExtractor i() {
        Cl cl = this.y;
        if (cl != null) {
            return cl;
        }
        synchronized (this) {
            Cl cl2 = this.y;
            if (cl2 != null) {
                return cl2;
            }
            Cl cl3 = new Cl(o().c.getAskForPermissionStrategy());
            this.y = cl3;
            return cl3;
        }
    }

    public final C0250fc k() {
        C0250fc c0250fc;
        C0250fc c0250fc2 = this.o;
        if (c0250fc2 == null) {
            synchronized (this) {
                c0250fc = this.o;
                if (c0250fc == null) {
                    c0250fc = new C0250fc(new C0215e3(this.f589a, this.d.a()), new C0473o2());
                    this.o = c0250fc;
                }
            }
            return c0250fc;
        }
        return c0250fc2;
    }

    public final InterfaceC0379kc l() {
        InterfaceC0379kc interfaceC0379kc;
        InterfaceC0379kc interfaceC0379kc2 = this.w;
        if (interfaceC0379kc2 == null) {
            synchronized (this) {
                interfaceC0379kc = this.w;
                if (interfaceC0379kc == null) {
                    Context context = this.f589a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0379kc = new C0431mc();
                    } else {
                        interfaceC0379kc = new C0405lc(context, new C0583sc(), locationClient);
                    }
                    this.w = interfaceC0379kc;
                }
            }
            return interfaceC0379kc;
        }
        return interfaceC0379kc2;
    }

    public final InterfaceC0379kc m() {
        return l();
    }

    public final C0634ud n() {
        return this.t;
    }

    public final Hk o() {
        Hk hk;
        Hk hk2 = this.r;
        if (hk2 == null) {
            synchronized (this) {
                hk = this.r;
                if (hk == null) {
                    hk = new Hk();
                    this.r = hk;
                }
            }
            return hk;
        }
        return hk2;
    }

    public final Qd p() {
        Qd qd;
        Qd qd2 = this.z;
        if (qd2 == null) {
            synchronized (this) {
                qd = this.z;
                if (qd == null) {
                    qd = new Qd(this.f589a, new to());
                    this.z = qd;
                }
            }
            return qd;
        }
        return qd2;
    }

    public final C0355je q() {
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

    public final Nf s() {
        C();
        return this.j;
    }

    public final Hg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new Hg(this.f589a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final Aj u() {
        Aj aj;
        Aj aj2 = this.n;
        if (aj2 == null) {
            synchronized (this) {
                aj = this.n;
                if (aj == null) {
                    aj = new Aj(this.f589a);
                    this.n = aj;
                }
            }
            return aj;
        }
        return aj2;
    }

    public final synchronized Ij v() {
        return this.f;
    }

    public final Ak w() {
        return this.d;
    }

    public final C0611tf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0611tf(C0728y7.a(this.f589a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized InterfaceC0112a3 y() {
        if (this.p == null) {
            Jl jl = new Jl(this.f589a);
            this.p = jl;
            this.u.a(jl);
        }
        return this.p;
    }

    public final C0544qm z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

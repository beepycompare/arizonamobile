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
    public volatile C0430ma C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f594a;
    public volatile Hg b;
    public volatile C0195d7 c;
    public volatile C0294h3 e;
    public volatile Ij f;
    public volatile T g;
    public volatile C0319i2 h;
    public volatile PlatformIdentifiers i;
    public volatile Nf j;
    public volatile Y3 k;
    public volatile C0612tf l;
    public volatile Go m;
    public volatile Aj n;
    public volatile C0251fc o;
    public Jl p;
    public volatile Hk r;
    public volatile InterfaceC0380kc w;
    public volatile C0645un x;
    public volatile Cl y;
    public volatile Qd z;
    public final Ma q = new Ma();
    public final C0585sd s = new C0585sd();
    public final C0635ud t = new C0635ud();
    public final C0545qm u = new C0545qm();
    public final C0667vk v = new C0667vk();
    public final C0356je A = new C0356je();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Ck D = new Ck();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Ak d = new Ak();

    public Na(Context context) {
        this.f594a = context;
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

    public final C0645un A() {
        C0645un c0645un;
        C0645un c0645un2 = this.x;
        if (c0645un2 == null) {
            synchronized (this) {
                c0645un = this.x;
                if (c0645un == null) {
                    c0645un = new C0645un(this.f594a);
                    this.x = c0645un;
                }
            }
            return c0645un;
        }
        return c0645un2;
    }

    public final synchronized Go B() {
        if (this.m == null) {
            this.m = new Go(this.f594a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    AbstractC0133an a2 = Zm.a(C0712xf.class);
                    Context context = this.f594a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0712xf c0712xf = (C0712xf) a3.read();
                    this.j = new Nf(this.f594a, a3, new Ef(), new C0662vf(c0712xf), new Mf(), new Df(this.f594a), new If(j().x()), new C0737yf(), c0712xf, "[PreloadInfoStorage]");
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
                    t = new T(this.f594a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0319i2 c() {
        C0319i2 c0319i2;
        C0319i2 c0319i22 = this.h;
        if (c0319i22 == null) {
            synchronized (this) {
                c0319i2 = this.h;
                if (c0319i2 == null) {
                    c0319i2 = new C0319i2(this.f594a, AbstractC0344j2.a());
                    this.h = c0319i2;
                }
            }
            return c0319i2;
        }
        return c0319i22;
    }

    public final C0474o2 d() {
        return k().b;
    }

    public final Y3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    AbstractC0133an a2 = Zm.a(R3.class);
                    Context context = this.f594a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new Y3(this.f594a, a3, new Z3(), new M3(), new C0166c4(), new C0517pj(this.f594a), new C0114a4(x()), new N3(), (R3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f594a;
    }

    public final C0195d7 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new C0195d7(new C0169c7(x()));
                }
            }
        }
        return this.c;
    }

    public final C0430ma h() {
        C0430ma c0430ma;
        C0430ma c0430ma2 = this.C;
        if (c0430ma2 == null) {
            synchronized (this) {
                c0430ma = this.C;
                if (c0430ma == null) {
                    c0430ma = new C0430ma(this.f594a);
                    this.C = c0430ma;
                }
            }
            return c0430ma;
        }
        return c0430ma2;
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

    public final C0251fc k() {
        C0251fc c0251fc;
        C0251fc c0251fc2 = this.o;
        if (c0251fc2 == null) {
            synchronized (this) {
                c0251fc = this.o;
                if (c0251fc == null) {
                    c0251fc = new C0251fc(new C0216e3(this.f594a, this.d.a()), new C0474o2());
                    this.o = c0251fc;
                }
            }
            return c0251fc;
        }
        return c0251fc2;
    }

    public final InterfaceC0380kc l() {
        InterfaceC0380kc interfaceC0380kc;
        InterfaceC0380kc interfaceC0380kc2 = this.w;
        if (interfaceC0380kc2 == null) {
            synchronized (this) {
                interfaceC0380kc = this.w;
                if (interfaceC0380kc == null) {
                    Context context = this.f594a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0380kc = new C0432mc();
                    } else {
                        interfaceC0380kc = new C0406lc(context, new C0584sc(), locationClient);
                    }
                    this.w = interfaceC0380kc;
                }
            }
            return interfaceC0380kc;
        }
        return interfaceC0380kc2;
    }

    public final InterfaceC0380kc m() {
        return l();
    }

    public final C0635ud n() {
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
                    qd = new Qd(this.f594a, new to());
                    this.z = qd;
                }
            }
            return qd;
        }
        return qd2;
    }

    public final C0356je q() {
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
                    this.b = new Hg(this.f594a, F.B().c);
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
                    aj = new Aj(this.f594a);
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

    public final C0612tf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0612tf(C0729y7.a(this.f594a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized InterfaceC0113a3 y() {
        if (this.p == null) {
            Jl jl = new Jl(this.f594a);
            this.p = jl;
            this.u.a(jl);
        }
        return this.p;
    }

    public final C0545qm z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

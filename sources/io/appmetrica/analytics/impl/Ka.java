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
public final class Ka {
    public static volatile Ka F;
    public volatile C0351ja C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f529a;
    public volatile Dg b;
    public volatile C0116a7 c;
    public volatile C0215e3 e;
    public volatile Ej f;
    public volatile T g;
    public volatile C0266g2 h;
    public volatile PlatformIdentifiers i;
    public volatile Jf j;
    public volatile V3 k;
    public volatile C0508pf l;
    public volatile Co m;
    public volatile C0686wj n;
    public volatile C0173cc o;
    public Fl p;
    public volatile Dk r;
    public volatile InterfaceC0302hc w;
    public volatile C0541qn x;
    public volatile C0738yl y;
    public volatile Md z;
    public final Ja q = new Ja();
    public final C0506pd s = new C0506pd();
    public final C0555rd t = new C0555rd();
    public final C0440mm u = new C0440mm();
    public final C0562rk v = new C0562rk();
    public final C0252fe A = new C0252fe();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0737yk D = new C0737yk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0687wk d = new C0687wk();

    public Ka(Context context) {
        this.f529a = context;
    }

    public static void a(Context context) {
        if (F == null) {
            synchronized (Ka.class) {
                if (F == null) {
                    F = new Ka(context.getApplicationContext());
                }
            }
        }
    }

    public static Ka j() {
        return F;
    }

    public final C0541qn A() {
        C0541qn c0541qn;
        C0541qn c0541qn2 = this.x;
        if (c0541qn2 == null) {
            synchronized (this) {
                c0541qn = this.x;
                if (c0541qn == null) {
                    c0541qn = new C0541qn(this.f529a);
                    this.x = c0541qn;
                }
            }
            return c0541qn;
        }
        return c0541qn2;
    }

    public final synchronized Co B() {
        if (this.m == null) {
            this.m = new Co(this.f529a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Wm a2 = Vm.a(C0607tf.class);
                    Context context = this.f529a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    C0607tf c0607tf = (C0607tf) a3.read();
                    this.j = new Jf(this.f529a, a3, new Af(), new C0557rf(c0607tf), new If(), new C0757zf(this.f529a), new Ef(j().x()), new C0632uf(), c0607tf, "[PreloadInfoStorage]");
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
                    t = new T(this.f529a, this.d.a(), this.u.b());
                    this.u.a(t);
                    this.g = t;
                }
            }
            return t;
        }
        return t2;
    }

    public final C0266g2 c() {
        C0266g2 c0266g2;
        C0266g2 c0266g22 = this.h;
        if (c0266g22 == null) {
            synchronized (this) {
                c0266g2 = this.h;
                if (c0266g2 == null) {
                    c0266g2 = new C0266g2(this.f529a, AbstractC0292h2.a());
                    this.h = c0266g2;
                }
            }
            return c0266g2;
        }
        return c0266g22;
    }

    public final C0420m2 d() {
        return k().b;
    }

    public final V3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Wm a2 = Vm.a(O3.class);
                    Context context = this.f529a;
                    ProtobufStateStorage<Object> a3 = a2.a(context, a2.c(context));
                    this.k = new V3(this.f529a, a3, new W3(), new J3(), new Z3(), new C0412lj(this.f529a), new X3(x()), new K3(), (O3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f529a;
    }

    public final C0116a7 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new C0116a7(new Z6(x()));
                }
            }
        }
        return this.c;
    }

    public final C0351ja h() {
        C0351ja c0351ja;
        C0351ja c0351ja2 = this.C;
        if (c0351ja2 == null) {
            synchronized (this) {
                c0351ja = this.C;
                if (c0351ja == null) {
                    c0351ja = new C0351ja(this.f529a);
                    this.C = c0351ja;
                }
            }
            return c0351ja;
        }
        return c0351ja2;
    }

    public final PermissionExtractor i() {
        C0738yl c0738yl = this.y;
        if (c0738yl != null) {
            return c0738yl;
        }
        synchronized (this) {
            C0738yl c0738yl2 = this.y;
            if (c0738yl2 != null) {
                return c0738yl2;
            }
            C0738yl c0738yl3 = new C0738yl(o().c.getAskForPermissionStrategy());
            this.y = c0738yl3;
            return c0738yl3;
        }
    }

    public final C0173cc k() {
        C0173cc c0173cc;
        C0173cc c0173cc2 = this.o;
        if (c0173cc2 == null) {
            synchronized (this) {
                c0173cc = this.o;
                if (c0173cc == null) {
                    c0173cc = new C0173cc(new C0138b3(this.f529a, this.d.a()), new C0420m2());
                    this.o = c0173cc;
                }
            }
            return c0173cc;
        }
        return c0173cc2;
    }

    public final InterfaceC0302hc l() {
        InterfaceC0302hc interfaceC0302hc;
        InterfaceC0302hc interfaceC0302hc2 = this.w;
        if (interfaceC0302hc2 == null) {
            synchronized (this) {
                interfaceC0302hc = this.w;
                if (interfaceC0302hc == null) {
                    Context context = this.f529a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0302hc = new C0353jc();
                    } else {
                        interfaceC0302hc = new C0328ic(context, new C0505pc(), locationClient);
                    }
                    this.w = interfaceC0302hc;
                }
            }
            return interfaceC0302hc;
        }
        return interfaceC0302hc2;
    }

    public final InterfaceC0302hc m() {
        return l();
    }

    public final C0555rd n() {
        return this.t;
    }

    public final Dk o() {
        Dk dk;
        Dk dk2 = this.r;
        if (dk2 == null) {
            synchronized (this) {
                dk = this.r;
                if (dk == null) {
                    dk = new Dk();
                    this.r = dk;
                }
            }
            return dk;
        }
        return dk2;
    }

    public final Md p() {
        Md md;
        Md md2 = this.z;
        if (md2 == null) {
            synchronized (this) {
                md = this.z;
                if (md == null) {
                    md = new Md(this.f529a, new po());
                    this.z = md;
                }
            }
            return md;
        }
        return md2;
    }

    public final C0252fe q() {
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

    public final Jf s() {
        C();
        return this.j;
    }

    public final Dg t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new Dg(this.f529a, F.B().c);
                }
            }
        }
        return this.b;
    }

    public final C0686wj u() {
        C0686wj c0686wj;
        C0686wj c0686wj2 = this.n;
        if (c0686wj2 == null) {
            synchronized (this) {
                c0686wj = this.n;
                if (c0686wj == null) {
                    c0686wj = new C0686wj(this.f529a);
                    this.n = c0686wj;
                }
            }
            return c0686wj;
        }
        return c0686wj2;
    }

    public final synchronized Ej v() {
        return this.f;
    }

    public final C0687wk w() {
        return this.d;
    }

    public final C0508pf x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0508pf(C0649v7.a(this.f529a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 y() {
        if (this.p == null) {
            Fl fl = new Fl(this.f529a);
            this.p = fl;
            this.u.a(fl);
        }
        return this.p;
    }

    public final C0440mm z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

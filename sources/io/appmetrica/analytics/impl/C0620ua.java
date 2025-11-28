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
/* renamed from: io.appmetrica.analytics.impl.ua  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0620ua {
    public static volatile C0620ua H;
    public volatile T9 C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1149a;
    public volatile C0527qg b;
    public volatile L6 c;
    public volatile Z2 e;
    public volatile C0554rj f;
    public volatile U g;
    public volatile C0336j2 h;
    public volatile PlatformIdentifiers i;
    public volatile C0725yf j;
    public volatile H3 k;
    public volatile C0220ef l;
    public volatile Co m;
    public volatile C0353jj n;
    public volatile Mb o;
    public El p;
    public volatile Ck r;
    public volatile Rb w;
    public volatile C0534qn x;
    public volatile C0706xl y;
    public volatile Cd z;
    public final C0595ta q = new C0595ta();
    public final Zc s = new Zc();
    public final C0141bd t = new C0141bd();
    public final C0408lm u = new C0408lm();
    public final C0354jk v = new C0354jk();
    public final Vd A = new Vd();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0531qk D = new C0531qk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Bk F = new Bk();
    public final C0333j G = new C0333j();
    public final C0481ok d = new C0481ok();

    public C0620ua(Context context) {
        this.f1149a = context;
    }

    public static void a(Context context) {
        if (H == null) {
            synchronized (C0620ua.class) {
                if (H == null) {
                    H = new C0620ua(context.getApplicationContext());
                }
            }
        }
    }

    public static C0620ua k() {
        return H;
    }

    public final synchronized S2 A() {
        if (this.p == null) {
            El el = new El(this.f1149a);
            this.p = el;
            this.u.a(el);
        }
        return this.p;
    }

    public final C0408lm B() {
        return this.u;
    }

    public final C0534qn C() {
        C0534qn c0534qn;
        C0534qn c0534qn2 = this.x;
        if (c0534qn2 == null) {
            synchronized (this) {
                c0534qn = this.x;
                if (c0534qn == null) {
                    c0534qn = new C0534qn(this.f1149a);
                    this.x = c0534qn;
                }
            }
            return c0534qn;
        }
        return c0534qn2;
    }

    public final synchronized Co D() {
        if (this.m == null) {
            this.m = new Co(this.f1149a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Um a2 = Tm.a(Cif.class);
                    Context context = this.f1149a;
                    Vm vm = (Vm) a2;
                    ProtobufStateStorage<Object> a3 = vm.a(context, vm.a(context));
                    Cif cif = (Cif) a3.read();
                    this.j = new C0725yf(this.f1149a, a3, new C0501pf(), new C0272gf(cif), new C0700xf(), new C0476of(this.f1149a), new C0600tf(k().z()), new C0349jf(), cif, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0333j b() {
        return this.G;
    }

    public final U c() {
        U u;
        U u2 = this.g;
        if (u2 == null) {
            synchronized (this) {
                u = this.g;
                if (u == null) {
                    u = new U(this.f1149a, this.d.a(), this.u.b());
                    this.u.a(u);
                    this.g = u;
                }
            }
            return u;
        }
        return u2;
    }

    public final C0336j2 d() {
        C0336j2 c0336j2;
        C0336j2 c0336j22 = this.h;
        if (c0336j22 == null) {
            synchronized (this) {
                c0336j2 = this.h;
                if (c0336j2 == null) {
                    c0336j2 = new C0336j2(this.f1149a, AbstractC0362k2.a());
                    this.h = c0336j2;
                }
            }
            return c0336j2;
        }
        return c0336j22;
    }

    public final C0488p2 e() {
        return l().b;
    }

    public final H3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Um a2 = Tm.a(A3.class);
                    Context context = this.f1149a;
                    Vm vm = (Vm) a2;
                    ProtobufStateStorage<Object> a3 = vm.a(context, vm.a(context));
                    this.k = new H3(this.f1149a, a3, new I3(), new C0638v3(), new L3(), new Yi(this.f1149a), new J3(z()), new C0663w3(), (A3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f1149a;
    }

    public final L6 h() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new L6(new K6(z()));
                }
            }
        }
        return this.c;
    }

    public final T9 i() {
        T9 t9;
        T9 t92 = this.C;
        if (t92 == null) {
            synchronized (this) {
                t9 = this.C;
                if (t9 == null) {
                    t9 = new T9(this.f1149a);
                    this.C = t9;
                }
            }
            return t9;
        }
        return t92;
    }

    public final PermissionExtractor j() {
        C0706xl c0706xl = this.y;
        if (c0706xl != null) {
            return c0706xl;
        }
        synchronized (this) {
            C0706xl c0706xl2 = this.y;
            if (c0706xl2 != null) {
                return c0706xl2;
            }
            C0706xl c0706xl3 = new C0706xl(p().c.getAskForPermissionStrategy());
            this.y = c0706xl3;
            return c0706xl3;
        }
    }

    public final Mb l() {
        Mb mb;
        Mb mb2 = this.o;
        if (mb2 == null) {
            synchronized (this) {
                mb = this.o;
                if (mb == null) {
                    mb = new Mb(new W2(this.f1149a, this.d.a()), new C0488p2());
                    this.o = mb;
                }
            }
            return mb;
        }
        return mb2;
    }

    public final Rb m() {
        Rb rb;
        Rb rb2 = this.w;
        if (rb2 == null) {
            synchronized (this) {
                rb = this.w;
                if (rb == null) {
                    Context context = this.f1149a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        rb = new Tb();
                    } else {
                        rb = new Sb(context, new Zb(), locationClient);
                    }
                    this.w = rb;
                }
            }
            return rb;
        }
        return rb2;
    }

    public final Rb n() {
        return m();
    }

    public final C0141bd o() {
        return this.t;
    }

    public final Ck p() {
        Ck ck;
        Ck ck2 = this.r;
        if (ck2 == null) {
            synchronized (this) {
                ck = this.r;
                if (ck == null) {
                    ck = new Ck();
                    this.r = ck;
                }
            }
            return ck;
        }
        return ck2;
    }

    public final Cd q() {
        Cd cd;
        Cd cd2 = this.z;
        if (cd2 == null) {
            synchronized (this) {
                cd = this.z;
                if (cd == null) {
                    cd = new Cd(this.f1149a, new po());
                    this.z = cd;
                }
            }
            return cd;
        }
        return cd2;
    }

    public final Vd r() {
        return this.A;
    }

    public final PlatformIdentifiers s() {
        PlatformIdentifiers platformIdentifiers;
        PlatformIdentifiers platformIdentifiers2 = this.i;
        if (platformIdentifiers2 == null) {
            synchronized (this) {
                platformIdentifiers = this.i;
                if (platformIdentifiers == null) {
                    platformIdentifiers = new PlatformIdentifiers(c(), d());
                    this.i = platformIdentifiers;
                }
            }
            return platformIdentifiers;
        }
        return platformIdentifiers2;
    }

    public final C0725yf t() {
        E();
        return this.j;
    }

    public final C0527qg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0527qg(this.f1149a, H.D().c);
                }
            }
        }
        return this.b;
    }

    public final C0353jj v() {
        C0353jj c0353jj;
        C0353jj c0353jj2 = this.n;
        if (c0353jj2 == null) {
            synchronized (this) {
                c0353jj = this.n;
                if (c0353jj == null) {
                    c0353jj = new C0353jj(this.f1149a);
                    this.n = c0353jj;
                }
            }
            return c0353jj;
        }
        return c0353jj2;
    }

    public final synchronized C0554rj w() {
        return this.f;
    }

    public final C0481ok x() {
        return this.d;
    }

    public final Bk y() {
        return this.F;
    }

    public final C0220ef z() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0220ef(C0264g7.a(this.f1149a).c());
                }
            }
        }
        return this.l;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

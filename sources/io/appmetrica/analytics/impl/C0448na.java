package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.ReferenceHolder;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import io.appmetrica.analytics.locationapi.internal.LocationClient;
import java.io.File;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.na  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0448na {
    public static volatile C0448na I;
    public volatile M9 C;
    public C0732yk H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1133a;
    public volatile C0404lg b;
    public volatile E6 c;
    public volatile R2 e;
    public volatile C0432mj f;
    public volatile U g;
    public volatile C0107a2 h;
    public volatile PlatformIdentifiers i;
    public volatile C0602tf j;
    public volatile C0740z3 k;
    public volatile Ze l;
    public volatile Ao m;
    public volatile C0227ej n;
    public volatile Fb o;
    public Al p;
    public volatile C0707xk r;
    public volatile Kb w;
    public volatile C0486on x;
    public volatile C0608tl y;
    public volatile C0650vd z;
    public final C0423ma q = new C0423ma();
    public final Sc s = new Sc();
    public final Uc t = new Uc();
    public final C0308hm u = new C0308hm();
    public final C0228ek v = new C0228ek();
    public final Od A = new Od();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0433mk D = new C0433mk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0682wk F = new C0682wk();
    public final C0336j G = new C0336j();
    public final C0383kk d = new C0383kk();

    public C0448na(Context context) {
        this.f1133a = context;
    }

    public static void a(Context context) {
        if (I == null) {
            synchronized (C0448na.class) {
                if (I == null) {
                    I = new C0448na(context.getApplicationContext());
                }
            }
        }
    }

    public static C0448na k() {
        return I;
    }

    public final C0308hm A() {
        return this.u;
    }

    public final C0732yk B() {
        C0732yk c0732yk;
        File file;
        C0732yk c0732yk2 = this.H;
        if (c0732yk2 == null) {
            synchronized (this) {
                c0732yk = this.H;
                if (c0732yk == null) {
                    Context context = this.f1133a;
                    String readSystemProperty = SystemPropertiesHelper.readSystemProperty("ro.yndx.metrica.db.dir");
                    String readSystemProperty2 = SystemPropertiesHelper.readSystemProperty("debug.yndx.iaa.db.dir");
                    if (StringsKt.isBlank(readSystemProperty)) {
                        readSystemProperty = readSystemProperty2;
                    }
                    if (!StringsKt.isBlank(readSystemProperty)) {
                        file = new File(readSystemProperty, context.getPackageName());
                        try {
                            file.mkdirs();
                        } catch (Exception unused) {
                        }
                        c0732yk = new C0732yk(file);
                        this.H = c0732yk;
                    }
                    file = null;
                    c0732yk = new C0732yk(file);
                    this.H = c0732yk;
                }
            }
            return c0732yk;
        }
        return c0732yk2;
    }

    public final C0486on C() {
        C0486on c0486on;
        C0486on c0486on2 = this.x;
        if (c0486on2 == null) {
            synchronized (this) {
                c0486on = this.x;
                if (c0486on == null) {
                    c0486on = new C0486on(this.f1133a);
                    this.x = c0486on;
                }
            }
            return c0486on;
        }
        return c0486on2;
    }

    public final synchronized Ao D() {
        if (this.m == null) {
            this.m = new Ao(this.f1133a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Qm a2 = Pm.a(C0198df.class);
                    Context context = this.f1133a;
                    Rm rm = (Rm) a2;
                    ProtobufStateStorage<Object> a3 = rm.a(context, rm.a(context));
                    C0198df c0198df = (C0198df) a3.read();
                    this.j = new C0602tf(this.f1133a, a3, new C0378kf(), new C0146bf(c0198df), new C0577sf(), new C0352jf(this.f1133a), new C0478of(k().y()), new C0223ef(), c0198df, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0336j b() {
        return this.G;
    }

    public final U c() {
        U u;
        U u2 = this.g;
        if (u2 == null) {
            synchronized (this) {
                u = this.g;
                if (u == null) {
                    u = new U(this.f1133a, this.d.a(), this.u.b());
                    this.u.a(u);
                    this.g = u;
                }
            }
            return u;
        }
        return u2;
    }

    public final C0107a2 d() {
        C0107a2 c0107a2;
        C0107a2 c0107a22 = this.h;
        if (c0107a22 == null) {
            synchronized (this) {
                c0107a2 = this.h;
                if (c0107a2 == null) {
                    c0107a2 = new C0107a2(this.f1133a, AbstractC0133b2.a());
                    this.h = c0107a2;
                }
            }
            return c0107a2;
        }
        return c0107a22;
    }

    public final C0262g2 e() {
        return l().b;
    }

    public final C0740z3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Qm a2 = Pm.a(C0565s3.class);
                    Context context = this.f1133a;
                    Rm rm = (Rm) a2;
                    ProtobufStateStorage<Object> a3 = rm.a(context, rm.a(context));
                    this.k = new C0740z3(this.f1133a, a3, new A3(), new C0441n3(), new D3(), new Ti(this.f1133a), new B3(y()), new C0466o3(), (C0565s3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f1133a;
    }

    public final E6 h() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new E6(new D6(y()));
                }
            }
        }
        return this.c;
    }

    public final M9 i() {
        M9 m9;
        M9 m92 = this.C;
        if (m92 == null) {
            synchronized (this) {
                m9 = this.C;
                if (m9 == null) {
                    m9 = new M9(this.f1133a);
                    this.C = m9;
                }
            }
            return m9;
        }
        return m92;
    }

    public final PermissionExtractor j() {
        C0608tl c0608tl = this.y;
        if (c0608tl != null) {
            return c0608tl;
        }
        synchronized (this) {
            C0608tl c0608tl2 = this.y;
            if (c0608tl2 != null) {
                return c0608tl2;
            }
            C0608tl c0608tl3 = new C0608tl(p().c.getAskForPermissionStrategy());
            this.y = c0608tl3;
            return c0608tl3;
        }
    }

    public final Fb l() {
        Fb fb;
        Fb fb2 = this.o;
        if (fb2 == null) {
            synchronized (this) {
                fb = this.o;
                if (fb == null) {
                    fb = new Fb(new O2(this.f1133a, this.d.a()), new C0262g2());
                    this.o = fb;
                }
            }
            return fb;
        }
        return fb2;
    }

    public final Kb m() {
        Kb kb;
        Kb kb2 = this.w;
        if (kb2 == null) {
            synchronized (this) {
                kb = this.w;
                if (kb == null) {
                    Context context = this.f1133a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        kb = new Mb();
                    } else {
                        kb = new Lb(context, new Sb(), locationClient);
                    }
                    this.w = kb;
                }
            }
            return kb;
        }
        return kb2;
    }

    public final Kb n() {
        return m();
    }

    public final Uc o() {
        return this.t;
    }

    public final C0707xk p() {
        C0707xk c0707xk;
        C0707xk c0707xk2 = this.r;
        if (c0707xk2 == null) {
            synchronized (this) {
                c0707xk = this.r;
                if (c0707xk == null) {
                    c0707xk = new C0707xk();
                    this.r = c0707xk;
                }
            }
            return c0707xk;
        }
        return c0707xk2;
    }

    public final C0650vd q() {
        C0650vd c0650vd;
        C0650vd c0650vd2 = this.z;
        if (c0650vd2 == null) {
            synchronized (this) {
                c0650vd = this.z;
                if (c0650vd == null) {
                    c0650vd = new C0650vd(this.f1133a, new no());
                    this.z = c0650vd;
                }
            }
            return c0650vd;
        }
        return c0650vd2;
    }

    public final Od r() {
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

    public final C0602tf t() {
        E();
        return this.j;
    }

    public final C0404lg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0404lg(this.f1133a, I.D().c);
                }
            }
        }
        return this.b;
    }

    public final C0227ej v() {
        C0227ej c0227ej;
        C0227ej c0227ej2 = this.n;
        if (c0227ej2 == null) {
            synchronized (this) {
                c0227ej = this.n;
                if (c0227ej == null) {
                    c0227ej = new C0227ej(this.f1133a);
                    this.n = c0227ej;
                }
            }
            return c0227ej;
        }
        return c0227ej2;
    }

    public final C0383kk w() {
        return this.d;
    }

    public final C0682wk x() {
        return this.F;
    }

    public final Ze y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new Ze(B().d(this.f1133a));
                }
            }
        }
        return this.l;
    }

    public final synchronized K2 z() {
        if (this.p == null) {
            Al al = new Al(this.f1133a);
            this.p = al;
            this.u.a(al);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

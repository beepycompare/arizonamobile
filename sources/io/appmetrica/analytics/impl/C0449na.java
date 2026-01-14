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
public final class C0449na {
    public static volatile C0449na I;
    public volatile M9 C;
    public C0733yk H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1134a;
    public volatile C0405lg b;
    public volatile E6 c;
    public volatile R2 e;
    public volatile C0433mj f;
    public volatile U g;
    public volatile C0108a2 h;
    public volatile PlatformIdentifiers i;
    public volatile C0603tf j;
    public volatile C0741z3 k;
    public volatile Ze l;
    public volatile Ao m;
    public volatile C0228ej n;
    public volatile Fb o;
    public Al p;
    public volatile C0708xk r;
    public volatile Kb w;
    public volatile C0487on x;
    public volatile C0609tl y;
    public volatile C0651vd z;
    public final C0424ma q = new C0424ma();
    public final Sc s = new Sc();
    public final Uc t = new Uc();
    public final C0309hm u = new C0309hm();
    public final C0229ek v = new C0229ek();
    public final Od A = new Od();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0434mk D = new C0434mk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0683wk F = new C0683wk();
    public final C0337j G = new C0337j();
    public final C0384kk d = new C0384kk();

    public C0449na(Context context) {
        this.f1134a = context;
    }

    public static void a(Context context) {
        if (I == null) {
            synchronized (C0449na.class) {
                if (I == null) {
                    I = new C0449na(context.getApplicationContext());
                }
            }
        }
    }

    public static C0449na k() {
        return I;
    }

    public final C0309hm A() {
        return this.u;
    }

    public final C0733yk B() {
        C0733yk c0733yk;
        File file;
        C0733yk c0733yk2 = this.H;
        if (c0733yk2 == null) {
            synchronized (this) {
                c0733yk = this.H;
                if (c0733yk == null) {
                    Context context = this.f1134a;
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
                        c0733yk = new C0733yk(file);
                        this.H = c0733yk;
                    }
                    file = null;
                    c0733yk = new C0733yk(file);
                    this.H = c0733yk;
                }
            }
            return c0733yk;
        }
        return c0733yk2;
    }

    public final C0487on C() {
        C0487on c0487on;
        C0487on c0487on2 = this.x;
        if (c0487on2 == null) {
            synchronized (this) {
                c0487on = this.x;
                if (c0487on == null) {
                    c0487on = new C0487on(this.f1134a);
                    this.x = c0487on;
                }
            }
            return c0487on;
        }
        return c0487on2;
    }

    public final synchronized Ao D() {
        if (this.m == null) {
            this.m = new Ao(this.f1134a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Qm a2 = Pm.a(C0199df.class);
                    Context context = this.f1134a;
                    Rm rm = (Rm) a2;
                    ProtobufStateStorage<Object> a3 = rm.a(context, rm.a(context));
                    C0199df c0199df = (C0199df) a3.read();
                    this.j = new C0603tf(this.f1134a, a3, new C0379kf(), new C0147bf(c0199df), new C0578sf(), new C0353jf(this.f1134a), new C0479of(k().y()), new C0224ef(), c0199df, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0337j b() {
        return this.G;
    }

    public final U c() {
        U u;
        U u2 = this.g;
        if (u2 == null) {
            synchronized (this) {
                u = this.g;
                if (u == null) {
                    u = new U(this.f1134a, this.d.a(), this.u.b());
                    this.u.a(u);
                    this.g = u;
                }
            }
            return u;
        }
        return u2;
    }

    public final C0108a2 d() {
        C0108a2 c0108a2;
        C0108a2 c0108a22 = this.h;
        if (c0108a22 == null) {
            synchronized (this) {
                c0108a2 = this.h;
                if (c0108a2 == null) {
                    c0108a2 = new C0108a2(this.f1134a, AbstractC0134b2.a());
                    this.h = c0108a2;
                }
            }
            return c0108a2;
        }
        return c0108a22;
    }

    public final C0263g2 e() {
        return l().b;
    }

    public final C0741z3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Qm a2 = Pm.a(C0566s3.class);
                    Context context = this.f1134a;
                    Rm rm = (Rm) a2;
                    ProtobufStateStorage<Object> a3 = rm.a(context, rm.a(context));
                    this.k = new C0741z3(this.f1134a, a3, new A3(), new C0442n3(), new D3(), new Ti(this.f1134a), new B3(y()), new C0467o3(), (C0566s3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f1134a;
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
                    m9 = new M9(this.f1134a);
                    this.C = m9;
                }
            }
            return m9;
        }
        return m92;
    }

    public final PermissionExtractor j() {
        C0609tl c0609tl = this.y;
        if (c0609tl != null) {
            return c0609tl;
        }
        synchronized (this) {
            C0609tl c0609tl2 = this.y;
            if (c0609tl2 != null) {
                return c0609tl2;
            }
            C0609tl c0609tl3 = new C0609tl(p().c.getAskForPermissionStrategy());
            this.y = c0609tl3;
            return c0609tl3;
        }
    }

    public final Fb l() {
        Fb fb;
        Fb fb2 = this.o;
        if (fb2 == null) {
            synchronized (this) {
                fb = this.o;
                if (fb == null) {
                    fb = new Fb(new O2(this.f1134a, this.d.a()), new C0263g2());
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
                    Context context = this.f1134a;
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

    public final C0708xk p() {
        C0708xk c0708xk;
        C0708xk c0708xk2 = this.r;
        if (c0708xk2 == null) {
            synchronized (this) {
                c0708xk = this.r;
                if (c0708xk == null) {
                    c0708xk = new C0708xk();
                    this.r = c0708xk;
                }
            }
            return c0708xk;
        }
        return c0708xk2;
    }

    public final C0651vd q() {
        C0651vd c0651vd;
        C0651vd c0651vd2 = this.z;
        if (c0651vd2 == null) {
            synchronized (this) {
                c0651vd = this.z;
                if (c0651vd == null) {
                    c0651vd = new C0651vd(this.f1134a, new no());
                    this.z = c0651vd;
                }
            }
            return c0651vd;
        }
        return c0651vd2;
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

    public final C0603tf t() {
        E();
        return this.j;
    }

    public final C0405lg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0405lg(this.f1134a, I.D().c);
                }
            }
        }
        return this.b;
    }

    public final C0228ej v() {
        C0228ej c0228ej;
        C0228ej c0228ej2 = this.n;
        if (c0228ej2 == null) {
            synchronized (this) {
                c0228ej = this.n;
                if (c0228ej == null) {
                    c0228ej = new C0228ej(this.f1134a);
                    this.n = c0228ej;
                }
            }
            return c0228ej;
        }
        return c0228ej2;
    }

    public final C0384kk w() {
        return this.d;
    }

    public final C0683wk x() {
        return this.F;
    }

    public final Ze y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new Ze(B().d(this.f1134a));
                }
            }
        }
        return this.l;
    }

    public final synchronized K2 z() {
        if (this.p == null) {
            Al al = new Al(this.f1134a);
            this.p = al;
            this.u.a(al);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

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
/* loaded from: classes5.dex */
public final class Na {
    public static volatile Na I;
    public volatile C0297ha C;
    public C0127al H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f683a;
    public volatile Fg b;
    public volatile W6 c;
    public volatile C0212e3 e;
    public volatile Mj f;
    public volatile W g;
    public volatile C0444n2 h;
    public volatile PlatformIdentifiers i;
    public volatile Tf j;
    public volatile Q3 k;
    public volatile C0768zf l;
    public volatile dp m;
    public volatile Fj n;
    public volatile C0299hc o;
    public C0180cm p;
    public volatile Zk r;
    public volatile InterfaceC0428mc w;
    public volatile Pn x;
    public volatile Yl y;
    public volatile Vd z;
    public final Ma q = new Ma();
    public final C0584sd s = new C0584sd();
    public final C0636ud t = new C0636ud();
    public final Jm u = new Jm();
    public final Gk v = new Gk();
    public final C0482oe A = new C0482oe();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Ok D = new Ok();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Yk F = new Yk();
    public final C0337j G = new C0337j();
    public final Mk d = new Mk();

    public Na(Context context) {
        this.f683a = context;
    }

    public static void a(Context context) {
        if (I == null) {
            synchronized (Na.class) {
                if (I == null) {
                    I = new Na(context.getApplicationContext());
                }
            }
        }
    }

    public static Na k() {
        return I;
    }

    public final Jm A() {
        return this.u;
    }

    public final C0127al B() {
        C0127al c0127al;
        File file;
        C0127al c0127al2 = this.H;
        if (c0127al2 == null) {
            synchronized (this) {
                c0127al = this.H;
                if (c0127al == null) {
                    Context context = this.f683a;
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
                        c0127al = new C0127al(file);
                        this.H = c0127al;
                    }
                    file = null;
                    c0127al = new C0127al(file);
                    this.H = c0127al;
                }
            }
            return c0127al;
        }
        return c0127al2;
    }

    public final Pn C() {
        Pn pn;
        Pn pn2 = this.x;
        if (pn2 == null) {
            synchronized (this) {
                pn = this.x;
                if (pn == null) {
                    pn = new Pn(this.f683a);
                    this.x = pn;
                }
            }
            return pn;
        }
        return pn2;
    }

    public final synchronized dp D() {
        if (this.m == null) {
            this.m = new dp(this.f683a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    InterfaceC0594sn a2 = C0568rn.a(Df.class);
                    Context context = this.f683a;
                    AbstractC0620tn abstractC0620tn = (AbstractC0620tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0620tn.a(context, abstractC0620tn.a(context));
                    Df df = (Df) a3.read();
                    this.j = new Tf(this.f683a, a3, new Kf(), new Bf(df), new Sf(), new Jf(this.f683a), new Of(k().y()), new Ef(), df, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0337j b() {
        return this.G;
    }

    public final W c() {
        W w;
        W w2 = this.g;
        if (w2 == null) {
            synchronized (this) {
                w = this.g;
                if (w == null) {
                    w = new W(this.f683a, this.d.g(), this.u.a());
                    this.u.a(w);
                    this.g = w;
                }
            }
            return w;
        }
        return w2;
    }

    public final C0444n2 d() {
        C0444n2 c0444n2;
        C0444n2 c0444n22 = this.h;
        if (c0444n22 == null) {
            synchronized (this) {
                c0444n2 = this.h;
                if (c0444n2 == null) {
                    c0444n2 = new C0444n2(this.f683a, AbstractC0470o2.a());
                    this.h = c0444n2;
                }
            }
            return c0444n2;
        }
        return c0444n22;
    }

    public final C0599t2 e() {
        return l().b;
    }

    public final Q3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    InterfaceC0594sn a2 = C0568rn.a(J3.class);
                    Context context = this.f683a;
                    AbstractC0620tn abstractC0620tn = (AbstractC0620tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0620tn.a(context, abstractC0620tn.a(context));
                    this.k = new Q3(this.f683a, a3, new R3(), new E3(), new U3(), new C0642uj(this.f683a), new S3(y()), new F3(), (J3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f683a;
    }

    public final W6 h() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new W6(new V6(y()));
                }
            }
        }
        return this.c;
    }

    public final C0297ha i() {
        C0297ha c0297ha;
        C0297ha c0297ha2 = this.C;
        if (c0297ha2 == null) {
            synchronized (this) {
                c0297ha = this.C;
                if (c0297ha == null) {
                    c0297ha = new C0297ha(this.f683a);
                    this.C = c0297ha;
                }
            }
            return c0297ha;
        }
        return c0297ha2;
    }

    public final PermissionExtractor j() {
        Yl yl = this.y;
        if (yl != null) {
            return yl;
        }
        synchronized (this) {
            Yl yl2 = this.y;
            if (yl2 != null) {
                return yl2;
            }
            Yl yl3 = new Yl(p().c.getAskForPermissionStrategy());
            this.y = yl3;
            return yl3;
        }
    }

    public final C0299hc l() {
        C0299hc c0299hc;
        C0299hc c0299hc2 = this.o;
        if (c0299hc2 == null) {
            synchronized (this) {
                c0299hc = this.o;
                if (c0299hc == null) {
                    c0299hc = new C0299hc(new C0135b3(this.f683a, this.d.a()), new C0599t2());
                    this.o = c0299hc;
                }
            }
            return c0299hc;
        }
        return c0299hc2;
    }

    public final InterfaceC0428mc m() {
        InterfaceC0428mc interfaceC0428mc;
        InterfaceC0428mc interfaceC0428mc2 = this.w;
        if (interfaceC0428mc2 == null) {
            synchronized (this) {
                interfaceC0428mc = this.w;
                if (interfaceC0428mc == null) {
                    Context context = this.f683a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0428mc = new C0480oc();
                    } else {
                        interfaceC0428mc = new C0454nc(context, new C0635uc(), locationClient);
                    }
                    this.w = interfaceC0428mc;
                }
            }
            return interfaceC0428mc;
        }
        return interfaceC0428mc2;
    }

    public final InterfaceC0428mc n() {
        return m();
    }

    public final C0636ud o() {
        return this.t;
    }

    public final Zk p() {
        Zk zk;
        Zk zk2 = this.r;
        if (zk2 == null) {
            synchronized (this) {
                zk = this.r;
                if (zk == null) {
                    zk = new Zk();
                    this.r = zk;
                }
            }
            return zk;
        }
        return zk2;
    }

    public final Vd q() {
        Vd vd;
        Vd vd2 = this.z;
        if (vd2 == null) {
            synchronized (this) {
                vd = this.z;
                if (vd == null) {
                    vd = new Vd(this.f683a, new Qo());
                    this.z = vd;
                }
            }
            return vd;
        }
        return vd2;
    }

    public final C0482oe r() {
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

    public final Tf t() {
        E();
        return this.j;
    }

    public final Fg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new Fg(new Ig().a(this.f683a));
                }
            }
        }
        return this.b;
    }

    public final Fj v() {
        Fj fj;
        Fj fj2 = this.n;
        if (fj2 == null) {
            synchronized (this) {
                fj = this.n;
                if (fj == null) {
                    fj = new Fj(this.f683a);
                    this.n = fj;
                }
            }
            return fj;
        }
        return fj2;
    }

    public final Mk w() {
        return this.d;
    }

    public final Yk x() {
        return this.F;
    }

    public final C0768zf y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0768zf(B().d(this.f683a));
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 z() {
        if (this.p == null) {
            C0180cm c0180cm = new C0180cm(this.f683a);
            this.p = c0180cm;
            this.u.a(c0180cm);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

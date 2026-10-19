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
    public volatile C0291ha C;
    public C0121al H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f686a;
    public volatile Fg b;
    public volatile W6 c;
    public volatile C0206e3 e;
    public volatile Mj f;
    public volatile W g;
    public volatile C0438n2 h;
    public volatile PlatformIdentifiers i;
    public volatile Tf j;
    public volatile Q3 k;
    public volatile C0762zf l;
    public volatile dp m;
    public volatile Fj n;
    public volatile C0293hc o;
    public C0174cm p;
    public volatile Zk r;
    public volatile InterfaceC0422mc w;
    public volatile Pn x;
    public volatile Yl y;
    public volatile Vd z;
    public final Ma q = new Ma();
    public final C0578sd s = new C0578sd();
    public final C0630ud t = new C0630ud();
    public final Jm u = new Jm();
    public final Gk v = new Gk();
    public final C0476oe A = new C0476oe();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Ok D = new Ok();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Yk F = new Yk();
    public final C0331j G = new C0331j();
    public final Mk d = new Mk();

    public Na(Context context) {
        this.f686a = context;
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

    public final C0121al B() {
        C0121al c0121al;
        File file;
        C0121al c0121al2 = this.H;
        if (c0121al2 == null) {
            synchronized (this) {
                c0121al = this.H;
                if (c0121al == null) {
                    Context context = this.f686a;
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
                        c0121al = new C0121al(file);
                        this.H = c0121al;
                    }
                    file = null;
                    c0121al = new C0121al(file);
                    this.H = c0121al;
                }
            }
            return c0121al;
        }
        return c0121al2;
    }

    public final Pn C() {
        Pn pn;
        Pn pn2 = this.x;
        if (pn2 == null) {
            synchronized (this) {
                pn = this.x;
                if (pn == null) {
                    pn = new Pn(this.f686a);
                    this.x = pn;
                }
            }
            return pn;
        }
        return pn2;
    }

    public final synchronized dp D() {
        if (this.m == null) {
            this.m = new dp(this.f686a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    InterfaceC0588sn a2 = C0562rn.a(Df.class);
                    Context context = this.f686a;
                    AbstractC0614tn abstractC0614tn = (AbstractC0614tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0614tn.a(context, abstractC0614tn.a(context));
                    Df df = (Df) a3.read();
                    this.j = new Tf(this.f686a, a3, new Kf(), new Bf(df), new Sf(), new Jf(this.f686a), new Of(k().y()), new Ef(), df, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0331j b() {
        return this.G;
    }

    public final W c() {
        W w;
        W w2 = this.g;
        if (w2 == null) {
            synchronized (this) {
                w = this.g;
                if (w == null) {
                    w = new W(this.f686a, this.d.g(), this.u.a());
                    this.u.a(w);
                    this.g = w;
                }
            }
            return w;
        }
        return w2;
    }

    public final C0438n2 d() {
        C0438n2 c0438n2;
        C0438n2 c0438n22 = this.h;
        if (c0438n22 == null) {
            synchronized (this) {
                c0438n2 = this.h;
                if (c0438n2 == null) {
                    c0438n2 = new C0438n2(this.f686a, AbstractC0464o2.a());
                    this.h = c0438n2;
                }
            }
            return c0438n2;
        }
        return c0438n22;
    }

    public final C0593t2 e() {
        return l().b;
    }

    public final Q3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    InterfaceC0588sn a2 = C0562rn.a(J3.class);
                    Context context = this.f686a;
                    AbstractC0614tn abstractC0614tn = (AbstractC0614tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0614tn.a(context, abstractC0614tn.a(context));
                    this.k = new Q3(this.f686a, a3, new R3(), new E3(), new U3(), new C0636uj(this.f686a), new S3(y()), new F3(), (J3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f686a;
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

    public final C0291ha i() {
        C0291ha c0291ha;
        C0291ha c0291ha2 = this.C;
        if (c0291ha2 == null) {
            synchronized (this) {
                c0291ha = this.C;
                if (c0291ha == null) {
                    c0291ha = new C0291ha(this.f686a);
                    this.C = c0291ha;
                }
            }
            return c0291ha;
        }
        return c0291ha2;
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

    public final C0293hc l() {
        C0293hc c0293hc;
        C0293hc c0293hc2 = this.o;
        if (c0293hc2 == null) {
            synchronized (this) {
                c0293hc = this.o;
                if (c0293hc == null) {
                    c0293hc = new C0293hc(new C0129b3(this.f686a, this.d.a()), new C0593t2());
                    this.o = c0293hc;
                }
            }
            return c0293hc;
        }
        return c0293hc2;
    }

    public final InterfaceC0422mc m() {
        InterfaceC0422mc interfaceC0422mc;
        InterfaceC0422mc interfaceC0422mc2 = this.w;
        if (interfaceC0422mc2 == null) {
            synchronized (this) {
                interfaceC0422mc = this.w;
                if (interfaceC0422mc == null) {
                    Context context = this.f686a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0422mc = new C0474oc();
                    } else {
                        interfaceC0422mc = new C0448nc(context, new C0629uc(), locationClient);
                    }
                    this.w = interfaceC0422mc;
                }
            }
            return interfaceC0422mc;
        }
        return interfaceC0422mc2;
    }

    public final InterfaceC0422mc n() {
        return m();
    }

    public final C0630ud o() {
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
                    vd = new Vd(this.f686a, new Qo());
                    this.z = vd;
                }
            }
            return vd;
        }
        return vd2;
    }

    public final C0476oe r() {
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
                    this.b = new Fg(new Ig().a(this.f686a));
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
                    fj = new Fj(this.f686a);
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

    public final C0762zf y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0762zf(B().d(this.f686a));
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 z() {
        if (this.p == null) {
            C0174cm c0174cm = new C0174cm(this.f686a);
            this.p = c0174cm;
            this.u.a(c0174cm);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

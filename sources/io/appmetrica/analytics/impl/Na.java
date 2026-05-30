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
    public volatile C0298ha C;
    public C0128al H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f681a;
    public volatile Fg b;
    public volatile W6 c;
    public volatile C0213e3 e;
    public volatile Mj f;
    public volatile W g;
    public volatile C0445n2 h;
    public volatile PlatformIdentifiers i;
    public volatile Tf j;
    public volatile Q3 k;
    public volatile C0769zf l;
    public volatile dp m;
    public volatile Fj n;
    public volatile C0300hc o;
    public C0181cm p;
    public volatile Zk r;
    public volatile InterfaceC0429mc w;
    public volatile Pn x;
    public volatile Yl y;
    public volatile Vd z;
    public final Ma q = new Ma();
    public final C0585sd s = new C0585sd();
    public final C0637ud t = new C0637ud();
    public final Jm u = new Jm();
    public final Gk v = new Gk();
    public final C0483oe A = new C0483oe();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Ok D = new Ok();
    public final ReferenceHolder E = new ReferenceHolder();
    public final Yk F = new Yk();
    public final C0338j G = new C0338j();
    public final Mk d = new Mk();

    public Na(Context context) {
        this.f681a = context;
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

    public final C0128al B() {
        C0128al c0128al;
        File file;
        C0128al c0128al2 = this.H;
        if (c0128al2 == null) {
            synchronized (this) {
                c0128al = this.H;
                if (c0128al == null) {
                    Context context = this.f681a;
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
                        c0128al = new C0128al(file);
                        this.H = c0128al;
                    }
                    file = null;
                    c0128al = new C0128al(file);
                    this.H = c0128al;
                }
            }
            return c0128al;
        }
        return c0128al2;
    }

    public final Pn C() {
        Pn pn;
        Pn pn2 = this.x;
        if (pn2 == null) {
            synchronized (this) {
                pn = this.x;
                if (pn == null) {
                    pn = new Pn(this.f681a);
                    this.x = pn;
                }
            }
            return pn;
        }
        return pn2;
    }

    public final synchronized dp D() {
        if (this.m == null) {
            this.m = new dp(this.f681a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    InterfaceC0595sn a2 = C0569rn.a(Df.class);
                    Context context = this.f681a;
                    AbstractC0621tn abstractC0621tn = (AbstractC0621tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0621tn.a(context, abstractC0621tn.a(context));
                    Df df = (Df) a3.read();
                    this.j = new Tf(this.f681a, a3, new Kf(), new Bf(df), new Sf(), new Jf(this.f681a), new Of(k().y()), new Ef(), df, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0338j b() {
        return this.G;
    }

    public final W c() {
        W w;
        W w2 = this.g;
        if (w2 == null) {
            synchronized (this) {
                w = this.g;
                if (w == null) {
                    w = new W(this.f681a, this.d.g(), this.u.a());
                    this.u.a(w);
                    this.g = w;
                }
            }
            return w;
        }
        return w2;
    }

    public final C0445n2 d() {
        C0445n2 c0445n2;
        C0445n2 c0445n22 = this.h;
        if (c0445n22 == null) {
            synchronized (this) {
                c0445n2 = this.h;
                if (c0445n2 == null) {
                    c0445n2 = new C0445n2(this.f681a, AbstractC0471o2.a());
                    this.h = c0445n2;
                }
            }
            return c0445n2;
        }
        return c0445n22;
    }

    public final C0600t2 e() {
        return l().b;
    }

    public final Q3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    InterfaceC0595sn a2 = C0569rn.a(J3.class);
                    Context context = this.f681a;
                    AbstractC0621tn abstractC0621tn = (AbstractC0621tn) a2;
                    ProtobufStateStorage<Object> a3 = abstractC0621tn.a(context, abstractC0621tn.a(context));
                    this.k = new Q3(this.f681a, a3, new R3(), new E3(), new U3(), new C0643uj(this.f681a), new S3(y()), new F3(), (J3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f681a;
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

    public final C0298ha i() {
        C0298ha c0298ha;
        C0298ha c0298ha2 = this.C;
        if (c0298ha2 == null) {
            synchronized (this) {
                c0298ha = this.C;
                if (c0298ha == null) {
                    c0298ha = new C0298ha(this.f681a);
                    this.C = c0298ha;
                }
            }
            return c0298ha;
        }
        return c0298ha2;
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

    public final C0300hc l() {
        C0300hc c0300hc;
        C0300hc c0300hc2 = this.o;
        if (c0300hc2 == null) {
            synchronized (this) {
                c0300hc = this.o;
                if (c0300hc == null) {
                    c0300hc = new C0300hc(new C0136b3(this.f681a, this.d.a()), new C0600t2());
                    this.o = c0300hc;
                }
            }
            return c0300hc;
        }
        return c0300hc2;
    }

    public final InterfaceC0429mc m() {
        InterfaceC0429mc interfaceC0429mc;
        InterfaceC0429mc interfaceC0429mc2 = this.w;
        if (interfaceC0429mc2 == null) {
            synchronized (this) {
                interfaceC0429mc = this.w;
                if (interfaceC0429mc == null) {
                    Context context = this.f681a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        interfaceC0429mc = new C0481oc();
                    } else {
                        interfaceC0429mc = new C0455nc(context, new C0636uc(), locationClient);
                    }
                    this.w = interfaceC0429mc;
                }
            }
            return interfaceC0429mc;
        }
        return interfaceC0429mc2;
    }

    public final InterfaceC0429mc n() {
        return m();
    }

    public final C0637ud o() {
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
                    vd = new Vd(this.f681a, new Qo());
                    this.z = vd;
                }
            }
            return vd;
        }
        return vd2;
    }

    public final C0483oe r() {
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
                    this.b = new Fg(new Ig().a(this.f681a));
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
                    fj = new Fj(this.f681a);
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

    public final C0769zf y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0769zf(B().d(this.f681a));
                }
            }
        }
        return this.l;
    }

    public final synchronized X2 z() {
        if (this.p == null) {
            C0181cm c0181cm = new C0181cm(this.f681a);
            this.p = c0181cm;
            this.u.a(c0181cm);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

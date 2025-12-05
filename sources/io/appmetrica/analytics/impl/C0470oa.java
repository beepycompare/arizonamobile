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
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0470oa {
    public static volatile C0470oa I;
    public volatile N9 C;
    public C0754zk H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1129a;
    public volatile C0426mg b;
    public volatile F6 c;
    public volatile S2 e;
    public volatile C0454nj f;
    public volatile U g;
    public volatile C0129b2 h;
    public volatile PlatformIdentifiers i;
    public volatile C0624uf j;
    public volatile A3 k;
    public volatile C0116af l;
    public volatile Bo m;
    public volatile C0249fj n;
    public volatile Gb o;
    public Bl p;
    public volatile C0729yk r;
    public volatile Lb w;
    public volatile C0508pn x;
    public volatile C0630ul y;
    public volatile C0672wd z;
    public final C0445na q = new C0445na();
    public final Tc s = new Tc();
    public final Vc t = new Vc();
    public final C0329im u = new C0329im();
    public final C0250fk v = new C0250fk();
    public final Pd A = new Pd();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0455nk D = new C0455nk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0704xk F = new C0704xk();
    public final C0332j G = new C0332j();
    public final C0405lk d = new C0405lk();

    public C0470oa(Context context) {
        this.f1129a = context;
    }

    public static void a(Context context) {
        if (I == null) {
            synchronized (C0470oa.class) {
                if (I == null) {
                    I = new C0470oa(context.getApplicationContext());
                }
            }
        }
    }

    public static C0470oa k() {
        return I;
    }

    public final C0329im A() {
        return this.u;
    }

    public final C0754zk B() {
        C0754zk c0754zk;
        File file;
        C0754zk c0754zk2 = this.H;
        if (c0754zk2 == null) {
            synchronized (this) {
                c0754zk = this.H;
                if (c0754zk == null) {
                    Context context = this.f1129a;
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
                        c0754zk = new C0754zk(file);
                        this.H = c0754zk;
                    }
                    file = null;
                    c0754zk = new C0754zk(file);
                    this.H = c0754zk;
                }
            }
            return c0754zk;
        }
        return c0754zk2;
    }

    public final C0508pn C() {
        C0508pn c0508pn;
        C0508pn c0508pn2 = this.x;
        if (c0508pn2 == null) {
            synchronized (this) {
                c0508pn = this.x;
                if (c0508pn == null) {
                    c0508pn = new C0508pn(this.f1129a);
                    this.x = c0508pn;
                }
            }
            return c0508pn;
        }
        return c0508pn2;
    }

    public final synchronized Bo D() {
        if (this.m == null) {
            this.m = new Bo(this.f1129a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Rm a2 = Qm.a(C0219ef.class);
                    Context context = this.f1129a;
                    Sm sm = (Sm) a2;
                    ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                    C0219ef c0219ef = (C0219ef) a3.read();
                    this.j = new C0624uf(this.f1129a, a3, new C0400lf(), new C0168cf(c0219ef), new C0599tf(), new C0374kf(this.f1129a), new C0500pf(k().y()), new C0245ff(), c0219ef, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final C0332j b() {
        return this.G;
    }

    public final U c() {
        U u;
        U u2 = this.g;
        if (u2 == null) {
            synchronized (this) {
                u = this.g;
                if (u == null) {
                    u = new U(this.f1129a, this.d.a(), this.u.b());
                    this.u.a(u);
                    this.g = u;
                }
            }
            return u;
        }
        return u2;
    }

    public final C0129b2 d() {
        C0129b2 c0129b2;
        C0129b2 c0129b22 = this.h;
        if (c0129b22 == null) {
            synchronized (this) {
                c0129b2 = this.h;
                if (c0129b2 == null) {
                    c0129b2 = new C0129b2(this.f1129a, AbstractC0155c2.a());
                    this.h = c0129b2;
                }
            }
            return c0129b2;
        }
        return c0129b22;
    }

    public final C0284h2 e() {
        return l().b;
    }

    public final A3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Rm a2 = Qm.a(C0587t3.class);
                    Context context = this.f1129a;
                    Sm sm = (Sm) a2;
                    ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                    this.k = new A3(this.f1129a, a3, new B3(), new C0463o3(), new E3(), new Ui(this.f1129a), new C3(y()), new C0488p3(), (C0587t3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f1129a;
    }

    public final F6 h() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new F6(new E6(y()));
                }
            }
        }
        return this.c;
    }

    public final N9 i() {
        N9 n9;
        N9 n92 = this.C;
        if (n92 == null) {
            synchronized (this) {
                n9 = this.C;
                if (n9 == null) {
                    n9 = new N9(this.f1129a);
                    this.C = n9;
                }
            }
            return n9;
        }
        return n92;
    }

    public final PermissionExtractor j() {
        C0630ul c0630ul = this.y;
        if (c0630ul != null) {
            return c0630ul;
        }
        synchronized (this) {
            C0630ul c0630ul2 = this.y;
            if (c0630ul2 != null) {
                return c0630ul2;
            }
            C0630ul c0630ul3 = new C0630ul(p().c.getAskForPermissionStrategy());
            this.y = c0630ul3;
            return c0630ul3;
        }
    }

    public final Gb l() {
        Gb gb;
        Gb gb2 = this.o;
        if (gb2 == null) {
            synchronized (this) {
                gb = this.o;
                if (gb == null) {
                    gb = new Gb(new P2(this.f1129a, this.d.a()), new C0284h2());
                    this.o = gb;
                }
            }
            return gb;
        }
        return gb2;
    }

    public final Lb m() {
        Lb lb;
        Lb lb2 = this.w;
        if (lb2 == null) {
            synchronized (this) {
                lb = this.w;
                if (lb == null) {
                    Context context = this.f1129a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    if (locationClient == null) {
                        lb = new Nb();
                    } else {
                        lb = new Mb(context, new Tb(), locationClient);
                    }
                    this.w = lb;
                }
            }
            return lb;
        }
        return lb2;
    }

    public final Lb n() {
        return m();
    }

    public final Vc o() {
        return this.t;
    }

    public final C0729yk p() {
        C0729yk c0729yk;
        C0729yk c0729yk2 = this.r;
        if (c0729yk2 == null) {
            synchronized (this) {
                c0729yk = this.r;
                if (c0729yk == null) {
                    c0729yk = new C0729yk();
                    this.r = c0729yk;
                }
            }
            return c0729yk;
        }
        return c0729yk2;
    }

    public final C0672wd q() {
        C0672wd c0672wd;
        C0672wd c0672wd2 = this.z;
        if (c0672wd2 == null) {
            synchronized (this) {
                c0672wd = this.z;
                if (c0672wd == null) {
                    c0672wd = new C0672wd(this.f1129a, new oo());
                    this.z = c0672wd;
                }
            }
            return c0672wd;
        }
        return c0672wd2;
    }

    public final Pd r() {
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

    public final C0624uf t() {
        E();
        return this.j;
    }

    public final C0426mg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0426mg(this.f1129a, I.D().c);
                }
            }
        }
        return this.b;
    }

    public final C0249fj v() {
        C0249fj c0249fj;
        C0249fj c0249fj2 = this.n;
        if (c0249fj2 == null) {
            synchronized (this) {
                c0249fj = this.n;
                if (c0249fj == null) {
                    c0249fj = new C0249fj(this.f1129a);
                    this.n = c0249fj;
                }
            }
            return c0249fj;
        }
        return c0249fj2;
    }

    public final C0405lk w() {
        return this.d;
    }

    public final C0704xk x() {
        return this.F;
    }

    public final C0116af y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0116af(B().d(this.f1129a));
                }
            }
        }
        return this.l;
    }

    public final synchronized L2 z() {
        if (this.p == null) {
            Bl bl = new Bl(this.f1129a);
            this.p = bl;
            this.u.a(bl);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

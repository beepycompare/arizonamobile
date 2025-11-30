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
public final class C0471oa {
    public static volatile C0471oa I;
    public volatile N9 C;
    public C0755zk H;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1046a;
    public volatile C0427mg b;
    public volatile F6 c;
    public volatile S2 e;
    public volatile C0455nj f;
    public volatile U g;
    public volatile C0130b2 h;
    public volatile PlatformIdentifiers i;
    public volatile C0625uf j;
    public volatile A3 k;
    public volatile C0117af l;
    public volatile Bo m;
    public volatile C0250fj n;
    public volatile Gb o;
    public Bl p;
    public volatile C0730yk r;
    public volatile Lb w;
    public volatile C0509pn x;
    public volatile C0631ul y;
    public volatile C0673wd z;
    public final C0446na q = new C0446na();
    public final Tc s = new Tc();
    public final Vc t = new Vc();
    public final C0330im u = new C0330im();
    public final C0251fk v = new C0251fk();
    public final Pd A = new Pd();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C0456nk D = new C0456nk();
    public final ReferenceHolder E = new ReferenceHolder();
    public final C0705xk F = new C0705xk();
    public final C0333j G = new C0333j();
    public final C0406lk d = new C0406lk();

    public C0471oa(Context context) {
        this.f1046a = context;
    }

    public static void a(Context context) {
        if (I == null) {
            synchronized (C0471oa.class) {
                if (I == null) {
                    I = new C0471oa(context.getApplicationContext());
                }
            }
        }
    }

    public static C0471oa k() {
        return I;
    }

    public final C0330im A() {
        return this.u;
    }

    public final C0755zk B() {
        C0755zk c0755zk;
        File file;
        C0755zk c0755zk2 = this.H;
        if (c0755zk2 == null) {
            synchronized (this) {
                c0755zk = this.H;
                if (c0755zk == null) {
                    Context context = this.f1046a;
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
                        c0755zk = new C0755zk(file);
                        this.H = c0755zk;
                    }
                    file = null;
                    c0755zk = new C0755zk(file);
                    this.H = c0755zk;
                }
            }
            return c0755zk;
        }
        return c0755zk2;
    }

    public final C0509pn C() {
        C0509pn c0509pn;
        C0509pn c0509pn2 = this.x;
        if (c0509pn2 == null) {
            synchronized (this) {
                c0509pn = this.x;
                if (c0509pn == null) {
                    c0509pn = new C0509pn(this.f1046a);
                    this.x = c0509pn;
                }
            }
            return c0509pn;
        }
        return c0509pn2;
    }

    public final synchronized Bo D() {
        if (this.m == null) {
            this.m = new Bo(this.f1046a);
        }
        return this.m;
    }

    public final void E() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    Rm a2 = Qm.a(C0220ef.class);
                    Context context = this.f1046a;
                    Sm sm = (Sm) a2;
                    ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                    C0220ef c0220ef = (C0220ef) a3.read();
                    this.j = new C0625uf(this.f1046a, a3, new C0401lf(), new C0169cf(c0220ef), new C0600tf(), new C0375kf(this.f1046a), new C0501pf(k().y()), new C0246ff(), c0220ef, "[PreloadInfoStorage]");
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
                    u = new U(this.f1046a, this.d.a(), this.u.b());
                    this.u.a(u);
                    this.g = u;
                }
            }
            return u;
        }
        return u2;
    }

    public final C0130b2 d() {
        C0130b2 c0130b2;
        C0130b2 c0130b22 = this.h;
        if (c0130b22 == null) {
            synchronized (this) {
                c0130b2 = this.h;
                if (c0130b2 == null) {
                    c0130b2 = new C0130b2(this.f1046a, AbstractC0156c2.a());
                    this.h = c0130b2;
                }
            }
            return c0130b2;
        }
        return c0130b22;
    }

    public final C0285h2 e() {
        return l().b;
    }

    public final A3 f() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    Rm a2 = Qm.a(C0588t3.class);
                    Context context = this.f1046a;
                    Sm sm = (Sm) a2;
                    ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                    this.k = new A3(this.f1046a, a3, new B3(), new C0464o3(), new E3(), new Ui(this.f1046a), new C3(y()), new C0489p3(), (C0588t3) a3.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context g() {
        return this.f1046a;
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
                    n9 = new N9(this.f1046a);
                    this.C = n9;
                }
            }
            return n9;
        }
        return n92;
    }

    public final PermissionExtractor j() {
        C0631ul c0631ul = this.y;
        if (c0631ul != null) {
            return c0631ul;
        }
        synchronized (this) {
            C0631ul c0631ul2 = this.y;
            if (c0631ul2 != null) {
                return c0631ul2;
            }
            C0631ul c0631ul3 = new C0631ul(p().c.getAskForPermissionStrategy());
            this.y = c0631ul3;
            return c0631ul3;
        }
    }

    public final Gb l() {
        Gb gb;
        Gb gb2 = this.o;
        if (gb2 == null) {
            synchronized (this) {
                gb = this.o;
                if (gb == null) {
                    gb = new Gb(new P2(this.f1046a, this.d.a()), new C0285h2());
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
                    Context context = this.f1046a;
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

    public final C0730yk p() {
        C0730yk c0730yk;
        C0730yk c0730yk2 = this.r;
        if (c0730yk2 == null) {
            synchronized (this) {
                c0730yk = this.r;
                if (c0730yk == null) {
                    c0730yk = new C0730yk();
                    this.r = c0730yk;
                }
            }
            return c0730yk;
        }
        return c0730yk2;
    }

    public final C0673wd q() {
        C0673wd c0673wd;
        C0673wd c0673wd2 = this.z;
        if (c0673wd2 == null) {
            synchronized (this) {
                c0673wd = this.z;
                if (c0673wd == null) {
                    c0673wd = new C0673wd(this.f1046a, new oo());
                    this.z = c0673wd;
                }
            }
            return c0673wd;
        }
        return c0673wd2;
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

    public final C0625uf t() {
        E();
        return this.j;
    }

    public final C0427mg u() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C0427mg(this.f1046a, I.D().c);
                }
            }
        }
        return this.b;
    }

    public final C0250fj v() {
        C0250fj c0250fj;
        C0250fj c0250fj2 = this.n;
        if (c0250fj2 == null) {
            synchronized (this) {
                c0250fj = this.n;
                if (c0250fj == null) {
                    c0250fj = new C0250fj(this.f1046a);
                    this.n = c0250fj;
                }
            }
            return c0250fj;
        }
        return c0250fj2;
    }

    public final C0406lk w() {
        return this.d;
    }

    public final C0705xk x() {
        return this.F;
    }

    public final C0117af y() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new C0117af(B().d(this.f1046a));
                }
            }
        }
        return this.l;
    }

    public final synchronized L2 z() {
        if (this.p == null) {
            Bl bl = new Bl(this.f1046a);
            this.p = bl;
            this.u.a(bl);
        }
        return this.p;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}

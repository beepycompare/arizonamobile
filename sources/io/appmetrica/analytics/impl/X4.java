package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public class X4 implements Pa, Ea, InterfaceC0355jh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f848a;
    public final Q4 b;
    public final We c;
    public final Ze d;
    public final L6 e;
    public final C0606ti f;
    public final X8 g;
    public final C0338j0 h;
    public final C0364k0 i;
    public final Rk j;
    public final Qg k;
    public final M8 l;
    public final PublicLogger m;
    public final C0373k9 n;
    public final S4 o;
    public final InterfaceC0523q9 p;
    public final C0417m3 q;
    public final TimePassedChecker r;
    public final C0603tf s;
    public final xo t;
    public final Jk u;
    public final C0491p2 v;

    public X4(Context context, C0257fm c0257fm, Q4 q4, C0468o4 c0468o4, InterfaceC0304hh interfaceC0304hh, V4 v4) {
        this(context, q4, new C0364k0(), new TimePassedChecker(), new C0163c5(context, q4, c0468o4, v4, c0257fm, interfaceC0304hh, C0449na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0449na.k().l(), new P4()), c0468o4);
    }

    public final boolean A() {
        C0381kh c0381kh = (C0381kh) this.k.a();
        return c0381kh.n && this.r.didTimePassSeconds(this.n.k, c0381kh.t, "should force send permissions");
    }

    public final boolean B() {
        C0257fm c0257fm;
        C0603tf c0603tf = this.s;
        c0603tf.h.a(c0603tf.f737a);
        boolean z = ((C0529qf) c0603tf.c()).d;
        Qg qg = this.k;
        synchronized (qg) {
            c0257fm = qg.c.f671a;
        }
        return !(z && c0257fm.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0257fm c0257fm) {
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final Q4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0338j0 c0338j0 = this.h;
        synchronized (c0338j0) {
            c0338j0.f1052a = new Fc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C0369k5) this.p).d();
    }

    public final C0491p2 f() {
        return this.v;
    }

    public final C0417m3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final Context getContext() {
        return this.f848a;
    }

    public final We h() {
        return this.c;
    }

    public final L6 i() {
        return this.e;
    }

    public final M8 j() {
        return this.l;
    }

    public final X8 k() {
        return this.g;
    }

    public final C0373k9 l() {
        return this.n;
    }

    public final InterfaceC0523q9 m() {
        return this.p;
    }

    public final C0381kh n() {
        return (C0381kh) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final Ze q() {
        return this.d;
    }

    public final Jk r() {
        return this.u;
    }

    public final Rk s() {
        return this.j;
    }

    public final C0257fm t() {
        C0257fm c0257fm;
        Qg qg = this.k;
        synchronized (qg) {
            c0257fm = qg.c.f671a;
        }
        return c0257fm;
    }

    public final xo u() {
        return this.t;
    }

    public final void v() {
        C0373k9 c0373k9 = this.n;
        int i = c0373k9.j;
        c0373k9.l = i;
        c0373k9.f1079a.a(i).b();
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        xo xoVar = this.t;
        synchronized (xoVar) {
            optInt = xoVar.f1312a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<T4> listOf = CollectionsKt.listOf(new U4(this));
            int intValue = valueOf.intValue();
            for (T4 t4 : listOf) {
                t4.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        C0381kh c0381kh = (C0381kh) this.k.a();
        return c0381kh.n && c0381kh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.k, c0381kh.s, "need to check permissions");
    }

    public final boolean y() {
        C0373k9 c0373k9 = this.n;
        return c0373k9.l < c0373k9.j && ((C0381kh) this.k.a()).o && ((C0381kh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        Qg qg = this.k;
        synchronized (qg) {
            qg.f1147a = null;
        }
    }

    public final void b(P5 p5) {
        this.h.a(p5.f);
        C0313i0 a2 = this.h.a();
        C0364k0 c0364k0 = this.i;
        We we = this.c;
        synchronized (c0364k0) {
            if (a2.b > we.d().b) {
                we.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f1035a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(P5 p5) {
        String a2 = Qf.a("Event received on service", EnumC0143bb.a(p5.d), p5.getName(), p5.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(p5, new C0581si());
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ea
    public synchronized void a(C0468o4 c0468o4) {
        long j;
        this.k.a(c0468o4);
        boolean z = false;
        if (Boolean.TRUE.equals(c0468o4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(c0468o4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0491p2 c0491p2 = this.v;
        Set<String> set = c0468o4.o;
        long currentTimeMillis = c0491p2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0491p2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0491p2.b) {
                c0491p2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0491p2.a(c0491p2.e);
            c0491p2.f1166a.a(c0491p2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public X4(Context context, Q4 q4, C0364k0 c0364k0, TimePassedChecker timePassedChecker, C0163c5 c0163c5, C0468o4 c0468o4) {
        this.f848a = context.getApplicationContext();
        this.b = q4;
        this.i = c0364k0;
        this.r = timePassedChecker;
        xo f = c0163c5.f();
        this.t = f;
        this.s = C0449na.k().t();
        We a2 = c0163c5.e().a();
        this.c = a2;
        this.v = c0163c5.a(a2);
        Qg a3 = c0163c5.a(this);
        this.k = a3;
        PublicLogger a4 = c0163c5.d().a();
        this.m = a4;
        this.d = C0449na.k().y();
        C0338j0 a5 = c0364k0.a(q4, a4, a2);
        this.h = a5;
        this.l = c0163c5.a();
        L6 b = c0163c5.b(this);
        this.e = b;
        C0656vi d = c0163c5.d(this);
        this.o = C0163c5.b();
        w();
        Rk a6 = C0163c5.a(this, f, new W4(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", q4.toString(), a5.a().f1035a);
        Jk c = c0163c5.c();
        this.u = c;
        this.n = c0163c5.a(a2, f, a6, b, a5, c, d);
        X8 c2 = C0163c5.c(this);
        this.g = c2;
        this.f = C0163c5.a(this, c2);
        this.q = c0163c5.b(a2);
        this.p = c0163c5.a(d, b, a3, c0468o4, q4, a2);
        b.d();
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ql
    public final synchronized void a(C0257fm c0257fm) {
        this.k.a(c0257fm);
        ((C0369k5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

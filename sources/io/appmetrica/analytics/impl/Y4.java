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
public class Y4 implements Qa, Fa, InterfaceC0376kh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f843a;
    public final R4 b;
    public final Xe c;
    public final C0116af d;
    public final M6 e;
    public final C0627ui f;
    public final Y8 g;
    public final C0333j0 h;
    public final C0359k0 i;
    public final Sk j;
    public final Rg k;
    public final N8 l;
    public final PublicLogger m;
    public final C0394l9 n;
    public final T4 o;
    public final InterfaceC0543r9 p;
    public final C0438n3 q;
    public final TimePassedChecker r;
    public final C0624uf s;
    public final yo t;
    public final Kk u;
    public final C0512q2 v;

    public Y4(Context context, C0278gm c0278gm, R4 r4, C0489p4 c0489p4, InterfaceC0324ih interfaceC0324ih, W4 w4) {
        this(context, r4, new C0359k0(), new TimePassedChecker(), new C0184d5(context, r4, c0489p4, w4, c0278gm, interfaceC0324ih, C0470oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0470oa.k().l(), new Q4()), c0489p4);
    }

    public final boolean A() {
        C0402lh c0402lh = (C0402lh) this.k.a();
        return c0402lh.n && this.r.didTimePassSeconds(this.n.k, c0402lh.t, "should force send permissions");
    }

    public final boolean B() {
        C0278gm c0278gm;
        C0624uf c0624uf = this.s;
        c0624uf.h.a(c0624uf.f732a);
        boolean z = ((C0549rf) c0624uf.c()).d;
        Rg rg = this.k;
        synchronized (rg) {
            c0278gm = rg.c.f666a;
        }
        return !(z && c0278gm.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Rl
    public final void a(Kl kl, C0278gm c0278gm) {
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final R4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0333j0 c0333j0 = this.h;
        synchronized (c0333j0) {
            c0333j0.f1030a = new Gc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C0390l5) this.p).d();
    }

    public final C0512q2 f() {
        return this.v;
    }

    public final C0438n3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final Context getContext() {
        return this.f843a;
    }

    public final Xe h() {
        return this.c;
    }

    public final M6 i() {
        return this.e;
    }

    public final N8 j() {
        return this.l;
    }

    public final Y8 k() {
        return this.g;
    }

    public final C0394l9 l() {
        return this.n;
    }

    public final InterfaceC0543r9 m() {
        return this.p;
    }

    public final C0402lh n() {
        return (C0402lh) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final C0116af q() {
        return this.d;
    }

    public final Kk r() {
        return this.u;
    }

    public final Sk s() {
        return this.j;
    }

    public final C0278gm t() {
        C0278gm c0278gm;
        Rg rg = this.k;
        synchronized (rg) {
            c0278gm = rg.c.f666a;
        }
        return c0278gm;
    }

    public final yo u() {
        return this.t;
    }

    public final void v() {
        C0394l9 c0394l9 = this.n;
        int i = c0394l9.j;
        c0394l9.l = i;
        c0394l9.f1074a.a(i).b();
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        yo yoVar = this.t;
        synchronized (yoVar) {
            optInt = yoVar.f1308a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<U4> listOf = CollectionsKt.listOf(new V4(this));
            int intValue = valueOf.intValue();
            for (U4 u4 : listOf) {
                u4.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        C0402lh c0402lh = (C0402lh) this.k.a();
        return c0402lh.n && c0402lh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.k, c0402lh.s, "need to check permissions");
    }

    public final boolean y() {
        C0394l9 c0394l9 = this.n;
        return c0394l9.l < c0394l9.j && ((C0402lh) this.k.a()).o && ((C0402lh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        Rg rg = this.k;
        synchronized (rg) {
            rg.f1143a = null;
        }
    }

    public final void b(Q5 q5) {
        this.h.a(q5.f);
        C0308i0 a2 = this.h.a();
        C0359k0 c0359k0 = this.i;
        Xe xe = this.c;
        synchronized (c0359k0) {
            if (a2.b > xe.d().b) {
                xe.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f1014a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Q5 q5) {
        String a2 = Rf.a("Event received on service", EnumC0164cb.a(q5.d), q5.getName(), q5.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(q5, new C0602ti());
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Fa
    public synchronized void a(C0489p4 c0489p4) {
        long j;
        this.k.a(c0489p4);
        boolean z = false;
        if (Boolean.TRUE.equals(c0489p4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(c0489p4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0512q2 c0512q2 = this.v;
        Set<String> set = c0489p4.o;
        long currentTimeMillis = c0512q2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0512q2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0512q2.b) {
                c0512q2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0512q2.a(c0512q2.e);
            c0512q2.f1162a.a(c0512q2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public Y4(Context context, R4 r4, C0359k0 c0359k0, TimePassedChecker timePassedChecker, C0184d5 c0184d5, C0489p4 c0489p4) {
        this.f843a = context.getApplicationContext();
        this.b = r4;
        this.i = c0359k0;
        this.r = timePassedChecker;
        yo f = c0184d5.f();
        this.t = f;
        this.s = C0470oa.k().t();
        Xe a2 = c0184d5.e().a();
        this.c = a2;
        this.v = c0184d5.a(a2);
        Rg a3 = c0184d5.a(this);
        this.k = a3;
        PublicLogger a4 = c0184d5.d().a();
        this.m = a4;
        this.d = C0470oa.k().y();
        C0333j0 a5 = c0359k0.a(r4, a4, a2);
        this.h = a5;
        this.l = c0184d5.a();
        M6 b = c0184d5.b(this);
        this.e = b;
        C0677wi d = c0184d5.d(this);
        this.o = C0184d5.b();
        w();
        Sk a6 = C0184d5.a(this, f, new X4(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", r4.toString(), a5.a().f1014a);
        Kk c = c0184d5.c();
        this.u = c;
        this.n = c0184d5.a(a2, f, a6, b, a5, c, d);
        Y8 c2 = C0184d5.c(this);
        this.g = c2;
        this.f = C0184d5.a(this, c2);
        this.q = c0184d5.b(a2);
        this.p = c0184d5.a(d, b, a3, c0489p4, r4, a2);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Rl
    public final synchronized void a(C0278gm c0278gm) {
        this.k.a(c0278gm);
        ((C0390l5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

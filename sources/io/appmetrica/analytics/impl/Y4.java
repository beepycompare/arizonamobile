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
public class Y4 implements Qa, Fa, InterfaceC0377kh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f760a;
    public final R4 b;
    public final Xe c;
    public final C0117af d;
    public final M6 e;
    public final C0628ui f;
    public final Y8 g;
    public final C0334j0 h;
    public final C0360k0 i;
    public final Sk j;
    public final Rg k;
    public final N8 l;
    public final PublicLogger m;
    public final C0395l9 n;
    public final T4 o;
    public final InterfaceC0544r9 p;
    public final C0439n3 q;
    public final TimePassedChecker r;
    public final C0625uf s;
    public final yo t;
    public final Kk u;
    public final C0513q2 v;

    public Y4(Context context, C0279gm c0279gm, R4 r4, C0490p4 c0490p4, InterfaceC0325ih interfaceC0325ih, W4 w4) {
        this(context, r4, new C0360k0(), new TimePassedChecker(), new C0185d5(context, r4, c0490p4, w4, c0279gm, interfaceC0325ih, C0471oa.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0471oa.k().l(), new Q4()), c0490p4);
    }

    public final boolean A() {
        C0403lh c0403lh = (C0403lh) this.k.a();
        return c0403lh.n && this.r.didTimePassSeconds(this.n.k, c0403lh.t, "should force send permissions");
    }

    public final boolean B() {
        C0279gm c0279gm;
        C0625uf c0625uf = this.s;
        c0625uf.h.a(c0625uf.f649a);
        boolean z = ((C0550rf) c0625uf.c()).d;
        Rg rg = this.k;
        synchronized (rg) {
            c0279gm = rg.c.f583a;
        }
        return !(z && c0279gm.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Rl
    public final void a(Kl kl, C0279gm c0279gm) {
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final R4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0334j0 c0334j0 = this.h;
        synchronized (c0334j0) {
            c0334j0.f947a = new Gc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C0391l5) this.p).d();
    }

    public final C0513q2 f() {
        return this.v;
    }

    public final C0439n3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final Context getContext() {
        return this.f760a;
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

    public final C0395l9 l() {
        return this.n;
    }

    public final InterfaceC0544r9 m() {
        return this.p;
    }

    public final C0403lh n() {
        return (C0403lh) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final C0117af q() {
        return this.d;
    }

    public final Kk r() {
        return this.u;
    }

    public final Sk s() {
        return this.j;
    }

    public final C0279gm t() {
        C0279gm c0279gm;
        Rg rg = this.k;
        synchronized (rg) {
            c0279gm = rg.c.f583a;
        }
        return c0279gm;
    }

    public final yo u() {
        return this.t;
    }

    public final void v() {
        C0395l9 c0395l9 = this.n;
        int i = c0395l9.j;
        c0395l9.l = i;
        c0395l9.f991a.a(i).b();
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        yo yoVar = this.t;
        synchronized (yoVar) {
            optInt = yoVar.f1225a.a().optInt("last_migration_api_level", 0);
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
        C0403lh c0403lh = (C0403lh) this.k.a();
        return c0403lh.n && c0403lh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.k, c0403lh.s, "need to check permissions");
    }

    public final boolean y() {
        C0395l9 c0395l9 = this.n;
        return c0395l9.l < c0395l9.j && ((C0403lh) this.k.a()).o && ((C0403lh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        Rg rg = this.k;
        synchronized (rg) {
            rg.f1060a = null;
        }
    }

    public final void b(Q5 q5) {
        this.h.a(q5.f);
        C0309i0 a2 = this.h.a();
        C0360k0 c0360k0 = this.i;
        Xe xe = this.c;
        synchronized (c0360k0) {
            if (a2.b > xe.d().b) {
                xe.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f931a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Q5 q5) {
        String a2 = Rf.a("Event received on service", EnumC0165cb.a(q5.d), q5.getName(), q5.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(q5, new C0603ti());
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Fa
    public synchronized void a(C0490p4 c0490p4) {
        long j;
        this.k.a(c0490p4);
        boolean z = false;
        if (Boolean.TRUE.equals(c0490p4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(c0490p4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0513q2 c0513q2 = this.v;
        Set<String> set = c0490p4.o;
        long currentTimeMillis = c0513q2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0513q2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0513q2.b) {
                c0513q2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0513q2.a(c0513q2.e);
            c0513q2.f1079a.a(c0513q2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public Y4(Context context, R4 r4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0185d5 c0185d5, C0490p4 c0490p4) {
        this.f760a = context.getApplicationContext();
        this.b = r4;
        this.i = c0360k0;
        this.r = timePassedChecker;
        yo f = c0185d5.f();
        this.t = f;
        this.s = C0471oa.k().t();
        Xe a2 = c0185d5.e().a();
        this.c = a2;
        this.v = c0185d5.a(a2);
        Rg a3 = c0185d5.a(this);
        this.k = a3;
        PublicLogger a4 = c0185d5.d().a();
        this.m = a4;
        this.d = C0471oa.k().y();
        C0334j0 a5 = c0360k0.a(r4, a4, a2);
        this.h = a5;
        this.l = c0185d5.a();
        M6 b = c0185d5.b(this);
        this.e = b;
        C0678wi d = c0185d5.d(this);
        this.o = C0185d5.b();
        w();
        Sk a6 = C0185d5.a(this, f, new X4(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", r4.toString(), a5.a().f931a);
        Kk c = c0185d5.c();
        this.u = c;
        this.n = c0185d5.a(a2, f, a6, b, a5, c, d);
        Y8 c2 = C0185d5.c(this);
        this.g = c2;
        this.f = C0185d5.a(this, c2);
        this.q = c0185d5.b(a2);
        this.p = c0185d5.a(d, b, a3, c0490p4, r4, a2);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.Qa, io.appmetrica.analytics.impl.Rl
    public final synchronized void a(C0279gm c0279gm) {
        this.k.a(c0279gm);
        ((C0391l5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

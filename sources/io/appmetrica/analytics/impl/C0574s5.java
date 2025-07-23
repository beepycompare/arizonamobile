package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.s5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0574s5 implements InterfaceC0381kb, Za, InterfaceC0686wh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1048a;
    public final C0400l5 b;
    public final C0385kf c;
    public final C0460nf d;
    public final C0278g7 e;
    public final Gi f;
    public final C0578s9 g;
    public final C0296h0 h;
    public final C0321i0 i;
    public final Sk j;
    public final C0211dh k;
    public final C0254f9 l;
    public final PublicLogger m;
    public final F9 n;
    public final C0450n5 o;
    public final L9 p;
    public final I3 q;
    public final TimePassedChecker r;
    public final Hf s;
    public final uo t;
    public final Kk u;

    public C0574s5(Context context, C0267fm c0267fm, C0400l5 c0400l5, J4 j4, InterfaceC0636uh interfaceC0636uh, AbstractC0525q5 abstractC0525q5) {
        this(context, c0400l5, new C0321i0(), new TimePassedChecker(), new C0699x5(context, c0400l5, j4, abstractC0525q5, c0267fm, interfaceC0636uh, Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().k(), new C0375k5()), j4);
    }

    public final boolean A() {
        C0267fm c0267fm;
        Hf hf = this.s;
        hf.h.a(hf.f897a);
        boolean z = ((Ef) hf.c()).d;
        C0211dh c0211dh = this.k;
        synchronized (c0211dh) {
            c0267fm = c0211dh.c.f878a;
        }
        return !(z && c0267fm.q);
    }

    public void B() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0267fm c0267fm) {
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final C0400l5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0296h0 c0296h0 = this.h;
        synchronized (c0296h0) {
            c0296h0.f873a = new C0129ad();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((F5) this.p).d();
    }

    public final I3 f() {
        return this.q;
    }

    public final C0385kf g() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Context getContext() {
        return this.f1048a;
    }

    public final C0278g7 h() {
        return this.e;
    }

    public final C0254f9 i() {
        return this.l;
    }

    public final C0578s9 j() {
        return this.g;
    }

    public final F9 k() {
        return this.n;
    }

    public final L9 l() {
        return this.p;
    }

    public final C0711xh m() {
        return (C0711xh) this.k.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.m;
    }

    public final C0460nf p() {
        return this.d;
    }

    public final Kk q() {
        return this.u;
    }

    public final Sk r() {
        return this.j;
    }

    public final C0267fm s() {
        C0267fm c0267fm;
        C0211dh c0211dh = this.k;
        synchronized (c0211dh) {
            c0267fm = c0211dh.c.f878a;
        }
        return c0267fm;
    }

    public final uo t() {
        return this.t;
    }

    public final void u() {
        F9 f9 = this.n;
        int i = f9.k;
        f9.m = i;
        f9.f434a.a(i).b();
    }

    public final void v() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        uo uoVar = this.t;
        synchronized (uoVar) {
            optInt = uoVar.f1091a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0475o5> listOf = CollectionsKt.listOf(new C0500p5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0475o5 abstractC0475o5 : listOf) {
                abstractC0475o5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean w() {
        C0711xh c0711xh = (C0711xh) this.k.a();
        return c0711xh.n && c0711xh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, c0711xh.s, "need to check permissions");
    }

    public final boolean x() {
        F9 f9 = this.n;
        return f9.m < f9.k && ((C0711xh) this.k.a()).o && ((C0711xh) this.k.a()).isIdentifiersValid();
    }

    public final void y() {
        C0211dh c0211dh = this.k;
        synchronized (c0211dh) {
            c0211dh.f498a = null;
        }
    }

    public final boolean z() {
        C0711xh c0711xh = (C0711xh) this.k.a();
        return c0711xh.n && this.r.didTimePassSeconds(this.n.l, c0711xh.t, "should force send permissions");
    }

    public final void b(C0401l6 c0401l6) {
        this.h.a(c0401l6.f);
        C0271g0 a2 = this.h.a();
        C0321i0 c0321i0 = this.i;
        C0385kf c0385kf = this.c;
        synchronized (c0321i0) {
            if (a2.b > c0385kf.d().b) {
                c0385kf.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f855a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kb
    public final void a(C0401l6 c0401l6) {
        String a2 = AbstractC0210dg.a("Event received on service", EnumC0680wb.a(c0401l6.d), c0401l6.getName(), c0401l6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0401l6, new Fi());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Za
    public synchronized void a(J4 j4) {
        this.k.a(j4);
        if (Boolean.TRUE.equals(j4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(j4.h)) {
                this.m.setEnabled(false);
            }
        }
    }

    public C0574s5(Context context, C0400l5 c0400l5, C0321i0 c0321i0, TimePassedChecker timePassedChecker, C0699x5 c0699x5, J4 j4) {
        this.f1048a = context.getApplicationContext();
        this.b = c0400l5;
        this.i = c0321i0;
        this.r = timePassedChecker;
        uo f = c0699x5.f();
        this.t = f;
        this.s = Ia.j().s();
        C0211dh a2 = c0699x5.a(this);
        this.k = a2;
        PublicLogger a3 = c0699x5.d().a();
        this.m = a3;
        C0385kf a4 = c0699x5.e().a();
        this.c = a4;
        this.d = Ia.j().x();
        C0296h0 a5 = c0321i0.a(c0400l5, a3, a4);
        this.h = a5;
        this.l = c0699x5.a();
        C0278g7 b = c0699x5.b(this);
        this.e = b;
        Ii d = c0699x5.d(this);
        this.o = C0699x5.b();
        v();
        Sk a6 = C0699x5.a(this, f, new C0549r5(this));
        this.j = a6;
        a3.info("Read app environment for component %s. Value: %s", c0400l5.toString(), a5.a().f855a);
        Kk c = c0699x5.c();
        this.u = c;
        this.n = c0699x5.a(a4, f, a6, b, a5, c, d);
        C0578s9 c2 = C0699x5.c(this);
        this.g = c2;
        this.f = C0699x5.a(this, c2);
        this.q = c0699x5.a(a4);
        this.p = c0699x5.a(d, b, a2, j4, c0400l5, a4);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Ql
    public synchronized void a(C0267fm c0267fm) {
        this.k.a(c0267fm);
        ((F5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

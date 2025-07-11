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
public class C0572s5 implements InterfaceC0330ib, Xa, InterfaceC0634uh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1038a;
    public final C0398l5 b;
    public final Cif c;
    public final C0408lf d;
    public final C0201d7 e;
    public final Di f;
    public final C0502p9 g;
    public final C0294h0 h;
    public final C0319i0 i;
    public final Pk j;
    public final C0159bh k;
    public final C0177c9 l;
    public final PublicLogger m;
    public final C9 n;
    public final C0448n5 o;
    public final I9 p;
    public final I3 q;
    public final TimePassedChecker r;
    public final Ff s;
    public final ro t;
    public final Hk u;

    public C0572s5(Context context, C0190cm c0190cm, C0398l5 c0398l5, J4 j4, InterfaceC0584sh interfaceC0584sh, AbstractC0523q5 abstractC0523q5) {
        this(context, c0398l5, new C0319i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0190cm, interfaceC0584sh, Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().k(), new C0373k5()), j4);
    }

    public final boolean A() {
        C0190cm c0190cm;
        Ff ff = this.s;
        ff.h.a(ff.f834a);
        boolean z = ((Cf) ff.c()).d;
        C0159bh c0159bh = this.k;
        synchronized (c0159bh) {
            c0190cm = c0159bh.c.f817a;
        }
        return !(z && c0190cm.q);
    }

    public void B() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Nl
    public final void a(Gl gl, C0190cm c0190cm) {
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final C0398l5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0294h0 c0294h0 = this.h;
        synchronized (c0294h0) {
            c0294h0.f860a = new Yc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((D5) this.p).d();
    }

    public final I3 f() {
        return this.q;
    }

    public final Cif g() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final Context getContext() {
        return this.f1038a;
    }

    public final C0201d7 h() {
        return this.e;
    }

    public final C0177c9 i() {
        return this.l;
    }

    public final C0502p9 j() {
        return this.g;
    }

    public final C9 k() {
        return this.n;
    }

    public final I9 l() {
        return this.p;
    }

    public final C0659vh m() {
        return (C0659vh) this.k.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.m;
    }

    public final C0408lf p() {
        return this.d;
    }

    public final Hk q() {
        return this.u;
    }

    public final Pk r() {
        return this.j;
    }

    public final C0190cm s() {
        C0190cm c0190cm;
        C0159bh c0159bh = this.k;
        synchronized (c0159bh) {
            c0190cm = c0159bh.c.f817a;
        }
        return c0190cm;
    }

    public final ro t() {
        return this.t;
    }

    public final void u() {
        C9 c9 = this.n;
        int i = c9.k;
        c9.m = i;
        c9.f371a.a(i).b();
    }

    public final void v() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        ro roVar = this.t;
        synchronized (roVar) {
            optInt = roVar.f1034a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0473o5> listOf = CollectionsKt.listOf(new C0498p5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0473o5 abstractC0473o5 : listOf) {
                abstractC0473o5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean w() {
        C0659vh c0659vh = (C0659vh) this.k.a();
        return c0659vh.n && c0659vh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, c0659vh.s, "need to check permissions");
    }

    public final boolean x() {
        C9 c9 = this.n;
        return c9.m < c9.k && ((C0659vh) this.k.a()).o && ((C0659vh) this.k.a()).isIdentifiersValid();
    }

    public final void y() {
        C0159bh c0159bh = this.k;
        synchronized (c0159bh) {
            c0159bh.f456a = null;
        }
    }

    public final boolean z() {
        C0659vh c0659vh = (C0659vh) this.k.a();
        return c0659vh.n && this.r.didTimePassSeconds(this.n.l, c0659vh.t, "should force send permissions");
    }

    public final void b(C0325i6 c0325i6) {
        this.h.a(c0325i6.f);
        C0269g0 a2 = this.h.a();
        C0319i0 c0319i0 = this.i;
        Cif cif = this.c;
        synchronized (c0319i0) {
            if (a2.b > cif.d().b) {
                cif.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f847a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0330ib
    public final void a(C0325i6 c0325i6) {
        String a2 = AbstractC0158bg.a("Event received on service", EnumC0628ub.a(c0325i6.d), c0325i6.getName(), c0325i6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0325i6, new Ci());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Xa
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

    public C0572s5(Context context, C0398l5 c0398l5, C0319i0 c0319i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, J4 j4) {
        this.f1038a = context.getApplicationContext();
        this.b = c0398l5;
        this.i = c0319i0;
        this.r = timePassedChecker;
        ro f = c0697x5.f();
        this.t = f;
        this.s = Ga.j().s();
        C0159bh a2 = c0697x5.a(this);
        this.k = a2;
        PublicLogger a3 = c0697x5.d().a();
        this.m = a3;
        Cif a4 = c0697x5.e().a();
        this.c = a4;
        this.d = Ga.j().x();
        C0294h0 a5 = c0319i0.a(c0398l5, a3, a4);
        this.h = a5;
        this.l = c0697x5.a();
        C0201d7 b = c0697x5.b(this);
        this.e = b;
        Fi d = c0697x5.d(this);
        this.o = C0697x5.b();
        v();
        Pk a6 = C0697x5.a(this, f, new C0547r5(this));
        this.j = a6;
        a3.info("Read app environment for component %s. Value: %s", c0398l5.toString(), a5.a().f847a);
        Hk c = c0697x5.c();
        this.u = c;
        this.n = c0697x5.a(a4, f, a6, b, a5, c, d);
        C0502p9 c2 = C0697x5.c(this);
        this.g = c2;
        this.f = C0697x5.a(this, c2);
        this.q = c0697x5.a(a4);
        this.p = c0697x5.a(d, b, a2, j4, c0398l5, a4);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Nl
    public synchronized void a(C0190cm c0190cm) {
        this.k.a(c0190cm);
        ((D5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

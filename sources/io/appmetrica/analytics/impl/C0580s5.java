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
public class C0580s5 implements InterfaceC0338ib, Xa, InterfaceC0642uh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1037a;
    public final C0406l5 b;
    public final Cif c;
    public final C0416lf d;
    public final C0209d7 e;
    public final Di f;
    public final C0510p9 g;
    public final C0302h0 h;
    public final C0327i0 i;
    public final Pk j;
    public final C0167bh k;
    public final C0185c9 l;
    public final PublicLogger m;
    public final C9 n;
    public final C0456n5 o;
    public final I9 p;
    public final I3 q;
    public final TimePassedChecker r;
    public final Ff s;
    public final ro t;
    public final Hk u;

    public C0580s5(Context context, C0198cm c0198cm, C0406l5 c0406l5, J4 j4, InterfaceC0592sh interfaceC0592sh, AbstractC0531q5 abstractC0531q5) {
        this(context, c0406l5, new C0327i0(), new TimePassedChecker(), new C0705x5(context, c0406l5, j4, abstractC0531q5, c0198cm, interfaceC0592sh, Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().k(), new C0381k5()), j4);
    }

    public final boolean A() {
        C0198cm c0198cm;
        Ff ff = this.s;
        ff.h.a(ff.f833a);
        boolean z = ((Cf) ff.c()).d;
        C0167bh c0167bh = this.k;
        synchronized (c0167bh) {
            c0198cm = c0167bh.c.f816a;
        }
        return !(z && c0198cm.q);
    }

    public void B() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0338ib, io.appmetrica.analytics.impl.Nl
    public final void a(Gl gl, C0198cm c0198cm) {
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final C0406l5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0302h0 c0302h0 = this.h;
        synchronized (c0302h0) {
            c0302h0.f859a = new Yc();
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
        return this.f1037a;
    }

    public final C0209d7 h() {
        return this.e;
    }

    public final C0185c9 i() {
        return this.l;
    }

    public final C0510p9 j() {
        return this.g;
    }

    public final C9 k() {
        return this.n;
    }

    public final I9 l() {
        return this.p;
    }

    public final C0667vh m() {
        return (C0667vh) this.k.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.m;
    }

    public final C0416lf p() {
        return this.d;
    }

    public final Hk q() {
        return this.u;
    }

    public final Pk r() {
        return this.j;
    }

    public final C0198cm s() {
        C0198cm c0198cm;
        C0167bh c0167bh = this.k;
        synchronized (c0167bh) {
            c0198cm = c0167bh.c.f816a;
        }
        return c0198cm;
    }

    public final ro t() {
        return this.t;
    }

    public final void u() {
        C9 c9 = this.n;
        int i = c9.k;
        c9.m = i;
        c9.f370a.a(i).b();
    }

    public final void v() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        ro roVar = this.t;
        synchronized (roVar) {
            optInt = roVar.f1033a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0481o5> listOf = CollectionsKt.listOf(new C0506p5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0481o5 abstractC0481o5 : listOf) {
                abstractC0481o5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean w() {
        C0667vh c0667vh = (C0667vh) this.k.a();
        return c0667vh.n && c0667vh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, c0667vh.s, "need to check permissions");
    }

    public final boolean x() {
        C9 c9 = this.n;
        return c9.m < c9.k && ((C0667vh) this.k.a()).o && ((C0667vh) this.k.a()).isIdentifiersValid();
    }

    public final void y() {
        C0167bh c0167bh = this.k;
        synchronized (c0167bh) {
            c0167bh.f455a = null;
        }
    }

    public final boolean z() {
        C0667vh c0667vh = (C0667vh) this.k.a();
        return c0667vh.n && this.r.didTimePassSeconds(this.n.l, c0667vh.t, "should force send permissions");
    }

    public final void b(C0333i6 c0333i6) {
        this.h.a(c0333i6.f);
        C0277g0 a2 = this.h.a();
        C0327i0 c0327i0 = this.i;
        Cif cif = this.c;
        synchronized (c0327i0) {
            if (a2.b > cif.d().b) {
                cif.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f846a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0338ib
    public final void a(C0333i6 c0333i6) {
        String a2 = AbstractC0166bg.a("Event received on service", EnumC0636ub.a(c0333i6.d), c0333i6.getName(), c0333i6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0333i6, new Ci());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0338ib, io.appmetrica.analytics.impl.Xa
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

    public C0580s5(Context context, C0406l5 c0406l5, C0327i0 c0327i0, TimePassedChecker timePassedChecker, C0705x5 c0705x5, J4 j4) {
        this.f1037a = context.getApplicationContext();
        this.b = c0406l5;
        this.i = c0327i0;
        this.r = timePassedChecker;
        ro f = c0705x5.f();
        this.t = f;
        this.s = Ga.j().s();
        C0167bh a2 = c0705x5.a(this);
        this.k = a2;
        PublicLogger a3 = c0705x5.d().a();
        this.m = a3;
        Cif a4 = c0705x5.e().a();
        this.c = a4;
        this.d = Ga.j().x();
        C0302h0 a5 = c0327i0.a(c0406l5, a3, a4);
        this.h = a5;
        this.l = c0705x5.a();
        C0209d7 b = c0705x5.b(this);
        this.e = b;
        Fi d = c0705x5.d(this);
        this.o = C0705x5.b();
        v();
        Pk a6 = C0705x5.a(this, f, new C0555r5(this));
        this.j = a6;
        a3.info("Read app environment for component %s. Value: %s", c0406l5.toString(), a5.a().f846a);
        Hk c = c0705x5.c();
        this.u = c;
        this.n = c0705x5.a(a4, f, a6, b, a5, c, d);
        C0510p9 c2 = C0705x5.c(this);
        this.g = c2;
        this.f = C0705x5.a(this, c2);
        this.q = c0705x5.a(a4);
        this.p = c0705x5.a(d, b, a2, j4, c0406l5, a4);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0338ib, io.appmetrica.analytics.impl.Nl
    public synchronized void a(C0198cm c0198cm) {
        this.k.a(c0198cm);
        ((D5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

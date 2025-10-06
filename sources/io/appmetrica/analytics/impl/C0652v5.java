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
/* renamed from: io.appmetrica.analytics.impl.v5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0652v5 implements InterfaceC0509pb, InterfaceC0224eb, Fh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1120a;
    public final C0477o5 b;
    public final C0538qf c;
    public final C0612tf d;
    public final C0375k7 e;
    public final Pi f;
    public final C0706x9 g;
    public final C0317i0 h;
    public final C0342j0 i;
    public final C0157bl j;
    public final C0437mh k;
    public final C0377k9 l;
    public final PublicLogger m;
    public final K9 n;
    public final C0528q5 o;
    public final Q9 p;
    public final L3 q;
    public final TimePassedChecker r;
    public final Nf s;
    public final Do t;
    public final Tk u;
    public final C0674w2 v;

    public C0652v5(Context context, C0494om c0494om, C0477o5 c0477o5, M4 m4, Dh dh, AbstractC0602t5 abstractC0602t5) {
        this(context, c0477o5, new C0342j0(), new TimePassedChecker(), new A5(context, c0477o5, m4, abstractC0602t5, c0494om, dh, Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().k(), new C0451n5()), m4);
    }

    public final boolean A() {
        Gh gh = (Gh) this.k.a();
        return gh.n && this.r.didTimePassSeconds(this.n.l, gh.t, "should force send permissions");
    }

    public final boolean B() {
        C0494om c0494om;
        Nf nf = this.s;
        nf.h.a(nf.f1003a);
        boolean z = ((Kf) nf.c()).d;
        C0437mh c0437mh = this.k;
        synchronized (c0437mh) {
            c0494om = c0437mh.c.f950a;
        }
        return !(z && c0494om.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.Zl
    public final void a(Sl sl, C0494om c0494om) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0224eb
    public final C0477o5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0317i0 c0317i0 = this.h;
        synchronized (c0317i0) {
            c0317i0.f915a = new C0252fd();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((I5) this.p).d();
    }

    public final C0674w2 f() {
        return this.v;
    }

    public final L3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0224eb
    public final Context getContext() {
        return this.f1120a;
    }

    public final C0538qf h() {
        return this.c;
    }

    public final C0375k7 i() {
        return this.e;
    }

    public final C0377k9 j() {
        return this.l;
    }

    public final C0706x9 k() {
        return this.g;
    }

    public final K9 l() {
        return this.n;
    }

    public final Q9 m() {
        return this.p;
    }

    public final Gh n() {
        return (Gh) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final C0612tf q() {
        return this.d;
    }

    public final Tk r() {
        return this.u;
    }

    public final C0157bl s() {
        return this.j;
    }

    public final C0494om t() {
        C0494om c0494om;
        C0437mh c0437mh = this.k;
        synchronized (c0437mh) {
            c0494om = c0437mh.c.f950a;
        }
        return c0494om;
    }

    public final Do u() {
        return this.t;
    }

    public final void v() {
        K9 k9 = this.n;
        int i = k9.k;
        k9.m = i;
        k9.f537a.a(i).b();
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        Do r1 = this.t;
        synchronized (r1) {
            optInt = r1.f418a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0552r5> listOf = CollectionsKt.listOf(new C0577s5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0552r5 abstractC0552r5 : listOf) {
                abstractC0552r5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        Gh gh = (Gh) this.k.a();
        return gh.n && gh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, gh.s, "need to check permissions");
    }

    public final boolean y() {
        K9 k9 = this.n;
        return k9.m < k9.k && ((Gh) this.k.a()).o && ((Gh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        C0437mh c0437mh = this.k;
        synchronized (c0437mh) {
            c0437mh.f572a = null;
        }
    }

    public final void b(C0478o6 c0478o6) {
        this.h.a(c0478o6.f);
        C0291h0 a2 = this.h.a();
        C0342j0 c0342j0 = this.i;
        C0538qf c0538qf = this.c;
        synchronized (c0342j0) {
            if (a2.b > c0538qf.d().b) {
                c0538qf.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f903a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0509pb
    public final void a(C0478o6 c0478o6) {
        String a2 = AbstractC0436mg.a("Event received on service", Bb.a(c0478o6.d), c0478o6.getName(), c0478o6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0478o6, new Oi());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.InterfaceC0224eb
    public synchronized void a(M4 m4) {
        long j;
        this.k.a(m4);
        boolean z = false;
        if (Boolean.TRUE.equals(m4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(m4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0674w2 c0674w2 = this.v;
        Set<String> set = m4.o;
        long currentTimeMillis = c0674w2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0674w2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0674w2.b) {
                c0674w2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0674w2.a(c0674w2.e);
            c0674w2.f1135a.a(c0674w2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public C0652v5(Context context, C0477o5 c0477o5, C0342j0 c0342j0, TimePassedChecker timePassedChecker, A5 a5, M4 m4) {
        this.f1120a = context.getApplicationContext();
        this.b = c0477o5;
        this.i = c0342j0;
        this.r = timePassedChecker;
        Do f = a5.f();
        this.t = f;
        this.s = Na.j().s();
        C0538qf a2 = a5.e().a();
        this.c = a2;
        this.v = a5.a(a2);
        C0437mh a3 = a5.a(this);
        this.k = a3;
        PublicLogger a4 = a5.d().a();
        this.m = a4;
        this.d = Na.j().x();
        C0317i0 a6 = c0342j0.a(c0477o5, a4, a2);
        this.h = a6;
        this.l = a5.a();
        C0375k7 b = a5.b(this);
        this.e = b;
        Ri d = a5.d(this);
        this.o = A5.b();
        w();
        C0157bl a7 = A5.a(this, f, new C0627u5(this));
        this.j = a7;
        a4.info("Read app environment for component %s. Value: %s", c0477o5.toString(), a6.a().f903a);
        Tk c = a5.c();
        this.u = c;
        this.n = a5.a(a2, f, a7, b, a6, c, d);
        C0706x9 c2 = A5.c(this);
        this.g = c2;
        this.f = A5.a(this, c2);
        this.q = a5.b(a2);
        this.p = a5.a(d, b, a3, m4, c0477o5, a2);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.Zl
    public synchronized void a(C0494om c0494om) {
        this.k.a(c0494om);
        ((I5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

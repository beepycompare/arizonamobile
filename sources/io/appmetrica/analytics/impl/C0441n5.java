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
/* renamed from: io.appmetrica.analytics.impl.n5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0441n5 implements InterfaceC0447nb, InterfaceC0266gb, Dh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1114a;
    public final C0260g5 b;
    public final C0684wf c;
    public final C0762zf d;
    public final C0159c7 e;
    public final Ni f;
    public final C0548r9 g;
    public final C0384l0 h;
    public final C0410m0 i;
    public final C0664vl j;
    public final C0272gh k;
    public final C0264g9 l;
    public final PublicLogger m;
    public final E9 n;
    public final C0312i5 o;
    public final K9 p;
    public final D3 q;
    public final TimePassedChecker r;
    public final Tf s;
    public final ap t;
    public final C0431ml u;
    public final C2 v;

    public C0441n5(Context context, Hm hm, C0260g5 c0260g5, F4 f4, Bh bh, AbstractC0389l5 abstractC0389l5) {
        this(context, c0260g5, new C0410m0(), new TimePassedChecker(), new C0570s5(context, c0260g5, f4, abstractC0389l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), new C0234f5()), f4);
    }

    public final boolean A() {
        Eh eh = (Eh) this.k.a();
        return eh.n && this.r.didTimePassSeconds(this.n.k, eh.t, "should force send permissions");
    }

    public final boolean B() {
        Hm hm;
        Tf tf = this.s;
        tf.h.a(tf.f1014a);
        boolean z = ((Qf) tf.c()).d;
        C0272gh c0272gh = this.k;
        synchronized (c0272gh) {
            hm = c0272gh.c.f907a;
        }
        return !(z && hm.q);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0447nb, io.appmetrica.analytics.impl.InterfaceC0587sm
    public final void a(EnumC0406lm enumC0406lm, Hm hm) {
    }

    public final void b(C0235f6 c0235f6) {
        this.h.a(c0235f6.f);
        C0358k0 a2 = this.h.a();
        C0410m0 c0410m0 = this.i;
        C0684wf c0684wf = this.c;
        synchronized (c0410m0) {
            if (a2.b > c0684wf.d().b) {
                c0684wf.a(a2);
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f1064a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final void c() {
        bp bpVar = this.t.f899a;
        bp.a(bpVar.f919a);
        bp.a(bpVar.b);
        this.e.j.b.flushAsync();
    }

    public final void d() {
        C0384l0 c0384l0 = this.h;
        synchronized (c0384l0) {
            c0384l0.f1077a = new C0268gd();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((A5) this.p).d();
    }

    public final C2 f() {
        return this.v;
    }

    public final D3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final Context getContext() {
        return this.f1114a;
    }

    public final C0684wf h() {
        return this.c;
    }

    public final C0159c7 i() {
        return this.e;
    }

    public final C0264g9 j() {
        return this.l;
    }

    public final C0548r9 k() {
        return this.g;
    }

    public final E9 l() {
        return this.n;
    }

    public final K9 m() {
        return this.p;
    }

    public final Eh n() {
        return (Eh) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final C0762zf q() {
        return this.d;
    }

    public final C0431ml r() {
        return this.u;
    }

    public final C0664vl s() {
        return this.j;
    }

    public final Hm t() {
        Hm hm;
        C0272gh c0272gh = this.k;
        synchronized (c0272gh) {
            hm = c0272gh.c.f907a;
        }
        return hm;
    }

    public final ap u() {
        return this.t;
    }

    public final void v() {
        E9 e9 = this.n;
        int i = e9.j;
        e9.l = i;
        e9.f530a.a(i);
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        ap apVar = this.t;
        synchronized (apVar) {
            optInt = apVar.f899a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0337j5> listOf = CollectionsKt.listOf(new C0363k5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0337j5 abstractC0337j5 : listOf) {
                abstractC0337j5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        Eh eh = (Eh) this.k.a();
        return eh.n && eh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.k, eh.s, "need to check permissions");
    }

    public final boolean y() {
        E9 e9 = this.n;
        return e9.l < e9.j && ((Eh) this.k.a()).o && ((Eh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        C0272gh c0272gh = this.k;
        synchronized (c0272gh) {
            c0272gh.f526a = null;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0447nb
    public final void a(C0235f6 c0235f6) {
        String a2 = AbstractC0555rg.a("Event received on service", Db.a(c0235f6.d), c0235f6.getName(), c0235f6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0235f6, new Mi());
    }

    public CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.MANUAL;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0447nb, io.appmetrica.analytics.impl.InterfaceC0266gb
    public synchronized void a(F4 f4) {
        long j;
        this.k.a(f4);
        boolean z = false;
        if (Boolean.TRUE.equals(f4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(f4.h)) {
                this.m.setEnabled(false);
            }
        }
        C2 c2 = this.v;
        Set<String> set = f4.o;
        long currentTimeMillis = c2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c2.b) {
                c2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c2.a(c2.e);
            c2.f490a.a(c2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public C0441n5(Context context, C0260g5 c0260g5, C0410m0 c0410m0, TimePassedChecker timePassedChecker, C0570s5 c0570s5, F4 f4) {
        this.f1114a = context.getApplicationContext();
        this.b = c0260g5;
        this.i = c0410m0;
        this.r = timePassedChecker;
        ap f = c0570s5.f();
        this.t = f;
        this.s = Na.k().t();
        C0684wf a2 = c0570s5.e().a();
        this.c = a2;
        this.v = c0570s5.a(a2);
        C0272gh a3 = c0570s5.a(this);
        this.k = a3;
        PublicLogger a4 = c0570s5.d().a();
        this.m = a4;
        this.d = Na.k().y();
        C0384l0 a5 = c0410m0.a(c0260g5, a4, a2);
        this.h = a5;
        this.l = c0570s5.a();
        C0159c7 b = c0570s5.b(this);
        this.e = b;
        Pi d = c0570s5.d(this);
        this.o = C0570s5.b();
        w();
        C0664vl a6 = C0570s5.a(this, f, new C0415m5(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", c0260g5.toString(), a5.a().f1064a);
        C0431ml c = c0570s5.c();
        this.u = c;
        this.n = c0570s5.a(a2, f, a6, b, a5, c, d);
        C0548r9 c2 = C0570s5.c(this);
        this.g = c2;
        this.f = C0570s5.a(this, c2);
        this.q = c0570s5.b(a2);
        this.p = c0570s5.a(d, b, a3, f4, c0260g5, a2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final C0260g5 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0447nb, io.appmetrica.analytics.impl.InterfaceC0587sm
    public final synchronized void a(Hm hm) {
        this.k.a(hm);
        ((A5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).f1284a.flushAsync();
    }
}

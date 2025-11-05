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
/* renamed from: io.appmetrica.analytics.impl.e5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0210e5 implements Wa, La, InterfaceC0478oh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f857a;
    public final X4 b;
    public final C0143bf c;
    public final C0220ef d;
    public final S6 e;
    public final C0728yi f;
    public final C0214e9 g;
    public final C0334j0 h;
    public final C0360k0 i;
    public final Wk j;
    public final Vg k;
    public final R8 l;
    public final PublicLogger m;
    public final C0544r9 n;
    public final Z4 o;
    public final InterfaceC0694x9 p;
    public final C0613u3 q;
    public final TimePassedChecker r;
    public final C0725yf s;
    public final zo t;
    public final Ok u;
    public final C0687x2 v;

    public C0210e5(Context context, C0356jm c0356jm, X4 x4, C0639v4 c0639v4, InterfaceC0428mh interfaceC0428mh, AbstractC0159c5 abstractC0159c5) {
        this(context, x4, new C0360k0(), new TimePassedChecker(), new C0339j5(context, x4, c0639v4, abstractC0159c5, c0356jm, interfaceC0428mh, C0620ua.k().x().d(), PackageManagerUtils.getAppVersionCodeInt(context), C0620ua.k().l(), new W4()), c0639v4);
    }

    public final boolean A() {
        C0503ph c0503ph = (C0503ph) this.k.a();
        return c0503ph.n && this.r.didTimePassSeconds(this.n.l, c0503ph.t, "should force send permissions");
    }

    public final boolean B() {
        C0356jm c0356jm;
        C0725yf c0725yf = this.s;
        c0725yf.h.a(c0725yf.f730a);
        boolean z = ((C0650vf) c0725yf.c()).d;
        Vg vg = this.k;
        synchronized (vg) {
            c0356jm = vg.c.f677a;
        }
        return !(z && c0356jm.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.Ul
    public final void a(Nl nl, C0356jm c0356jm) {
    }

    @Override // io.appmetrica.analytics.impl.La
    public final X4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0334j0 c0334j0 = this.h;
        synchronized (c0334j0) {
            c0334j0.f942a = new Mc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C0540r5) this.p).d();
    }

    public final C0687x2 f() {
        return this.v;
    }

    public final C0613u3 g() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.La
    public final Context getContext() {
        return this.f857a;
    }

    public final C0143bf h() {
        return this.c;
    }

    public final S6 i() {
        return this.e;
    }

    public final R8 j() {
        return this.l;
    }

    public final C0214e9 k() {
        return this.g;
    }

    public final C0544r9 l() {
        return this.n;
    }

    public final InterfaceC0694x9 m() {
        return this.p;
    }

    public final C0503ph n() {
        return (C0503ph) this.k.a();
    }

    public final String o() {
        return this.c.j();
    }

    public final PublicLogger p() {
        return this.m;
    }

    public final C0220ef q() {
        return this.d;
    }

    public final Ok r() {
        return this.u;
    }

    public final Wk s() {
        return this.j;
    }

    public final C0356jm t() {
        C0356jm c0356jm;
        Vg vg = this.k;
        synchronized (vg) {
            c0356jm = vg.c.f677a;
        }
        return c0356jm;
    }

    public final zo u() {
        return this.t;
    }

    public final void v() {
        C0544r9 c0544r9 = this.n;
        int i = c0544r9.k;
        c0544r9.m = i;
        c0544r9.f1091a.a(i).b();
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        zo zoVar = this.t;
        synchronized (zoVar) {
            optInt = zoVar.f1238a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0107a5> listOf = CollectionsKt.listOf(new C0133b5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0107a5 abstractC0107a5 : listOf) {
                abstractC0107a5.a(intValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        C0503ph c0503ph = (C0503ph) this.k.a();
        return c0503ph.n && c0503ph.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, c0503ph.s, "need to check permissions");
    }

    public final boolean y() {
        C0544r9 c0544r9 = this.n;
        return c0544r9.m < c0544r9.k && ((C0503ph) this.k.a()).o && ((C0503ph) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        Vg vg = this.k;
        synchronized (vg) {
            vg.f1163a = null;
        }
    }

    public final void b(W5 w5) {
        this.h.a(w5.f);
        C0309i0 a2 = this.h.a();
        C0360k0 c0360k0 = this.i;
        C0143bf c0143bf = this.c;
        synchronized (c0360k0) {
            if (a2.b > c0143bf.d().b) {
                c0143bf.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f920a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final void a(W5 w5) {
        String a2 = Vf.a("Event received on service", EnumC0320ib.a(w5.d), w5.getName(), w5.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(w5, new C0703xi());
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public synchronized void a(C0639v4 c0639v4) {
        long j;
        this.k.a(c0639v4);
        boolean z = false;
        if (Boolean.TRUE.equals(c0639v4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(c0639v4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0687x2 c0687x2 = this.v;
        Set<String> set = c0639v4.o;
        long currentTimeMillis = c0687x2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0687x2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0687x2.b) {
                c0687x2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0687x2.a(c0687x2.e);
            c0687x2.f1197a.a(c0687x2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public C0210e5(Context context, X4 x4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0339j5 c0339j5, C0639v4 c0639v4) {
        this.f857a = context.getApplicationContext();
        this.b = x4;
        this.i = c0360k0;
        this.r = timePassedChecker;
        zo f = c0339j5.f();
        this.t = f;
        this.s = C0620ua.k().t();
        C0143bf a2 = c0339j5.e().a();
        this.c = a2;
        this.v = c0339j5.a(a2);
        Vg a3 = c0339j5.a(this);
        this.k = a3;
        PublicLogger a4 = c0339j5.d().a();
        this.m = a4;
        this.d = C0620ua.k().z();
        C0334j0 a5 = c0360k0.a(x4, a4, a2);
        this.h = a5;
        this.l = c0339j5.a();
        S6 b = c0339j5.b(this);
        this.e = b;
        Ai d = c0339j5.d(this);
        this.o = C0339j5.b();
        w();
        Wk a6 = C0339j5.a(this, f, new C0185d5(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", x4.toString(), a5.a().f920a);
        Ok c = c0339j5.c();
        this.u = c;
        this.n = c0339j5.a(a2, f, a6, b, a5, c, d);
        C0214e9 c2 = C0339j5.c(this);
        this.g = c2;
        this.f = C0339j5.a(this, c2);
        this.q = c0339j5.b(a2);
        this.p = c0339j5.a(d, b, a3, c0639v4, x4, a2);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.Ul
    public final synchronized void a(C0356jm c0356jm) {
        this.k.a(c0356jm);
        ((C0540r5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

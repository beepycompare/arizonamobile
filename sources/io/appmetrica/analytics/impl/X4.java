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
public class X4 implements Pa, Ea, InterfaceC0354jh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f848a;
    public final Q4 b;
    public final We c;
    public final Ze d;
    public final L6 e;
    public final C0605ti f;
    public final X8 g;
    public final C0337j0 h;
    public final C0363k0 i;
    public final Rk j;
    public final Qg k;
    public final M8 l;
    public final PublicLogger m;
    public final C0372k9 n;
    public final S4 o;
    public final InterfaceC0522q9 p;
    public final C0416m3 q;
    public final TimePassedChecker r;
    public final C0602tf s;
    public final xo t;
    public final Jk u;
    public final C0490p2 v;

    public X4(Context context, C0256fm c0256fm, Q4 q4, C0467o4 c0467o4, InterfaceC0303hh interfaceC0303hh, V4 v4) {
        this(context, q4, new C0363k0(), new TimePassedChecker(), new C0162c5(context, q4, c0467o4, v4, c0256fm, interfaceC0303hh, C0448na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0448na.k().l(), new P4()), c0467o4);
    }

    public final boolean A() {
        C0380kh c0380kh = (C0380kh) this.k.a();
        return c0380kh.n && this.r.didTimePassSeconds(this.n.k, c0380kh.t, "should force send permissions");
    }

    public final boolean B() {
        C0256fm c0256fm;
        C0602tf c0602tf = this.s;
        c0602tf.h.a(c0602tf.f737a);
        boolean z = ((C0528qf) c0602tf.c()).d;
        Qg qg = this.k;
        synchronized (qg) {
            c0256fm = qg.c.f671a;
        }
        return !(z && c0256fm.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0256fm c0256fm) {
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final Q4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0337j0 c0337j0 = this.h;
        synchronized (c0337j0) {
            c0337j0.f1052a = new Fc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C0368k5) this.p).d();
    }

    public final C0490p2 f() {
        return this.v;
    }

    public final C0416m3 g() {
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

    public final C0372k9 l() {
        return this.n;
    }

    public final InterfaceC0522q9 m() {
        return this.p;
    }

    public final C0380kh n() {
        return (C0380kh) this.k.a();
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

    public final C0256fm t() {
        C0256fm c0256fm;
        Qg qg = this.k;
        synchronized (qg) {
            c0256fm = qg.c.f671a;
        }
        return c0256fm;
    }

    public final xo u() {
        return this.t;
    }

    public final void v() {
        C0372k9 c0372k9 = this.n;
        int i = c0372k9.j;
        c0372k9.l = i;
        c0372k9.f1079a.a(i).b();
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
        C0380kh c0380kh = (C0380kh) this.k.a();
        return c0380kh.n && c0380kh.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.k, c0380kh.s, "need to check permissions");
    }

    public final boolean y() {
        C0372k9 c0372k9 = this.n;
        return c0372k9.l < c0372k9.j && ((C0380kh) this.k.a()).o && ((C0380kh) this.k.a()).isIdentifiersValid();
    }

    public final void z() {
        Qg qg = this.k;
        synchronized (qg) {
            qg.f1147a = null;
        }
    }

    public final void b(P5 p5) {
        this.h.a(p5.f);
        C0312i0 a2 = this.h.a();
        C0363k0 c0363k0 = this.i;
        We we = this.c;
        synchronized (c0363k0) {
            if (a2.b > we.d().b) {
                we.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f1035a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(P5 p5) {
        String a2 = Qf.a("Event received on service", EnumC0142bb.a(p5.d), p5.getName(), p5.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(p5, new C0580si());
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ea
    public synchronized void a(C0467o4 c0467o4) {
        long j;
        this.k.a(c0467o4);
        boolean z = false;
        if (Boolean.TRUE.equals(c0467o4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(c0467o4.h)) {
                this.m.setEnabled(false);
            }
        }
        C0490p2 c0490p2 = this.v;
        Set<String> set = c0467o4.o;
        long currentTimeMillis = c0490p2.d.currentTimeMillis();
        boolean z2 = false;
        for (String str : set) {
            Long l = (Long) c0490p2.e.get(str);
            if (l != null) {
                j = l.longValue();
            } else {
                j = -1;
                z2 = true;
            }
            if (currentTimeMillis - j > c0490p2.b) {
                c0490p2.e.put(str, Long.valueOf(currentTimeMillis));
                z = true;
            }
        }
        if (z) {
            c0490p2.a(c0490p2.e);
            c0490p2.f1166a.a(c0490p2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public X4(Context context, Q4 q4, C0363k0 c0363k0, TimePassedChecker timePassedChecker, C0162c5 c0162c5, C0467o4 c0467o4) {
        this.f848a = context.getApplicationContext();
        this.b = q4;
        this.i = c0363k0;
        this.r = timePassedChecker;
        xo f = c0162c5.f();
        this.t = f;
        this.s = C0448na.k().t();
        We a2 = c0162c5.e().a();
        this.c = a2;
        this.v = c0162c5.a(a2);
        Qg a3 = c0162c5.a(this);
        this.k = a3;
        PublicLogger a4 = c0162c5.d().a();
        this.m = a4;
        this.d = C0448na.k().y();
        C0337j0 a5 = c0363k0.a(q4, a4, a2);
        this.h = a5;
        this.l = c0162c5.a();
        L6 b = c0162c5.b(this);
        this.e = b;
        C0655vi d = c0162c5.d(this);
        this.o = C0162c5.b();
        w();
        Rk a6 = C0162c5.a(this, f, new W4(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", q4.toString(), a5.a().f1035a);
        Jk c = c0162c5.c();
        this.u = c;
        this.n = c0162c5.a(a2, f, a6, b, a5, c, d);
        X8 c2 = C0162c5.c(this);
        this.g = c2;
        this.f = C0162c5.a(this, c2);
        this.q = c0162c5.b(a2);
        this.p = c0162c5.a(d, b, a3, c0467o4, q4, a2);
        b.d();
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ql
    public final synchronized void a(C0256fm c0256fm) {
        this.k.a(c0256fm);
        ((C0368k5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

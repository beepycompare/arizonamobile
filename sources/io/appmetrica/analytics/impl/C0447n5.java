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
public class C0447n5 implements InterfaceC0453nb, InterfaceC0272gb, Dh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1111a;
    public final C0266g5 b;
    public final C0690wf c;
    public final C0768zf d;
    public final C0165c7 e;
    public final Ni f;
    public final C0554r9 g;
    public final C0390l0 h;
    public final C0416m0 i;
    public final C0670vl j;
    public final C0278gh k;
    public final C0270g9 l;
    public final PublicLogger m;
    public final E9 n;
    public final C0318i5 o;
    public final K9 p;
    public final D3 q;
    public final TimePassedChecker r;
    public final Tf s;
    public final ap t;
    public final C0437ml u;
    public final C2 v;

    public C0447n5(Context context, Hm hm, C0266g5 c0266g5, F4 f4, Bh bh, AbstractC0395l5 abstractC0395l5) {
        this(context, c0266g5, new C0416m0(), new TimePassedChecker(), new C0576s5(context, c0266g5, f4, abstractC0395l5, hm, bh, Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), new C0240f5()), f4);
    }

    public final boolean A() {
        Eh eh = (Eh) this.k.a();
        return eh.n && this.r.didTimePassSeconds(this.n.k, eh.t, "should force send permissions");
    }

    public final boolean B() {
        Hm hm;
        Tf tf = this.s;
        tf.h.a(tf.f1011a);
        boolean z = ((Qf) tf.c()).d;
        C0278gh c0278gh = this.k;
        synchronized (c0278gh) {
            hm = c0278gh.c.f904a;
        }
        return !(z && hm.q);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0453nb, io.appmetrica.analytics.impl.InterfaceC0593sm
    public final void a(EnumC0412lm enumC0412lm, Hm hm) {
    }

    public final void b(C0241f6 c0241f6) {
        this.h.a(c0241f6.f);
        C0364k0 a2 = this.h.a();
        C0416m0 c0416m0 = this.i;
        C0690wf c0690wf = this.c;
        synchronized (c0416m0) {
            if (a2.b > c0690wf.d().b) {
                c0690wf.a(a2);
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f1061a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final void c() {
        bp bpVar = this.t.f896a;
        bp.a(bpVar.f916a);
        bp.a(bpVar.b);
        this.e.j.b.flushAsync();
    }

    public final void d() {
        C0390l0 c0390l0 = this.h;
        synchronized (c0390l0) {
            c0390l0.f1074a = new C0274gd();
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final Context getContext() {
        return this.f1111a;
    }

    public final C0690wf h() {
        return this.c;
    }

    public final C0165c7 i() {
        return this.e;
    }

    public final C0270g9 j() {
        return this.l;
    }

    public final C0554r9 k() {
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

    public final C0768zf q() {
        return this.d;
    }

    public final C0437ml r() {
        return this.u;
    }

    public final C0670vl s() {
        return this.j;
    }

    public final Hm t() {
        Hm hm;
        C0278gh c0278gh = this.k;
        synchronized (c0278gh) {
            hm = c0278gh.c.f904a;
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
        e9.f527a.a(i);
    }

    public final void w() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        ap apVar = this.t;
        synchronized (apVar) {
            optInt = apVar.f896a.a().optInt("last_migration_api_level", 0);
        }
        Integer valueOf = Integer.valueOf(optInt);
        if (valueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List<AbstractC0343j5> listOf = CollectionsKt.listOf(new C0369k5(this));
            int intValue = valueOf.intValue();
            for (AbstractC0343j5 abstractC0343j5 : listOf) {
                abstractC0343j5.a(intValue);
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
        C0278gh c0278gh = this.k;
        synchronized (c0278gh) {
            c0278gh.f523a = null;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0453nb
    public final void a(C0241f6 c0241f6) {
        String a2 = AbstractC0561rg.a("Event received on service", Db.a(c0241f6.d), c0241f6.getName(), c0241f6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0241f6, new Mi());
    }

    public CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.MANUAL;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0453nb, io.appmetrica.analytics.impl.InterfaceC0272gb
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
            c2.f487a.a(c2.e);
        }
        if (z2) {
            this.k.e();
        }
    }

    public C0447n5(Context context, C0266g5 c0266g5, C0416m0 c0416m0, TimePassedChecker timePassedChecker, C0576s5 c0576s5, F4 f4) {
        this.f1111a = context.getApplicationContext();
        this.b = c0266g5;
        this.i = c0416m0;
        this.r = timePassedChecker;
        ap f = c0576s5.f();
        this.t = f;
        this.s = Na.k().t();
        C0690wf a2 = c0576s5.e().a();
        this.c = a2;
        this.v = c0576s5.a(a2);
        C0278gh a3 = c0576s5.a(this);
        this.k = a3;
        PublicLogger a4 = c0576s5.d().a();
        this.m = a4;
        this.d = Na.k().y();
        C0390l0 a5 = c0416m0.a(c0266g5, a4, a2);
        this.h = a5;
        this.l = c0576s5.a();
        C0165c7 b = c0576s5.b(this);
        this.e = b;
        Pi d = c0576s5.d(this);
        this.o = C0576s5.b();
        w();
        C0670vl a6 = C0576s5.a(this, f, new C0421m5(this));
        this.j = a6;
        a4.info("Read app environment for component %s. Value: %s", c0266g5.toString(), a5.a().f1061a);
        C0437ml c = c0576s5.c();
        this.u = c;
        this.n = c0576s5.a(a2, f, a6, b, a5, c, d);
        C0554r9 c2 = C0576s5.c(this);
        this.g = c2;
        this.f = C0576s5.a(this, c2);
        this.q = c0576s5.b(a2);
        this.p = c0576s5.a(d, b, a3, f4, c0266g5, a2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final C0266g5 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0453nb, io.appmetrica.analytics.impl.InterfaceC0593sm
    public final synchronized void a(Hm hm) {
        this.k.a(hm);
        ((A5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).f1281a.flushAsync();
    }
}

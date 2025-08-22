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
public class C0572s5 implements InterfaceC0429mb, InterfaceC0146bb, Bh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1054a;
    public final C0398l5 b;
    public final C0433mf c;
    public final C0508pf d;
    public final C0297h7 e;
    public final Li f;
    public final C0626u9 g;
    public final C0290h0 h;
    public final C0316i0 i;
    public final Xk j;
    public final C0332ih k;
    public final C0299h9 l;
    public final PublicLogger m;
    public final H9 n;
    public final C0448n5 o;
    public final N9 p;
    public final I3 q;
    public final TimePassedChecker r;
    public final Jf s;
    public final zo t;
    public final Pk u;

    public C0572s5(Context context, C0389km c0389km, C0398l5 c0398l5, J4 j4, InterfaceC0759zh interfaceC0759zh, AbstractC0523q5 abstractC0523q5) {
        this(context, c0398l5, new C0316i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0389km, interfaceC0759zh, Ka.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ka.j().k(), new C0372k5()), j4);
    }

    public final boolean A() {
        C0389km c0389km;
        Jf jf = this.s;
        jf.h.a(jf.f935a);
        boolean z = ((Gf) jf.c()).d;
        C0332ih c0332ih = this.k;
        synchronized (c0332ih) {
            c0389km = c0332ih.c.f882a;
        }
        return !(z && c0389km.q);
    }

    public void B() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.Vl
    public final void a(Ol ol, C0389km c0389km) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final C0398l5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C0290h0 c0290h0 = this.h;
        synchronized (c0290h0) {
            c0290h0.f877a = new C0174cd();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((F5) this.p).d();
    }

    public final I3 f() {
        return this.q;
    }

    public final C0433mf g() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final Context getContext() {
        return this.f1054a;
    }

    public final C0297h7 h() {
        return this.e;
    }

    public final C0299h9 i() {
        return this.l;
    }

    public final C0626u9 j() {
        return this.g;
    }

    public final H9 k() {
        return this.n;
    }

    public final N9 l() {
        return this.p;
    }

    public final Ch m() {
        return (Ch) this.k.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.m;
    }

    public final C0508pf p() {
        return this.d;
    }

    public final Pk q() {
        return this.u;
    }

    public final Xk r() {
        return this.j;
    }

    public final C0389km s() {
        C0389km c0389km;
        C0332ih c0332ih = this.k;
        synchronized (c0332ih) {
            c0389km = c0332ih.c.f882a;
        }
        return c0389km;
    }

    public final zo t() {
        return this.t;
    }

    public final void u() {
        H9 h9 = this.n;
        int i = h9.k;
        h9.m = i;
        h9.f474a.a(i).b();
    }

    public final void v() {
        int optInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        zo zoVar = this.t;
        synchronized (zoVar) {
            optInt = zoVar.f1187a.a().optInt("last_migration_api_level", 0);
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
        Ch ch = (Ch) this.k.a();
        return ch.n && ch.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, ch.s, "need to check permissions");
    }

    public final boolean x() {
        H9 h9 = this.n;
        return h9.m < h9.k && ((Ch) this.k.a()).o && ((Ch) this.k.a()).isIdentifiersValid();
    }

    public final void y() {
        C0332ih c0332ih = this.k;
        synchronized (c0332ih) {
            c0332ih.f509a = null;
        }
    }

    public final boolean z() {
        Ch ch = (Ch) this.k.a();
        return ch.n && this.r.didTimePassSeconds(this.n.l, ch.t, "should force send permissions");
    }

    public final void b(C0399l6 c0399l6) {
        this.h.a(c0399l6.f);
        C0264g0 a2 = this.h.a();
        C0316i0 c0316i0 = this.i;
        C0433mf c0433mf = this.c;
        synchronized (c0316i0) {
            if (a2.b > c0433mf.d().b) {
                c0433mf.a(a2).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, a2.f862a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb
    public final void a(C0399l6 c0399l6) {
        String a2 = AbstractC0331ig.a("Event received on service", EnumC0728yb.a(c0399l6.d), c0399l6.getName(), c0399l6.getValue());
        if (a2 != null) {
            this.m.info(a2, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c0399l6, new Ki());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.InterfaceC0146bb
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

    public C0572s5(Context context, C0398l5 c0398l5, C0316i0 c0316i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, J4 j4) {
        this.f1054a = context.getApplicationContext();
        this.b = c0398l5;
        this.i = c0316i0;
        this.r = timePassedChecker;
        zo f = c0697x5.f();
        this.t = f;
        this.s = Ka.j().s();
        C0332ih a2 = c0697x5.a(this);
        this.k = a2;
        PublicLogger a3 = c0697x5.d().a();
        this.m = a3;
        C0433mf a4 = c0697x5.e().a();
        this.c = a4;
        this.d = Ka.j().x();
        C0290h0 a5 = c0316i0.a(c0398l5, a3, a4);
        this.h = a5;
        this.l = c0697x5.a();
        C0297h7 b = c0697x5.b(this);
        this.e = b;
        Ni d = c0697x5.d(this);
        this.o = C0697x5.b();
        v();
        Xk a6 = C0697x5.a(this, f, new C0547r5(this));
        this.j = a6;
        a3.info("Read app environment for component %s. Value: %s", c0398l5.toString(), a5.a().f862a);
        Pk c = c0697x5.c();
        this.u = c;
        this.n = c0697x5.a(a4, f, a6, b, a5, c, d);
        C0626u9 c2 = C0697x5.c(this);
        this.g = c2;
        this.f = C0697x5.a(this, c2);
        this.q = c0697x5.a(a4);
        this.p = c0697x5.a(d, b, a2, j4, c0398l5, a4);
        b.e();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.Vl
    public synchronized void a(C0389km c0389km) {
        this.k.a(c0389km);
        ((F5) this.p).e();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}

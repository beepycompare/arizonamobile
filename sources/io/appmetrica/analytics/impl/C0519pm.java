package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0519pm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Se f1039a = new Se();
    public final Fa b = new Fa();
    public final Rm c = new Rm();
    public final C0698x2 d = new C0698x2();
    public final E3 e = new E3();
    public final C0623u2 f = new C0623u2();
    public final V6 g = new V6();
    public final Nm h = new Nm();
    public final Ld i = new Ld();
    public final C0171ca j = new C0171ca();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Gm fromModel(C0593sm c0593sm) {
        Gm gm = new Gm();
        gm.s = c0593sm.u;
        gm.t = c0593sm.v;
        String str = c0593sm.f1084a;
        if (str != null) {
            gm.f464a = str;
        }
        List list = c0593sm.f;
        if (list != null) {
            gm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0593sm.g;
        if (list2 != null) {
            gm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0593sm.b;
        if (list3 != null) {
            gm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0593sm.h;
        if (list4 != null) {
            gm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0593sm.i;
        if (map != null) {
            gm.h = this.g.fromModel(map);
        }
        Re re = c0593sm.s;
        if (re != null) {
            gm.v = this.f1039a.fromModel(re);
        }
        String str2 = c0593sm.j;
        if (str2 != null) {
            gm.j = str2;
        }
        String str3 = c0593sm.c;
        if (str3 != null) {
            gm.d = str3;
        }
        String str4 = c0593sm.d;
        if (str4 != null) {
            gm.e = str4;
        }
        String str5 = c0593sm.e;
        if (str5 != null) {
            gm.r = str5;
        }
        gm.i = this.b.fromModel(c0593sm.m);
        String str6 = c0593sm.k;
        if (str6 != null) {
            gm.k = str6;
        }
        String str7 = c0593sm.l;
        if (str7 != null) {
            gm.l = str7;
        }
        gm.m = c0593sm.p;
        gm.b = c0593sm.n;
        gm.q = c0593sm.o;
        RetryPolicyConfig retryPolicyConfig = c0593sm.t;
        gm.w = retryPolicyConfig.maxIntervalSeconds;
        gm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0593sm.q;
        if (str8 != null) {
            gm.n = str8;
        }
        Qm qm = c0593sm.r;
        if (qm != null) {
            this.c.getClass();
            Fm fm = new Fm();
            fm.f450a = qm.f645a;
            gm.p = fm;
        }
        gm.u = c0593sm.w;
        BillingConfig billingConfig = c0593sm.x;
        if (billingConfig != null) {
            gm.z = this.d.fromModel(billingConfig);
        }
        C3 c3 = c0593sm.y;
        if (c3 != null) {
            this.e.getClass();
            C0743ym c0743ym = new C0743ym();
            c0743ym.f1176a = c3.f381a;
            gm.y = c0743ym;
        }
        C0598t2 c0598t2 = c0593sm.z;
        if (c0598t2 != null) {
            gm.A = this.f.fromModel(c0598t2);
        }
        gm.B = this.h.fromModel(c0593sm.A);
        gm.C = this.i.fromModel(c0593sm.B);
        gm.D = this.j.fromModel(c0593sm.C);
        return gm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0593sm toModel(Gm gm) {
        C0568rm c0568rm = new C0568rm(this.b.toModel(gm.i));
        c0568rm.f1071a = gm.f464a;
        c0568rm.j = gm.j;
        c0568rm.c = gm.d;
        c0568rm.b = Arrays.asList(gm.c);
        c0568rm.g = Arrays.asList(gm.g);
        c0568rm.f = Arrays.asList(gm.f);
        c0568rm.d = gm.e;
        c0568rm.e = gm.r;
        c0568rm.h = Arrays.asList(gm.o);
        c0568rm.k = gm.k;
        c0568rm.l = gm.l;
        c0568rm.q = gm.m;
        c0568rm.o = gm.b;
        c0568rm.p = gm.q;
        c0568rm.t = gm.s;
        c0568rm.u = gm.t;
        c0568rm.r = gm.n;
        c0568rm.v = gm.u;
        c0568rm.w = new RetryPolicyConfig(gm.w, gm.x);
        c0568rm.i = this.g.toModel(gm.h);
        Dm dm = gm.v;
        if (dm != null) {
            this.f1039a.getClass();
            c0568rm.n = new Re(dm.f415a, dm.b);
        }
        Fm fm = gm.p;
        if (fm != null) {
            this.c.getClass();
            c0568rm.s = new Qm(fm.f450a);
        }
        C0718xm c0718xm = gm.z;
        if (c0718xm != null) {
            this.d.getClass();
            c0568rm.x = new BillingConfig(c0718xm.f1160a, c0718xm.b);
        }
        C0743ym c0743ym = gm.y;
        if (c0743ym != null) {
            this.e.getClass();
            c0568rm.y = new C3(c0743ym.f1176a);
        }
        C0693wm c0693wm = gm.A;
        if (c0693wm != null) {
            c0568rm.z = this.f.toModel(c0693wm);
        }
        Em em = gm.B;
        if (em != null) {
            this.h.getClass();
            c0568rm.A = new Mm(em.f431a);
        }
        c0568rm.B = this.i.toModel(gm.C);
        Am am = gm.D;
        if (am != null) {
            this.j.getClass();
            c0568rm.C = new C0145ba(am.f355a);
        }
        return new C0593sm(c0568rm);
    }
}

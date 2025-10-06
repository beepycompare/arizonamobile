package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0520pm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Se f1040a = new Se();
    public final Fa b = new Fa();
    public final Rm c = new Rm();
    public final C0699x2 d = new C0699x2();
    public final E3 e = new E3();
    public final C0624u2 f = new C0624u2();
    public final V6 g = new V6();
    public final Nm h = new Nm();
    public final Ld i = new Ld();
    public final C0172ca j = new C0172ca();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Gm fromModel(C0594sm c0594sm) {
        Gm gm = new Gm();
        gm.s = c0594sm.u;
        gm.t = c0594sm.v;
        String str = c0594sm.f1085a;
        if (str != null) {
            gm.f465a = str;
        }
        List list = c0594sm.f;
        if (list != null) {
            gm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0594sm.g;
        if (list2 != null) {
            gm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0594sm.b;
        if (list3 != null) {
            gm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0594sm.h;
        if (list4 != null) {
            gm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0594sm.i;
        if (map != null) {
            gm.h = this.g.fromModel(map);
        }
        Re re = c0594sm.s;
        if (re != null) {
            gm.v = this.f1040a.fromModel(re);
        }
        String str2 = c0594sm.j;
        if (str2 != null) {
            gm.j = str2;
        }
        String str3 = c0594sm.c;
        if (str3 != null) {
            gm.d = str3;
        }
        String str4 = c0594sm.d;
        if (str4 != null) {
            gm.e = str4;
        }
        String str5 = c0594sm.e;
        if (str5 != null) {
            gm.r = str5;
        }
        gm.i = this.b.fromModel(c0594sm.m);
        String str6 = c0594sm.k;
        if (str6 != null) {
            gm.k = str6;
        }
        String str7 = c0594sm.l;
        if (str7 != null) {
            gm.l = str7;
        }
        gm.m = c0594sm.p;
        gm.b = c0594sm.n;
        gm.q = c0594sm.o;
        RetryPolicyConfig retryPolicyConfig = c0594sm.t;
        gm.w = retryPolicyConfig.maxIntervalSeconds;
        gm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0594sm.q;
        if (str8 != null) {
            gm.n = str8;
        }
        Qm qm = c0594sm.r;
        if (qm != null) {
            this.c.getClass();
            Fm fm = new Fm();
            fm.f451a = qm.f646a;
            gm.p = fm;
        }
        gm.u = c0594sm.w;
        BillingConfig billingConfig = c0594sm.x;
        if (billingConfig != null) {
            gm.z = this.d.fromModel(billingConfig);
        }
        C3 c3 = c0594sm.y;
        if (c3 != null) {
            this.e.getClass();
            C0744ym c0744ym = new C0744ym();
            c0744ym.f1177a = c3.f382a;
            gm.y = c0744ym;
        }
        C0599t2 c0599t2 = c0594sm.z;
        if (c0599t2 != null) {
            gm.A = this.f.fromModel(c0599t2);
        }
        gm.B = this.h.fromModel(c0594sm.A);
        gm.C = this.i.fromModel(c0594sm.B);
        gm.D = this.j.fromModel(c0594sm.C);
        return gm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0594sm toModel(Gm gm) {
        C0569rm c0569rm = new C0569rm(this.b.toModel(gm.i));
        c0569rm.f1072a = gm.f465a;
        c0569rm.j = gm.j;
        c0569rm.c = gm.d;
        c0569rm.b = Arrays.asList(gm.c);
        c0569rm.g = Arrays.asList(gm.g);
        c0569rm.f = Arrays.asList(gm.f);
        c0569rm.d = gm.e;
        c0569rm.e = gm.r;
        c0569rm.h = Arrays.asList(gm.o);
        c0569rm.k = gm.k;
        c0569rm.l = gm.l;
        c0569rm.q = gm.m;
        c0569rm.o = gm.b;
        c0569rm.p = gm.q;
        c0569rm.t = gm.s;
        c0569rm.u = gm.t;
        c0569rm.r = gm.n;
        c0569rm.v = gm.u;
        c0569rm.w = new RetryPolicyConfig(gm.w, gm.x);
        c0569rm.i = this.g.toModel(gm.h);
        Dm dm = gm.v;
        if (dm != null) {
            this.f1040a.getClass();
            c0569rm.n = new Re(dm.f416a, dm.b);
        }
        Fm fm = gm.p;
        if (fm != null) {
            this.c.getClass();
            c0569rm.s = new Qm(fm.f451a);
        }
        C0719xm c0719xm = gm.z;
        if (c0719xm != null) {
            this.d.getClass();
            c0569rm.x = new BillingConfig(c0719xm.f1161a, c0719xm.b);
        }
        C0744ym c0744ym = gm.y;
        if (c0744ym != null) {
            this.e.getClass();
            c0569rm.y = new C3(c0744ym.f1177a);
        }
        C0694wm c0694wm = gm.A;
        if (c0694wm != null) {
            c0569rm.z = this.f.toModel(c0694wm);
        }
        Em em = gm.B;
        if (em != null) {
            this.h.getClass();
            c0569rm.A = new Mm(em.f432a);
        }
        c0569rm.B = this.i.toModel(gm.C);
        Am am = gm.D;
        if (am != null) {
            this.j.getClass();
            c0569rm.C = new C0146ba(am.f356a);
        }
        return new C0594sm(c0569rm);
    }
}

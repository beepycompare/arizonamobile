package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0293gm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f871a = new Me();
    public final Aa b = new Aa();
    public final Im c = new Im();
    public final C0621u2 d = new C0621u2();
    public final B3 e = new B3();
    public final C0571s2 f = new C0571s2();
    public final R6 g = new R6();
    public final Em h = new Em();
    public final Fd i = new Fd();
    public final X9 j = new X9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0716xm fromModel(C0367jm c0367jm) {
        C0716xm c0716xm = new C0716xm();
        c0716xm.s = c0367jm.u;
        c0716xm.t = c0367jm.v;
        String str = c0367jm.f917a;
        if (str != null) {
            c0716xm.f1141a = str;
        }
        List list = c0367jm.f;
        if (list != null) {
            c0716xm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0367jm.g;
        if (list2 != null) {
            c0716xm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0367jm.b;
        if (list3 != null) {
            c0716xm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0367jm.h;
        if (list4 != null) {
            c0716xm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0367jm.i;
        if (map != null) {
            c0716xm.h = this.g.fromModel(map);
        }
        Le le = c0367jm.s;
        if (le != null) {
            c0716xm.v = this.f871a.fromModel(le);
        }
        String str2 = c0367jm.j;
        if (str2 != null) {
            c0716xm.j = str2;
        }
        String str3 = c0367jm.c;
        if (str3 != null) {
            c0716xm.d = str3;
        }
        String str4 = c0367jm.d;
        if (str4 != null) {
            c0716xm.e = str4;
        }
        String str5 = c0367jm.e;
        if (str5 != null) {
            c0716xm.r = str5;
        }
        c0716xm.i = this.b.fromModel(c0367jm.m);
        String str6 = c0367jm.k;
        if (str6 != null) {
            c0716xm.k = str6;
        }
        String str7 = c0367jm.l;
        if (str7 != null) {
            c0716xm.l = str7;
        }
        c0716xm.m = c0367jm.p;
        c0716xm.b = c0367jm.n;
        c0716xm.q = c0367jm.o;
        RetryPolicyConfig retryPolicyConfig = c0367jm.t;
        c0716xm.w = retryPolicyConfig.maxIntervalSeconds;
        c0716xm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0367jm.q;
        if (str8 != null) {
            c0716xm.n = str8;
        }
        Hm hm = c0367jm.r;
        if (hm != null) {
            this.c.getClass();
            C0691wm c0691wm = new C0691wm();
            c0691wm.f1125a = hm.f477a;
            c0716xm.p = c0691wm;
        }
        c0716xm.u = c0367jm.w;
        BillingConfig billingConfig = c0367jm.x;
        if (billingConfig != null) {
            c0716xm.z = this.d.fromModel(billingConfig);
        }
        C0747z3 c0747z3 = c0367jm.y;
        if (c0747z3 != null) {
            this.e.getClass();
            C0517pm c0517pm = new C0517pm();
            c0517pm.f1007a = c0747z3.f1162a;
            c0716xm.y = c0517pm;
        }
        C0546r2 c0546r2 = c0367jm.z;
        if (c0546r2 != null) {
            c0716xm.A = this.f.fromModel(c0546r2);
        }
        c0716xm.B = this.h.fromModel(c0367jm.A);
        c0716xm.C = this.i.fromModel(c0367jm.B);
        c0716xm.D = this.j.fromModel(c0367jm.C);
        return c0716xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0367jm toModel(C0716xm c0716xm) {
        C0342im c0342im = new C0342im(this.b.toModel(c0716xm.i));
        c0342im.f905a = c0716xm.f1141a;
        c0342im.j = c0716xm.j;
        c0342im.c = c0716xm.d;
        c0342im.b = Arrays.asList(c0716xm.c);
        c0342im.g = Arrays.asList(c0716xm.g);
        c0342im.f = Arrays.asList(c0716xm.f);
        c0342im.d = c0716xm.e;
        c0342im.e = c0716xm.r;
        c0342im.h = Arrays.asList(c0716xm.o);
        c0342im.k = c0716xm.k;
        c0342im.l = c0716xm.l;
        c0342im.q = c0716xm.m;
        c0342im.o = c0716xm.b;
        c0342im.p = c0716xm.q;
        c0342im.t = c0716xm.s;
        c0342im.u = c0716xm.t;
        c0342im.r = c0716xm.n;
        c0342im.v = c0716xm.u;
        c0342im.w = new RetryPolicyConfig(c0716xm.w, c0716xm.x);
        c0342im.i = this.g.toModel(c0716xm.h);
        C0641um c0641um = c0716xm.v;
        if (c0641um != null) {
            this.f871a.getClass();
            c0342im.n = new Le(c0641um.f1089a, c0641um.b);
        }
        C0691wm c0691wm = c0716xm.p;
        if (c0691wm != null) {
            this.c.getClass();
            c0342im.s = new Hm(c0691wm.f1125a);
        }
        C0492om c0492om = c0716xm.z;
        if (c0492om != null) {
            this.d.getClass();
            c0342im.x = new BillingConfig(c0492om.f992a, c0492om.b);
        }
        C0517pm c0517pm = c0716xm.y;
        if (c0517pm != null) {
            this.e.getClass();
            c0342im.y = new C0747z3(c0517pm.f1007a);
        }
        C0467nm c0467nm = c0716xm.A;
        if (c0467nm != null) {
            c0342im.z = this.f.toModel(c0467nm);
        }
        C0666vm c0666vm = c0716xm.B;
        if (c0666vm != null) {
            this.h.getClass();
            c0342im.A = new Dm(c0666vm.f1105a);
        }
        c0342im.B = this.i.toModel(c0716xm.C);
        C0566rm c0566rm = c0716xm.D;
        if (c0566rm != null) {
            this.j.getClass();
            c0342im.C = new W9(c0566rm.f1042a);
        }
        return new C0367jm(c0342im);
    }
}

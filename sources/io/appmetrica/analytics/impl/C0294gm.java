package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0294gm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f871a = new Me();
    public final Aa b = new Aa();
    public final Im c = new Im();
    public final C0622u2 d = new C0622u2();
    public final B3 e = new B3();
    public final C0572s2 f = new C0572s2();
    public final R6 g = new R6();
    public final Em h = new Em();
    public final Fd i = new Fd();
    public final X9 j = new X9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0717xm fromModel(C0368jm c0368jm) {
        C0717xm c0717xm = new C0717xm();
        c0717xm.s = c0368jm.u;
        c0717xm.t = c0368jm.v;
        String str = c0368jm.f917a;
        if (str != null) {
            c0717xm.f1141a = str;
        }
        List list = c0368jm.f;
        if (list != null) {
            c0717xm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0368jm.g;
        if (list2 != null) {
            c0717xm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0368jm.b;
        if (list3 != null) {
            c0717xm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0368jm.h;
        if (list4 != null) {
            c0717xm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0368jm.i;
        if (map != null) {
            c0717xm.h = this.g.fromModel(map);
        }
        Le le = c0368jm.s;
        if (le != null) {
            c0717xm.v = this.f871a.fromModel(le);
        }
        String str2 = c0368jm.j;
        if (str2 != null) {
            c0717xm.j = str2;
        }
        String str3 = c0368jm.c;
        if (str3 != null) {
            c0717xm.d = str3;
        }
        String str4 = c0368jm.d;
        if (str4 != null) {
            c0717xm.e = str4;
        }
        String str5 = c0368jm.e;
        if (str5 != null) {
            c0717xm.r = str5;
        }
        c0717xm.i = this.b.fromModel(c0368jm.m);
        String str6 = c0368jm.k;
        if (str6 != null) {
            c0717xm.k = str6;
        }
        String str7 = c0368jm.l;
        if (str7 != null) {
            c0717xm.l = str7;
        }
        c0717xm.m = c0368jm.p;
        c0717xm.b = c0368jm.n;
        c0717xm.q = c0368jm.o;
        RetryPolicyConfig retryPolicyConfig = c0368jm.t;
        c0717xm.w = retryPolicyConfig.maxIntervalSeconds;
        c0717xm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0368jm.q;
        if (str8 != null) {
            c0717xm.n = str8;
        }
        Hm hm = c0368jm.r;
        if (hm != null) {
            this.c.getClass();
            C0692wm c0692wm = new C0692wm();
            c0692wm.f1125a = hm.f477a;
            c0717xm.p = c0692wm;
        }
        c0717xm.u = c0368jm.w;
        BillingConfig billingConfig = c0368jm.x;
        if (billingConfig != null) {
            c0717xm.z = this.d.fromModel(billingConfig);
        }
        C0748z3 c0748z3 = c0368jm.y;
        if (c0748z3 != null) {
            this.e.getClass();
            C0518pm c0518pm = new C0518pm();
            c0518pm.f1007a = c0748z3.f1162a;
            c0717xm.y = c0518pm;
        }
        C0547r2 c0547r2 = c0368jm.z;
        if (c0547r2 != null) {
            c0717xm.A = this.f.fromModel(c0547r2);
        }
        c0717xm.B = this.h.fromModel(c0368jm.A);
        c0717xm.C = this.i.fromModel(c0368jm.B);
        c0717xm.D = this.j.fromModel(c0368jm.C);
        return c0717xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0368jm toModel(C0717xm c0717xm) {
        C0343im c0343im = new C0343im(this.b.toModel(c0717xm.i));
        c0343im.f905a = c0717xm.f1141a;
        c0343im.j = c0717xm.j;
        c0343im.c = c0717xm.d;
        c0343im.b = Arrays.asList(c0717xm.c);
        c0343im.g = Arrays.asList(c0717xm.g);
        c0343im.f = Arrays.asList(c0717xm.f);
        c0343im.d = c0717xm.e;
        c0343im.e = c0717xm.r;
        c0343im.h = Arrays.asList(c0717xm.o);
        c0343im.k = c0717xm.k;
        c0343im.l = c0717xm.l;
        c0343im.q = c0717xm.m;
        c0343im.o = c0717xm.b;
        c0343im.p = c0717xm.q;
        c0343im.t = c0717xm.s;
        c0343im.u = c0717xm.t;
        c0343im.r = c0717xm.n;
        c0343im.v = c0717xm.u;
        c0343im.w = new RetryPolicyConfig(c0717xm.w, c0717xm.x);
        c0343im.i = this.g.toModel(c0717xm.h);
        C0642um c0642um = c0717xm.v;
        if (c0642um != null) {
            this.f871a.getClass();
            c0343im.n = new Le(c0642um.f1089a, c0642um.b);
        }
        C0692wm c0692wm = c0717xm.p;
        if (c0692wm != null) {
            this.c.getClass();
            c0343im.s = new Hm(c0692wm.f1125a);
        }
        C0493om c0493om = c0717xm.z;
        if (c0493om != null) {
            this.d.getClass();
            c0343im.x = new BillingConfig(c0493om.f992a, c0493om.b);
        }
        C0518pm c0518pm = c0717xm.y;
        if (c0518pm != null) {
            this.e.getClass();
            c0343im.y = new C0748z3(c0518pm.f1007a);
        }
        C0468nm c0468nm = c0717xm.A;
        if (c0468nm != null) {
            c0343im.z = this.f.toModel(c0468nm);
        }
        C0667vm c0667vm = c0717xm.B;
        if (c0667vm != null) {
            this.h.getClass();
            c0343im.A = new Dm(c0667vm.f1105a);
        }
        c0343im.B = this.i.toModel(c0717xm.C);
        C0567rm c0567rm = c0717xm.D;
        if (c0567rm != null) {
            this.j.getClass();
            c0343im.C = new W9(c0567rm.f1042a);
        }
        return new C0368jm(c0343im);
    }
}

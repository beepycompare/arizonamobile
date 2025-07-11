package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0216dm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ke f811a = new Ke();
    public final C0727ya b = new C0727ya();
    public final Fm c = new Fm();
    public final C0619u2 d = new C0619u2();
    public final B3 e = new B3();
    public final C0569s2 f = new C0569s2();
    public final O6 g = new O6();
    public final Bm h = new Bm();
    public final Dd i = new Dd();
    public final V9 j = new V9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0639um fromModel(C0291gm c0291gm) {
        C0639um c0639um = new C0639um();
        c0639um.s = c0291gm.u;
        c0639um.t = c0291gm.v;
        String str = c0291gm.f858a;
        if (str != null) {
            c0639um.f1081a = str;
        }
        List list = c0291gm.f;
        if (list != null) {
            c0639um.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0291gm.g;
        if (list2 != null) {
            c0639um.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0291gm.b;
        if (list3 != null) {
            c0639um.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0291gm.h;
        if (list4 != null) {
            c0639um.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0291gm.i;
        if (map != null) {
            c0639um.h = this.g.fromModel(map);
        }
        Je je = c0291gm.s;
        if (je != null) {
            c0639um.v = this.f811a.fromModel(je);
        }
        String str2 = c0291gm.j;
        if (str2 != null) {
            c0639um.j = str2;
        }
        String str3 = c0291gm.c;
        if (str3 != null) {
            c0639um.d = str3;
        }
        String str4 = c0291gm.d;
        if (str4 != null) {
            c0639um.e = str4;
        }
        String str5 = c0291gm.e;
        if (str5 != null) {
            c0639um.r = str5;
        }
        c0639um.i = this.b.fromModel(c0291gm.m);
        String str6 = c0291gm.k;
        if (str6 != null) {
            c0639um.k = str6;
        }
        String str7 = c0291gm.l;
        if (str7 != null) {
            c0639um.l = str7;
        }
        c0639um.m = c0291gm.p;
        c0639um.b = c0291gm.n;
        c0639um.q = c0291gm.o;
        RetryPolicyConfig retryPolicyConfig = c0291gm.t;
        c0639um.w = retryPolicyConfig.maxIntervalSeconds;
        c0639um.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0291gm.q;
        if (str8 != null) {
            c0639um.n = str8;
        }
        Em em = c0291gm.r;
        if (em != null) {
            this.c.getClass();
            C0614tm c0614tm = new C0614tm();
            c0614tm.f1064a = em.f416a;
            c0639um.p = c0614tm;
        }
        c0639um.u = c0291gm.w;
        BillingConfig billingConfig = c0291gm.x;
        if (billingConfig != null) {
            c0639um.z = this.d.fromModel(billingConfig);
        }
        C0745z3 c0745z3 = c0291gm.y;
        if (c0745z3 != null) {
            this.e.getClass();
            C0440mm c0440mm = new C0440mm();
            c0440mm.f946a = c0745z3.f1157a;
            c0639um.y = c0440mm;
        }
        C0544r2 c0544r2 = c0291gm.z;
        if (c0544r2 != null) {
            c0639um.A = this.f.fromModel(c0544r2);
        }
        c0639um.B = this.h.fromModel(c0291gm.A);
        c0639um.C = this.i.fromModel(c0291gm.B);
        c0639um.D = this.j.fromModel(c0291gm.C);
        return c0639um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0291gm toModel(C0639um c0639um) {
        C0266fm c0266fm = new C0266fm(this.b.toModel(c0639um.i));
        c0266fm.f844a = c0639um.f1081a;
        c0266fm.j = c0639um.j;
        c0266fm.c = c0639um.d;
        c0266fm.b = Arrays.asList(c0639um.c);
        c0266fm.g = Arrays.asList(c0639um.g);
        c0266fm.f = Arrays.asList(c0639um.f);
        c0266fm.d = c0639um.e;
        c0266fm.e = c0639um.r;
        c0266fm.h = Arrays.asList(c0639um.o);
        c0266fm.k = c0639um.k;
        c0266fm.l = c0639um.l;
        c0266fm.q = c0639um.m;
        c0266fm.o = c0639um.b;
        c0266fm.p = c0639um.q;
        c0266fm.t = c0639um.s;
        c0266fm.u = c0639um.t;
        c0266fm.r = c0639um.n;
        c0266fm.v = c0639um.u;
        c0266fm.w = new RetryPolicyConfig(c0639um.w, c0639um.x);
        c0266fm.i = this.g.toModel(c0639um.h);
        C0564rm c0564rm = c0639um.v;
        if (c0564rm != null) {
            this.f811a.getClass();
            c0266fm.n = new Je(c0564rm.f1032a, c0564rm.b);
        }
        C0614tm c0614tm = c0639um.p;
        if (c0614tm != null) {
            this.c.getClass();
            c0266fm.s = new Em(c0614tm.f1064a);
        }
        C0415lm c0415lm = c0639um.z;
        if (c0415lm != null) {
            this.d.getClass();
            c0266fm.x = new BillingConfig(c0415lm.f928a, c0415lm.b);
        }
        C0440mm c0440mm = c0639um.y;
        if (c0440mm != null) {
            this.e.getClass();
            c0266fm.y = new C0745z3(c0440mm.f946a);
        }
        C0390km c0390km = c0639um.A;
        if (c0390km != null) {
            c0266fm.z = this.f.toModel(c0390km);
        }
        C0589sm c0589sm = c0639um.B;
        if (c0589sm != null) {
            this.h.getClass();
            c0266fm.A = new Am(c0589sm.f1049a);
        }
        c0266fm.B = this.i.toModel(c0639um.C);
        C0490om c0490om = c0639um.D;
        if (c0490om != null) {
            this.j.getClass();
            c0266fm.C = new U9(c0490om.f980a);
        }
        return new C0291gm(c0266fm);
    }
}

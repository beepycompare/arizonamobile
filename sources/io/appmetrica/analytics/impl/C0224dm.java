package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0224dm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ke f810a = new Ke();
    public final C0735ya b = new C0735ya();
    public final Fm c = new Fm();
    public final C0627u2 d = new C0627u2();
    public final B3 e = new B3();
    public final C0577s2 f = new C0577s2();
    public final O6 g = new O6();
    public final Bm h = new Bm();
    public final Dd i = new Dd();
    public final V9 j = new V9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0647um fromModel(C0299gm c0299gm) {
        C0647um c0647um = new C0647um();
        c0647um.s = c0299gm.u;
        c0647um.t = c0299gm.v;
        String str = c0299gm.f857a;
        if (str != null) {
            c0647um.f1080a = str;
        }
        List list = c0299gm.f;
        if (list != null) {
            c0647um.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0299gm.g;
        if (list2 != null) {
            c0647um.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0299gm.b;
        if (list3 != null) {
            c0647um.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0299gm.h;
        if (list4 != null) {
            c0647um.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0299gm.i;
        if (map != null) {
            c0647um.h = this.g.fromModel(map);
        }
        Je je = c0299gm.s;
        if (je != null) {
            c0647um.v = this.f810a.fromModel(je);
        }
        String str2 = c0299gm.j;
        if (str2 != null) {
            c0647um.j = str2;
        }
        String str3 = c0299gm.c;
        if (str3 != null) {
            c0647um.d = str3;
        }
        String str4 = c0299gm.d;
        if (str4 != null) {
            c0647um.e = str4;
        }
        String str5 = c0299gm.e;
        if (str5 != null) {
            c0647um.r = str5;
        }
        c0647um.i = this.b.fromModel(c0299gm.m);
        String str6 = c0299gm.k;
        if (str6 != null) {
            c0647um.k = str6;
        }
        String str7 = c0299gm.l;
        if (str7 != null) {
            c0647um.l = str7;
        }
        c0647um.m = c0299gm.p;
        c0647um.b = c0299gm.n;
        c0647um.q = c0299gm.o;
        RetryPolicyConfig retryPolicyConfig = c0299gm.t;
        c0647um.w = retryPolicyConfig.maxIntervalSeconds;
        c0647um.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0299gm.q;
        if (str8 != null) {
            c0647um.n = str8;
        }
        Em em = c0299gm.r;
        if (em != null) {
            this.c.getClass();
            C0622tm c0622tm = new C0622tm();
            c0622tm.f1063a = em.f415a;
            c0647um.p = c0622tm;
        }
        c0647um.u = c0299gm.w;
        BillingConfig billingConfig = c0299gm.x;
        if (billingConfig != null) {
            c0647um.z = this.d.fromModel(billingConfig);
        }
        C0753z3 c0753z3 = c0299gm.y;
        if (c0753z3 != null) {
            this.e.getClass();
            C0448mm c0448mm = new C0448mm();
            c0448mm.f945a = c0753z3.f1156a;
            c0647um.y = c0448mm;
        }
        C0552r2 c0552r2 = c0299gm.z;
        if (c0552r2 != null) {
            c0647um.A = this.f.fromModel(c0552r2);
        }
        c0647um.B = this.h.fromModel(c0299gm.A);
        c0647um.C = this.i.fromModel(c0299gm.B);
        c0647um.D = this.j.fromModel(c0299gm.C);
        return c0647um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0299gm toModel(C0647um c0647um) {
        C0274fm c0274fm = new C0274fm(this.b.toModel(c0647um.i));
        c0274fm.f843a = c0647um.f1080a;
        c0274fm.j = c0647um.j;
        c0274fm.c = c0647um.d;
        c0274fm.b = Arrays.asList(c0647um.c);
        c0274fm.g = Arrays.asList(c0647um.g);
        c0274fm.f = Arrays.asList(c0647um.f);
        c0274fm.d = c0647um.e;
        c0274fm.e = c0647um.r;
        c0274fm.h = Arrays.asList(c0647um.o);
        c0274fm.k = c0647um.k;
        c0274fm.l = c0647um.l;
        c0274fm.q = c0647um.m;
        c0274fm.o = c0647um.b;
        c0274fm.p = c0647um.q;
        c0274fm.t = c0647um.s;
        c0274fm.u = c0647um.t;
        c0274fm.r = c0647um.n;
        c0274fm.v = c0647um.u;
        c0274fm.w = new RetryPolicyConfig(c0647um.w, c0647um.x);
        c0274fm.i = this.g.toModel(c0647um.h);
        C0572rm c0572rm = c0647um.v;
        if (c0572rm != null) {
            this.f810a.getClass();
            c0274fm.n = new Je(c0572rm.f1031a, c0572rm.b);
        }
        C0622tm c0622tm = c0647um.p;
        if (c0622tm != null) {
            this.c.getClass();
            c0274fm.s = new Em(c0622tm.f1063a);
        }
        C0423lm c0423lm = c0647um.z;
        if (c0423lm != null) {
            this.d.getClass();
            c0274fm.x = new BillingConfig(c0423lm.f927a, c0423lm.b);
        }
        C0448mm c0448mm = c0647um.y;
        if (c0448mm != null) {
            this.e.getClass();
            c0274fm.y = new C0753z3(c0448mm.f945a);
        }
        C0398km c0398km = c0647um.A;
        if (c0398km != null) {
            c0274fm.z = this.f.toModel(c0398km);
        }
        C0597sm c0597sm = c0647um.B;
        if (c0597sm != null) {
            this.h.getClass();
            c0274fm.A = new Am(c0597sm.f1048a);
        }
        c0274fm.B = this.i.toModel(c0647um.C);
        C0498om c0498om = c0647um.D;
        if (c0498om != null) {
            this.j.getClass();
            c0274fm.C = new U9(c0498om.f979a);
        }
        return new C0299gm(c0274fm);
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0282gm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0726ye f1022a = new C0726ye();
    public final C0244fa b = new C0244fa();
    public final Hm c = new Hm();
    public final C0237f3 d = new C0237f3();
    public final C0440n2 e = new C0440n2();
    public final C0668w6 f = new C0668w6();
    public final Dm g = new Dm();
    public final C0501pd h = new C0501pd();
    public final C9 i = new C9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0684wm fromModel(C0359jm c0359jm) {
        C0684wm c0684wm = new C0684wm();
        c0684wm.s = c0359jm.u;
        c0684wm.t = c0359jm.v;
        String str = c0359jm.f1073a;
        if (str != null) {
            c0684wm.f1296a = str;
        }
        List list = c0359jm.f;
        if (list != null) {
            c0684wm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0359jm.g;
        if (list2 != null) {
            c0684wm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0359jm.b;
        if (list3 != null) {
            c0684wm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0359jm.h;
        if (list4 != null) {
            c0684wm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0359jm.i;
        if (map != null) {
            c0684wm.h = this.f.fromModel(map);
        }
        C0701xe c0701xe = c0359jm.s;
        if (c0701xe != null) {
            c0684wm.v = this.f1022a.fromModel(c0701xe);
        }
        String str2 = c0359jm.j;
        if (str2 != null) {
            c0684wm.j = str2;
        }
        String str3 = c0359jm.c;
        if (str3 != null) {
            c0684wm.d = str3;
        }
        String str4 = c0359jm.d;
        if (str4 != null) {
            c0684wm.e = str4;
        }
        String str5 = c0359jm.e;
        if (str5 != null) {
            c0684wm.r = str5;
        }
        c0684wm.i = this.b.fromModel(c0359jm.m);
        String str6 = c0359jm.k;
        if (str6 != null) {
            c0684wm.k = str6;
        }
        String str7 = c0359jm.l;
        if (str7 != null) {
            c0684wm.l = str7;
        }
        c0684wm.m = c0359jm.p;
        c0684wm.b = c0359jm.n;
        c0684wm.q = c0359jm.o;
        RetryPolicyConfig retryPolicyConfig = c0359jm.t;
        c0684wm.w = retryPolicyConfig.maxIntervalSeconds;
        c0684wm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0359jm.q;
        if (str8 != null) {
            c0684wm.n = str8;
        }
        Gm gm = c0359jm.r;
        if (gm != null) {
            this.c.getClass();
            C0659vm c0659vm = new C0659vm();
            c0659vm.f1280a = gm.f607a;
            c0684wm.p = c0659vm;
        }
        c0684wm.u = c0359jm.w;
        C0186d3 c0186d3 = c0359jm.x;
        if (c0186d3 != null) {
            this.d.getClass();
            C0485om c0485om = new C0485om();
            c0485om.f1166a = c0186d3.f955a;
            c0684wm.y = c0485om;
        }
        C0415m2 c0415m2 = c0359jm.y;
        if (c0415m2 != null) {
            c0684wm.z = this.e.fromModel(c0415m2);
        }
        c0684wm.A = this.g.fromModel(c0359jm.z);
        c0684wm.B = this.h.fromModel(c0359jm.A);
        c0684wm.C = this.i.fromModel(c0359jm.B);
        return c0684wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0359jm toModel(C0684wm c0684wm) {
        C0333im c0333im = new C0333im(this.b.toModel(c0684wm.i));
        c0333im.f1054a = c0684wm.f1296a;
        c0333im.j = c0684wm.j;
        c0333im.c = c0684wm.d;
        c0333im.b = Arrays.asList(c0684wm.c);
        c0333im.g = Arrays.asList(c0684wm.g);
        c0333im.f = Arrays.asList(c0684wm.f);
        c0333im.d = c0684wm.e;
        c0333im.e = c0684wm.r;
        c0333im.h = Arrays.asList(c0684wm.o);
        c0333im.k = c0684wm.k;
        c0333im.l = c0684wm.l;
        c0333im.q = c0684wm.m;
        c0333im.o = c0684wm.b;
        c0333im.p = c0684wm.q;
        c0333im.t = c0684wm.s;
        c0333im.u = c0684wm.t;
        c0333im.r = c0684wm.n;
        c0333im.v = c0684wm.u;
        c0333im.w = new RetryPolicyConfig(c0684wm.w, c0684wm.x);
        c0333im.i = this.f.toModel(c0684wm.h);
        C0609tm c0609tm = c0684wm.v;
        if (c0609tm != null) {
            this.f1022a.getClass();
            c0333im.n = new C0701xe(c0609tm.f1246a, c0609tm.b);
        }
        C0659vm c0659vm = c0684wm.p;
        if (c0659vm != null) {
            this.c.getClass();
            c0333im.s = new Gm(c0659vm.f1280a);
        }
        C0485om c0485om = c0684wm.y;
        if (c0485om != null) {
            this.d.getClass();
            c0333im.x = new C0186d3(c0485om.f1166a);
        }
        C0460nm c0460nm = c0684wm.z;
        if (c0460nm != null) {
            c0333im.y = this.e.toModel(c0460nm);
        }
        C0634um c0634um = c0684wm.A;
        if (c0634um != null) {
            this.g.getClass();
            c0333im.z = new Cm(c0634um.f1266a);
        }
        c0333im.A = this.h.toModel(c0684wm.B);
        C0535qm c0535qm = c0684wm.C;
        if (c0535qm != null) {
            this.i.getClass();
            c0333im.B = new B9(c0535qm.f1198a);
        }
        return new C0359jm(c0333im);
    }
}

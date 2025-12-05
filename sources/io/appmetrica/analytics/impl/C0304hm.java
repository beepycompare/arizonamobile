package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0304hm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0748ze f1011a = new C0748ze();
    public final C0266ga b = new C0266ga();
    public final Im c = new Im();
    public final C0259g3 d = new C0259g3();
    public final C0462o2 e = new C0462o2();
    public final C0690x6 f = new C0690x6();
    public final Em g = new Em();
    public final C0523qd h = new C0523qd();
    public final D9 i = new D9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0706xm fromModel(C0381km c0381km) {
        C0706xm c0706xm = new C0706xm();
        c0706xm.s = c0381km.u;
        c0706xm.t = c0381km.v;
        String str = c0381km.f1064a;
        if (str != null) {
            c0706xm.f1287a = str;
        }
        List list = c0381km.f;
        if (list != null) {
            c0706xm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0381km.g;
        if (list2 != null) {
            c0706xm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0381km.b;
        if (list3 != null) {
            c0706xm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0381km.h;
        if (list4 != null) {
            c0706xm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0381km.i;
        if (map != null) {
            c0706xm.h = this.f.fromModel(map);
        }
        C0723ye c0723ye = c0381km.s;
        if (c0723ye != null) {
            c0706xm.v = this.f1011a.fromModel(c0723ye);
        }
        String str2 = c0381km.j;
        if (str2 != null) {
            c0706xm.j = str2;
        }
        String str3 = c0381km.c;
        if (str3 != null) {
            c0706xm.d = str3;
        }
        String str4 = c0381km.d;
        if (str4 != null) {
            c0706xm.e = str4;
        }
        String str5 = c0381km.e;
        if (str5 != null) {
            c0706xm.r = str5;
        }
        c0706xm.i = this.b.fromModel(c0381km.m);
        String str6 = c0381km.k;
        if (str6 != null) {
            c0706xm.k = str6;
        }
        String str7 = c0381km.l;
        if (str7 != null) {
            c0706xm.l = str7;
        }
        c0706xm.m = c0381km.p;
        c0706xm.b = c0381km.n;
        c0706xm.q = c0381km.o;
        RetryPolicyConfig retryPolicyConfig = c0381km.t;
        c0706xm.w = retryPolicyConfig.maxIntervalSeconds;
        c0706xm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0381km.q;
        if (str8 != null) {
            c0706xm.n = str8;
        }
        Hm hm = c0381km.r;
        if (hm != null) {
            this.c.getClass();
            C0681wm c0681wm = new C0681wm();
            c0681wm.f1270a = hm.f596a;
            c0706xm.p = c0681wm;
        }
        c0706xm.u = c0381km.w;
        C0207e3 c0207e3 = c0381km.x;
        if (c0207e3 != null) {
            this.d.getClass();
            C0507pm c0507pm = new C0507pm();
            c0507pm.f1157a = c0207e3.f946a;
            c0706xm.y = c0507pm;
        }
        C0437n2 c0437n2 = c0381km.y;
        if (c0437n2 != null) {
            c0706xm.z = this.e.fromModel(c0437n2);
        }
        c0706xm.A = this.g.fromModel(c0381km.z);
        c0706xm.B = this.h.fromModel(c0381km.A);
        c0706xm.C = this.i.fromModel(c0381km.B);
        return c0706xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0381km toModel(C0706xm c0706xm) {
        C0355jm c0355jm = new C0355jm(this.b.toModel(c0706xm.i));
        c0355jm.f1044a = c0706xm.f1287a;
        c0355jm.j = c0706xm.j;
        c0355jm.c = c0706xm.d;
        c0355jm.b = Arrays.asList(c0706xm.c);
        c0355jm.g = Arrays.asList(c0706xm.g);
        c0355jm.f = Arrays.asList(c0706xm.f);
        c0355jm.d = c0706xm.e;
        c0355jm.e = c0706xm.r;
        c0355jm.h = Arrays.asList(c0706xm.o);
        c0355jm.k = c0706xm.k;
        c0355jm.l = c0706xm.l;
        c0355jm.q = c0706xm.m;
        c0355jm.o = c0706xm.b;
        c0355jm.p = c0706xm.q;
        c0355jm.t = c0706xm.s;
        c0355jm.u = c0706xm.t;
        c0355jm.r = c0706xm.n;
        c0355jm.v = c0706xm.u;
        c0355jm.w = new RetryPolicyConfig(c0706xm.w, c0706xm.x);
        c0355jm.i = this.f.toModel(c0706xm.h);
        C0631um c0631um = c0706xm.v;
        if (c0631um != null) {
            this.f1011a.getClass();
            c0355jm.n = new C0723ye(c0631um.f1237a, c0631um.b);
        }
        C0681wm c0681wm = c0706xm.p;
        if (c0681wm != null) {
            this.c.getClass();
            c0355jm.s = new Hm(c0681wm.f1270a);
        }
        C0507pm c0507pm = c0706xm.y;
        if (c0507pm != null) {
            this.d.getClass();
            c0355jm.x = new C0207e3(c0507pm.f1157a);
        }
        C0482om c0482om = c0706xm.z;
        if (c0482om != null) {
            c0355jm.y = this.e.toModel(c0482om);
        }
        C0656vm c0656vm = c0706xm.A;
        if (c0656vm != null) {
            this.g.getClass();
            c0355jm.z = new Dm(c0656vm.f1257a);
        }
        c0355jm.A = this.h.toModel(c0706xm.B);
        C0556rm c0556rm = c0706xm.C;
        if (c0556rm != null) {
            this.i.getClass();
            c0355jm.B = new C9(c0556rm.f1189a);
        }
        return new C0381km(c0355jm);
    }
}

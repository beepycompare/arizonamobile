package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Im implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ze f598a = new Ze();
    public final Ca b = new Ca();
    public final C0362jn c = new C0362jn();
    public final C0653v3 d = new C0653v3();
    public final A2 e = new A2();
    public final O6 f = new O6();
    public final C0259fn g = new C0259fn();
    public final Pd h = new Pd();
    public final X9 i = new X9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ym fromModel(Lm lm) {
        Ym ym = new Ym();
        ym.s = lm.u;
        ym.t = lm.v;
        String str = lm.f650a;
        if (str != null) {
            ym.f861a = str;
        }
        List list = lm.f;
        if (list != null) {
            ym.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = lm.g;
        if (list2 != null) {
            ym.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = lm.b;
        if (list3 != null) {
            ym.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = lm.h;
        if (list4 != null) {
            ym.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = lm.i;
        if (map != null) {
            ym.h = this.f.fromModel(map);
        }
        Ye ye = lm.s;
        if (ye != null) {
            ym.v = this.f598a.fromModel(ye);
        }
        String str2 = lm.j;
        if (str2 != null) {
            ym.j = str2;
        }
        String str3 = lm.c;
        if (str3 != null) {
            ym.d = str3;
        }
        String str4 = lm.d;
        if (str4 != null) {
            ym.e = str4;
        }
        String str5 = lm.e;
        if (str5 != null) {
            ym.r = str5;
        }
        ym.i = this.b.fromModel(lm.m);
        String str6 = lm.k;
        if (str6 != null) {
            ym.k = str6;
        }
        String str7 = lm.l;
        if (str7 != null) {
            ym.l = str7;
        }
        ym.m = lm.p;
        ym.b = lm.n;
        ym.q = lm.o;
        RetryPolicyConfig retryPolicyConfig = lm.t;
        ym.w = retryPolicyConfig.maxIntervalSeconds;
        ym.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = lm.q;
        if (str8 != null) {
            ym.n = str8;
        }
        C0336in c0336in = lm.r;
        if (c0336in != null) {
            this.c.getClass();
            Xm xm = new Xm();
            xm.f842a = c0336in.f1039a;
            ym.p = xm;
        }
        ym.u = lm.w;
        C0601t3 c0601t3 = lm.x;
        if (c0601t3 != null) {
            this.d.getClass();
            Qm qm = new Qm();
            qm.f736a = c0601t3.f1207a;
            ym.y = qm;
        }
        C0756z2 c0756z2 = lm.y;
        if (c0756z2 != null) {
            ym.z = this.e.fromModel(c0756z2);
        }
        ym.A = this.g.fromModel(lm.z);
        ym.B = this.h.fromModel(lm.A);
        ym.C = this.i.fromModel(lm.B);
        return ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Lm toModel(Ym ym) {
        Km km = new Km(this.b.toModel(ym.i));
        km.f632a = ym.f861a;
        km.j = ym.j;
        km.c = ym.d;
        km.b = Arrays.asList(ym.c);
        km.g = Arrays.asList(ym.g);
        km.f = Arrays.asList(ym.f);
        km.d = ym.e;
        km.e = ym.r;
        km.h = Arrays.asList(ym.o);
        km.k = ym.k;
        km.l = ym.l;
        km.q = ym.m;
        km.o = ym.b;
        km.p = ym.q;
        km.t = ym.s;
        km.u = ym.t;
        km.r = ym.n;
        km.v = ym.u;
        km.w = new RetryPolicyConfig(ym.w, ym.x);
        km.i = this.f.toModel(ym.h);
        Vm vm = ym.v;
        if (vm != null) {
            this.f598a.getClass();
            km.n = new Ye(vm.f812a, vm.b);
        }
        Xm xm = ym.p;
        if (xm != null) {
            this.c.getClass();
            km.s = new C0336in(xm.f842a);
        }
        Qm qm = ym.y;
        if (qm != null) {
            this.d.getClass();
            km.x = new C0601t3(qm.f736a);
        }
        Pm pm = ym.z;
        if (pm != null) {
            km.y = this.e.toModel(pm);
        }
        Wm wm = ym.A;
        if (wm != null) {
            this.g.getClass();
            km.z = new C0233en(wm.f830a);
        }
        km.A = this.h.toModel(ym.B);
        Sm sm = ym.C;
        if (sm != null) {
            this.i.getClass();
            km.B = new W9(sm.f766a);
        }
        return new Lm(km);
    }
}

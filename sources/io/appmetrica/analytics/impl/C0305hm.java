package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0305hm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0749ze f928a = new C0749ze();
    public final C0267ga b = new C0267ga();
    public final Im c = new Im();
    public final C0260g3 d = new C0260g3();
    public final C0463o2 e = new C0463o2();
    public final C0691x6 f = new C0691x6();
    public final Em g = new Em();
    public final C0524qd h = new C0524qd();
    public final D9 i = new D9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0707xm fromModel(C0382km c0382km) {
        C0707xm c0707xm = new C0707xm();
        c0707xm.s = c0382km.u;
        c0707xm.t = c0382km.v;
        String str = c0382km.f981a;
        if (str != null) {
            c0707xm.f1204a = str;
        }
        List list = c0382km.f;
        if (list != null) {
            c0707xm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0382km.g;
        if (list2 != null) {
            c0707xm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0382km.b;
        if (list3 != null) {
            c0707xm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0382km.h;
        if (list4 != null) {
            c0707xm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0382km.i;
        if (map != null) {
            c0707xm.h = this.f.fromModel(map);
        }
        C0724ye c0724ye = c0382km.s;
        if (c0724ye != null) {
            c0707xm.v = this.f928a.fromModel(c0724ye);
        }
        String str2 = c0382km.j;
        if (str2 != null) {
            c0707xm.j = str2;
        }
        String str3 = c0382km.c;
        if (str3 != null) {
            c0707xm.d = str3;
        }
        String str4 = c0382km.d;
        if (str4 != null) {
            c0707xm.e = str4;
        }
        String str5 = c0382km.e;
        if (str5 != null) {
            c0707xm.r = str5;
        }
        c0707xm.i = this.b.fromModel(c0382km.m);
        String str6 = c0382km.k;
        if (str6 != null) {
            c0707xm.k = str6;
        }
        String str7 = c0382km.l;
        if (str7 != null) {
            c0707xm.l = str7;
        }
        c0707xm.m = c0382km.p;
        c0707xm.b = c0382km.n;
        c0707xm.q = c0382km.o;
        RetryPolicyConfig retryPolicyConfig = c0382km.t;
        c0707xm.w = retryPolicyConfig.maxIntervalSeconds;
        c0707xm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0382km.q;
        if (str8 != null) {
            c0707xm.n = str8;
        }
        Hm hm = c0382km.r;
        if (hm != null) {
            this.c.getClass();
            C0682wm c0682wm = new C0682wm();
            c0682wm.f1187a = hm.f513a;
            c0707xm.p = c0682wm;
        }
        c0707xm.u = c0382km.w;
        C0208e3 c0208e3 = c0382km.x;
        if (c0208e3 != null) {
            this.d.getClass();
            C0508pm c0508pm = new C0508pm();
            c0508pm.f1074a = c0208e3.f863a;
            c0707xm.y = c0508pm;
        }
        C0438n2 c0438n2 = c0382km.y;
        if (c0438n2 != null) {
            c0707xm.z = this.e.fromModel(c0438n2);
        }
        c0707xm.A = this.g.fromModel(c0382km.z);
        c0707xm.B = this.h.fromModel(c0382km.A);
        c0707xm.C = this.i.fromModel(c0382km.B);
        return c0707xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0382km toModel(C0707xm c0707xm) {
        C0356jm c0356jm = new C0356jm(this.b.toModel(c0707xm.i));
        c0356jm.f961a = c0707xm.f1204a;
        c0356jm.j = c0707xm.j;
        c0356jm.c = c0707xm.d;
        c0356jm.b = Arrays.asList(c0707xm.c);
        c0356jm.g = Arrays.asList(c0707xm.g);
        c0356jm.f = Arrays.asList(c0707xm.f);
        c0356jm.d = c0707xm.e;
        c0356jm.e = c0707xm.r;
        c0356jm.h = Arrays.asList(c0707xm.o);
        c0356jm.k = c0707xm.k;
        c0356jm.l = c0707xm.l;
        c0356jm.q = c0707xm.m;
        c0356jm.o = c0707xm.b;
        c0356jm.p = c0707xm.q;
        c0356jm.t = c0707xm.s;
        c0356jm.u = c0707xm.t;
        c0356jm.r = c0707xm.n;
        c0356jm.v = c0707xm.u;
        c0356jm.w = new RetryPolicyConfig(c0707xm.w, c0707xm.x);
        c0356jm.i = this.f.toModel(c0707xm.h);
        C0632um c0632um = c0707xm.v;
        if (c0632um != null) {
            this.f928a.getClass();
            c0356jm.n = new C0724ye(c0632um.f1154a, c0632um.b);
        }
        C0682wm c0682wm = c0707xm.p;
        if (c0682wm != null) {
            this.c.getClass();
            c0356jm.s = new Hm(c0682wm.f1187a);
        }
        C0508pm c0508pm = c0707xm.y;
        if (c0508pm != null) {
            this.d.getClass();
            c0356jm.x = new C0208e3(c0508pm.f1074a);
        }
        C0483om c0483om = c0707xm.z;
        if (c0483om != null) {
            c0356jm.y = this.e.toModel(c0483om);
        }
        C0657vm c0657vm = c0707xm.A;
        if (c0657vm != null) {
            this.g.getClass();
            c0356jm.z = new Dm(c0657vm.f1174a);
        }
        c0356jm.A = this.h.toModel(c0707xm.B);
        C0557rm c0557rm = c0707xm.C;
        if (c0557rm != null) {
            this.i.getClass();
            c0356jm.B = new C9(c0557rm.f1106a);
        }
        return new C0382km(c0356jm);
    }
}

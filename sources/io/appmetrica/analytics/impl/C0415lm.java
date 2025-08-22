package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.lm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0415lm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Oe f957a = new Oe();
    public final Ca b = new Ca();
    public final Nm c = new Nm();
    public final C0619u2 d = new C0619u2();
    public final B3 e = new B3();
    public final C0569s2 f = new C0569s2();
    public final S6 g = new S6();
    public final Jm h = new Jm();
    public final Hd i = new Hd();
    public final Z9 j = new Z9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cm fromModel(C0490om c0490om) {
        Cm cm = new Cm();
        cm.s = c0490om.u;
        cm.t = c0490om.v;
        String str = c0490om.f1002a;
        if (str != null) {
            cm.f384a = str;
        }
        List list = c0490om.f;
        if (list != null) {
            cm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0490om.g;
        if (list2 != null) {
            cm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0490om.b;
        if (list3 != null) {
            cm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0490om.h;
        if (list4 != null) {
            cm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0490om.i;
        if (map != null) {
            cm.h = this.g.fromModel(map);
        }
        Ne ne = c0490om.s;
        if (ne != null) {
            cm.v = this.f957a.fromModel(ne);
        }
        String str2 = c0490om.j;
        if (str2 != null) {
            cm.j = str2;
        }
        String str3 = c0490om.c;
        if (str3 != null) {
            cm.d = str3;
        }
        String str4 = c0490om.d;
        if (str4 != null) {
            cm.e = str4;
        }
        String str5 = c0490om.e;
        if (str5 != null) {
            cm.r = str5;
        }
        cm.i = this.b.fromModel(c0490om.m);
        String str6 = c0490om.k;
        if (str6 != null) {
            cm.k = str6;
        }
        String str7 = c0490om.l;
        if (str7 != null) {
            cm.l = str7;
        }
        cm.m = c0490om.p;
        cm.b = c0490om.n;
        cm.q = c0490om.o;
        RetryPolicyConfig retryPolicyConfig = c0490om.t;
        cm.w = retryPolicyConfig.maxIntervalSeconds;
        cm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0490om.q;
        if (str8 != null) {
            cm.n = str8;
        }
        Mm mm = c0490om.r;
        if (mm != null) {
            this.c.getClass();
            Bm bm = new Bm();
            bm.f368a = mm.f566a;
            cm.p = bm;
        }
        cm.u = c0490om.w;
        BillingConfig billingConfig = c0490om.x;
        if (billingConfig != null) {
            cm.z = this.d.fromModel(billingConfig);
        }
        C0745z3 c0745z3 = c0490om.y;
        if (c0745z3 != null) {
            this.e.getClass();
            C0639um c0639um = new C0639um();
            c0639um.f1093a = c0745z3.f1171a;
            cm.y = c0639um;
        }
        C0544r2 c0544r2 = c0490om.z;
        if (c0544r2 != null) {
            cm.A = this.f.fromModel(c0544r2);
        }
        cm.B = this.h.fromModel(c0490om.A);
        cm.C = this.i.fromModel(c0490om.B);
        cm.D = this.j.fromModel(c0490om.C);
        return cm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0490om toModel(Cm cm) {
        C0465nm c0465nm = new C0465nm(this.b.toModel(cm.i));
        c0465nm.f988a = cm.f384a;
        c0465nm.j = cm.j;
        c0465nm.c = cm.d;
        c0465nm.b = Arrays.asList(cm.c);
        c0465nm.g = Arrays.asList(cm.g);
        c0465nm.f = Arrays.asList(cm.f);
        c0465nm.d = cm.e;
        c0465nm.e = cm.r;
        c0465nm.h = Arrays.asList(cm.o);
        c0465nm.k = cm.k;
        c0465nm.l = cm.l;
        c0465nm.q = cm.m;
        c0465nm.o = cm.b;
        c0465nm.p = cm.q;
        c0465nm.t = cm.s;
        c0465nm.u = cm.t;
        c0465nm.r = cm.n;
        c0465nm.v = cm.u;
        c0465nm.w = new RetryPolicyConfig(cm.w, cm.x);
        c0465nm.i = this.g.toModel(cm.h);
        C0764zm c0764zm = cm.v;
        if (c0764zm != null) {
            this.f957a.getClass();
            c0465nm.n = new Ne(c0764zm.f1185a, c0764zm.b);
        }
        Bm bm = cm.p;
        if (bm != null) {
            this.c.getClass();
            c0465nm.s = new Mm(bm.f368a);
        }
        C0614tm c0614tm = cm.z;
        if (c0614tm != null) {
            this.d.getClass();
            c0465nm.x = new BillingConfig(c0614tm.f1078a, c0614tm.b);
        }
        C0639um c0639um = cm.y;
        if (c0639um != null) {
            this.e.getClass();
            c0465nm.y = new C0745z3(c0639um.f1093a);
        }
        C0589sm c0589sm = cm.A;
        if (c0589sm != null) {
            c0465nm.z = this.f.toModel(c0589sm);
        }
        Am am = cm.B;
        if (am != null) {
            this.h.getClass();
            c0465nm.A = new Im(am.f350a);
        }
        c0465nm.B = this.i.toModel(cm.C);
        C0689wm c0689wm = cm.D;
        if (c0689wm != null) {
            this.j.getClass();
            c0465nm.C = new Y9(c0689wm.f1128a);
        }
        return new C0490om(c0465nm);
    }
}

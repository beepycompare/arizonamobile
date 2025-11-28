package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.km  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382km implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ee f978a = new Ee();
    public final C0421ma b = new C0421ma();
    public final Lm c = new Lm();
    public final C0439n3 d = new C0439n3();
    public final C0637v2 e = new C0637v2();
    public final D6 f = new D6();
    public final Hm g = new Hm();
    public final C0673wd h = new C0673wd();
    public final J9 i = new J9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Am fromModel(C0458nm c0458nm) {
        Am am = new Am();
        am.s = c0458nm.u;
        am.t = c0458nm.v;
        String str = c0458nm.f1028a;
        if (str != null) {
            am.f400a = str;
        }
        List list = c0458nm.f;
        if (list != null) {
            am.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0458nm.g;
        if (list2 != null) {
            am.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0458nm.b;
        if (list3 != null) {
            am.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0458nm.h;
        if (list4 != null) {
            am.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0458nm.i;
        if (map != null) {
            am.h = this.f.fromModel(map);
        }
        De de = c0458nm.s;
        if (de != null) {
            am.v = this.f978a.fromModel(de);
        }
        String str2 = c0458nm.j;
        if (str2 != null) {
            am.j = str2;
        }
        String str3 = c0458nm.c;
        if (str3 != null) {
            am.d = str3;
        }
        String str4 = c0458nm.d;
        if (str4 != null) {
            am.e = str4;
        }
        String str5 = c0458nm.e;
        if (str5 != null) {
            am.r = str5;
        }
        am.i = this.b.fromModel(c0458nm.m);
        String str6 = c0458nm.k;
        if (str6 != null) {
            am.k = str6;
        }
        String str7 = c0458nm.l;
        if (str7 != null) {
            am.l = str7;
        }
        am.m = c0458nm.p;
        am.b = c0458nm.n;
        am.q = c0458nm.o;
        RetryPolicyConfig retryPolicyConfig = c0458nm.t;
        am.w = retryPolicyConfig.maxIntervalSeconds;
        am.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0458nm.q;
        if (str8 != null) {
            am.n = str8;
        }
        Km km = c0458nm.r;
        if (km != null) {
            this.c.getClass();
            C0757zm c0757zm = new C0757zm();
            c0757zm.f1236a = km.f564a;
            am.p = c0757zm;
        }
        am.u = c0458nm.w;
        C0389l3 c0389l3 = c0458nm.x;
        if (c0389l3 != null) {
            this.d.getClass();
            C0582sm c0582sm = new C0582sm();
            c0582sm.f1119a = c0389l3.f982a;
            am.y = c0582sm;
        }
        C0612u2 c0612u2 = c0458nm.y;
        if (c0612u2 != null) {
            am.z = this.e.fromModel(c0612u2);
        }
        am.A = this.g.fromModel(c0458nm.z);
        am.B = this.h.fromModel(c0458nm.A);
        am.C = this.i.fromModel(c0458nm.B);
        return am;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0458nm toModel(Am am) {
        C0433mm c0433mm = new C0433mm(this.b.toModel(am.i));
        c0433mm.f1014a = am.f400a;
        c0433mm.j = am.j;
        c0433mm.c = am.d;
        c0433mm.b = Arrays.asList(am.c);
        c0433mm.g = Arrays.asList(am.g);
        c0433mm.f = Arrays.asList(am.f);
        c0433mm.d = am.e;
        c0433mm.e = am.r;
        c0433mm.h = Arrays.asList(am.o);
        c0433mm.k = am.k;
        c0433mm.l = am.l;
        c0433mm.q = am.m;
        c0433mm.o = am.b;
        c0433mm.p = am.q;
        c0433mm.t = am.s;
        c0433mm.u = am.t;
        c0433mm.r = am.n;
        c0433mm.v = am.u;
        c0433mm.w = new RetryPolicyConfig(am.w, am.x);
        c0433mm.i = this.f.toModel(am.h);
        C0707xm c0707xm = am.v;
        if (c0707xm != null) {
            this.f978a.getClass();
            c0433mm.n = new De(c0707xm.f1204a, c0707xm.b);
        }
        C0757zm c0757zm = am.p;
        if (c0757zm != null) {
            this.c.getClass();
            c0433mm.s = new Km(c0757zm.f1236a);
        }
        C0582sm c0582sm = am.y;
        if (c0582sm != null) {
            this.d.getClass();
            c0433mm.x = new C0389l3(c0582sm.f1119a);
        }
        C0557rm c0557rm = am.z;
        if (c0557rm != null) {
            c0433mm.y = this.e.toModel(c0557rm);
        }
        C0732ym c0732ym = am.A;
        if (c0732ym != null) {
            this.g.getClass();
            c0433mm.z = new Gm(c0732ym.f1218a);
        }
        c0433mm.A = this.h.toModel(am.B);
        C0632um c0632um = am.C;
        if (c0632um != null) {
            this.i.getClass();
            c0433mm.B = new I9(c0632um.f1157a);
        }
        return new C0458nm(c0433mm);
    }
}

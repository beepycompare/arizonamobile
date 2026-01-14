package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0283gm implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0727ye f1018a = new C0727ye();
    public final C0245fa b = new C0245fa();
    public final Hm c = new Hm();
    public final C0238f3 d = new C0238f3();
    public final C0441n2 e = new C0441n2();
    public final C0669w6 f = new C0669w6();
    public final Dm g = new Dm();
    public final C0502pd h = new C0502pd();
    public final C9 i = new C9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0685wm fromModel(C0360jm c0360jm) {
        C0685wm c0685wm = new C0685wm();
        c0685wm.s = c0360jm.u;
        c0685wm.t = c0360jm.v;
        String str = c0360jm.f1069a;
        if (str != null) {
            c0685wm.f1292a = str;
        }
        List list = c0360jm.f;
        if (list != null) {
            c0685wm.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c0360jm.g;
        if (list2 != null) {
            c0685wm.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c0360jm.b;
        if (list3 != null) {
            c0685wm.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c0360jm.h;
        if (list4 != null) {
            c0685wm.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c0360jm.i;
        if (map != null) {
            c0685wm.h = this.f.fromModel(map);
        }
        C0702xe c0702xe = c0360jm.s;
        if (c0702xe != null) {
            c0685wm.v = this.f1018a.fromModel(c0702xe);
        }
        String str2 = c0360jm.j;
        if (str2 != null) {
            c0685wm.j = str2;
        }
        String str3 = c0360jm.c;
        if (str3 != null) {
            c0685wm.d = str3;
        }
        String str4 = c0360jm.d;
        if (str4 != null) {
            c0685wm.e = str4;
        }
        String str5 = c0360jm.e;
        if (str5 != null) {
            c0685wm.r = str5;
        }
        c0685wm.i = this.b.fromModel(c0360jm.m);
        String str6 = c0360jm.k;
        if (str6 != null) {
            c0685wm.k = str6;
        }
        String str7 = c0360jm.l;
        if (str7 != null) {
            c0685wm.l = str7;
        }
        c0685wm.m = c0360jm.p;
        c0685wm.b = c0360jm.n;
        c0685wm.q = c0360jm.o;
        RetryPolicyConfig retryPolicyConfig = c0360jm.t;
        c0685wm.w = retryPolicyConfig.maxIntervalSeconds;
        c0685wm.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c0360jm.q;
        if (str8 != null) {
            c0685wm.n = str8;
        }
        Gm gm = c0360jm.r;
        if (gm != null) {
            this.c.getClass();
            C0660vm c0660vm = new C0660vm();
            c0660vm.f1276a = gm.f603a;
            c0685wm.p = c0660vm;
        }
        c0685wm.u = c0360jm.w;
        C0187d3 c0187d3 = c0360jm.x;
        if (c0187d3 != null) {
            this.d.getClass();
            C0486om c0486om = new C0486om();
            c0486om.f1162a = c0187d3.f951a;
            c0685wm.y = c0486om;
        }
        C0416m2 c0416m2 = c0360jm.y;
        if (c0416m2 != null) {
            c0685wm.z = this.e.fromModel(c0416m2);
        }
        c0685wm.A = this.g.fromModel(c0360jm.z);
        c0685wm.B = this.h.fromModel(c0360jm.A);
        c0685wm.C = this.i.fromModel(c0360jm.B);
        return c0685wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0360jm toModel(C0685wm c0685wm) {
        C0334im c0334im = new C0334im(this.b.toModel(c0685wm.i));
        c0334im.f1050a = c0685wm.f1292a;
        c0334im.j = c0685wm.j;
        c0334im.c = c0685wm.d;
        c0334im.b = Arrays.asList(c0685wm.c);
        c0334im.g = Arrays.asList(c0685wm.g);
        c0334im.f = Arrays.asList(c0685wm.f);
        c0334im.d = c0685wm.e;
        c0334im.e = c0685wm.r;
        c0334im.h = Arrays.asList(c0685wm.o);
        c0334im.k = c0685wm.k;
        c0334im.l = c0685wm.l;
        c0334im.q = c0685wm.m;
        c0334im.o = c0685wm.b;
        c0334im.p = c0685wm.q;
        c0334im.t = c0685wm.s;
        c0334im.u = c0685wm.t;
        c0334im.r = c0685wm.n;
        c0334im.v = c0685wm.u;
        c0334im.w = new RetryPolicyConfig(c0685wm.w, c0685wm.x);
        c0334im.i = this.f.toModel(c0685wm.h);
        C0610tm c0610tm = c0685wm.v;
        if (c0610tm != null) {
            this.f1018a.getClass();
            c0334im.n = new C0702xe(c0610tm.f1242a, c0610tm.b);
        }
        C0660vm c0660vm = c0685wm.p;
        if (c0660vm != null) {
            this.c.getClass();
            c0334im.s = new Gm(c0660vm.f1276a);
        }
        C0486om c0486om = c0685wm.y;
        if (c0486om != null) {
            this.d.getClass();
            c0334im.x = new C0187d3(c0486om.f1162a);
        }
        C0461nm c0461nm = c0685wm.z;
        if (c0461nm != null) {
            c0334im.y = this.e.toModel(c0461nm);
        }
        C0635um c0635um = c0685wm.A;
        if (c0635um != null) {
            this.g.getClass();
            c0334im.z = new Cm(c0635um.f1262a);
        }
        c0334im.A = this.h.toModel(c0685wm.B);
        C0536qm c0536qm = c0685wm.C;
        if (c0536qm != null) {
            this.i.getClass();
            c0334im.B = new B9(c0536qm.f1194a);
        }
        return new C0360jm(c0334im);
    }
}

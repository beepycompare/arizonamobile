package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.m9 */
/* loaded from: classes4.dex */
public final class C0427m9 {
    public static final Map h;
    public static final C0427m9 i;

    /* renamed from: a */
    public final Kd f936a;
    public final no b;
    public final O8 c;
    public final L9 d;
    public final InterfaceC0480oc e;
    public final InterfaceC0308he f;
    public final InterfaceC0279ga g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0677wa.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0677wa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0677wa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0427m9(new C0161bj(), new Vm(), new C0507pe(), new C0135aj(), new Ca(), new Da(), new Ba());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0427m9(C0402l9 c0402l9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Kd kd;
        no noVar;
        O8 o8;
        L9 l9;
        InterfaceC0480oc interfaceC0480oc;
        InterfaceC0308he interfaceC0308he;
        InterfaceC0279ga interfaceC0279ga;
        kd = c0402l9.f920a;
        noVar = c0402l9.b;
        o8 = c0402l9.c;
        l9 = c0402l9.d;
        interfaceC0480oc = c0402l9.e;
        interfaceC0308he = c0402l9.f;
        interfaceC0279ga = c0402l9.g;
    }

    public final C0676w9 a(C0203d9 c0203d9, C0659vh c0659vh) {
        C0676w9 c0676w9 = new C0676w9();
        C0651v9 a2 = this.f.a(c0203d9.l, c0203d9.m);
        C0551r9 a3 = this.e.a(c0203d9.g);
        if (a2 != null) {
            c0676w9.g = a2;
        }
        if (a3 != null) {
            c0676w9.f = a3;
        }
        String a4 = this.f936a.a(c0203d9.f802a);
        if (a4 != null) {
            c0676w9.d = a4;
        }
        c0676w9.e = this.b.a(c0203d9, c0659vh);
        String str = c0203d9.j;
        if (str != null) {
            c0676w9.h = str;
        }
        Integer a5 = this.d.a(c0203d9);
        if (a5 != null) {
            c0676w9.c = a5.intValue();
        }
        Long l = c0203d9.c;
        if (l != null) {
            c0676w9.f1103a = l.longValue();
        }
        Long l2 = c0203d9.d;
        if (l2 != null) {
            c0676w9.n = l2.longValue();
        }
        Long l3 = c0203d9.e;
        if (l3 != null) {
            c0676w9.o = l3.longValue();
        }
        Long l4 = c0203d9.f;
        if (l4 != null) {
            c0676w9.b = l4.longValue();
        }
        Integer num = c0203d9.k;
        if (num != null) {
            c0676w9.i = num.intValue();
        }
        c0676w9.j = this.c.a(c0203d9.o);
        B7 b7 = c0203d9.g;
        c0676w9.k = b7 != null ? new A6().a(b7.f350a) : -1;
        String str2 = c0203d9.n;
        if (str2 != null) {
            c0676w9.l = str2.getBytes();
        }
        EnumC0677wa enumC0677wa = c0203d9.p;
        Integer num2 = enumC0677wa != null ? (Integer) h.get(enumC0677wa) : null;
        if (num2 != null) {
            c0676w9.m = num2.intValue();
        }
        E9 e9 = c0203d9.q;
        if (e9 != null) {
            int ordinal = e9.ordinal();
            if (ordinal == 0) {
                c0676w9.p = 0;
            } else if (ordinal == 1) {
                c0676w9.p = 1;
            } else if (ordinal == 2) {
                c0676w9.p = 2;
            }
        }
        Boolean bool = c0203d9.r;
        if (bool != null) {
            c0676w9.q = bool.booleanValue();
        }
        Integer num3 = c0203d9.s;
        if (num3 != null) {
            c0676w9.r = num3.intValue();
        }
        c0676w9.s = ((Ba) this.g).a(c0203d9.t);
        return c0676w9;
    }

    public C0427m9(Kd kd, no noVar, O8 o8, L9 l9, InterfaceC0480oc interfaceC0480oc, InterfaceC0308he interfaceC0308he, InterfaceC0279ga interfaceC0279ga) {
        this.f936a = kd;
        this.b = noVar;
        this.c = o8;
        this.d = l9;
        this.e = interfaceC0480oc;
        this.f = interfaceC0308he;
        this.g = interfaceC0279ga;
    }

    public static C0402l9 a() {
        return new C0402l9(i);
    }
}

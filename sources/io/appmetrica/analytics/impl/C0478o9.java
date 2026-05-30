package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.o9 */
/* loaded from: classes5.dex */
public final class C0478o9 {
    public static final Map h;
    public static final C0478o9 i;

    /* renamed from: a */
    public final Xd f1127a;
    public final Wo b;
    public final R8 c;
    public final N9 d;
    public final InterfaceC0714xc e;
    public final InterfaceC0664ve f;
    public final InterfaceC0324ia g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Aa.FIRST_OCCURRENCE, 1);
        hashMap.put(Aa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(Aa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0478o9(new C0591sj(), new Bn(), new De(), new C0565rj(), new Ga(), new Ha(), new Fa());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0478o9(C0452n9 c0452n9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Xd xd;
        Wo wo;
        R8 r8;
        N9 n9;
        InterfaceC0714xc interfaceC0714xc;
        InterfaceC0664ve interfaceC0664ve;
        InterfaceC0324ia interfaceC0324ia;
        xd = c0452n9.f1112a;
        wo = c0452n9.b;
        r8 = c0452n9.c;
        n9 = c0452n9.d;
        interfaceC0714xc = c0452n9.e;
        interfaceC0664ve = c0452n9.f;
        interfaceC0324ia = c0452n9.g;
    }

    public final C0737y9 a(C0297h9 c0297h9, Eh eh) {
        C0737y9 c0737y9 = new C0737y9();
        C0711x9 a2 = this.f.a(c0297h9.l, c0297h9.m);
        C0607t9 a3 = this.e.a(c0297h9.g);
        if (a2 != null) {
            c0737y9.g = a2;
        }
        if (a3 != null) {
            c0737y9.f = a3;
        }
        String a4 = this.f1127a.a(c0297h9.f1010a);
        if (a4 != null) {
            c0737y9.d = a4;
        }
        c0737y9.e = this.b.a(c0297h9, eh);
        String str = c0297h9.j;
        if (str != null) {
            c0737y9.h = str;
        }
        Integer a5 = this.d.a(c0297h9);
        if (a5 != null) {
            c0737y9.c = a5.intValue();
        }
        Long l = c0297h9.c;
        if (l != null) {
            c0737y9.f1291a = l.longValue();
        }
        Long l2 = c0297h9.d;
        if (l2 != null) {
            c0737y9.n = l2.longValue();
        }
        Long l3 = c0297h9.e;
        if (l3 != null) {
            c0737y9.o = l3.longValue();
        }
        Long l4 = c0297h9.f;
        if (l4 != null) {
            c0737y9.b = l4.longValue();
        }
        Integer num = c0297h9.k;
        if (num != null) {
            c0737y9.i = num.intValue();
        }
        c0737y9.j = this.c.a(c0297h9.o);
        C0761z7 c0761z7 = c0297h9.g;
        c0737y9.k = c0761z7 != null ? new C0708x6().a(c0761z7.f1309a) : -1;
        String str2 = c0297h9.n;
        if (str2 != null) {
            c0737y9.l = str2.getBytes();
        }
        Aa aa = c0297h9.p;
        Integer num2 = aa != null ? (Integer) h.get(aa) : null;
        if (num2 != null) {
            c0737y9.m = num2.intValue();
        }
        G9 g9 = c0297h9.q;
        if (g9 != null) {
            int ordinal = g9.ordinal();
            if (ordinal == 0) {
                c0737y9.p = 0;
            } else if (ordinal == 1) {
                c0737y9.p = 1;
            } else if (ordinal == 2) {
                c0737y9.p = 2;
            }
        }
        Boolean bool = c0297h9.r;
        if (bool != null) {
            c0737y9.q = bool.booleanValue();
        }
        Integer num3 = c0297h9.s;
        if (num3 != null) {
            c0737y9.r = num3.intValue();
        }
        c0737y9.s = ((Fa) this.g).a(c0297h9.t);
        return c0737y9;
    }

    public C0478o9(Xd xd, Wo wo, R8 r8, N9 n9, InterfaceC0714xc interfaceC0714xc, InterfaceC0664ve interfaceC0664ve, InterfaceC0324ia interfaceC0324ia) {
        this.f1127a = xd;
        this.b = wo;
        this.c = r8;
        this.d = n9;
        this.e = interfaceC0714xc;
        this.f = interfaceC0664ve;
        this.g = interfaceC0324ia;
    }

    public static C0452n9 a() {
        return new C0452n9(i);
    }
}

package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.o9 */
/* loaded from: classes5.dex */
public final class C0471o9 {
    public static final Map h;
    public static final C0471o9 i;

    /* renamed from: a */
    public final Xd f1132a;
    public final Wo b;
    public final R8 c;
    public final N9 d;
    public final InterfaceC0707xc e;
    public final InterfaceC0657ve f;
    public final InterfaceC0317ia g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Aa.FIRST_OCCURRENCE, 1);
        hashMap.put(Aa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(Aa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0471o9(new C0584sj(), new Bn(), new De(), new C0558rj(), new Ga(), new Ha(), new Fa());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0471o9(C0445n9 c0445n9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Xd xd;
        Wo wo;
        R8 r8;
        N9 n9;
        InterfaceC0707xc interfaceC0707xc;
        InterfaceC0657ve interfaceC0657ve;
        InterfaceC0317ia interfaceC0317ia;
        xd = c0445n9.f1117a;
        wo = c0445n9.b;
        r8 = c0445n9.c;
        n9 = c0445n9.d;
        interfaceC0707xc = c0445n9.e;
        interfaceC0657ve = c0445n9.f;
        interfaceC0317ia = c0445n9.g;
    }

    public final C0730y9 a(C0290h9 c0290h9, Eh eh) {
        C0730y9 c0730y9 = new C0730y9();
        C0704x9 a2 = this.f.a(c0290h9.l, c0290h9.m);
        C0600t9 a3 = this.e.a(c0290h9.g);
        if (a2 != null) {
            c0730y9.g = a2;
        }
        if (a3 != null) {
            c0730y9.f = a3;
        }
        String a4 = this.f1132a.a(c0290h9.f1015a);
        if (a4 != null) {
            c0730y9.d = a4;
        }
        c0730y9.e = this.b.a(c0290h9, eh);
        String str = c0290h9.j;
        if (str != null) {
            c0730y9.h = str;
        }
        Integer a5 = this.d.a(c0290h9);
        if (a5 != null) {
            c0730y9.c = a5.intValue();
        }
        Long l = c0290h9.c;
        if (l != null) {
            c0730y9.f1296a = l.longValue();
        }
        Long l2 = c0290h9.d;
        if (l2 != null) {
            c0730y9.n = l2.longValue();
        }
        Long l3 = c0290h9.e;
        if (l3 != null) {
            c0730y9.o = l3.longValue();
        }
        Long l4 = c0290h9.f;
        if (l4 != null) {
            c0730y9.b = l4.longValue();
        }
        Integer num = c0290h9.k;
        if (num != null) {
            c0730y9.i = num.intValue();
        }
        c0730y9.j = this.c.a(c0290h9.o);
        C0754z7 c0754z7 = c0290h9.g;
        c0730y9.k = c0754z7 != null ? new C0701x6().a(c0754z7.f1314a) : -1;
        String str2 = c0290h9.n;
        if (str2 != null) {
            c0730y9.l = str2.getBytes();
        }
        Aa aa = c0290h9.p;
        Integer num2 = aa != null ? (Integer) h.get(aa) : null;
        if (num2 != null) {
            c0730y9.m = num2.intValue();
        }
        G9 g9 = c0290h9.q;
        if (g9 != null) {
            int ordinal = g9.ordinal();
            if (ordinal == 0) {
                c0730y9.p = 0;
            } else if (ordinal == 1) {
                c0730y9.p = 1;
            } else if (ordinal == 2) {
                c0730y9.p = 2;
            }
        }
        Boolean bool = c0290h9.r;
        if (bool != null) {
            c0730y9.q = bool.booleanValue();
        }
        Integer num3 = c0290h9.s;
        if (num3 != null) {
            c0730y9.r = num3.intValue();
        }
        c0730y9.s = ((Fa) this.g).a(c0290h9.t);
        return c0730y9;
    }

    public C0471o9(Xd xd, Wo wo, R8 r8, N9 n9, InterfaceC0707xc interfaceC0707xc, InterfaceC0657ve interfaceC0657ve, InterfaceC0317ia interfaceC0317ia) {
        this.f1132a = xd;
        this.b = wo;
        this.c = r8;
        this.d = n9;
        this.e = interfaceC0707xc;
        this.f = interfaceC0657ve;
        this.g = interfaceC0317ia;
    }

    public static C0445n9 a() {
        return new C0445n9(i);
    }
}

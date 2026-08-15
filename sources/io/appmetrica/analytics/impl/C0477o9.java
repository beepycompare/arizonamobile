package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.o9 */
/* loaded from: classes5.dex */
public final class C0477o9 {
    public static final Map h;
    public static final C0477o9 i;

    /* renamed from: a */
    public final Xd f1129a;
    public final Wo b;
    public final R8 c;
    public final N9 d;
    public final InterfaceC0713xc e;
    public final InterfaceC0663ve f;
    public final InterfaceC0323ia g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Aa.FIRST_OCCURRENCE, 1);
        hashMap.put(Aa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(Aa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0477o9(new C0590sj(), new Bn(), new De(), new C0564rj(), new Ga(), new Ha(), new Fa());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0477o9(C0451n9 c0451n9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Xd xd;
        Wo wo;
        R8 r8;
        N9 n9;
        InterfaceC0713xc interfaceC0713xc;
        InterfaceC0663ve interfaceC0663ve;
        InterfaceC0323ia interfaceC0323ia;
        xd = c0451n9.f1114a;
        wo = c0451n9.b;
        r8 = c0451n9.c;
        n9 = c0451n9.d;
        interfaceC0713xc = c0451n9.e;
        interfaceC0663ve = c0451n9.f;
        interfaceC0323ia = c0451n9.g;
    }

    public final C0736y9 a(C0296h9 c0296h9, Eh eh) {
        C0736y9 c0736y9 = new C0736y9();
        C0710x9 a2 = this.f.a(c0296h9.l, c0296h9.m);
        C0606t9 a3 = this.e.a(c0296h9.g);
        if (a2 != null) {
            c0736y9.g = a2;
        }
        if (a3 != null) {
            c0736y9.f = a3;
        }
        String a4 = this.f1129a.a(c0296h9.f1012a);
        if (a4 != null) {
            c0736y9.d = a4;
        }
        c0736y9.e = this.b.a(c0296h9, eh);
        String str = c0296h9.j;
        if (str != null) {
            c0736y9.h = str;
        }
        Integer a5 = this.d.a(c0296h9);
        if (a5 != null) {
            c0736y9.c = a5.intValue();
        }
        Long l = c0296h9.c;
        if (l != null) {
            c0736y9.f1293a = l.longValue();
        }
        Long l2 = c0296h9.d;
        if (l2 != null) {
            c0736y9.n = l2.longValue();
        }
        Long l3 = c0296h9.e;
        if (l3 != null) {
            c0736y9.o = l3.longValue();
        }
        Long l4 = c0296h9.f;
        if (l4 != null) {
            c0736y9.b = l4.longValue();
        }
        Integer num = c0296h9.k;
        if (num != null) {
            c0736y9.i = num.intValue();
        }
        c0736y9.j = this.c.a(c0296h9.o);
        C0760z7 c0760z7 = c0296h9.g;
        c0736y9.k = c0760z7 != null ? new C0707x6().a(c0760z7.f1311a) : -1;
        String str2 = c0296h9.n;
        if (str2 != null) {
            c0736y9.l = str2.getBytes();
        }
        Aa aa = c0296h9.p;
        Integer num2 = aa != null ? (Integer) h.get(aa) : null;
        if (num2 != null) {
            c0736y9.m = num2.intValue();
        }
        G9 g9 = c0296h9.q;
        if (g9 != null) {
            int ordinal = g9.ordinal();
            if (ordinal == 0) {
                c0736y9.p = 0;
            } else if (ordinal == 1) {
                c0736y9.p = 1;
            } else if (ordinal == 2) {
                c0736y9.p = 2;
            }
        }
        Boolean bool = c0296h9.r;
        if (bool != null) {
            c0736y9.q = bool.booleanValue();
        }
        Integer num3 = c0296h9.s;
        if (num3 != null) {
            c0736y9.r = num3.intValue();
        }
        c0736y9.s = ((Fa) this.g).a(c0296h9.t);
        return c0736y9;
    }

    public C0477o9(Xd xd, Wo wo, R8 r8, N9 n9, InterfaceC0713xc interfaceC0713xc, InterfaceC0663ve interfaceC0663ve, InterfaceC0323ia interfaceC0323ia) {
        this.f1129a = xd;
        this.b = wo;
        this.c = r8;
        this.d = n9;
        this.e = interfaceC0713xc;
        this.f = interfaceC0663ve;
        this.g = interfaceC0323ia;
    }

    public static C0451n9 a() {
        return new C0451n9(i);
    }
}

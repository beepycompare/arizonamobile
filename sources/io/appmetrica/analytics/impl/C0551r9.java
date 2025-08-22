package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.r9 */
/* loaded from: classes4.dex */
public final class C0551r9 {
    public static final Map h;
    public static final C0551r9 i;

    /* renamed from: a */
    public final Od f1041a;
    public final vo b;
    public final T8 c;
    public final Q9 d;
    public final InterfaceC0579sc e;
    public final InterfaceC0407le f;
    public final InterfaceC0377ka g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Aa.FIRST_OCCURRENCE, 1);
        hashMap.put(Aa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(Aa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0551r9(new C0360jj(), new C0210dn(), new C0606te(), new C0334ij(), new Ga(), new Ha(), new Fa());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0551r9(C0527q9 c0527q9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Od od;
        vo voVar;
        T8 t8;
        Q9 q9;
        InterfaceC0579sc interfaceC0579sc;
        InterfaceC0407le interfaceC0407le;
        InterfaceC0377ka interfaceC0377ka;
        od = c0527q9.f1023a;
        voVar = c0527q9.b;
        t8 = c0527q9.c;
        q9 = c0527q9.d;
        interfaceC0579sc = c0527q9.e;
        interfaceC0407le = c0527q9.f;
        interfaceC0377ka = c0527q9.g;
    }

    public final B9 a(C0325i9 c0325i9, Ch ch) {
        B9 b9 = new B9();
        A9 a2 = this.f.a(c0325i9.l, c0325i9.m);
        C0676w9 a3 = this.e.a(c0325i9.g);
        if (a2 != null) {
            b9.g = a2;
        }
        if (a3 != null) {
            b9.f = a3;
        }
        String a4 = this.f1041a.a(c0325i9.f904a);
        if (a4 != null) {
            b9.d = a4;
        }
        b9.e = this.b.a(c0325i9, ch);
        String str = c0325i9.j;
        if (str != null) {
            b9.h = str;
        }
        Integer a5 = this.d.a(c0325i9);
        if (a5 != null) {
            b9.c = a5.intValue();
        }
        Long l = c0325i9.c;
        if (l != null) {
            b9.f360a = l.longValue();
        }
        Long l2 = c0325i9.d;
        if (l2 != null) {
            b9.n = l2.longValue();
        }
        Long l3 = c0325i9.e;
        if (l3 != null) {
            b9.o = l3.longValue();
        }
        Long l4 = c0325i9.f;
        if (l4 != null) {
            b9.b = l4.longValue();
        }
        Integer num = c0325i9.k;
        if (num != null) {
            b9.i = num.intValue();
        }
        b9.j = this.c.a(c0325i9.o);
        F7 f7 = c0325i9.g;
        b9.k = f7 != null ? new D6().a(f7.f429a) : -1;
        String str2 = c0325i9.n;
        if (str2 != null) {
            b9.l = str2.getBytes();
        }
        Aa aa = c0325i9.p;
        Integer num2 = aa != null ? (Integer) h.get(aa) : null;
        if (num2 != null) {
            b9.m = num2.intValue();
        }
        J9 j9 = c0325i9.q;
        if (j9 != null) {
            int ordinal = j9.ordinal();
            if (ordinal == 0) {
                b9.p = 0;
            } else if (ordinal == 1) {
                b9.p = 1;
            } else if (ordinal == 2) {
                b9.p = 2;
            }
        }
        Boolean bool = c0325i9.r;
        if (bool != null) {
            b9.q = bool.booleanValue();
        }
        Integer num3 = c0325i9.s;
        if (num3 != null) {
            b9.r = num3.intValue();
        }
        b9.s = ((Fa) this.g).a(c0325i9.t);
        return b9;
    }

    public C0551r9(Od od, vo voVar, T8 t8, Q9 q9, InterfaceC0579sc interfaceC0579sc, InterfaceC0407le interfaceC0407le, InterfaceC0377ka interfaceC0377ka) {
        this.f1041a = od;
        this.b = voVar;
        this.c = t8;
        this.d = q9;
        this.e = interfaceC0579sc;
        this.f = interfaceC0407le;
        this.g = interfaceC0377ka;
    }

    public static C0527q9 a() {
        return new C0527q9(i);
    }
}

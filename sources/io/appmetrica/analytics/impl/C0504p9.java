package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.p9 */
/* loaded from: classes4.dex */
public final class C0504p9 {
    public static final Map h;
    public static final C0504p9 i;

    /* renamed from: a */
    public final Md f999a;
    public final qo b;
    public final R8 c;
    public final O9 d;
    public final InterfaceC0532qc e;
    public final InterfaceC0359je f;
    public final InterfaceC0331ia g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0729ya.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0729ya.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0729ya.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0504p9(new C0238ej(), new Ym(), new C0558re(), new C0213dj(), new Ea(), new Fa(), new Da());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0504p9(C0479o9 c0479o9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Md md;
        qo qoVar;
        R8 r8;
        O9 o9;
        InterfaceC0532qc interfaceC0532qc;
        InterfaceC0359je interfaceC0359je;
        InterfaceC0331ia interfaceC0331ia;
        md = c0479o9.f984a;
        qoVar = c0479o9.b;
        r8 = c0479o9.c;
        o9 = c0479o9.d;
        interfaceC0532qc = c0479o9.e;
        interfaceC0359je = c0479o9.f;
        interfaceC0331ia = c0479o9.g;
    }

    public final C0753z9 a(C0280g9 c0280g9, C0711xh c0711xh) {
        C0753z9 c0753z9 = new C0753z9();
        C0728y9 a2 = this.f.a(c0280g9.l, c0280g9.m);
        C0628u9 a3 = this.e.a(c0280g9.g);
        if (a2 != null) {
            c0753z9.g = a2;
        }
        if (a3 != null) {
            c0753z9.f = a3;
        }
        String a4 = this.f999a.a(c0280g9.f864a);
        if (a4 != null) {
            c0753z9.d = a4;
        }
        c0753z9.e = this.b.a(c0280g9, c0711xh);
        String str = c0280g9.j;
        if (str != null) {
            c0753z9.h = str;
        }
        Integer a5 = this.d.a(c0280g9);
        if (a5 != null) {
            c0753z9.c = a5.intValue();
        }
        Long l = c0280g9.c;
        if (l != null) {
            c0753z9.f1168a = l.longValue();
        }
        Long l2 = c0280g9.d;
        if (l2 != null) {
            c0753z9.n = l2.longValue();
        }
        Long l3 = c0280g9.e;
        if (l3 != null) {
            c0753z9.o = l3.longValue();
        }
        Long l4 = c0280g9.f;
        if (l4 != null) {
            c0753z9.b = l4.longValue();
        }
        Integer num = c0280g9.k;
        if (num != null) {
            c0753z9.i = num.intValue();
        }
        c0753z9.j = this.c.a(c0280g9.o);
        E7 e7 = c0280g9.g;
        c0753z9.k = e7 != null ? new D6().a(e7.f413a) : -1;
        String str2 = c0280g9.n;
        if (str2 != null) {
            c0753z9.l = str2.getBytes();
        }
        EnumC0729ya enumC0729ya = c0280g9.p;
        Integer num2 = enumC0729ya != null ? (Integer) h.get(enumC0729ya) : null;
        if (num2 != null) {
            c0753z9.m = num2.intValue();
        }
        H9 h9 = c0280g9.q;
        if (h9 != null) {
            int ordinal = h9.ordinal();
            if (ordinal == 0) {
                c0753z9.p = 0;
            } else if (ordinal == 1) {
                c0753z9.p = 1;
            } else if (ordinal == 2) {
                c0753z9.p = 2;
            }
        }
        Boolean bool = c0280g9.r;
        if (bool != null) {
            c0753z9.q = bool.booleanValue();
        }
        Integer num3 = c0280g9.s;
        if (num3 != null) {
            c0753z9.r = num3.intValue();
        }
        c0753z9.s = ((Da) this.g).a(c0280g9.t);
        return c0753z9;
    }

    public C0504p9(Md md, qo qoVar, R8 r8, O9 o9, InterfaceC0532qc interfaceC0532qc, InterfaceC0359je interfaceC0359je, InterfaceC0331ia interfaceC0331ia) {
        this.f999a = md;
        this.b = qoVar;
        this.c = r8;
        this.d = o9;
        this.e = interfaceC0532qc;
        this.f = interfaceC0359je;
        this.g = interfaceC0331ia;
    }

    public static C0479o9 a() {
        return new C0479o9(i);
    }
}

package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.p9 */
/* loaded from: classes4.dex */
public final class C0505p9 {
    public static final Map h;
    public static final C0505p9 i;

    /* renamed from: a */
    public final Md f998a;
    public final qo b;
    public final R8 c;
    public final O9 d;
    public final InterfaceC0533qc e;
    public final InterfaceC0360je f;
    public final InterfaceC0332ia g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0730ya.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0730ya.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0730ya.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0505p9(new C0239ej(), new Ym(), new C0559re(), new C0214dj(), new Ea(), new Fa(), new Da());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0505p9(C0480o9 c0480o9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Md md;
        qo qoVar;
        R8 r8;
        O9 o9;
        InterfaceC0533qc interfaceC0533qc;
        InterfaceC0360je interfaceC0360je;
        InterfaceC0332ia interfaceC0332ia;
        md = c0480o9.f983a;
        qoVar = c0480o9.b;
        r8 = c0480o9.c;
        o9 = c0480o9.d;
        interfaceC0533qc = c0480o9.e;
        interfaceC0360je = c0480o9.f;
        interfaceC0332ia = c0480o9.g;
    }

    public final C0754z9 a(C0281g9 c0281g9, C0712xh c0712xh) {
        C0754z9 c0754z9 = new C0754z9();
        C0729y9 a2 = this.f.a(c0281g9.l, c0281g9.m);
        C0629u9 a3 = this.e.a(c0281g9.g);
        if (a2 != null) {
            c0754z9.g = a2;
        }
        if (a3 != null) {
            c0754z9.f = a3;
        }
        String a4 = this.f998a.a(c0281g9.f863a);
        if (a4 != null) {
            c0754z9.d = a4;
        }
        c0754z9.e = this.b.a(c0281g9, c0712xh);
        String str = c0281g9.j;
        if (str != null) {
            c0754z9.h = str;
        }
        Integer a5 = this.d.a(c0281g9);
        if (a5 != null) {
            c0754z9.c = a5.intValue();
        }
        Long l = c0281g9.c;
        if (l != null) {
            c0754z9.f1167a = l.longValue();
        }
        Long l2 = c0281g9.d;
        if (l2 != null) {
            c0754z9.n = l2.longValue();
        }
        Long l3 = c0281g9.e;
        if (l3 != null) {
            c0754z9.o = l3.longValue();
        }
        Long l4 = c0281g9.f;
        if (l4 != null) {
            c0754z9.b = l4.longValue();
        }
        Integer num = c0281g9.k;
        if (num != null) {
            c0754z9.i = num.intValue();
        }
        c0754z9.j = this.c.a(c0281g9.o);
        E7 e7 = c0281g9.g;
        c0754z9.k = e7 != null ? new D6().a(e7.f412a) : -1;
        String str2 = c0281g9.n;
        if (str2 != null) {
            c0754z9.l = str2.getBytes();
        }
        EnumC0730ya enumC0730ya = c0281g9.p;
        Integer num2 = enumC0730ya != null ? (Integer) h.get(enumC0730ya) : null;
        if (num2 != null) {
            c0754z9.m = num2.intValue();
        }
        H9 h9 = c0281g9.q;
        if (h9 != null) {
            int ordinal = h9.ordinal();
            if (ordinal == 0) {
                c0754z9.p = 0;
            } else if (ordinal == 1) {
                c0754z9.p = 1;
            } else if (ordinal == 2) {
                c0754z9.p = 2;
            }
        }
        Boolean bool = c0281g9.r;
        if (bool != null) {
            c0754z9.q = bool.booleanValue();
        }
        Integer num3 = c0281g9.s;
        if (num3 != null) {
            c0754z9.r = num3.intValue();
        }
        c0754z9.s = ((Da) this.g).a(c0281g9.t);
        return c0754z9;
    }

    public C0505p9(Md md, qo qoVar, R8 r8, O9 o9, InterfaceC0533qc interfaceC0533qc, InterfaceC0360je interfaceC0360je, InterfaceC0332ia interfaceC0332ia) {
        this.f998a = md;
        this.b = qoVar;
        this.c = r8;
        this.d = o9;
        this.e = interfaceC0533qc;
        this.f = interfaceC0360je;
        this.g = interfaceC0332ia;
    }

    public static C0480o9 a() {
        return new C0480o9(i);
    }
}

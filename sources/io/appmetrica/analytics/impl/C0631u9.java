package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.u9 */
/* loaded from: classes4.dex */
public final class C0631u9 {
    public static final Map h;
    public static final C0631u9 i;

    /* renamed from: a */
    public final Sd f1108a;
    public final zo b;
    public final W8 c;
    public final T9 d;
    public final InterfaceC0659vc e;
    public final InterfaceC0512pe f;
    public final InterfaceC0456na g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Da.FIRST_OCCURRENCE, 1);
        hashMap.put(Da.NON_FIRST_OCCURENCE, 0);
        hashMap.put(Da.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0631u9(new C0465nj(), new C0314hn(), new C0711xe(), new C0439mj(), new Ja(), new Ka(), new Ia());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0631u9(C0606t9 c0606t9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Sd sd;
        zo zoVar;
        W8 w8;
        T9 t9;
        InterfaceC0659vc interfaceC0659vc;
        InterfaceC0512pe interfaceC0512pe;
        InterfaceC0456na interfaceC0456na;
        sd = c0606t9.f1093a;
        zoVar = c0606t9.b;
        w8 = c0606t9.c;
        t9 = c0606t9.d;
        interfaceC0659vc = c0606t9.e;
        interfaceC0512pe = c0606t9.f;
        interfaceC0456na = c0606t9.g;
    }

    public final E9 a(C0403l9 c0403l9, Gh gh) {
        E9 e9 = new E9();
        D9 a2 = this.f.a(c0403l9.l, c0403l9.m);
        C0756z9 a3 = this.e.a(c0403l9.g);
        if (a2 != null) {
            e9.g = a2;
        }
        if (a3 != null) {
            e9.f = a3;
        }
        String a4 = this.f1108a.a(c0403l9.f969a);
        if (a4 != null) {
            e9.d = a4;
        }
        e9.e = this.b.a(c0403l9, gh);
        String str = c0403l9.j;
        if (str != null) {
            e9.h = str;
        }
        Integer a5 = this.d.a(c0403l9);
        if (a5 != null) {
            e9.c = a5.intValue();
        }
        Long l = c0403l9.c;
        if (l != null) {
            e9.f426a = l.longValue();
        }
        Long l2 = c0403l9.d;
        if (l2 != null) {
            e9.n = l2.longValue();
        }
        Long l3 = c0403l9.e;
        if (l3 != null) {
            e9.o = l3.longValue();
        }
        Long l4 = c0403l9.f;
        if (l4 != null) {
            e9.b = l4.longValue();
        }
        Integer num = c0403l9.k;
        if (num != null) {
            e9.i = num.intValue();
        }
        e9.j = this.c.a(c0403l9.o);
        I7 i7 = c0403l9.g;
        e9.k = i7 != null ? new G6().a(i7.f492a) : -1;
        String str2 = c0403l9.n;
        if (str2 != null) {
            e9.l = str2.getBytes();
        }
        Da da = c0403l9.p;
        Integer num2 = da != null ? (Integer) h.get(da) : null;
        if (num2 != null) {
            e9.m = num2.intValue();
        }
        M9 m9 = c0403l9.q;
        if (m9 != null) {
            int ordinal = m9.ordinal();
            if (ordinal == 0) {
                e9.p = 0;
            } else if (ordinal == 1) {
                e9.p = 1;
            } else if (ordinal == 2) {
                e9.p = 2;
            }
        }
        Boolean bool = c0403l9.r;
        if (bool != null) {
            e9.q = bool.booleanValue();
        }
        Integer num3 = c0403l9.s;
        if (num3 != null) {
            e9.r = num3.intValue();
        }
        e9.s = ((Ia) this.g).a(c0403l9.t);
        return e9;
    }

    public C0631u9(Sd sd, zo zoVar, W8 w8, T9 t9, InterfaceC0659vc interfaceC0659vc, InterfaceC0512pe interfaceC0512pe, InterfaceC0456na interfaceC0456na) {
        this.f1108a = sd;
        this.b = zoVar;
        this.c = w8;
        this.d = t9;
        this.e = interfaceC0659vc;
        this.f = interfaceC0512pe;
        this.g = interfaceC0456na;
    }

    public static C0606t9 a() {
        return new C0606t9(i);
    }
}

package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.b9 */
/* loaded from: classes3.dex */
public final class C0137b9 {
    public static final Map h;
    public static final C0137b9 i;

    /* renamed from: a */
    public final Ed f814a;
    public final vo b;
    public final D8 c;
    public final A9 d;
    public final InterfaceC0166cc e;
    public final InterfaceC0142be f;
    public final U9 g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0370ka.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0370ka.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0370ka.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0137b9(new Wi(), new C0177cn(), new C0348je(), new Vi(), new C0521qa(), new C0545ra(), new C0496pa());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0137b9(C0111a9 c0111a9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Ed ed;
        vo voVar;
        D8 d8;
        A9 a9;
        InterfaceC0166cc interfaceC0166cc;
        InterfaceC0142be interfaceC0142be;
        U9 u9;
        ed = c0111a9.f799a;
        voVar = c0111a9.b;
        d8 = c0111a9.c;
        a9 = c0111a9.d;
        interfaceC0166cc = c0111a9.e;
        interfaceC0142be = c0111a9.f;
        u9 = c0111a9.g;
    }

    public final C0395l9 a(S8 s8, C0503ph c0503ph) {
        C0395l9 c0395l9 = new C0395l9();
        C0369k9 a2 = this.f.a(s8.l, s8.m);
        C0266g9 a3 = this.e.a(s8.g);
        if (a2 != null) {
            c0395l9.g = a2;
        }
        if (a3 != null) {
            c0395l9.f = a3;
        }
        String a4 = this.f814a.a(s8.f680a);
        if (a4 != null) {
            c0395l9.d = a4;
        }
        c0395l9.e = this.b.a(s8, c0503ph);
        String str = s8.j;
        if (str != null) {
            c0395l9.h = str;
        }
        Integer a5 = this.d.a(s8);
        if (a5 != null) {
            c0395l9.c = a5.intValue();
        }
        Long l = s8.c;
        if (l != null) {
            c0395l9.f988a = l.longValue();
        }
        Long l2 = s8.d;
        if (l2 != null) {
            c0395l9.n = l2.longValue();
        }
        Long l3 = s8.e;
        if (l3 != null) {
            c0395l9.o = l3.longValue();
        }
        Long l4 = s8.f;
        if (l4 != null) {
            c0395l9.b = l4.longValue();
        }
        Integer num = s8.k;
        if (num != null) {
            c0395l9.i = num.intValue();
        }
        c0395l9.j = this.c.a(s8.o);
        C0518q7 c0518q7 = s8.g;
        c0395l9.k = c0518q7 != null ? new C0467o6().a(c0518q7.f1068a) : -1;
        String str2 = s8.n;
        if (str2 != null) {
            c0395l9.l = str2.getBytes();
        }
        EnumC0370ka enumC0370ka = s8.p;
        Integer num2 = enumC0370ka != null ? (Integer) h.get(enumC0370ka) : null;
        if (num2 != null) {
            c0395l9.m = num2.intValue();
        }
        EnumC0594t9 enumC0594t9 = s8.q;
        if (enumC0594t9 != null) {
            int ordinal = enumC0594t9.ordinal();
            if (ordinal == 0) {
                c0395l9.p = 0;
            } else if (ordinal == 1) {
                c0395l9.p = 1;
            } else if (ordinal == 2) {
                c0395l9.p = 2;
            }
        }
        Boolean bool = s8.r;
        if (bool != null) {
            c0395l9.q = bool.booleanValue();
        }
        Integer num3 = s8.s;
        if (num3 != null) {
            c0395l9.r = num3.intValue();
        }
        c0395l9.s = ((C0496pa) this.g).a(s8.t);
        return c0395l9;
    }

    public C0137b9(Ed ed, vo voVar, D8 d8, A9 a9, InterfaceC0166cc interfaceC0166cc, InterfaceC0142be interfaceC0142be, U9 u9) {
        this.f814a = ed;
        this.b = voVar;
        this.c = d8;
        this.d = a9;
        this.e = interfaceC0166cc;
        this.f = interfaceC0142be;
        this.g = u9;
    }

    public static C0111a9 a() {
        return new C0111a9(i);
    }
}

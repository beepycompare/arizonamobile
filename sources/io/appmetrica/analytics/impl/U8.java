package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class U8 {
    public static final Map h;
    public static final U8 i;

    /* renamed from: a */
    public final InterfaceC0700xd f813a;
    public final to b;
    public final InterfaceC0720y8 c;
    public final InterfaceC0596t9 d;
    public final Vb e;
    public final Ud f;
    public final N9 g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0193da.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0193da.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0193da.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new U8(new Ri(), new Zm(), new C0171ce(), new Qi(), new C0347ja(), new C0373ka(), new C0322ia());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public U8(T8 t8) {
        this(r1, r2, r3, r4, r5, r6, r7);
        InterfaceC0700xd interfaceC0700xd;
        to toVar;
        InterfaceC0720y8 interfaceC0720y8;
        InterfaceC0596t9 interfaceC0596t9;
        Vb vb;
        Ud ud;
        N9 n9;
        interfaceC0700xd = t8.f800a;
        toVar = t8.b;
        interfaceC0720y8 = t8.c;
        interfaceC0596t9 = t8.d;
        vb = t8.e;
        ud = t8.f;
        n9 = t8.g;
    }

    public final C0217e9 a(N8 n8, C0380kh c0380kh) {
        C0217e9 c0217e9 = new C0217e9();
        C0192d9 a2 = this.f.a(n8.l, n8.m);
        Z8 a3 = this.e.a(n8.g);
        if (a2 != null) {
            c0217e9.g = a2;
        }
        if (a3 != null) {
            c0217e9.f = a3;
        }
        String a4 = this.f813a.a(n8.f712a);
        if (a4 != null) {
            c0217e9.d = a4;
        }
        c0217e9.e = this.b.a(n8, c0380kh);
        String str = n8.j;
        if (str != null) {
            c0217e9.h = str;
        }
        Integer a5 = this.d.a(n8);
        if (a5 != null) {
            c0217e9.c = a5.intValue();
        }
        Long l = n8.c;
        if (l != null) {
            c0217e9.f980a = l.longValue();
        }
        Long l2 = n8.d;
        if (l2 != null) {
            c0217e9.n = l2.longValue();
        }
        Long l3 = n8.e;
        if (l3 != null) {
            c0217e9.o = l3.longValue();
        }
        Long l4 = n8.f;
        if (l4 != null) {
            c0217e9.b = l4.longValue();
        }
        Integer num = n8.k;
        if (num != null) {
            c0217e9.i = num.intValue();
        }
        c0217e9.j = this.c.a(n8.o);
        C0319i7 c0319i7 = n8.g;
        c0217e9.k = c0319i7 != null ? new C0292h6().a(c0319i7.f1044a) : -1;
        String str2 = n8.n;
        if (str2 != null) {
            c0217e9.l = str2.getBytes();
        }
        EnumC0193da enumC0193da = n8.p;
        Integer num2 = enumC0193da != null ? (Integer) h.get(enumC0193da) : null;
        if (num2 != null) {
            c0217e9.m = num2.intValue();
        }
        EnumC0422m9 enumC0422m9 = n8.q;
        if (enumC0422m9 != null) {
            int ordinal = enumC0422m9.ordinal();
            if (ordinal == 0) {
                c0217e9.p = 0;
            } else if (ordinal == 1) {
                c0217e9.p = 1;
            } else if (ordinal == 2) {
                c0217e9.p = 2;
            }
        }
        Boolean bool = n8.r;
        if (bool != null) {
            c0217e9.q = bool.booleanValue();
        }
        Integer num3 = n8.s;
        if (num3 != null) {
            c0217e9.r = num3.intValue();
        }
        c0217e9.s = ((C0322ia) this.g).a(n8.t);
        return c0217e9;
    }

    public U8(InterfaceC0700xd interfaceC0700xd, to toVar, InterfaceC0720y8 interfaceC0720y8, InterfaceC0596t9 interfaceC0596t9, Vb vb, Ud ud, N9 n9) {
        this.f813a = interfaceC0700xd;
        this.b = toVar;
        this.c = interfaceC0720y8;
        this.d = interfaceC0596t9;
        this.e = vb;
        this.f = ud;
        this.g = n9;
    }

    public static T8 a() {
        return new T8(i);
    }
}

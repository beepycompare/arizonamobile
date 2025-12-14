package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class V8 {
    public static final Map h;
    public static final V8 i;

    /* renamed from: a */
    public final InterfaceC0722yd f817a;
    public final uo b;
    public final InterfaceC0742z8 c;
    public final InterfaceC0618u9 d;
    public final Wb e;
    public final Vd f;
    public final O9 g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0214ea.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0214ea.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0214ea.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new V8(new Si(), new C0124an(), new C0193de(), new Ri(), new C0369ka(), new C0395la(), new C0343ja());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V8(U8 u8) {
        this(r1, r2, r3, r4, r5, r6, r7);
        InterfaceC0722yd interfaceC0722yd;
        uo uoVar;
        InterfaceC0742z8 interfaceC0742z8;
        InterfaceC0618u9 interfaceC0618u9;
        Wb wb;
        Vd vd;
        O9 o9;
        interfaceC0722yd = u8.f804a;
        uoVar = u8.b;
        interfaceC0742z8 = u8.c;
        interfaceC0618u9 = u8.d;
        wb = u8.e;
        vd = u8.f;
        o9 = u8.g;
    }

    public final C0239f9 a(O8 o8, C0402lh c0402lh) {
        C0239f9 c0239f9 = new C0239f9();
        C0213e9 a2 = this.f.a(o8.l, o8.m);
        C0110a9 a3 = this.e.a(o8.g);
        if (a2 != null) {
            c0239f9.g = a2;
        }
        if (a3 != null) {
            c0239f9.f = a3;
        }
        String a4 = this.f817a.a(o8.f716a);
        if (a4 != null) {
            c0239f9.d = a4;
        }
        c0239f9.e = this.b.a(o8, c0402lh);
        String str = o8.j;
        if (str != null) {
            c0239f9.h = str;
        }
        Integer a5 = this.d.a(o8);
        if (a5 != null) {
            c0239f9.c = a5.intValue();
        }
        Long l = o8.c;
        if (l != null) {
            c0239f9.f985a = l.longValue();
        }
        Long l2 = o8.d;
        if (l2 != null) {
            c0239f9.n = l2.longValue();
        }
        Long l3 = o8.e;
        if (l3 != null) {
            c0239f9.o = l3.longValue();
        }
        Long l4 = o8.f;
        if (l4 != null) {
            c0239f9.b = l4.longValue();
        }
        Integer num = o8.k;
        if (num != null) {
            c0239f9.i = num.intValue();
        }
        c0239f9.j = this.c.a(o8.o);
        C0340j7 c0340j7 = o8.g;
        c0239f9.k = c0340j7 != null ? new C0314i6().a(c0340j7.f1048a) : -1;
        String str2 = o8.n;
        if (str2 != null) {
            c0239f9.l = str2.getBytes();
        }
        EnumC0214ea enumC0214ea = o8.p;
        Integer num2 = enumC0214ea != null ? (Integer) h.get(enumC0214ea) : null;
        if (num2 != null) {
            c0239f9.m = num2.intValue();
        }
        EnumC0444n9 enumC0444n9 = o8.q;
        if (enumC0444n9 != null) {
            int ordinal = enumC0444n9.ordinal();
            if (ordinal == 0) {
                c0239f9.p = 0;
            } else if (ordinal == 1) {
                c0239f9.p = 1;
            } else if (ordinal == 2) {
                c0239f9.p = 2;
            }
        }
        Boolean bool = o8.r;
        if (bool != null) {
            c0239f9.q = bool.booleanValue();
        }
        Integer num3 = o8.s;
        if (num3 != null) {
            c0239f9.r = num3.intValue();
        }
        c0239f9.s = ((C0343ja) this.g).a(o8.t);
        return c0239f9;
    }

    public V8(InterfaceC0722yd interfaceC0722yd, uo uoVar, InterfaceC0742z8 interfaceC0742z8, InterfaceC0618u9 interfaceC0618u9, Wb wb, Vd vd, O9 o9) {
        this.f817a = interfaceC0722yd;
        this.b = uoVar;
        this.c = interfaceC0742z8;
        this.d = interfaceC0618u9;
        this.e = wb;
        this.f = vd;
        this.g = o9;
    }

    public static U8 a() {
        return new U8(i);
    }
}

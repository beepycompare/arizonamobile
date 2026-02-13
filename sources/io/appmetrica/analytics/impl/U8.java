package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class U8 {
    public static final Map h;
    public static final U8 i;

    /* renamed from: a */
    public final InterfaceC0701xd f808a;
    public final to b;
    public final InterfaceC0721y8 c;
    public final InterfaceC0597t9 d;
    public final Vb e;
    public final Ud f;
    public final N9 g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0194da.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0194da.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0194da.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new U8(new Ri(), new Zm(), new C0172ce(), new Qi(), new C0348ja(), new C0374ka(), new C0323ia());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public U8(T8 t8) {
        this(r1, r2, r3, r4, r5, r6, r7);
        InterfaceC0701xd interfaceC0701xd;
        to toVar;
        InterfaceC0721y8 interfaceC0721y8;
        InterfaceC0597t9 interfaceC0597t9;
        Vb vb;
        Ud ud;
        N9 n9;
        interfaceC0701xd = t8.f795a;
        toVar = t8.b;
        interfaceC0721y8 = t8.c;
        interfaceC0597t9 = t8.d;
        vb = t8.e;
        ud = t8.f;
        n9 = t8.g;
    }

    public final C0218e9 a(N8 n8, C0381kh c0381kh) {
        C0218e9 c0218e9 = new C0218e9();
        C0193d9 a2 = this.f.a(n8.l, n8.m);
        Z8 a3 = this.e.a(n8.g);
        if (a2 != null) {
            c0218e9.g = a2;
        }
        if (a3 != null) {
            c0218e9.f = a3;
        }
        String a4 = this.f808a.a(n8.f707a);
        if (a4 != null) {
            c0218e9.d = a4;
        }
        c0218e9.e = this.b.a(n8, c0381kh);
        String str = n8.j;
        if (str != null) {
            c0218e9.h = str;
        }
        Integer a5 = this.d.a(n8);
        if (a5 != null) {
            c0218e9.c = a5.intValue();
        }
        Long l = n8.c;
        if (l != null) {
            c0218e9.f975a = l.longValue();
        }
        Long l2 = n8.d;
        if (l2 != null) {
            c0218e9.n = l2.longValue();
        }
        Long l3 = n8.e;
        if (l3 != null) {
            c0218e9.o = l3.longValue();
        }
        Long l4 = n8.f;
        if (l4 != null) {
            c0218e9.b = l4.longValue();
        }
        Integer num = n8.k;
        if (num != null) {
            c0218e9.i = num.intValue();
        }
        c0218e9.j = this.c.a(n8.o);
        C0320i7 c0320i7 = n8.g;
        c0218e9.k = c0320i7 != null ? new C0293h6().a(c0320i7.f1039a) : -1;
        String str2 = n8.n;
        if (str2 != null) {
            c0218e9.l = str2.getBytes();
        }
        EnumC0194da enumC0194da = n8.p;
        Integer num2 = enumC0194da != null ? (Integer) h.get(enumC0194da) : null;
        if (num2 != null) {
            c0218e9.m = num2.intValue();
        }
        EnumC0423m9 enumC0423m9 = n8.q;
        if (enumC0423m9 != null) {
            int ordinal = enumC0423m9.ordinal();
            if (ordinal == 0) {
                c0218e9.p = 0;
            } else if (ordinal == 1) {
                c0218e9.p = 1;
            } else if (ordinal == 2) {
                c0218e9.p = 2;
            }
        }
        Boolean bool = n8.r;
        if (bool != null) {
            c0218e9.q = bool.booleanValue();
        }
        Integer num3 = n8.s;
        if (num3 != null) {
            c0218e9.r = num3.intValue();
        }
        c0218e9.s = ((C0323ia) this.g).a(n8.t);
        return c0218e9;
    }

    public U8(InterfaceC0701xd interfaceC0701xd, to toVar, InterfaceC0721y8 interfaceC0721y8, InterfaceC0597t9 interfaceC0597t9, Vb vb, Ud ud, N9 n9) {
        this.f808a = interfaceC0701xd;
        this.b = toVar;
        this.c = interfaceC0721y8;
        this.d = interfaceC0597t9;
        this.e = vb;
        this.f = ud;
        this.g = n9;
    }

    public static T8 a() {
        return new T8(i);
    }
}

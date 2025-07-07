package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.m9 */
/* loaded from: classes4.dex */
public final class C0435m9 {
    public static final Map h;
    public static final C0435m9 i;

    /* renamed from: a */
    public final Kd f935a;
    public final no b;
    public final O8 c;
    public final L9 d;
    public final InterfaceC0488oc e;
    public final InterfaceC0316he f;
    public final InterfaceC0287ga g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0685wa.FIRST_OCCURRENCE, 1);
        hashMap.put(EnumC0685wa.NON_FIRST_OCCURENCE, 0);
        hashMap.put(EnumC0685wa.UNKNOWN, -1);
        h = Collections.unmodifiableMap(hashMap);
        i = new C0435m9(new C0169bj(), new Vm(), new C0515pe(), new C0143aj(), new Ca(), new Da(), new Ba());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0435m9(C0410l9 c0410l9) {
        this(r1, r2, r3, r4, r5, r6, r7);
        Kd kd;
        no noVar;
        O8 o8;
        L9 l9;
        InterfaceC0488oc interfaceC0488oc;
        InterfaceC0316he interfaceC0316he;
        InterfaceC0287ga interfaceC0287ga;
        kd = c0410l9.f919a;
        noVar = c0410l9.b;
        o8 = c0410l9.c;
        l9 = c0410l9.d;
        interfaceC0488oc = c0410l9.e;
        interfaceC0316he = c0410l9.f;
        interfaceC0287ga = c0410l9.g;
    }

    public final C0684w9 a(C0211d9 c0211d9, C0667vh c0667vh) {
        C0684w9 c0684w9 = new C0684w9();
        C0659v9 a2 = this.f.a(c0211d9.l, c0211d9.m);
        C0559r9 a3 = this.e.a(c0211d9.g);
        if (a2 != null) {
            c0684w9.g = a2;
        }
        if (a3 != null) {
            c0684w9.f = a3;
        }
        String a4 = this.f935a.a(c0211d9.f801a);
        if (a4 != null) {
            c0684w9.d = a4;
        }
        c0684w9.e = this.b.a(c0211d9, c0667vh);
        String str = c0211d9.j;
        if (str != null) {
            c0684w9.h = str;
        }
        Integer a5 = this.d.a(c0211d9);
        if (a5 != null) {
            c0684w9.c = a5.intValue();
        }
        Long l = c0211d9.c;
        if (l != null) {
            c0684w9.f1102a = l.longValue();
        }
        Long l2 = c0211d9.d;
        if (l2 != null) {
            c0684w9.n = l2.longValue();
        }
        Long l3 = c0211d9.e;
        if (l3 != null) {
            c0684w9.o = l3.longValue();
        }
        Long l4 = c0211d9.f;
        if (l4 != null) {
            c0684w9.b = l4.longValue();
        }
        Integer num = c0211d9.k;
        if (num != null) {
            c0684w9.i = num.intValue();
        }
        c0684w9.j = this.c.a(c0211d9.o);
        B7 b7 = c0211d9.g;
        c0684w9.k = b7 != null ? new A6().a(b7.f349a) : -1;
        String str2 = c0211d9.n;
        if (str2 != null) {
            c0684w9.l = str2.getBytes();
        }
        EnumC0685wa enumC0685wa = c0211d9.p;
        Integer num2 = enumC0685wa != null ? (Integer) h.get(enumC0685wa) : null;
        if (num2 != null) {
            c0684w9.m = num2.intValue();
        }
        E9 e9 = c0211d9.q;
        if (e9 != null) {
            int ordinal = e9.ordinal();
            if (ordinal == 0) {
                c0684w9.p = 0;
            } else if (ordinal == 1) {
                c0684w9.p = 1;
            } else if (ordinal == 2) {
                c0684w9.p = 2;
            }
        }
        Boolean bool = c0211d9.r;
        if (bool != null) {
            c0684w9.q = bool.booleanValue();
        }
        Integer num3 = c0211d9.s;
        if (num3 != null) {
            c0684w9.r = num3.intValue();
        }
        c0684w9.s = ((Ba) this.g).a(c0211d9.t);
        return c0684w9;
    }

    public C0435m9(Kd kd, no noVar, O8 o8, L9 l9, InterfaceC0488oc interfaceC0488oc, InterfaceC0316he interfaceC0316he, InterfaceC0287ga interfaceC0287ga) {
        this.f935a = kd;
        this.b = noVar;
        this.c = o8;
        this.d = l9;
        this.e = interfaceC0488oc;
        this.f = interfaceC0316he;
        this.g = interfaceC0287ga;
    }

    public static C0410l9 a() {
        return new C0410l9(i);
    }
}

package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class U3 extends W5 {
    public HashMap q;
    public C0125an r;
    public Ym s;
    public Ym t;
    public C0286h3 u;
    public C0125an v;

    public U3(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static W5 b(String str, String str2) {
        W5 w5 = new W5("", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = 5376;
        w5.a(str, str2);
        return w5;
    }

    public static W5 n() {
        W5 w5 = new W5("", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = 5632;
        return w5;
    }

    public static W5 o() {
        W5 w5 = new W5("", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = 40961;
        return w5;
    }

    public final void a(String str, String str2, T3 t3) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(t3, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(t3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.W5
    public final void c(String str) {
        C0125an c0125an = this.v;
        c0125an.getClass();
        this.h = c0125an.a(str);
    }

    public final String d(String str) {
        C0125an c0125an = this.r;
        c0125an.getClass();
        String a2 = c0125an.a(str);
        a(str, a2, T3.NAME);
        return a2;
    }

    public final String e(String str) {
        Ym ym = this.s;
        ym.getClass();
        String a2 = ym.a(str);
        a(str, a2, T3.VALUE);
        return a2;
    }

    public final U3 f(String str) {
        Ym ym = this.t;
        ym.getClass();
        String a2 = ym.a(str);
        a(str, a2, T3.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<T3, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.W5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f741a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.W5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.W5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public U3(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public U3(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final U3 a(HashMap<T3, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public U3(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f741a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0125an(1000, "event name", publicLogger);
        this.s = new Ym(245760, "event value", publicLogger);
        this.t = new Ym(1024000, "event extended value", publicLogger);
        this.u = new C0286h3(245760, "event value bytes", publicLogger);
        this.v = new C0125an(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0286h3 c0286h3 = this.u;
        c0286h3.getClass();
        byte[] a2 = c0286h3.a(bArr);
        T3 t3 = T3.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(t3, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(t3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static W5 a(C0384ko c0384ko) {
        W5 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0384ko), 0)));
        return o;
    }

    public static U3 a(PublicLogger publicLogger, Ti ti) {
        int i;
        U3 u3 = new U3(publicLogger);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        u3.d = 40976;
        Ri ri = new Ri();
        ri.b = ti.f708a.currency.getCurrencyCode().getBytes();
        ri.f = ti.f708a.priceMicros;
        ri.c = StringUtils.stringToBytesForProtobuf(new C0125an(200, "revenue productID", ti.e).a(ti.f708a.productID));
        ri.f669a = ((Integer) WrapUtils.getOrDefault(ti.f708a.quantity, 1)).intValue();
        Ym ym = ti.b;
        String str = ti.f708a.payload;
        ym.getClass();
        ri.d = StringUtils.stringToBytesForProtobuf(ym.a(str));
        if (no.a(ti.f708a.receipt)) {
            Mi mi = new Mi();
            String str2 = (String) ti.c.a(ti.f708a.receipt.data);
            i = !StringUtils.equalsNullSafety(ti.f708a.receipt.data, str2) ? ti.f708a.receipt.data.length() : 0;
            mi.f594a = StringUtils.stringToBytesForProtobuf(str2);
            mi.b = StringUtils.stringToBytesForProtobuf((String) ti.d.a(ti.f708a.receipt.signature));
            ri.e = mi;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(ri), Integer.valueOf(i));
        u3.b = u3.e(new String(Base64.encode((byte[]) pair.first, 0)));
        u3.g = ((Integer) pair.second).intValue();
        return u3;
    }

    public U3(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f741a = d(str);
        setType(i);
    }

    public static U3 a(PublicLogger publicLogger, E e) {
        U3 u3 = new U3(publicLogger);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        u3.d = 40977;
        kotlin.Pair a2 = e.a();
        u3.b = u3.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        u3.g = ((Integer) a2.getSecond()).intValue();
        return u3;
    }
}

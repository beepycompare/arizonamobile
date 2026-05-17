package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class M3 extends P5 {
    public HashMap q;
    public Xm r;
    public Um s;
    public Um t;
    public Z2 u;
    public Xm v;

    public M3(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static P5 b(String str, String str2) {
        P5 p5 = new P5("", 0);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        p5.d = 5376;
        p5.a(str, str2);
        return p5;
    }

    public static P5 n() {
        P5 p5 = new P5("", 0);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        p5.d = 5632;
        return p5;
    }

    public static P5 o() {
        P5 p5 = new P5("", 0);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        p5.d = 40961;
        return p5;
    }

    public final void a(String str, String str2, L3 l3) {
        boolean equalsNullSafety = StringUtils.equalsNullSafety(str, str2);
        HashMap hashMap = this.q;
        if (!equalsNullSafety) {
            hashMap.put(l3, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            hashMap.remove(l3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.P5
    public final void c(String str) {
        Xm xm = this.v;
        xm.getClass();
        this.h = xm.a(str);
    }

    public final String d(String str) {
        Xm xm = this.r;
        xm.getClass();
        String a2 = xm.a(str);
        a(str, a2, L3.NAME);
        return a2;
    }

    public final String e(String str) {
        Um um = this.s;
        um.getClass();
        String a2 = um.a(str);
        a(str, a2, L3.VALUE);
        return a2;
    }

    public final M3 f(String str) {
        Um um = this.t;
        um.getClass();
        String a2 = um.a(str);
        a(str, a2, L3.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<L3, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.P5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f741a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.P5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.P5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public M3(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public M3(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final M3 a(HashMap<L3, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public M3(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f741a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new Xm(1000, "event name", publicLogger);
        this.s = new Um(245760, "event value", publicLogger);
        this.t = new Um(1024000, "event extended value", publicLogger);
        this.u = new Z2(245760, "event value bytes", publicLogger);
        this.v = new Xm(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        Z2 z2 = this.u;
        z2.getClass();
        byte[] a2 = z2.a(bArr);
        L3 l3 = L3.VALUE;
        int length = bArr.length;
        int length2 = a2.length;
        HashMap hashMap = this.q;
        if (length != length2) {
            hashMap.put(l3, Integer.valueOf(bArr.length - a2.length));
        } else {
            hashMap.remove(l3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static P5 a(C0335io c0335io) {
        P5 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0335io), 0)));
        return o;
    }

    public static M3 a(PublicLogger publicLogger, Oi oi) {
        int i;
        M3 m3 = new M3(publicLogger);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        m3.d = 40976;
        Mi mi = new Mi();
        mi.b = oi.f731a.currency.getCurrencyCode().getBytes();
        mi.f = oi.f731a.priceMicros;
        mi.c = StringUtils.stringToBytesForProtobuf(new Xm(200, "revenue productID", oi.e).a(oi.f731a.productID));
        mi.f702a = ((Integer) WrapUtils.getOrDefault(oi.f731a.quantity, 1)).intValue();
        Um um = oi.b;
        String str = oi.f731a.payload;
        um.getClass();
        mi.d = StringUtils.stringToBytesForProtobuf(um.a(str));
        if (lo.a(oi.f731a.receipt)) {
            Hi hi = new Hi();
            String str2 = (String) oi.c.a(oi.f731a.receipt.data);
            i = !StringUtils.equalsNullSafety(oi.f731a.receipt.data, str2) ? oi.f731a.receipt.data.length() : 0;
            hi.f620a = StringUtils.stringToBytesForProtobuf(str2);
            hi.b = StringUtils.stringToBytesForProtobuf((String) oi.d.a(oi.f731a.receipt.signature));
            mi.e = hi;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(mi), Integer.valueOf(i));
        m3.b = m3.e(new String(Base64.encode((byte[]) pair.first, 0)));
        m3.g = ((Integer) pair.second).intValue();
        return m3;
    }

    public M3(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f741a = d(str);
        setType(i);
    }

    public static M3 a(PublicLogger publicLogger, E e) {
        M3 m3 = new M3(publicLogger);
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        m3.d = 40977;
        kotlin.Pair a2 = e.a();
        m3.b = m3.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        m3.g = ((Integer) a2.getSecond()).intValue();
        return m3;
    }
}

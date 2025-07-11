package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0323i4 extends C0325i6 {
    public HashMap q;
    public Tm r;
    public Rm s;
    public Rm t;
    public C0645v3 u;
    public Tm v;

    public C0323i4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C0325i6 b(String str, String str2) {
        C0325i6 c0325i6 = new C0325i6("", 0);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0325i6.d = 5376;
        c0325i6.a(str, str2);
        return c0325i6;
    }

    public static C0325i6 n() {
        C0325i6 c0325i6 = new C0325i6("", 0);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0325i6.d = 5632;
        return c0325i6;
    }

    public static C0325i6 o() {
        C0325i6 c0325i6 = new C0325i6("", 0);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0325i6.d = 40961;
        return c0325i6;
    }

    public final void a(String str, String str2, EnumC0298h4 enumC0298h4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC0298h4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC0298h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0325i6
    public final void c(String str) {
        Tm tm = this.v;
        tm.getClass();
        this.h = tm.a(str);
    }

    public final String d(String str) {
        Tm tm = this.r;
        tm.getClass();
        String a2 = tm.a(str);
        a(str, a2, EnumC0298h4.NAME);
        return a2;
    }

    public final String e(String str) {
        Rm rm = this.s;
        rm.getClass();
        String a2 = rm.a(str);
        a(str, a2, EnumC0298h4.VALUE);
        return a2;
    }

    public final C0323i4 f(String str) {
        Rm rm = this.t;
        rm.getClass();
        String a2 = rm.a(str);
        a(str, a2, EnumC0298h4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0298h4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0325i6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f875a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0325i6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0325i6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0323i4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0323i4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C0323i4 a(HashMap<EnumC0298h4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public C0323i4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f875a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new Tm(1000, "event name", publicLogger);
        this.s = new Rm(245760, "event value", publicLogger);
        this.t = new Rm(1024000, "event extended value", publicLogger);
        this.u = new C0645v3(245760, "event value bytes", publicLogger);
        this.v = new Tm(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0645v3 c0645v3 = this.u;
        c0645v3.getClass();
        byte[] a2 = c0645v3.a(bArr);
        EnumC0298h4 enumC0298h4 = EnumC0298h4.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(enumC0298h4, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(enumC0298h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0325i6 a(C0192co c0192co) {
        C0325i6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0192co), 0)));
        return o;
    }

    public static C0323i4 a(PublicLogger publicLogger, Yi yi) {
        int i;
        C0323i4 c0323i4 = new C0323i4(publicLogger);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0323i4.d = 40976;
        Wi wi = new Wi();
        wi.b = yi.f725a.currency.getCurrencyCode().getBytes();
        wi.f = yi.f725a.priceMicros;
        wi.c = StringUtils.stringToBytesForProtobuf(new Tm(200, "revenue productID", yi.e).a(yi.f725a.productID));
        wi.f691a = ((Integer) WrapUtils.getOrDefault(yi.f725a.quantity, 1)).intValue();
        Rm rm = yi.b;
        String str = yi.f725a.payload;
        rm.getClass();
        wi.d = StringUtils.stringToBytesForProtobuf(rm.a(str));
        if (fo.a(yi.f725a.receipt)) {
            Ri ri = new Ri();
            String str2 = (String) yi.c.a(yi.f725a.receipt.data);
            i = !StringUtils.equalsNullSafety(yi.f725a.receipt.data, str2) ? yi.f725a.receipt.data.length() : 0;
            ri.f613a = StringUtils.stringToBytesForProtobuf(str2);
            ri.b = StringUtils.stringToBytesForProtobuf((String) yi.d.a(yi.f725a.receipt.signature));
            wi.e = ri;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(wi), Integer.valueOf(i));
        c0323i4.b = c0323i4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0323i4.g = ((Integer) pair.second).intValue();
        return c0323i4;
    }

    public C0323i4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f875a = d(str);
        setType(i);
    }

    public static C0323i4 a(PublicLogger publicLogger, D d) {
        C0323i4 c0323i4 = new C0323i4(publicLogger);
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        c0323i4.d = 40977;
        kotlin.Pair a2 = d.a();
        c0323i4.b = c0323i4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0323i4.g = ((Integer) a2.getSecond()).intValue();
        return c0323i4;
    }
}

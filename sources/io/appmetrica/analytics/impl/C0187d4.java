package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0187d4 extends C0240f6 {
    public HashMap q;
    public C0775zn r;
    public C0697wn s;
    public C0697wn t;
    public C0496p3 u;
    public C0775zn v;

    public C0187d4(PublicLogger publicLogger) {
        this("", "", 0, 0, publicLogger);
    }

    public static C0240f6 b(String str, String str2) {
        C0240f6 c0240f6 = new C0240f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0240f6.d = 5376;
        c0240f6.a(str, str2);
        return c0240f6;
    }

    public static C0240f6 n() {
        C0240f6 c0240f6 = new C0240f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0240f6.d = 5632;
        return c0240f6;
    }

    public static C0240f6 o() {
        C0240f6 c0240f6 = new C0240f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0240f6.d = 40961;
        return c0240f6;
    }

    public final void a(String str, String str2, EnumC0161c4 enumC0161c4) {
        boolean equalsNullSafety = StringUtils.equalsNullSafety(str, str2);
        HashMap hashMap = this.q;
        if (!equalsNullSafety) {
            hashMap.put(enumC0161c4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            hashMap.remove(enumC0161c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0240f6
    public final void c(String str) {
        C0775zn c0775zn = this.v;
        c0775zn.getClass();
        this.h = c0775zn.a(str);
    }

    public final String d(String str) {
        C0775zn c0775zn = this.r;
        c0775zn.getClass();
        String a2 = c0775zn.a(str);
        a(str, a2, EnumC0161c4.NAME);
        return a2;
    }

    public final String e(String str) {
        C0697wn c0697wn = this.s;
        c0697wn.getClass();
        String a2 = c0697wn.a(str);
        a(str, a2, EnumC0161c4.VALUE);
        return a2;
    }

    public final C0187d4 f(String str) {
        C0697wn c0697wn = this.t;
        c0697wn.getClass();
        String a2 = c0697wn.a(str);
        a(str, a2, EnumC0161c4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0161c4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0240f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f977a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0240f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0240f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0187d4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0187d4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public C0187d4(int i, PublicLogger publicLogger, long j) {
        this("", "", i, publicLogger);
        b(j);
    }

    public C0187d4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f977a = d(str);
        setType(i);
    }

    public final C0187d4 a(HashMap<EnumC0161c4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0775zn(1000, "event name", publicLogger);
        this.s = new C0697wn(245760, "event value", publicLogger);
        this.t = new C0697wn(1024000, "event extended value", publicLogger);
        this.u = new C0496p3(245760, "event value bytes", publicLogger);
        this.v = new C0775zn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0496p3 c0496p3 = this.u;
        c0496p3.getClass();
        byte[] a2 = c0496p3.a(bArr);
        EnumC0161c4 enumC0161c4 = EnumC0161c4.VALUE;
        int length = bArr.length;
        int length2 = a2.length;
        HashMap hashMap = this.q;
        if (length != length2) {
            hashMap.put(enumC0161c4, Integer.valueOf(bArr.length - a2.length));
        } else {
            hashMap.remove(enumC0161c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0240f6 a(Lo lo) {
        C0240f6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(lo), 0)));
        return o;
    }

    public static C0187d4 a(PublicLogger publicLogger, C0356jj c0356jj) {
        int i;
        C0187d4 c0187d4 = new C0187d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0187d4.d = 40976;
        C0305hj c0305hj = new C0305hj();
        c0305hj.b = c0356jj.f1054a.currency.getCurrencyCode().getBytes();
        c0305hj.f = c0356jj.f1054a.priceMicros;
        c0305hj.c = StringUtils.stringToBytesForProtobuf(new C0775zn(200, "revenue productID", c0356jj.e).a(c0356jj.f1054a.productID));
        c0305hj.f1021a = ((Integer) WrapUtils.getOrDefault(c0356jj.f1054a.quantity, 1)).intValue();
        C0697wn c0697wn = c0356jj.b;
        String str = c0356jj.f1054a.payload;
        c0697wn.getClass();
        c0305hj.d = StringUtils.stringToBytesForProtobuf(c0697wn.a(str));
        if (Oo.a(c0356jj.f1054a.receipt)) {
            C0176cj c0176cj = new C0176cj();
            String str2 = (String) c0356jj.c.a(c0356jj.f1054a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0356jj.f1054a.receipt.data, str2) ? c0356jj.f1054a.receipt.data.length() : 0;
            c0176cj.f932a = StringUtils.stringToBytesForProtobuf(str2);
            c0176cj.b = StringUtils.stringToBytesForProtobuf((String) c0356jj.d.a(c0356jj.f1054a.receipt.signature));
            c0305hj.e = c0176cj;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0305hj), Integer.valueOf(i));
        c0187d4.b = c0187d4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0187d4.g = ((Integer) pair.second).intValue();
        return c0187d4;
    }

    public C0187d4(byte[] bArr, String str, int i, PublicLogger publicLogger, long j) {
        this(bArr, str, i, publicLogger);
        b(j);
    }

    public C0187d4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f977a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public static C0187d4 a(PublicLogger publicLogger, F f) {
        C0187d4 c0187d4 = new C0187d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0187d4.d = 40977;
        kotlin.Pair a2 = f.a();
        c0187d4.b = c0187d4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0187d4.g = ((Integer) a2.getSecond()).intValue();
        return c0187d4;
    }
}

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
public final class C0189d4 extends C0242f6 {
    public HashMap q;
    public C0777zn r;
    public C0699wn s;
    public C0699wn t;
    public C0498p3 u;
    public C0777zn v;

    public C0189d4(PublicLogger publicLogger) {
        this("", "", 0, 0, publicLogger);
    }

    public static C0242f6 b(String str, String str2) {
        C0242f6 c0242f6 = new C0242f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0242f6.d = 5376;
        c0242f6.a(str, str2);
        return c0242f6;
    }

    public static C0242f6 n() {
        C0242f6 c0242f6 = new C0242f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0242f6.d = 5632;
        return c0242f6;
    }

    public static C0242f6 o() {
        C0242f6 c0242f6 = new C0242f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0242f6.d = 40961;
        return c0242f6;
    }

    public final void a(String str, String str2, EnumC0163c4 enumC0163c4) {
        boolean equalsNullSafety = StringUtils.equalsNullSafety(str, str2);
        HashMap hashMap = this.q;
        if (!equalsNullSafety) {
            hashMap.put(enumC0163c4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            hashMap.remove(enumC0163c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0242f6
    public final void c(String str) {
        C0777zn c0777zn = this.v;
        c0777zn.getClass();
        this.h = c0777zn.a(str);
    }

    public final String d(String str) {
        C0777zn c0777zn = this.r;
        c0777zn.getClass();
        String a2 = c0777zn.a(str);
        a(str, a2, EnumC0163c4.NAME);
        return a2;
    }

    public final String e(String str) {
        C0699wn c0699wn = this.s;
        c0699wn.getClass();
        String a2 = c0699wn.a(str);
        a(str, a2, EnumC0163c4.VALUE);
        return a2;
    }

    public final C0189d4 f(String str) {
        C0699wn c0699wn = this.t;
        c0699wn.getClass();
        String a2 = c0699wn.a(str);
        a(str, a2, EnumC0163c4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0163c4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0242f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f974a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0242f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0242f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0189d4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0189d4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public C0189d4(int i, PublicLogger publicLogger, long j) {
        this("", "", i, publicLogger);
        b(j);
    }

    public C0189d4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f974a = d(str);
        setType(i);
    }

    public final C0189d4 a(HashMap<EnumC0163c4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0777zn(1000, "event name", publicLogger);
        this.s = new C0699wn(245760, "event value", publicLogger);
        this.t = new C0699wn(1024000, "event extended value", publicLogger);
        this.u = new C0498p3(245760, "event value bytes", publicLogger);
        this.v = new C0777zn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0498p3 c0498p3 = this.u;
        c0498p3.getClass();
        byte[] a2 = c0498p3.a(bArr);
        EnumC0163c4 enumC0163c4 = EnumC0163c4.VALUE;
        int length = bArr.length;
        int length2 = a2.length;
        HashMap hashMap = this.q;
        if (length != length2) {
            hashMap.put(enumC0163c4, Integer.valueOf(bArr.length - a2.length));
        } else {
            hashMap.remove(enumC0163c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0242f6 a(Lo lo) {
        C0242f6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(lo), 0)));
        return o;
    }

    public static C0189d4 a(PublicLogger publicLogger, C0358jj c0358jj) {
        int i;
        C0189d4 c0189d4 = new C0189d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0189d4.d = 40976;
        C0307hj c0307hj = new C0307hj();
        c0307hj.b = c0358jj.f1051a.currency.getCurrencyCode().getBytes();
        c0307hj.f = c0358jj.f1051a.priceMicros;
        c0307hj.c = StringUtils.stringToBytesForProtobuf(new C0777zn(200, "revenue productID", c0358jj.e).a(c0358jj.f1051a.productID));
        c0307hj.f1018a = ((Integer) WrapUtils.getOrDefault(c0358jj.f1051a.quantity, 1)).intValue();
        C0699wn c0699wn = c0358jj.b;
        String str = c0358jj.f1051a.payload;
        c0699wn.getClass();
        c0307hj.d = StringUtils.stringToBytesForProtobuf(c0699wn.a(str));
        if (Oo.a(c0358jj.f1051a.receipt)) {
            C0178cj c0178cj = new C0178cj();
            String str2 = (String) c0358jj.c.a(c0358jj.f1051a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0358jj.f1051a.receipt.data, str2) ? c0358jj.f1051a.receipt.data.length() : 0;
            c0178cj.f929a = StringUtils.stringToBytesForProtobuf(str2);
            c0178cj.b = StringUtils.stringToBytesForProtobuf((String) c0358jj.d.a(c0358jj.f1051a.receipt.signature));
            c0307hj.e = c0178cj;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0307hj), Integer.valueOf(i));
        c0189d4.b = c0189d4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0189d4.g = ((Integer) pair.second).intValue();
        return c0189d4;
    }

    public C0189d4(byte[] bArr, String str, int i, PublicLogger publicLogger, long j) {
        this(bArr, str, i, publicLogger);
        b(j);
    }

    public C0189d4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f974a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public static C0189d4 a(PublicLogger publicLogger, F f) {
        C0189d4 c0189d4 = new C0189d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0189d4.d = 40977;
        kotlin.Pair a2 = f.a();
        c0189d4.b = c0189d4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0189d4.g = ((Integer) a2.getSecond()).intValue();
        return c0189d4;
    }
}

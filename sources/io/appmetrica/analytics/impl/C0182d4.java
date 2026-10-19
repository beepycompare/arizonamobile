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
public final class C0182d4 extends C0235f6 {
    public HashMap q;
    public C0770zn r;
    public C0692wn s;
    public C0692wn t;
    public C0491p3 u;
    public C0770zn v;

    public C0182d4(PublicLogger publicLogger) {
        this("", "", 0, 0, publicLogger);
    }

    public static C0235f6 b(String str, String str2) {
        C0235f6 c0235f6 = new C0235f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0235f6.d = 5376;
        c0235f6.a(str, str2);
        return c0235f6;
    }

    public static C0235f6 n() {
        C0235f6 c0235f6 = new C0235f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0235f6.d = 5632;
        return c0235f6;
    }

    public static C0235f6 o() {
        C0235f6 c0235f6 = new C0235f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0235f6.d = 40961;
        return c0235f6;
    }

    public final void a(String str, String str2, EnumC0156c4 enumC0156c4) {
        boolean equalsNullSafety = StringUtils.equalsNullSafety(str, str2);
        HashMap hashMap = this.q;
        if (!equalsNullSafety) {
            hashMap.put(enumC0156c4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            hashMap.remove(enumC0156c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0235f6
    public final void c(String str) {
        C0770zn c0770zn = this.v;
        c0770zn.getClass();
        this.h = c0770zn.a(str);
    }

    public final String d(String str) {
        C0770zn c0770zn = this.r;
        c0770zn.getClass();
        String a2 = c0770zn.a(str);
        a(str, a2, EnumC0156c4.NAME);
        return a2;
    }

    public final String e(String str) {
        C0692wn c0692wn = this.s;
        c0692wn.getClass();
        String a2 = c0692wn.a(str);
        a(str, a2, EnumC0156c4.VALUE);
        return a2;
    }

    public final C0182d4 f(String str) {
        C0692wn c0692wn = this.t;
        c0692wn.getClass();
        String a2 = c0692wn.a(str);
        a(str, a2, EnumC0156c4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0156c4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0235f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f980a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0235f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0235f6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0182d4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0182d4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public C0182d4(int i, PublicLogger publicLogger, long j) {
        this("", "", i, publicLogger);
        b(j);
    }

    public C0182d4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f980a = d(str);
        setType(i);
    }

    public final C0182d4 a(HashMap<EnumC0156c4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0770zn(1000, "event name", publicLogger);
        this.s = new C0692wn(245760, "event value", publicLogger);
        this.t = new C0692wn(1024000, "event extended value", publicLogger);
        this.u = new C0491p3(245760, "event value bytes", publicLogger);
        this.v = new C0770zn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0491p3 c0491p3 = this.u;
        c0491p3.getClass();
        byte[] a2 = c0491p3.a(bArr);
        EnumC0156c4 enumC0156c4 = EnumC0156c4.VALUE;
        int length = bArr.length;
        int length2 = a2.length;
        HashMap hashMap = this.q;
        if (length != length2) {
            hashMap.put(enumC0156c4, Integer.valueOf(bArr.length - a2.length));
        } else {
            hashMap.remove(enumC0156c4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0235f6 a(Lo lo) {
        C0235f6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(lo), 0)));
        return o;
    }

    public static C0182d4 a(PublicLogger publicLogger, C0351jj c0351jj) {
        int i;
        C0182d4 c0182d4 = new C0182d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0182d4.d = 40976;
        C0300hj c0300hj = new C0300hj();
        c0300hj.b = c0351jj.f1057a.currency.getCurrencyCode().getBytes();
        c0300hj.f = c0351jj.f1057a.priceMicros;
        c0300hj.c = StringUtils.stringToBytesForProtobuf(new C0770zn(200, "revenue productID", c0351jj.e).a(c0351jj.f1057a.productID));
        c0300hj.f1024a = ((Integer) WrapUtils.getOrDefault(c0351jj.f1057a.quantity, 1)).intValue();
        C0692wn c0692wn = c0351jj.b;
        String str = c0351jj.f1057a.payload;
        c0692wn.getClass();
        c0300hj.d = StringUtils.stringToBytesForProtobuf(c0692wn.a(str));
        if (Oo.a(c0351jj.f1057a.receipt)) {
            C0171cj c0171cj = new C0171cj();
            String str2 = (String) c0351jj.c.a(c0351jj.f1057a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0351jj.f1057a.receipt.data, str2) ? c0351jj.f1057a.receipt.data.length() : 0;
            c0171cj.f935a = StringUtils.stringToBytesForProtobuf(str2);
            c0171cj.b = StringUtils.stringToBytesForProtobuf((String) c0351jj.d.a(c0351jj.f1057a.receipt.signature));
            c0300hj.e = c0171cj;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0300hj), Integer.valueOf(i));
        c0182d4.b = c0182d4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0182d4.g = ((Integer) pair.second).intValue();
        return c0182d4;
    }

    public C0182d4(byte[] bArr, String str, int i, PublicLogger publicLogger, long j) {
        this(bArr, str, i, publicLogger);
        b(j);
    }

    public C0182d4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f980a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public static C0182d4 a(PublicLogger publicLogger, F f) {
        C0182d4 c0182d4 = new C0182d4(publicLogger);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0182d4.d = 40977;
        kotlin.Pair a2 = f.a();
        c0182d4.b = c0182d4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0182d4.g = ((Integer) a2.getSecond()).intValue();
        return c0182d4;
    }
}

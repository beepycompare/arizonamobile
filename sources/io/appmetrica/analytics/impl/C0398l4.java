package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0398l4 extends C0478o6 {
    public HashMap q;
    public C0262fn r;
    public C0211dn s;
    public C0211dn t;
    public C0725y3 u;
    public C0262fn v;

    public C0398l4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C0478o6 b(String str, String str2) {
        C0478o6 c0478o6 = new C0478o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 5376;
        c0478o6.a(str, str2);
        return c0478o6;
    }

    public static C0478o6 n() {
        C0478o6 c0478o6 = new C0478o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 5632;
        return c0478o6;
    }

    public static C0478o6 o() {
        C0478o6 c0478o6 = new C0478o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 40961;
        return c0478o6;
    }

    public final void a(String str, String str2, EnumC0372k4 enumC0372k4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC0372k4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC0372k4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0478o6
    public final void c(String str) {
        C0262fn c0262fn = this.v;
        c0262fn.getClass();
        this.h = c0262fn.a(str);
    }

    public final String d(String str) {
        C0262fn c0262fn = this.r;
        c0262fn.getClass();
        String a2 = c0262fn.a(str);
        a(str, a2, EnumC0372k4.NAME);
        return a2;
    }

    public final String e(String str) {
        C0211dn c0211dn = this.s;
        c0211dn.getClass();
        String a2 = c0211dn.a(str);
        a(str, a2, EnumC0372k4.VALUE);
        return a2;
    }

    public final C0398l4 f(String str) {
        C0211dn c0211dn = this.t;
        c0211dn.getClass();
        String a2 = c0211dn.a(str);
        a(str, a2, EnumC0372k4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0372k4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0478o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f1018a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0478o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0478o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0398l4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0398l4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C0398l4 a(HashMap<EnumC0372k4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public C0398l4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f1018a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0262fn(1000, "event name", publicLogger);
        this.s = new C0211dn(245760, "event value", publicLogger);
        this.t = new C0211dn(1024000, "event extended value", publicLogger);
        this.u = new C0725y3(245760, "event value bytes", publicLogger);
        this.v = new C0262fn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0725y3 c0725y3 = this.u;
        c0725y3.getClass();
        byte[] a2 = c0725y3.a(bArr);
        EnumC0372k4 enumC0372k4 = EnumC0372k4.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(enumC0372k4, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(enumC0372k4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0478o6 a(C0496oo c0496oo) {
        C0478o6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0496oo), 0)));
        return o;
    }

    public static C0398l4 a(PublicLogger publicLogger, C0387kj c0387kj) {
        int i;
        C0398l4 c0398l4 = new C0398l4(publicLogger);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0398l4.d = 40976;
        C0335ij c0335ij = new C0335ij();
        c0335ij.b = c0387kj.f957a.currency.getCurrencyCode().getBytes();
        c0335ij.f = c0387kj.f957a.priceMicros;
        c0335ij.c = StringUtils.stringToBytesForProtobuf(new C0262fn(200, "revenue productID", c0387kj.e).a(c0387kj.f957a.productID));
        c0335ij.f926a = ((Integer) WrapUtils.getOrDefault(c0387kj.f957a.quantity, 1)).intValue();
        C0211dn c0211dn = c0387kj.b;
        String str = c0387kj.f957a.payload;
        c0211dn.getClass();
        c0335ij.d = StringUtils.stringToBytesForProtobuf(c0211dn.a(str));
        if (ro.a(c0387kj.f957a.receipt)) {
            C0207dj c0207dj = new C0207dj();
            String str2 = (String) c0387kj.c.a(c0387kj.f957a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0387kj.f957a.receipt.data, str2) ? c0387kj.f957a.receipt.data.length() : 0;
            c0207dj.f848a = StringUtils.stringToBytesForProtobuf(str2);
            c0207dj.b = StringUtils.stringToBytesForProtobuf((String) c0387kj.d.a(c0387kj.f957a.receipt.signature));
            c0335ij.e = c0207dj;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0335ij), Integer.valueOf(i));
        c0398l4.b = c0398l4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0398l4.g = ((Integer) pair.second).intValue();
        return c0398l4;
    }

    public C0398l4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f1018a = d(str);
        setType(i);
    }

    public static C0398l4 a(PublicLogger publicLogger, D d) {
        C0398l4 c0398l4 = new C0398l4(publicLogger);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0398l4.d = 40977;
        kotlin.Pair a2 = d.a();
        c0398l4.b = c0398l4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0398l4.g = ((Integer) a2.getSecond()).intValue();
        return c0398l4;
    }
}

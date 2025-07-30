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
public final class C0325i4 extends C0401l6 {
    public HashMap q;
    public Wm r;
    public Um s;
    public Um t;
    public C0647v3 u;
    public Wm v;

    public C0325i4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C0401l6 b(String str, String str2) {
        C0401l6 c0401l6 = new C0401l6("", 0);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0401l6.d = 5376;
        c0401l6.a(str, str2);
        return c0401l6;
    }

    public static C0401l6 n() {
        C0401l6 c0401l6 = new C0401l6("", 0);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0401l6.d = 5632;
        return c0401l6;
    }

    public static C0401l6 o() {
        C0401l6 c0401l6 = new C0401l6("", 0);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0401l6.d = 40961;
        return c0401l6;
    }

    public final void a(String str, String str2, EnumC0300h4 enumC0300h4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC0300h4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC0300h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0401l6
    public final void c(String str) {
        Wm wm = this.v;
        wm.getClass();
        this.h = wm.a(str);
    }

    public final String d(String str) {
        Wm wm = this.r;
        wm.getClass();
        String a2 = wm.a(str);
        a(str, a2, EnumC0300h4.NAME);
        return a2;
    }

    public final String e(String str) {
        Um um = this.s;
        um.getClass();
        String a2 = um.a(str);
        a(str, a2, EnumC0300h4.VALUE);
        return a2;
    }

    public final C0325i4 f(String str) {
        Um um = this.t;
        um.getClass();
        String a2 = um.a(str);
        a(str, a2, EnumC0300h4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0300h4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0401l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f936a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0401l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0401l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0325i4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0325i4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C0325i4 a(HashMap<EnumC0300h4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public C0325i4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f936a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new Wm(1000, "event name", publicLogger);
        this.s = new Um(245760, "event value", publicLogger);
        this.t = new Um(1024000, "event extended value", publicLogger);
        this.u = new C0647v3(245760, "event value bytes", publicLogger);
        this.v = new Wm(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0647v3 c0647v3 = this.u;
        c0647v3.getClass();
        byte[] a2 = c0647v3.a(bArr);
        EnumC0300h4 enumC0300h4 = EnumC0300h4.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(enumC0300h4, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(enumC0300h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0401l6 a(C0269fo c0269fo) {
        C0401l6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0269fo), 0)));
        return o;
    }

    public static C0325i4 a(PublicLogger publicLogger, C0161bj c0161bj) {
        int i;
        C0325i4 c0325i4 = new C0325i4(publicLogger);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0325i4.d = 40976;
        Zi zi = new Zi();
        zi.b = c0161bj.f787a.currency.getCurrencyCode().getBytes();
        zi.f = c0161bj.f787a.priceMicros;
        zi.c = StringUtils.stringToBytesForProtobuf(new Wm(200, "revenue productID", c0161bj.e).a(c0161bj.f787a.productID));
        zi.f753a = ((Integer) WrapUtils.getOrDefault(c0161bj.f787a.quantity, 1)).intValue();
        Um um = c0161bj.b;
        String str = c0161bj.f787a.payload;
        um.getClass();
        zi.d = StringUtils.stringToBytesForProtobuf(um.a(str));
        if (io.a(c0161bj.f787a.receipt)) {
            Ui ui = new Ui();
            String str2 = (String) c0161bj.c.a(c0161bj.f787a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0161bj.f787a.receipt.data, str2) ? c0161bj.f787a.receipt.data.length() : 0;
            ui.f674a = StringUtils.stringToBytesForProtobuf(str2);
            ui.b = StringUtils.stringToBytesForProtobuf((String) c0161bj.d.a(c0161bj.f787a.receipt.signature));
            zi.e = ui;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(zi), Integer.valueOf(i));
        c0325i4.b = c0325i4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0325i4.g = ((Integer) pair.second).intValue();
        return c0325i4;
    }

    public C0325i4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f936a = d(str);
        setType(i);
    }

    public static C0325i4 a(PublicLogger publicLogger, D d) {
        C0325i4 c0325i4 = new C0325i4(publicLogger);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        c0325i4.d = 40977;
        kotlin.Pair a2 = d.a();
        c0325i4.b = c0325i4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0325i4.g = ((Integer) a2.getSecond()).intValue();
        return c0325i4;
    }
}

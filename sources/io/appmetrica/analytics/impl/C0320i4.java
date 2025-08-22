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
public final class C0320i4 extends C0399l6 {
    public HashMap q;
    public C0158bn r;
    public Zm s;
    public Zm t;
    public C0645v3 u;
    public C0158bn v;

    public C0320i4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C0399l6 b(String str, String str2) {
        C0399l6 c0399l6 = new C0399l6("", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 5376;
        c0399l6.a(str, str2);
        return c0399l6;
    }

    public static C0399l6 n() {
        C0399l6 c0399l6 = new C0399l6("", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 5632;
        return c0399l6;
    }

    public static C0399l6 o() {
        C0399l6 c0399l6 = new C0399l6("", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 40961;
        return c0399l6;
    }

    public final void a(String str, String str2, EnumC0294h4 enumC0294h4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC0294h4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC0294h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0399l6
    public final void c(String str) {
        C0158bn c0158bn = this.v;
        c0158bn.getClass();
        this.h = c0158bn.a(str);
    }

    public final String d(String str) {
        C0158bn c0158bn = this.r;
        c0158bn.getClass();
        String a2 = c0158bn.a(str);
        a(str, a2, EnumC0294h4.NAME);
        return a2;
    }

    public final String e(String str) {
        Zm zm = this.s;
        zm.getClass();
        String a2 = zm.a(str);
        a(str, a2, EnumC0294h4.VALUE);
        return a2;
    }

    public final C0320i4 f(String str) {
        Zm zm = this.t;
        zm.getClass();
        String a2 = zm.a(str);
        a(str, a2, EnumC0294h4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0294h4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0399l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f950a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0399l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0399l6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0320i4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0320i4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C0320i4 a(HashMap<EnumC0294h4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public C0320i4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f950a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0158bn(1000, "event name", publicLogger);
        this.s = new Zm(245760, "event value", publicLogger);
        this.t = new Zm(1024000, "event extended value", publicLogger);
        this.u = new C0645v3(245760, "event value bytes", publicLogger);
        this.v = new C0158bn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0645v3 c0645v3 = this.u;
        c0645v3.getClass();
        byte[] a2 = c0645v3.a(bArr);
        EnumC0294h4 enumC0294h4 = EnumC0294h4.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(enumC0294h4, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(enumC0294h4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0399l6 a(C0391ko c0391ko) {
        C0399l6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0391ko), 0)));
        return o;
    }

    public static C0320i4 a(PublicLogger publicLogger, C0283gj c0283gj) {
        int i;
        C0320i4 c0320i4 = new C0320i4(publicLogger);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0320i4.d = 40976;
        C0231ej c0231ej = new C0231ej();
        c0231ej.b = c0283gj.f874a.currency.getCurrencyCode().getBytes();
        c0231ej.f = c0283gj.f874a.priceMicros;
        c0231ej.c = StringUtils.stringToBytesForProtobuf(new C0158bn(200, "revenue productID", c0283gj.e).a(c0283gj.f874a.productID));
        c0231ej.f844a = ((Integer) WrapUtils.getOrDefault(c0283gj.f874a.quantity, 1)).intValue();
        Zm zm = c0283gj.b;
        String str = c0283gj.f874a.payload;
        zm.getClass();
        c0231ej.d = StringUtils.stringToBytesForProtobuf(zm.a(str));
        if (no.a(c0283gj.f874a.receipt)) {
            Zi zi = new Zi();
            String str2 = (String) c0283gj.c.a(c0283gj.f874a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0283gj.f874a.receipt.data, str2) ? c0283gj.f874a.receipt.data.length() : 0;
            zi.f761a = StringUtils.stringToBytesForProtobuf(str2);
            zi.b = StringUtils.stringToBytesForProtobuf((String) c0283gj.d.a(c0283gj.f874a.receipt.signature));
            c0231ej.e = zi;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0231ej), Integer.valueOf(i));
        c0320i4.b = c0320i4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0320i4.g = ((Integer) pair.second).intValue();
        return c0320i4;
    }

    public C0320i4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f950a = d(str);
        setType(i);
    }

    public static C0320i4 a(PublicLogger publicLogger, D d) {
        C0320i4 c0320i4 = new C0320i4(publicLogger);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0320i4.d = 40977;
        kotlin.Pair a2 = d.a();
        c0320i4.b = c0320i4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0320i4.g = ((Integer) a2.getSecond()).intValue();
        return c0320i4;
    }
}

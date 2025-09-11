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
public final class C0397l4 extends C0477o6 {
    public HashMap q;
    public C0261fn r;
    public C0210dn s;
    public C0210dn t;
    public C0724y3 u;
    public C0261fn v;

    public C0397l4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C0477o6 b(String str, String str2) {
        C0477o6 c0477o6 = new C0477o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0477o6.d = 5376;
        c0477o6.a(str, str2);
        return c0477o6;
    }

    public static C0477o6 n() {
        C0477o6 c0477o6 = new C0477o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0477o6.d = 5632;
        return c0477o6;
    }

    public static C0477o6 o() {
        C0477o6 c0477o6 = new C0477o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0477o6.d = 40961;
        return c0477o6;
    }

    public final void a(String str, String str2, EnumC0371k4 enumC0371k4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC0371k4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC0371k4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.C0477o6
    public final void c(String str) {
        C0261fn c0261fn = this.v;
        c0261fn.getClass();
        this.h = c0261fn.a(str);
    }

    public final String d(String str) {
        C0261fn c0261fn = this.r;
        c0261fn.getClass();
        String a2 = c0261fn.a(str);
        a(str, a2, EnumC0371k4.NAME);
        return a2;
    }

    public final String e(String str) {
        C0210dn c0210dn = this.s;
        c0210dn.getClass();
        String a2 = c0210dn.a(str);
        a(str, a2, EnumC0371k4.VALUE);
        return a2;
    }

    public final C0397l4 f(String str) {
        C0210dn c0210dn = this.t;
        c0210dn.getClass();
        String a2 = c0210dn.a(str);
        a(str, a2, EnumC0371k4.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<EnumC0371k4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C0477o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f1017a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C0477o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C0477o6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C0397l4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C0397l4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C0397l4 a(HashMap<EnumC0371k4, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public C0397l4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f1017a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C0261fn(1000, "event name", publicLogger);
        this.s = new C0210dn(245760, "event value", publicLogger);
        this.t = new C0210dn(1024000, "event extended value", publicLogger);
        this.u = new C0724y3(245760, "event value bytes", publicLogger);
        this.v = new C0261fn(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0724y3 c0724y3 = this.u;
        c0724y3.getClass();
        byte[] a2 = c0724y3.a(bArr);
        EnumC0371k4 enumC0371k4 = EnumC0371k4.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(enumC0371k4, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(enumC0371k4);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static C0477o6 a(C0495oo c0495oo) {
        C0477o6 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0495oo), 0)));
        return o;
    }

    public static C0397l4 a(PublicLogger publicLogger, C0386kj c0386kj) {
        int i;
        C0397l4 c0397l4 = new C0397l4(publicLogger);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0397l4.d = 40976;
        C0334ij c0334ij = new C0334ij();
        c0334ij.b = c0386kj.f956a.currency.getCurrencyCode().getBytes();
        c0334ij.f = c0386kj.f956a.priceMicros;
        c0334ij.c = StringUtils.stringToBytesForProtobuf(new C0261fn(200, "revenue productID", c0386kj.e).a(c0386kj.f956a.productID));
        c0334ij.f925a = ((Integer) WrapUtils.getOrDefault(c0386kj.f956a.quantity, 1)).intValue();
        C0210dn c0210dn = c0386kj.b;
        String str = c0386kj.f956a.payload;
        c0210dn.getClass();
        c0334ij.d = StringUtils.stringToBytesForProtobuf(c0210dn.a(str));
        if (ro.a(c0386kj.f956a.receipt)) {
            C0206dj c0206dj = new C0206dj();
            String str2 = (String) c0386kj.c.a(c0386kj.f956a.receipt.data);
            i = !StringUtils.equalsNullSafety(c0386kj.f956a.receipt.data, str2) ? c0386kj.f956a.receipt.data.length() : 0;
            c0206dj.f847a = StringUtils.stringToBytesForProtobuf(str2);
            c0206dj.b = StringUtils.stringToBytesForProtobuf((String) c0386kj.d.a(c0386kj.f956a.receipt.signature));
            c0334ij.e = c0206dj;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c0334ij), Integer.valueOf(i));
        c0397l4.b = c0397l4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c0397l4.g = ((Integer) pair.second).intValue();
        return c0397l4;
    }

    public C0397l4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f1017a = d(str);
        setType(i);
    }

    public static C0397l4 a(PublicLogger publicLogger, D d) {
        C0397l4 c0397l4 = new C0397l4(publicLogger);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0397l4.d = 40977;
        kotlin.Pair a2 = d.a();
        c0397l4.b = c0397l4.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        c0397l4.g = ((Integer) a2.getSecond()).intValue();
        return c0397l4;
    }
}

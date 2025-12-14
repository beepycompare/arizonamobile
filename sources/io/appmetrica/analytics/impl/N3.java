package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class N3 extends Q5 {
    public HashMap q;
    public Ym r;
    public Vm s;
    public Vm t;
    public C0104a3 u;
    public Ym v;

    public N3(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static Q5 b(String str, String str2) {
        Q5 q5 = new Q5("", 0);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = 5376;
        q5.a(str, str2);
        return q5;
    }

    public static Q5 n() {
        Q5 q5 = new Q5("", 0);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = 5632;
        return q5;
    }

    public static Q5 o() {
        Q5 q5 = new Q5("", 0);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = 40961;
        return q5;
    }

    public final void a(String str, String str2, M3 m3) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(m3, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(m3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
    }

    @Override // io.appmetrica.analytics.impl.Q5
    public final void c(String str) {
        Ym ym = this.v;
        ym.getClass();
        this.h = ym.a(str);
    }

    public final String d(String str) {
        Ym ym = this.r;
        ym.getClass();
        String a2 = ym.a(str);
        a(str, a2, M3.NAME);
        return a2;
    }

    public final String e(String str) {
        Vm vm = this.s;
        vm.getClass();
        String a2 = vm.a(str);
        a(str, a2, M3.VALUE);
        return a2;
    }

    public final N3 f(String str) {
        Vm vm = this.t;
        vm.getClass();
        String a2 = vm.a(str);
        a(str, a2, M3.VALUE);
        this.b = a2;
        return this;
    }

    public final HashMap<M3, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f745a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public N3(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public N3(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final N3 a(HashMap<M3, Integer> hashMap) {
        this.q = hashMap;
        return this;
    }

    public N3(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f745a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new Ym(1000, "event name", publicLogger);
        this.s = new Vm(245760, "event value", publicLogger);
        this.t = new Vm(1024000, "event extended value", publicLogger);
        this.u = new C0104a3(245760, "event value bytes", publicLogger);
        this.v = new Ym(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C0104a3 c0104a3 = this.u;
        c0104a3.getClass();
        byte[] a2 = c0104a3.a(bArr);
        M3 m3 = M3.VALUE;
        if (bArr.length != a2.length) {
            this.q.put(m3, Integer.valueOf(bArr.length - a2.length));
        } else {
            this.q.remove(m3);
        }
        int i = 0;
        for (Integer num : this.q.values()) {
            i += num.intValue();
        }
        this.g = i;
        super.setValueBytes(a2);
    }

    public static Q5 a(C0357jo c0357jo) {
        Q5 o = o();
        o.setValue(new String(Base64.encode(MessageNano.toByteArray(c0357jo), 0)));
        return o;
    }

    public static N3 a(PublicLogger publicLogger, Pi pi) {
        int i;
        N3 n3 = new N3(publicLogger);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        n3.d = 40976;
        Ni ni = new Ni();
        ni.b = pi.f734a.currency.getCurrencyCode().getBytes();
        ni.f = pi.f734a.priceMicros;
        ni.c = StringUtils.stringToBytesForProtobuf(new Ym(200, "revenue productID", pi.e).a(pi.f734a.productID));
        ni.f706a = ((Integer) WrapUtils.getOrDefault(pi.f734a.quantity, 1)).intValue();
        Vm vm = pi.b;
        String str = pi.f734a.payload;
        vm.getClass();
        ni.d = StringUtils.stringToBytesForProtobuf(vm.a(str));
        if (mo.a(pi.f734a.receipt)) {
            Ii ii = new Ii();
            String str2 = (String) pi.c.a(pi.f734a.receipt.data);
            i = !StringUtils.equalsNullSafety(pi.f734a.receipt.data, str2) ? pi.f734a.receipt.data.length() : 0;
            ii.f623a = StringUtils.stringToBytesForProtobuf(str2);
            ii.b = StringUtils.stringToBytesForProtobuf((String) pi.d.a(pi.f734a.receipt.signature));
            ni.e = ii;
        } else {
            i = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(ni), Integer.valueOf(i));
        n3.b = n3.e(new String(Base64.encode((byte[]) pair.first, 0)));
        n3.g = ((Integer) pair.second).intValue();
        return n3;
    }

    public N3(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f745a = d(str);
        setType(i);
    }

    public static N3 a(PublicLogger publicLogger, E e) {
        N3 n3 = new N3(publicLogger);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        n3.d = 40977;
        kotlin.Pair a2 = e.a();
        n3.b = n3.e(new String(Base64.encode((byte[]) a2.getFirst(), 0)));
        n3.g = ((Integer) a2.getSecond()).intValue();
        return n3;
    }
}

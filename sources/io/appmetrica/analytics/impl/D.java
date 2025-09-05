package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class D {

    /* renamed from: a  reason: collision with root package name */
    public final AdRevenue f394a;
    public final boolean b;
    public final InterfaceC0570s c;
    public final C0261fn d;
    public final C0210dn e;

    public D(AdRevenue adRevenue, boolean z, C0468nn c0468nn, PublicLogger publicLogger) {
        this.f394a = adRevenue;
        this.b = z;
        this.c = c0468nn;
        this.d = new C0261fn(100, "ad revenue strings", publicLogger);
        this.e = new C0210dn(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f394a.adNetwork, new C0670w(rVar)), TuplesKt.to(this.f394a.adPlacementId, new C0695x(rVar)), TuplesKt.to(this.f394a.adPlacementName, new C0720y(rVar)), TuplesKt.to(this.f394a.adUnitId, new C0745z(rVar)), TuplesKt.to(this.f394a.adUnitName, new A(rVar)), TuplesKt.to(this.f394a.precision, new B(rVar)), TuplesKt.to(this.f394a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            C0261fn c0261fn = this.d;
            c0261fn.getClass();
            String a2 = c0261fn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f414a.get(this.f394a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0521q c0521q = new C0521q();
        BigDecimal bigDecimal = this.f394a.adRevenue;
        BigInteger bigInteger = X7.f733a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(X7.f733a) <= 0 && unscaledValue.compareTo(X7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0521q.f1037a = longValue;
        c0521q.b = intValue;
        rVar.b = c0521q;
        Map<String, String> map = this.f394a.payload;
        InterfaceC0570s interfaceC0570s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Gb.b(interfaceC0570s.a(linkedHashMap));
        C0210dn c0210dn = this.e;
        c0210dn.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c0210dn.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1053a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

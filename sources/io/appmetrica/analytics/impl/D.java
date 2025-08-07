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
    public final AdRevenue f386a;
    public final boolean b;
    public final InterfaceC0569s c;
    public final Wm d;
    public final Um e;

    public D(AdRevenue adRevenue, boolean z, C0243en c0243en, PublicLogger publicLogger) {
        this.f386a = adRevenue;
        this.b = z;
        this.c = c0243en;
        this.d = new Wm(100, "ad revenue strings", publicLogger);
        this.e = new Um(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f386a.adNetwork, new C0669w(rVar)), TuplesKt.to(this.f386a.adPlacementId, new C0694x(rVar)), TuplesKt.to(this.f386a.adPlacementName, new C0719y(rVar)), TuplesKt.to(this.f386a.adUnitId, new C0744z(rVar)), TuplesKt.to(this.f386a.adUnitName, new A(rVar)), TuplesKt.to(this.f386a.precision, new B(rVar)), TuplesKt.to(this.f386a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            Wm wm = this.d;
            wm.getClass();
            String a2 = wm.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f405a.get(this.f386a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0520q c0520q = new C0520q();
        BigDecimal bigDecimal = this.f386a.adRevenue;
        BigInteger bigInteger = T7.f648a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(T7.f648a) <= 0 && unscaledValue.compareTo(T7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0520q.f1009a = longValue;
        c0520q.b = intValue;
        rVar.b = c0520q;
        Map<String, String> map = this.f386a.payload;
        InterfaceC0569s interfaceC0569s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Bb.b(interfaceC0569s.a(linkedHashMap));
        Um um = this.e;
        um.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(um.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1025a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

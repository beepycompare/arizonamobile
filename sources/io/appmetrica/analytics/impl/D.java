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
    public final AdRevenue f387a;
    public final boolean b;
    public final InterfaceC0568s c;
    public final Wm d;
    public final Um e;

    public D(AdRevenue adRevenue, boolean z, C0242en c0242en, PublicLogger publicLogger) {
        this.f387a = adRevenue;
        this.b = z;
        this.c = c0242en;
        this.d = new Wm(100, "ad revenue strings", publicLogger);
        this.e = new Um(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f387a.adNetwork, new C0668w(rVar)), TuplesKt.to(this.f387a.adPlacementId, new C0693x(rVar)), TuplesKt.to(this.f387a.adPlacementName, new C0718y(rVar)), TuplesKt.to(this.f387a.adUnitId, new C0743z(rVar)), TuplesKt.to(this.f387a.adUnitName, new A(rVar)), TuplesKt.to(this.f387a.precision, new B(rVar)), TuplesKt.to(this.f387a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            Wm wm = this.d;
            wm.getClass();
            String a2 = wm.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f406a.get(this.f387a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0519q c0519q = new C0519q();
        BigDecimal bigDecimal = this.f387a.adRevenue;
        BigInteger bigInteger = T7.f649a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(T7.f649a) <= 0 && unscaledValue.compareTo(T7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0519q.f1010a = longValue;
        c0519q.b = intValue;
        rVar.b = c0519q;
        Map<String, String> map = this.f387a.payload;
        InterfaceC0568s interfaceC0568s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Bb.b(interfaceC0568s.a(linkedHashMap));
        Um um = this.e;
        um.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(um.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1026a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

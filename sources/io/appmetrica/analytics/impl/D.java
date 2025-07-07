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
    public final AdRevenue f379a;
    public final boolean b;
    public final InterfaceC0574s c;
    public final Tm d;
    public final Rm e;

    public D(AdRevenue adRevenue, boolean z, C0173bn c0173bn, PublicLogger publicLogger) {
        this.f379a = adRevenue;
        this.b = z;
        this.c = c0173bn;
        this.d = new Tm(100, "ad revenue strings", publicLogger);
        this.e = new Rm(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f379a.adNetwork, new C0674w(rVar)), TuplesKt.to(this.f379a.adPlacementId, new C0699x(rVar)), TuplesKt.to(this.f379a.adPlacementName, new C0724y(rVar)), TuplesKt.to(this.f379a.adUnitId, new C0749z(rVar)), TuplesKt.to(this.f379a.adUnitName, new A(rVar)), TuplesKt.to(this.f379a.precision, new B(rVar)), TuplesKt.to(this.f379a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            Tm tm = this.d;
            tm.getClass();
            String a2 = tm.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f395a.get(this.f379a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0525q c0525q = new C0525q();
        BigDecimal bigDecimal = this.f379a.adRevenue;
        BigInteger bigInteger = Q7.f591a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(Q7.f591a) <= 0 && unscaledValue.compareTo(Q7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0525q.f996a = longValue;
        c0525q.b = intValue;
        rVar.b = c0525q;
        Map<String, String> map = this.f379a.payload;
        InterfaceC0574s interfaceC0574s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = AbstractC0761zb.b(interfaceC0574s.a(linkedHashMap));
        Rm rm = this.e;
        rm.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(rm.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1013a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

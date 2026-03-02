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
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final AdRevenue f558a;
    public final boolean b;
    public final InterfaceC0586t c;
    public final Xm d;
    public final Um e;

    public E(AdRevenue adRevenue, boolean z, C0257fn c0257fn, PublicLogger publicLogger) {
        this.f558a = adRevenue;
        this.b = z;
        this.c = c0257fn;
        this.d = new Xm(100, "ad revenue strings", publicLogger);
        this.e = new Um(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0561s c0561s = new C0561s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f558a.adNetwork, new C0686x(c0561s)), TuplesKt.to(this.f558a.adPlacementId, new C0711y(c0561s)), TuplesKt.to(this.f558a.adPlacementName, new C0736z(c0561s)), TuplesKt.to(this.f558a.adUnitId, new A(c0561s)), TuplesKt.to(this.f558a.adUnitName, new B(c0561s)), TuplesKt.to(this.f558a.precision, new C(c0561s)), TuplesKt.to(this.f558a.currency.getCurrencyCode(), new D(c0561s))})) {
            String str = (String) pair.getFirst();
            Xm xm = this.d;
            xm.getClass();
            String a2 = xm.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) F.f574a.get(this.f558a.adType);
        c0561s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f558a.adRevenue;
        BigInteger bigInteger = AbstractC0694x7.f1301a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0694x7.f1301a) <= 0 && unscaledValue.compareTo(AbstractC0694x7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        rVar.f1195a = longValue;
        rVar.b = intValue;
        c0561s.b = rVar;
        Map<String, String> map = this.f558a.payload;
        InterfaceC0586t interfaceC0586t = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = AbstractC0271gb.b(interfaceC0586t.a(linkedHashMap));
        Um um = this.e;
        um.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(um.a(b));
        c0561s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            c0561s.f1213a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0561s), Integer.valueOf(length));
    }
}

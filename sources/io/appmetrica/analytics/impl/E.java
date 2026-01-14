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
    public final AdRevenue f559a;
    public final boolean b;
    public final InterfaceC0587t c;
    public final Xm d;
    public final Um e;

    public E(AdRevenue adRevenue, boolean z, C0258fn c0258fn, PublicLogger publicLogger) {
        this.f559a = adRevenue;
        this.b = z;
        this.c = c0258fn;
        this.d = new Xm(100, "ad revenue strings", publicLogger);
        this.e = new Um(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0562s c0562s = new C0562s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f559a.adNetwork, new C0687x(c0562s)), TuplesKt.to(this.f559a.adPlacementId, new C0712y(c0562s)), TuplesKt.to(this.f559a.adPlacementName, new C0737z(c0562s)), TuplesKt.to(this.f559a.adUnitId, new A(c0562s)), TuplesKt.to(this.f559a.adUnitName, new B(c0562s)), TuplesKt.to(this.f559a.precision, new C(c0562s)), TuplesKt.to(this.f559a.currency.getCurrencyCode(), new D(c0562s))})) {
            String str = (String) pair.getFirst();
            Xm xm = this.d;
            xm.getClass();
            String a2 = xm.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) F.f575a.get(this.f559a.adType);
        c0562s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f559a.adRevenue;
        BigInteger bigInteger = AbstractC0695x7.f1302a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0695x7.f1302a) <= 0 && unscaledValue.compareTo(AbstractC0695x7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        rVar.f1196a = longValue;
        rVar.b = intValue;
        c0562s.b = rVar;
        Map<String, String> map = this.f559a.payload;
        InterfaceC0587t interfaceC0587t = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = AbstractC0272gb.b(interfaceC0587t.a(linkedHashMap));
        Um um = this.e;
        um.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(um.a(b));
        c0562s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            c0562s.f1214a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0562s), Integer.valueOf(length));
    }
}

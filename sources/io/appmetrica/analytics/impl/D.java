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
    public final AdRevenue f399a;
    public final boolean b;
    public final InterfaceC0571s c;
    public final C0262fn d;
    public final C0211dn e;

    public D(AdRevenue adRevenue, boolean z, C0469nn c0469nn, PublicLogger publicLogger) {
        this.f399a = adRevenue;
        this.b = z;
        this.c = c0469nn;
        this.d = new C0262fn(100, "ad revenue strings", publicLogger);
        this.e = new C0211dn(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f399a.adNetwork, new C0671w(rVar)), TuplesKt.to(this.f399a.adPlacementId, new C0696x(rVar)), TuplesKt.to(this.f399a.adPlacementName, new C0721y(rVar)), TuplesKt.to(this.f399a.adUnitId, new C0746z(rVar)), TuplesKt.to(this.f399a.adUnitName, new A(rVar)), TuplesKt.to(this.f399a.precision, new B(rVar)), TuplesKt.to(this.f399a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            C0262fn c0262fn = this.d;
            c0262fn.getClass();
            String a2 = c0262fn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f419a.get(this.f399a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0522q c0522q = new C0522q();
        BigDecimal bigDecimal = this.f399a.adRevenue;
        BigInteger bigInteger = X7.f738a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(X7.f738a) <= 0 && unscaledValue.compareTo(X7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0522q.f1042a = longValue;
        c0522q.b = intValue;
        rVar.b = c0522q;
        Map<String, String> map = this.f399a.payload;
        InterfaceC0571s interfaceC0571s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Gb.b(interfaceC0571s.a(linkedHashMap));
        C0211dn c0211dn = this.e;
        c0211dn.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c0211dn.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1058a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

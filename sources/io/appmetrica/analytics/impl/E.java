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
    public final AdRevenue f451a;
    public final boolean b;
    public final InterfaceC0584t c;
    public final Ym d;
    public final Vm e;

    public E(AdRevenue adRevenue, boolean z, C0280gn c0280gn, PublicLogger publicLogger) {
        this.f451a = adRevenue;
        this.b = z;
        this.c = c0280gn;
        this.d = new Ym(100, "ad revenue strings", publicLogger);
        this.e = new Vm(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0559s c0559s = new C0559s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f451a.adNetwork, new C0684x(c0559s)), TuplesKt.to(this.f451a.adPlacementId, new C0709y(c0559s)), TuplesKt.to(this.f451a.adPlacementName, new C0734z(c0559s)), TuplesKt.to(this.f451a.adUnitId, new A(c0559s)), TuplesKt.to(this.f451a.adUnitName, new B(c0559s)), TuplesKt.to(this.f451a.precision, new C(c0559s)), TuplesKt.to(this.f451a.currency.getCurrencyCode(), new D(c0559s))})) {
            String str = (String) pair.getFirst();
            Ym ym = this.d;
            ym.getClass();
            String a2 = ym.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) F.f469a.get(this.f451a.adType);
        c0559s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f451a.adRevenue;
        BigInteger bigInteger = AbstractC0717y7.f1214a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0717y7.f1214a) <= 0 && unscaledValue.compareTo(AbstractC0717y7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        rVar.f1094a = longValue;
        rVar.b = intValue;
        c0559s.b = rVar;
        Map<String, String> map = this.f451a.payload;
        InterfaceC0584t interfaceC0584t = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = AbstractC0294hb.b(interfaceC0584t.a(linkedHashMap));
        Vm vm = this.e;
        vm.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(vm.a(b));
        c0559s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            c0559s.f1108a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0559s), Integer.valueOf(length));
    }
}

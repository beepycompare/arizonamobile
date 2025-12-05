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
    public final AdRevenue f534a;
    public final boolean b;
    public final InterfaceC0583t c;
    public final Ym d;
    public final Vm e;

    public E(AdRevenue adRevenue, boolean z, C0279gn c0279gn, PublicLogger publicLogger) {
        this.f534a = adRevenue;
        this.b = z;
        this.c = c0279gn;
        this.d = new Ym(100, "ad revenue strings", publicLogger);
        this.e = new Vm(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0558s c0558s = new C0558s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f534a.adNetwork, new C0683x(c0558s)), TuplesKt.to(this.f534a.adPlacementId, new C0708y(c0558s)), TuplesKt.to(this.f534a.adPlacementName, new C0733z(c0558s)), TuplesKt.to(this.f534a.adUnitId, new A(c0558s)), TuplesKt.to(this.f534a.adUnitName, new B(c0558s)), TuplesKt.to(this.f534a.precision, new C(c0558s)), TuplesKt.to(this.f534a.currency.getCurrencyCode(), new D(c0558s))})) {
            String str = (String) pair.getFirst();
            Ym ym = this.d;
            ym.getClass();
            String a2 = ym.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) F.f552a.get(this.f534a.adType);
        c0558s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f534a.adRevenue;
        BigInteger bigInteger = AbstractC0716y7.f1297a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0716y7.f1297a) <= 0 && unscaledValue.compareTo(AbstractC0716y7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        rVar.f1177a = longValue;
        rVar.b = intValue;
        c0558s.b = rVar;
        Map<String, String> map = this.f534a.payload;
        InterfaceC0583t interfaceC0583t = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = AbstractC0293hb.b(interfaceC0583t.a(linkedHashMap));
        Vm vm = this.e;
        vm.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(vm.a(b));
        c0558s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            c0558s.f1191a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0558s), Integer.valueOf(length));
    }
}

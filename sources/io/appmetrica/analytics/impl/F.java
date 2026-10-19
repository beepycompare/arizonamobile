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
public final class F {

    /* renamed from: a  reason: collision with root package name */
    public final AdRevenue f540a;
    public final boolean b;
    public final InterfaceC0616u c;
    public final C0770zn d;
    public final C0692wn e;

    public F(AdRevenue adRevenue, boolean z, Gn gn, PublicLogger publicLogger) {
        this.f540a = adRevenue;
        this.b = z;
        this.c = gn;
        this.d = new C0770zn(100, "ad revenue strings", publicLogger);
        this.e = new C0692wn(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0564s c0564s = new C0564s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f540a.adNetwork, new C0720y(c0564s)), TuplesKt.to(this.f540a.adPlacementId, new C0746z(c0564s)), TuplesKt.to(this.f540a.adPlacementName, new A(c0564s)), TuplesKt.to(this.f540a.adUnitId, new B(c0564s)), TuplesKt.to(this.f540a.adUnitName, new C(c0564s)), TuplesKt.to(this.f540a.precision, new D(c0564s)), TuplesKt.to(this.f540a.currency.getCurrencyCode(), new E(c0564s))})) {
            String str = (String) pair.getFirst();
            C0770zn c0770zn = this.d;
            c0770zn.getClass();
            String a2 = c0770zn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) G.f559a.get(this.f540a.adType);
        c0564s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f540a.adRevenue;
        BigInteger bigInteger = P7.f719a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(P7.f719a) <= 0 && unscaledValue.compareTo(P7.b) >= 0) {
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
        c0564s.b = rVar;
        Map<String, String> map = this.f540a.payload;
        InterfaceC0616u interfaceC0616u = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Ib.b(interfaceC0616u.a(linkedHashMap));
        C0692wn c0692wn = this.e;
        c0692wn.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c0692wn.a(b));
        c0564s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            EnumC0590t[] enumC0590tArr = EnumC0590t.f1209a;
            c0564s.f1193a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0564s), Integer.valueOf(length));
    }
}

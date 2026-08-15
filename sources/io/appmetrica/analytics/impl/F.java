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
    public final AdRevenue f537a;
    public final boolean b;
    public final InterfaceC0622u c;
    public final C0776zn d;
    public final C0698wn e;

    public F(AdRevenue adRevenue, boolean z, Gn gn, PublicLogger publicLogger) {
        this.f537a = adRevenue;
        this.b = z;
        this.c = gn;
        this.d = new C0776zn(100, "ad revenue strings", publicLogger);
        this.e = new C0698wn(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0570s c0570s = new C0570s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f537a.adNetwork, new C0726y(c0570s)), TuplesKt.to(this.f537a.adPlacementId, new C0752z(c0570s)), TuplesKt.to(this.f537a.adPlacementName, new A(c0570s)), TuplesKt.to(this.f537a.adUnitId, new B(c0570s)), TuplesKt.to(this.f537a.adUnitName, new C(c0570s)), TuplesKt.to(this.f537a.precision, new D(c0570s)), TuplesKt.to(this.f537a.currency.getCurrencyCode(), new E(c0570s))})) {
            String str = (String) pair.getFirst();
            C0776zn c0776zn = this.d;
            c0776zn.getClass();
            String a2 = c0776zn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) G.f556a.get(this.f537a.adType);
        c0570s.d = num != null ? num.intValue() : 0;
        r rVar = new r();
        BigDecimal bigDecimal = this.f537a.adRevenue;
        BigInteger bigInteger = P7.f716a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(P7.f716a) <= 0 && unscaledValue.compareTo(P7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        rVar.f1174a = longValue;
        rVar.b = intValue;
        c0570s.b = rVar;
        Map<String, String> map = this.f537a.payload;
        InterfaceC0622u interfaceC0622u = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Ib.b(interfaceC0622u.a(linkedHashMap));
        C0698wn c0698wn = this.e;
        c0698wn.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c0698wn.a(b));
        c0570s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            EnumC0596t[] enumC0596tArr = EnumC0596t.f1206a;
            c0570s.f1190a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0570s), Integer.valueOf(length));
    }
}

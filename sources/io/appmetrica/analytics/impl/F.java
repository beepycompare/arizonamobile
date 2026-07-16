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
    public final InterfaceC0623u c;
    public final C0777zn d;
    public final C0699wn e;

    public F(AdRevenue adRevenue, boolean z, Gn gn, PublicLogger publicLogger) {
        this.f537a = adRevenue;
        this.b = z;
        this.c = gn;
        this.d = new C0777zn(100, "ad revenue strings", publicLogger);
        this.e = new C0699wn(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        C0571s c0571s = new C0571s();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f537a.adNetwork, new C0727y(c0571s)), TuplesKt.to(this.f537a.adPlacementId, new C0753z(c0571s)), TuplesKt.to(this.f537a.adPlacementName, new A(c0571s)), TuplesKt.to(this.f537a.adUnitId, new B(c0571s)), TuplesKt.to(this.f537a.adUnitName, new C(c0571s)), TuplesKt.to(this.f537a.precision, new D(c0571s)), TuplesKt.to(this.f537a.currency.getCurrencyCode(), new E(c0571s))})) {
            String str = (String) pair.getFirst();
            C0777zn c0777zn = this.d;
            c0777zn.getClass();
            String a2 = c0777zn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) G.f556a.get(this.f537a.adType);
        c0571s.d = num != null ? num.intValue() : 0;
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
        c0571s.b = rVar;
        Map<String, String> map = this.f537a.payload;
        InterfaceC0623u interfaceC0623u = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Ib.b(interfaceC0623u.a(linkedHashMap));
        C0699wn c0699wn = this.e;
        c0699wn.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c0699wn.a(b));
        c0571s.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            EnumC0597t[] enumC0597tArr = EnumC0597t.f1206a;
            c0571s.f1190a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c0571s), Integer.valueOf(length));
    }
}

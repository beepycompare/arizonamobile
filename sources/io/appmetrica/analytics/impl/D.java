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
    public final AdRevenue f386a;
    public final boolean b;
    public final InterfaceC0566s c;
    public final C0158bn d;
    public final Zm e;

    public D(AdRevenue adRevenue, boolean z, C0364jn c0364jn, PublicLogger publicLogger) {
        this.f386a = adRevenue;
        this.b = z;
        this.c = c0364jn;
        this.d = new C0158bn(100, "ad revenue strings", publicLogger);
        this.e = new Zm(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        Map linkedHashMap;
        r rVar = new r();
        int i = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f386a.adNetwork, new C0666w(rVar)), TuplesKt.to(this.f386a.adPlacementId, new C0691x(rVar)), TuplesKt.to(this.f386a.adPlacementName, new C0716y(rVar)), TuplesKt.to(this.f386a.adUnitId, new C0741z(rVar)), TuplesKt.to(this.f386a.adUnitName, new A(rVar)), TuplesKt.to(this.f386a.precision, new B(rVar)), TuplesKt.to(this.f386a.currency.getCurrencyCode(), new C(rVar))})) {
            String str = (String) pair.getFirst();
            C0158bn c0158bn = this.d;
            c0158bn.getClass();
            String a2 = c0158bn.a(str);
            byte[] stringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] stringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(a2);
            ((Function1) pair.getSecond()).invoke(stringToBytesForProtobuf2);
            i += stringToBytesForProtobuf.length - stringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) E.f402a.get(this.f386a.adType);
        rVar.d = num != null ? num.intValue() : 0;
        C0517q c0517q = new C0517q();
        BigDecimal bigDecimal = this.f386a.adRevenue;
        BigInteger bigInteger = U7.f673a;
        int i2 = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(U7.f673a) <= 0 && unscaledValue.compareTo(U7.b) >= 0) {
                break;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i2++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i2));
        long longValue = ((Number) pair2.getFirst()).longValue();
        int intValue = ((Number) pair2.getSecond()).intValue();
        c0517q.f1017a = longValue;
        c0517q.b = intValue;
        rVar.b = c0517q;
        Map<String, String> map = this.f386a.payload;
        InterfaceC0566s interfaceC0566s = this.c;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        String b = Db.b(interfaceC0566s.a(linkedHashMap));
        Zm zm = this.e;
        zm.getClass();
        byte[] stringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(zm.a(b));
        rVar.k = stringToBytesForProtobuf3;
        int length = (StringUtils.stringToBytesForProtobuf(b).length - stringToBytesForProtobuf3.length) + i;
        if (this.b) {
            rVar.f1033a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(rVar), Integer.valueOf(length));
    }
}

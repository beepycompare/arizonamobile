package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes4.dex */
public final class O7 implements ProtobufConverter {
    public final BigDecimal a(C0708x8 c0708x8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0708x8 c0708x8 = (C0708x8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0708x8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = Q7.f591a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(Q7.f591a) <= 0 && unscaledValue.compareTo(Q7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                P7 p7 = new P7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                C0708x8 c0708x8 = new C0708x8();
                c0708x8.f1120a = p7.f576a;
                c0708x8.b = p7.b;
                return c0708x8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

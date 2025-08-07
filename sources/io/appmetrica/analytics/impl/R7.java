package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes4.dex */
public final class R7 implements ProtobufConverter {
    public final BigDecimal a(A8 a8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        A8 a8 = (A8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = T7.f648a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(T7.f648a) <= 0 && unscaledValue.compareTo(T7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                S7 s7 = new S7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                A8 a8 = new A8();
                a8.f334a = s7.f635a;
                a8.b = s7.b;
                return a8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

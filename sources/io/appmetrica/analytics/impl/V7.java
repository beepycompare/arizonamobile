package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes4.dex */
public final class V7 implements ProtobufConverter {
    public final BigDecimal a(F8 f8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        F8 f8 = (F8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = X7.f737a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(X7.f737a) <= 0 && unscaledValue.compareTo(X7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                W7 w7 = new W7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                F8 f8 = new F8();
                f8.f441a = w7.f724a;
                f8.b = w7.b;
                return f8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

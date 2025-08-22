package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes4.dex */
public final class S7 implements ProtobufConverter {
    public final BigDecimal a(C8 c8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C8 c8 = (C8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = U7.f673a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(U7.f673a) <= 0 && unscaledValue.compareTo(U7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                T7 t7 = new T7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                C8 c8 = new C8();
                c8.f377a = t7.f658a;
                c8.b = t7.b;
                return c8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* renamed from: io.appmetrica.analytics.impl.w7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0667w7 implements ProtobufConverter {
    public final BigDecimal a(C0291h8 c0291h8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0291h8 c0291h8 = (C0291h8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0291h8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = AbstractC0717y7.f1214a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0717y7.f1214a) <= 0 && unscaledValue.compareTo(AbstractC0717y7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                C0692x7 c0692x7 = new C0692x7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0291h8 c0291h8 = new C0291h8();
                c0291h8.f920a = c0692x7.f1196a;
                c0291h8.b = c0692x7.b;
                return c0291h8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

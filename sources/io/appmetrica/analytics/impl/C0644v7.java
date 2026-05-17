package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* renamed from: io.appmetrica.analytics.impl.v7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0644v7 implements ProtobufConverter {
    public final BigDecimal a(C0268g8 c0268g8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0268g8 c0268g8 = (C0268g8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0268g8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = AbstractC0694x7.f1306a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0694x7.f1306a) <= 0 && unscaledValue.compareTo(AbstractC0694x7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                C0669w7 c0669w7 = new C0669w7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0268g8 c0268g8 = new C0268g8();
                c0268g8.f1014a = c0669w7.f1288a;
                c0268g8.b = c0669w7.b;
                return c0268g8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

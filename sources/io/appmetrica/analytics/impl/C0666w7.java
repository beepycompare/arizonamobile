package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* renamed from: io.appmetrica.analytics.impl.w7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0666w7 implements ProtobufConverter {
    public final BigDecimal a(C0290h8 c0290h8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0290h8 c0290h8 = (C0290h8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0290h8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = AbstractC0716y7.f1311a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0716y7.f1311a) <= 0 && unscaledValue.compareTo(AbstractC0716y7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                C0691x7 c0691x7 = new C0691x7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0290h8 c0290h8 = new C0290h8();
                c0290h8.f1017a = c0691x7.f1293a;
                c0290h8.b = c0691x7.b;
                return c0290h8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

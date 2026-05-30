package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes5.dex */
public final class N7 implements ProtobufConverter {
    public final BigDecimal a(C0762z8 c0762z8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0762z8 c0762z8 = (C0762z8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0762z8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = P7.f714a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(P7.f714a) <= 0 && unscaledValue.compareTo(P7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                O7 o7 = new O7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0762z8 c0762z8 = new C0762z8();
                c0762z8.f1310a = o7.f697a;
                c0762z8.b = o7.b;
                return c0762z8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

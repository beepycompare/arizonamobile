package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes5.dex */
public final class N7 implements ProtobufConverter {
    public final BigDecimal a(C0761z8 c0761z8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0761z8 c0761z8 = (C0761z8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0761z8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = P7.f716a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(P7.f716a) <= 0 && unscaledValue.compareTo(P7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                O7 o7 = new O7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0761z8 c0761z8 = new C0761z8();
                c0761z8.f1312a = o7.f699a;
                c0761z8.b = o7.b;
                return c0761z8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

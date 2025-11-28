package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes5.dex */
public final class D7 implements ProtobufConverter {
    public final BigDecimal a(C0419m8 c0419m8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0419m8 c0419m8 = (C0419m8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0419m8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = F7.f472a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(F7.f472a) <= 0 && unscaledValue.compareTo(F7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                E7 e7 = new E7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                C0419m8 c0419m8 = new C0419m8();
                c0419m8.f1005a = e7.f454a;
                c0419m8.b = e7.b;
                return c0419m8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

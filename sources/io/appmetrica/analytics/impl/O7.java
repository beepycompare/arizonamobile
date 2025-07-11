package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* loaded from: classes4.dex */
public final class O7 implements ProtobufConverter {
    public final BigDecimal a(C0700x8 c0700x8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0700x8 c0700x8 = (C0700x8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0700x8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = Q7.f592a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(Q7.f592a) <= 0 && unscaledValue.compareTo(Q7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                P7 p7 = new P7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                C0700x8 c0700x8 = new C0700x8();
                c0700x8.f1121a = p7.f577a;
                c0700x8.b = p7.b;
                return c0700x8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

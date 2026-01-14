package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
/* renamed from: io.appmetrica.analytics.impl.v7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0645v7 implements ProtobufConverter {
    public final BigDecimal a(C0269g8 c0269g8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0269g8 c0269g8 = (C0269g8) obj;
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0269g8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = AbstractC0695x7.f1302a;
        int i = -bigDecimal.scale();
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (unscaledValue.compareTo(AbstractC0695x7.f1302a) <= 0 && unscaledValue.compareTo(AbstractC0695x7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(unscaledValue.longValue()), Integer.valueOf(i));
                C0670w7 c0670w7 = new C0670w7(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).intValue());
                C0269g8 c0269g8 = new C0269g8();
                c0269g8.f1010a = c0670w7.f1284a;
                c0269g8.b = c0670w7.b;
                return c0269g8;
            }
            unscaledValue = unscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}

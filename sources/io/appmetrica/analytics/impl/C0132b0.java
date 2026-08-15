package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0132b0 {

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f898a;
    public final String b;

    public C0132b0(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f898a + ", unit='" + this.b + "'}";
    }

    public C0132b0(BigDecimal bigDecimal, String str) {
        this.f898a = bigDecimal;
        this.b = str;
    }
}

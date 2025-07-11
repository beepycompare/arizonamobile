package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class Y {

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f713a;
    public final String b;

    public Y(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f713a + ", unit='" + this.b + "'}";
    }

    public Y(BigDecimal bigDecimal, String str) {
        this.f713a = bigDecimal;
        this.b = str;
    }
}

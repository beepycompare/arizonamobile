package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class Y {

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f750a;
    public final String b;

    public Y(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f750a + ", unit='" + this.b + "'}";
    }

    public Y(BigDecimal bigDecimal, String str) {
        this.f750a = bigDecimal;
        this.b = str;
    }
}

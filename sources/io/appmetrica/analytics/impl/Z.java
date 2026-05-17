package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public final class Z {

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f879a;
    public final String b;

    public Z(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f879a + ", unit='" + this.b + "'}";
    }

    public Z(BigDecimal bigDecimal, String str) {
        this.f879a = bigDecimal;
        this.b = str;
    }
}

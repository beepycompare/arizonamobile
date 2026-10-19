package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0126b0 {

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f901a;
    public final String b;

    public C0126b0(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f901a + ", unit='" + this.b + "'}";
    }

    public C0126b0(BigDecimal bigDecimal, String str) {
        this.f901a = bigDecimal;
        this.b = str;
    }
}

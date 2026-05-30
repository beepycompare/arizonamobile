package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.Oo;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f387a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(Oo.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f387a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f387a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(Oo.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f387a = bigDecimal;
        this.b = str;
    }
}

package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.lo;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f430a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(lo.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f430a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f430a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(lo.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f430a = bigDecimal;
        this.b = str;
    }
}

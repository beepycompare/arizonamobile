package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.mo;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f333a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(mo.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f333a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f333a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(mo.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f333a = bigDecimal;
        this.b = str;
    }
}

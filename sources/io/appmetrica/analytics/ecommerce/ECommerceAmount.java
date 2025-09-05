package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.ro;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f309a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(ro.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f309a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f309a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(ro.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f309a = bigDecimal;
        this.b = str;
    }
}

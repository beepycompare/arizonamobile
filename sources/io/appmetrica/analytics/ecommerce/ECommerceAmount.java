package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.io;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f301a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(io.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f301a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f301a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(io.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f301a = bigDecimal;
        this.b = str;
    }
}

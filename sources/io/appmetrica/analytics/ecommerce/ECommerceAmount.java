package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.fo;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f299a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(fo.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f299a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f299a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(fo.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f299a = bigDecimal;
        this.b = str;
    }
}

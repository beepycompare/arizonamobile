package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.no;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public class ECommerceAmount {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f308a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(no.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f308a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f308a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(no.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f308a = bigDecimal;
        this.b = str;
    }
}

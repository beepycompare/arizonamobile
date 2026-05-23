package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billing.internal.config.BillingConfig;
/* loaded from: classes5.dex */
public final class A {

    /* renamed from: a  reason: collision with root package name */
    public final int f256a;
    public final int b;

    public A(int i, int i2) {
        this.f256a = i;
        this.b = i2;
    }

    public final String toString() {
        return "ServiceSideBillingConfig(sendFrequencySeconds=" + this.f256a + ", firstCollectingInappMaxAgeSeconds=" + this.b + ')';
    }

    public A(BillingConfig billingConfig) {
        this(billingConfig.getSendFrequencySeconds(), billingConfig.getFirstCollectingInappMaxAgeSeconds());
    }
}

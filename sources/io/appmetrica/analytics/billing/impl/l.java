package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingType;
/* loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f300a;

    static {
        int[] iArr = new int[BillingType.values().length];
        iArr[BillingType.LIBRARY_V6.ordinal()] = 1;
        iArr[BillingType.LIBRARY_V8.ordinal()] = 2;
        f300a = iArr;
    }
}

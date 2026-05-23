package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingType;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class l {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f265a;

    static {
        int[] iArr = new int[BillingType.values().length];
        try {
            iArr[BillingType.LIBRARY_V6.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[BillingType.LIBRARY_V8.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f265a = iArr;
    }
}

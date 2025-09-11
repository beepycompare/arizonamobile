package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingType;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0448n3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1001a;

    static {
        int[] iArr = new int[BillingType.values().length];
        iArr[BillingType.LIBRARY_V6.ordinal()] = 1;
        iArr[BillingType.LIBRARY_V8.ordinal()] = 2;
        f1001a = iArr;
    }
}

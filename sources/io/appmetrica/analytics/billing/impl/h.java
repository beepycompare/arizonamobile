package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* loaded from: classes3.dex */
public abstract /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f214a;

    static {
        int[] iArr = new int[ProductType.values().length];
        iArr[ProductType.INAPP.ordinal()] = 1;
        iArr[ProductType.SUBS.ordinal()] = 2;
        f214a = iArr;
    }
}

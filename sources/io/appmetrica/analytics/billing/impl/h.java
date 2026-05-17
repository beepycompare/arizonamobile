package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f316a;

    static {
        int[] iArr = new int[ProductType.values().length];
        iArr[ProductType.INAPP.ordinal()] = 1;
        iArr[ProductType.SUBS.ordinal()] = 2;
        f316a = iArr;
    }
}

package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* loaded from: classes2.dex */
public abstract /* synthetic */ class n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f216a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ProductType.values().length];
        iArr[ProductType.INAPP.ordinal()] = 1;
        iArr[ProductType.SUBS.ordinal()] = 2;
        f216a = iArr;
        int[] iArr2 = new int[Period.TimeUnit.values().length];
        iArr2[Period.TimeUnit.DAY.ordinal()] = 1;
        iArr2[Period.TimeUnit.WEEK.ordinal()] = 2;
        iArr2[Period.TimeUnit.MONTH.ordinal()] = 3;
        iArr2[Period.TimeUnit.YEAR.ordinal()] = 4;
        b = iArr2;
    }
}

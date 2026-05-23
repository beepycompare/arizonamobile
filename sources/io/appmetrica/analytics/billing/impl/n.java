package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f267a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ProductType.values().length];
        try {
            iArr[ProductType.INAPP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ProductType.SUBS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f267a = iArr;
        int[] iArr2 = new int[Period.TimeUnit.values().length];
        try {
            iArr2[Period.TimeUnit.DAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Period.TimeUnit.WEEK.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Period.TimeUnit.MONTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Period.TimeUnit.YEAR.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        b = iArr2;
    }
}

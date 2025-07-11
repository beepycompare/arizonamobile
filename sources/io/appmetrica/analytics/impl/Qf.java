package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class Qf {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f596a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[Period.TimeUnit.values().length];
        b = iArr;
        try {
            iArr[Period.TimeUnit.DAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[Period.TimeUnit.WEEK.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[Period.TimeUnit.MONTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[Period.TimeUnit.YEAR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[ProductType.values().length];
        f596a = iArr2;
        try {
            iArr2[ProductType.INAPP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f596a[ProductType.SUBS.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

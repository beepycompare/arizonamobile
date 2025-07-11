package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0247f3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f831a;

    static {
        int[] iArr = new int[ProductType.values().length];
        f831a = iArr;
        try {
            iArr[ProductType.INAPP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f831a[ProductType.SUBS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

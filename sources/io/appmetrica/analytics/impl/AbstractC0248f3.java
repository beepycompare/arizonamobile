package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductType;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0248f3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f841a;

    static {
        int[] iArr = new int[ProductType.values().length];
        f841a = iArr;
        try {
            iArr[ProductType.INAPP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f841a[ProductType.SUBS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0688wj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1125a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f1125a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1125a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

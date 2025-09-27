package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class Fj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f450a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f450a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f450a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class Fj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f449a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f449a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f449a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

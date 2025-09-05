package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class Fj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f445a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f445a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f445a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

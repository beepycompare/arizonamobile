package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class Bj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f367a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f367a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f367a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

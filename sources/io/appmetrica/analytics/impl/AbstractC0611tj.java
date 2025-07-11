package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.tj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0611tj {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1063a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        f1063a = iArr;
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1063a[CounterConfigurationReporterType.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

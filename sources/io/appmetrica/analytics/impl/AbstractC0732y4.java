package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0732y4 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1289a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        try {
            iArr[CounterConfigurationReporterType.COMMUTATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[CounterConfigurationReporterType.MANUAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[CounterConfigurationReporterType.SELF_SDK.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[CounterConfigurationReporterType.MAIN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[CounterConfigurationReporterType.CRASH.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        f1289a = iArr;
    }
}

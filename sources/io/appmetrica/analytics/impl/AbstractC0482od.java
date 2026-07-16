package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
/* renamed from: io.appmetrica.analytics.impl.od  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0482od {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1132a;

    static {
        int[] iArr = new int[ModuleAdType.values().length];
        try {
            iArr[ModuleAdType.NATIVE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ModuleAdType.BANNER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[ModuleAdType.REWARDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[ModuleAdType.INTERSTITIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[ModuleAdType.MREC.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[ModuleAdType.APP_OPEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[ModuleAdType.OTHER.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        f1132a = iArr;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
/* renamed from: io.appmetrica.analytics.impl.gd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC0282gd {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f853a;

    static {
        int[] iArr = new int[ModuleAdType.values().length];
        iArr[ModuleAdType.NATIVE.ordinal()] = 1;
        iArr[ModuleAdType.BANNER.ordinal()] = 2;
        iArr[ModuleAdType.REWARDED.ordinal()] = 3;
        iArr[ModuleAdType.INTERSTITIAL.ordinal()] = 4;
        iArr[ModuleAdType.MREC.ordinal()] = 5;
        iArr[ModuleAdType.APP_OPEN.ordinal()] = 6;
        iArr[ModuleAdType.OTHER.ordinal()] = 7;
        f853a = iArr;
    }
}

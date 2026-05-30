package io.appmetrica.analytics.adrevenue.fyber.v3.impl;

import com.fyber.fairbid.ads.PlacementType;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f228a;

    static {
        int[] iArr = new int[PlacementType.values().length];
        f228a = iArr;
        try {
            iArr[PlacementType.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f228a[PlacementType.REWARDED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f228a[PlacementType.INTERSTITIAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

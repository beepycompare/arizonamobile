package io.appmetrica.analytics.coreapi.internal.identifiers;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class AdvertisingIdsHolder {

    /* renamed from: a  reason: collision with root package name */
    private final AdTrackingInfoResult f321a;
    private final AdTrackingInfoResult b;
    private final AdTrackingInfoResult c;

    public AdvertisingIdsHolder() {
        this(new AdTrackingInfoResult(), new AdTrackingInfoResult(), new AdTrackingInfoResult());
    }

    public AdTrackingInfoResult getGoogle() {
        return this.f321a;
    }

    public AdTrackingInfoResult getHuawei() {
        return this.b;
    }

    public AdTrackingInfoResult getYandex() {
        return this.c;
    }

    public String toString() {
        return "AdvertisingIdsHolder{mGoogle=" + this.f321a + ", mHuawei=" + this.b + ", yandex=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public AdvertisingIdsHolder(AdTrackingInfoResult adTrackingInfoResult, AdTrackingInfoResult adTrackingInfoResult2, AdTrackingInfoResult adTrackingInfoResult3) {
        this.f321a = adTrackingInfoResult;
        this.b = adTrackingInfoResult2;
        this.c = adTrackingInfoResult3;
    }
}

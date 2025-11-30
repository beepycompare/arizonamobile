package io.appmetrica.analytics.coreapi.internal.identifiers;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public class AdvertisingIdsHolder {

    /* renamed from: a  reason: collision with root package name */
    private final AdTrackingInfoResult f270a;
    private final AdTrackingInfoResult b;
    private final AdTrackingInfoResult c;

    public AdvertisingIdsHolder() {
        this(new AdTrackingInfoResult(), new AdTrackingInfoResult(), new AdTrackingInfoResult());
    }

    public AdTrackingInfoResult getGoogle() {
        return this.f270a;
    }

    public AdTrackingInfoResult getHuawei() {
        return this.b;
    }

    public AdTrackingInfoResult getYandex() {
        return this.c;
    }

    public String toString() {
        return "AdvertisingIdsHolder{mGoogle=" + this.f270a + ", mHuawei=" + this.b + ", yandex=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public AdvertisingIdsHolder(AdTrackingInfoResult adTrackingInfoResult, AdTrackingInfoResult adTrackingInfoResult2, AdTrackingInfoResult adTrackingInfoResult3) {
        this.f270a = adTrackingInfoResult;
        this.b = adTrackingInfoResult2;
        this.c = adTrackingInfoResult3;
    }
}

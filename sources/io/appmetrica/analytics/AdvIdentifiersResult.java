package io.appmetrica.analytics;
/* loaded from: classes2.dex */
public class AdvIdentifiersResult {
    public final AdvId googleAdvId;
    public final AdvId huaweiAdvId;
    public final AdvId yandexAdvId;

    /* loaded from: classes2.dex */
    public static class AdvId {
        public final String advId;
        public final Details details;
        public final String errorExplanation;

        public AdvId(String str, Details details, String str2) {
            this.advId = str;
            this.details = details;
            this.errorExplanation = str2;
        }
    }

    /* loaded from: classes2.dex */
    public enum Details {
        OK,
        IDENTIFIER_PROVIDER_UNAVAILABLE,
        INVALID_ADV_ID,
        FEATURE_DISABLED,
        NO_STARTUP,
        INTERNAL_ERROR,
        FORBIDDEN_BY_CLIENT_CONFIG
    }

    public AdvIdentifiersResult(AdvId advId, AdvId advId2, AdvId advId3) {
        this.googleAdvId = advId;
        this.huaweiAdvId = advId2;
        this.yandexAdvId = advId3;
    }
}

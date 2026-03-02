package io.appmetrica.analytics;

import java.util.Map;
/* loaded from: classes3.dex */
public interface DeferredDeeplinkParametersListener {

    /* loaded from: classes3.dex */
    public enum Error {
        NOT_A_FIRST_LAUNCH("Deferred deeplink parameters can be requested during first launch only."),
        PARSE_ERROR("Google Play referrer did not contain valid deferred deeplink parameters."),
        NO_REFERRER("No referrer was found"),
        UNKNOWN("Unknown error");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f279a;

        Error(String str) {
            this.f279a = str;
        }

        public String getDescription() {
            return this.f279a;
        }
    }

    void onError(Error error, String str);

    void onParametersLoaded(Map<String, String> map);
}

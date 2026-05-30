package io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate;

import io.appmetrica.analytics.impl.M2;
/* loaded from: classes5.dex */
public enum ApplicationState {
    UNKNOWN("unknown"),
    BACKGROUND(M2.g),
    VISIBLE("visible");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f332a;

    ApplicationState(String str) {
        this.f332a = str;
    }

    public static ApplicationState fromString(String str) {
        ApplicationState[] values;
        ApplicationState applicationState = UNKNOWN;
        for (ApplicationState applicationState2 : values()) {
            if (applicationState2.f332a.equals(str)) {
                return applicationState2;
            }
        }
        return applicationState;
    }

    public String getStringValue() {
        return this.f332a;
    }
}

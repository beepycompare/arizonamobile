package io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate;

import io.appmetrica.analytics.impl.L2;
/* loaded from: classes4.dex */
public enum ApplicationState {
    UNKNOWN("unknown"),
    BACKGROUND(L2.g),
    VISIBLE("visible");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f251a;

    ApplicationState(String str) {
        this.f251a = str;
    }

    public static ApplicationState fromString(String str) {
        ApplicationState[] values;
        ApplicationState applicationState = UNKNOWN;
        for (ApplicationState applicationState2 : values()) {
            if (applicationState2.f251a.equals(str)) {
                return applicationState2;
            }
        }
        return applicationState;
    }

    public String getStringValue() {
        return this.f251a;
    }
}

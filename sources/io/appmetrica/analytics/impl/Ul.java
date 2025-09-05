package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ul extends HashMap {
    public Ul() {
        put(Sl.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Sl.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Sl.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

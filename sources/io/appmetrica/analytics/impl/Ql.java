package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ql extends HashMap {
    public Ql() {
        put(Ol.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Ol.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Ol.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

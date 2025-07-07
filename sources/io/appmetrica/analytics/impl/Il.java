package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Il extends HashMap {
    public Il() {
        put(Gl.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Gl.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Gl.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

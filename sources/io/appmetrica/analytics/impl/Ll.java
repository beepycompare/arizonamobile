package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ll extends HashMap {
    public Ll() {
        put(Jl.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Jl.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Jl.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

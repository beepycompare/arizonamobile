package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ml extends HashMap {
    public Ml() {
        put(Kl.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Kl.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Kl.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

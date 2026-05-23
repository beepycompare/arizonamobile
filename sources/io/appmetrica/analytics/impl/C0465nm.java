package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0465nm extends HashMap {
    public C0465nm() {
        put(EnumC0413lm.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(EnumC0413lm.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(EnumC0413lm.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

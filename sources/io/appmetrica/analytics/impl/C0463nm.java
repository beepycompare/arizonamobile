package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0463nm extends HashMap {
    public C0463nm() {
        put(EnumC0411lm.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(EnumC0411lm.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(EnumC0411lm.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

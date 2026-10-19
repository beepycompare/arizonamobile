package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0458nm extends HashMap {
    public C0458nm() {
        put(EnumC0406lm.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(EnumC0406lm.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(EnumC0406lm.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

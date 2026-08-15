package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0464nm extends HashMap {
    public C0464nm() {
        put(EnumC0412lm.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(EnumC0412lm.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(EnumC0412lm.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}

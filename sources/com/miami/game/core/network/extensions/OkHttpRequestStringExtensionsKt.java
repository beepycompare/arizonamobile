package com.miami.game.core.network.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
/* compiled from: OkHttpRequestStringExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toSafeString", "", "Lokhttp3/Request;", "network_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OkHttpRequestStringExtensionsKt {
    public static final String toSafeString(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        String method = request.method();
        return "Request(method=" + method + ", url=" + request.url() + ")";
    }
}

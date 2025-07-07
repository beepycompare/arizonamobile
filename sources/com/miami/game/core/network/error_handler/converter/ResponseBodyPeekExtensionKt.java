package com.miami.game.core.network.error_handler.converter;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
/* compiled from: ResponseBodyPeekExtension.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"peek", "Lokhttp3/ResponseBody;", "byteCount", "", "network_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseBodyPeekExtensionKt {
    public static final ResponseBody peek(ResponseBody responseBody, long j) throws IOException {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        BufferedSource source = responseBody.source();
        source.request(j);
        Buffer clone = source.getBuffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.Companion.create(responseBody.contentType(), clone.size(), clone);
    }
}

package io.appmetrica.analytics.network.internal;

import io.appmetrica.analytics.network.impl.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class Response {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1224a;
    private final int b;
    private final byte[] c;
    private final byte[] d;
    private final Map e;
    private final Throwable f;

    public Response(Throwable th) {
        this(false, 0, new byte[0], new byte[0], new HashMap(), th);
    }

    public int getCode() {
        return this.b;
    }

    public byte[] getErrorData() {
        return this.d;
    }

    public Throwable getException() {
        return this.f;
    }

    public Map<String, List<String>> getHeaders() {
        return this.e;
    }

    public byte[] getResponseData() {
        return this.c;
    }

    public boolean isCompleted() {
        return this.f1224a;
    }

    public String toString() {
        return "Response{completed=" + this.f1224a + ", code=" + this.b + ", responseDataLength=" + this.c.length + ", errorDataLength=" + this.d.length + ", headers=" + this.e + ", exception=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    public Response(boolean z, int i, byte[] bArr, byte[] bArr2, Map<String, List<String>> map, Throwable th) {
        Map a2;
        this.f1224a = z;
        this.b = i;
        this.c = bArr;
        this.d = bArr2;
        if (map == null) {
            a2 = Collections.emptyMap();
        } else {
            a2 = e.a(map);
        }
        this.e = a2;
        this.f = th;
    }
}

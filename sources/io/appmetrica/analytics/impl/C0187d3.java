package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0187d3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f951a;

    public C0187d3(long j) {
        this.f951a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0187d3.class == obj.getClass() && this.f951a == ((C0187d3) obj).f951a;
    }

    public final int hashCode() {
        long j = this.f951a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f951a + AbstractJsonLexerKt.END_OBJ;
    }
}

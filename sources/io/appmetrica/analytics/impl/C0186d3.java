package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0186d3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f955a;

    public C0186d3(long j) {
        this.f955a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0186d3.class == obj.getClass() && this.f955a == ((C0186d3) obj).f955a;
    }

    public final int hashCode() {
        long j = this.f955a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f955a + AbstractJsonLexerKt.END_OBJ;
    }
}

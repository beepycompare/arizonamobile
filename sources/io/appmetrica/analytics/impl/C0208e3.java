package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.e3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0208e3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f863a;

    public C0208e3(long j) {
        this.f863a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0208e3.class == obj.getClass() && this.f863a == ((C0208e3) obj).f863a;
    }

    public final int hashCode() {
        long j = this.f863a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f863a + AbstractJsonLexerKt.END_OBJ;
    }
}

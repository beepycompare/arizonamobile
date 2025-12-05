package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.e3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0207e3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f946a;

    public C0207e3(long j) {
        this.f946a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0207e3.class == obj.getClass() && this.f946a == ((C0207e3) obj).f946a;
    }

    public final int hashCode() {
        long j = this.f946a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f946a + AbstractJsonLexerKt.END_OBJ;
    }
}

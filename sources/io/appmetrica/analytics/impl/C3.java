package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class C3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f377a;

    public C3(long j) {
        this.f377a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C3.class == obj.getClass() && this.f377a == ((C3) obj).f377a;
    }

    public final int hashCode() {
        long j = this.f377a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f377a + AbstractJsonLexerKt.END_OBJ;
    }
}

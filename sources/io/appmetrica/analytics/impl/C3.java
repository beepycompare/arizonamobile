package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class C3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f382a;

    public C3(long j) {
        this.f382a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C3.class == obj.getClass() && this.f382a == ((C3) obj).f382a;
    }

    public final int hashCode() {
        long j = this.f382a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f382a + AbstractJsonLexerKt.END_OBJ;
    }
}

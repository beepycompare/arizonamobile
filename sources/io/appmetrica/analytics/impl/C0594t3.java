package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.t3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0594t3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1213a;

    public C0594t3(long j) {
        this.f1213a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0594t3.class == obj.getClass() && this.f1213a == ((C0594t3) obj).f1213a;
    }

    public final int hashCode() {
        long j = this.f1213a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f1213a + AbstractJsonLexerKt.END_OBJ;
    }
}

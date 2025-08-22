package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0745z3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1171a;

    public C0745z3(long j) {
        this.f1171a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0745z3.class == obj.getClass() && this.f1171a == ((C0745z3) obj).f1171a;
    }

    public final int hashCode() {
        long j = this.f1171a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f1171a + AbstractJsonLexerKt.END_OBJ;
    }
}

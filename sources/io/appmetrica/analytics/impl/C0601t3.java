package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.t3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0601t3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1208a;

    public C0601t3(long j) {
        this.f1208a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0601t3.class == obj.getClass() && this.f1208a == ((C0601t3) obj).f1208a;
    }

    public final int hashCode() {
        long j = this.f1208a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f1208a + AbstractJsonLexerKt.END_OBJ;
    }
}

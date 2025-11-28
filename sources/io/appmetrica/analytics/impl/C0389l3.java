package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0389l3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f982a;

    public C0389l3(long j) {
        this.f982a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0389l3.class == obj.getClass() && this.f982a == ((C0389l3) obj).f982a;
    }

    public final int hashCode() {
        long j = this.f982a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f982a + AbstractJsonLexerKt.END_OBJ;
    }
}

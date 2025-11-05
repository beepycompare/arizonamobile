package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public final class Km {

    /* renamed from: a  reason: collision with root package name */
    public final long f564a;

    public Km(long j) {
        this.f564a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Km.class == obj.getClass() && this.f564a == ((Km) obj).f564a;
    }

    public final int hashCode() {
        long j = this.f564a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f564a + AbstractJsonLexerKt.END_OBJ;
    }
}

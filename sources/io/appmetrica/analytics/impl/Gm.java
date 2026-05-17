package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Gm {

    /* renamed from: a  reason: collision with root package name */
    public final long f607a;

    public Gm(long j) {
        this.f607a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Gm.class == obj.getClass() && this.f607a == ((Gm) obj).f607a;
    }

    public final int hashCode() {
        long j = this.f607a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f607a + AbstractJsonLexerKt.END_OBJ;
    }
}

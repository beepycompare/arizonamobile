package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Hm {

    /* renamed from: a  reason: collision with root package name */
    public final long f477a;

    public Hm(long j) {
        this.f477a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Hm.class == obj.getClass() && this.f477a == ((Hm) obj).f477a;
    }

    public final int hashCode() {
        long j = this.f477a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f477a + AbstractJsonLexerKt.END_OBJ;
    }
}

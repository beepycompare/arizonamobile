package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Qm {

    /* renamed from: a  reason: collision with root package name */
    public final long f646a;

    public Qm(long j) {
        this.f646a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Qm.class == obj.getClass() && this.f646a == ((Qm) obj).f646a;
    }

    public final int hashCode() {
        long j = this.f646a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f646a + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Qm {

    /* renamed from: a  reason: collision with root package name */
    public final long f645a;

    public Qm(long j) {
        this.f645a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Qm.class == obj.getClass() && this.f645a == ((Qm) obj).f645a;
    }

    public final int hashCode() {
        long j = this.f645a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f645a + AbstractJsonLexerKt.END_OBJ;
    }
}

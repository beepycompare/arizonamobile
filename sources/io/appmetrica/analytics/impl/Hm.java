package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Hm {

    /* renamed from: a  reason: collision with root package name */
    public final long f513a;

    public Hm(long j) {
        this.f513a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Hm.class == obj.getClass() && this.f513a == ((Hm) obj).f513a;
    }

    public final int hashCode() {
        long j = this.f513a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f513a + AbstractJsonLexerKt.END_OBJ;
    }
}

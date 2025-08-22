package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Mm {

    /* renamed from: a  reason: collision with root package name */
    public final long f566a;

    public Mm(long j) {
        this.f566a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Mm.class == obj.getClass() && this.f566a == ((Mm) obj).f566a;
    }

    public final int hashCode() {
        long j = this.f566a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f566a + AbstractJsonLexerKt.END_OBJ;
    }
}

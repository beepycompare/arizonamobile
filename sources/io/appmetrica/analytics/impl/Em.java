package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Em {

    /* renamed from: a  reason: collision with root package name */
    public final long f416a;

    public Em(long j) {
        this.f416a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Em.class == obj.getClass() && this.f416a == ((Em) obj).f416a;
    }

    public final int hashCode() {
        long j = this.f416a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f416a + AbstractJsonLexerKt.END_OBJ;
    }
}

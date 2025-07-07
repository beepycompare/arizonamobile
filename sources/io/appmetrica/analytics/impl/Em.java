package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Em {

    /* renamed from: a  reason: collision with root package name */
    public final long f415a;

    public Em(long j) {
        this.f415a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Em.class == obj.getClass() && this.f415a == ((Em) obj).f415a;
    }

    public final int hashCode() {
        long j = this.f415a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f415a + AbstractJsonLexerKt.END_OBJ;
    }
}

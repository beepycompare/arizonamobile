package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Hm {

    /* renamed from: a  reason: collision with root package name */
    public final long f478a;

    public Hm(long j) {
        this.f478a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Hm.class == obj.getClass() && this.f478a == ((Hm) obj).f478a;
    }

    public final int hashCode() {
        long j = this.f478a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f478a + AbstractJsonLexerKt.END_OBJ;
    }
}

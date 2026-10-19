package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.in  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329in {

    /* renamed from: a  reason: collision with root package name */
    public final long f1045a;

    public C0329in(long j) {
        this.f1045a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0329in.class == obj.getClass() && this.f1045a == ((C0329in) obj).f1045a;
    }

    public final int hashCode() {
        long j = this.f1045a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f1045a + AbstractJsonLexerKt.END_OBJ;
    }
}

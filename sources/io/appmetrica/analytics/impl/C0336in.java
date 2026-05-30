package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.in  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0336in {

    /* renamed from: a  reason: collision with root package name */
    public final long f1040a;

    public C0336in(long j) {
        this.f1040a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0336in.class == obj.getClass() && this.f1040a == ((C0336in) obj).f1040a;
    }

    public final int hashCode() {
        long j = this.f1040a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f1040a + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Zi implements A3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f776a;
    public final A3 b;

    public Zi(Object obj, A3 a3) {
        this.f776a = obj;
        this.b = a3;
    }

    @Override // io.appmetrica.analytics.impl.A3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f776a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Gn implements InterfaceC0703x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f449a;
    public final InterfaceC0703x3 b;

    public Gn(Object obj, InterfaceC0703x3 interfaceC0703x3) {
        this.f449a = obj;
        this.b = interfaceC0703x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0703x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f449a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

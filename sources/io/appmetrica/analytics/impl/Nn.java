package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Nn implements InterfaceC0156c3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f694a;
    public final InterfaceC0156c3 b;

    public Nn(Object obj, InterfaceC0156c3 interfaceC0156c3) {
        this.f694a = obj;
        this.b = interfaceC0156c3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0156c3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f694a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

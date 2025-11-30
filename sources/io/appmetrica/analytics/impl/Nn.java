package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Nn implements InterfaceC0157c3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f611a;
    public final InterfaceC0157c3 b;

    public Nn(Object obj, InterfaceC0157c3 interfaceC0157c3) {
        this.f611a = obj;
        this.b = interfaceC0157c3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0157c3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f611a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

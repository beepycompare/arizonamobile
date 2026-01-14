package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Mn implements InterfaceC0135b3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f700a;
    public final InterfaceC0135b3 b;

    public Mn(Object obj, InterfaceC0135b3 interfaceC0135b3) {
        this.f700a = obj;
        this.b = interfaceC0135b3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135b3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f700a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

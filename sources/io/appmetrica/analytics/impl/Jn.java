package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Jn implements InterfaceC0697x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f511a;
    public final InterfaceC0697x3 b;

    public Jn(Object obj, InterfaceC0697x3 interfaceC0697x3) {
        this.f511a = obj;
        this.b = interfaceC0697x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0697x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f511a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

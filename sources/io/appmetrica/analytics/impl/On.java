package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public final class On implements InterfaceC0337j3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f625a;
    public final InterfaceC0337j3 b;

    public On(Object obj, InterfaceC0337j3 interfaceC0337j3) {
        this.f625a = obj;
        this.b = interfaceC0337j3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0337j3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f625a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

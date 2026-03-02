package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Mn implements InterfaceC0134b3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f699a;
    public final InterfaceC0134b3 b;

    public Mn(Object obj, InterfaceC0134b3 interfaceC0134b3) {
        this.f699a = obj;
        this.b = interfaceC0134b3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0134b3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f699a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

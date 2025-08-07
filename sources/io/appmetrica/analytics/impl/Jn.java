package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Jn implements InterfaceC0698x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f511a;
    public final InterfaceC0698x3 b;

    public Jn(Object obj, InterfaceC0698x3 interfaceC0698x3) {
        this.f511a = obj;
        this.b = interfaceC0698x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f511a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

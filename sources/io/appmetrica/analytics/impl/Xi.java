package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Xi implements InterfaceC0542r3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f844a;
    public final InterfaceC0542r3 b;

    public Xi(Object obj, InterfaceC0542r3 interfaceC0542r3) {
        this.f844a = obj;
        this.b = interfaceC0542r3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0542r3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f844a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

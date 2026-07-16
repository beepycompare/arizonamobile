package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Xi implements InterfaceC0549r3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f841a;
    public final InterfaceC0549r3 b;

    public Xi(Object obj, InterfaceC0549r3 interfaceC0549r3) {
        this.f841a = obj;
        this.b = interfaceC0549r3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0549r3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f841a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

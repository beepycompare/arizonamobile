package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Ni implements InterfaceC0695x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f557a;
    public final InterfaceC0695x3 b;

    public Ni(Object obj, InterfaceC0695x3 interfaceC0695x3) {
        this.f557a = obj;
        this.b = interfaceC0695x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f557a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

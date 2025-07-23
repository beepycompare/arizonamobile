package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Qi implements InterfaceC0697x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f612a;
    public final InterfaceC0697x3 b;

    public Qi(Object obj, InterfaceC0697x3 interfaceC0697x3) {
        this.f612a = obj;
        this.b = interfaceC0697x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0697x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f612a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

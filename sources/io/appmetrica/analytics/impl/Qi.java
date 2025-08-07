package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Qi implements InterfaceC0698x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f612a;
    public final InterfaceC0698x3 b;

    public Qi(Object obj, InterfaceC0698x3 interfaceC0698x3) {
        this.f612a = obj;
        this.b = interfaceC0698x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f612a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

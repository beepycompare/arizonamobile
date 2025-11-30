package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Ei implements InterfaceC0157c3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f463a;
    public final InterfaceC0157c3 b;

    public Ei(Object obj, InterfaceC0157c3 interfaceC0157c3) {
        this.f463a = obj;
        this.b = interfaceC0157c3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0157c3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f463a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

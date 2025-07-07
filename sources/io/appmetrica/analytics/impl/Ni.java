package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Ni implements InterfaceC0703x3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f556a;
    public final InterfaceC0703x3 b;

    public Ni(Object obj, InterfaceC0703x3 interfaceC0703x3) {
        this.f556a = obj;
        this.b = interfaceC0703x3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0703x3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f556a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

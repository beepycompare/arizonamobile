package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.po  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0519po implements InterfaceC0549r3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1155a;
    public final InterfaceC0549r3 b;

    public C0519po(Object obj, InterfaceC0549r3 interfaceC0549r3) {
        this.f1155a = obj;
        this.b = interfaceC0549r3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0549r3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f1155a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

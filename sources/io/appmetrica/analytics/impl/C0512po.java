package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.po  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0512po implements InterfaceC0542r3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1158a;
    public final InterfaceC0542r3 b;

    public C0512po(Object obj, InterfaceC0542r3 interfaceC0542r3) {
        this.f1158a = obj;
        this.b = interfaceC0542r3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0542r3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f1158a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

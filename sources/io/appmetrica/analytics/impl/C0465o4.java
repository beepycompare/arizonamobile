package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.o4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0465o4 extends C0131b3 {
    public final int b;

    public C0465o4(int i, int i2) {
        super(i2);
        this.b = i;
    }

    @Override // io.appmetrica.analytics.impl.C0131b3
    public final String toString() {
        return "CollectionTrimInfo{itemsDropped=" + this.b + ", bytesTruncated=" + this.f809a + AbstractJsonLexerKt.END_OBJ;
    }
}

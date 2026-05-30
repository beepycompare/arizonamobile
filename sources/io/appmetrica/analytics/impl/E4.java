package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class E4 extends C0524q3 {
    public final int b;

    public E4(int i, int i2) {
        super(i2);
        this.b = i;
    }

    @Override // io.appmetrica.analytics.impl.C0524q3
    public final String toString() {
        return "CollectionTrimInfo{itemsDropped=" + this.b + ", bytesTruncated=" + this.f1158a + AbstractJsonLexerKt.END_OBJ;
    }
}

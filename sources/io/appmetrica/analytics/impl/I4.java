package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class I4 extends C0670w3 {
    public final int b;

    public I4(int i, int i2) {
        super(i2);
        this.b = i;
    }

    @Override // io.appmetrica.analytics.impl.C0670w3
    public final String toString() {
        return "CollectionTrimInfo{itemsDropped=" + this.b + ", bytesTruncated=" + this.f1098a + AbstractJsonLexerKt.END_OBJ;
    }
}

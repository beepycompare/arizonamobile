package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.n4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0442n4 extends C0108a3 {
    public final int b;

    public C0442n4(int i, int i2) {
        super(i2);
        this.b = i;
    }

    @Override // io.appmetrica.analytics.impl.C0108a3
    public final String toString() {
        return "CollectionTrimInfo{itemsDropped=" + this.b + ", bytesTruncated=" + this.f901a + AbstractJsonLexerKt.END_OBJ;
    }
}

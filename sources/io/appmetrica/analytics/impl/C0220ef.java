package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0220ef implements R7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0550rf f871a;
    public final List<C0195df> b;

    public C0220ef(C0550rf c0550rf, List<C0195df> list) {
        this.f871a = c0550rf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final List<C0195df> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final Object b() {
        return this.f871a;
    }

    public final C0550rf c() {
        return this.f871a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f871a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

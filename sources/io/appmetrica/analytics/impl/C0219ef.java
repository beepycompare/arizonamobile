package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0219ef implements R7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0549rf f968a;
    public final List<C0194df> b;

    public C0219ef(C0549rf c0549rf, List<C0194df> list) {
        this.f968a = c0549rf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final List<C0194df> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final Object b() {
        return this.f968a;
    }

    public final C0549rf c() {
        return this.f968a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f968a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

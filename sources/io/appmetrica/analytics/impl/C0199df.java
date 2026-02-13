package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.df  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0199df implements Q7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0529qf f958a;
    public final List<C0173cf> b;

    public C0199df(C0529qf c0529qf, List<C0173cf> list) {
        this.f958a = c0529qf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final List<C0173cf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final Object b() {
        return this.f958a;
    }

    public final C0529qf c() {
        return this.f958a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f958a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

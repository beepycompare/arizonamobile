package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.if  reason: invalid class name */
/* loaded from: classes3.dex */
public final class Cif implements W7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0650vf f935a;
    public final List<C0298hf> b;

    public Cif(C0650vf c0650vf, List<C0298hf> list) {
        this.f935a = c0650vf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.W7
    public final List<C0298hf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.W7
    public final Object b() {
        return this.f935a;
    }

    public final C0650vf c() {
        return this.f935a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f935a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

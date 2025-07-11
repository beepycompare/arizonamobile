package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0508pf implements InterfaceC0277g8 {

    /* renamed from: a  reason: collision with root package name */
    public final Cf f991a;
    public final List<C0483of> b;

    public C0508pf(Cf cf, List<C0483of> list) {
        this.f991a = cf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0277g8
    public final List<C0483of> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0277g8
    public final Object b() {
        return this.f991a;
    }

    public final Cf c() {
        return this.f991a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f991a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

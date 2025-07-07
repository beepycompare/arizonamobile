package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0516pf implements InterfaceC0285g8 {

    /* renamed from: a  reason: collision with root package name */
    public final Cf f990a;
    public final List<C0491of> b;

    public C0516pf(Cf cf, List<C0491of> list) {
        this.f990a = cf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0285g8
    public final List<C0491of> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0285g8
    public final Object b() {
        return this.f990a;
    }

    public final Cf c() {
        return this.f990a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f990a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

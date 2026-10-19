package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Df implements InterfaceC0315i8 {

    /* renamed from: a  reason: collision with root package name */
    public final Qf f518a;
    public final List<Cf> b;

    public Df(Qf qf, List<Cf> list) {
        this.f518a = qf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0315i8
    public final List<Cf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0315i8
    public final Object b() {
        return this.f518a;
    }

    public final Qf c() {
        return this.f518a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f518a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

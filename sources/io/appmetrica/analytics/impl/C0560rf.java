package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0560rf implements InterfaceC0354j8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ef f1036a;
    public final List<C0536qf> b;

    public C0560rf(Ef ef, List<C0536qf> list) {
        this.f1036a = ef;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354j8
    public final List<C0536qf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354j8
    public final Object b() {
        return this.f1036a;
    }

    public final Ef c() {
        return this.f1036a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f1036a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0559rf implements InterfaceC0353j8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ef f1037a;
    public final List<C0535qf> b;

    public C0559rf(Ef ef, List<C0535qf> list) {
        this.f1037a = ef;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0353j8
    public final List<C0535qf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0353j8
    public final Object b() {
        return this.f1037a;
    }

    public final Ef c() {
        return this.f1037a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f1037a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

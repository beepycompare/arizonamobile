package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.tf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0607tf implements InterfaceC0401l8 {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f1073a;
    public final List<C0582sf> b;

    public C0607tf(Gf gf, List<C0582sf> list) {
        this.f1073a = gf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0401l8
    public final List<C0582sf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0401l8
    public final Object b() {
        return this.f1073a;
    }

    public final Gf c() {
        return this.f1073a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f1073a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.xf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0711xf implements InterfaceC0479o8 {

    /* renamed from: a  reason: collision with root package name */
    public final Kf f1155a;
    public final List<C0686wf> b;

    public C0711xf(Kf kf, List<C0686wf> list) {
        this.f1155a = kf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479o8
    public final List<C0686wf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479o8
    public final Object b() {
        return this.f1155a;
    }

    public final Kf c() {
        return this.f1155a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f1155a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

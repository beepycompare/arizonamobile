package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.xf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0712xf implements InterfaceC0480o8 {

    /* renamed from: a  reason: collision with root package name */
    public final Kf f1156a;
    public final List<C0687wf> b;

    public C0712xf(Kf kf, List<C0687wf> list) {
        this.f1156a = kf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480o8
    public final List<C0687wf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480o8
    public final Object b() {
        return this.f1156a;
    }

    public final Kf c() {
        return this.f1156a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f1156a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

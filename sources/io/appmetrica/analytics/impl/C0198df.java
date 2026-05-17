package io.appmetrica.analytics.impl;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.df  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0198df implements Q7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0528qf f963a;
    public final List<C0172cf> b;

    public C0198df(C0528qf c0528qf, List<C0172cf> list) {
        this.f963a = c0528qf;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final List<C0172cf> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final Object b() {
        return this.f963a;
    }

    public final C0528qf c() {
        return this.f963a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.f963a + ", candidates=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

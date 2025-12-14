package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0303hl implements InterfaceC0161c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f1024a;

    public C0303hl() {
        this(new Zi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0277gl c0277gl) {
        C0642v8 c0642v8 = new C0642v8();
        c0642v8.f1262a = 1;
        c0642v8.b = new C0617u8();
        Ei fromModel = this.f1024a.fromModel(c0277gl.f1007a);
        c0642v8.b.f1243a = (C0542r8) fromModel.f560a;
        C0130b3 c0130b3 = new C0130b3(C0130b3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Ei(c0642v8, c0130b3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0303hl(Zi zi) {
        this.f1024a = zi;
    }

    public final C0277gl a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}

package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0304hl implements InterfaceC0162c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Zi f927a;

    public C0304hl() {
        this(new Zi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0278gl c0278gl) {
        C0643v8 c0643v8 = new C0643v8();
        c0643v8.f1165a = 1;
        c0643v8.b = new C0618u8();
        Ei fromModel = this.f927a.fromModel(c0278gl.f910a);
        c0643v8.b.f1146a = (C0543r8) fromModel.f463a;
        C0131b3 c0131b3 = new C0131b3(C0131b3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Ei(c0643v8, c0131b3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0304hl(Zi zi) {
        this.f927a = zi;
    }

    public final C0278gl a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}

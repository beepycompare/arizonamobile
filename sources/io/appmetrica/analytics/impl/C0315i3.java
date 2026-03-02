package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0315i3 implements InterfaceC0139b8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0340j3 f1037a;

    public C0315i3() {
        this(new C0340j3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0289h3 c0289h3) {
        C0620u8 c0620u8 = new C0620u8();
        c0620u8.e = new C0191d8();
        Di fromModel = this.f1037a.fromModel(c0289h3.b);
        c0620u8.e.f954a = (C0216e8) fromModel.f552a;
        c0620u8.f1252a = c0289h3.f1021a;
        return Collections.singletonList(new Di(c0620u8, new C0108a3(C0108a3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0315i3(C0340j3 c0340j3) {
        this.f1037a = c0340j3;
    }

    public final C0289h3 a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

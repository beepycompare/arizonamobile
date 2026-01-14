package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0316i3 implements InterfaceC0140b8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0341j3 f1038a;

    public C0316i3() {
        this(new C0341j3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0290h3 c0290h3) {
        C0621u8 c0621u8 = new C0621u8();
        c0621u8.e = new C0192d8();
        Di fromModel = this.f1038a.fromModel(c0290h3.b);
        c0621u8.e.f955a = (C0217e8) fromModel.f553a;
        c0621u8.f1253a = c0290h3.f1022a;
        return Collections.singletonList(new Di(c0621u8, new C0109a3(C0109a3.b(fromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0316i3(C0341j3 c0341j3) {
        this.f1038a = c0341j3;
    }

    public final C0290h3 a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

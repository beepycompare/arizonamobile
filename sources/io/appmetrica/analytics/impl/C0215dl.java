package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0215dl implements InterfaceC0575s8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0337ij f810a;

    public C0215dl() {
        this(new C0337ij());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(C0189cl c0189cl) {
        L8 l8 = new L8();
        l8.f516a = 1;
        l8.b = new K8();
        Ni fromModel = this.f810a.fromModel(c0189cl.f788a);
        l8.b.f504a = (H8) fromModel.f557a;
        C0670w3 c0670w3 = new C0670w3(C0670w3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Ni(l8, c0670w3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0215dl(C0337ij c0337ij) {
        this.f810a = c0337ij;
    }

    public final C0189cl a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}

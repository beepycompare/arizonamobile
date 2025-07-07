package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0223dl implements InterfaceC0583s8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0345ij f809a;

    public C0223dl() {
        this(new C0345ij());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(C0197cl c0197cl) {
        L8 l8 = new L8();
        l8.f515a = 1;
        l8.b = new K8();
        Ni fromModel = this.f809a.fromModel(c0197cl.f787a);
        l8.b.f503a = (H8) fromModel.f556a;
        C0678w3 c0678w3 = new C0678w3(C0678w3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Ni(l8, c0678w3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0223dl(C0345ij c0345ij) {
        this.f809a = c0345ij;
    }

    public final C0197cl a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}

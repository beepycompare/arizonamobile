package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0282gl implements InterfaceC0140b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f1017a;

    public C0282gl() {
        this(new Yi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0256fl c0256fl) {
        C0621u8 c0621u8 = new C0621u8();
        c0621u8.f1253a = 1;
        c0621u8.b = new C0596t8();
        Di fromModel = this.f1017a.fromModel(c0256fl.f999a);
        c0621u8.b.f1234a = (C0522q8) fromModel.f553a;
        C0109a3 c0109a3 = new C0109a3(C0109a3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Di(c0621u8, c0109a3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0282gl(Yi yi) {
        this.f1017a = yi;
    }

    public final C0256fl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

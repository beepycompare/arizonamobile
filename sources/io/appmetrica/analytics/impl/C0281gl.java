package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0281gl implements InterfaceC0139b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f1021a;

    public C0281gl() {
        this(new Yi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0255fl c0255fl) {
        C0620u8 c0620u8 = new C0620u8();
        c0620u8.f1257a = 1;
        c0620u8.b = new C0595t8();
        Di fromModel = this.f1021a.fromModel(c0255fl.f1003a);
        c0620u8.b.f1238a = (C0521q8) fromModel.f557a;
        C0108a3 c0108a3 = new C0108a3(C0108a3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Di(c0620u8, c0108a3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0281gl(Yi yi) {
        this.f1021a = yi;
    }

    public final C0255fl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

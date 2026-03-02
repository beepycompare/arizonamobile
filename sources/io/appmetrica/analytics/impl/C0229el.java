package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0229el implements InterfaceC0139b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f982a;
    public final C0276gg b;

    public C0229el() {
        this(new Gf(), new C0276gg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0204dl c0204dl) {
        Di di;
        C0620u8 c0620u8 = new C0620u8();
        c0620u8.f1252a = 3;
        c0620u8.d = new C0570s8();
        Di fromModel = this.f982a.fromModel(c0204dl.f961a);
        c0620u8.d.f1219a = (C0446n8) fromModel.f552a;
        C0703xg c0703xg = c0204dl.b;
        if (c0703xg != null) {
            di = this.b.fromModel(c0703xg);
            c0620u8.d.b = (C0496p8) di.f552a;
        } else {
            di = null;
        }
        return Collections.singletonList(new Di(c0620u8, new C0108a3(C0108a3.b(fromModel, di))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0229el(Gf gf, C0276gg c0276gg) {
        this.f982a = gf;
        this.b = c0276gg;
    }

    public final C0204dl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

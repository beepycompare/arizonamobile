package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0179cl implements InterfaceC0140b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f943a;
    public final Gf b;

    public C0179cl() {
        this(new Yi(), new Gf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0153bl c0153bl) {
        C0621u8 c0621u8 = new C0621u8();
        c0621u8.f1252a = 2;
        c0621u8.c = new C0546r8();
        Di fromModel = this.f943a.fromModel(c0153bl.b);
        c0621u8.c.b = (C0522q8) fromModel.f552a;
        Di fromModel2 = this.b.fromModel(c0153bl.f925a);
        c0621u8.c.f1204a = (C0447n8) fromModel2.f552a;
        return Collections.singletonList(new Di(c0621u8, new C0109a3(C0109a3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0179cl(Yi yi, Gf gf) {
        this.f943a = yi;
        this.b = gf;
    }

    public final C0153bl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

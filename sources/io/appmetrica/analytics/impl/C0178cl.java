package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0178cl implements InterfaceC0139b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f943a;
    public final Gf b;

    public C0178cl() {
        this(new Yi(), new Gf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0152bl c0152bl) {
        C0620u8 c0620u8 = new C0620u8();
        c0620u8.f1252a = 2;
        c0620u8.c = new C0545r8();
        Di fromModel = this.f943a.fromModel(c0152bl.b);
        c0620u8.c.b = (C0521q8) fromModel.f552a;
        Di fromModel2 = this.b.fromModel(c0152bl.f925a);
        c0620u8.c.f1204a = (C0446n8) fromModel2.f552a;
        return Collections.singletonList(new Di(c0620u8, new C0108a3(C0108a3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0178cl(Yi yi, Gf gf) {
        this.f943a = yi;
        this.b = gf;
    }

    public final C0152bl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

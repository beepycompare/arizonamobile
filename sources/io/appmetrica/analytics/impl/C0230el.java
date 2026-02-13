package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0230el implements InterfaceC0140b8 {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f982a;
    public final C0277gg b;

    public C0230el() {
        this(new Gf(), new C0277gg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0205dl c0205dl) {
        Di di;
        C0621u8 c0621u8 = new C0621u8();
        c0621u8.f1252a = 3;
        c0621u8.d = new C0571s8();
        Di fromModel = this.f982a.fromModel(c0205dl.f961a);
        c0621u8.d.f1219a = (C0447n8) fromModel.f552a;
        C0704xg c0704xg = c0205dl.b;
        if (c0704xg != null) {
            di = this.b.fromModel(c0704xg);
            c0621u8.d.b = (C0497p8) di.f552a;
        } else {
            di = null;
        }
        return Collections.singletonList(new Di(c0621u8, new C0109a3(C0109a3.b(fromModel, di))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0230el(Gf gf, C0277gg c0277gg) {
        this.f982a = gf;
        this.b = c0277gg;
    }

    public final C0205dl a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}

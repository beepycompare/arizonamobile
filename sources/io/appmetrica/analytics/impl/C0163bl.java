package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0163bl implements InterfaceC0575s8 {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f772a;
    public final C0558rg b;

    public C0163bl() {
        this(new Pf(), new C0558rg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(C0137al c0137al) {
        Ni ni;
        L8 l8 = new L8();
        l8.f516a = 3;
        l8.d = new J8();
        Ni fromModel = this.f772a.fromModel(c0137al.f757a);
        l8.d.f490a = (E8) fromModel.f557a;
        Ig ig = c0137al.b;
        if (ig != null) {
            ni = this.b.fromModel(ig);
            l8.d.b = (G8) ni.f557a;
        } else {
            ni = null;
        }
        return Collections.singletonList(new Ni(l8, new C0670w3(C0670w3.b(fromModel, ni))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0163bl(Pf pf, C0558rg c0558rg) {
        this.f772a = pf;
        this.b = c0558rg;
    }

    public final C0137al a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}

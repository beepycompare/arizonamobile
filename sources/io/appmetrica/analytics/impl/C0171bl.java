package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0171bl implements InterfaceC0583s8 {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f771a;
    public final C0566rg b;

    public C0171bl() {
        this(new Pf(), new C0566rg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(C0145al c0145al) {
        Ni ni;
        L8 l8 = new L8();
        l8.f515a = 3;
        l8.d = new J8();
        Ni fromModel = this.f771a.fromModel(c0145al.f756a);
        l8.d.f489a = (E8) fromModel.f556a;
        Ig ig = c0145al.b;
        if (ig != null) {
            ni = this.b.fromModel(ig);
            l8.d.b = (G8) ni.f556a;
        } else {
            ni = null;
        }
        return Collections.singletonList(new Ni(l8, new C0678w3(C0678w3.b(fromModel, ni))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0171bl(Pf pf, C0566rg c0566rg) {
        this.f771a = pf;
        this.b = c0566rg;
    }

    public final C0145al a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}

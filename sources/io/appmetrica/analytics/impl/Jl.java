package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Jl implements InterfaceC0632u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0304hg f617a;
    public final C0744yg b;

    public Jl() {
        this(new C0304hg(), new C0744yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Il il) {
        Xi xi;
        N8 n8 = new N8();
        n8.f680a = 3;
        n8.d = new L8();
        Xi fromModel = this.f617a.fromModel(il.f598a);
        n8.d.f643a = (G8) fromModel.f839a;
        Ng ng = il.b;
        if (ng != null) {
            xi = this.b.fromModel(ng);
            n8.d.b = (I8) xi.f839a;
        } else {
            xi = null;
        }
        return Collections.singletonList(new Xi(n8, new C0524q3(C0524q3.b(fromModel, xi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Jl(C0304hg c0304hg, C0744yg c0744yg) {
        this.f617a = c0304hg;
        this.b = c0744yg;
    }

    public final Il a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

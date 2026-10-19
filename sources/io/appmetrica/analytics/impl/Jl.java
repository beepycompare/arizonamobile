package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Jl implements InterfaceC0625u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0297hg f622a;
    public final C0737yg b;

    public Jl() {
        this(new C0297hg(), new C0737yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Il il) {
        Xi xi;
        N8 n8 = new N8();
        n8.f685a = 3;
        n8.d = new L8();
        Xi fromModel = this.f622a.fromModel(il.f603a);
        n8.d.f648a = (G8) fromModel.f844a;
        Ng ng = il.b;
        if (ng != null) {
            xi = this.b.fromModel(ng);
            n8.d.b = (I8) xi.f844a;
        } else {
            xi = null;
        }
        return Collections.singletonList(new Xi(n8, new C0517q3(C0517q3.b(fromModel, xi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Jl(C0297hg c0297hg, C0737yg c0737yg) {
        this.f622a = c0297hg;
        this.b = c0737yg;
    }

    public final Il a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

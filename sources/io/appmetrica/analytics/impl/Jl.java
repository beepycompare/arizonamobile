package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Jl implements InterfaceC0630u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0302hg f619a;
    public final C0742yg b;

    public Jl() {
        this(new C0302hg(), new C0742yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Il il) {
        Xi xi;
        N8 n8 = new N8();
        n8.f682a = 3;
        n8.d = new L8();
        Xi fromModel = this.f619a.fromModel(il.f600a);
        n8.d.f645a = (G8) fromModel.f841a;
        Ng ng = il.b;
        if (ng != null) {
            xi = this.b.fromModel(ng);
            n8.d.b = (I8) xi.f841a;
        } else {
            xi = null;
        }
        return Collections.singletonList(new Xi(n8, new C0522q3(C0522q3.b(fromModel, xi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Jl(C0302hg c0302hg, C0742yg c0742yg) {
        this.f619a = c0302hg;
        this.b = c0742yg;
    }

    public final Il a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

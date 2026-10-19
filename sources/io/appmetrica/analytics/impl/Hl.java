package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Hl implements InterfaceC0625u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0766zj f586a;
    public final C0297hg b;

    public Hl() {
        this(new C0766zj(), new C0297hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Gl gl) {
        N8 n8 = new N8();
        n8.f685a = 2;
        n8.c = new K8();
        Xi fromModel = this.f586a.fromModel(gl.b);
        n8.c.b = (J8) fromModel.f844a;
        Xi fromModel2 = this.b.fromModel(gl.f570a);
        n8.c.f631a = (G8) fromModel2.f844a;
        return Collections.singletonList(new Xi(n8, new C0517q3(C0517q3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Hl(C0766zj c0766zj, C0297hg c0297hg) {
        this.f586a = c0766zj;
        this.b = c0297hg;
    }

    public final Gl a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

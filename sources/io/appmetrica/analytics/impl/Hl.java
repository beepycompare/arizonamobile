package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Hl implements InterfaceC0631u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0772zj f583a;
    public final C0303hg b;

    public Hl() {
        this(new C0772zj(), new C0303hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Gl gl) {
        N8 n8 = new N8();
        n8.f682a = 2;
        n8.c = new K8();
        Xi fromModel = this.f583a.fromModel(gl.b);
        n8.c.b = (J8) fromModel.f841a;
        Xi fromModel2 = this.b.fromModel(gl.f567a);
        n8.c.f628a = (G8) fromModel2.f841a;
        return Collections.singletonList(new Xi(n8, new C0523q3(C0523q3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Hl(C0772zj c0772zj, C0303hg c0303hg) {
        this.f583a = c0772zj;
        this.b = c0303hg;
    }

    public final Gl a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

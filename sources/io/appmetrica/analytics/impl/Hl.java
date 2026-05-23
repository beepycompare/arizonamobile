package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Hl implements InterfaceC0632u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0773zj f580a;
    public final C0304hg b;

    public Hl() {
        this(new C0773zj(), new C0304hg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Gl gl) {
        N8 n8 = new N8();
        n8.f679a = 2;
        n8.c = new K8();
        Xi fromModel = this.f580a.fromModel(gl.b);
        n8.c.b = (J8) fromModel.f838a;
        Xi fromModel2 = this.b.fromModel(gl.f564a);
        n8.c.f625a = (G8) fromModel2.f838a;
        return Collections.singletonList(new Xi(n8, new C0524q3(C0524q3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Hl(C0773zj c0773zj, C0304hg c0304hg) {
        this.f580a = c0773zj;
        this.b = c0304hg;
    }

    public final Gl a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

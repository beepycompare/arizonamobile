package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0311hl implements InterfaceC0700x8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0537qj f893a;
    public final Wf b;

    public C0311hl() {
        this(new C0537qj(), new Wf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Vi> fromModel(C0285gl c0285gl) {
        Q8 q8 = new Q8();
        q8.f617a = 2;
        q8.c = new N8();
        Vi fromModel = this.f893a.fromModel(c0285gl.b);
        q8.c.b = (M8) fromModel.f697a;
        Vi fromModel2 = this.b.fromModel(c0285gl.f876a);
        q8.c.f576a = (J8) fromModel2.f697a;
        return Collections.singletonList(new Vi(q8, new C0670w3(C0670w3.b(fromModel, fromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0311hl(C0537qj c0537qj, Wf wf) {
        this.f893a = c0537qj;
        this.b = wf;
    }

    public final C0285gl a(List<Vi> list) {
        throw new UnsupportedOperationException();
    }
}

package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.jl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0362jl implements InterfaceC0700x8 {

    /* renamed from: a  reason: collision with root package name */
    public final Wf f927a;
    public final C0733yg b;

    public C0362jl() {
        this(new Wf(), new C0733yg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Vi> fromModel(C0336il c0336il) {
        Vi vi;
        Q8 q8 = new Q8();
        q8.f617a = 3;
        q8.d = new O8();
        Vi fromModel = this.f927a.fromModel(c0336il.f908a);
        q8.d.f588a = (J8) fromModel.f697a;
        Pg pg = c0336il.b;
        if (pg != null) {
            vi = this.b.fromModel(pg);
            q8.d.b = (L8) vi.f697a;
        } else {
            vi = null;
        }
        return Collections.singletonList(new Vi(q8, new C0670w3(C0670w3.b(fromModel, vi))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0362jl(Wf wf, C0733yg c0733yg) {
        this.f927a = wf;
        this.b = c0733yg;
    }

    public final C0336il a(List<Vi> list) {
        throw new UnsupportedOperationException();
    }
}

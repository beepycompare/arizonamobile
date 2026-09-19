package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ll implements InterfaceC0630u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0771zj f652a;

    public Ll() {
        this(new C0771zj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Kl kl) {
        N8 n8 = new N8();
        n8.f682a = 1;
        n8.b = new M8();
        Xi fromModel = this.f652a.fromModel(kl.f634a);
        n8.b.f663a = (J8) fromModel.f841a;
        C0522q3 c0522q3 = new C0522q3(C0522q3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Xi(n8, c0522q3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Ll(C0771zj c0771zj) {
        this.f652a = c0771zj;
    }

    public final Kl a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

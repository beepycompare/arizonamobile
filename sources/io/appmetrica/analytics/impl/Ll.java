package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ll implements InterfaceC0625u8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0766zj f655a;

    public Ll() {
        this(new C0766zj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Kl kl) {
        N8 n8 = new N8();
        n8.f685a = 1;
        n8.b = new M8();
        Xi fromModel = this.f655a.fromModel(kl.f637a);
        n8.b.f666a = (J8) fromModel.f844a;
        C0517q3 c0517q3 = new C0517q3(C0517q3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Xi(n8, c0517q3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Ll(C0766zj c0766zj) {
        this.f655a = c0766zj;
    }

    public final Kl a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}

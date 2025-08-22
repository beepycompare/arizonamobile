package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0414ll implements InterfaceC0700x8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0537qj f956a;

    public C0414ll() {
        this(new C0537qj());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Vi> fromModel(C0388kl c0388kl) {
        Q8 q8 = new Q8();
        q8.f617a = 1;
        q8.b = new P8();
        Vi fromModel = this.f956a.fromModel(c0388kl.f941a);
        q8.b.f602a = (M8) fromModel.f697a;
        C0670w3 c0670w3 = new C0670w3(C0670w3.b(fromModel));
        fromModel.b.getBytesTruncated();
        return Collections.singletonList(new Vi(q8, c0670w3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0414ll(C0537qj c0537qj) {
        this.f956a = c0537qj;
    }

    public final C0388kl a(List<Vi> list) {
        throw new UnsupportedOperationException();
    }
}

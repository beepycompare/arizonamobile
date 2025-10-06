package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class Dn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Kl f417a;

    public Dn() {
        this(new Kl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0753z6 fromModel(Cn cn) {
        C0753z6 c0753z6 = new C0753z6();
        Integer num = cn.e;
        c0753z6.e = num == null ? -1 : num.intValue();
        c0753z6.d = cn.d;
        c0753z6.b = cn.b;
        c0753z6.f1185a = cn.f397a;
        c0753z6.c = cn.c;
        Kl kl = this.f417a;
        List<StackTraceElement> list = cn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Ml(stackTraceElement));
        }
        c0753z6.f = kl.fromModel(arrayList);
        return c0753z6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0753z6 c0753z6 = (C0753z6) obj;
        throw new UnsupportedOperationException();
    }

    public Dn(Kl kl) {
        this.f417a = kl;
    }

    public final Cn a(C0753z6 c0753z6) {
        throw new UnsupportedOperationException();
    }
}

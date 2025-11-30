package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0733yn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f1224a;

    public C0733yn() {
        this(new Cl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0134b6 fromModel(C0708xn c0708xn) {
        C0134b6 c0134b6 = new C0134b6();
        Integer num = c0708xn.e;
        c0134b6.e = num == null ? -1 : num.intValue();
        c0134b6.d = c0708xn.d;
        c0134b6.b = c0708xn.b;
        c0134b6.f812a = c0708xn.f1205a;
        c0134b6.c = c0708xn.c;
        Cl cl = this.f1224a;
        List<StackTraceElement> list = c0708xn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new El(stackTraceElement));
        }
        c0134b6.f = cl.fromModel(arrayList);
        return c0134b6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0134b6 c0134b6 = (C0134b6) obj;
        throw new UnsupportedOperationException();
    }

    public C0733yn(Cl cl) {
        this.f1224a = cl;
    }

    public final C0708xn a(C0134b6 c0134b6) {
        throw new UnsupportedOperationException();
    }
}

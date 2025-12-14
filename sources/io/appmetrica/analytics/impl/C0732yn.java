package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0732yn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f1321a;

    public C0732yn() {
        this(new Cl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0133b6 fromModel(C0707xn c0707xn) {
        C0133b6 c0133b6 = new C0133b6();
        Integer num = c0707xn.e;
        c0133b6.e = num == null ? -1 : num.intValue();
        c0133b6.d = c0707xn.d;
        c0133b6.b = c0707xn.b;
        c0133b6.f909a = c0707xn.f1302a;
        c0133b6.c = c0707xn.c;
        Cl cl = this.f1321a;
        List<StackTraceElement> list = c0707xn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new El(stackTraceElement));
        }
        c0133b6.f = cl.fromModel(arrayList);
        return c0133b6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0133b6 c0133b6 = (C0133b6) obj;
        throw new UnsupportedOperationException();
    }

    public C0732yn(Cl cl) {
        this.f1321a = cl;
    }

    public final C0707xn a(C0133b6 c0133b6) {
        throw new UnsupportedOperationException();
    }
}

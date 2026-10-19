package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0124ao implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0200dm f898a;

    public C0124ao() {
        this(new C0200dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0520q6 fromModel(Zn zn) {
        C0520q6 c0520q6 = new C0520q6();
        Integer num = zn.e;
        c0520q6.e = num == null ? -1 : num.intValue();
        c0520q6.d = zn.d;
        c0520q6.b = zn.b;
        c0520q6.f1166a = zn.f880a;
        c0520q6.c = zn.c;
        C0200dm c0200dm = this.f898a;
        List<StackTraceElement> list = zn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new C0251fm(stackTraceElement));
        }
        c0520q6.f = c0200dm.fromModel(arrayList);
        return c0520q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0520q6 c0520q6 = (C0520q6) obj;
        throw new UnsupportedOperationException();
    }

    public C0124ao(C0200dm c0200dm) {
        this.f898a = c0200dm;
    }

    public final Zn a(C0520q6 c0520q6) {
        throw new UnsupportedOperationException();
    }
}

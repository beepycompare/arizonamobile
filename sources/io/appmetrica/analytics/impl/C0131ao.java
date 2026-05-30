package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0131ao implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0207dm f893a;

    public C0131ao() {
        this(new C0207dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0527q6 fromModel(Zn zn) {
        C0527q6 c0527q6 = new C0527q6();
        Integer num = zn.e;
        c0527q6.e = num == null ? -1 : num.intValue();
        c0527q6.d = zn.d;
        c0527q6.b = zn.b;
        c0527q6.f1161a = zn.f875a;
        c0527q6.c = zn.c;
        C0207dm c0207dm = this.f893a;
        List<StackTraceElement> list = zn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new C0258fm(stackTraceElement));
        }
        c0527q6.f = c0207dm.fromModel(arrayList);
        return c0527q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0527q6 c0527q6 = (C0527q6) obj;
        throw new UnsupportedOperationException();
    }

    public C0131ao(C0207dm c0207dm) {
        this.f893a = c0207dm;
    }

    public final Zn a(C0527q6 c0527q6) {
        throw new UnsupportedOperationException();
    }
}

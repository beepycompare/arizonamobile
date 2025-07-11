package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0565rn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0738yl f1033a;

    public C0565rn() {
        this(new C0738yl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0598t6 fromModel(C0541qn c0541qn) {
        C0598t6 c0598t6 = new C0598t6();
        Integer num = c0541qn.e;
        c0598t6.e = num == null ? -1 : num.intValue();
        c0598t6.d = c0541qn.d;
        c0598t6.b = c0541qn.b;
        c0598t6.f1054a = c0541qn.f1012a;
        c0598t6.c = c0541qn.c;
        C0738yl c0738yl = this.f1033a;
        List<StackTraceElement> list = c0541qn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Al(stackTraceElement));
        }
        c0598t6.f = c0738yl.fromModel(arrayList);
        return c0598t6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0598t6 c0598t6 = (C0598t6) obj;
        throw new UnsupportedOperationException();
    }

    public C0565rn(C0738yl c0738yl) {
        this.f1033a = c0738yl;
    }

    public final C0541qn a(C0598t6 c0598t6) {
        throw new UnsupportedOperationException();
    }
}

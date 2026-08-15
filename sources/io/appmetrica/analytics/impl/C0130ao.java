package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0130ao implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0206dm f895a;

    public C0130ao() {
        this(new C0206dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0526q6 fromModel(Zn zn) {
        C0526q6 c0526q6 = new C0526q6();
        Integer num = zn.e;
        c0526q6.e = num == null ? -1 : num.intValue();
        c0526q6.d = zn.d;
        c0526q6.b = zn.b;
        c0526q6.f1163a = zn.f877a;
        c0526q6.c = zn.c;
        C0206dm c0206dm = this.f895a;
        List<StackTraceElement> list = zn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new C0257fm(stackTraceElement));
        }
        c0526q6.f = c0206dm.fromModel(arrayList);
        return c0526q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0526q6 c0526q6 = (C0526q6) obj;
        throw new UnsupportedOperationException();
    }

    public C0130ao(C0206dm c0206dm) {
        this.f895a = c0206dm;
    }

    public final Zn a(C0526q6 c0526q6) {
        throw new UnsupportedOperationException();
    }
}

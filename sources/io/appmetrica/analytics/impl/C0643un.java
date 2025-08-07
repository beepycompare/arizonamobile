package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0643un implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f1090a;

    public C0643un() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0676w6 fromModel(C0618tn c0618tn) {
        C0676w6 c0676w6 = new C0676w6();
        Integer num = c0618tn.e;
        c0676w6.e = num == null ? -1 : num.intValue();
        c0676w6.d = c0618tn.d;
        c0676w6.b = c0618tn.b;
        c0676w6.f1114a = c0618tn.f1072a;
        c0676w6.c = c0618tn.c;
        Bl bl = this.f1090a;
        List<StackTraceElement> list = c0618tn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Dl(stackTraceElement));
        }
        c0676w6.f = bl.fromModel(arrayList);
        return c0676w6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0676w6 c0676w6 = (C0676w6) obj;
        throw new UnsupportedOperationException();
    }

    public C0643un(Bl bl) {
        this.f1090a = bl;
    }

    public final C0618tn a(C0676w6 c0676w6) {
        throw new UnsupportedOperationException();
    }
}

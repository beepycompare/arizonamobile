package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0642un implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f1090a;

    public C0642un() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0675w6 fromModel(C0617tn c0617tn) {
        C0675w6 c0675w6 = new C0675w6();
        Integer num = c0617tn.e;
        c0675w6.e = num == null ? -1 : num.intValue();
        c0675w6.d = c0617tn.d;
        c0675w6.b = c0617tn.b;
        c0675w6.f1114a = c0617tn.f1072a;
        c0675w6.c = c0617tn.c;
        Bl bl = this.f1090a;
        List<StackTraceElement> list = c0617tn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Dl(stackTraceElement));
        }
        c0675w6.f = bl.fromModel(arrayList);
        return c0675w6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0675w6 c0675w6 = (C0675w6) obj;
        throw new UnsupportedOperationException();
    }

    public C0642un(Bl bl) {
        this.f1090a = bl;
    }

    public final C0617tn a(C0675w6 c0675w6) {
        throw new UnsupportedOperationException();
    }
}

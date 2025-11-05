package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.zn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0758zn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Fl f1237a;

    public C0758zn() {
        this(new Fl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0289h6 fromModel(C0733yn c0733yn) {
        C0289h6 c0289h6 = new C0289h6();
        Integer num = c0733yn.e;
        c0289h6.e = num == null ? -1 : num.intValue();
        c0289h6.d = c0733yn.d;
        c0289h6.b = c0733yn.b;
        c0289h6.f906a = c0733yn.f1219a;
        c0289h6.c = c0733yn.c;
        Fl fl = this.f1237a;
        List<StackTraceElement> list = c0733yn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Hl(stackTraceElement));
        }
        c0289h6.f = fl.fromModel(arrayList);
        return c0289h6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0289h6 c0289h6 = (C0289h6) obj;
        throw new UnsupportedOperationException();
    }

    public C0758zn(Fl fl) {
        this.f1237a = fl;
    }

    public final C0733yn a(C0289h6 c0289h6) {
        throw new UnsupportedOperationException();
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0573rn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0746yl f1032a;

    public C0573rn() {
        this(new C0746yl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0606t6 fromModel(C0549qn c0549qn) {
        C0606t6 c0606t6 = new C0606t6();
        Integer num = c0549qn.e;
        c0606t6.e = num == null ? -1 : num.intValue();
        c0606t6.d = c0549qn.d;
        c0606t6.b = c0549qn.b;
        c0606t6.f1053a = c0549qn.f1011a;
        c0606t6.c = c0549qn.c;
        C0746yl c0746yl = this.f1032a;
        List<StackTraceElement> list = c0549qn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Al(stackTraceElement));
        }
        c0606t6.f = c0746yl.fromModel(arrayList);
        return c0606t6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0606t6 c0606t6 = (C0606t6) obj;
        throw new UnsupportedOperationException();
    }

    public C0573rn(C0746yl c0746yl) {
        this.f1032a = c0746yl;
    }

    public final C0549qn a(C0606t6 c0606t6) {
        throw new UnsupportedOperationException();
    }
}

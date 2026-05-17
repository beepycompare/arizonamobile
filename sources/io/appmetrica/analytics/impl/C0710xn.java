package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.xn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0710xn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f1316a;

    public C0710xn() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0111a6 fromModel(C0685wn c0685wn) {
        C0111a6 c0111a6 = new C0111a6();
        Integer num = c0685wn.e;
        c0111a6.e = num == null ? -1 : num.intValue();
        c0111a6.d = c0685wn.d;
        c0111a6.b = c0685wn.b;
        c0111a6.f904a = c0685wn.f1297a;
        c0111a6.c = c0685wn.c;
        Bl bl = this.f1316a;
        List<StackTraceElement> list = c0685wn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Dl(stackTraceElement));
        }
        c0111a6.f = bl.fromModel(arrayList);
        return c0111a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0111a6 c0111a6 = (C0111a6) obj;
        throw new UnsupportedOperationException();
    }

    public C0710xn(Bl bl) {
        this.f1316a = bl;
    }

    public final C0685wn a(C0111a6 c0111a6) {
        throw new UnsupportedOperationException();
    }
}

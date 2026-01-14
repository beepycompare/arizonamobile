package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.xn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0711xn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f1312a;

    public C0711xn() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0112a6 fromModel(C0686wn c0686wn) {
        C0112a6 c0112a6 = new C0112a6();
        Integer num = c0686wn.e;
        c0112a6.e = num == null ? -1 : num.intValue();
        c0112a6.d = c0686wn.d;
        c0112a6.b = c0686wn.b;
        c0112a6.f900a = c0686wn.f1293a;
        c0112a6.c = c0686wn.c;
        Bl bl = this.f1312a;
        List<StackTraceElement> list = c0686wn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Dl(stackTraceElement));
        }
        c0112a6.f = bl.fromModel(arrayList);
        return c0112a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0112a6 c0112a6 = (C0112a6) obj;
        throw new UnsupportedOperationException();
    }

    public C0711xn(Bl bl) {
        this.f1312a = bl;
    }

    public final C0686wn a(C0112a6 c0112a6) {
        throw new UnsupportedOperationException();
    }
}

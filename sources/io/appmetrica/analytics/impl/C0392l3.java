package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0392l3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0548ra f1090a;

    public C0392l3() {
        this(new C0548ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(List<String> list) {
        Mn a2 = this.f1090a.a((List<Object>) list);
        C0243f8 c0243f8 = new C0243f8();
        c0243f8.f991a = StringUtils.getUTF8Bytes((List) a2.f700a);
        InterfaceC0135b3 interfaceC0135b3 = a2.b;
        int i = ((C0443n4) interfaceC0135b3).f897a;
        return new Di(c0243f8, interfaceC0135b3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0392l3(C0548ra c0548ra) {
        this.f1090a = c0548ra;
    }

    public final List<String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}

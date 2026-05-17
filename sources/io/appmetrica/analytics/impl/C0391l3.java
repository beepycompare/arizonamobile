package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0391l3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0547ra f1094a;

    public C0391l3() {
        this(new C0547ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(List<String> list) {
        Mn a2 = this.f1094a.a((List<Object>) list);
        C0242f8 c0242f8 = new C0242f8();
        c0242f8.f995a = StringUtils.getUTF8Bytes((List) a2.f704a);
        InterfaceC0134b3 interfaceC0134b3 = a2.b;
        int i = ((C0442n4) interfaceC0134b3).f901a;
        return new Di(c0242f8, interfaceC0134b3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0391l3(C0547ra c0547ra) {
        this.f1094a = c0547ra;
    }

    public final List<String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}

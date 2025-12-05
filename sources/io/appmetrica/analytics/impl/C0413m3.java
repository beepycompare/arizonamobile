package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0413m3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0569sa f1085a;

    public C0413m3() {
        this(new C0569sa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(List<String> list) {
        Nn a2 = this.f1085a.a((List<Object>) list);
        C0264g8 c0264g8 = new C0264g8();
        c0264g8.f985a = StringUtils.getUTF8Bytes((List) a2.f694a);
        InterfaceC0156c3 interfaceC0156c3 = a2.b;
        int i = ((C0464o4) interfaceC0156c3).f892a;
        return new Ei(c0264g8, interfaceC0156c3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0413m3(C0569sa c0569sa) {
        this.f1085a = c0569sa;
    }

    public final List<String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}

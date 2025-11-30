package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0414m3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0570sa f1002a;

    public C0414m3() {
        this(new C0570sa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(List<String> list) {
        Nn a2 = this.f1002a.a((List<Object>) list);
        C0265g8 c0265g8 = new C0265g8();
        c0265g8.f902a = StringUtils.getUTF8Bytes((List) a2.f611a);
        InterfaceC0157c3 interfaceC0157c3 = a2.b;
        int i = ((C0465o4) interfaceC0157c3).f809a;
        return new Ei(c0265g8, interfaceC0157c3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0414m3(C0570sa c0570sa) {
        this.f1002a = c0570sa;
    }

    public final List<String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}

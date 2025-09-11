package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class K3 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ra f530a;

    public K3() {
        this(new Ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(List<String> list) {
        Sn a2 = this.f530a.a((List<Object>) list);
        E8 e8 = new E8();
        e8.f424a = StringUtils.getUTF8Bytes((List) a2.f675a);
        A3 a3 = a2.b;
        int i = ((L4) a3).f1181a;
        return new Zi(e8, a3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public K3(Ra ra) {
        this.f530a = ra;
    }

    public final List<String> a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}

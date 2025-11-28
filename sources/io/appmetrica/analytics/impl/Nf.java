package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Nf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0720ya f607a;

    public Nf() {
        this(new C0720ya(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(List<String> list) {
        On a2 = this.f607a.a((List<Object>) list);
        List list2 = (List) a2.f625a;
        C0618u8[] c0618u8Arr = new C0618u8[0];
        if (list2 != null) {
            c0618u8Arr = new C0618u8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C0618u8 c0618u8 = new C0618u8();
                c0618u8Arr[i] = c0618u8;
                c0618u8.f1147a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Ii(c0618u8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public Nf(C0720ya c0720ya) {
        this.f607a = c0720ya;
    }

    public final List<String> a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}

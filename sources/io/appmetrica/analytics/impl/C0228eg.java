package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.eg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0228eg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ra f858a;

    public C0228eg() {
        this(new Ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(List<String> list) {
        Sn a2 = this.f858a.a((List<Object>) list);
        List list2 = (List) a2.f671a;
        N8[] n8Arr = new N8[0];
        if (list2 != null) {
            n8Arr = new N8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                N8 n8 = new N8();
                n8Arr[i] = n8;
                n8.f587a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Zi(n8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public C0228eg(Ra ra) {
        this.f858a = ra;
    }

    public final List<String> a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0125ag implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f779a;

    public C0125ag() {
        this(new Oa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(List<String> list) {
        On a2 = this.f779a.a((List<Object>) list);
        List list2 = (List) a2.f594a;
        K8[] k8Arr = new K8[0];
        if (list2 != null) {
            k8Arr = new K8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                K8 k8 = new K8();
                k8Arr[i] = k8;
                k8.f527a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Vi(k8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public C0125ag(Oa oa) {
        this.f779a = oa;
    }

    public final List<String> a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}

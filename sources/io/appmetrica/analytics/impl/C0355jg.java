package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0355jg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ua f1049a;

    public C0355jg() {
        this(new Ua(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(List<String> list) {
        C0519po a2 = this.f1049a.a((List<Object>) list);
        List list2 = (List) a2.f1152a;
        H8[] h8Arr = new H8[0];
        if (list2 != null) {
            h8Arr = new H8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                H8 h8 = new H8();
                h8Arr[i] = h8;
                h8.f574a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Xi(h8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public C0355jg(Ua ua) {
        this.f1049a = ua;
    }

    public final List<String> a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}

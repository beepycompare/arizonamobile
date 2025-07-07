package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ee implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f408a;

    public Ee() {
        this(new Oa((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Map<String, String> map) {
        Gn a2 = this.f408a.a(map);
        C8 c8 = new C8();
        c8.b = ((I4) a2.b).b;
        Map map2 = (Map) a2.f449a;
        if (map2 != null) {
            c8.f369a = new B8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c8.f369a[i] = new B8();
                c8.f369a[i].f350a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c8.f369a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0703x3 interfaceC0703x3 = a2.b;
        int i2 = ((I4) interfaceC0703x3).f1097a;
        return new Ni(c8, interfaceC0703x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public Ee(Oa oa) {
        this.f408a = oa;
    }

    public final Map<String, String> a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}

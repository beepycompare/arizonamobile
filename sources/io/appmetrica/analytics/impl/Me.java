package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Me implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Va f578a;

    public Me() {
        this(new Va((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(Map<String, String> map) {
        Sn a2 = this.f578a.a(map);
        K8 k8 = new K8();
        k8.b = ((L4) a2.b).b;
        Map map2 = (Map) a2.f676a;
        if (map2 != null) {
            k8.f536a = new J8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                k8.f536a[i] = new J8();
                k8.f536a[i].f514a = StringUtils.getUTF8Bytes((String) entry.getKey());
                k8.f536a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        A3 a3 = a2.b;
        int i2 = ((L4) a3).f1182a;
        return new Zi(k8, a3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public Me(Va va) {
        this.f578a = va;
    }

    public final Map<String, String> a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}

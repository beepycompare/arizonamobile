package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Te implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ya f777a;

    public Te() {
        this(new Ya((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Xi fromModel(Map<String, String> map) {
        C0519po a2 = this.f777a.a(map);
        E8 e8 = new E8();
        e8.b = ((E4) a2.b).b;
        Map map2 = (Map) a2.f1153a;
        if (map2 != null) {
            e8.f524a = new D8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                e8.f524a[i] = new D8();
                e8.f524a[i].f509a = StringUtils.getUTF8Bytes((String) entry.getKey());
                e8.f524a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0549r3 interfaceC0549r3 = a2.b;
        int i2 = ((E4) interfaceC0549r3).f1158a;
        return new Xi(e8, interfaceC0549r3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Xi xi = (Xi) obj;
        throw new UnsupportedOperationException();
    }

    public Te(Ya ya) {
        this.f777a = ya;
    }

    public final Map<String, String> a(Xi xi) {
        throw new UnsupportedOperationException();
    }
}

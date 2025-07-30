package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ge implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Qa f455a;

    public Ge() {
        this(new Qa((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Map<String, String> map) {
        Jn a2 = this.f455a.a(map);
        F8 f8 = new F8();
        f8.b = ((I4) a2.b).b;
        Map map2 = (Map) a2.f512a;
        if (map2 != null) {
            f8.f434a = new E8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                f8.f434a[i] = new E8();
                f8.f434a[i].f414a = StringUtils.getUTF8Bytes((String) entry.getKey());
                f8.f434a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0697x3 interfaceC0697x3 = a2.b;
        int i2 = ((I4) interfaceC0697x3).f1112a;
        return new Qi(f8, interfaceC0697x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public Ge(Qa qa) {
        this.f455a = qa;
    }

    public final Map<String, String> a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}

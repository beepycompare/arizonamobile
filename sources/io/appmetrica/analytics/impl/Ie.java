package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ie implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f497a;

    public Ie() {
        this(new Sa((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(Map<String, String> map) {
        On a2 = this.f497a.a(map);
        H8 h8 = new H8();
        h8.b = ((I4) a2.b).b;
        Map map2 = (Map) a2.f594a;
        if (map2 != null) {
            h8.f473a = new G8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                h8.f473a[i] = new G8();
                h8.f473a[i].f452a = StringUtils.getUTF8Bytes((String) entry.getKey());
                h8.f473a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0695x3 interfaceC0695x3 = a2.b;
        int i2 = ((I4) interfaceC0695x3).f1113a;
        return new Vi(h8, interfaceC0695x3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public Ie(Sa sa) {
        this.f497a = sa;
    }

    public final Map<String, String> a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}

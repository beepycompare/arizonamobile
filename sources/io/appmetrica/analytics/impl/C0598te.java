package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.te  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0598te implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0669wa f1231a;

    public C0598te() {
        this(new C0669wa((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Map<String, String> map) {
        Nn a2 = this.f1231a.a(map);
        C0418m8 c0418m8 = new C0418m8();
        c0418m8.b = ((C0464o4) a2.b).b;
        Map map2 = (Map) a2.f708a;
        if (map2 != null) {
            c0418m8.f1104a = new C0393l8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c0418m8.f1104a[i] = new C0393l8();
                c0418m8.f1104a[i].f1087a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c0418m8.f1104a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0156c3 interfaceC0156c3 = a2.b;
        int i2 = ((C0464o4) interfaceC0156c3).f906a;
        return new Ei(c0418m8, interfaceC0156c3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0598te(C0669wa c0669wa) {
        this.f1231a = c0669wa;
    }

    public final Map<String, String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}

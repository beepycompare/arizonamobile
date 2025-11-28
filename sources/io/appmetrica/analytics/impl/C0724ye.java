package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ye  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0724ye implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ca f1215a;

    public C0724ye() {
        this(new Ca((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(Map<String, String> map) {
        On a2 = this.f1215a.a(map);
        C0543r8 c0543r8 = new C0543r8();
        c0543r8.b = ((C0614u4) a2.b).b;
        Map map2 = (Map) a2.f625a;
        if (map2 != null) {
            c0543r8.f1090a = new C0519q8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c0543r8.f1090a[i] = new C0519q8();
                c0543r8.f1090a[i].f1069a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c0543r8.f1090a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0337j3 interfaceC0337j3 = a2.b;
        int i2 = ((C0614u4) interfaceC0337j3).f923a;
        return new Ii(c0543r8, interfaceC0337j3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public C0724ye(Ca ca) {
        this.f1215a = ca;
    }

    public final Map<String, String> a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}

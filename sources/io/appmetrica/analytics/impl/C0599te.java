package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.te  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0599te implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0670wa f1134a;

    public C0599te() {
        this(new C0670wa((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Map<String, String> map) {
        Nn a2 = this.f1134a.a(map);
        C0419m8 c0419m8 = new C0419m8();
        c0419m8.b = ((C0465o4) a2.b).b;
        Map map2 = (Map) a2.f611a;
        if (map2 != null) {
            c0419m8.f1007a = new C0394l8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c0419m8.f1007a[i] = new C0394l8();
                c0419m8.f1007a[i].f990a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c0419m8.f1007a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0157c3 interfaceC0157c3 = a2.b;
        int i2 = ((C0465o4) interfaceC0157c3).f809a;
        return new Ei(c0419m8, interfaceC0157c3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public C0599te(C0670wa c0670wa) {
        this.f1134a = c0670wa;
    }

    public final Map<String, String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}

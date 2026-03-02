package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.se  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0576se implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0647va f1222a;

    public C0576se() {
        this(new C0647va((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Map<String, String> map) {
        Mn a2 = this.f1222a.a(map);
        C0396l8 c0396l8 = new C0396l8();
        c0396l8.b = ((C0442n4) a2.b).b;
        Map map2 = (Map) a2.f699a;
        if (map2 != null) {
            c0396l8.f1094a = new C0371k8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c0396l8.f1094a[i] = new C0371k8();
                c0396l8.f1094a[i].f1078a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c0396l8.f1094a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0134b3 interfaceC0134b3 = a2.b;
        int i2 = ((C0442n4) interfaceC0134b3).f896a;
        return new Di(c0396l8, interfaceC0134b3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0576se(C0647va c0647va) {
        this.f1222a = c0647va;
    }

    public final Map<String, String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}

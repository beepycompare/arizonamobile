package io.appmetrica.analytics.impl;

import androidx.media3.datasource.cache.CacheDataSink;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.se  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0577se implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0648va f1223a;

    public C0577se() {
        this(new C0648va((int) CacheDataSink.DEFAULT_BUFFER_SIZE, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Map<String, String> map) {
        Mn a2 = this.f1223a.a(map);
        C0397l8 c0397l8 = new C0397l8();
        c0397l8.b = ((C0443n4) a2.b).b;
        Map map2 = (Map) a2.f700a;
        if (map2 != null) {
            c0397l8.f1095a = new C0372k8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c0397l8.f1095a[i] = new C0372k8();
                c0397l8.f1095a[i].f1079a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c0397l8.f1095a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC0135b3 interfaceC0135b3 = a2.b;
        int i2 = ((C0443n4) interfaceC0135b3).f897a;
        return new Di(c0397l8, interfaceC0135b3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0577se(C0648va c0648va) {
        this.f1223a = c0648va;
    }

    public final Map<String, String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}

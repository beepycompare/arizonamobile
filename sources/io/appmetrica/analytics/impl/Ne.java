package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* loaded from: classes3.dex */
public final class Ne implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0108a6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0108a6[] c0108a6Arr = new C0108a6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0108a6Arr[i2] = new C0108a6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0108a6 c0108a6 = c0108a6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0108a6.f798a = entry.getKey().getBytes(charset);
            c0108a6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0108a6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0108a6[] c0108a6Arr = (C0108a6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0108a6[] c0108a6Arr) {
        throw new UnsupportedOperationException();
    }
}

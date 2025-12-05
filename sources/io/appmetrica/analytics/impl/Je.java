package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Je implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final U5[] fromModel(Map<String, String> map) {
        int size = map.size();
        U5[] u5Arr = new U5[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            u5Arr[i2] = new U5();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            U5 u5 = u5Arr[i];
            Charset charset = Charsets.UTF_8;
            u5.f789a = entry.getKey().getBytes(charset);
            u5Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return u5Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        U5[] u5Arr = (U5[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(U5[] u5Arr) {
        throw new UnsupportedOperationException();
    }
}

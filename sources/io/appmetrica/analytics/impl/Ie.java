package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Ie implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T5[] fromModel(Map<String, String> map) {
        int size = map.size();
        T5[] t5Arr = new T5[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            t5Arr[i2] = new T5();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            T5 t5 = t5Arr[i];
            Charset charset = Charsets.UTF_8;
            t5.f795a = entry.getKey().getBytes(charset);
            t5Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return t5Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        T5[] t5Arr = (T5[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(T5[] t5Arr) {
        throw new UnsupportedOperationException();
    }
}

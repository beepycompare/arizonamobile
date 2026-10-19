package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.jf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0347jf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0338j6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0338j6[] c0338j6Arr = new C0338j6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0338j6Arr[i2] = new C0338j6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0338j6 c0338j6 = c0338j6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0338j6.f1052a = entry.getKey().getBytes(charset);
            c0338j6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0338j6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0338j6[] c0338j6Arr = (C0338j6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0338j6[] c0338j6Arr) {
        throw new UnsupportedOperationException();
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Ye implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0499p6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0499p6[] c0499p6Arr = new C0499p6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0499p6Arr[i2] = new C0499p6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0499p6 c0499p6 = c0499p6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0499p6.f1008a = entry.getKey().getBytes(charset);
            c0499p6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0499p6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0499p6[] c0499p6Arr = (C0499p6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0499p6[] c0499p6Arr) {
        throw new UnsupportedOperationException();
    }
}

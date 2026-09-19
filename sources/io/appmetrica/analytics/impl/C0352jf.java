package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.jf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0352jf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0343j6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0343j6[] c0343j6Arr = new C0343j6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0343j6Arr[i2] = new C0343j6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0343j6 c0343j6 = c0343j6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0343j6.f1049a = entry.getKey().getBytes(charset);
            c0343j6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0343j6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0343j6[] c0343j6Arr = (C0343j6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0343j6[] c0343j6Arr) {
        throw new UnsupportedOperationException();
    }
}

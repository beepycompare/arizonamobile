package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Ue implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0424m6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0424m6[] c0424m6Arr = new C0424m6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0424m6Arr[i2] = new C0424m6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0424m6 c0424m6 = c0424m6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0424m6.f935a = entry.getKey().getBytes(charset);
            c0424m6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0424m6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0424m6[] c0424m6Arr = (C0424m6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0424m6[] c0424m6Arr) {
        throw new UnsupportedOperationException();
    }
}

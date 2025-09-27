package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0176cf implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0577s6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0577s6[] c0577s6Arr = new C0577s6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0577s6Arr[i2] = new C0577s6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0577s6 c0577s6 = c0577s6Arr[i];
            Charset charset = Charsets.UTF_8;
            c0577s6.f1079a = entry.getKey().getBytes(charset);
            c0577s6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c0577s6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0577s6[] c0577s6Arr = (C0577s6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C0577s6[] c0577s6Arr) {
        throw new UnsupportedOperationException();
    }
}

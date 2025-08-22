package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Fa implements InterfaceC0377ka {

    /* renamed from: a  reason: collision with root package name */
    public final C0221e9 f432a = new C0221e9();

    public final C0751z9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f432a.toModel(bArr);
            C0751z9[] c0751z9Arr = new C0751z9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0751z9 c0751z9 = new C0751z9();
                c0751z9.f1176a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0751z9.b = (byte[]) entry.getValue();
                c0751z9Arr[i] = c0751z9;
                i = i2;
            }
            return c0751z9Arr;
        }
        return new C0751z9[0];
    }
}

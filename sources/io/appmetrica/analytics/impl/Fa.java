package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Fa implements InterfaceC0317ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0187d9 f548a = new C0187d9();

    public final C0678w9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f548a.toModel(bArr);
            C0678w9[] c0678w9Arr = new C0678w9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0678w9 c0678w9 = new C0678w9();
                c0678w9.f1267a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0678w9.b = (byte[]) entry.getValue();
                c0678w9Arr[i] = c0678w9;
                i = i2;
            }
            return c0678w9Arr;
        }
        return new C0678w9[0];
    }
}

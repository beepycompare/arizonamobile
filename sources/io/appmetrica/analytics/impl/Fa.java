package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Fa implements InterfaceC0322ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0192d9 f545a = new C0192d9();

    public final C0683w9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f545a.toModel(bArr);
            C0683w9[] c0683w9Arr = new C0683w9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0683w9 c0683w9 = new C0683w9();
                c0683w9.f1264a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0683w9.b = (byte[]) entry.getValue();
                c0683w9Arr[i] = c0683w9;
                i = i2;
            }
            return c0683w9Arr;
        }
        return new C0683w9[0];
    }
}

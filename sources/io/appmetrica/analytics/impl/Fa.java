package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Fa implements InterfaceC0323ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0193d9 f545a = new C0193d9();

    public final C0684w9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f545a.toModel(bArr);
            C0684w9[] c0684w9Arr = new C0684w9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0684w9 c0684w9 = new C0684w9();
                c0684w9.f1264a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0684w9.b = (byte[]) entry.getValue();
                c0684w9Arr[i] = c0684w9;
                i = i2;
            }
            return c0684w9Arr;
        }
        return new C0684w9[0];
    }
}

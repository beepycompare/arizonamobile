package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Fa implements InterfaceC0324ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0194d9 f543a = new C0194d9();

    public final C0685w9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f543a.toModel(bArr);
            C0685w9[] c0685w9Arr = new C0685w9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0685w9 c0685w9 = new C0685w9();
                c0685w9.f1262a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0685w9.b = (byte[]) entry.getValue();
                c0685w9Arr[i] = c0685w9;
                i = i2;
            }
            return c0685w9Arr;
        }
        return new C0685w9[0];
    }
}

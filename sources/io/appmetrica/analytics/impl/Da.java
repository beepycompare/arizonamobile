package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Da implements InterfaceC0332ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0178c9 f394a = new C0178c9();

    public final C0704x9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f394a.toModel(bArr);
            C0704x9[] c0704x9Arr = new C0704x9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0704x9 c0704x9 = new C0704x9();
                c0704x9.f1134a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0704x9.b = (byte[]) entry.getValue();
                c0704x9Arr[i] = c0704x9;
                i = i2;
            }
            return c0704x9Arr;
        }
        return new C0704x9[0];
    }
}

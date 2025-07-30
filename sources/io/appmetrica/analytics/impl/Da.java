package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Da implements InterfaceC0331ia {

    /* renamed from: a  reason: collision with root package name */
    public final C0177c9 f395a = new C0177c9();

    public final C0703x9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f395a.toModel(bArr);
            C0703x9[] c0703x9Arr = new C0703x9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0703x9 c0703x9 = new C0703x9();
                c0703x9.f1135a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0703x9.b = (byte[]) entry.getValue();
                c0703x9Arr[i] = c0703x9;
                i = i2;
            }
            return c0703x9Arr;
        }
        return new C0703x9[0];
    }
}

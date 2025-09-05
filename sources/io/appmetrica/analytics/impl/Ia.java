package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Ia implements InterfaceC0455na {

    /* renamed from: a  reason: collision with root package name */
    public final C0299h9 f490a = new C0299h9();

    public final C9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f490a.toModel(bArr);
            C9[] c9Arr = new C9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C9 c9 = new C9();
                c9.f382a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c9.b = (byte[]) entry.getValue();
                c9Arr[i] = c9;
                i = i2;
            }
            return c9Arr;
        }
        return new C9[0];
    }
}

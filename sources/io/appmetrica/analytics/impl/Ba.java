package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Ba implements InterfaceC0287ga {

    /* renamed from: a  reason: collision with root package name */
    public final Z8 f352a = new Z8();

    public final C0634u9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f352a.toModel(bArr);
            C0634u9[] c0634u9Arr = new C0634u9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0634u9 c0634u9 = new C0634u9();
                c0634u9.f1071a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0634u9.b = (byte[]) entry.getValue();
                c0634u9Arr[i] = c0634u9;
                i = i2;
            }
            return c0634u9Arr;
        }
        return new C0634u9[0];
    }
}

package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Ba implements InterfaceC0279ga {

    /* renamed from: a  reason: collision with root package name */
    public final Z8 f353a = new Z8();

    public final C0626u9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f353a.toModel(bArr);
            C0626u9[] c0626u9Arr = new C0626u9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0626u9 c0626u9 = new C0626u9();
                c0626u9.f1072a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0626u9.b = (byte[]) entry.getValue();
                c0626u9Arr[i] = c0626u9;
                i = i2;
            }
            return c0626u9Arr;
        }
        return new C0626u9[0];
    }
}

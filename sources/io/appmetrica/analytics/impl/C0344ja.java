package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0344ja implements O9 {

    /* renamed from: a  reason: collision with root package name */
    public final K8 f954a = new K8();

    public final C0189d9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f954a.toModel(bArr);
            C0189d9[] c0189d9Arr = new C0189d9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0189d9 c0189d9 = new C0189d9();
                c0189d9.f846a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0189d9.b = (byte[]) entry.getValue();
                c0189d9Arr[i] = c0189d9;
                i = i2;
            }
            return c0189d9Arr;
        }
        return new C0189d9[0];
    }
}

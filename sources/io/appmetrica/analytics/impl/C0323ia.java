package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ia  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0323ia implements N9 {

    /* renamed from: a  reason: collision with root package name */
    public final J8 f1043a = new J8();

    public final C0167c9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f1043a.toModel(bArr);
            C0167c9[] c0167c9Arr = new C0167c9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0167c9 c0167c9 = new C0167c9();
                c0167c9.f934a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0167c9.b = (byte[]) entry.getValue();
                c0167c9Arr[i] = c0167c9;
                i = i2;
            }
            return c0167c9Arr;
        }
        return new C0167c9[0];
    }
}

package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.ia  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0322ia implements N9 {

    /* renamed from: a  reason: collision with root package name */
    public final J8 f1047a = new J8();

    public final C0166c9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f1047a.toModel(bArr);
            C0166c9[] c0166c9Arr = new C0166c9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0166c9 c0166c9 = new C0166c9();
                c0166c9.f938a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0166c9.b = (byte[]) entry.getValue();
                c0166c9Arr[i] = c0166c9;
                i = i2;
            }
            return c0166c9Arr;
        }
        return new C0166c9[0];
    }
}

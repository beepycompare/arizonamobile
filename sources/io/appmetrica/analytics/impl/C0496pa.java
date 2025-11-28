package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
/* renamed from: io.appmetrica.analytics.impl.pa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0496pa implements U9 {

    /* renamed from: a  reason: collision with root package name */
    public final O8 f1055a = new O8();

    public final C0343j9[] a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            Map<String, byte[]> model = this.f1055a.toModel(bArr);
            C0343j9[] c0343j9Arr = new C0343j9[model.size()];
            for (Object obj : model.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) obj;
                C0343j9 c0343j9 = new C0343j9();
                c0343j9.f949a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
                c0343j9.b = (byte[]) entry.getValue();
                c0343j9Arr[i] = c0343j9;
                i = i2;
            }
            return c0343j9Arr;
        }
        return new C0343j9[0];
    }
}

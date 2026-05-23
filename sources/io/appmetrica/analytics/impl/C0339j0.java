package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.UUID;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0339j0 implements Vo {
    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new To(this, false, "ApiKey is empty. Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
        try {
            UUID.fromString(str);
            return new To(this, true, "");
        } catch (Throwable unused) {
            return new To(this, false, "Invalid ApiKey=" + str + ". Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
    }
}

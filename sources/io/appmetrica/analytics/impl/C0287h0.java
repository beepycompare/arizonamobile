package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.UUID;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0287h0 implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new qo(this, false, "ApiKey is empty. Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
        try {
            UUID.fromString(str);
            return new qo(this, true, "");
        } catch (Throwable unused) {
            return new qo(this, false, "Invalid ApiKey=" + str + ". Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
    }
}

package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.UUID;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0264g0 implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new wo(this, false, "ApiKey is empty. Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
        try {
            UUID.fromString(str);
            return new wo(this, true, "");
        } catch (Throwable unused) {
            return new wo(this, false, "Invalid ApiKey=" + str + ". Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
    }
}

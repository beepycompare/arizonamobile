package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.UUID;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0283h0 implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new so(this, false, "ApiKey is empty. Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
        try {
            UUID.fromString(str);
            return new so(this, true, "");
        } catch (Throwable unused) {
            return new so(this, false, "Invalid ApiKey=" + str + ". Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
    }
}

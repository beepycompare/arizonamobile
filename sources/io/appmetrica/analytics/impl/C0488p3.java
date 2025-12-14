package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.Context;
import io.appmetrica.analytics.internal.PreloadInfoContentProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.p3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0488p3 implements A6 {
    @Override // io.appmetrica.analytics.impl.A6
    public final void a(Context context) {
        CountDownLatch countDownLatch = B5.f503a;
        if (countDownLatch != null) {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PreloadInfoContentProvider.class), 2, 1);
                PreloadInfoContentProvider preloadInfoContentProvider = B5.b;
                if (preloadInfoContentProvider != null) {
                    preloadInfoContentProvider.disable();
                }
            } catch (Throwable unused) {
            }
            B5.f503a = null;
        }
    }
}

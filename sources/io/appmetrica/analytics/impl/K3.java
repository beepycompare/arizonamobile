package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.Context;
import io.appmetrica.analytics.internal.PreloadInfoContentProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class K3 implements R6 {
    @Override // io.appmetrica.analytics.impl.R6
    public final void a(Context context) {
        CountDownLatch countDownLatch = T5.f635a;
        if (countDownLatch != null) {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PreloadInfoContentProvider.class), 2, 1);
                PreloadInfoContentProvider preloadInfoContentProvider = T5.b;
                if (preloadInfoContentProvider != null) {
                    preloadInfoContentProvider.disable();
                }
            } catch (Throwable unused) {
            }
            T5.f635a = null;
        }
    }
}

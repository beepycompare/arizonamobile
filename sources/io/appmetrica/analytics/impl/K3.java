package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.Context;
import io.appmetrica.analytics.internal.PreloadInfoContentProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class K3 implements U6 {
    @Override // io.appmetrica.analytics.impl.U6
    public final void a(Context context) {
        CountDownLatch countDownLatch = W5.f696a;
        if (countDownLatch != null) {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PreloadInfoContentProvider.class), 2, 1);
                PreloadInfoContentProvider preloadInfoContentProvider = W5.b;
                if (preloadInfoContentProvider != null) {
                    preloadInfoContentProvider.disable();
                }
            } catch (Throwable unused) {
            }
            W5.f696a = null;
        }
    }
}

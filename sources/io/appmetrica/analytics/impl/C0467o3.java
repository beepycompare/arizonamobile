package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.Context;
import io.appmetrica.analytics.internal.PreloadInfoContentProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.o3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0467o3 implements InterfaceC0744z6 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0744z6
    public final void a(Context context) {
        CountDownLatch countDownLatch = A5.f494a;
        if (countDownLatch != null) {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PreloadInfoContentProvider.class), 2, 1);
                PreloadInfoContentProvider preloadInfoContentProvider = A5.b;
                if (preloadInfoContentProvider != null) {
                    preloadInfoContentProvider.disable();
                }
            } catch (Throwable unused) {
            }
            A5.f494a = null;
        }
    }
}

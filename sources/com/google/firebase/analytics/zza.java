package com.google.firebase.analytics;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.5.0 */
/* loaded from: classes4.dex */
final class zza extends ThreadPoolExecutor {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zza(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30L, timeUnit, blockingQueue);
        Objects.requireNonNull(firebaseAnalytics);
    }
}

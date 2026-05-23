package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public interface zal {
    ExecutorService zaa(int i, int i2);

    ExecutorService zab(int i, ThreadFactory threadFactory, int i2);

    ExecutorService zac(ThreadFactory threadFactory, int i);
}

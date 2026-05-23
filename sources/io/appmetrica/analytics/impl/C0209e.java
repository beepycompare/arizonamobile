package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: io.appmetrica.analytics.impl.e  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0209e {
    public static final long g = TimeUnit.SECONDS.toMillis(1);
    public static final String h = "WatchDog-" + Zd.f870a.incrementAndGet();

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f951a;
    public final AtomicInteger b;
    public final Handler c;
    public C0184d d;
    public final AtomicBoolean e;
    public final Runnable f;

    public C0209e(C0248fc c0248fc) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f951a = copyOnWriteArrayList;
        this.b = new AtomicInteger();
        this.c = new Handler(Looper.getMainLooper());
        this.e = new AtomicBoolean();
        this.f = new Runnable() { // from class: io.appmetrica.analytics.impl.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0209e.this.a();
            }
        };
        copyOnWriteArrayList.add(c0248fc);
    }

    public final /* synthetic */ void a() {
        this.e.set(true);
    }

    public final synchronized void b() {
        C0184d c0184d = this.d;
        if (c0184d != null) {
            c0184d.f933a.set(false);
            this.d = null;
            PublicLogger.getAnonymousInstance().info("Stop ANR monitoring", new Object[0]);
        }
    }

    public final synchronized void a(int i) {
        AtomicInteger atomicInteger = this.b;
        Integer valueOf = Integer.valueOf(i);
        int i2 = 5;
        if (valueOf != null && valueOf.intValue() >= 5) {
            i2 = valueOf.intValue();
        }
        atomicInteger.set(i2);
        if (this.d == null) {
            C0184d c0184d = new C0184d(this);
            this.d = c0184d;
            try {
                c0184d.setName(h);
            } catch (SecurityException unused) {
            }
            this.d.start();
            PublicLogger.getAnonymousInstance().info("Start ANR monitoring with timeout: %s seconds", Integer.valueOf(i));
        }
    }
}

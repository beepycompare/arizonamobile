package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: io.appmetrica.analytics.impl.e  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0212e {
    public static final long g = TimeUnit.SECONDS.toMillis(1);
    public static final String h = "WatchDog-" + Ud.f700a.incrementAndGet();

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f852a;
    public final AtomicInteger b;
    public final Handler c;
    public C0187d d;
    public final AtomicBoolean e;
    public final Runnable f;

    public C0212e(C0200dc c0200dc) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f852a = copyOnWriteArrayList;
        this.b = new AtomicInteger();
        this.c = new Handler(Looper.getMainLooper());
        this.e = new AtomicBoolean();
        this.f = new Runnable() { // from class: io.appmetrica.analytics.impl.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0212e.this.a();
            }
        };
        copyOnWriteArrayList.add(c0200dc);
    }

    public final /* synthetic */ void a() {
        this.e.set(true);
    }

    public final synchronized void b() {
        C0187d c0187d = this.d;
        if (c0187d != null) {
            c0187d.f832a.set(false);
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
            C0187d c0187d = new C0187d(this);
            this.d = c0187d;
            try {
                c0187d.setName(h);
            } catch (SecurityException unused) {
            }
            this.d.start();
            PublicLogger.getAnonymousInstance().info("Start ANR monitoring with timeout: %s seconds", Integer.valueOf(i));
        }
    }
}

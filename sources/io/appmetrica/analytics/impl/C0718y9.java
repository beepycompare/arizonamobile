package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* renamed from: io.appmetrica.analytics.impl.y9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0718y9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f1298a;
    public final Z9 b;

    public C0718y9(Context context, String str) {
        this(new ReentrantLock(), new Z9(context, str));
    }

    public final void a() {
        this.f1298a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f1298a.unlock();
    }

    public final void c() {
        Z9 z9 = this.b;
        synchronized (z9) {
            z9.b();
            z9.f859a.delete();
        }
        this.f1298a.unlock();
    }

    public C0718y9(ReentrantLock reentrantLock, Z9 z9) {
        this.f1298a = reentrantLock;
        this.b = z9;
    }
}

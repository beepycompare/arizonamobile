package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public final class R9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f747a;
    public final C0627ua b;

    public R9(Context context, String str) {
        this(new ReentrantLock(), new C0627ua(context, str));
    }

    public final void a() {
        this.f747a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f747a.unlock();
    }

    public final void c() {
        C0627ua c0627ua = this.b;
        synchronized (c0627ua) {
            c0627ua.b();
            c0627ua.f1234a.delete();
        }
        this.f747a.unlock();
    }

    public R9(ReentrantLock reentrantLock, C0627ua c0627ua) {
        this.f747a = reentrantLock;
        this.b = c0627ua;
    }
}

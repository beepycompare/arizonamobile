package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public final class E9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f456a;
    public final C0241fa b;

    public E9(Context context, String str) {
        this(new ReentrantLock(), new C0241fa(context, str));
    }

    public final void a() {
        this.f456a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f456a.unlock();
    }

    public final void c() {
        C0241fa c0241fa = this.b;
        synchronized (c0241fa) {
            c0241fa.b();
            c0241fa.f874a.delete();
        }
        this.f456a.unlock();
    }

    public E9(ReentrantLock reentrantLock, C0241fa c0241fa) {
        this.f456a = reentrantLock;
        this.b = c0241fa;
    }
}

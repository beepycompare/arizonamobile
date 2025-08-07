package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class S9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f637a;
    public final C0605ta b;

    public S9(Context context, String str) {
        this(new ReentrantLock(), new C0605ta(context, str));
    }

    public final void a() {
        this.f637a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f637a.unlock();
    }

    public final void c() {
        C0605ta c0605ta = this.b;
        synchronized (c0605ta) {
            c0605ta.b();
            c0605ta.f1063a.delete();
        }
        this.f637a.unlock();
    }

    public S9(ReentrantLock reentrantLock, C0605ta c0605ta) {
        this.f637a = reentrantLock;
        this.b = c0605ta;
    }
}

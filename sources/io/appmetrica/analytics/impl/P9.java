package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class P9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f578a;
    public final C0560ra b;

    public P9(Context context, String str) {
        this(new ReentrantLock(), new C0560ra(context, str));
    }

    public final void a() {
        this.f578a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f578a.unlock();
    }

    public final void c() {
        C0560ra c0560ra = this.b;
        synchronized (c0560ra) {
            c0560ra.b();
            c0560ra.f1023a.delete();
        }
        this.f578a.unlock();
    }

    public P9(ReentrantLock reentrantLock, C0560ra c0560ra) {
        this.f578a = reentrantLock;
        this.b = c0560ra;
    }
}

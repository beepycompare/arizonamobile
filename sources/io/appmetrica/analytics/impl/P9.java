package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class P9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f579a;
    public final C0552ra b;

    public P9(Context context, String str) {
        this(new ReentrantLock(), new C0552ra(context, str));
    }

    public final void a() {
        this.f579a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f579a.unlock();
    }

    public final void c() {
        C0552ra c0552ra = this.b;
        synchronized (c0552ra) {
            c0552ra.b();
            c0552ra.f1024a.delete();
        }
        this.f579a.unlock();
    }

    public P9(ReentrantLock reentrantLock, C0552ra c0552ra) {
        this.f579a = reentrantLock;
        this.b = c0552ra;
    }
}

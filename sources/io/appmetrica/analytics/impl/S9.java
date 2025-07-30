package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class S9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f638a;
    public final C0604ta b;

    public S9(Context context, String str) {
        this(new ReentrantLock(), new C0604ta(context, str));
    }

    public final void a() {
        this.f638a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f638a.unlock();
    }

    public final void c() {
        C0604ta c0604ta = this.b;
        synchronized (c0604ta) {
            c0604ta.b();
            c0604ta.f1064a.delete();
        }
        this.f638a.unlock();
    }

    public S9(ReentrantLock reentrantLock, C0604ta c0604ta) {
        this.f638a = reentrantLock;
        this.b = c0604ta;
    }
}

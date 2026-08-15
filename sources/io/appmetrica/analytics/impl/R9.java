package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public final class R9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f744a;
    public final C0633ua b;

    public R9(Context context, String str) {
        this(new ReentrantLock(), new C0633ua(context, str));
    }

    public final void a() {
        this.f744a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f744a.unlock();
    }

    public final void c() {
        C0633ua c0633ua = this.b;
        synchronized (c0633ua) {
            c0633ua.b();
            c0633ua.f1231a.delete();
        }
        this.f744a.unlock();
    }

    public R9(ReentrantLock reentrantLock, C0633ua c0633ua) {
        this.f744a = reentrantLock;
        this.b = c0633ua;
    }
}

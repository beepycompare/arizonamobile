package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public final class R9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f744a;
    public final C0634ua b;

    public R9(Context context, String str) {
        this(new ReentrantLock(), new C0634ua(context, str));
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
        C0634ua c0634ua = this.b;
        synchronized (c0634ua) {
            c0634ua.b();
            c0634ua.f1231a.delete();
        }
        this.f744a.unlock();
    }

    public R9(ReentrantLock reentrantLock, C0634ua c0634ua) {
        this.f744a = reentrantLock;
        this.b = c0634ua;
    }
}

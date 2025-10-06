package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class X9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f740a;
    public final C0732ya b;

    public X9(Context context, String str) {
        this(new ReentrantLock(), new C0732ya(context, str));
    }

    public final void a() {
        this.f740a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f740a.unlock();
    }

    public final void c() {
        C0732ya c0732ya = this.b;
        synchronized (c0732ya) {
            c0732ya.b();
            c0732ya.f1170a.delete();
        }
        this.f740a.unlock();
    }

    public X9(ReentrantLock reentrantLock, C0732ya c0732ya) {
        this.f740a = reentrantLock;
        this.b = c0732ya;
    }
}

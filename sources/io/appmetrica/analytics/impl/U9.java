package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class U9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f675a;
    public final C0652va b;

    public U9(Context context, String str) {
        this(new ReentrantLock(), new C0652va(context, str));
    }

    public final void a() {
        this.f675a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f675a.unlock();
    }

    public final void c() {
        C0652va c0652va = this.b;
        synchronized (c0652va) {
            c0652va.b();
            c0652va.f1102a.delete();
        }
        this.f675a.unlock();
    }

    public U9(ReentrantLock reentrantLock, C0652va c0652va) {
        this.f675a = reentrantLock;
        this.b = c0652va;
    }
}

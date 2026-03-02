package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
/* renamed from: io.appmetrica.analytics.impl.x9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0696x9 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f1302a;
    public final Y9 b;

    public C0696x9(Context context, String str) {
        this(new ReentrantLock(), new Y9(context, str));
    }

    public final void a() {
        this.f1302a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f1302a.unlock();
    }

    public final void c() {
        Y9 y9 = this.b;
        synchronized (y9) {
            y9.b();
            y9.f864a.delete();
        }
        this.f1302a.unlock();
    }

    public C0696x9(ReentrantLock reentrantLock, Y9 y9) {
        this.f1302a = reentrantLock;
        this.b = y9;
    }
}

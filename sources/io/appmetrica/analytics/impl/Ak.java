package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public final class Ak {

    /* renamed from: a  reason: collision with root package name */
    public final C0766zk f353a;
    public volatile Z9 b;
    public volatile Z9 c;
    public volatile Z9 d;
    public volatile Z9 e;
    public volatile Z9 f;
    public volatile Z9 g;
    public volatile ExecutorC0741yk h;

    public Ak() {
        this(new C0766zk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f353a.getClass();
                    Cb a2 = Z9.a("IAA-SDE");
                    this.g = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f353a.getClass();
                    Cb a2 = Z9.a("IAA-SC");
                    this.b = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f353a.getClass();
                    Cb a2 = Z9.a("IAA-SMH-1");
                    this.d = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f353a.getClass();
                    Cb a2 = Z9.a("IAA-SNTPE");
                    this.e = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f353a.getClass();
                    Cb a2 = Z9.a("IAA-STE");
                    this.c = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.f353a.getClass();
                    this.h = new ExecutorC0741yk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return this.h;
    }

    public Ak(C0766zk c0766zk) {
        new HashMap();
        this.f353a = c0766zk;
    }
}

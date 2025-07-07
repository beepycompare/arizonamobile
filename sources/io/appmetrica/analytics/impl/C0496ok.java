package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0496ok {

    /* renamed from: a  reason: collision with root package name */
    public final C0471nk f977a;
    public volatile S9 b;
    public volatile S9 c;
    public volatile S9 d;
    public volatile S9 e;
    public volatile S9 f;
    public volatile S9 g;
    public volatile ExecutorC0446mk h;

    public C0496ok() {
        this(new C0471nk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-SDE");
                    this.g = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-SC");
                    this.b = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-SMH-1");
                    this.d = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-SNTPE");
                    this.e = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-STE");
                    this.c = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.f977a.getClass();
                    this.h = new ExecutorC0446mk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return this.h;
    }

    public C0496ok(C0471nk c0471nk) {
        new HashMap();
        this.f977a = c0471nk;
    }
}

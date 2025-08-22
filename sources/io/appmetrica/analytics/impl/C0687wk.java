package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0687wk {

    /* renamed from: a  reason: collision with root package name */
    public final C0662vk f1126a;
    public volatile W9 b;
    public volatile W9 c;
    public volatile W9 d;
    public volatile W9 e;
    public volatile W9 f;
    public volatile W9 g;
    public volatile ExecutorC0637uk h;

    public C0687wk() {
        this(new C0662vk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-SDE");
                    this.g = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-SC");
                    this.b = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-SMH-1");
                    this.d = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-SNTPE");
                    this.e = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-STE");
                    this.c = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.f1126a.getClass();
                    this.h = new ExecutorC0637uk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return this.h;
    }

    public C0687wk(C0662vk c0662vk) {
        new HashMap();
        this.f1126a = c0662vk;
    }
}

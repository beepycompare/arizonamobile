package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.rk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0565rk {

    /* renamed from: a  reason: collision with root package name */
    public final C0541qk f1040a;
    public volatile U9 b;
    public volatile U9 c;
    public volatile U9 d;
    public volatile U9 e;
    public volatile U9 f;
    public volatile U9 g;
    public volatile ExecutorC0516pk h;

    public C0565rk() {
        this(new C0541qk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f1040a.getClass();
                    HandlerThreadC0706xb a2 = U9.a("IAA-SDE");
                    this.g = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f1040a.getClass();
                    HandlerThreadC0706xb a2 = U9.a("IAA-SC");
                    this.b = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1040a.getClass();
                    HandlerThreadC0706xb a2 = U9.a("IAA-SMH-1");
                    this.d = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f1040a.getClass();
                    HandlerThreadC0706xb a2 = U9.a("IAA-SNTPE");
                    this.e = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1040a.getClass();
                    HandlerThreadC0706xb a2 = U9.a("IAA-STE");
                    this.c = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.f1040a.getClass();
                    this.h = new ExecutorC0516pk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return this.h;
    }

    public C0565rk(C0541qk c0541qk) {
        new HashMap();
        this.f1040a = c0541qk;
    }
}

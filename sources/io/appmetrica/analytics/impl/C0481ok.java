package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0481ok {

    /* renamed from: a  reason: collision with root package name */
    public final C0456nk f1044a;
    public volatile G9 b;
    public volatile G9 c;
    public volatile G9 d;
    public volatile G9 e;
    public volatile G9 f;
    public volatile G9 g;
    public volatile ExecutorC0431mk h;

    public C0481ok() {
        this(new C0456nk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-SDE");
                    this.g = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-SC");
                    this.b = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-SMH-1");
                    this.d = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-SNTPE");
                    this.e = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-STE");
                    this.c = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0481ok(C0456nk c0456nk) {
        new HashMap();
        this.f1044a = c0456nk;
    }
}

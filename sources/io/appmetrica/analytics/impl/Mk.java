package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Mk {

    /* renamed from: a  reason: collision with root package name */
    public final Lk f670a;
    public volatile U9 b;
    public volatile U9 c;
    public volatile U9 d;
    public volatile U9 e;
    public volatile U9 f;
    public volatile U9 g;
    public volatile Kk h;
    public volatile U9 i;

    public Mk() {
        this(new Lk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SDE");
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
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SC");
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
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SMH-1");
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
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SNTPE");
                    this.e = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.i == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SPT");
                    this.i = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.i;
    }

    public final IHandlerExecutor f() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-STE");
                    this.c = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public final IHandlerExecutor g() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f670a.getClass();
                    Eb a2 = U9.a("IAA-SIO");
                    this.f = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.f;
    }

    public Mk(Lk lk) {
        new HashMap();
        this.f670a = lk;
    }
}

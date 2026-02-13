package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0384kk {

    /* renamed from: a  reason: collision with root package name */
    public final C0358jk f1084a;
    public volatile C0747z9 b;
    public volatile C0747z9 c;
    public volatile C0747z9 d;
    public volatile C0747z9 e;
    public volatile C0747z9 f;
    public volatile C0747z9 g;
    public volatile ExecutorC0332ik h;

    public C0384kk() {
        this(new C0358jk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f1084a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-SDE");
                    this.g = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1084a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-SMH-1");
                    this.d = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor c() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f1084a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-SNTPE");
                    this.e = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor d() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1084a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-STE");
                    this.c = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0384kk(C0358jk c0358jk) {
        new HashMap();
        this.f1084a = c0358jk;
    }
}

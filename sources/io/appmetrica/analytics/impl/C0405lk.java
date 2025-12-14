package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.lk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0405lk {

    /* renamed from: a  reason: collision with root package name */
    public final C0379kk f1093a;
    public volatile A9 b;
    public volatile A9 c;
    public volatile A9 d;
    public volatile A9 e;
    public volatile A9 f;
    public volatile A9 g;
    public volatile ExecutorC0353jk h;

    public C0405lk() {
        this(new C0379kk());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.f1093a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-SDE");
                    this.g = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1093a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-SMH-1");
                    this.d = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor c() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.f1093a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-SNTPE");
                    this.e = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor d() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1093a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-STE");
                    this.c = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0405lk(C0379kk c0379kk) {
        new HashMap();
        this.f1093a = c0379kk;
    }
}

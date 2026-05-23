package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.i4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0318i4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0292h4 f1027a;
    public volatile U9 b;
    public volatile U9 c;
    public volatile U9 d;

    public C0318i4() {
        this(new C0292h4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f1027a.getClass();
                    Eb a2 = U9.a("IAA-CDE");
                    this.b = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor b() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.f1027a.getClass();
                    Eb a2 = U9.a("IAA-CPT");
                    this.d = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.d;
    }

    public final ICommonExecutor c() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1027a.getClass();
                    Eb a2 = U9.a("IAA-CRS");
                    this.c = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0318i4(C0292h4 c0292h4) {
        this.f1027a = c0292h4;
    }
}

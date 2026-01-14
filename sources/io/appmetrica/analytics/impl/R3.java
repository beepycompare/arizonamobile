package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class R3 {

    /* renamed from: a  reason: collision with root package name */
    public final Q3 f760a;
    public volatile C0747z9 b;
    public volatile C0747z9 c;

    public R3() {
        this(new Q3());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f760a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-CDE");
                    this.b = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f760a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-CRS");
                    this.c = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public R3(Q3 q3) {
        this.f760a = q3;
    }
}

package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class S3 {

    /* renamed from: a  reason: collision with root package name */
    public final R3 f754a;
    public volatile A9 b;
    public volatile A9 c;

    public S3() {
        this(new R3());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f754a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-CDE");
                    this.b = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f754a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-CRS");
                    this.c = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public S3(R3 r3) {
        this.f754a = r3;
    }
}

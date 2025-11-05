package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes3.dex */
public final class Z3 {

    /* renamed from: a  reason: collision with root package name */
    public final Y3 f780a;
    public volatile G9 b;
    public volatile G9 c;

    public Z3() {
        this(new Y3());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f780a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-CDE");
                    this.b = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f780a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-CRS");
                    this.c = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public Z3(Y3 y3) {
        this.f780a = y3;
    }
}

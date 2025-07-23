package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.n4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0449n4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0424m4 f964a;
    public volatile U9 b;
    public volatile U9 c;

    public C0449n4() {
        this(new C0424m4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f964a.getClass();
                    HandlerThreadC0705xb a2 = U9.a("IAA-CDE");
                    this.b = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f964a.getClass();
                    HandlerThreadC0705xb a2 = U9.a("IAA-CRS");
                    this.c = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0449n4(C0424m4 c0424m4) {
        this.f964a = c0424m4;
    }
}

package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.n4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0447n4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0422m4 f979a;
    public volatile W9 b;
    public volatile W9 c;

    public C0447n4() {
        this(new C0422m4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f979a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-CDE");
                    this.b = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f979a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-CRS");
                    this.c = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0447n4(C0422m4 c0422m4) {
        this.f979a = c0422m4;
    }
}

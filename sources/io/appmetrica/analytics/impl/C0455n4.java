package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.n4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0455n4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0430m4 f951a;
    public volatile S9 b;
    public volatile S9 c;

    public C0455n4() {
        this(new C0430m4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f951a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-CDE");
                    this.b = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f951a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-CRS");
                    this.c = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0455n4(C0430m4 c0430m4) {
        this.f951a = c0430m4;
    }
}

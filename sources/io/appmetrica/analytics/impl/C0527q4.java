package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.q4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0527q4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0502p4 f1046a;
    public volatile Z9 b;
    public volatile Z9 c;

    public C0527q4() {
        this(new C0502p4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.f1046a.getClass();
                    Cb a2 = Z9.a("IAA-CDE");
                    this.b = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.f1046a.getClass();
                    Cb a2 = Z9.a("IAA-CRS");
                    this.c = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return this.c;
    }

    public C0527q4(C0502p4 c0502p4) {
        this.f1046a = c0502p4;
    }
}

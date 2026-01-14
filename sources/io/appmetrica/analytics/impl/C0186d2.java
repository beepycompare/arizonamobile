package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.d2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0186d2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0273gc f950a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.d2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0186d2.a(C0186d2.this);
        }
    };

    public C0186d2(C0273gc c0273gc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f950a = c0273gc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C0186d2 c0186d2) {
        C0299hc c0299hc = c0186d2.f950a.f1012a;
        C0681wi c0681wi = c0299hc.h;
        c0681wi.c.a(c0299hc.b.f608a);
    }
}

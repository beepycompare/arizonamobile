package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.v5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0640v5 implements InterfaceC0327ij {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f1163a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public S5 c;

    public AbstractC0640v5(BaseRequestConfig.RequestConfigLoader<Object, S5> requestConfigLoader, C0356jm c0356jm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C0620ua.k().v().a(this);
        a(new S5(c0356jm, C0620ua.k().v(), C0620ua.k().s(), argumentsMerger));
    }

    public final synchronized void a(S5 s5) {
        this.c = s5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0356jm c() {
        return this.c.f677a;
    }

    public final void d() {
        synchronized (this) {
            this.f1163a = null;
        }
    }

    public final synchronized void e() {
        this.f1163a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new S5(c(), C0620ua.H.v(), C0620ua.H.s(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0356jm c0356jm) {
        a(new S5(c0356jm, C0620ua.H.v(), C0620ua.H.s(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f1163a == null) {
            this.f1163a = this.b.load(this.c);
        }
        return this.f1163a;
    }
}

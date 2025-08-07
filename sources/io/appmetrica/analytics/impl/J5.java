package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes4.dex */
public abstract class J5 implements InterfaceC0540qj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f498a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public C0303h6 c;

    public J5(BaseRequestConfig.RequestConfigLoader<Object, C0303h6> requestConfigLoader, C0268fm c0268fm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        Ia.j().u().a(this);
        a(new C0303h6(c0268fm, Ia.j().u(), Ia.j().r(), argumentsMerger));
    }

    public final synchronized void a(C0303h6 c0303h6) {
        this.c = c0303h6;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0268fm c() {
        return this.c.f878a;
    }

    public final void d() {
        synchronized (this) {
            this.f498a = null;
        }
    }

    public final synchronized void e() {
        this.f498a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new C0303h6(c(), Ia.F.u(), Ia.F.r(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0268fm c0268fm) {
        a(new C0303h6(c0268fm, Ia.F.u(), Ia.F.r(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f498a == null) {
            this.f498a = this.b.load(this.c);
        }
        return this.f498a;
    }
}

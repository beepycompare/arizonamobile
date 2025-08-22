package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes4.dex */
public abstract class J5 implements InterfaceC0661vj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f509a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public C0296h6 c;

    public J5(BaseRequestConfig.RequestConfigLoader<Object, C0296h6> requestConfigLoader, C0389km c0389km, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        Ka.j().u().a(this);
        a(new C0296h6(c0389km, Ka.j().u(), Ka.j().r(), argumentsMerger));
    }

    public final synchronized void a(C0296h6 c0296h6) {
        this.c = c0296h6;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0389km c() {
        return this.c.f882a;
    }

    public final void d() {
        synchronized (this) {
            this.f509a = null;
        }
    }

    public final synchronized void e() {
        this.f509a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new C0296h6(c(), Ka.F.u(), Ka.F.r(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0389km c0389km) {
        a(new C0296h6(c0389km, Ka.F.u(), Ka.F.r(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f509a == null) {
            this.f509a = this.b.load(this.c);
        }
        return this.f509a;
    }
}

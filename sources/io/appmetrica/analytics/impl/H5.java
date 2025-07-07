package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes4.dex */
public abstract class H5 implements InterfaceC0470nj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f455a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public C0233e6 c;

    public H5(BaseRequestConfig.RequestConfigLoader<Object, C0233e6> requestConfigLoader, C0198cm c0198cm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        Ga.j().u().a(this);
        a(new C0233e6(c0198cm, Ga.j().u(), Ga.j().r(), argumentsMerger));
    }

    public final synchronized void a(C0233e6 c0233e6) {
        this.c = c0233e6;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0198cm c() {
        return this.c.f816a;
    }

    public final void d() {
        synchronized (this) {
            this.f455a = null;
        }
    }

    public final synchronized void e() {
        this.f455a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new C0233e6(c(), Ga.F.u(), Ga.F.r(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0198cm c0198cm) {
        a(new C0233e6(c0198cm, Ga.F.u(), Ga.F.r(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f455a == null) {
            this.f455a = this.b.load(this.c);
        }
        return this.f455a;
    }
}

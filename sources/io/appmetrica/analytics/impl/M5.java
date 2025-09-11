package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes4.dex */
public abstract class M5 implements InterfaceC0765zj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f571a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public C0373k6 c;

    public M5(BaseRequestConfig.RequestConfigLoader<Object, C0373k6> requestConfigLoader, C0493om c0493om, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        Na.j().u().a(this);
        a(new C0373k6(c0493om, Na.j().u(), Na.j().r(), argumentsMerger));
    }

    public final synchronized void a(C0373k6 c0373k6) {
        this.c = c0373k6;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0493om c() {
        return this.c.f949a;
    }

    public final void d() {
        synchronized (this) {
            this.f571a = null;
        }
    }

    public final synchronized void e() {
        this.f571a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new C0373k6(c(), Na.F.u(), Na.F.r(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0493om c0493om) {
        a(new C0373k6(c0493om, Na.F.u(), Na.F.r(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f571a == null) {
            this.f571a = this.b.load(this.c);
        }
        return this.f571a;
    }
}

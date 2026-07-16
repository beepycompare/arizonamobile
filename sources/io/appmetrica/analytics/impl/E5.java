package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* loaded from: classes5.dex */
public abstract class E5 implements Ej {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f523a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public C0139b6 c;

    public E5(BaseRequestConfig.RequestConfigLoader<Object, C0139b6> requestConfigLoader, Hm hm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        Na.k().v().a(this);
        a(new C0139b6(hm, Na.k().v(), Na.k().s(), argumentsMerger));
    }

    public final synchronized void a(C0139b6 c0139b6) {
        this.c = c0139b6;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized Hm c() {
        return this.c.f904a;
    }

    public final void d() {
        synchronized (this) {
            this.f523a = null;
        }
    }

    public final synchronized void e() {
        this.f523a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new C0139b6(c(), Na.I.v(), Na.I.s(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(Hm hm) {
        a(new C0139b6(hm, Na.I.v(), Na.I.s(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f523a == null) {
            this.f523a = this.b.load(this.c);
        }
        return this.f523a;
    }
}

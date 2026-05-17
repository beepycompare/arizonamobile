package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.o5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0468o5 implements InterfaceC0202dj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f1152a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public L5 c;

    public AbstractC0468o5(BaseRequestConfig.RequestConfigLoader<Object, L5> requestConfigLoader, C0256fm c0256fm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C0448na.k().v().a(this);
        a(new L5(c0256fm, C0448na.k().v(), C0448na.k().s(), argumentsMerger));
    }

    public final synchronized void a(L5 l5) {
        this.c = l5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0256fm c() {
        return this.c.f676a;
    }

    public final void d() {
        synchronized (this) {
            this.f1152a = null;
        }
    }

    public final synchronized void e() {
        this.f1152a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new L5(c(), C0448na.I.v(), C0448na.I.s(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0256fm c0256fm) {
        a(new L5(c0256fm, C0448na.I.v(), C0448na.I.s(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f1152a == null) {
            this.f1152a = this.b.load(this.c);
        }
        return this.f1152a;
    }
}

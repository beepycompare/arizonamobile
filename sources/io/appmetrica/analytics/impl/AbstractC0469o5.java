package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.o5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0469o5 implements InterfaceC0203dj {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f1148a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public L5 c;

    public AbstractC0469o5(BaseRequestConfig.RequestConfigLoader<Object, L5> requestConfigLoader, C0257fm c0257fm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C0449na.k().v().a(this);
        a(new L5(c0257fm, C0449na.k().v(), C0449na.k().s(), argumentsMerger));
    }

    public final synchronized void a(L5 l5) {
        this.c = l5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0257fm c() {
        return this.c.f672a;
    }

    public final void d() {
        synchronized (this) {
            this.f1148a = null;
        }
    }

    public final synchronized void e() {
        this.f1148a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new L5(c(), C0449na.I.v(), C0449na.I.s(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0257fm c0257fm) {
        a(new L5(c0257fm, C0449na.I.v(), C0449na.I.s(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f1148a == null) {
            this.f1148a = this.b.load(this.c);
        }
        return this.f1148a;
    }
}

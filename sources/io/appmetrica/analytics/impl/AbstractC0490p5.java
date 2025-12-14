package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.p5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0490p5 implements InterfaceC0223ej {

    /* renamed from: a  reason: collision with root package name */
    public BaseRequestConfig f1157a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public M5 c;

    public AbstractC0490p5(BaseRequestConfig.RequestConfigLoader<Object, M5> requestConfigLoader, C0278gm c0278gm, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C0470oa.k().v().a(this);
        a(new M5(c0278gm, C0470oa.k().v(), C0470oa.k().s(), argumentsMerger));
    }

    public final synchronized void a(M5 m5) {
        this.c = m5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C0278gm c() {
        return this.c.f680a;
    }

    public final void d() {
        synchronized (this) {
            this.f1157a = null;
        }
    }

    public final synchronized void e() {
        this.f1157a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new M5(c(), C0470oa.I.v(), C0470oa.I.s(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C0278gm c0278gm) {
        a(new M5(c0278gm, C0470oa.I.v(), C0470oa.I.s(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f1157a == null) {
            this.f1157a = this.b.load(this.c);
        }
        return this.f1157a;
    }
}

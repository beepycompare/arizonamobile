package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;
/* renamed from: io.appmetrica.analytics.impl.v6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0641v6 implements Function {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final C0733yn apply(Thread thread) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new C0733yn(name, priority, id, threadGroup != null ? threadGroup.getName() : "", null, null);
    }
}

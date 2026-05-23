package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;
/* loaded from: classes5.dex */
public final class F6 implements Function {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final Zn apply(Thread thread) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new Zn(name, priority, id, threadGroup != null ? threadGroup.getName() : "", null, null);
    }
}

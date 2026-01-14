package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;
/* renamed from: io.appmetrica.analytics.impl.o6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0470o6 implements Function {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final C0686wn apply(Thread thread) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new C0686wn(name, priority, id, threadGroup != null ? threadGroup.getName() : "", null, null);
    }
}

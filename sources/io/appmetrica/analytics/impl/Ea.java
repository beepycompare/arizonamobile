package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class Ea implements BiFunction {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiFunction
    /* renamed from: a */
    public final C0541qn apply(Thread thread, StackTraceElement[] stackTraceElementArr) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new C0541qn(name, priority, id, threadGroup != null ? threadGroup.getName() : "", Integer.valueOf(thread.getState().ordinal()), stackTraceElementArr == null ? null : Arrays.asList(stackTraceElementArr));
    }
}

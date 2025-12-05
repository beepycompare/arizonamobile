package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0420ma implements BiFunction {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiFunction
    /* renamed from: a */
    public final C0707xn apply(Thread thread, StackTraceElement[] stackTraceElementArr) {
        String name = thread.getName();
        int priority = thread.getPriority();
        long id = thread.getId();
        ThreadGroup threadGroup = thread.getThreadGroup();
        return new C0707xn(name, priority, id, threadGroup != null ? threadGroup.getName() : "", Integer.valueOf(thread.getState().ordinal()), stackTraceElementArr == null ? null : Arrays.asList(stackTraceElementArr));
    }
}

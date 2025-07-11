package io.appmetrica.analytics.impl;

import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.sn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0590sn implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1050a = new CopyOnWriteArrayList();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : this.f1050a) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

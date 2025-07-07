package io.appmetrica.analytics.impl;

import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.sn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0598sn implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1049a = new CopyOnWriteArrayList();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : this.f1049a) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

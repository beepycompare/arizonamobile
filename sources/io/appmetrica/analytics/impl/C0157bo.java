package io.appmetrica.analytics.impl;

import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.bo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0157bo implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f913a = new CopyOnWriteArrayList();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : this.f913a) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

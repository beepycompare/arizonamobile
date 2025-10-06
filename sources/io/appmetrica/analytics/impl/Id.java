package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Id extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f497a;

    public Id(String str) {
        this.f497a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0672w0 c0672w0 = A4.l().p;
        String str = this.f497a;
        c0672w0.getClass();
        C0647v0.c().a(str);
    }
}

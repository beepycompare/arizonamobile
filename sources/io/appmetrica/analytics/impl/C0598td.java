package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.td  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0598td extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1131a;

    public C0598td(String str) {
        this.f1131a = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0685x0 c0685x0 = C0338j4.l().p;
        String str = this.f1131a;
        c0685x0.getClass();
        C0660w0.c().a(str);
    }
}

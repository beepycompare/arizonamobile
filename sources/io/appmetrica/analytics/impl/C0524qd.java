package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0524qd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0623ud f1073a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C0524qd(C0623ud c0623ud, int i, String str) {
        this.f1073a = c0623ud;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0623ud.a(this.f1073a).a(new M9(this.b, this.c));
    }
}

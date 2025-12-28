package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.md  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0423md extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0473od f1108a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C0423md(C0473od c0473od, String str, byte[] bArr) {
        this.f1108a = c0473od;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0473od.a(this.f1108a).setSessionExtra(this.b, this.c);
    }
}

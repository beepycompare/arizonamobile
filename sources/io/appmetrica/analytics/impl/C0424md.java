package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.md  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0424md extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0474od f1010a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C0424md(C0474od c0474od, String str, byte[] bArr) {
        this.f1010a = c0474od;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0474od.a(this.f1010a).setSessionExtra(this.b, this.c);
    }
}

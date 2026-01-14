package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0402ld extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452nd f1098a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C0402ld(C0452nd c0452nd, String str, byte[] bArr) {
        this.f1098a = c0452nd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0452nd.a(this.f1098a).setSessionExtra(this.b, this.c);
    }
}

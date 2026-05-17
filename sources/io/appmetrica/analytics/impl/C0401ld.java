package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0401ld extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0451nd f1102a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C0401ld(C0451nd c0451nd, String str, byte[] bArr) {
        this.f1102a = c0451nd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0451nd.a(this.f1102a).setSessionExtra(this.b, this.c);
    }
}

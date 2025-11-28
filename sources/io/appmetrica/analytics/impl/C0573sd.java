package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0573sd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0623ud f1112a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C0573sd(C0623ud c0623ud, String str, byte[] bArr) {
        this.f1112a = c0623ud;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0623ud.a(this.f1112a).setSessionExtra(this.b, this.c);
    }
}

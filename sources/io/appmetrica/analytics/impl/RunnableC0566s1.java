package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0566s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1195a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0644v1 c;

    public RunnableC0566s1(C0644v1 c0644v1, String str, Throwable th) {
        this.c = c0644v1;
        this.f1195a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.c).reportError(this.f1195a, this.b);
    }
}

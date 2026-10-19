package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0144bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f914a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ Ai c;

    public RunnableC0144bi(Ai ai, String str, Throwable th) {
        this.c = ai;
        this.f914a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f466a, ai.d, ai.e).reportError(this.f914a, this.b);
    }
}

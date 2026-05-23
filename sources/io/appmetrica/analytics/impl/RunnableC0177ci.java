package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0177ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f928a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ Ai d;

    public RunnableC0177ci(Ai ai, String str, String str2, Throwable th) {
        this.d = ai;
        this.f928a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.d;
        Ai.a(ai.f460a, ai.d, ai.e).reportError(this.f928a, this.b, this.c);
    }
}

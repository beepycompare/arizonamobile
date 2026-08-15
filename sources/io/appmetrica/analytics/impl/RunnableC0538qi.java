package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0538qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1168a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ Ai c;

    public RunnableC0538qi(Ai ai, String str, byte[] bArr) {
        this.c = ai;
        this.f1168a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f463a, ai.d, ai.e).setSessionExtra(this.f1168a, this.b);
    }
}

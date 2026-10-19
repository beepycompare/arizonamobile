package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0765zi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1323a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ai c;

    public RunnableC0765zi(Ai ai, String str, String str2) {
        this.c = ai;
        this.f1323a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f466a, ai.d, ai.e).reportEvent(this.f1323a, this.b);
    }
}

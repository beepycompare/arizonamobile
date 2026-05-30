package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0772zi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1318a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ai c;

    public RunnableC0772zi(Ai ai, String str, String str2) {
        this.c = ai;
        this.f1318a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f461a, ai.d, ai.e).reportEvent(this.f1318a, this.b);
    }
}

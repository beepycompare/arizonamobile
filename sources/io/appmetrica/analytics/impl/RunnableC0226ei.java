package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0226ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f984a;
    public final /* synthetic */ C0278gi b;

    public RunnableC0226ei(C0278gi c0278gi, String str) {
        this.b = c0278gi;
        this.f984a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportEvent(this.f984a);
    }
}

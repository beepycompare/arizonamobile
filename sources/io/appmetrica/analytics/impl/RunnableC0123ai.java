package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0123ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f911a;
    public final /* synthetic */ C0278gi b;

    public RunnableC0123ai(C0278gi c0278gi, V v) {
        this.b = c0278gi;
        this.f911a = v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).a(this.f911a);
    }
}

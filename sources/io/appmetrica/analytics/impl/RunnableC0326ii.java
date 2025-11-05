package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0326ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0404li f937a;

    public RunnableC0326ii(C0404li c0404li) {
        this.f937a = c0404li;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.f937a;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).clearAppEnvironment();
    }
}

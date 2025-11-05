package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Ph implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0404li f638a;

    public Ph(C0404li c0404li) {
        this.f638a = c0404li;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.f638a;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).resumeSession();
    }
}

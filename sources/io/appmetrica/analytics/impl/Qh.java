package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Qh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0404li f652a;

    public Qh(C0404li c0404li) {
        this.f652a = c0404li;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.f652a;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).pauseSession();
    }
}

package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0198di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sn f848a;
    public final /* synthetic */ C0404li b;

    public RunnableC0198di(C0404li c0404li, Sn sn) {
        this.b = c0404li;
        this.f848a = sn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).a(this.f848a);
    }
}

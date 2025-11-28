package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0352ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f955a;
    public final /* synthetic */ C0404li b;

    public RunnableC0352ji(C0404li c0404li, String str) {
        this.b = c0404li;
        this.f955a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportEvent(this.f955a);
    }
}

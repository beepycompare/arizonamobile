package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0378ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f975a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0404li c;

    public RunnableC0378ki(C0404li c0404li, String str, String str2) {
        this.c = c0404li;
        this.f975a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportEvent(this.f975a, this.b);
    }
}

package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0588si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1054a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0613ti c;

    public RunnableC0588si(C0613ti c0613ti, String str, String str2) {
        this.c = c0613ti;
        this.f1054a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportEvent(this.f1054a, this.b);
    }
}

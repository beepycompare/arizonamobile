package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0563ri implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1038a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0563ri(C0613ti c0613ti, String str) {
        this.b = c0613ti;
        this.f1038a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportEvent(this.f1038a);
    }
}

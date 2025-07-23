package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0562ri implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1038a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0562ri(C0612ti c0612ti, String str) {
        this.b = c0612ti;
        this.f1038a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportEvent(this.f1038a);
    }
}

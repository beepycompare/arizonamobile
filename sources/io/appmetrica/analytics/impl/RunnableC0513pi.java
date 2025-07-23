package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0513pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1003a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0612ti c;

    public RunnableC0513pi(C0612ti c0612ti, String str, String str2) {
        this.c = c0612ti;
        this.f1003a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.c;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).putAppEnvironmentValue(this.f1003a, this.b);
    }
}

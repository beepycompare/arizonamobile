package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0514pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1003a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0613ti c;

    public RunnableC0514pi(C0613ti c0613ti, String str, String str2) {
        this.c = c0613ti;
        this.f1003a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).putAppEnvironmentValue(this.f1003a, this.b);
    }
}

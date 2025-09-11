package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0689wi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f1141a;
    public final /* synthetic */ Ci b;

    public RunnableC0689wi(Ci ci, U u) {
        this.b = ci;
        this.f1141a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f392a, ci.d, ci.e).a(this.f1141a);
    }
}

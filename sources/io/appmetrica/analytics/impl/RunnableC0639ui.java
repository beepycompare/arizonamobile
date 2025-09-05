package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ui  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0639ui implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Wn f1109a;
    public final /* synthetic */ Ci b;

    public RunnableC0639ui(Ci ci, Wn wn) {
        this.b = ci;
        this.f1109a = wn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f388a, ci.d, ci.e).a(this.f1109a);
    }
}

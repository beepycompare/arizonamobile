package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f657a;
    public final /* synthetic */ C0561s1 b;

    public R0(C0561s1 c0561s1, boolean z) {
        this.b = c0561s1;
        this.f657a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0685x0 c0685x0 = this.b.f1103a;
        boolean z = this.f657a;
        c0685x0.getClass();
        C0660w0.c().setDataSendingEnabled(z);
    }
}

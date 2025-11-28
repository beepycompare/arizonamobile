package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f674a;
    public final /* synthetic */ C0561s1 b;

    public S0(C0561s1 c0561s1, String str) {
        this.b = c0561s1;
        this.f674a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0685x0 c0685x0 = this.b.f1103a;
        String str = this.f674a;
        c0685x0.getClass();
        C0660w0.c().setUserProfileID(str);
    }
}

package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f648a;
    public final /* synthetic */ C0548r1 b;

    public R0(C0548r1 c0548r1, String str) {
        this.b = c0548r1;
        this.f648a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0672w0 c0672w0 = this.b.f1059a;
        String str = this.f648a;
        c0672w0.getClass();
        C0647v0.c().setUserProfileID(str);
    }
}

package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f766a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0548r1 c;

    public Z0(C0548r1 c0548r1, String str, String str2) {
        this.c = c0548r1;
        this.f766a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0672w0 c0672w0 = this.c.f1059a;
        String str = this.f766a;
        String str2 = this.b;
        c0672w0.getClass();
        C0647v0.c().a(str, str2);
    }
}

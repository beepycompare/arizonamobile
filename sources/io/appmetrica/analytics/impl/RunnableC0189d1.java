package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0189d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f834a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0548r1 c;

    public RunnableC0189d1(C0548r1 c0548r1, String str, String str2) {
        this.c = c0548r1;
        this.f834a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0672w0 c0672w0 = this.c.f1059a;
        String str = this.f834a;
        String str2 = this.b;
        c0672w0.getClass();
        C0647v0.c().putAppEnvironmentValue(str, str2);
    }
}

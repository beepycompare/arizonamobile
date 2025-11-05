package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0206e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f854a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0561s1 c;

    public RunnableC0206e1(C0561s1 c0561s1, String str, String str2) {
        this.c = c0561s1;
        this.f854a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0685x0 c0685x0 = this.c.f1103a;
        String str = this.f854a;
        String str2 = this.b;
        c0685x0.getClass();
        C0660w0.c().putAppEnvironmentValue(str, str2);
    }
}

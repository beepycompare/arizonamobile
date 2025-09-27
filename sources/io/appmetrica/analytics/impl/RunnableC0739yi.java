package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.yi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0739yi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1173a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ci c;

    public RunnableC0739yi(Ci ci, String str, String str2) {
        this.c = ci;
        this.f1173a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f393a, ci.d, ci.e).putAppEnvironmentValue(this.f1173a, this.b);
    }
}

package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0461ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f959a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0560ri c;

    public RunnableC0461ni(C0560ri c0560ri, String str, String str2) {
        this.c = c0560ri;
        this.f959a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).putAppEnvironmentValue(this.f959a, this.b);
    }
}

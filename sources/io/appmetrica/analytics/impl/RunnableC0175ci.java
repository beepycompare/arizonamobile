package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0175ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f940a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0278gi c;

    public RunnableC0175ci(C0278gi c0278gi, String str, String str2) {
        this.c = c0278gi;
        this.f940a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.c;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).putAppEnvironmentValue(this.f940a, this.b);
    }
}

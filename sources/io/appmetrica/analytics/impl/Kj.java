package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f663a;
    public final /* synthetic */ String b;

    public Kj(String str, String str2) {
        this.f663a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.putAppEnvironmentValue(this.f663a, this.b);
    }
}

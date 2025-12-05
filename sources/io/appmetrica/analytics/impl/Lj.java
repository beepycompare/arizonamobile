package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Lj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f657a;
    public final /* synthetic */ String b;

    public Lj(String str, String str2) {
        this.f657a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.putAppEnvironmentValue(this.f657a, this.b);
    }
}

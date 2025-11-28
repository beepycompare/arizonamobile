package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Pj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f640a;
    public final /* synthetic */ String b;

    public Pj(String str, String str2) {
        this.f640a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.putAppEnvironmentValue(this.f640a, this.b);
    }
}

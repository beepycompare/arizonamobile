package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Pj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f721a;
    public final /* synthetic */ String b;

    public Pj(String str, String str2) {
        this.f721a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportEvent(this.f721a, this.b);
    }
}

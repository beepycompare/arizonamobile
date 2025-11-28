package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Tj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f709a;
    public final /* synthetic */ String b;

    public Tj(String str, String str2) {
        this.f709a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f709a, this.b);
    }
}

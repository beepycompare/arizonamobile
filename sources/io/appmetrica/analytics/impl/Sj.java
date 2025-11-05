package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Sj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f687a;

    public Sj(String str) {
        this.f687a = str;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f687a);
    }
}

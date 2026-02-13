package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Nj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f712a;

    public Nj(String str) {
        this.f712a = str;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportEvent(this.f712a);
    }
}

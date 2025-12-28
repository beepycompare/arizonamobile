package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Oj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f722a;

    public Oj(String str) {
        this.f722a = str;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportEvent(this.f722a);
    }
}

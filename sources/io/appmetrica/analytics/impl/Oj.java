package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Oj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f727a;
    public final /* synthetic */ String b;

    public Oj(String str, String str2) {
        this.f727a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportEvent(this.f727a, this.b);
    }
}

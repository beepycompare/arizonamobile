package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Oj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f732a;
    public final /* synthetic */ String b;

    public Oj(String str, String str2) {
        this.f732a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportEvent(this.f732a, this.b);
    }
}

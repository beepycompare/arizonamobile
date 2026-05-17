package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Pj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f746a;
    public final /* synthetic */ Map b;

    public Pj(String str, Map map) {
        this.f746a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportEvent(this.f746a, this.b);
    }
}

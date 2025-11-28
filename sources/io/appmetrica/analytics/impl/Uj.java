package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Uj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f722a;
    public final /* synthetic */ Map b;

    public Uj(String str, Map map) {
        this.f722a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f722a, this.b);
    }
}

package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0710xd extends S2 {
    public final String b;

    public C0710xd(String str, Dl dl) {
        super(dl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.S2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}

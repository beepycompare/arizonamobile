package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.df  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0195df {

    /* renamed from: a  reason: collision with root package name */
    public final String f846a;
    public final String b;

    public C0195df(String str, String str2) {
        this.f846a = str;
        this.b = a(str2);
    }

    public final String a(String str) {
        return str != null ? this.f846a + str : this.f846a;
    }
}

package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0505p8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0200dd f1032a;

    public AbstractC0505p8() {
        C0200dd c0200dd = new C0200dd(0);
        c0200dd.a(EnumC0530q8.b, 0);
        c0200dd.a(EnumC0530q8.c, 1);
        c0200dd.a(EnumC0530q8.d, 2);
        c0200dd.a(EnumC0530q8.e, 3);
        this.f1032a = c0200dd;
    }

    public final C0200dd a() {
        return this.f1032a;
    }

    public abstract boolean a(Object obj, Object obj2);
}

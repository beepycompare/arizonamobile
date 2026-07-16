package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Jg implements Lg {

    /* renamed from: a  reason: collision with root package name */
    public final String f615a;
    public final Throwable b;

    public Jg(String str, Throwable th) {
        this.f615a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Lg
    public final Bg a() {
        return null;
    }

    public final String b() {
        return this.f615a;
    }

    public final Throwable c() {
        return this.b;
    }

    public final String toString() {
        return "Failure(message='" + this.f615a + "', throwable=" + this.b + ')';
    }

    public /* synthetic */ Jg(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}

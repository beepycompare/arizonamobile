package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.x  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0687x extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0562s f1295a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0687x(C0562s c0562s) {
        super(1);
        this.f1295a = c0562s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1295a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}

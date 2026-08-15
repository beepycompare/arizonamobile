package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.z  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0752z extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0570s f1305a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0752z(C0570s c0570s) {
        super(1);
        this.f1305a = c0570s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1305a.h = (byte[]) obj;
        return Unit.INSTANCE;
    }
}

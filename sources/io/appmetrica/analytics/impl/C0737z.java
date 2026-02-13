package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.z  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0737z extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0562s f1327a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0737z(C0562s c0562s) {
        super(1);
        this.f1327a = c0562s;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1327a.i = (byte[]) obj;
        return Unit.INSTANCE;
    }
}

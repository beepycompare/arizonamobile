package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.w  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0666w extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f1095a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0666w(r rVar) {
        super(1);
        this.f1095a = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f1095a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}

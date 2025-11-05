package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0698xd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0422mb f1201a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0698xd(C0422mb c0422mb) {
        super(1);
        this.f1201a = c0422mb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0244fd) ((Map.Entry) obj).getValue()).b.parse(this.f1201a);
    }
}

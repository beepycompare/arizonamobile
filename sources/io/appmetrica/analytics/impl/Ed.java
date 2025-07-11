package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Ed extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0728yb f408a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ed(C0728yb c0728yb) {
        super(1);
        this.f408a = c0728yb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0555rd) ((Map.Entry) obj).getValue()).b.parse(this.f408a);
    }
}

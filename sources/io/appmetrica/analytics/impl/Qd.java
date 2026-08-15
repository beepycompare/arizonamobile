package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class Qd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hb f733a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qd(Hb hb) {
        super(1);
        this.f733a = hb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0740yd) ((Map.Entry) obj).getValue()).b.parse(this.f733a);
    }
}

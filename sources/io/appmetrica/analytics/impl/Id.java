package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Id extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cb f496a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Id(Cb cb) {
        super(1);
        this.f496a = cb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0655vd) ((Map.Entry) obj).getValue()).b.parse(this.f496a);
    }
}

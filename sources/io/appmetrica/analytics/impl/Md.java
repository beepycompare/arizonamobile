package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Md extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fb f577a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Md(Fb fb) {
        super(1);
        this.f577a = fb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0735yd) ((Map.Entry) obj).getValue()).b.parse(this.f577a);
    }
}

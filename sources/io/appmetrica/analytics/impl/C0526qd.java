package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0526qd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0245fb f1192a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0526qd(C0245fb c0245fb) {
        super(1);
        this.f1192a = c0245fb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Yc) ((Map.Entry) obj).getValue()).b.parse(this.f1192a);
    }
}

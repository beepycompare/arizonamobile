package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0527qd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0246fb f1188a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0527qd(C0246fb c0246fb) {
        super(1);
        this.f1188a = c0246fb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Yc) ((Map.Entry) obj).getValue()).b.parse(this.f1188a);
    }
}

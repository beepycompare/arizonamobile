package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.rd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0547rd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0267gb f1197a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0547rd(C0267gb c0267gb) {
        super(1);
        this.f1197a = c0267gb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Zc) ((Map.Entry) obj).getValue()).b.parse(this.f1197a);
    }
}

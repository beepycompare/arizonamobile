package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class Gd extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ab f453a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gd(Ab ab) {
        super(1);
        this.f453a = ab;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C0608td) ((Map.Entry) obj).getValue()).b.parse(this.f453a);
    }
}

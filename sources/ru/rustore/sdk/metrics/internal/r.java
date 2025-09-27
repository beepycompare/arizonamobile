package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class r extends Lambda implements Function0<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1473a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable th) {
        super(0);
        this.f1473a = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Http request was failed with: " + this.f1473a;
    }
}

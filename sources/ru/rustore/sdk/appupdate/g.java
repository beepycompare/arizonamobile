package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
/* loaded from: classes5.dex */
public final class g extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f1349a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(CancellableContinuation<? super Unit> cancellableContinuation) {
        super(0);
        this.f1349a = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        CancellableContinuationExtKt.resumeIfActive(this.f1349a, Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}

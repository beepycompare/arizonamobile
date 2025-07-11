package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
/* loaded from: classes5.dex */
public final class s extends Lambda implements Function1<RuStoreException, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f1362a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public s(CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.f1362a = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(RuStoreException ruStoreException) {
        RuStoreException error = ruStoreException;
        Intrinsics.checkNotNullParameter(error, "error");
        CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1362a, error);
        return Unit.INSTANCE;
    }
}

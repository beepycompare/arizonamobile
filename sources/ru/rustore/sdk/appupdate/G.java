package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class G extends Lambda implements Function1<RuStoreException, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<Unit> f1498a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(SingleEmitter<Unit> singleEmitter) {
        super(1);
        this.f1498a = singleEmitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(RuStoreException ruStoreException) {
        RuStoreException error = ruStoreException;
        Intrinsics.checkNotNullParameter(error, "error");
        this.f1498a.error(error);
        return Unit.INSTANCE;
    }
}

package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class W extends Lambda implements Function1<SingleEmitter<Integer>, Unit> {
    public W() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(SingleEmitter<Integer> singleEmitter) {
        SingleEmitter<Integer> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        emitter.error(new RuStoreException("update not available"));
        return Unit.INSTANCE;
    }
}

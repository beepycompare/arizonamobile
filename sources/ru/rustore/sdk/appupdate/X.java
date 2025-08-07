package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes5.dex */
public final class X extends Lambda implements Function1<SingleEmitter<Integer>, Unit> {
    public X() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(SingleEmitter<Integer> singleEmitter) {
        SingleEmitter<Integer> emitter = singleEmitter;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        emitter.error(new IllegalStateException("AppUpdateInfo object is already used. Call the method getAppUpdateInfo() again"));
        return Unit.INSTANCE;
    }
}

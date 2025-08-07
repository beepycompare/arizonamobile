package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes5.dex */
public final class F extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<Unit> f1335a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(SingleEmitter<Unit> singleEmitter) {
        super(0);
        this.f1335a = singleEmitter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        SingleEmitter<Unit> singleEmitter = this.f1335a;
        Unit unit = Unit.INSTANCE;
        singleEmitter.success(unit);
        return unit;
    }
}

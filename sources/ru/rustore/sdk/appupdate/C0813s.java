package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* renamed from: ru.rustore.sdk.appupdate.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0813s extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<Unit> f1393a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0813s(SingleEmitter<Unit> singleEmitter) {
        super(0);
        this.f1393a = singleEmitter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        SingleEmitter<Unit> singleEmitter = this.f1393a;
        Unit unit = Unit.INSTANCE;
        singleEmitter.success(unit);
        return unit;
    }
}

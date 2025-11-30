package ru.rustore.sdk.appupdate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* renamed from: ru.rustore.sdk.appupdate.t  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0804t extends Lambda implements Function1<RuStoreException, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter<Unit> f1459a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0804t(SingleEmitter<Unit> singleEmitter) {
        super(1);
        this.f1459a = singleEmitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(RuStoreException ruStoreException) {
        RuStoreException error = ruStoreException;
        Intrinsics.checkNotNullParameter(error, "error");
        this.f1459a.error(error);
        return Unit.INSTANCE;
    }
}

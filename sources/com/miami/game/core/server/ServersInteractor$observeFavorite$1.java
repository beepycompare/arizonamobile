package com.miami.game.core.server;

import com.miami.game.core.server.data.FavoriteServerEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "favoritesList", "", "Lcom/miami/game/core/server/data/FavoriteServerEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$observeFavorite$1", f = "ServersInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ServersInteractor$observeFavorite$1 extends SuspendLambda implements Function2<List<? extends FavoriteServerEntity>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$observeFavorite$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$observeFavorite$1> continuation) {
        super(2, continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ServersInteractor$observeFavorite$1 serversInteractor$observeFavorite$1 = new ServersInteractor$observeFavorite$1(this.this$0, continuation);
        serversInteractor$observeFavorite$1.L$0 = obj;
        return serversInteractor$observeFavorite$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends FavoriteServerEntity> list, Continuation<? super Unit> continuation) {
        return invoke2((List<FavoriteServerEntity>) list, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(List<FavoriteServerEntity> list, Continuation<? super Unit> continuation) {
        return ((ServersInteractor$observeFavorite$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.updateFavorites((List) this.L$0);
        return Unit.INSTANCE;
    }
}

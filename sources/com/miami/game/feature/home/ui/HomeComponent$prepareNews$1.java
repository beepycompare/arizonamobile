package com.miami.game.feature.home.ui;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.news.domain.NewsState;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/news/domain/NewsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$prepareNews$1", f = "HomeComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class HomeComponent$prepareNews$1 extends SuspendLambda implements Function2<NewsState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$prepareNews$1(HomeComponent homeComponent, Continuation<? super HomeComponent$prepareNews$1> continuation) {
        super(2, continuation);
        this.this$0 = homeComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeComponent$prepareNews$1 homeComponent$prepareNews$1 = new HomeComponent$prepareNews$1(this.this$0, continuation);
        homeComponent$prepareNews$1.L$0 = obj;
        return homeComponent$prepareNews$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NewsState newsState, Continuation<? super Unit> continuation) {
        return ((HomeComponent$prepareNews$1) create(newsState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NewsState newsState = (NewsState) this.L$0;
        if (!newsState.getNewsList().isEmpty()) {
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
                Timber.Forest.d(newsState.getNewsList().toString(), new Object[0]);
            } while (!mutableStateFlow.compareAndSet(value, HomeUiState.copy$default((HomeUiState) value, 0, false, null, newsState.getNewsList(), null, null, null, null, null, null, null, false, false, false, 0, false, false, false, 262135, null)));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

package com.miami.game.feature.home.ui;

import android.content.Context;
import com.miami.game.feature.home.ui.model.HomeUiAction;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$onClickShop$1", f = "HomeComponent.kt", i = {0, 0, 0}, l = {299}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-HomeComponent$onClickShop$1$isShopAllowed$1"}, nl = {301}, s = {"L$0", "L$1", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class HomeComponent$onClickShop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HomeComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$onClickShop$1(HomeComponent homeComponent, Context context, Continuation<? super HomeComponent$onClickShop$1> continuation) {
        super(2, continuation);
        this.this$0 = homeComponent;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeComponent$onClickShop$1 homeComponent$onClickShop$1 = new HomeComponent$onClickShop$1(this.this$0, this.$context, continuation);
        homeComponent$onClickShop$1.L$0 = obj;
        return homeComponent$onClickShop$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeComponent$onClickShop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9842constructorimpl;
        MutableStateFlow mutableStateFlow;
        Object withContext;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HomeComponent homeComponent = this.this$0;
                Context context = this.$context;
                Result.Companion companion = Result.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new HomeComponent$onClickShop$1$isShopAllowed$1$1(homeComponent, context, null), this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$1;
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
            m9842constructorimpl = Result.m9842constructorimpl(Boxing.boxBoolean(((Boolean) withContext).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9842constructorimpl = Result.m9842constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9845exceptionOrNullimpl = Result.m9845exceptionOrNullimpl(m9842constructorimpl);
        if (m9845exceptionOrNullimpl != null) {
            Timber.Forest.e(m9845exceptionOrNullimpl, "Failed to check shop availability", new Object[0]);
            m9842constructorimpl = Boxing.boxBoolean(false);
        }
        boolean booleanValue = ((Boolean) m9842constructorimpl).booleanValue();
        mutableStateFlow = this.this$0.stateStore;
        while (true) {
            Object value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, HomeUiState.copy$default((HomeUiState) value, 0, false, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, booleanValue, false, false, 0, 0, 0, null, null, 16711679, null))) {
                break;
            }
        }
        HomeComponent homeComponent2 = this.this$0;
        if (booleanValue) {
            homeComponent2.openShop(this.$context);
        } else {
            homeComponent2.emitUiAction(HomeUiAction.NotifyShopIsNotAllowed.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}

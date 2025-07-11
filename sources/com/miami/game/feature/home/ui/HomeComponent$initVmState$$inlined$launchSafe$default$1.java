package com.miami.game.feature.home.ui;

import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$initVmState$$inlined$launchSafe$default$1", f = "HomeComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "invokeSuspend", n = {"$this$launch", "$completion", "$this$initVmState_u24lambda_u242", "$this$update$iv", "prevValue$iv", "it", "$i$a$-launchSafe$default-HomeComponent$initVmState$2", "$i$f$update", "$i$a$-update-HomeComponent$initVmState$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"})
/* loaded from: classes4.dex */
public final class HomeComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ HomeComponent receiver$inlined;
    final /* synthetic */ HomeComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$initVmState$$inlined$launchSafe$default$1(Continuation continuation, HomeComponent homeComponent, HomeComponent homeComponent2) {
        super(2, continuation);
        this.this$0 = homeComponent;
        this.receiver$inlined = homeComponent2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeComponent$initVmState$$inlined$launchSafe$default$1 homeComponent$initVmState$$inlined$launchSafe$default$1 = new HomeComponent$initVmState$$inlined$launchSafe$default$1(continuation, this.this$0, this.receiver$inlined);
        homeComponent$initVmState$$inlined$launchSafe$default$1.L$0 = obj;
        return homeComponent$initVmState$$inlined$launchSafe$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeComponent$initVmState$$inlined$launchSafe$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009b -> B:8:0x003b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        CoroutineScope coroutineScope;
        Object obj2;
        int i;
        int i2;
        MutableStateFlow mutableStateFlow2;
        Object value;
        HomeUiState homeUiState;
        privacyInteractor privacyinteractor;
        Object isPrivacyAccepted;
        int i3;
        boolean z;
        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        int i5 = 1;
        try {
        } catch (Exception e) {
            this.receiver$inlined.handleError(e);
        }
        if (i4 != 0) {
            if (i4 == 1) {
                int i6 = this.I$5;
                int i7 = this.I$4;
                int i8 = this.I$3;
                int i9 = this.I$1;
                i2 = this.I$0;
                homeUiState = (HomeUiState) this.L$6;
                HomeUiState homeUiState2 = (HomeUiState) this.L$5;
                value = this.L$4;
                mutableStateFlow2 = (MutableStateFlow) this.L$3;
                coroutineScope = (CoroutineScope) this.L$2;
                obj2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                int i10 = i9;
                int i11 = i8;
                int i12 = i6;
                isPrivacyAccepted = obj;
                int i13 = i2;
                CoroutineScope coroutineScope3 = coroutineScope;
                Object obj3 = obj2;
                if (i7 == 0) {
                    i3 = i11;
                    z = i5;
                } else {
                    i3 = i11;
                    z = 0;
                }
                MutableStateFlow mutableStateFlow3 = mutableStateFlow2;
                if (!mutableStateFlow3.compareAndSet(value, HomeUiState.copy$default(homeUiState, i12, z, null, null, null, null, null, null, null, null, null, i3 == 0 ? i5 : 0, ((Boolean) isPrivacyAccepted).booleanValue(), false, 0, false, false, false, 258047, null))) {
                    mutableStateFlow2 = mutableStateFlow3;
                    i = i10;
                    i2 = i13;
                    coroutineScope = coroutineScope3;
                    obj2 = obj3;
                    i5 = 1;
                    value = mutableStateFlow2.getValue();
                    homeUiState = (HomeUiState) value;
                    privacyinteractor = this.this$0.privacyInteractor;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$3 = mutableStateFlow2;
                    this.L$4 = value;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState);
                    this.L$6 = homeUiState;
                    this.I$0 = i2;
                    this.I$1 = i;
                    this.I$2 = 0;
                    this.I$3 = 0;
                    this.I$4 = 0;
                    this.I$5 = 0;
                    this.label = i5;
                    isPrivacyAccepted = privacyinteractor.isPrivacyAccepted(this);
                    if (isPrivacyAccepted != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i7 = 0;
                    i12 = 0;
                    i10 = i;
                    i11 = 0;
                    int i132 = i2;
                    CoroutineScope coroutineScope32 = coroutineScope;
                    Object obj32 = obj2;
                    if (i7 == 0) {
                    }
                    MutableStateFlow mutableStateFlow32 = mutableStateFlow2;
                    if (!mutableStateFlow32.compareAndSet(value, HomeUiState.copy$default(homeUiState, i12, z, null, null, null, null, null, null, null, null, null, i3 == 0 ? i5 : 0, ((Boolean) isPrivacyAccepted).booleanValue(), false, 0, false, false, false, 258047, null))) {
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        mutableStateFlow = this.this$0.stateStore;
        coroutineScope = coroutineScope2;
        obj2 = this;
        i = 0;
        i2 = 0;
        mutableStateFlow2 = mutableStateFlow;
        value = mutableStateFlow2.getValue();
        homeUiState = (HomeUiState) value;
        privacyinteractor = this.this$0.privacyInteractor;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$3 = mutableStateFlow2;
        this.L$4 = value;
        this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState);
        this.L$6 = homeUiState;
        this.I$0 = i2;
        this.I$1 = i;
        this.I$2 = 0;
        this.I$3 = 0;
        this.I$4 = 0;
        this.I$5 = 0;
        this.label = i5;
        isPrivacyAccepted = privacyinteractor.isPrivacyAccepted(this);
        if (isPrivacyAccepted != coroutine_suspended) {
        }
    }
}

package com.miami.game.feature.home.ui;

import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$initVmState$$inlined$launchSafe$default$1", f = "HomeComponent.kt", i = {0, 0}, l = {29}, m = "invokeSuspend", n = {"$this$update$iv", "prevValue$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class HomeComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0064 -> B:16:0x006a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        privacyInteractor privacyinteractor;
        Object isPrivacyAccepted;
        int i;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 1;
        try {
        } catch (Exception e) {
            this.receiver$inlined.handleError(e);
        }
        if (i2 != 0) {
            if (i2 == 1) {
                int i4 = this.I$2;
                int i5 = this.I$1;
                int i6 = this.I$0;
                HomeUiState homeUiState = (HomeUiState) this.L$2;
                Object obj2 = this.L$1;
                MutableStateFlow mutableStateFlow2 = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow3 = mutableStateFlow2;
                Object obj3 = obj2;
                HomeUiState homeUiState2 = homeUiState;
                int i7 = i6;
                int i8 = i4;
                isPrivacyAccepted = obj;
                if (i5 == 0) {
                    i = i7;
                    z = i3;
                } else {
                    i = i7;
                    z = 0;
                }
                boolean z2 = i == 0 ? i3 : 0;
                boolean booleanValue = ((Boolean) isPrivacyAccepted).booleanValue();
                mutableStateFlow = mutableStateFlow3;
                if (!mutableStateFlow.compareAndSet(obj3, HomeUiState.copy$default(homeUiState2, i8, z, null, null, null, null, null, null, null, null, null, z2, booleanValue, false, 0, false, false, false, 258047, null))) {
                    i3 = 1;
                    MutableStateFlow mutableStateFlow4 = mutableStateFlow;
                    Object value = mutableStateFlow4.getValue();
                    HomeUiState homeUiState3 = (HomeUiState) value;
                    privacyinteractor = this.this$0.privacyInteractor;
                    this.L$0 = mutableStateFlow4;
                    this.L$1 = value;
                    this.L$2 = homeUiState3;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.label = i3;
                    isPrivacyAccepted = privacyinteractor.isPrivacyAccepted(this);
                    if (isPrivacyAccepted != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i5 = 0;
                    i8 = 0;
                    mutableStateFlow3 = mutableStateFlow4;
                    obj3 = value;
                    homeUiState2 = homeUiState3;
                    i7 = 0;
                    if (i5 == 0) {
                    }
                    if (i == 0) {
                    }
                    boolean booleanValue2 = ((Boolean) isPrivacyAccepted).booleanValue();
                    mutableStateFlow = mutableStateFlow3;
                    if (!mutableStateFlow.compareAndSet(obj3, HomeUiState.copy$default(homeUiState2, i8, z, null, null, null, null, null, null, null, null, null, z2, booleanValue2, false, 0, false, false, false, 258047, null))) {
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        HomeComponent$initVmState$$inlined$launchSafe$default$1 homeComponent$initVmState$$inlined$launchSafe$default$1 = this;
        mutableStateFlow = this.this$0.stateStore;
        MutableStateFlow mutableStateFlow42 = mutableStateFlow;
        Object value2 = mutableStateFlow42.getValue();
        HomeUiState homeUiState32 = (HomeUiState) value2;
        privacyinteractor = this.this$0.privacyInteractor;
        this.L$0 = mutableStateFlow42;
        this.L$1 = value2;
        this.L$2 = homeUiState32;
        this.I$0 = 0;
        this.I$1 = 0;
        this.I$2 = 0;
        this.label = i3;
        isPrivacyAccepted = privacyinteractor.isPrivacyAccepted(this);
        if (isPrivacyAccepted != coroutine_suspended) {
        }
    }
}

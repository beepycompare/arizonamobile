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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$initVmState$$inlined$launchSafe$default$1", f = "HomeComponent.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {32, 33}, m = "invokeSuspend", n = {"$this$launch", "$completion", "$this$initVmState_u24lambda_u240", "$this$update$iv", "prevValue$iv", "it", "$this$launch", "$completion", "$this$initVmState_u24lambda_u240", "$this$update$iv", "prevValue$iv", "it"}, nl = {31, 31}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
/* loaded from: classes5.dex */
public final class HomeComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
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
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015f  */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0109 -> B:9:0x0040). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HomeComponent$initVmState$$inlined$launchSafe$default$1 homeComponent$initVmState$$inlined$launchSafe$default$1;
        MutableStateFlow mutableStateFlow;
        CoroutineScope coroutineScope;
        Continuation continuation;
        CoroutineScope coroutineScope2;
        MutableStateFlow mutableStateFlow2;
        Object obj2;
        Object obj3;
        int i;
        int i2;
        int i3;
        HomeUiState homeUiState;
        HomeUiState homeUiState2;
        privacyInteractor privacyinteractor;
        char c;
        Object isFirstDownload;
        privacyInteractor privacyinteractor2;
        CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        int i5 = 1;
        try {
        } catch (Exception e) {
            this.receiver$inlined.handleError(e);
        }
        if (i4 != 0) {
            if (i4 == 1) {
                int i6 = this.I$2;
                int i7 = this.I$1;
                int i8 = this.I$0;
                HomeUiState homeUiState3 = (HomeUiState) this.L$6;
                HomeUiState homeUiState4 = (HomeUiState) this.L$5;
                Object obj4 = this.L$4;
                MutableStateFlow mutableStateFlow3 = (MutableStateFlow) this.L$3;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$2;
                Continuation continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                i3 = i6;
                homeUiState2 = homeUiState4;
                i = i8;
                i2 = i7;
                homeUiState = homeUiState3;
                continuation = continuation2;
                coroutineScope2 = coroutineScope4;
                mutableStateFlow2 = mutableStateFlow3;
                obj2 = obj4;
                obj3 = obj;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                privacyinteractor = this.this$0.privacyInteractor;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                this.L$3 = mutableStateFlow2;
                this.L$4 = obj2;
                this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
                this.L$6 = homeUiState;
                this.I$0 = i;
                this.I$1 = i2;
                this.I$2 = i3;
                this.Z$0 = booleanValue;
                this.I$3 = 0;
                c = 2;
                this.label = 2;
                isFirstDownload = privacyinteractor.isFirstDownload(this);
                if (isFirstDownload != coroutine_suspended) {
                }
                return coroutine_suspended;
            } else if (i4 == 2) {
                int i9 = this.I$3;
                boolean z = this.Z$0;
                i3 = this.I$2;
                i2 = this.I$1;
                i = this.I$0;
                HomeUiState homeUiState5 = (HomeUiState) this.L$6;
                HomeUiState homeUiState6 = (HomeUiState) this.L$5;
                obj2 = this.L$4;
                mutableStateFlow2 = (MutableStateFlow) this.L$3;
                coroutineScope2 = (CoroutineScope) this.L$2;
                continuation = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                int i10 = i9;
                c = 2;
                boolean z2 = z;
                HomeUiState homeUiState7 = homeUiState5;
                isFirstDownload = obj;
                int i11 = i3;
                mutableStateFlow = mutableStateFlow2;
                coroutineScope = coroutineScope2;
                if (!mutableStateFlow.compareAndSet(obj2, HomeUiState.copy$default(homeUiState7, i11, i2 == 0, null, null, null, null, null, null, null, null, null, i == 0, z2, i10 == 0, ((Boolean) isFirstDownload).booleanValue(), 0, false, false, false, 0, 0, 0, null, null, 16756735, null))) {
                    homeComponent$initVmState$$inlined$launchSafe$default$1 = continuation;
                    i5 = 1;
                    Object value = mutableStateFlow.getValue();
                    HomeUiState homeUiState8 = (HomeUiState) value;
                    privacyinteractor2 = this.this$0.privacyInteractor;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(homeComponent$initVmState$$inlined$launchSafe$default$1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$3 = mutableStateFlow;
                    this.L$4 = value;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState8);
                    this.L$6 = homeUiState8;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.label = i5;
                    obj3 = privacyinteractor2.isPrivacyAccepted(this);
                    if (obj3 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    continuation = homeComponent$initVmState$$inlined$launchSafe$default$1;
                    mutableStateFlow2 = mutableStateFlow;
                    coroutineScope2 = coroutineScope;
                    obj2 = value;
                    homeUiState2 = homeUiState8;
                    homeUiState = homeUiState2;
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    boolean booleanValue2 = ((Boolean) obj3).booleanValue();
                    privacyinteractor = this.this$0.privacyInteractor;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                    this.L$3 = mutableStateFlow2;
                    this.L$4 = obj2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
                    this.L$6 = homeUiState;
                    this.I$0 = i;
                    this.I$1 = i2;
                    this.I$2 = i3;
                    this.Z$0 = booleanValue2;
                    this.I$3 = 0;
                    c = 2;
                    this.label = 2;
                    isFirstDownload = privacyinteractor.isFirstDownload(this);
                    if (isFirstDownload != coroutine_suspended) {
                        i10 = 0;
                        homeUiState7 = homeUiState;
                        z2 = booleanValue2;
                        int i112 = i3;
                        mutableStateFlow = mutableStateFlow2;
                        coroutineScope = coroutineScope2;
                        if (!mutableStateFlow.compareAndSet(obj2, HomeUiState.copy$default(homeUiState7, i112, i2 == 0, null, null, null, null, null, null, null, null, null, i == 0, z2, i10 == 0, ((Boolean) isFirstDownload).booleanValue(), 0, false, false, false, 0, 0, 0, null, null, 16756735, null))) {
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        homeComponent$initVmState$$inlined$launchSafe$default$1 = this;
        mutableStateFlow = this.this$0.stateStore;
        coroutineScope = coroutineScope3;
        Object value2 = mutableStateFlow.getValue();
        HomeUiState homeUiState82 = (HomeUiState) value2;
        privacyinteractor2 = this.this$0.privacyInteractor;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
        this.L$1 = SpillingKt.nullOutSpilledVariable(homeComponent$initVmState$$inlined$launchSafe$default$1);
        this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$3 = mutableStateFlow;
        this.L$4 = value2;
        this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState82);
        this.L$6 = homeUiState82;
        this.I$0 = 0;
        this.I$1 = 0;
        this.I$2 = 0;
        this.label = i5;
        obj3 = privacyinteractor2.isPrivacyAccepted(this);
        if (obj3 != coroutine_suspended) {
        }
    }
}

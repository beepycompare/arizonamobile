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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$initVmState$$inlined$launchSafe$default$1", f = "HomeComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {32, 33}, m = "invokeSuspend", n = {"$this$launch", "$completion", "$this$initVmState_u24lambda_u240", "$this$update$iv", "prevValue$iv", "it", "$i$a$-launchSafe$default-HomeComponent$initVmState$2", "$i$f$update", "$i$a$-update-HomeComponent$initVmState$2$1", "$this$launch", "$completion", "$this$initVmState_u24lambda_u240", "$this$update$iv", "prevValue$iv", "it", "$i$a$-launchSafe$default-HomeComponent$initVmState$2", "$i$f$update", "$i$a$-update-HomeComponent$initVmState$2$1"}, nl = {31, 31}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 2)
/* loaded from: classes4.dex */
public final class HomeComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
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
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018d  */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0132 -> B:24:0x013e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HomeComponent$initVmState$$inlined$launchSafe$default$1 homeComponent$initVmState$$inlined$launchSafe$default$1;
        MutableStateFlow mutableStateFlow;
        CoroutineScope coroutineScope;
        int i;
        int i2;
        HomeUiState homeUiState;
        int i3;
        int i4;
        Object obj2;
        HomeUiState homeUiState2;
        Object obj3;
        int i5;
        int i6;
        int i7;
        MutableStateFlow mutableStateFlow2;
        Continuation continuation;
        CoroutineScope coroutineScope2;
        int i8;
        CoroutineScope coroutineScope3;
        privacyInteractor privacyinteractor;
        int i9;
        Object isFirstDownload;
        privacyInteractor privacyinteractor2;
        CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        int i11 = 0;
        try {
        } catch (Exception e) {
            this.receiver$inlined.handleError(e);
        }
        if (i10 != 0) {
            if (i10 == 1) {
                int i12 = this.I$5;
                int i13 = this.I$4;
                int i14 = this.I$3;
                i7 = this.I$2;
                int i15 = this.I$1;
                int i16 = this.I$0;
                HomeUiState homeUiState3 = (HomeUiState) this.L$6;
                homeUiState2 = (HomeUiState) this.L$5;
                obj2 = this.L$4;
                MutableStateFlow mutableStateFlow3 = (MutableStateFlow) this.L$3;
                CoroutineScope coroutineScope5 = (CoroutineScope) this.L$2;
                Continuation continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                i5 = i13;
                coroutineScope2 = coroutineScope5;
                i3 = i16;
                mutableStateFlow2 = mutableStateFlow3;
                i4 = i15;
                i6 = i12;
                i8 = i14;
                continuation = continuation2;
                homeUiState = homeUiState3;
                obj3 = obj;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                coroutineScope3 = coroutineScope4;
                privacyinteractor = this.this$0.privacyInteractor;
                CoroutineScope coroutineScope6 = coroutineScope2;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope6);
                this.L$3 = mutableStateFlow2;
                this.L$4 = obj2;
                this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
                this.L$6 = homeUiState;
                this.I$0 = i3;
                this.I$1 = i4;
                this.I$2 = i7;
                this.I$3 = i8;
                this.I$4 = i5;
                this.I$5 = i6;
                this.Z$0 = booleanValue;
                i9 = 0;
                this.I$6 = 0;
                this.label = 2;
                isFirstDownload = privacyinteractor.isFirstDownload(this);
                if (isFirstDownload != coroutine_suspended) {
                }
                return coroutine_suspended;
            } else if (i10 == 2) {
                int i17 = this.I$6;
                boolean z = this.Z$0;
                int i18 = this.I$5;
                i5 = this.I$4;
                int i19 = this.I$3;
                int i20 = this.I$1;
                int i21 = this.I$0;
                HomeUiState homeUiState4 = (HomeUiState) this.L$6;
                HomeUiState homeUiState5 = (HomeUiState) this.L$5;
                Object obj4 = this.L$4;
                MutableStateFlow mutableStateFlow4 = (MutableStateFlow) this.L$3;
                CoroutineScope coroutineScope7 = (CoroutineScope) this.L$2;
                continuation = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope8 = coroutineScope7;
                i9 = 0;
                i3 = i21;
                obj2 = obj4;
                coroutineScope3 = coroutineScope4;
                boolean z2 = z;
                int i22 = i18;
                i2 = i20;
                HomeUiState homeUiState6 = homeUiState4;
                isFirstDownload = obj;
                if (!mutableStateFlow4.compareAndSet(obj2, HomeUiState.copy$default(homeUiState6, i22, i5 == 0 ? 1 : i9, null, null, null, null, null, null, null, null, null, i19 == 0 ? 1 : i9, z2, i17 == 0 ? 1 : i9, ((Boolean) isFirstDownload).booleanValue(), 0, false, false, false, 0, 0, 0, null, null, 16756735, null))) {
                    homeComponent$initVmState$$inlined$launchSafe$default$1 = continuation;
                    coroutineScope = coroutineScope8;
                    i = i3;
                    coroutineScope4 = coroutineScope3;
                    i11 = i9;
                    mutableStateFlow = mutableStateFlow4;
                    Object value = mutableStateFlow.getValue();
                    homeUiState2 = (HomeUiState) value;
                    privacyinteractor2 = this.this$0.privacyInteractor;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(homeComponent$initVmState$$inlined$launchSafe$default$1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$3 = mutableStateFlow;
                    this.L$4 = value;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
                    this.L$6 = homeUiState2;
                    this.I$0 = i;
                    this.I$1 = i2;
                    this.I$2 = i11;
                    this.I$3 = i11;
                    this.I$4 = i11;
                    this.I$5 = i11;
                    this.label = 1;
                    obj3 = privacyinteractor2.isPrivacyAccepted(this);
                    if (obj3 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i3 = i;
                    i4 = i2;
                    obj2 = value;
                    homeUiState = homeUiState2;
                    i7 = i11;
                    i6 = i7;
                    i5 = i6;
                    mutableStateFlow2 = mutableStateFlow;
                    coroutineScope2 = coroutineScope;
                    continuation = homeComponent$initVmState$$inlined$launchSafe$default$1;
                    i8 = i5;
                    boolean booleanValue2 = ((Boolean) obj3).booleanValue();
                    coroutineScope3 = coroutineScope4;
                    privacyinteractor = this.this$0.privacyInteractor;
                    CoroutineScope coroutineScope62 = coroutineScope2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope62);
                    this.L$3 = mutableStateFlow2;
                    this.L$4 = obj2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
                    this.L$6 = homeUiState;
                    this.I$0 = i3;
                    this.I$1 = i4;
                    this.I$2 = i7;
                    this.I$3 = i8;
                    this.I$4 = i5;
                    this.I$5 = i6;
                    this.Z$0 = booleanValue2;
                    i9 = 0;
                    this.I$6 = 0;
                    this.label = 2;
                    isFirstDownload = privacyinteractor.isFirstDownload(this);
                    if (isFirstDownload != coroutine_suspended) {
                        i22 = i6;
                        z2 = booleanValue2;
                        i2 = i4;
                        homeUiState6 = homeUiState;
                        i19 = i8;
                        i17 = 0;
                        mutableStateFlow4 = mutableStateFlow2;
                        coroutineScope8 = coroutineScope62;
                        if (!mutableStateFlow4.compareAndSet(obj2, HomeUiState.copy$default(homeUiState6, i22, i5 == 0 ? 1 : i9, null, null, null, null, null, null, null, null, null, i19 == 0 ? 1 : i9, z2, i17 == 0 ? 1 : i9, ((Boolean) isFirstDownload).booleanValue(), 0, false, false, false, 0, 0, 0, null, null, 16756735, null))) {
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
        coroutineScope = coroutineScope4;
        i = 0;
        i2 = 0;
        Object value2 = mutableStateFlow.getValue();
        homeUiState2 = (HomeUiState) value2;
        privacyinteractor2 = this.this$0.privacyInteractor;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
        this.L$1 = SpillingKt.nullOutSpilledVariable(homeComponent$initVmState$$inlined$launchSafe$default$1);
        this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$3 = mutableStateFlow;
        this.L$4 = value2;
        this.L$5 = SpillingKt.nullOutSpilledVariable(homeUiState2);
        this.L$6 = homeUiState2;
        this.I$0 = i;
        this.I$1 = i2;
        this.I$2 = i11;
        this.I$3 = i11;
        this.I$4 = i11;
        this.I$5 = i11;
        this.label = 1;
        obj3 = privacyinteractor2.isPrivacyAccepted(this);
        if (obj3 != coroutine_suspended) {
        }
    }
}

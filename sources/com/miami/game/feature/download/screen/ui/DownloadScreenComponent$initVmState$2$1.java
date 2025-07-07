package com.miami.game.feature.download.screen.ui;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: DownloadScreenComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.DownloadScreenComponent$initVmState$2$1", f = "DownloadScreenComponent.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DownloadScreenComponent$initVmState$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadScreenComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadScreenComponent$initVmState$2$1(DownloadScreenComponent downloadScreenComponent, Continuation<? super DownloadScreenComponent$initVmState$2$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadScreenComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadScreenComponent$initVmState$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadScreenComponent$initVmState$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        Object withContext;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            this.label = 1;
            withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloadScreenComponent$initVmState$2$1$invokeSuspend$$inlined$getSuspend$1(localRepository, "sound_key", null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            withContext = obj;
        }
        Boolean bool = (Boolean) withContext;
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DownloadScreenUiState.copy$default((DownloadScreenUiState) value, null, null, null, false, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, booleanValue, false, false, 0, 1919, null)));
        return Unit.INSTANCE;
    }
}

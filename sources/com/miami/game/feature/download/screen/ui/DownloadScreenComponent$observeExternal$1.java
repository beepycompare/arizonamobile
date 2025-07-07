package com.miami.game.feature.download.screen.ui;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiState;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
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
/* compiled from: DownloadScreenComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/feature/download/screen/ui/model/DownloadExternalUiState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.DownloadScreenComponent$observeExternal$1", f = "DownloadScreenComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloadScreenComponent$observeExternal$1 extends SuspendLambda implements Function2<DownloadExternalUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadScreenComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadScreenComponent$observeExternal$1(DownloadScreenComponent downloadScreenComponent, Continuation<? super DownloadScreenComponent$observeExternal$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadScreenComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadScreenComponent$observeExternal$1 downloadScreenComponent$observeExternal$1 = new DownloadScreenComponent$observeExternal$1(this.this$0, continuation);
        downloadScreenComponent$observeExternal$1.L$0 = obj;
        return downloadScreenComponent$observeExternal$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DownloadExternalUiState downloadExternalUiState, Continuation<? super Unit> continuation) {
        return ((DownloadScreenComponent$observeExternal$1) create(downloadExternalUiState, continuation)).invokeSuspend(Unit.INSTANCE);
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
        DownloadExternalUiState downloadExternalUiState = (DownloadExternalUiState) this.L$0;
        Timber.Forest.d("mainStateStore " + downloadExternalUiState, new Object[0]);
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
            Timber.Forest.d(downloadExternalUiState.toString(), new Object[0]);
        } while (!mutableStateFlow.compareAndSet(value, DownloadScreenUiState.copy$default((DownloadScreenUiState) value, downloadExternalUiState.getTextDownload(), downloadExternalUiState.getTimeRemainingString(), downloadExternalUiState.getDownloadingStringState(), false, false, downloadExternalUiState.getPercentageProgress(), null, false, downloadExternalUiState.isDialogVisible(), downloadExternalUiState.isLauncherUpdate(), 0, 1240, null)));
        return Unit.INSTANCE;
    }
}

package com.miami.game.feature.download.screen.ui;

import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
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
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1", f = "DownloadScreenComponent.kt", i = {0, 0, 0, 0}, l = {27}, m = "invokeSuspend", n = {"$this$launch", "$completion", "$this$onCancelDownloadGame_u24lambda_u243", "$i$a$-launchSafe$default-DownloadScreenComponent$onCancelDownloadGame$2"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes4.dex */
public final class DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DownloadScreenComponent receiver$inlined;
    final /* synthetic */ DownloadScreenComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1(Continuation continuation, DownloadScreenComponent downloadScreenComponent, DownloadScreenComponent downloadScreenComponent2) {
        super(2, continuation);
        this.this$0 = downloadScreenComponent;
        this.receiver$inlined = downloadScreenComponent2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1 downloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1 = new DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1(continuation, this.this$0, this.receiver$inlined);
        downloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1.L$0 = obj;
        return downloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FilesUpdaterInteractor filesUpdaterInteractor;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                filesUpdaterInteractor = this.this$0.filesUpdaterInteractor;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(this);
                this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                if (filesUpdaterInteractor.cancelDownload(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$2;
                Continuation continuation = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            this.receiver$inlined.handleError(e);
        }
        return Unit.INSTANCE;
    }
}

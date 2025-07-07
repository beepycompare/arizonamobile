package com.miami.game.core.files.updater.domain;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.downloader.sync.DownloaderState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/downloader/sync/DownloaderState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor$observerDatabaseState$1", f = "FilesUpdaterInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilesUpdaterInteractor$observerDatabaseState$1 extends SuspendLambda implements Function2<DownloaderState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$observerDatabaseState$1(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$observerDatabaseState$1> continuation) {
        super(2, continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FilesUpdaterInteractor$observerDatabaseState$1 filesUpdaterInteractor$observerDatabaseState$1 = new FilesUpdaterInteractor$observerDatabaseState$1(this.this$0, continuation);
        filesUpdaterInteractor$observerDatabaseState$1.L$0 = obj;
        return filesUpdaterInteractor$observerDatabaseState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DownloaderState downloaderState, Continuation<? super Unit> continuation) {
        return ((FilesUpdaterInteractor$observerDatabaseState$1) create(downloaderState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.updateState((DownloaderState) this.L$0);
        return Unit.INSTANCE;
    }
}

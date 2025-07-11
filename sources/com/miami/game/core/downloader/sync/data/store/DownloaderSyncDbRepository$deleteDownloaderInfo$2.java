package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.downloader.database.DownloaderInfoDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncDbRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$deleteDownloaderInfo$2", f = "DownloaderSyncDbRepository.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncDbRepository$deleteDownloaderInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ DownloaderSyncDbRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncDbRepository$deleteDownloaderInfo$2(String str, DownloaderSyncDbRepository downloaderSyncDbRepository, Continuation<? super DownloaderSyncDbRepository$deleteDownloaderInfo$2> continuation) {
        super(2, continuation);
        this.$name = str;
        this.this$0 = downloaderSyncDbRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncDbRepository$deleteDownloaderInfo$2(this.$name, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloaderSyncDbRepository$deleteDownloaderInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloaderInfoDatabase downloaderInfoDatabase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$name != null) {
                downloaderInfoDatabase = this.this$0.database;
                this.label = 1;
                if (downloaderInfoDatabase.downloaderInfoDao().deleteDownloaderInfo(this.$name, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

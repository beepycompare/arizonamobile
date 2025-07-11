package com.miami.game.core.downloader.sync.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.DownloaderSyncRepository$downloadFiles$2", f = "DownloaderSyncRepository.kt", i = {2}, l = {63, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 70}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class DownloaderSyncRepository$downloadFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ long $currentTime;
    final /* synthetic */ GameInfoFile $gameInfoFile;
    Object L$0;
    int label;
    final /* synthetic */ DownloaderSyncRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncRepository$downloadFiles$2(GameInfoFile gameInfoFile, DownloaderSyncRepository downloaderSyncRepository, long j, Continuation<? super DownloaderSyncRepository$downloadFiles$2> continuation) {
        super(2, continuation);
        this.$gameInfoFile = gameInfoFile;
        this.this$0 = downloaderSyncRepository;
        this.$currentTime = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncRepository$downloadFiles$2(this.$gameInfoFile, this.this$0, this.$currentTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((DownloaderSyncRepository$downloadFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r8.deleteDownloaderInfo(r7.$gameInfoFile.getName(), r7) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
        if (r8 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncDbRepository downloaderSyncDbRepository;
        DownloaderSyncApiRepository downloaderSyncApiRepository;
        DownloaderSyncDbRepository downloaderSyncDbRepository2;
        DownloaderInfoDbModel downloaderInfoDbModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("Загрузка начата " + this.$gameInfoFile.getName(), new Object[0]);
            downloaderSyncDbRepository = this.this$0.dbRepository;
            this.label = 1;
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    downloaderInfoDbModel = (DownloaderInfoDbModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxLong(downloaderInfoDbModel.getId());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DownloaderInfoDbModel downloaderInfoDbModel2 = (DownloaderInfoDbModel) obj;
            downloaderSyncDbRepository2 = this.this$0.dbRepository;
            this.L$0 = downloaderInfoDbModel2;
            this.label = 3;
            if (downloaderSyncDbRepository2.saveDownloaderInfoDbModel(downloaderInfoDbModel2, this) != coroutine_suspended) {
                downloaderInfoDbModel = downloaderInfoDbModel2;
                return Boxing.boxLong(downloaderInfoDbModel.getId());
            }
            return coroutine_suspended;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        downloaderSyncApiRepository = this.this$0.apiRepository;
        this.label = 2;
        obj = downloaderSyncApiRepository.downloadFile(this.$gameInfoFile, this.$currentTime, this);
    }
}

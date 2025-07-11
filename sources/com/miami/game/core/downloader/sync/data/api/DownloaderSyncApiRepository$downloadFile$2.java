package com.miami.game.core.downloader.sync.data.api;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncApiRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository$downloadFile$2", f = "DownloaderSyncApiRepository.kt", i = {1}, l = {73, 74}, m = "invokeSuspend", n = {"url"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class DownloaderSyncApiRepository$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DownloaderInfoDbModel>, Object> {
    final /* synthetic */ long $currentTime;
    final /* synthetic */ GameInfoFile $gameInfoFile;
    Object L$0;
    int label;
    final /* synthetic */ DownloaderSyncApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncApiRepository$downloadFile$2(DownloaderSyncApiRepository downloaderSyncApiRepository, GameInfoFile gameInfoFile, long j, Continuation<? super DownloaderSyncApiRepository$downloadFile$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncApiRepository;
        this.$gameInfoFile = gameInfoFile;
        this.$currentTime = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncApiRepository$downloadFile$2(this.this$0, this.$gameInfoFile, this.$currentTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DownloaderInfoDbModel> continuation) {
        return ((DownloaderSyncApiRepository$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r14 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        if (r14 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ConnectionResolver connectionResolver;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            connectionResolver = this.this$0.connectionResolver;
            this.label = 1;
            obj = connectionResolver.getDownloadFilesChannel(-1, this);
        } else if (i != 1) {
            if (i == 2) {
                String str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                return new DownloaderInfoDbModel(((Number) obj).longValue(), this.$gameInfoFile.getPath(), this.$gameInfoFile.getName(), this.$gameInfoFile.getSize(), this.$gameInfoFile.getHash(), this.$gameInfoFile.getDateChange(), this.$gameInfoFile.getGpuType(), false, Boxing.boxLong(this.$currentTime), null, Boxing.boxLong(System.currentTimeMillis()));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        String str2 = (String) ((Pair) obj).component1();
        DownloaderSyncApiRepository downloaderSyncApiRepository = this.this$0;
        String path = this.$gameInfoFile.getPath();
        this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
        this.label = 2;
        obj = downloaderSyncApiRepository.downloadFile(str2 + path, this.$gameInfoFile.getLocalPath(), this);
    }
}

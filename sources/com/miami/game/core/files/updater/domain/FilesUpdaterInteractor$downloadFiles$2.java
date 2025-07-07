package com.miami.game.core.files.updater.domain;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import com.miami.game.core.files.updater.domain.model.CheckedFile;
import com.miami.game.core.files.updater.domain.model.FilesUpdaterState;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor$downloadFiles$2", f = "FilesUpdaterInteractor.kt", i = {}, l = {SubsamplingScaleImageView.ORIENTATION_270}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$downloadFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentTime;
    int label;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$downloadFiles$2(FilesUpdaterInteractor filesUpdaterInteractor, long j, Continuation<? super FilesUpdaterInteractor$downloadFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = filesUpdaterInteractor;
        this.$currentTime = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesUpdaterInteractor$downloadFiles$2(this.this$0, this.$currentTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesUpdaterInteractor$downloadFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        LinkedList linkedList;
        DownloaderSyncInteractor downloaderSyncInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default((FilesUpdaterState) value, 0L, null, 0L, null, 0L, false, false, true, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 8031, null)));
            linkedList = this.this$0.gameInfoFilesCheckedList;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : linkedList) {
                if (!((CheckedFile) obj2).isDownloadedAndChecked()) {
                    arrayList.add(obj2);
                }
            }
            ArrayList<CheckedFile> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (CheckedFile checkedFile : arrayList2) {
                arrayList3.add(checkedFile.getGameInfoFile());
            }
            downloaderSyncInteractor = this.this$0.downloaderSyncInteractor;
            this.label = 1;
            if (downloaderSyncInteractor.downloadFiles(arrayList3, this.$currentTime, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

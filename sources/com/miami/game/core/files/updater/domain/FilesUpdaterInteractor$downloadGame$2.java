package com.miami.game.core.files.updater.domain;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor$downloadGame$2", f = "FilesUpdaterInteractor.kt", i = {}, l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$downloadGame$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    int label;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$downloadGame$2(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$downloadGame$2> continuation) {
        super(2, continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesUpdaterInteractor$downloadGame$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((FilesUpdaterInteractor$downloadGame$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object downloadFiles;
        Job collectBytes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            downloadFiles = this.this$0.downloadFiles(System.currentTimeMillis(), this);
            if (downloadFiles == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        collectBytes = this.this$0.collectBytes();
        return collectBytes;
    }
}

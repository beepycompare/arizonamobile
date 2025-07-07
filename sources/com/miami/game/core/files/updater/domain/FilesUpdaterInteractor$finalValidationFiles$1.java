package com.miami.game.core.files.updater.domain;

import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor", f = "FilesUpdaterInteractor.kt", i = {2, 2, 2, 3, 3, 3}, l = {376, 377, 386, 387, Constants.STATUS_LENGTH_REQUIRED}, m = "finalValidationFiles", n = {"files", "setFiles", "it", "files", "setFiles", "it"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$finalValidationFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$finalValidationFiles$1(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$finalValidationFiles$1> continuation) {
        super(continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object finalValidationFiles;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        finalValidationFiles = this.this$0.finalValidationFiles(this);
        return finalValidationFiles;
    }
}

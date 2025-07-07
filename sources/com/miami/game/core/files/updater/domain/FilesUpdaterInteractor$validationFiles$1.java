package com.miami.game.core.files.updater.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor", f = "FilesUpdaterInteractor.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5}, l = {300, 305, TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 365, 370}, m = "validationFiles", n = {"gameInfoFiles", "gameInfoFiles", "newGameInfoFiles", "gameInfoFiles", "newGameInfoFiles", "files", "setFiles", "loadedFile", "gameInfoFiles", "newGameInfoFiles", "files", "setFiles", "loadedFile", "newGameInfoFiles", "newGameInfoFiles"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$0"})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$validationFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$validationFiles$1(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$validationFiles$1> continuation) {
        super(continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object validationFiles;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        validationFiles = this.this$0.validationFiles(null, this);
        return validationFiles;
    }
}

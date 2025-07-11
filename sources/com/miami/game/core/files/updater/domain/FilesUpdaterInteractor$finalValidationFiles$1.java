package com.miami.game.core.files.updater.domain;

import androidx.compose.runtime.ComposerKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor", f = "FilesUpdaterInteractor.kt", i = {2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4}, l = {178, 179, TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1, ComposerKt.reuseKey}, m = "finalValidationFiles", n = {"files", "setFiles", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-FilesUpdaterInteractor$finalValidationFiles$3", "files", "setFiles", "$this$forEach$iv", "element$iv", "it", "destinationUri", "$i$f$forEach", "$i$a$-forEach-FilesUpdaterInteractor$finalValidationFiles$3", "files", "setFiles", "filesToDelete"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$finalValidationFiles$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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

package com.miami.game.core.files.updater.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor", f = "FilesUpdaterInteractor.kt", i = {}, l = {282, 283}, m = "checkUpdateIsNeeded", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$checkUpdateIsNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$checkUpdateIsNeeded$1(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$checkUpdateIsNeeded$1> continuation) {
        super(continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkUpdateIsNeeded;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkUpdateIsNeeded = this.this$0.checkUpdateIsNeeded(this);
        return checkUpdateIsNeeded;
    }
}

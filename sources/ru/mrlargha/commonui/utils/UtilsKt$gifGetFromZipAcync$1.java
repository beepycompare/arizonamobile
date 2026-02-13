package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0}, l = {626}, m = "gifGetFromZipAcync", n = {"$this$gifGetFromZipAcync", "imageView", "folderName", "item"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
/* loaded from: classes6.dex */
public final class UtilsKt$gifGetFromZipAcync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UtilsKt$gifGetFromZipAcync$1(Continuation<? super UtilsKt$gifGetFromZipAcync$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.gifGetFromZipAcync(null, null, null, null, this);
    }
}

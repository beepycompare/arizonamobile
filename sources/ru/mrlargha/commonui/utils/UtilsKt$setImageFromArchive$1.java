package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt", f = "Utils.kt", i = {0, 0, 0}, l = {625}, m = "setImageFromArchive", n = {"$this$setImageFromArchive", "folderName", "item"}, nl = {628}, s = {"L$0", "L$1", "I$0"}, v = 2)
/* loaded from: classes6.dex */
public final class UtilsKt$setImageFromArchive$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UtilsKt$setImageFromArchive$1(Continuation<? super UtilsKt$setImageFromArchive$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.setImageFromArchive(null, null, 0, this);
    }
}

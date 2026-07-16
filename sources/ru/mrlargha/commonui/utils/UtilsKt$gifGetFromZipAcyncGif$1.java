package ru.mrlargha.commonui.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt", f = "Utils.kt", i = {0, 0, 0}, l = {601}, m = "gifGetFromZipAcyncGif", n = {"$this$gifGetFromZipAcyncGif", "folderName", "item"}, nl = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR}, s = {"L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes6.dex */
public final class UtilsKt$gifGetFromZipAcyncGif$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UtilsKt$gifGetFromZipAcyncGif$1(Continuation<? super UtilsKt$gifGetFromZipAcyncGif$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.gifGetFromZipAcyncGif(null, null, null, this);
    }
}

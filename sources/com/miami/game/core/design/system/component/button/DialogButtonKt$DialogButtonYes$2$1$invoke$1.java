package com.miami.game.core.design.system.component.button;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogButton.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.button.DialogButtonKt$DialogButtonYes$2$1", f = "DialogButton.kt", i = {0}, l = {86}, m = "invoke", n = {"$this$pointerInput"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class DialogButtonKt$DialogButtonYes$2$1$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialogButtonKt$DialogButtonYes$2$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogButtonKt$DialogButtonYes$2$1$invoke$1(DialogButtonKt$DialogButtonYes$2$1 dialogButtonKt$DialogButtonYes$2$1, Continuation<? super DialogButtonKt$DialogButtonYes$2$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = dialogButtonKt$DialogButtonYes$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}

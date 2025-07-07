package com.miami.game.core.design.system.component.scaling_button;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScalingButton.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButton$1$1", f = "ScalingButton.kt", i = {0}, l = {30}, m = "invoke", n = {"$this$pointerInput"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class ScalingButtonKt$ScalingButton$1$1$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScalingButtonKt$ScalingButton$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalingButtonKt$ScalingButton$1$1$invoke$1(ScalingButtonKt$ScalingButton$1$1 scalingButtonKt$ScalingButton$1$1, Continuation<? super ScalingButtonKt$ScalingButton$1$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = scalingButtonKt$ScalingButton$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}

package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonContextMenuArea.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt", f = "CommonContextMenuArea.kt", i = {0}, l = {200}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"}, v = 1)
/* loaded from: classes.dex */
public final class CommonContextMenuAreaKt$getContextMenuItemsAvailability$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonContextMenuAreaKt$getContextMenuItemsAvailability$1(Continuation<? super CommonContextMenuAreaKt$getContextMenuItemsAvailability$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CommonContextMenuAreaKt.getContextMenuItemsAvailability((TextFieldSelectionState) null, this);
    }
}

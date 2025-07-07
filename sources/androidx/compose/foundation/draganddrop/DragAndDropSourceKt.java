package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"androidx/compose/foundation/draganddrop/DragAndDropSourceKt__DragAndDropSourceKt", "androidx/compose/foundation/draganddrop/DragAndDropSourceKt__LegacyDragAndDropSource_androidKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropSourceKt {
    public static final Modifier dragAndDropSource(Modifier modifier, Function1<? super Offset, DragAndDropTransferData> function1) {
        return DragAndDropSourceKt__DragAndDropSourceKt.dragAndDropSource(modifier, function1);
    }

    public static final Modifier dragAndDropSource(Modifier modifier, Function1<? super DrawScope, Unit> function1, Function1<? super Offset, DragAndDropTransferData> function12) {
        return DragAndDropSourceKt__DragAndDropSourceKt.dragAndDropSource(modifier, function1, function12);
    }

    @Deprecated(message = "Replaced by overload with a callback for obtain a transfer data,start detection is performed by Compose itself", replaceWith = @ReplaceWith(expression = "Modifier.dragAndDropSource(transferData)", imports = {}))
    public static final Modifier dragAndDropSource(Modifier modifier, Function1<? super DrawScope, Unit> function1, Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return DragAndDropSourceKt__LegacyDragAndDropSource_androidKt.dragAndDropSource(modifier, function1, function2);
    }
}

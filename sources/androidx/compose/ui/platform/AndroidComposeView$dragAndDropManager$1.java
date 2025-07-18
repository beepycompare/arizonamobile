package androidx.compose.ui.platform;

import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeView.android.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class AndroidComposeView$dragAndDropManager$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$dragAndDropManager$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(DragAndDropTransferData dragAndDropTransferData, Size size, Function1<? super DrawScope, ? extends Unit> function1) {
        return m5812invoke12SF9DM(dragAndDropTransferData, size.m3911unboximpl(), function1);
    }

    /* renamed from: invoke-12SF9DM  reason: not valid java name */
    public final Boolean m5812invoke12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        boolean m5810startDrag12SF9DM;
        m5810startDrag12SF9DM = ((AndroidComposeView) this.receiver).m5810startDrag12SF9DM(dragAndDropTransferData, j, function1);
        return Boolean.valueOf(m5810startDrag12SF9DM);
    }
}

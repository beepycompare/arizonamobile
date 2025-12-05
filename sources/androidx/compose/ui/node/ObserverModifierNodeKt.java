package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: ObserverModifierNode.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"observeReads", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier$Node;Lkotlin/jvm/functions/Function0;)V", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ObserverModifierNodeKt {
    public static final <T extends Modifier.Node & ObserverModifierNode> void observeReads(T t, Function0<Unit> function0) {
        ObserverNodeOwnerScope ownerScope$ui = t.getOwnerScope$ui();
        if (ownerScope$ui == null) {
            ownerScope$ui = new ObserverNodeOwnerScope(t);
            t.setOwnerScope$ui(ownerScope$ui);
        }
        OwnerSnapshotObserver snapshotObserver = DelegatableNodeKt.requireOwner(t).getSnapshotObserver();
        Function1<ObserverNodeOwnerScope, Unit> onObserveReadsChanged$ui = ObserverNodeOwnerScope.Companion.getOnObserveReadsChanged$ui();
        OwnerSnapshotObserver.access$getObserver$p(snapshotObserver).observeReads(ownerScope$ui, onObserveReadsChanged$ui, function0);
    }
}

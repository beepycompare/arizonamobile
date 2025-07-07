package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DepthSortedSet.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u001e\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DepthSortedSetKt {
    private static final Comparator<LayoutNode> DepthComparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSetKt$DepthComparator$1
        @Override // java.util.Comparator
        public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
            int compare = Intrinsics.compare(layoutNode.getDepth$ui_release(), layoutNode2.getDepth$ui_release());
            return compare != 0 ? compare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
        }
    };
}

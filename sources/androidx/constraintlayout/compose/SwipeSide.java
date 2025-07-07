package androidx.constraintlayout.compose;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TransitionScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/SwipeSide;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeSide {
    public static final int $stable = 0;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final SwipeSide Top = new SwipeSide("top");
    private static final SwipeSide Left = new SwipeSide(TtmlNode.LEFT);
    private static final SwipeSide Right = new SwipeSide(TtmlNode.RIGHT);
    private static final SwipeSide Bottom = new SwipeSide("bottom");
    private static final SwipeSide Middle = new SwipeSide("middle");
    private static final SwipeSide Start = new SwipeSide(TtmlNode.START);
    private static final SwipeSide End = new SwipeSide(TtmlNode.END);

    public SwipeSide(String str) {
        this.name = str;
    }

    /* compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/constraintlayout/compose/SwipeSide$Companion;", "", "()V", "Bottom", "Landroidx/constraintlayout/compose/SwipeSide;", "getBottom", "()Landroidx/constraintlayout/compose/SwipeSide;", "End", "getEnd", "Left", "getLeft", "Middle", "getMiddle", "Right", "getRight", "Start", "getStart", "Top", "getTop", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SwipeSide getTop() {
            return SwipeSide.Top;
        }

        public final SwipeSide getLeft() {
            return SwipeSide.Left;
        }

        public final SwipeSide getRight() {
            return SwipeSide.Right;
        }

        public final SwipeSide getBottom() {
            return SwipeSide.Bottom;
        }

        public final SwipeSide getMiddle() {
            return SwipeSide.Middle;
        }

        public final SwipeSide getStart() {
            return SwipeSide.Start;
        }

        public final SwipeSide getEnd() {
            return SwipeSide.End;
        }
    }

    public final String getName() {
        return this.name;
    }
}

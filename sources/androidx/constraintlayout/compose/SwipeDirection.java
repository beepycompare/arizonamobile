package androidx.constraintlayout.compose;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TransitionScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/SwipeDirection;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeDirection {
    public static final int $stable = 0;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final SwipeDirection Up = new SwipeDirection("up");
    private static final SwipeDirection Down = new SwipeDirection("down");
    private static final SwipeDirection Left = new SwipeDirection(TtmlNode.LEFT);
    private static final SwipeDirection Right = new SwipeDirection(TtmlNode.RIGHT);
    private static final SwipeDirection Start = new SwipeDirection(TtmlNode.START);
    private static final SwipeDirection End = new SwipeDirection(TtmlNode.END);
    private static final SwipeDirection Clockwise = new SwipeDirection("clockwise");
    private static final SwipeDirection Counterclockwise = new SwipeDirection("anticlockwise");

    public SwipeDirection(String str) {
        this.name = str;
    }

    /* compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/SwipeDirection$Companion;", "", "()V", "Clockwise", "Landroidx/constraintlayout/compose/SwipeDirection;", "getClockwise", "()Landroidx/constraintlayout/compose/SwipeDirection;", "Counterclockwise", "getCounterclockwise", "Down", "getDown", "End", "getEnd", "Left", "getLeft", "Right", "getRight", "Start", "getStart", "Up", "getUp", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SwipeDirection getUp() {
            return SwipeDirection.Up;
        }

        public final SwipeDirection getDown() {
            return SwipeDirection.Down;
        }

        public final SwipeDirection getLeft() {
            return SwipeDirection.Left;
        }

        public final SwipeDirection getRight() {
            return SwipeDirection.Right;
        }

        public final SwipeDirection getStart() {
            return SwipeDirection.Start;
        }

        public final SwipeDirection getEnd() {
            return SwipeDirection.End;
        }

        public final SwipeDirection getClockwise() {
            return SwipeDirection.Clockwise;
        }

        public final SwipeDirection getCounterclockwise() {
            return SwipeDirection.Counterclockwise;
        }
    }

    public final String getName() {
        return this.name;
    }
}

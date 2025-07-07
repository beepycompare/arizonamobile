package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextFieldHandleState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 %2\u00020\u0001:\u0001%B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0017\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "", "visible", "", "position", "Landroidx/compose/ui/geometry/Offset;", "lineHeight", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getHandlesCrossed", "()Z", "getLineHeight", "()F", "getPosition-F1C5BW0", "()J", "J", "getVisible", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "component5", "copy", "copy-YqVAtuI", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;Z)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldHandleState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final TextFieldHandleState Hidden = new TextFieldHandleState(false, Offset.Companion.m3852getUnspecifiedF1C5BW0(), 0.0f, ResolvedTextDirection.Ltr, false, null);
    private final ResolvedTextDirection direction;
    private final boolean handlesCrossed;
    private final float lineHeight;
    private final long position;
    private final boolean visible;

    public /* synthetic */ TextFieldHandleState(boolean z, long j, float f, ResolvedTextDirection resolvedTextDirection, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, f, resolvedTextDirection, z2);
    }

    /* renamed from: copy-YqVAtuI$default  reason: not valid java name */
    public static /* synthetic */ TextFieldHandleState m1357copyYqVAtuI$default(TextFieldHandleState textFieldHandleState, boolean z, long j, float f, ResolvedTextDirection resolvedTextDirection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textFieldHandleState.visible;
        }
        if ((i & 2) != 0) {
            j = textFieldHandleState.position;
        }
        if ((i & 4) != 0) {
            f = textFieldHandleState.lineHeight;
        }
        if ((i & 8) != 0) {
            resolvedTextDirection = textFieldHandleState.direction;
        }
        if ((i & 16) != 0) {
            z2 = textFieldHandleState.handlesCrossed;
        }
        boolean z3 = z2;
        float f2 = f;
        return textFieldHandleState.m1359copyYqVAtuI(z, j, f2, resolvedTextDirection, z3);
    }

    public final boolean component1() {
        return this.visible;
    }

    /* renamed from: component2-F1C5BW0  reason: not valid java name */
    public final long m1358component2F1C5BW0() {
        return this.position;
    }

    public final float component3() {
        return this.lineHeight;
    }

    public final ResolvedTextDirection component4() {
        return this.direction;
    }

    public final boolean component5() {
        return this.handlesCrossed;
    }

    /* renamed from: copy-YqVAtuI  reason: not valid java name */
    public final TextFieldHandleState m1359copyYqVAtuI(boolean z, long j, float f, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        return new TextFieldHandleState(z, j, f, resolvedTextDirection, z2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextFieldHandleState) {
            TextFieldHandleState textFieldHandleState = (TextFieldHandleState) obj;
            return this.visible == textFieldHandleState.visible && Offset.m3834equalsimpl0(this.position, textFieldHandleState.position) && Float.compare(this.lineHeight, textFieldHandleState.lineHeight) == 0 && this.direction == textFieldHandleState.direction && this.handlesCrossed == textFieldHandleState.handlesCrossed;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.visible) * 31) + Offset.m3839hashCodeimpl(this.position)) * 31) + Float.hashCode(this.lineHeight)) * 31) + this.direction.hashCode()) * 31) + Boolean.hashCode(this.handlesCrossed);
    }

    public String toString() {
        return "TextFieldHandleState(visible=" + this.visible + ", position=" + ((Object) Offset.m3845toStringimpl(this.position)) + ", lineHeight=" + this.lineHeight + ", direction=" + this.direction + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    private TextFieldHandleState(boolean z, long j, float f, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        this.visible = z;
        this.position = j;
        this.lineHeight = f;
        this.direction = resolvedTextDirection;
        this.handlesCrossed = z2;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m1360getPositionF1C5BW0() {
        return this.position;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    /* compiled from: TextFieldHandleState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState$Companion;", "", "()V", "Hidden", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getHidden", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextFieldHandleState getHidden() {
            return TextFieldHandleState.Hidden;
        }
    }
}

package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ContextMenuUi.android.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Landroidx/compose/ui/graphics/Color;", "textColor", "iconColor", "disabledTextColor", "disabledIconColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getIconColor-0d7_KjU", "getTextColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuColors {
    public static final int $stable = 0;
    private final long backgroundColor;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long iconColor;
    private final long textColor;

    public /* synthetic */ ContextMenuColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private ContextMenuColors(long j, long j2, long j3, long j4, long j5) {
        this.backgroundColor = j;
        this.textColor = j2;
        this.iconColor = j3;
        this.disabledTextColor = j4;
        this.disabledIconColor = j5;
    }

    /* renamed from: getBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m352getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m356getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* renamed from: getIconColor-0d7_KjU  reason: not valid java name */
    public final long m355getIconColor0d7_KjU() {
        return this.iconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m354getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: getDisabledIconColor-0d7_KjU  reason: not valid java name */
    public final long m353getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextMenuColors)) {
            return false;
        }
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
        return Color.m4079equalsimpl0(this.backgroundColor, contextMenuColors.backgroundColor) && Color.m4079equalsimpl0(this.textColor, contextMenuColors.textColor) && Color.m4079equalsimpl0(this.iconColor, contextMenuColors.iconColor) && Color.m4079equalsimpl0(this.disabledTextColor, contextMenuColors.disabledTextColor) && Color.m4079equalsimpl0(this.disabledIconColor, contextMenuColors.disabledIconColor);
    }

    public int hashCode() {
        return (((((((Color.m4085hashCodeimpl(this.backgroundColor) * 31) + Color.m4085hashCodeimpl(this.textColor)) * 31) + Color.m4085hashCodeimpl(this.iconColor)) * 31) + Color.m4085hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4085hashCodeimpl(this.disabledIconColor);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + ((Object) Color.m4086toStringimpl(this.backgroundColor)) + ", textColor=" + ((Object) Color.m4086toStringimpl(this.textColor)) + ", iconColor=" + ((Object) Color.m4086toStringimpl(this.iconColor)) + ", disabledTextColor=" + ((Object) Color.m4086toStringimpl(this.disabledTextColor)) + ", disabledIconColor=" + ((Object) Color.m4086toStringimpl(this.disabledIconColor)) + ')';
    }
}

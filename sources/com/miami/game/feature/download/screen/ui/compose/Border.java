package com.miami.game.feature.download.screen.ui.compose;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ProgressBar.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/compose/Border;", "", "wight", "", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(FJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWight", "()F", "getColor-0d7_KjU", "()J", "J", "component1", "component2", "component2-0d7_KjU", "copy", "copy-4WTKRHQ", "(FJ)Lcom/miami/game/feature/download/screen/ui/compose/Border;", "equals", "", "other", "hashCode", "", "toString", "", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Border {
    public static final int $stable = 0;
    private final long color;
    private final float wight;

    public /* synthetic */ Border(float f, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, j);
    }

    /* renamed from: copy-4WTKRHQ$default  reason: not valid java name */
    public static /* synthetic */ Border m8356copy4WTKRHQ$default(Border border, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = border.wight;
        }
        if ((i & 2) != 0) {
            j = border.color;
        }
        return border.m8358copy4WTKRHQ(f, j);
    }

    public final float component1() {
        return this.wight;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m8357component20d7_KjU() {
        return this.color;
    }

    /* renamed from: copy-4WTKRHQ  reason: not valid java name */
    public final Border m8358copy4WTKRHQ(float f, long j) {
        return new Border(f, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Border) {
            Border border = (Border) obj;
            return Float.compare(this.wight, border.wight) == 0 && Color.m4079equalsimpl0(this.color, border.color);
        }
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.wight) * 31) + Color.m4085hashCodeimpl(this.color);
    }

    public String toString() {
        float f = this.wight;
        return "Border(wight=" + f + ", color=" + Color.m4086toStringimpl(this.color) + ")";
    }

    private Border(float f, long j) {
        this.wight = f;
        this.color = j;
    }

    public final float getWight() {
        return this.wight;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m8359getColor0d7_KjU() {
        return this.color;
    }
}

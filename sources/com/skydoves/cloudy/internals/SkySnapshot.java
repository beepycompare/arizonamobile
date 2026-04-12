package com.skydoves.cloudy.internals;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import com.skydoves.cloudy.CloudyProgressive;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SkySnapshot.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081\b\u0018\u0000 82\u00020\u0001:\u000278BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\u0010\u0010,\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b-\u0010!Jt\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u00020\u0010¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/skydoves/cloudy/internals/SkySnapshot;", "", "radius", "", "offsetX", "", "offsetY", "childWidth", "childHeight", "direction", "Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;", "fadeStart", "fadeEnd", "easing", "Landroidx/compose/animation/core/Easing;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(IFFFFLcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;FFLandroidx/compose/animation/core/Easing;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadius", "()I", "getOffsetX", "()F", "getOffsetY", "getChildWidth", "getChildHeight", "getDirection", "()Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;", "getFadeStart", "getFadeEnd", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getTintColor-0d7_KjU", "()J", "J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component10-0d7_KjU", "copy", "copy-fnh65Uc", "(IFFFFLcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;FFLandroidx/compose/animation/core/Easing;J)Lcom/skydoves/cloudy/internals/SkySnapshot;", "equals", "", "other", "hashCode", "toString", "", "ProgressiveDirection", "Companion", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SkySnapshot {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final float childHeight;
    private final float childWidth;
    private final ProgressiveDirection direction;
    private final Easing easing;
    private final float fadeEnd;
    private final float fadeStart;
    private final float offsetX;
    private final float offsetY;
    private final int radius;
    private final long tintColor;

    public /* synthetic */ SkySnapshot(int i, float f, float f2, float f3, float f4, ProgressiveDirection progressiveDirection, float f5, float f6, Easing easing, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, f2, f3, f4, progressiveDirection, f5, f6, easing, j);
    }

    /* renamed from: copy-fnh65Uc$default  reason: not valid java name */
    public static /* synthetic */ SkySnapshot m9144copyfnh65Uc$default(SkySnapshot skySnapshot, int i, float f, float f2, float f3, float f4, ProgressiveDirection progressiveDirection, float f5, float f6, Easing easing, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = skySnapshot.radius;
        }
        if ((i2 & 2) != 0) {
            f = skySnapshot.offsetX;
        }
        if ((i2 & 4) != 0) {
            f2 = skySnapshot.offsetY;
        }
        if ((i2 & 8) != 0) {
            f3 = skySnapshot.childWidth;
        }
        if ((i2 & 16) != 0) {
            f4 = skySnapshot.childHeight;
        }
        if ((i2 & 32) != 0) {
            progressiveDirection = skySnapshot.direction;
        }
        if ((i2 & 64) != 0) {
            f5 = skySnapshot.fadeStart;
        }
        if ((i2 & 128) != 0) {
            f6 = skySnapshot.fadeEnd;
        }
        if ((i2 & 256) != 0) {
            easing = skySnapshot.easing;
        }
        if ((i2 & 512) != 0) {
            j = skySnapshot.tintColor;
        }
        long j2 = j;
        float f7 = f6;
        Easing easing2 = easing;
        ProgressiveDirection progressiveDirection2 = progressiveDirection;
        float f8 = f5;
        float f9 = f4;
        float f10 = f2;
        return skySnapshot.m9146copyfnh65Uc(i, f, f10, f3, f9, progressiveDirection2, f8, f7, easing2, j2);
    }

    public final int component1() {
        return this.radius;
    }

    /* renamed from: component10-0d7_KjU  reason: not valid java name */
    public final long m9145component100d7_KjU() {
        return this.tintColor;
    }

    public final float component2() {
        return this.offsetX;
    }

    public final float component3() {
        return this.offsetY;
    }

    public final float component4() {
        return this.childWidth;
    }

    public final float component5() {
        return this.childHeight;
    }

    public final ProgressiveDirection component6() {
        return this.direction;
    }

    public final float component7() {
        return this.fadeStart;
    }

    public final float component8() {
        return this.fadeEnd;
    }

    public final Easing component9() {
        return this.easing;
    }

    /* renamed from: copy-fnh65Uc  reason: not valid java name */
    public final SkySnapshot m9146copyfnh65Uc(int i, float f, float f2, float f3, float f4, ProgressiveDirection direction, float f5, float f6, Easing easing, long j) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new SkySnapshot(i, f, f2, f3, f4, direction, f5, f6, easing, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkySnapshot) {
            SkySnapshot skySnapshot = (SkySnapshot) obj;
            return this.radius == skySnapshot.radius && Float.compare(this.offsetX, skySnapshot.offsetX) == 0 && Float.compare(this.offsetY, skySnapshot.offsetY) == 0 && Float.compare(this.childWidth, skySnapshot.childWidth) == 0 && Float.compare(this.childHeight, skySnapshot.childHeight) == 0 && this.direction == skySnapshot.direction && Float.compare(this.fadeStart, skySnapshot.fadeStart) == 0 && Float.compare(this.fadeEnd, skySnapshot.fadeEnd) == 0 && Intrinsics.areEqual(this.easing, skySnapshot.easing) && Color.m4773equalsimpl0(this.tintColor, skySnapshot.tintColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.radius) * 31) + Float.hashCode(this.offsetX)) * 31) + Float.hashCode(this.offsetY)) * 31) + Float.hashCode(this.childWidth)) * 31) + Float.hashCode(this.childHeight)) * 31) + this.direction.hashCode()) * 31) + Float.hashCode(this.fadeStart)) * 31) + Float.hashCode(this.fadeEnd)) * 31) + this.easing.hashCode()) * 31) + Color.m4779hashCodeimpl(this.tintColor);
    }

    public String toString() {
        return "SkySnapshot(radius=" + this.radius + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", childWidth=" + this.childWidth + ", childHeight=" + this.childHeight + ", direction=" + this.direction + ", fadeStart=" + this.fadeStart + ", fadeEnd=" + this.fadeEnd + ", easing=" + this.easing + ", tintColor=" + ((Object) Color.m4780toStringimpl(this.tintColor)) + ')';
    }

    private SkySnapshot(int i, float f, float f2, float f3, float f4, ProgressiveDirection direction, float f5, float f6, Easing easing, long j) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.radius = i;
        this.offsetX = f;
        this.offsetY = f2;
        this.childWidth = f3;
        this.childHeight = f4;
        this.direction = direction;
        this.fadeStart = f5;
        this.fadeEnd = f6;
        this.easing = easing;
        this.tintColor = j;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final float getChildWidth() {
        return this.childWidth;
    }

    public final float getChildHeight() {
        return this.childHeight;
    }

    public final ProgressiveDirection getDirection() {
        return this.direction;
    }

    public final float getFadeStart() {
        return this.fadeStart;
    }

    public final float getFadeEnd() {
        return this.fadeEnd;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    /* renamed from: getTintColor-0d7_KjU  reason: not valid java name */
    public final long m9147getTintColor0d7_KjU() {
        return this.tintColor;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SkySnapshot.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "EDGES", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ProgressiveDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProgressiveDirection[] $VALUES;
        public static final ProgressiveDirection NONE = new ProgressiveDirection("NONE", 0);
        public static final ProgressiveDirection TOP_TO_BOTTOM = new ProgressiveDirection("TOP_TO_BOTTOM", 1);
        public static final ProgressiveDirection BOTTOM_TO_TOP = new ProgressiveDirection("BOTTOM_TO_TOP", 2);
        public static final ProgressiveDirection EDGES = new ProgressiveDirection("EDGES", 3);

        private static final /* synthetic */ ProgressiveDirection[] $values() {
            return new ProgressiveDirection[]{NONE, TOP_TO_BOTTOM, BOTTOM_TO_TOP, EDGES};
        }

        public static EnumEntries<ProgressiveDirection> getEntries() {
            return $ENTRIES;
        }

        public static ProgressiveDirection valueOf(String str) {
            return (ProgressiveDirection) Enum.valueOf(ProgressiveDirection.class, str);
        }

        public static ProgressiveDirection[] values() {
            return (ProgressiveDirection[]) $VALUES.clone();
        }

        private ProgressiveDirection(String str, int i) {
        }

        static {
            ProgressiveDirection[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: SkySnapshot.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/skydoves/cloudy/internals/SkySnapshot$Companion;", "", "<init>", "()V", "fromProgressive", "Lcom/skydoves/cloudy/internals/SkySnapshot;", "radius", "", "offsetX", "", "offsetY", "childWidth", "childHeight", "progressive", "Lcom/skydoves/cloudy/CloudyProgressive;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "fromProgressive-PE3pjmc", "(IFFFFLcom/skydoves/cloudy/CloudyProgressive;J)Lcom/skydoves/cloudy/internals/SkySnapshot;", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fromProgressive-PE3pjmc  reason: not valid java name */
        public final SkySnapshot m9148fromProgressivePE3pjmc(int i, float f, float f2, float f3, float f4, CloudyProgressive progressive, long j) {
            ProgressiveParams progressiveParams;
            ProgressiveParams progressiveParams2;
            Intrinsics.checkNotNullParameter(progressive, "progressive");
            if (progressive instanceof CloudyProgressive.None) {
                progressiveParams2 = new ProgressiveParams(ProgressiveDirection.NONE, 0.0f, 1.0f, EasingKt.getFastOutSlowInEasing());
            } else {
                if (progressive instanceof CloudyProgressive.TopToBottom) {
                    CloudyProgressive.TopToBottom topToBottom = (CloudyProgressive.TopToBottom) progressive;
                    progressiveParams = new ProgressiveParams(ProgressiveDirection.TOP_TO_BOTTOM, topToBottom.getStart(), topToBottom.getEnd(), topToBottom.getEasing());
                } else if (progressive instanceof CloudyProgressive.BottomToTop) {
                    CloudyProgressive.BottomToTop bottomToTop = (CloudyProgressive.BottomToTop) progressive;
                    progressiveParams = new ProgressiveParams(ProgressiveDirection.BOTTOM_TO_TOP, bottomToTop.getStart(), bottomToTop.getEnd(), bottomToTop.getEasing());
                } else if (!(progressive instanceof CloudyProgressive.Edges)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    CloudyProgressive.Edges edges = (CloudyProgressive.Edges) progressive;
                    progressiveParams = new ProgressiveParams(ProgressiveDirection.EDGES, edges.getFadeDistance(), 1.0f - edges.getFadeDistance(), edges.getEasing());
                }
                progressiveParams2 = progressiveParams;
            }
            return new SkySnapshot(i, f, f2, f3, f4, progressiveParams2.component1(), progressiveParams2.component2(), progressiveParams2.component3(), progressiveParams2.component4(), j, null);
        }
    }
}

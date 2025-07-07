package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005EFGHIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020$H\u0007J-\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J%\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b0J-\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b2J-\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b4J-\u00105\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b6J-\u00107\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b8J\u001a\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\"\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\"\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010@J/\u0010A\u001a\u00020&*\u00020*2\u0006\u0010B\u001a\u00020-2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0DH\u0082\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001b\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;
    public static final Arrangement INSTANCE = new Arrangement();
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    };
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    };
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    };
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    };
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m6684constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        public float mo625getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Center";
        }
    };
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m6684constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo625getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    };
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m6684constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo625getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    };
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m6684constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo625getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    };

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getCenter$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    private Arrangement() {
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Horizontal {
        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* compiled from: Arrangement.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m627getSpacingD9Ej5fM(Horizontal horizontal) {
                return Horizontal.super.mo625getSpacingD9Ej5fM();
            }
        }

        /* renamed from: getSpacing-D9Ej5fM */
        default float mo625getSpacingD9Ej5fM() {
            return Dp.m6684constructorimpl(0);
        }
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Vertical {
        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        /* compiled from: Arrangement.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m635getSpacingD9Ej5fM(Vertical vertical) {
                return Vertical.super.mo625getSpacingD9Ej5fM();
            }
        }

        /* renamed from: getSpacing-D9Ej5fM */
        default float mo625getSpacingD9Ej5fM() {
            return Dp.m6684constructorimpl(0);
        }
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u001a\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        /* compiled from: Arrangement.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m629getSpacingD9Ej5fM(HorizontalOrVertical horizontalOrVertical) {
                return HorizontalOrVertical.super.mo625getSpacingD9Ej5fM();
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        default float mo625getSpacingD9Ej5fM() {
            return Dp.m6684constructorimpl(0);
        }
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    /* renamed from: spacedBy-0680j_4  reason: not valid java name */
    public final HorizontalOrVertical m619spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.Companion.getStart().align(0, i, layoutDirection));
            }
        }, null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Horizontal m620spacedByD5KLDUw(float f, final Alignment.Horizontal horizontal) {
        return new SpacedAligned(f, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.Horizontal.this.align(0, i, layoutDirection));
            }
        }, null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Vertical m621spacedByD5KLDUw(float f, final Alignment.Vertical vertical) {
        return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.Vertical.this.align(0, i));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }
        }, null);
    }

    public final Horizontal aligned(final Alignment.Horizontal horizontal) {
        return new SpacedAligned(Dp.m6684constructorimpl(0), true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$aligned$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.Horizontal.this.align(0, i, layoutDirection));
            }
        }, null);
    }

    public final Vertical aligned(final Alignment.Vertical vertical) {
        return new SpacedAligned(Dp.m6684constructorimpl(0), false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$aligned$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.Vertical.this.align(0, i));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }
        }, null);
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010$R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "()V", "Center", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "getLeft$annotations", "getLeft", "Right", "getRight$annotations", "getRight", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Absolute {
        public static final int $stable = 0;
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };
        private static final Horizontal Right = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };
        private static final Horizontal SpaceBetween = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };
        private static final Horizontal SpaceEvenly = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };
        private static final Horizontal SpaceAround = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getLeft$annotations() {
        }

        public static /* synthetic */ void getRight$annotations() {
        }

        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        private Absolute() {
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        /* renamed from: spacedBy-0680j_4  reason: not valid java name */
        public final HorizontalOrVertical m622spacedBy0680j_4(float f) {
            return new SpacedAligned(f, false, null, null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Horizontal m623spacedByD5KLDUw(float f, final Alignment.Horizontal horizontal) {
            return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$spacedBy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                    return invoke(num.intValue(), layoutDirection);
                }

                public final Integer invoke(int i, LayoutDirection layoutDirection) {
                    return Integer.valueOf(Alignment.Horizontal.this.align(0, i, layoutDirection));
                }
            }, null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Vertical m624spacedByD5KLDUw(float f, final Alignment.Vertical vertical) {
            return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$spacedBy$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public final Integer invoke(int i, LayoutDirection layoutDirection) {
                    return Integer.valueOf(Alignment.Vertical.this.align(0, i));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                    return invoke(num.intValue(), layoutDirection);
                }
            }, null);
        }

        public final Horizontal aligned(final Alignment.Horizontal horizontal) {
            return new SpacedAligned(Dp.m6684constructorimpl(0), false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$aligned$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                    return invoke(num.intValue(), layoutDirection);
                }

                public final Integer invoke(int i, LayoutDirection layoutDirection) {
                    return Integer.valueOf(Alignment.Horizontal.this.align(0, i, layoutDirection));
                }
            }, null);
        }
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J,\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020&H\u0016J$\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SpacedAligned implements HorizontalOrVertical {
        public static final int $stable = 0;
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-8Feqmps$default  reason: not valid java name */
        public static /* synthetic */ SpacedAligned m630copy8Feqmps$default(SpacedAligned spacedAligned, float f, boolean z, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = spacedAligned.space;
            }
            if ((i & 2) != 0) {
                z = spacedAligned.rtlMirror;
            }
            if ((i & 4) != 0) {
                function2 = spacedAligned.alignment;
            }
            return spacedAligned.m632copy8Feqmps(f, z, function2);
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m631component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        /* renamed from: copy-8Feqmps  reason: not valid java name */
        public final SpacedAligned m632copy8Feqmps(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            return new SpacedAligned(f, z, function2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SpacedAligned) {
                SpacedAligned spacedAligned = (SpacedAligned) obj;
                return Dp.m6689equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment);
            }
            return false;
        }

        public int hashCode() {
            int m6690hashCodeimpl = ((Dp.m6690hashCodeimpl(this.space) * 31) + Boolean.hashCode(this.rtlMirror)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return m6690hashCodeimpl + (function2 == null ? 0 : function2.hashCode());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = function2;
            this.spacing = f;
        }

        /* renamed from: getSpace-D9Ej5fM  reason: not valid java name */
        public final float m633getSpaceD9Ej5fM() {
            return this.space;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo625getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i2;
            int i3;
            if (iArr.length == 0) {
                return;
            }
            int mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (!z) {
                int length = iArr.length;
                int i4 = 0;
                i2 = 0;
                i3 = 0;
                int i5 = 0;
                while (i4 < length) {
                    int i6 = iArr[i4];
                    int min = Math.min(i2, i - i6);
                    iArr2[i5] = min;
                    int min2 = Math.min(mo383roundToPx0680j_4, (i - min) - i6);
                    i4++;
                    i3 = min2;
                    i2 = iArr2[i5] + i6 + min2;
                    i5++;
                }
            } else {
                i2 = 0;
                i3 = 0;
                for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                    int i7 = iArr[length2];
                    int min3 = Math.min(i2, i - i7);
                    iArr2[length2] = min3;
                    i3 = Math.min(mo383roundToPx0680j_4, (i - min3) - i7);
                    i2 = iArr2[length2] + i7 + i3;
                }
            }
            int i8 = i2 - i3;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null || i8 >= i) {
                return;
            }
            int intValue = function2.invoke(Integer.valueOf(i - i8), layoutDirection).intValue();
            int length3 = iArr2.length;
            for (int i9 = 0; i9 < length3; i9++) {
                iArr2[i9] = iArr2[i9] + intValue;
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
        }

        public String toString() {
            return (this.rtlMirror ? "" : "Absolute") + "Arrangement#spacedAligned(" + ((Object) Dp.m6695toStringimpl(this.space)) + ", " + this.alignment + ')';
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        if (iArr.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float max = (i - i3) / Math.max(ArraysKt.getLastIndex(iArr), 1);
        float f = (z && iArr.length == 1) ? max : 0.0f;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6 + max;
                i2++;
                i5++;
            }
            return;
        }
        for (int length2 = iArr.length - 1; -1 < length2; length2--) {
            int i7 = iArr[length2];
            iArr2[length2] = Math.round(f);
            f += i7 + max;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        int i5 = i - i3;
        if (!z) {
            int length = iArr.length;
            int i6 = 0;
            while (i2 < length) {
                int i7 = iArr[i2];
                iArr2[i6] = i5;
                i5 += i7;
                i2++;
                i6++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i8 = iArr[length2];
            iArr2[length2] = i5;
            i5 += i8;
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] iArr, int[] iArr2, boolean z) {
        int i = 0;
        if (!z) {
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int i4 = iArr[i];
                iArr2[i2] = i3;
                i3 += i4;
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i5 = iArr[length2];
            iArr2[length2] = i;
            i += i5;
        }
    }

    public final void placeCenter$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = (i - i3) / 2;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = Math.round(f);
            f += i7;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = (i - i3) / (iArr.length + 1);
        if (!z) {
            int length2 = iArr.length;
            float f = length;
            int i5 = 0;
            while (i2 < length2) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6 + length;
                i2++;
                i5++;
            }
            return;
        }
        float f2 = length;
        for (int length3 = iArr.length - 1; -1 < length3; length3--) {
            int i7 = iArr[length3];
            iArr2[length3] = Math.round(f2);
            f2 += i7 + length;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = !(iArr.length == 0) ? (i - i3) / iArr.length : 0.0f;
        float f = length / 2;
        if (!z) {
            int length2 = iArr.length;
            int i5 = 0;
            while (i2 < length2) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6 + length;
                i2++;
                i5++;
            }
            return;
        }
        for (int length3 = iArr.length - 1; -1 < length3; length3--) {
            int i7 = iArr[length3];
            iArr2[length3] = Math.round(f);
            f += i7 + length;
        }
    }

    private final void forEachIndexed(int[] iArr, boolean z, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (z) {
            int length = iArr.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                function2.invoke(Integer.valueOf(length), Integer.valueOf(iArr[length]));
            }
        } else {
            int length2 = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length2) {
                function2.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
                i++;
                i2++;
            }
        }
    }
}

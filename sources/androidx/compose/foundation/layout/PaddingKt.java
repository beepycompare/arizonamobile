package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0015\u0010\u0016\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0015\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\"\u001a7\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"padding", "Landroidx/compose/ui/Modifier;", TtmlNode.START, "Landroidx/compose/ui/unit/Dp;", "top", TtmlNode.END, "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", TtmlNode.COMBINE_ALL, "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", TtmlNode.LEFT, TtmlNode.RIGHT, "absolutePadding-qDBjuR0", "plus", "other", "minus", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PaddingKt {
    /* renamed from: padding-qDBjuR0 */
    public static final Modifier m1053paddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    public static final Unit padding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set(TtmlNode.START, Dp.m8158boximpl(f));
        inspectorInfo.getProperties().set("top", Dp.m8158boximpl(f2));
        inspectorInfo.getProperties().set(TtmlNode.END, Dp.m8158boximpl(f3));
        inspectorInfo.getProperties().set("bottom", Dp.m8158boximpl(f4));
        return Unit.INSTANCE;
    }

    /* renamed from: padding-VpY3zN4 */
    public static final Modifier m1051paddingVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_VpY3zN4$lambda$0(f, f2, (InspectorInfo) obj);
            }
        }, null));
    }

    public static final Unit padding_VpY3zN4$lambda$0(float f, float f2, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("horizontal", Dp.m8158boximpl(f));
        inspectorInfo.getProperties().set("vertical", Dp.m8158boximpl(f2));
        return Unit.INSTANCE;
    }

    /* renamed from: padding-3ABfNKs */
    public static final Modifier m1050padding3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_3ABfNKs$lambda$0(f, (InspectorInfo) obj);
            }
        }, null));
    }

    public static final Unit padding_3ABfNKs$lambda$0(float f, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.setValue(Dp.m8158boximpl(f));
        return Unit.INSTANCE;
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding$lambda$0(PaddingValues.this, (InspectorInfo) obj);
            }
        }));
    }

    public static final Unit padding$lambda$0(PaddingValues paddingValues, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("paddingValues", paddingValues);
        return Unit.INSTANCE;
    }

    /* renamed from: absolutePadding-qDBjuR0 */
    public static final Modifier m1048absolutePaddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, false, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.absolutePadding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    public static final Unit absolutePadding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set(TtmlNode.LEFT, Dp.m8158boximpl(f));
        inspectorInfo.getProperties().set("top", Dp.m8158boximpl(f2));
        inspectorInfo.getProperties().set(TtmlNode.RIGHT, Dp.m8158boximpl(f3));
        inspectorInfo.getProperties().set("bottom", Dp.m8158boximpl(f4));
        return Unit.INSTANCE;
    }

    public static final PaddingValues plus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt$plus$1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateLeftPadding-u2uoSUM */
            public float mo1000calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8160constructorimpl(PaddingValues.this.mo1000calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues2.mo1000calculateLeftPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateTopPadding-D9Ej5fM */
            public float mo1002calculateTopPaddingD9Ej5fM() {
                return Dp.m8160constructorimpl(PaddingValues.this.mo1002calculateTopPaddingD9Ej5fM() + paddingValues2.mo1002calculateTopPaddingD9Ej5fM());
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateRightPadding-u2uoSUM */
            public float mo1001calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8160constructorimpl(PaddingValues.this.mo1001calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues2.mo1001calculateRightPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateBottomPadding-D9Ej5fM */
            public float mo999calculateBottomPaddingD9Ej5fM() {
                return Dp.m8160constructorimpl(PaddingValues.this.mo999calculateBottomPaddingD9Ej5fM() + paddingValues2.mo999calculateBottomPaddingD9Ej5fM());
            }
        };
    }

    public static final PaddingValues minus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt$minus$1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateLeftPadding-u2uoSUM */
            public float mo1000calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8160constructorimpl(RangesKt.coerceAtLeast(Dp.m8160constructorimpl(PaddingValues.this.mo1000calculateLeftPaddingu2uoSUM(layoutDirection) - paddingValues2.mo1000calculateLeftPaddingu2uoSUM(layoutDirection)), Dp.m8160constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateTopPadding-D9Ej5fM */
            public float mo1002calculateTopPaddingD9Ej5fM() {
                return Dp.m8160constructorimpl(RangesKt.coerceAtLeast(Dp.m8160constructorimpl(PaddingValues.this.mo1002calculateTopPaddingD9Ej5fM() - paddingValues2.mo1002calculateTopPaddingD9Ej5fM()), Dp.m8160constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateRightPadding-u2uoSUM */
            public float mo1001calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8160constructorimpl(RangesKt.coerceAtLeast(Dp.m8160constructorimpl(PaddingValues.this.mo1001calculateRightPaddingu2uoSUM(layoutDirection) - paddingValues2.mo1001calculateRightPaddingu2uoSUM(layoutDirection)), Dp.m8160constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* renamed from: calculateBottomPadding-D9Ej5fM */
            public float mo999calculateBottomPaddingD9Ej5fM() {
                return Dp.m8160constructorimpl(RangesKt.coerceAtLeast(Dp.m8160constructorimpl(PaddingValues.this.mo999calculateBottomPaddingD9Ej5fM() - paddingValues2.mo999calculateBottomPaddingD9Ej5fM()), Dp.m8160constructorimpl(0.0f)));
            }
        };
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo1000calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo1001calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo1001calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo1000calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* renamed from: PaddingValues-0680j_4 */
    public static final PaddingValues m1043PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    /* renamed from: PaddingValues-YgX7TsA */
    public static final PaddingValues m1044PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* renamed from: PaddingValues-a9UjIt4 */
    public static final PaddingValues m1046PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* renamed from: padding-qDBjuR0$default */
    public static /* synthetic */ Modifier m1054paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m8160constructorimpl(0.0f);
        }
        return m1053paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: padding-VpY3zN4$default */
    public static /* synthetic */ Modifier m1052paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m8160constructorimpl(0.0f);
        }
        return m1051paddingVpY3zN4(modifier, f, f2);
    }

    /* renamed from: absolutePadding-qDBjuR0$default */
    public static /* synthetic */ Modifier m1049absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m8160constructorimpl(0.0f);
        }
        return m1048absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: PaddingValues-YgX7TsA$default */
    public static /* synthetic */ PaddingValues m1045PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m8160constructorimpl(0.0f);
        }
        return m1044PaddingValuesYgX7TsA(f, f2);
    }

    /* renamed from: PaddingValues-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m1047PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m8160constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m8160constructorimpl(0.0f);
        }
        return m1046PaddingValuesa9UjIt4(f, f2, f3, f4);
    }
}

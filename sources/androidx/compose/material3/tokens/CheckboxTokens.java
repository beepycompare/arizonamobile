package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
/* compiled from: CheckboxTokens.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b(\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010!\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0011\u0010%\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0011\u0010'\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0011\u0010+\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014R\u0011\u0010-\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0014R\u0011\u0010/\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0014R\u0013\u00101\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0014R\u0011\u00105\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0014R\u0013\u00107\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0014R\u0011\u0010;\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0014R\u0013\u0010=\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b>\u0010\u0007R\u0011\u0010?\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0014R\u0013\u0010A\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bB\u0010\u0007R\u0011\u0010C\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0014R\u0011\u0010E\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0014R\u0013\u0010G\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bH\u0010\u0007R\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bN\u0010\u0007R\u000e\u0010O\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0014R\u0013\u0010R\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0014R\u0013\u0010V\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0014R\u0013\u0010Z\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0014R\u0011\u0010^\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0014R\u0013\u0010`\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0014R\u0013\u0010d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0014R\u0013\u0010h\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0014R\u0013\u0010l\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bm\u0010\u0007R\u0011\u0010n\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0014R\u0013\u0010p\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bq\u0010\u0007¨\u0006r"}, d2 = {"Landroidx/compose/material3/tokens/CheckboxTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getContainerShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "SelectedContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getSelectedContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "SelectedDisabledContainerColor", "getSelectedDisabledContainerColor", "SelectedDisabledContainerOpacity", "", "SelectedDisabledContainerOutlineWidth", "getSelectedDisabledContainerOutlineWidth-D9Ej5fM", "SelectedDisabledIconColor", "getSelectedDisabledIconColor", "SelectedErrorContainerColor", "getSelectedErrorContainerColor", "SelectedErrorFocusContainerColor", "getSelectedErrorFocusContainerColor", "SelectedErrorFocusIconColor", "getSelectedErrorFocusIconColor", "SelectedErrorFocusOutlineWidth", "getSelectedErrorFocusOutlineWidth-D9Ej5fM", "SelectedErrorHoverContainerColor", "getSelectedErrorHoverContainerColor", "SelectedErrorHoverIconColor", "getSelectedErrorHoverIconColor", "SelectedErrorHoverOutlineWidth", "getSelectedErrorHoverOutlineWidth-D9Ej5fM", "SelectedErrorIconColor", "getSelectedErrorIconColor", "SelectedErrorPressedContainerColor", "getSelectedErrorPressedContainerColor", "SelectedErrorPressedIconColor", "getSelectedErrorPressedIconColor", "SelectedErrorPressedOutlineWidth", "getSelectedErrorPressedOutlineWidth-D9Ej5fM", "SelectedFocusContainerColor", "getSelectedFocusContainerColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusOutlineWidth", "getSelectedFocusOutlineWidth-D9Ej5fM", "SelectedHoverContainerColor", "getSelectedHoverContainerColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverOutlineWidth", "getSelectedHoverOutlineWidth-D9Ej5fM", "SelectedIconColor", "getSelectedIconColor", "SelectedOutlineWidth", "getSelectedOutlineWidth-D9Ej5fM", "SelectedPressedContainerColor", "getSelectedPressedContainerColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedOutlineWidth", "getSelectedPressedOutlineWidth-D9Ej5fM", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedDisabledContainerOpacity", "UnselectedDisabledOutlineColor", "getUnselectedDisabledOutlineColor", "UnselectedDisabledOutlineWidth", "getUnselectedDisabledOutlineWidth-D9Ej5fM", "UnselectedErrorFocusOutlineColor", "getUnselectedErrorFocusOutlineColor", "UnselectedErrorFocusOutlineWidth", "getUnselectedErrorFocusOutlineWidth-D9Ej5fM", "UnselectedErrorHoverOutlineColor", "getUnselectedErrorHoverOutlineColor", "UnselectedErrorHoverOutlineWidth", "getUnselectedErrorHoverOutlineWidth-D9Ej5fM", "UnselectedErrorOutlineColor", "getUnselectedErrorOutlineColor", "UnselectedErrorPressedOutlineColor", "getUnselectedErrorPressedOutlineColor", "UnselectedErrorPressedOutlineWidth", "getUnselectedErrorPressedOutlineWidth-D9Ej5fM", "UnselectedFocusOutlineColor", "getUnselectedFocusOutlineColor", "UnselectedFocusOutlineWidth", "getUnselectedFocusOutlineWidth-D9Ej5fM", "UnselectedHoverOutlineColor", "getUnselectedHoverOutlineColor", "UnselectedHoverOutlineWidth", "getUnselectedHoverOutlineWidth-D9Ej5fM", "UnselectedOutlineColor", "getUnselectedOutlineColor", "UnselectedOutlineWidth", "getUnselectedOutlineWidth-D9Ej5fM", "UnselectedPressedOutlineColor", "getUnselectedPressedOutlineColor", "UnselectedPressedOutlineWidth", "getUnselectedPressedOutlineWidth-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxTokens {
    public static final int $stable = 0;
    private static final float ContainerHeight;
    private static final RoundedCornerShape ContainerShape;
    private static final float ContainerWidth;
    private static final float IconSize;
    public static final float SelectedDisabledContainerOpacity = 0.38f;
    private static final float SelectedDisabledContainerOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedDisabledIconColor;
    private static final ColorSchemeKeyTokens SelectedErrorContainerColor;
    private static final ColorSchemeKeyTokens SelectedErrorFocusContainerColor;
    private static final ColorSchemeKeyTokens SelectedErrorFocusIconColor;
    private static final float SelectedErrorFocusOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedErrorHoverContainerColor;
    private static final ColorSchemeKeyTokens SelectedErrorHoverIconColor;
    private static final float SelectedErrorHoverOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedErrorIconColor;
    private static final ColorSchemeKeyTokens SelectedErrorPressedContainerColor;
    private static final ColorSchemeKeyTokens SelectedErrorPressedIconColor;
    private static final float SelectedErrorPressedOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedFocusContainerColor;
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;
    private static final float SelectedFocusOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedHoverContainerColor;
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;
    private static final float SelectedHoverOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedIconColor;
    private static final float SelectedOutlineWidth;
    private static final ColorSchemeKeyTokens SelectedPressedContainerColor;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;
    private static final float SelectedPressedOutlineWidth;
    private static final ShapeKeyTokens StateLayerShape;
    private static final float StateLayerSize;
    public static final float UnselectedDisabledContainerOpacity = 0.38f;
    private static final ColorSchemeKeyTokens UnselectedDisabledOutlineColor;
    private static final float UnselectedDisabledOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedErrorFocusOutlineColor;
    private static final float UnselectedErrorFocusOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedErrorHoverOutlineColor;
    private static final float UnselectedErrorHoverOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedErrorOutlineColor;
    private static final ColorSchemeKeyTokens UnselectedErrorPressedOutlineColor;
    private static final float UnselectedErrorPressedOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedFocusOutlineColor;
    private static final float UnselectedFocusOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedHoverOutlineColor;
    private static final float UnselectedHoverOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedOutlineColor;
    private static final float UnselectedOutlineWidth;
    private static final ColorSchemeKeyTokens UnselectedPressedOutlineColor;
    private static final float UnselectedPressedOutlineWidth;
    public static final CheckboxTokens INSTANCE = new CheckboxTokens();
    private static final ColorSchemeKeyTokens SelectedContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedDisabledContainerColor = ColorSchemeKeyTokens.OnSurface;

    private CheckboxTokens() {
    }

    /* renamed from: getContainerHeight-D9Ej5fM  reason: not valid java name */
    public final float m3712getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final RoundedCornerShape getContainerShape() {
        return ContainerShape;
    }

    /* renamed from: getContainerWidth-D9Ej5fM  reason: not valid java name */
    public final float m3713getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m3714getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getSelectedContainerColor() {
        return SelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledContainerColor() {
        return SelectedDisabledContainerColor;
    }

    /* renamed from: getSelectedDisabledContainerOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3715getSelectedDisabledContainerOutlineWidthD9Ej5fM() {
        return SelectedDisabledContainerOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledIconColor() {
        return SelectedDisabledIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorContainerColor() {
        return SelectedErrorContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusContainerColor() {
        return SelectedErrorFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusIconColor() {
        return SelectedErrorFocusIconColor;
    }

    /* renamed from: getSelectedErrorFocusOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3716getSelectedErrorFocusOutlineWidthD9Ej5fM() {
        return SelectedErrorFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverContainerColor() {
        return SelectedErrorHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverIconColor() {
        return SelectedErrorHoverIconColor;
    }

    /* renamed from: getSelectedErrorHoverOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3717getSelectedErrorHoverOutlineWidthD9Ej5fM() {
        return SelectedErrorHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedErrorIconColor() {
        return SelectedErrorIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedContainerColor() {
        return SelectedErrorPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedIconColor() {
        return SelectedErrorPressedIconColor;
    }

    /* renamed from: getSelectedErrorPressedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3718getSelectedErrorPressedOutlineWidthD9Ej5fM() {
        return SelectedErrorPressedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedFocusContainerColor() {
        return SelectedFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    /* renamed from: getSelectedFocusOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3719getSelectedFocusOutlineWidthD9Ej5fM() {
        return SelectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedHoverContainerColor() {
        return SelectedHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    /* renamed from: getSelectedHoverOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3720getSelectedHoverOutlineWidthD9Ej5fM() {
        return SelectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    /* renamed from: getSelectedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3721getSelectedOutlineWidthD9Ej5fM() {
        return SelectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedPressedContainerColor() {
        return SelectedPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    /* renamed from: getSelectedPressedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3722getSelectedPressedOutlineWidthD9Ej5fM() {
        return SelectedPressedOutlineWidth;
    }

    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* renamed from: getStateLayerSize-D9Ej5fM  reason: not valid java name */
    public final float m3723getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    public final ColorSchemeKeyTokens getUnselectedDisabledOutlineColor() {
        return UnselectedDisabledOutlineColor;
    }

    /* renamed from: getUnselectedDisabledOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3724getUnselectedDisabledOutlineWidthD9Ej5fM() {
        return UnselectedDisabledOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorFocusOutlineColor() {
        return UnselectedErrorFocusOutlineColor;
    }

    /* renamed from: getUnselectedErrorFocusOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3725getUnselectedErrorFocusOutlineWidthD9Ej5fM() {
        return UnselectedErrorFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorHoverOutlineColor() {
        return UnselectedErrorHoverOutlineColor;
    }

    /* renamed from: getUnselectedErrorHoverOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3726getUnselectedErrorHoverOutlineWidthD9Ej5fM() {
        return UnselectedErrorHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorOutlineColor() {
        return UnselectedErrorOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorPressedOutlineColor() {
        return UnselectedErrorPressedOutlineColor;
    }

    /* renamed from: getUnselectedErrorPressedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3727getUnselectedErrorPressedOutlineWidthD9Ej5fM() {
        return UnselectedErrorPressedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusOutlineColor() {
        return UnselectedFocusOutlineColor;
    }

    /* renamed from: getUnselectedFocusOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3728getUnselectedFocusOutlineWidthD9Ej5fM() {
        return UnselectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverOutlineColor() {
        return UnselectedHoverOutlineColor;
    }

    /* renamed from: getUnselectedHoverOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3729getUnselectedHoverOutlineWidthD9Ej5fM() {
        return UnselectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedOutlineColor() {
        return UnselectedOutlineColor;
    }

    /* renamed from: getUnselectedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3730getUnselectedOutlineWidthD9Ej5fM() {
        return UnselectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedOutlineColor() {
        return UnselectedPressedOutlineColor;
    }

    /* renamed from: getUnselectedPressedOutlineWidth-D9Ej5fM  reason: not valid java name */
    public final float m3731getUnselectedPressedOutlineWidthD9Ej5fM() {
        return UnselectedPressedOutlineWidth;
    }

    static {
        float f = (float) 18.0d;
        ContainerHeight = Dp.m7996constructorimpl(f);
        float f2 = (float) 2.0d;
        ContainerShape = RoundedCornerShapeKt.m1208RoundedCornerShape0680j_4(Dp.m7996constructorimpl(f2));
        ContainerWidth = Dp.m7996constructorimpl(f);
        IconSize = Dp.m7996constructorimpl(f);
        float f3 = (float) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        SelectedDisabledContainerOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedDisabledIconColor = ColorSchemeKeyTokens.Surface;
        SelectedErrorContainerColor = ColorSchemeKeyTokens.Error;
        SelectedErrorFocusContainerColor = ColorSchemeKeyTokens.Error;
        SelectedErrorFocusIconColor = ColorSchemeKeyTokens.OnError;
        SelectedErrorFocusOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedErrorHoverContainerColor = ColorSchemeKeyTokens.Error;
        SelectedErrorHoverIconColor = ColorSchemeKeyTokens.OnError;
        SelectedErrorHoverOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedErrorIconColor = ColorSchemeKeyTokens.OnError;
        SelectedErrorPressedContainerColor = ColorSchemeKeyTokens.Error;
        SelectedErrorPressedIconColor = ColorSchemeKeyTokens.OnError;
        SelectedErrorPressedOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedFocusContainerColor = ColorSchemeKeyTokens.Primary;
        SelectedFocusIconColor = ColorSchemeKeyTokens.OnPrimary;
        SelectedFocusOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedHoverContainerColor = ColorSchemeKeyTokens.Primary;
        SelectedHoverIconColor = ColorSchemeKeyTokens.OnPrimary;
        SelectedHoverOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedIconColor = ColorSchemeKeyTokens.OnPrimary;
        SelectedOutlineWidth = Dp.m7996constructorimpl(f3);
        SelectedPressedContainerColor = ColorSchemeKeyTokens.Primary;
        SelectedPressedIconColor = ColorSchemeKeyTokens.OnPrimary;
        SelectedPressedOutlineWidth = Dp.m7996constructorimpl(f3);
        StateLayerShape = ShapeKeyTokens.CornerFull;
        StateLayerSize = Dp.m7996constructorimpl((float) 40.0d);
        UnselectedDisabledOutlineColor = ColorSchemeKeyTokens.OnSurface;
        UnselectedDisabledOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedErrorFocusOutlineColor = ColorSchemeKeyTokens.Error;
        UnselectedErrorFocusOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedErrorHoverOutlineColor = ColorSchemeKeyTokens.Error;
        UnselectedErrorHoverOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedErrorOutlineColor = ColorSchemeKeyTokens.Error;
        UnselectedErrorPressedOutlineColor = ColorSchemeKeyTokens.Error;
        UnselectedErrorPressedOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedFocusOutlineColor = ColorSchemeKeyTokens.OnSurface;
        UnselectedFocusOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedHoverOutlineColor = ColorSchemeKeyTokens.OnSurface;
        UnselectedHoverOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedOutlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        UnselectedOutlineWidth = Dp.m7996constructorimpl(f2);
        UnselectedPressedOutlineColor = ColorSchemeKeyTokens.OnSurface;
        UnselectedPressedOutlineWidth = Dp.m7996constructorimpl(f2);
    }
}

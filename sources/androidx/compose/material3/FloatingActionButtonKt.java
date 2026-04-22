package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabMediumTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001an\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u0012\u001an\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0012\u001ay\u0010\u001e\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001f¢\u0006\u0002\b\u0010¢\u0006\u0002\b!H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u008b\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b(\u0010)\u001a»\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¢\u0006\u0004\b-\u0010.\u001a\r\u0010G\u001a\u00020HH\u0003¢\u0006\u0002\u0010I\u001a\r\u0010J\u001a\u00020KH\u0003¢\u0006\u0002\u0010L\"\u0010\u0010/\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00107\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00108\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00109\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010:\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010;\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010<\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010=\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010?\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010@\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010A\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010B\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010C\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010D\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010E\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010F\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006M"}, d2 = {"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "FloatingActionButton-lF-WlFE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "ExtendedFloatingActionButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "startPadding", "endPadding", "iconPadding", "ExtendedFloatingActionButton-qtIzBjc", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFFFFLandroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SmallExtendedFabMinimumWidth", "F", "SmallExtendedFabMinimumHeight", "SmallExtendedFabPaddingStart", "SmallExtendedFabPaddingEnd", "SmallExtendedFabIconPadding", "SmallExtendedFabTextStyle", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MediumExtendedFabMinimumWidth", "MediumExtendedFabMinimumHeight", "MediumExtendedFabPaddingStart", "MediumExtendedFabPaddingEnd", "MediumExtendedFabIconPadding", "MediumExtendedFabTextStyle", "LargeExtendedFabMinimumWidth", "LargeExtendedFabMinimumHeight", "LargeExtendedFabPaddingStart", "LargeExtendedFabPaddingEnd", "LargeExtendedFabIconPadding", "LargeExtendedFabTextStyle", "ExtendedFabStartIconPadding", "ExtendedFabEndIconPadding", "ExtendedFabTextPadding", "ExtendedFabMinimumWidth", "extendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "extendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float SmallExtendedFabMinimumWidth = ExtendedFabSmallTokens.INSTANCE.m3385getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabMinimumHeight = ExtendedFabSmallTokens.INSTANCE.m3385getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabPaddingStart = ExtendedFabSmallTokens.INSTANCE.m3388getLeadingSpaceD9Ej5fM();
    private static final float SmallExtendedFabPaddingEnd = ExtendedFabSmallTokens.INSTANCE.m3389getTrailingSpaceD9Ej5fM();
    private static final float SmallExtendedFabIconPadding = ExtendedFabSmallTokens.INSTANCE.m3386getIconLabelSpaceD9Ej5fM();
    private static final TypographyKeyTokens SmallExtendedFabTextStyle = TypographyKeyTokens.TitleMedium;
    private static final float MediumExtendedFabMinimumWidth = ExtendedFabMediumTokens.INSTANCE.m3370getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabMinimumHeight = ExtendedFabMediumTokens.INSTANCE.m3370getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabPaddingStart = ExtendedFabMediumTokens.INSTANCE.m3373getLeadingSpaceD9Ej5fM();
    private static final float MediumExtendedFabPaddingEnd = ExtendedFabMediumTokens.INSTANCE.m3374getTrailingSpaceD9Ej5fM();
    private static final float MediumExtendedFabIconPadding = Dp.m7555constructorimpl(12.0f);
    private static final TypographyKeyTokens MediumExtendedFabTextStyle = TypographyKeyTokens.TitleLarge;
    private static final float LargeExtendedFabMinimumWidth = ExtendedFabLargeTokens.INSTANCE.m3365getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabMinimumHeight = ExtendedFabLargeTokens.INSTANCE.m3365getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabPaddingStart = ExtendedFabLargeTokens.INSTANCE.m3368getLeadingSpaceD9Ej5fM();
    private static final float LargeExtendedFabPaddingEnd = ExtendedFabLargeTokens.INSTANCE.m3369getTrailingSpaceD9Ej5fM();
    private static final float LargeExtendedFabIconPadding = Dp.m7555constructorimpl(16.0f);
    private static final TypographyKeyTokens LargeExtendedFabTextStyle = TypographyKeyTokens.HeadlineSmall;
    private static final float ExtendedFabStartIconPadding = Dp.m7555constructorimpl(16.0f);
    private static final float ExtendedFabEndIconPadding = Dp.m7555constructorimpl(12.0f);
    private static final float ExtendedFabTextPadding = Dp.m7555constructorimpl(20.0f);
    private static final float ExtendedFabMinimumWidth = Dp.m7555constructorimpl(80.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$8(Function2 function2, Function2 function22, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m2111ExtendedFloatingActionButtonElI57k(function2, function22, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$7(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2112ExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$9(Function2 function2, Function2 function22, Function0 function0, TextStyle textStyle, float f, float f2, float f3, float f4, float f5, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        m2113ExtendedFloatingActionButtonqtIzBjc(function2, function22, function0, textStyle, f, f2, f3, f4, f5, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2114FloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$4(Function0 function0, TextStyle textStyle, float f, float f2, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m2115FloatingActionButtonlFWlFE(function0, textStyle, f, f2, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LargeFloatingActionButton_X_z6DiA$lambda$6(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2116LargeFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SmallFloatingActionButton_X_z6DiA$lambda$5(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2117SmallFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* renamed from: FloatingActionButton-X-z6DiA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2114FloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        Object obj2;
        long j3;
        long j4;
        Object obj3;
        int i4;
        Object obj4;
        final Modifier modifier2;
        final Shape shape2;
        Composer composer2;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        long j7;
        Modifier modifier3;
        int i5;
        long j8;
        Modifier modifier4;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j9;
        long j10;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(748201188);
        ComposerKt.sourceInformation(startRestartGroup, "C(FloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)120@5970L5,118@5884L325:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    obj2 = shape;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                obj2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(obj3)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    obj3 = floatingActionButtonElevation;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                obj3 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                obj4 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "111@5554L5,112@5618L14,113@5660L31,114@5769L11");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i5 = 6;
                            modifier4 = obj;
                            shape4 = obj2;
                            floatingActionButtonElevation3 = obj3;
                            j9 = j3;
                            j10 = j4;
                            mutableInteractionSource3 = obj4;
                        } else {
                            Modifier.Companion companion = i8 != 0 ? Modifier.Companion : obj;
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                shape3 = FloatingActionButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape3 = obj2;
                            }
                            if ((i2 & 8) != 0) {
                                j7 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                j7 = j3;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j7, startRestartGroup, (i3 >> 9) & 14);
                            }
                            int i9 = i3;
                            if ((i2 & 32) != 0) {
                                j8 = j7;
                                modifier3 = companion;
                                i5 = 6;
                                obj3 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 = i9 & (-458753);
                            } else {
                                modifier3 = companion;
                                i5 = 6;
                                j8 = j7;
                                i3 = i9;
                            }
                            if (i4 != 0) {
                                modifier4 = modifier3;
                                mutableInteractionSource3 = null;
                                floatingActionButtonElevation3 = obj3;
                            } else {
                                modifier4 = modifier3;
                                floatingActionButtonElevation3 = obj3;
                                mutableInteractionSource3 = obj4;
                            }
                            shape4 = shape3;
                            j9 = j8;
                            j10 = j4;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(748201188, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:118)");
                        }
                        int i10 = i3 << 9;
                        m2115FloatingActionButtonlFWlFE(function02, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i5), FabBaselineTokens.INSTANCE.m3391getContainerWidthD9Ej5fM(), FabBaselineTokens.INSTANCE.m3390getContainerHeightD9Ej5fM(), modifier4, shape4, j9, j10, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, (i3 & 14) | 3456 | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), (i3 >> 21) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        modifier2 = modifier4;
                        shape2 = shape4;
                        j5 = j9;
                        j6 = j10;
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = obj;
                        shape2 = obj2;
                        composer2 = startRestartGroup;
                        floatingActionButtonElevation2 = obj3;
                        j5 = j3;
                        j6 = j4;
                        mutableInteractionSource2 = obj4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj5, Object obj6) {
                                return FloatingActionButtonKt.FloatingActionButton_X_z6DiA$lambda$0(Function0.this, modifier2, shape2, j5, j6, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj4 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        obj4 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /* JADX WARN: Type inference failed for: r10v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* renamed from: FloatingActionButton-lF-WlFE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m2115FloatingActionButtonlFWlFE(final Function0<Unit> function0, final TextStyle textStyle, final float f, final float f2, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        Function0<Unit> function02;
        int i4;
        float f3;
        float f4;
        Modifier modifier2;
        Object obj;
        int i5;
        long j3;
        int i6;
        int i7;
        int i8;
        int i9;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        Composer composer2;
        final Shape shape2;
        final long j4;
        final long j5;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        long j6;
        int i10;
        Modifier modifier4;
        boolean z;
        long j7;
        boolean z2;
        boolean z3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j8;
        long j9;
        ?? r10;
        MutableInteractionSource mutableInteractionSource4;
        int i11;
        Object obj2;
        int i12;
        Object obj3;
        Composer startRestartGroup = composer.startRestartGroup(121669932);
        ComposerKt.sourceInformation(startRestartGroup, "C(FloatingActionButton)N(onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)150@6953L22,155@7158L54,157@7273L330,148@6879L724:FloatingActionButton.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i4 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            f3 = f;
        } else {
            f3 = f;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changed(f3) ? 256 : 128;
            }
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
            f4 = f2;
        } else {
            f4 = f2;
            if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f4) ? 2048 : 1024;
            }
        }
        int i13 = i3 & 16;
        if (i13 != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            Object obj4 = modifier;
            i4 |= startRestartGroup.changed(obj4) ? 16384 : 8192;
            modifier2 = obj4;
            if ((196608 & i) != 0) {
                if ((i3 & 32) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i12 = 131072;
                        obj3 = obj2;
                        i4 |= i12;
                        obj = obj3;
                    }
                } else {
                    obj2 = shape;
                }
                i12 = 65536;
                obj3 = obj2;
                i4 |= i12;
                obj = obj3;
            } else {
                obj = shape;
            }
            if ((1572864 & i) != 0) {
                i5 = i4 | (((i3 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : 524288);
            } else {
                i5 = i4;
            }
            if ((i & 12582912) != 0) {
                j3 = j2;
                i5 |= ((i3 & 128) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
            } else {
                j3 = j2;
            }
            if ((i & 100663296) == 0) {
                if ((i3 & 256) == 0 && startRestartGroup.changed(floatingActionButtonElevation)) {
                    i11 = 67108864;
                    i5 |= i11;
                }
                i11 = 33554432;
                i5 |= i11;
            }
            i6 = i3 & 512;
            if (i6 == 0) {
                i5 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i7 = i6;
                i5 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                if ((i3 & 1024) != 0) {
                    i8 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i8 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                } else {
                    i8 = i2;
                }
                i9 = i8;
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i9 & 3) != 2, i5 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "139@6428L5,140@6492L14,141@6534L31,142@6643L11");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            i5 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        j8 = j;
                        floatingActionButtonElevation3 = floatingActionButtonElevation;
                        i10 = i9;
                        z = true;
                        shape4 = obj;
                        j9 = j3;
                        z2 = false;
                        r10 = 1;
                        mutableInteractionSource3 = mutableInteractionSource;
                    } else {
                        Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier2;
                        if ((i3 & 32) != 0) {
                            i5 &= -458753;
                            shape3 = FloatingActionButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            shape3 = obj;
                        }
                        if ((i3 & 64) != 0) {
                            j6 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i5 &= -3670017;
                        } else {
                            j6 = j;
                        }
                        if ((i3 & 128) != 0) {
                            j3 = ColorSchemeKt.m1902contentColorForek8zF_U(j6, startRestartGroup, (i5 >> 18) & 14);
                            i5 &= -29360129;
                        }
                        int i14 = i5;
                        if ((i3 & 256) != 0) {
                            z = true;
                            j7 = j6;
                            i10 = i9;
                            modifier4 = companion;
                            z2 = false;
                            z3 = true;
                            floatingActionButtonElevation3 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                            i5 = i14 & (-234881025);
                        } else {
                            i10 = i9;
                            modifier4 = companion;
                            z = true;
                            j7 = j6;
                            z2 = false;
                            z3 = true;
                            floatingActionButtonElevation3 = floatingActionButtonElevation;
                            i5 = i14;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                            modifier2 = modifier4;
                        } else {
                            modifier2 = modifier4;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        j8 = j7;
                        j9 = j3;
                        r10 = z3;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(121669932, i5, i10, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:145)");
                    }
                    if (mutableInteractionSource3 == null) {
                        startRestartGroup.startReplaceGroup(-282833393);
                        ComposerKt.sourceInformation(startRestartGroup, "147@6835L39");
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 960707667, "CC(remember):FloatingActionButton.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                    } else {
                        startRestartGroup.startReplaceGroup(960707016);
                        startRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 960711426, "CC(remember):FloatingActionButton.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$3$lambda$2((SemanticsPropertyReceiver) obj5);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float f5 = f3;
                    final float f6 = f4;
                    final long j10 = j9;
                    int i15 = i5 >> 6;
                    SurfaceKt.m2572Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, z2, (Function1) rememberedValue2, r10, null), false, shape4, j8, j9, floatingActionButtonElevation3.m2108tonalElevationD9Ej5fM$material3(), floatingActionButtonElevation3.shadowElevation$material3(mutableInteractionSource4, startRestartGroup, (i5 >> 21) & 112).getValue().m7569unboximpl(), null, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1779603465, r10, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i16) {
                            ComposerKt.sourceInformation(composer3, "C158@7364L233,158@7283L314:FloatingActionButton.kt#uh7d8r");
                            if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1779603465, i16, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:158)");
                            }
                            long j11 = j10;
                            TextStyle textStyle2 = textStyle;
                            final float f7 = f5;
                            final float f8 = f6;
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            ProvideContentColorTextStyleKt.m3007ProvideContentColorTextStyle3JVO9M(j11, textStyle2, ComposableLambdaKt.rememberComposableLambda(-1767363041, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i17) {
                                    ComposerKt.sourceInformation(composer4, "C159@7378L209:FloatingActionButton.kt#uh7d8r");
                                    if (!composer4.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1767363041, i17, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:159)");
                                    }
                                    Modifier m848defaultMinSizeVpY3zN4 = SizeKt.m848defaultMinSizeVpY3zN4(Modifier.Companion, f7, f8);
                                    Alignment center = Alignment.Companion.getCenter();
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, m848defaultMinSizeVpY3zN4);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer4);
                                    Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -339027051, "C163@7564L9:FloatingActionButton.kt#uh7d8r");
                                    function23.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | (i15 & 7168) | (57344 & i15) | (i15 & 458752), 6, 260);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier3 = modifier2;
                    composer2 = startRestartGroup;
                    shape2 = shape4;
                    j5 = j8;
                    j4 = j9;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    composer2 = startRestartGroup;
                    shape2 = obj;
                    j4 = j3;
                    j5 = j;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj5, Object obj6) {
                            return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$4(Function0.this, textStyle, f, f2, modifier3, shape2, j5, j4, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i7 = i6;
            if ((i3 & 1024) != 0) {
            }
            i9 = i8;
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i9 & 3) != 2, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i6 = i3 & 512;
        if (i6 == 0) {
        }
        i7 = i6;
        if ((i3 & 1024) != 0) {
        }
        i9 = i8;
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i9 & 3) != 2, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$3$lambda$2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m6793setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6774getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* renamed from: SmallFloatingActionButton-X-z6DiA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2117SmallFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        Object obj2;
        long j3;
        long j4;
        Object obj3;
        int i4;
        Object obj4;
        final Modifier modifier2;
        final Shape shape2;
        Composer composer2;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        int i5;
        long j7;
        long j8;
        long j9;
        int i6;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j10;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(26608441);
        ComposerKt.sourceInformation(startRestartGroup, "C(SmallFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)208@9786L441:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    obj2 = shape;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                obj2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(obj3)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    obj3 = floatingActionButtonElevation;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                obj3 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                obj4 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "201@9451L10,202@9520L14,203@9562L31,204@9671L11");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            floatingActionButtonElevation3 = obj3;
                            j9 = j3;
                            j10 = j4;
                            mutableInteractionSource3 = obj4;
                            i6 = 26608441;
                            shape4 = obj2;
                        } else {
                            Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                shape3 = FloatingActionButtonDefaults.INSTANCE.getSmallShape(startRestartGroup, 6);
                            } else {
                                shape3 = obj2;
                            }
                            if ((i2 & 8) != 0) {
                                i5 = i3 & (-7169);
                                j7 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            } else {
                                i5 = i3;
                                j7 = j3;
                            }
                            if ((i2 & 16) != 0) {
                                i5 &= -57345;
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j7, startRestartGroup, (i5 >> 9) & 14);
                            }
                            int i10 = i5;
                            if ((i2 & 32) != 0) {
                                j8 = j7;
                                obj3 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 = i10 & (-458753);
                            } else {
                                j8 = j7;
                                i3 = i10;
                            }
                            if (i4 != 0) {
                                obj = companion;
                                shape4 = shape3;
                                j9 = j8;
                                i6 = 26608441;
                                mutableInteractionSource3 = null;
                                floatingActionButtonElevation3 = obj3;
                            } else {
                                obj = companion;
                                j9 = j8;
                                i6 = 26608441;
                                floatingActionButtonElevation3 = obj3;
                                mutableInteractionSource3 = obj4;
                                shape4 = shape3;
                            }
                            j10 = j4;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:207)");
                        }
                        m2114FloatingActionButtonXz6DiA(function02, SizeKt.m868sizeInqDBjuR0$default(obj, FabSmallTokens.INSTANCE.m3420getContainerWidthD9Ej5fM(), FabSmallTokens.INSTANCE.m3419getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j9, j10, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = obj;
                        composer2 = startRestartGroup;
                        shape2 = shape4;
                        j5 = j9;
                        j6 = j10;
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = obj;
                        shape2 = obj2;
                        composer2 = startRestartGroup;
                        floatingActionButtonElevation2 = obj3;
                        j5 = j3;
                        j6 = j4;
                        mutableInteractionSource2 = obj4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj5, Object obj6) {
                                return FloatingActionButtonKt.SmallFloatingActionButton_X_z6DiA$lambda$5(Function0.this, modifier2, shape2, j5, j6, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj4 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        obj4 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* renamed from: LargeFloatingActionButton-X-z6DiA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2116LargeFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        Object obj2;
        long j3;
        long j4;
        Object obj3;
        int i4;
        Object obj4;
        final Modifier modifier2;
        final Shape shape2;
        Composer composer2;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        int i5;
        long j7;
        long j8;
        long j9;
        int i6;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j10;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1274576261);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)263@12410L441:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    obj2 = shape;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                obj2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(obj3)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    obj3 = floatingActionButtonElevation;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                obj3 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                obj4 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "256@12075L10,257@12144L14,258@12186L31,259@12295L11");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            floatingActionButtonElevation3 = obj3;
                            j9 = j3;
                            j10 = j4;
                            mutableInteractionSource3 = obj4;
                            i6 = 1274576261;
                            shape4 = obj2;
                        } else {
                            Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                shape3 = FloatingActionButtonDefaults.INSTANCE.getLargeShape(startRestartGroup, 6);
                            } else {
                                shape3 = obj2;
                            }
                            if ((i2 & 8) != 0) {
                                i5 = i3 & (-7169);
                                j7 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            } else {
                                i5 = i3;
                                j7 = j3;
                            }
                            if ((i2 & 16) != 0) {
                                i5 &= -57345;
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j7, startRestartGroup, (i5 >> 9) & 14);
                            }
                            int i10 = i5;
                            if ((i2 & 32) != 0) {
                                j8 = j7;
                                obj3 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 = i10 & (-458753);
                            } else {
                                j8 = j7;
                                i3 = i10;
                            }
                            if (i4 != 0) {
                                obj = companion;
                                shape4 = shape3;
                                j9 = j8;
                                i6 = 1274576261;
                                mutableInteractionSource3 = null;
                                floatingActionButtonElevation3 = obj3;
                            } else {
                                obj = companion;
                                j9 = j8;
                                i6 = 1274576261;
                                floatingActionButtonElevation3 = obj3;
                                mutableInteractionSource3 = obj4;
                                shape4 = shape3;
                            }
                            j10 = j4;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:262)");
                        }
                        m2114FloatingActionButtonXz6DiA(function02, SizeKt.m868sizeInqDBjuR0$default(obj, FabLargeTokens.INSTANCE.m3394getContainerWidthD9Ej5fM(), FabLargeTokens.INSTANCE.m3393getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j9, j10, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = obj;
                        composer2 = startRestartGroup;
                        shape2 = shape4;
                        j5 = j9;
                        j6 = j10;
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = obj;
                        shape2 = obj2;
                        composer2 = startRestartGroup;
                        floatingActionButtonElevation2 = obj3;
                        j5 = j3;
                        j6 = j4;
                        mutableInteractionSource2 = obj4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj5, Object obj6) {
                                return FloatingActionButtonKt.LargeFloatingActionButton_X_z6DiA$lambda$6(Function0.this, modifier2, shape2, j5, j6, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj4 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        obj4 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* renamed from: ExtendedFloatingActionButton-X-z6DiA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2112ExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        Object obj;
        int i4;
        final Modifier modifier2;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape3;
        Composer composer2;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        long j7;
        boolean z;
        Shape shape4;
        long j8;
        Modifier modifier4;
        MutableInteractionSource mutableInteractionSource3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        int i5;
        long j9;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1039585610);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)329@15450L335,321@15187L598:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    shape2 = shape;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj = floatingActionButtonElevation;
                    if (startRestartGroup.changed(obj)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    obj = floatingActionButtonElevation;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                obj = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
            }
            if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "314@14837L16,315@14912L14,316@14954L31,317@15063L11");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    mutableInteractionSource3 = mutableInteractionSource;
                    z = true;
                    floatingActionButtonElevation3 = obj;
                    j8 = j4;
                    i5 = 12582912;
                    i6 = 1039585610;
                    modifier4 = modifier;
                    shape4 = shape2;
                    j9 = j3;
                } else {
                    Modifier.Companion companion = i9 != 0 ? Modifier.Companion : modifier;
                    if ((i2 & 4) != 0) {
                        shape2 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(startRestartGroup, 6);
                        i3 &= -897;
                    }
                    Shape shape5 = shape2;
                    if ((i2 & 8) != 0) {
                        j3 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i3 &= -7169;
                    }
                    int i10 = i3;
                    long j10 = j3;
                    if ((i2 & 16) != 0) {
                        i10 &= -57345;
                        j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j10, startRestartGroup, (i10 >> 9) & 14);
                    }
                    int i11 = i10;
                    if ((i2 & 32) != 0) {
                        j7 = j10;
                        modifier3 = companion;
                        z = true;
                        obj = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                        i3 = i11 & (-458753);
                    } else {
                        modifier3 = companion;
                        j7 = j10;
                        z = true;
                        i3 = i11;
                    }
                    if (i4 != 0) {
                        shape4 = shape5;
                        j8 = j4;
                        modifier4 = modifier3;
                        mutableInteractionSource3 = null;
                    } else {
                        shape4 = shape5;
                        j8 = j4;
                        modifier4 = modifier3;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    floatingActionButtonElevation3 = obj;
                    i5 = 12582912;
                    j9 = j7;
                    i6 = 1039585610;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:320)");
                }
                m2114FloatingActionButtonXz6DiA(function02, modifier4, shape4, j9, j8, floatingActionButtonElevation3, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-1233936436, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        float f;
                        float f2;
                        ComposerKt.sourceInformation(composer3, "C330@15460L319:FloatingActionButton.kt#uh7d8r");
                        if (composer3.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1233936436, i12, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:330)");
                            }
                            f = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                            Modifier m868sizeInqDBjuR0$default = SizeKt.m868sizeInqDBjuR0$default(Modifier.Companion, f, 0.0f, 0.0f, 0.0f, 14, null);
                            f2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                            Modifier m820paddingVpY3zN4$default = PaddingKt.m820paddingVpY3zN4$default(m868sizeInqDBjuR0$default, f2, 0.0f, 2, null);
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m820paddingVpY3zN4$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer3);
                            Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | i5 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = startRestartGroup;
                modifier2 = modifier4;
                shape3 = shape4;
                j5 = j9;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                mutableInteractionSource2 = mutableInteractionSource;
                shape3 = shape2;
                composer2 = startRestartGroup;
                floatingActionButtonElevation2 = obj;
                j5 = j3;
                j6 = j4;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$7(Function0.this, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource2, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (!startRestartGroup.shouldExecute((4793491 & i3) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* renamed from: ExtendedFloatingActionButton-ElI5-7k  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2111ExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Modifier.Companion companion;
        int i4;
        final boolean z2;
        Object obj;
        long j3;
        int i5;
        Object obj2;
        int i6;
        int i7;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape2;
        final long j4;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        long j6;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1161000600);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)400@18910L1159,392@18647L1422:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
            }
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj = shape;
                        if (startRestartGroup.changed(obj)) {
                            i10 = 131072;
                            i3 |= i10;
                        }
                    } else {
                        obj = shape;
                    }
                    i10 = 65536;
                    i3 |= i10;
                } else {
                    obj = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = 1048576;
                            i3 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = 524288;
                    i3 |= i9;
                } else {
                    j3 = j;
                }
                if ((i & 12582912) == 0) {
                    i5 = 12582912;
                    i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                } else {
                    i5 = 12582912;
                }
                if ((i & 100663296) == 0) {
                    if ((i2 & 256) == 0) {
                        obj2 = floatingActionButtonElevation;
                        if (startRestartGroup.changed(obj2)) {
                            i8 = 67108864;
                            i3 |= i8;
                        }
                    } else {
                        obj2 = floatingActionButtonElevation;
                    }
                    i8 = 33554432;
                    i3 |= i8;
                } else {
                    obj2 = floatingActionButtonElevation;
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                    i3 |= 805306368;
                } else if ((805306368 & i) == 0) {
                    i3 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    i7 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i7 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "386@18343L16,387@18418L14,388@18460L31,389@18569L11");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 32) != 0) {
                                obj = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(startRestartGroup, 6);
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                j3 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i7 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                j6 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i7 >> 18) & 14);
                                i7 &= -29360129;
                            } else {
                                j6 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                obj2 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i7 &= -234881025;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource3 = null;
                                long j7 = j3;
                                FloatingActionButtonElevation floatingActionButtonElevation3 = obj2;
                                int i12 = i7;
                                Shape shape3 = obj;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1161000600, i12, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:391)");
                                }
                                int i13 = i12 >> 6;
                                int i14 = i12 >> 9;
                                Modifier modifier3 = companion;
                                m2114FloatingActionButtonXz6DiA(function02, modifier3, shape3, j7, j6, floatingActionButtonElevation3, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        float m7555constructorimpl;
                                        float m7555constructorimpl2;
                                        float m3391getContainerWidthD9Ej5fM;
                                        EnterTransition extendedFabExpandAnimation;
                                        ExitTransition extendedFabCollapseAnimation;
                                        ComposerKt.sourceInformation(composer2, "C404@19072L991:FloatingActionButton.kt#uh7d8r");
                                        if (!composer2.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(632971498, i15, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:401)");
                                        }
                                        if (z2) {
                                            m7555constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                                        } else {
                                            m7555constructorimpl = Dp.m7555constructorimpl(0.0f);
                                        }
                                        float f = m7555constructorimpl;
                                        if (z2) {
                                            m7555constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                                        } else {
                                            m7555constructorimpl2 = Dp.m7555constructorimpl(0.0f);
                                        }
                                        float f2 = m7555constructorimpl2;
                                        Modifier.Companion companion2 = Modifier.Companion;
                                        if (z2) {
                                            m3391getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                                        } else {
                                            m3391getContainerWidthD9Ej5fM = FabBaselineTokens.INSTANCE.m3391getContainerWidthD9Ej5fM();
                                        }
                                        Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(SizeKt.m868sizeInqDBjuR0$default(companion2, m3391getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                        Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function23 = function22;
                                        boolean z4 = z2;
                                        Function2<Composer, Integer, Unit> function24 = function2;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m822paddingqDBjuR0$default);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m4041constructorimpl = Updater.m4041constructorimpl(composer2);
                                        Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                        ComposerKt.sourceInformationMarkerStart(composer2, -145916491, "C418@19669L6,421@19768L28,422@19821L30,423@19867L186,419@19688L365:FloatingActionButton.kt#uh7d8r");
                                        function23.invoke(composer2, 0);
                                        extendedFabExpandAnimation = FloatingActionButtonKt.extendedFabExpandAnimation(composer2, 0);
                                        extendedFabCollapseAnimation = FloatingActionButtonKt.extendedFabCollapseAnimation(composer2, 0);
                                        AnimatedVisibilityKt.AnimatedVisibility(RowScopeInstance.INSTANCE, z4, (Modifier) null, extendedFabExpandAnimation, extendedFabCollapseAnimation, (String) null, ComposableLambdaKt.rememberComposableLambda(-660008666, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1(function24), composer2, 54), composer2, 1572870, 18);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, (i13 & 112) | (i13 & 14) | i5 | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (i14 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z3 = z2;
                                modifier2 = modifier3;
                                shape2 = shape3;
                                j4 = j7;
                                j5 = j6;
                                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i7 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i7 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i7 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i7 &= -234881025;
                            }
                            j6 = j2;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        long j72 = j3;
                        FloatingActionButtonElevation floatingActionButtonElevation32 = obj2;
                        int i122 = i7;
                        Shape shape32 = obj;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i132 = i122 >> 6;
                        int i142 = i122 >> 9;
                        Modifier modifier32 = companion;
                        m2114FloatingActionButtonXz6DiA(function02, modifier32, shape32, j72, j6, floatingActionButtonElevation32, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                float m7555constructorimpl;
                                float m7555constructorimpl2;
                                float m3391getContainerWidthD9Ej5fM;
                                EnterTransition extendedFabExpandAnimation;
                                ExitTransition extendedFabCollapseAnimation;
                                ComposerKt.sourceInformation(composer2, "C404@19072L991:FloatingActionButton.kt#uh7d8r");
                                if (!composer2.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(632971498, i15, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:401)");
                                }
                                if (z2) {
                                    m7555constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                                } else {
                                    m7555constructorimpl = Dp.m7555constructorimpl(0.0f);
                                }
                                float f = m7555constructorimpl;
                                if (z2) {
                                    m7555constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                                } else {
                                    m7555constructorimpl2 = Dp.m7555constructorimpl(0.0f);
                                }
                                float f2 = m7555constructorimpl2;
                                Modifier.Companion companion2 = Modifier.Companion;
                                if (z2) {
                                    m3391getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                                } else {
                                    m3391getContainerWidthD9Ej5fM = FabBaselineTokens.INSTANCE.m3391getContainerWidthD9Ej5fM();
                                }
                                Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(SizeKt.m868sizeInqDBjuR0$default(companion2, m3391getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function23 = function22;
                                boolean z4 = z2;
                                Function2<Composer, Integer, Unit> function24 = function2;
                                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m822paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m4041constructorimpl = Updater.m4041constructorimpl(composer2);
                                Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                ComposerKt.sourceInformationMarkerStart(composer2, -145916491, "C418@19669L6,421@19768L28,422@19821L30,423@19867L186,419@19688L365:FloatingActionButton.kt#uh7d8r");
                                function23.invoke(composer2, 0);
                                extendedFabExpandAnimation = FloatingActionButtonKt.extendedFabExpandAnimation(composer2, 0);
                                extendedFabCollapseAnimation = FloatingActionButtonKt.extendedFabCollapseAnimation(composer2, 0);
                                AnimatedVisibilityKt.AnimatedVisibility(RowScopeInstance.INSTANCE, z4, (Modifier) null, extendedFabExpandAnimation, extendedFabCollapseAnimation, (String) null, ComposableLambdaKt.rememberComposableLambda(-660008666, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1(function24), composer2, 54), composer2, 1572870, 18);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i132 & 112) | (i132 & 14) | i5 | (i142 & 896) | (i142 & 7168) | (57344 & i142) | (458752 & i142) | (i142 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z3 = z2;
                        modifier2 = modifier32;
                        shape2 = shape32;
                        j4 = j72;
                        j5 = j6;
                        floatingActionButtonElevation2 = floatingActionButtonElevation32;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = companion;
                        z3 = z2;
                        shape2 = obj;
                        j4 = j3;
                        floatingActionButtonElevation2 = obj2;
                        j5 = j2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$8(Function2.this, function22, function0, modifier2, z3, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i7 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i6 = i2 & 512;
            if (i6 != 0) {
            }
            i7 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i7 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z2 = z;
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i6 = i2 & 512;
        if (i6 != 0) {
        }
        i7 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i7 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x01ca, code lost:
        if (r4.changed(r51) == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* renamed from: ExtendedFloatingActionButton-qtIzBjc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m2113ExtendedFloatingActionButtonqtIzBjc(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function0<Unit> function0, final TextStyle textStyle, final float f, final float f2, final float f3, final float f4, final float f5, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        float f6;
        int i5;
        int i6;
        int i7;
        int i8;
        long j3;
        int i9;
        Composer composer2;
        final Modifier modifier2;
        final boolean z2;
        final Shape shape2;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        Modifier modifier3;
        int i10;
        boolean z3;
        long j6;
        long j7;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        long j8;
        Shape shape4;
        long j9;
        FloatingActionButtonElevation floatingActionButtonElevation4;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(193103278);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)N(text,icon,onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,startPadding:c#ui.unit.Dp,endPadding:c#ui.unit.Dp,iconPadding:c#ui.unit.Dp,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)463@21128L1923,452@20763L2288:FloatingActionButton.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
                int i13 = 1024;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
                    int i14 = 16384;
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= startRestartGroup.changed(f) ? 16384 : 8192;
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            f6 = f2;
                        } else {
                            f6 = f2;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                            }
                        }
                        if ((i3 & 64) != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                        }
                        if ((i3 & 128) != 0) {
                            i4 |= 12582912;
                        } else if ((12582912 & i) == 0) {
                            i4 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                            if ((i3 & 256) == 0) {
                                i4 |= 100663296;
                            } else if ((100663296 & i) == 0) {
                                i4 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
                                i5 = i3 & 512;
                                if (i5 != 0) {
                                    i4 |= 805306368;
                                } else if ((i & 805306368) == 0) {
                                    i4 |= startRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                }
                                i6 = i3 & 1024;
                                if (i6 != 0) {
                                    i8 = i2 | 6;
                                    i7 = i6;
                                } else if ((i2 & 6) == 0) {
                                    i7 = i6;
                                    i8 = i2 | (startRestartGroup.changed(z) ? 4 : 2);
                                } else {
                                    i7 = i6;
                                    i8 = i2;
                                }
                                if ((i2 & 48) == 0) {
                                    if ((i3 & 2048) == 0 && startRestartGroup.changed(shape)) {
                                        i12 = 32;
                                        i8 |= i12;
                                    }
                                    i12 = 16;
                                    i8 |= i12;
                                }
                                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    i8 |= ((i3 & 4096) == 0 && startRestartGroup.changed(j)) ? 256 : 128;
                                }
                                if ((i2 & 3072) == 0) {
                                    j3 = j2;
                                    if ((i3 & 8192) == 0 && startRestartGroup.changed(j3)) {
                                        i13 = 2048;
                                    }
                                    i8 |= i13;
                                } else {
                                    j3 = j2;
                                }
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) != 0) {
                                    }
                                    i14 = 8192;
                                    i8 |= i14;
                                }
                                i9 = i3 & 32768;
                                if (i9 != 0) {
                                    i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i8 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                                }
                                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "446@20459L16,447@20534L14,448@20576L31,449@20685L11");
                                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 2048) != 0) {
                                            i8 &= -113;
                                        }
                                        i11 = i8;
                                        if ((i3 & 4096) != 0) {
                                            i11 &= -897;
                                        }
                                        if ((i3 & 8192) != 0) {
                                            i11 &= -7169;
                                        }
                                        if ((i3 & 16384) != 0) {
                                            i11 &= -57345;
                                        }
                                        modifier3 = modifier;
                                        z3 = z;
                                        shape4 = shape;
                                        j9 = j;
                                        floatingActionButtonElevation4 = floatingActionButtonElevation;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        composer2 = startRestartGroup;
                                        j8 = j3;
                                    } else {
                                        Modifier.Companion companion = i5 != 0 ? Modifier.Companion : modifier;
                                        boolean z4 = i7 != 0 ? true : z;
                                        if ((i3 & 2048) != 0) {
                                            shape3 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(startRestartGroup, 6);
                                            i8 &= -113;
                                        } else {
                                            shape3 = shape;
                                        }
                                        int i15 = i8;
                                        if ((i3 & 4096) != 0) {
                                            modifier3 = companion;
                                            i10 = i15 & (-897);
                                            z3 = z4;
                                            j6 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                        } else {
                                            modifier3 = companion;
                                            i10 = i15;
                                            z3 = z4;
                                            j6 = j;
                                        }
                                        if ((i3 & 8192) != 0) {
                                            j7 = ColorSchemeKt.m1902contentColorForek8zF_U(j6, startRestartGroup, (i10 >> 6) & 14);
                                            i10 &= -7169;
                                        } else {
                                            j7 = j2;
                                        }
                                        long j10 = j6;
                                        if ((i3 & 16384) != 0) {
                                            floatingActionButtonElevation3 = FloatingActionButtonDefaults.INSTANCE.m2105elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                            composer2 = startRestartGroup;
                                            i10 &= -57345;
                                        } else {
                                            composer2 = startRestartGroup;
                                            floatingActionButtonElevation3 = floatingActionButtonElevation;
                                        }
                                        mutableInteractionSource3 = i9 != 0 ? null : mutableInteractionSource;
                                        j8 = j7;
                                        shape4 = shape3;
                                        j9 = j10;
                                        floatingActionButtonElevation4 = floatingActionButtonElevation3;
                                        i11 = i10;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(193103278, i4, i11, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:451)");
                                    }
                                    boolean z5 = z3;
                                    int i16 = i4 >> 6;
                                    int i17 = (i16 & 112) | (i16 & 14) | 3456 | ((i4 >> 15) & 57344);
                                    int i18 = i11 << 12;
                                    Modifier modifier4 = modifier3;
                                    m2115FloatingActionButtonlFWlFE(function0, textStyle, Dp.Companion.m7575getUnspecifiedD9Ej5fM(), Dp.Companion.m7575getUnspecifiedD9Ej5fM(), modifier4, shape4, j9, j8, floatingActionButtonElevation4, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-827388388, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(z5, f, f6, f3, f4, function22, f5, function2), composer2, 54), composer2, i17 | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & 1879048192), 6, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    floatingActionButtonElevation2 = floatingActionButtonElevation4;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    j5 = j8;
                                    shape2 = shape4;
                                    j4 = j9;
                                    z2 = z5;
                                    modifier2 = modifier4;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    z2 = z;
                                    shape2 = shape;
                                    j4 = j;
                                    j5 = j2;
                                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$9(Function2.this, function22, function0, textStyle, f, f2, f3, f4, f5, modifier2, z2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 = i3 & 512;
                            if (i5 != 0) {
                            }
                            i6 = i3 & 1024;
                            if (i6 != 0) {
                            }
                            if ((i2 & 48) == 0) {
                            }
                            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            }
                            if ((i2 & 3072) == 0) {
                            }
                            if ((i2 & 24576) == 0) {
                            }
                            i9 = i3 & 32768;
                            if (i9 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i3 & 256) == 0) {
                        }
                        i5 = i3 & 512;
                        if (i5 != 0) {
                        }
                        i6 = i3 & 1024;
                        if (i6 != 0) {
                        }
                        if ((i2 & 48) == 0) {
                        }
                        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        }
                        if ((i2 & 3072) == 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        i9 = i3 & 32768;
                        if (i9 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) == 0) {
                    }
                    i5 = i3 & 512;
                    if (i5 != 0) {
                    }
                    i6 = i3 & 1024;
                    if (i6 != 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    }
                    if ((i2 & 3072) == 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    i9 = i3 & 32768;
                    if (i9 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                int i142 = 16384;
                if ((i3 & 16) == 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) == 0) {
                }
                i5 = i3 & 512;
                if (i5 != 0) {
                }
                i6 = i3 & 1024;
                if (i6 != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                }
                if ((i2 & 3072) == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i9 = i3 & 32768;
                if (i9 != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            int i132 = 1024;
            if ((i3 & 8) != 0) {
            }
            int i1422 = 16384;
            if ((i3 & 16) == 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) == 0) {
            }
            i5 = i3 & 512;
            if (i5 != 0) {
            }
            i6 = i3 & 1024;
            if (i6 != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            }
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i9 = i3 & 32768;
            if (i9 != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        int i1322 = 1024;
        if ((i3 & 8) != 0) {
        }
        int i14222 = 16384;
        if ((i3 & 16) == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) == 0) {
        }
        i5 = i3 & 512;
        if (i5 != 0) {
        }
        i6 = i3 & 1024;
        if (i6 != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i9 = i3 & 32768;
        if (i9 != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i8 & 74899) != 74898, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition extendedFabCollapseAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -56172201, "C(extendedFabCollapseAnimation)797@35053L7,800@35162L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-56172201, i, -1, "androidx.compose.material3.extendedFabCollapseAnimation (FloatingActionButton.kt:795)");
        }
        ExitTransition plus = EnterExitTransitionKt.fadeOut$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return plus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition extendedFabExpandAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -719787506, "C(extendedFabExpandAnimation)808@35431L7,811@35537L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-719787506, i, -1, "androidx.compose.material3.extendedFabExpandAnimation (FloatingActionButton.kt:806)");
        }
        EnterTransition plus = EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return plus;
    }
}

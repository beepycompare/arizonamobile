package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001at\u0010\u0012\u001a\u00020\u00012\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0002\u0010\u0018\u001aK\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%\u001aS\u0010&\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b/\u00100\u001an\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001072\b\u00109\u001a\u0004\u0018\u0001072\b\u0010:\u001a\u0004\u0018\u0001072\b\u0010;\u001a\u0004\u0018\u0001072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u001aH\u0002\u001a2\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0011\u0010F\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0004\bG\u0010H\u001a\u0014\u0010^\u001a\u00020=*\u00020_2\u0006\u0010`\u001a\u00020\u001aH\u0002\u001a\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002¢\u0006\u0004\ba\u0010b\"\u001e\u0010I\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u001e\u0010O\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u001e\u0010R\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010M\"\u001e\u0010U\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bV\u0010K\u001a\u0004\bW\u0010M\"\u001e\u0010X\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bY\u0010K\u001a\u0004\bZ\u0010M\"\u001e\u0010[\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\b\\\u0010K\u001a\u0004\b]\u0010M¨\u0006c"}, d2 = {"ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "calculateHeight", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "listItemType", "Landroidx/compose/material3/ListItemType;", "verticalPadding", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "isThreeLine", "", "startPadding", "endPadding", "topPadding", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", FirebaseAnalytics.Param.CONTENT, "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "()V", "getListItemVerticalPadding", "()F", "F", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "LeadingContentEndPadding", "getLeadingContentEndPadding$annotations", "getLeadingContentEndPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "isSupportingMultilineHeuristic", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "verticalPadding-yh95HIg", "(I)F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemKt {
    private static final float ListItemVerticalPadding = Dp.m7555constructorimpl(8.0f);
    private static final float ListItemThreeLineVerticalPadding = Dp.m7555constructorimpl(12.0f);
    private static final float ListItemStartPadding = Dp.m7555constructorimpl(16.0f);
    private static final float ListItemEndPadding = Dp.m7555constructorimpl(16.0f);
    private static final float LeadingContentEndPadding = Dp.m7555constructorimpl(16.0f);
    private static final float TrailingContentStartPadding = Dp.m7555constructorimpl(16.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ListItemLayout$lambda$8(Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, int i, Composer composer, int i2) {
        ListItemLayout(function2, function22, function23, function24, function25, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ListItem_HXNGIdc$lambda$6(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function2 function24, Function2 function25, ListItemColors listItemColors, float f, float f2, int i, int i2, Composer composer, int i3) {
        m2212ListItemHXNGIdc(function2, modifier, function22, function23, function24, function25, listItemColors, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProvideTextStyleFromToken_3J_VO9M$lambda$12(long j, TypographyKeyTokens typographyKeyTokens, Function2 function2, int i, Composer composer, int i2) {
        m2213ProvideTextStyleFromToken3JVO9M(j, typographyKeyTokens, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* renamed from: ListItem-HXNGIdc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2212ListItemHXNGIdc(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, ListItemColors listItemColors, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final Object obj;
        int i5;
        final Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final float f3;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final ListItemColors listItemColors2;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        ListItemColors listItemColors3;
        int i13;
        float f5;
        int i14;
        float f6;
        final ListItemColors listItemColors4;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        ComposableLambda rememberComposableLambda;
        ComposableLambda rememberComposableLambda2;
        Function2<? super Composer, ? super Integer, Unit> function211;
        ComposableLambda rememberComposableLambda3;
        final ComposableLambda composableLambda;
        Object rememberedValue;
        Composer startRestartGroup = composer.startRestartGroup(487133126);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItem)N(headlineContent,modifier,overlineContent,supportingContent,leadingContent,trailingContent,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp)105@4827L177,157@6607L2,158@6659L5,163@6858L288,156@6535L611:ListItem.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = function22;
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj2 = function23;
                    i3 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj3 = function24;
                        i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            obj4 = function25;
                            i3 |= startRestartGroup.changedInstance(obj4) ? 131072 : 65536;
                            if ((i & 1572864) == 0) {
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(listItemColors)) ? 1048576 : 524288;
                            }
                            i8 = i2 & 128;
                            if (i8 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                                i10 = i2 & 256;
                                if (i10 != 0) {
                                    i3 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    i11 = i10;
                                    i3 |= startRestartGroup.changed(f2) ? 67108864 : 33554432;
                                    i12 = i3;
                                    if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "101@4647L8");
                                        ComposableLambda composableLambda2 = null;
                                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i2 & 64) != 0) {
                                                listItemColors4 = listItemColors;
                                                f6 = f;
                                                f5 = f2;
                                                i14 = i12 & (-3670017);
                                            } else {
                                                listItemColors4 = listItemColors;
                                                f6 = f;
                                                f5 = f2;
                                                i14 = i12;
                                            }
                                        } else {
                                            if (i15 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i4 != 0) {
                                                obj = null;
                                            }
                                            if (i5 != 0) {
                                                obj2 = null;
                                            }
                                            if (i6 != 0) {
                                                obj3 = null;
                                            }
                                            if (i7 != 0) {
                                                obj4 = null;
                                            }
                                            if ((i2 & 64) != 0) {
                                                listItemColors3 = ListItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                                i13 = i12 & (-3670017);
                                            } else {
                                                listItemColors3 = listItemColors;
                                                i13 = i12;
                                            }
                                            float m2211getElevationD9Ej5fM = i9 != 0 ? ListItemDefaults.INSTANCE.m2211getElevationD9Ej5fM() : f;
                                            if (i11 == 0) {
                                                f5 = f2;
                                                i14 = i13;
                                                f6 = m2211getElevationD9Ej5fM;
                                                function29 = obj4;
                                                listItemColors4 = listItemColors3;
                                                function210 = obj3;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(487133126, i14, -1, "androidx.compose.material3.ListItem (ListItem.kt:104)");
                                                }
                                                final ComposableLambda rememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(629852750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i16) {
                                                        ComposerKt.sourceInformation(composer3, "C106@4837L161:ListItem.kt#uh7d8r");
                                                        if (composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(629852750, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:106)");
                                                            }
                                                            ListItemKt.m2213ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2205headlineColorvNxB06k$material3(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer3, 48);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, startRestartGroup, 54);
                                                if (obj2 != null) {
                                                    startRestartGroup.startReplaceGroup(-510713870);
                                                    startRestartGroup.endReplaceGroup();
                                                    rememberComposableLambda = null;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-510713869);
                                                    ComposerKt.sourceInformation(startRestartGroup, "*114@5114L205");
                                                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1291211644, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i16) {
                                                            ComposerKt.sourceInformation(composer3, "C115@5132L173:ListItem.kt#uh7d8r");
                                                            if (composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1291211644, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:115)");
                                                                }
                                                                ListItemKt.m2213ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2208supportingColor0d7_KjU$material3(), ListTokens.INSTANCE.getListItemSupportingTextFont(), obj2, composer3, 48);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer3.skipToGroupEnd();
                                                        }
                                                    }, startRestartGroup, 54);
                                                    startRestartGroup.endReplaceGroup();
                                                }
                                                if (obj != null) {
                                                    startRestartGroup.startReplaceGroup(-510395686);
                                                    startRestartGroup.endReplaceGroup();
                                                    rememberComposableLambda2 = null;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-510395685);
                                                    ComposerKt.sourceInformation(startRestartGroup, "*124@5435L197");
                                                    rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(372414991, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i16) {
                                                            ComposerKt.sourceInformation(composer3, "C125@5453L165:ListItem.kt#uh7d8r");
                                                            if (composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(372414991, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:125)");
                                                                }
                                                                ListItemKt.m2213ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2207overlineColor0d7_KjU$material3(), ListTokens.INSTANCE.getListItemOverlineFont(), obj, composer3, 48);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer3.skipToGroupEnd();
                                                        }
                                                    }, startRestartGroup, 54);
                                                    startRestartGroup.endReplaceGroup();
                                                }
                                                if (function210 != null) {
                                                    startRestartGroup.startReplaceGroup(-510083888);
                                                    startRestartGroup.endReplaceGroup();
                                                    function211 = function210;
                                                    rememberComposableLambda3 = null;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-510083887);
                                                    ComposerKt.sourceInformation(startRestartGroup, "*134@5746L303");
                                                    function211 = function210;
                                                    rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(449548451, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i16) {
                                                            ComposerKt.sourceInformation(composer3, "C135@5764L271:ListItem.kt#uh7d8r");
                                                            if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(449548451, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:135)");
                                                            }
                                                            Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ListItemKt.getLeadingContentEndPadding(), 0.0f, 11, null);
                                                            ListItemColors listItemColors5 = ListItemColors.this;
                                                            Function2<Composer, Integer, Unit> function212 = function210;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
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
                                                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 788364341, "C136@5840L177:ListItem.kt#uh7d8r");
                                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(listItemColors5.m2206leadingIconColorvNxB06k$material3(true))), function212, composer3, ProvidedValue.$stable);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            composer3.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, startRestartGroup, 54);
                                                    startRestartGroup.endReplaceGroup();
                                                }
                                                if (function29 != null) {
                                                    startRestartGroup.startReplaceGroup(-509666659);
                                                    startRestartGroup.endReplaceGroup();
                                                    composableLambda = rememberComposableLambda3;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-509666658);
                                                    ComposerKt.sourceInformation(startRestartGroup, "*145@6165L354");
                                                    composableLambda = rememberComposableLambda3;
                                                    composableLambda2 = ComposableLambdaKt.rememberComposableLambda(1946411067, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i16) {
                                                            ComposerKt.sourceInformation(composer3, "C146@6183L322:ListItem.kt#uh7d8r");
                                                            if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1946411067, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:146)");
                                                            }
                                                            Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(Modifier.Companion, ListItemKt.getTrailingContentStartPadding(), 0.0f, 0.0f, 0.0f, 14, null);
                                                            ListItemColors listItemColors5 = ListItemColors.this;
                                                            Function2<Composer, Integer, Unit> function212 = function29;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
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
                                                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -869008925, "C147@6264L223:ListItem.kt#uh7d8r");
                                                            ListItemKt.m2213ProvideTextStyleFromToken3JVO9M(listItemColors5.m2209trailingIconColorvNxB06k$material3(true), ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function212, composer3, 48);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            composer3.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, startRestartGroup, 54);
                                                    startRestartGroup.endReplaceGroup();
                                                }
                                                Modifier.Companion companion2 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -16426520, "CC(remember):ListItem.kt#9igjgp");
                                                rememberedValue = startRestartGroup.rememberedValue();
                                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                                    rememberedValue = new Function1() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj5) {
                                                            Unit unit;
                                                            SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj5;
                                                            unit = Unit.INSTANCE;
                                                            return unit;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final ComposableLambda composableLambda3 = rememberComposableLambda2;
                                                final ComposableLambda composableLambda4 = rememberComposableLambda;
                                                final ComposableLambda composableLambda5 = composableLambda2;
                                                int i16 = i14 >> 9;
                                                composer2 = startRestartGroup;
                                                SurfaceKt.m2569SurfaceT9BRK9s(SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors4.m2194containerColor0d7_KjU$material3(), listItemColors4.m2205headlineColorvNxB06k$material3(true), f6, f5, null, ComposableLambdaKt.rememberComposableLambda(1192488737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i17) {
                                                        ComposerKt.sourceInformation(composer3, "C164@6868L272:ListItem.kt#uh7d8r");
                                                        if (composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1192488737, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:164)");
                                                            }
                                                            ListItemKt.ListItemLayout(composableLambda, composableLambda5, rememberComposableLambda4, composableLambda3, composableLambda4, composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, startRestartGroup, 54), composer2, (57344 & i16) | 12582912 | (i16 & 458752), 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                modifier2 = companion;
                                                function26 = obj;
                                                listItemColors2 = listItemColors4;
                                                function27 = obj2;
                                                f3 = f6;
                                                f4 = f5;
                                                function28 = function211;
                                            } else {
                                                f6 = m2211getElevationD9Ej5fM;
                                                f5 = ListItemDefaults.INSTANCE.m2211getElevationD9Ej5fM();
                                                listItemColors4 = listItemColors3;
                                                i14 = i13;
                                            }
                                        }
                                        function210 = obj3;
                                        function29 = obj4;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> rememberComposableLambda42 = ComposableLambdaKt.rememberComposableLambda(629852750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i162) {
                                                ComposerKt.sourceInformation(composer3, "C106@4837L161:ListItem.kt#uh7d8r");
                                                if (composer3.shouldExecute((i162 & 3) != 2, i162 & 1)) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(629852750, i162, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:106)");
                                                    }
                                                    ListItemKt.m2213ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2205headlineColorvNxB06k$material3(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer3, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54);
                                        if (obj2 != null) {
                                        }
                                        if (obj != null) {
                                        }
                                        if (function210 != null) {
                                        }
                                        if (function29 != null) {
                                        }
                                        Modifier.Companion companion22 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -16426520, "CC(remember):ListItem.kt#9igjgp");
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Function2<? super Composer, ? super Integer, Unit> composableLambda32 = rememberComposableLambda2;
                                        final Function2<? super Composer, ? super Integer, Unit> composableLambda42 = rememberComposableLambda;
                                        final Function2<? super Composer, ? super Integer, Unit> composableLambda52 = composableLambda2;
                                        int i162 = i14 >> 9;
                                        composer2 = startRestartGroup;
                                        SurfaceKt.m2569SurfaceT9BRK9s(SemanticsModifierKt.semantics(companion22, true, (Function1) rememberedValue).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors4.m2194containerColor0d7_KjU$material3(), listItemColors4.m2205headlineColorvNxB06k$material3(true), f6, f5, null, ComposableLambdaKt.rememberComposableLambda(1192488737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i17) {
                                                ComposerKt.sourceInformation(composer3, "C164@6868L272:ListItem.kt#uh7d8r");
                                                if (composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1192488737, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:164)");
                                                    }
                                                    ListItemKt.ListItemLayout(composableLambda, composableLambda52, rememberComposableLambda42, composableLambda32, composableLambda42, composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), composer2, (57344 & i162) | 12582912 | (i162 & 458752), 64);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        modifier2 = companion;
                                        function26 = obj;
                                        listItemColors2 = listItemColors4;
                                        function27 = obj2;
                                        f3 = f6;
                                        f4 = f5;
                                        function28 = function211;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        f3 = f;
                                        modifier2 = companion;
                                        function26 = obj;
                                        function27 = obj2;
                                        function28 = obj3;
                                        function29 = obj4;
                                        listItemColors2 = listItemColors;
                                        f4 = f2;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj5, Object obj6) {
                                                return ListItemKt.ListItem_HXNGIdc$lambda$6(Function2.this, modifier2, function26, function27, function28, function29, listItemColors2, f3, f4, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i11 = i10;
                                i12 = i3;
                                if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i9 = i8;
                            i10 = i2 & 256;
                            if (i10 != 0) {
                            }
                            i11 = i10;
                            i12 = i3;
                            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        obj4 = function25;
                        if ((i & 1572864) == 0) {
                        }
                        i8 = i2 & 128;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i2 & 256;
                        if (i10 != 0) {
                        }
                        i11 = i10;
                        i12 = i3;
                        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj3 = function24;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    obj4 = function25;
                    if ((i & 1572864) == 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    i12 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj2 = function23;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                obj3 = function24;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                obj4 = function25;
                if ((i & 1572864) == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                }
                i11 = i10;
                i12 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj2 = function23;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            obj3 = function24;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            obj4 = function25;
            if ((i & 1572864) == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
            }
            i11 = i10;
            i12 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj2 = function23;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        obj3 = function24;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        obj4 = function25;
        if ((i & 1572864) == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 != 0) {
        }
        i11 = i10;
        i12 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i12 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-61277522);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItemLayout)N(leading,trailing,headline,overline,supporting)182@7421L36,183@7462L166:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-61277522, i2, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:181)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1241852210, "CC(remember):ListItem.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ListItemMeasurePolicy();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ListItemMeasurePolicy listItemMeasurePolicy = (ListItemMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function23;
            function2Arr[1] = function24 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1937getLambda$489887388$material3() : function24;
            function2Arr[2] = function25 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$1629163587$material3() : function25;
            function2Arr[3] = function2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1938getLambda$546752734$material3() : function2;
            function2Arr[4] = function22 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$1572298241$material3() : function22;
            List listOf = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.Companion;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(listItemMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.ListItemLayout$lambda$8(Function2.this, function22, function23, function24, function25, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y  reason: not valid java name */
    public static final int m2219calculateWidthyeHjK3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, long j) {
        if (Constraints.m7504getHasBoundedWidthimpl(j)) {
            return Constraints.m7508getMaxWidthimpl(j);
        }
        return i6 + i + Math.max(i3, Math.max(i4, i5)) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y  reason: not valid java name */
    public static final int m2218calculateHeightN4Jib3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        float m3519getListItemTwoLineContainerHeightD9Ej5fM;
        if (ListItemType.m2225equalsimpl0(i6, ListItemType.Companion.m2230getOneLineAlXitO8())) {
            m3519getListItemTwoLineContainerHeightD9Ej5fM = ListTokens.INSTANCE.m3514getListItemOneLineContainerHeightD9Ej5fM();
        } else {
            m3519getListItemTwoLineContainerHeightD9Ej5fM = ListItemType.m2225equalsimpl0(i6, ListItemType.Companion.m2232getTwoLineAlXitO8()) ? ListTokens.INSTANCE.m3519getListItemTwoLineContainerHeightD9Ej5fM() : ListTokens.INSTANCE.m3516getListItemThreeLineContainerHeightD9Ej5fM();
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.m7509getMinHeightimpl(j), intrinsicMeasureScope.mo399roundToPx0680j_4(m3519getListItemTwoLineContainerHeightD9Ej5fM)), i7 + Math.max(i, Math.max(i3 + i4 + i5, i2))), Constraints.m7507getMaxHeightimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult place(MeasureScope measureScope, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5, final boolean z, final int i3, final int i4, final int i5) {
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt.place$lambda$11(Placeable.this, i3, z, i5, placeable3, placeable4, placeable5, i2, placeable2, i, i4, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit place$lambda$11(Placeable placeable, int i, boolean z, int i2, Placeable placeable2, Placeable placeable3, Placeable placeable4, int i3, Placeable placeable5, int i4, int i5, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, z ? i2 : Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i3), 0.0f, 4, null);
        }
        int widthOrZero = i + LayoutUtilKt.getWidthOrZero(placeable);
        int align = z ? i2 : Alignment.Companion.getCenterVertically().align(LayoutUtilKt.getHeightOrZero(placeable2) + LayoutUtilKt.getHeightOrZero(placeable3) + LayoutUtilKt.getHeightOrZero(placeable4), i3);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, align, 0.0f, 4, null);
        }
        int heightOrZero = align + LayoutUtilKt.getHeightOrZero(placeable3);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, heightOrZero, 0.0f, 4, null);
        }
        int heightOrZero2 = heightOrZero + LayoutUtilKt.getHeightOrZero(placeable2);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, widthOrZero, heightOrZero2, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            int width = (i4 - i5) - placeable5.getWidth();
            if (!z) {
                i2 = Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i3);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, width, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M  reason: not valid java name */
    public static final void m2213ProvideTextStyleFromToken3JVO9M(long j, final TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        long j2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(-285397024);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyleFromToken)N(color:c#ui.graphics.Color,textToken,content)705@29794L5,703@29704L129:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(typographyKeyTokens.ordinal()) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            j2 = j;
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-285397024, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:703)");
            }
            j2 = j;
            ProvideContentColorTextStyleKt.m3007ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.getValue(typographyKeyTokens, startRestartGroup, (i2 >> 3) & 14), function2, startRestartGroup, i2 & 910);
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j3 = j2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.ProvideTextStyleFromToken_3J_VO9M$lambda$12(j3, typographyKeyTokens, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSupportingMultilineHeuristic(Density density, int i) {
        return i > density.mo398roundToPxR2X_6o(TextUnitKt.getSp(30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verticalPadding-yh95HIg  reason: not valid java name */
    public static final float m2220verticalPaddingyh95HIg(int i) {
        return ListItemType.m2225equalsimpl0(i, ListItemType.Companion.m2231getThreeLineAlXitO8()) ? ListItemThreeLineVerticalPadding : ListItemVerticalPadding;
    }
}

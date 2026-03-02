package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001aw\u0010\u0019\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "onClick", "Lkotlin/Function0;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Card$lambda$0(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Card$lambda$2(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedCard$lambda$3(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(modifier, shape, cardColors, cardElevation, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedCard$lambda$4(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(function0, modifier, z, shape, cardColors, cardElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OutlinedCard$lambda$5(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OutlinedCard$lambda$6(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        Object obj3;
        CardElevation cardElevation2;
        Object obj4;
        final Modifier modifier2;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation3;
        final BorderStroke borderStroke2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        CardColors cardColors3;
        boolean z;
        Modifier modifier3;
        CardElevation cardElevation4;
        BorderStroke borderStroke3;
        Shape shape4;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1359693790);
        ComposerKt.sourceInformation(startRestartGroup, "C(Card)N(modifier,shape,colors,elevation,border,content)92@4165L57,94@4261L41,87@3953L349:Card.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                obj2 = shape;
                if (startRestartGroup.changed(obj2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                obj2 = shape;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            obj2 = shape;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                obj3 = cardColors;
                if (startRestartGroup.changed(obj3)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                obj3 = cardColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            obj3 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed(cardElevation2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            cardElevation2 = cardElevation;
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            obj4 = borderStroke;
            i3 |= startRestartGroup.changed(obj4) ? 16384 : 8192;
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "81@3742L5,82@3787L12,83@3845L15");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    cardElevation4 = cardElevation2;
                    borderStroke3 = obj4;
                    modifier3 = obj;
                    shape4 = obj2;
                    cardColors3 = obj3;
                    z = true;
                } else {
                    Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                    if ((i2 & 2) != 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = obj2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColors3 = CardDefaults.INSTANCE.cardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = obj3;
                    }
                    if ((i2 & 8) != 0) {
                        z = true;
                        cardElevation2 = CardDefaults.INSTANCE.m1784cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        z = true;
                    }
                    CardElevation cardElevation5 = cardElevation2;
                    modifier3 = companion;
                    cardElevation4 = cardElevation5;
                    if (i8 != 0) {
                        shape4 = shape3;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        shape4 = shape3;
                    }
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1359693790, i3, -1, "androidx.compose.material3.Card (Card.kt:86)");
                }
                SurfaceKt.m2569SurfaceT9BRK9s(modifier3, shape4, cardColors3.m1776containerColorvNxB06k$material3(z), cardColors3.m1777contentColorvNxB06k$material3(z), 0.0f, cardElevation4.shadowElevation$material3(z, null, startRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m7569unboximpl(), borderStroke3, ComposableLambdaKt.rememberComposableLambda(-97109725, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C95@4271L25:Card.kt#uh7d8r");
                        if (!composer2.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-97109725, i9, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:95)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
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
                        Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 16);
                startRestartGroup = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors2 = cardColors3;
                shape2 = shape4;
                borderStroke2 = borderStroke3;
                cardElevation3 = cardElevation4;
                modifier2 = modifier3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier2 = obj;
                shape2 = obj2;
                cardColors2 = obj3;
                cardElevation3 = cardElevation2;
                borderStroke2 = borderStroke;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj5, Object obj6) {
                        return CardKt.Card$lambda$0(Modifier.this, shape2, cardColors2, cardElevation3, borderStroke2, function3, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj4 = borderStroke;
        if ((i2 & 32) == 0) {
        }
        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Composer composer2;
        final CardElevation cardElevation2;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape2;
        final CardColors cardColors2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        CardColors cardColors3;
        Composer composer3;
        boolean z4;
        int i7;
        CardElevation cardElevation3;
        Modifier modifier3;
        Shape shape3;
        BorderStroke borderStroke3;
        int i8;
        boolean z5;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(2136075085);
        ComposerKt.sourceInformation(startRestartGroup, "C(Card)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)155@7038L43,158@7167L41,148@6786L422:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj = shape;
                        if (startRestartGroup.changed(obj)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        obj = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    obj = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = cardColors;
                        if (startRestartGroup.changed(obj2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        obj2 = cardColors;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    obj2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0 && startRestartGroup.changed(cardElevation)) {
                        i9 = 131072;
                        i3 |= i9;
                    }
                    i9 = 65536;
                    i3 |= i9;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    obj3 = borderStroke;
                    i3 |= startRestartGroup.changed(obj3) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                    }
                    if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                obj = CardDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                cardColors3 = CardDefaults.INSTANCE.cardColors(startRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                cardColors3 = obj2;
                            }
                            if ((i2 & 32) != 0) {
                                z4 = true;
                                i7 = i6;
                                cardElevation3 = CardDefaults.INSTANCE.m1784cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                composer3 = startRestartGroup;
                                i3 &= -458753;
                            } else {
                                composer3 = startRestartGroup;
                                z4 = true;
                                i7 = i6;
                                cardElevation3 = cardElevation;
                            }
                            BorderStroke borderStroke4 = i5 != 0 ? null : borderStroke;
                            if (i7 != 0) {
                                Modifier modifier4 = companion;
                                i8 = i3;
                                mutableInteractionSource3 = null;
                                modifier3 = modifier4;
                                shape3 = obj;
                                borderStroke3 = borderStroke4;
                                z5 = z2;
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2136075085, i8, -1, "androidx.compose.material3.Card (Card.kt:145)");
                                }
                                if (mutableInteractionSource3 != null) {
                                    composer3.startReplaceGroup(1577885006);
                                    ComposerKt.sourceInformation(composer3, "147@6742L39");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -226195148, "CC(remember):Card.kt#9igjgp");
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    composer3.startReplaceGroup(-226195799);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                composer2 = composer3;
                                SurfaceKt.m2572Surfaceo_FOJdg(function0, modifier3, z5, shape3, cardColors3.m1776containerColorvNxB06k$material3(z5), cardColors3.m1777contentColorvNxB06k$material3(z5), 0.0f, cardElevation3.shadowElevation$material3(z5, mutableInteractionSource4, composer3, ((i8 >> 6) & 14) | ((i8 >> 9) & 896)).getValue().m7569unboximpl(), borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i13) {
                                        ComposerKt.sourceInformation(composer4, "C159@7177L25:Card.kt#uh7d8r");
                                        if (!composer4.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1347531112, i13, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:159)");
                                        }
                                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
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
                                        Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                        function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer2, (i8 & 8190) | ((i8 << 6) & 234881024), 6, 64);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                cardColors2 = cardColors3;
                                cardElevation2 = cardElevation3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                modifier2 = modifier3;
                                z3 = z5;
                                shape2 = shape3;
                                borderStroke2 = borderStroke3;
                            } else {
                                modifier3 = companion;
                                shape3 = obj;
                                borderStroke3 = borderStroke4;
                                i8 = i3;
                                z5 = z2;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            shape3 = obj;
                            cardColors3 = obj2;
                            z4 = true;
                            borderStroke3 = obj3;
                            composer3 = startRestartGroup;
                            modifier3 = companion;
                            z5 = z2;
                            cardElevation3 = cardElevation;
                            i8 = i3;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (mutableInteractionSource3 != null) {
                        }
                        composer2 = composer3;
                        SurfaceKt.m2572Surfaceo_FOJdg(function0, modifier3, z5, shape3, cardColors3.m1776containerColorvNxB06k$material3(z5), cardColors3.m1777contentColorvNxB06k$material3(z5), 0.0f, cardElevation3.shadowElevation$material3(z5, mutableInteractionSource4, composer3, ((i8 >> 6) & 14) | ((i8 >> 9) & 896)).getValue().m7569unboximpl(), borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i13) {
                                ComposerKt.sourceInformation(composer4, "C159@7177L25:Card.kt#uh7d8r");
                                if (!composer4.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1347531112, i13, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:159)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, 0);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
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
                                Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer2, (i8 & 8190) | ((i8 << 6) & 234881024), 6, 64);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        cardColors2 = cardColors3;
                        cardElevation2 = cardElevation3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier3;
                        z3 = z5;
                        shape2 = shape3;
                        borderStroke2 = borderStroke3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        cardElevation2 = cardElevation;
                        modifier2 = companion;
                        z3 = z2;
                        shape2 = obj;
                        cardColors2 = obj2;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return CardKt.Card$lambda$2(Function0.this, modifier2, z3, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource2, function3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj3 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj3 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        Object obj3;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        CardColors cardColors3;
        Composer composer3;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation3;
        Modifier modifier3;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1464672362);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedCard)N(modifier,shape,colors,elevation,content)197@8874L169:Card.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                obj2 = shape;
                if (startRestartGroup.changed(obj2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                obj2 = shape;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            obj2 = shape;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                obj3 = cardColors;
                if (startRestartGroup.changed(obj3)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                obj3 = cardColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            obj3 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                obj4 = cardElevation;
                if (startRestartGroup.changed(obj4)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                obj4 = cardElevation;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            obj4 = cardElevation;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
            if (!startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "192@8673L13,193@8726L20,194@8792L23");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    shape4 = obj2;
                    cardColors4 = obj3;
                    cardElevation3 = obj4;
                    composer3 = startRestartGroup;
                    modifier3 = obj;
                } else {
                    Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                    if ((i2 & 2) != 0) {
                        shape3 = CardDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = obj2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColors3 = CardDefaults.INSTANCE.elevatedCardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = obj3;
                    }
                    if ((i2 & 8) != 0) {
                        composer3 = startRestartGroup;
                        i3 &= -7169;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation3 = CardDefaults.INSTANCE.m1786elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = startRestartGroup;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation3 = obj4;
                        modifier3 = companion;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1464672362, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:197)");
                }
                Composer composer4 = composer3;
                Card(modifier3, shape4, cardColors4, cardElevation3, null, function3, composer4, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                cardColors2 = cardColors4;
                cardElevation2 = cardElevation3;
            } else {
                composer2 = startRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = obj;
                shape2 = obj2;
                cardColors2 = obj3;
                cardElevation2 = obj4;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj5, Object obj6) {
                        return CardKt.ElevatedCard$lambda$3(Modifier.this, shape2, cardColors2, cardElevation2, function3, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                });
                return;
            }
            return;
        }
        if (!startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        Object obj2;
        Object obj3;
        Object obj4;
        int i5;
        Object obj5;
        Composer composer2;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        CardColors cardColors3;
        Composer composer3;
        CardColors cardColors4;
        boolean z4;
        Shape shape3;
        CardElevation cardElevation3;
        Composer composer4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-129138571);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedCard)N(onClick,modifier,enabled,shape,colors,elevation,interactionSource,content)250@11337L270:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            obj = function0;
        } else if ((i & 6) == 0) {
            obj = function0;
            i3 = (startRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            obj = function0;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj2 = shape;
                        if (startRestartGroup.changed(obj2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj3 = cardColors;
                        if (startRestartGroup.changed(obj3)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        obj3 = cardColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    obj3 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj4 = cardElevation;
                        if (startRestartGroup.changed(obj4)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        obj4 = cardElevation;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    obj4 = cardElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    obj5 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    obj2 = CardDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    cardColors3 = CardDefaults.INSTANCE.elevatedCardColors(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    cardColors3 = obj3;
                                }
                                if ((i2 & 32) != 0) {
                                    composer3 = startRestartGroup;
                                    i3 &= -458753;
                                    obj4 = CardDefaults.INSTANCE.m1786elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                                } else {
                                    composer3 = startRestartGroup;
                                }
                                if (i5 != 0) {
                                    cardColors4 = cardColors3;
                                    z4 = z2;
                                    shape3 = obj2;
                                    cardElevation3 = obj4;
                                    composer4 = composer3;
                                    mutableInteractionSource3 = null;
                                } else {
                                    cardColors4 = cardColors3;
                                    z4 = z2;
                                    shape3 = obj2;
                                    cardElevation3 = obj4;
                                    composer4 = composer3;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                modifier3 = companion;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                composer4 = startRestartGroup;
                                shape3 = obj2;
                                cardColors4 = obj3;
                                cardElevation3 = obj4;
                                mutableInteractionSource3 = obj5;
                                modifier3 = companion;
                                z4 = z2;
                            }
                            composer4.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                            }
                            int i10 = i3 << 3;
                            Card(obj, modifier3, z4, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer4, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i10) | (i10 & 234881024), 0);
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                            composer2 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource4;
                            modifier2 = modifier3;
                            z3 = z4;
                            shape2 = shape3;
                            cardColors2 = cardColors4;
                            cardElevation2 = cardElevation3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = companion;
                            z3 = z2;
                            shape2 = obj2;
                            cardColors2 = obj3;
                            cardElevation2 = obj4;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj6, Object obj7) {
                                    return CardKt.ElevatedCard$lambda$4(Function0.this, modifier2, z3, shape2, cardColors2, cardElevation2, mutableInteractionSource2, function3, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj5 = mutableInteractionSource;
                if ((i2 & 128) == 0) {
                }
                if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj5 = mutableInteractionSource;
            if ((i2 & 128) == 0) {
            }
            if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj5 = mutableInteractionSource;
        if ((i2 & 128) == 0) {
        }
        if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        CardColors cardColors3;
        boolean z;
        int i4;
        Composer composer3;
        BorderStroke borderStroke3;
        Modifier modifier3;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation3;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1945643296);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedCard)N(modifier,shape,colors,elevation,border,content)298@13425L171:Card.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                obj2 = shape;
                if (startRestartGroup.changed(obj2)) {
                    i8 = 32;
                    i3 |= i8;
                }
            } else {
                obj2 = shape;
            }
            i8 = 16;
            i3 |= i8;
        } else {
            obj2 = shape;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                obj3 = cardColors;
                if (startRestartGroup.changed(obj3)) {
                    i7 = 256;
                    i3 |= i7;
                }
            } else {
                obj3 = cardColors;
            }
            i7 = 128;
            i3 |= i7;
        } else {
            obj3 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                obj4 = cardElevation;
                if (startRestartGroup.changed(obj4)) {
                    i6 = 2048;
                    i3 |= i6;
                }
            } else {
                obj4 = cardElevation;
            }
            i6 = 1024;
            i3 |= i6;
        } else {
            obj4 = cardElevation;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                obj5 = borderStroke;
                if (startRestartGroup.changed(obj5)) {
                    i5 = 16384;
                    i3 |= i5;
                }
            } else {
                obj5 = borderStroke;
            }
            i5 = 8192;
            i3 |= i5;
        } else {
            obj5 = borderStroke;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "292@13162L13,293@13215L20,294@13281L23,295@13346L20");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    shape4 = obj2;
                    cardColors4 = obj3;
                    cardElevation3 = obj4;
                    borderStroke3 = obj5;
                    composer3 = startRestartGroup;
                    modifier3 = obj;
                } else {
                    Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                    if ((i2 & 2) != 0) {
                        shape3 = CardDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = obj2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColors3 = CardDefaults.INSTANCE.outlinedCardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = obj3;
                    }
                    if ((i2 & 8) != 0) {
                        z = false;
                        composer3 = startRestartGroup;
                        i3 &= -7169;
                        i4 = 1;
                        obj4 = CardDefaults.INSTANCE.m1788outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        z = false;
                        i4 = 1;
                        composer3 = startRestartGroup;
                    }
                    if ((i2 & 16) != 0) {
                        BorderStroke outlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z, composer3, 48, i4);
                        i3 &= -57345;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        borderStroke3 = outlinedCardBorder;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                    }
                    cardElevation3 = obj4;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1945643296, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:298)");
                }
                Composer composer4 = composer3;
                Card(modifier3, shape4, cardColors4, cardElevation3, borderStroke3, function3, composer4, 524286 & i3, 0);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                cardColors2 = cardColors4;
                cardElevation2 = cardElevation3;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = startRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = obj;
                shape2 = obj2;
                cardColors2 = obj3;
                cardElevation2 = obj4;
                borderStroke2 = borderStroke;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj6, Object obj7) {
                        return CardKt.OutlinedCard$lambda$5(Modifier.this, shape2, cardColors2, cardElevation2, borderStroke2, function3, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                    }
                });
                return;
            }
            return;
        }
        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        Object obj;
        Object obj2;
        Object obj3;
        int i5;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Composer composer3;
        int i6;
        int i7;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke4;
        Modifier modifier3;
        boolean z4;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevation3;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1401605899);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedCard)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)353@16051L272:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj = shape;
                        if (startRestartGroup.changed(obj)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        obj = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    obj = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = cardColors;
                        if (startRestartGroup.changed(obj2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        obj2 = cardColors;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    obj2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj3 = cardElevation;
                        if (startRestartGroup.changed(obj3)) {
                            i9 = 131072;
                            i3 |= i9;
                        }
                    } else {
                        obj3 = cardElevation;
                    }
                    i9 = 65536;
                    i3 |= i9;
                } else {
                    obj3 = cardElevation;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0 && startRestartGroup.changed(borderStroke)) {
                        i8 = 1048576;
                        i3 |= i8;
                    }
                    i8 = 524288;
                    i3 |= i8;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else if ((12582912 & i) == 0) {
                    obj4 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj4) ? 8388608 : 4194304;
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    obj = CardDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    obj2 = CardDefaults.INSTANCE.outlinedCardColors(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i6 = 0;
                                    i7 = i5;
                                    composer3 = startRestartGroup;
                                    i3 &= -458753;
                                    obj3 = CardDefaults.INSTANCE.m1788outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    composer3 = startRestartGroup;
                                    i6 = 0;
                                    i7 = i5;
                                }
                                if ((i2 & 64) != 0) {
                                    borderStroke3 = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, i6);
                                    i3 &= -3670017;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i7 != 0) {
                                    borderStroke4 = borderStroke3;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    borderStroke4 = borderStroke3;
                                }
                                modifier3 = companion;
                                z4 = z2;
                                shape3 = obj;
                                cardColors3 = obj2;
                                cardElevation3 = obj3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                borderStroke4 = borderStroke;
                                composer3 = startRestartGroup;
                                modifier3 = companion;
                                z4 = z2;
                                cardColors3 = obj2;
                                cardElevation3 = obj3;
                                mutableInteractionSource3 = obj4;
                                shape3 = obj;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                            }
                            composer2 = composer3;
                            Card(function0, modifier3, z4, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            z3 = z4;
                            shape2 = shape3;
                            cardColors2 = cardColors3;
                            cardElevation2 = cardElevation3;
                            borderStroke2 = borderStroke4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = companion;
                            z3 = z2;
                            shape2 = obj;
                            cardColors2 = obj2;
                            cardElevation2 = obj3;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return CardKt.OutlinedCard$lambda$6(Function0.this, modifier2, z3, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource2, function3, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj4 = mutableInteractionSource;
                if ((i2 & 256) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            obj4 = mutableInteractionSource;
            if ((i2 & 256) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        obj4 = mutableInteractionSource;
        if ((i2 & 256) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}

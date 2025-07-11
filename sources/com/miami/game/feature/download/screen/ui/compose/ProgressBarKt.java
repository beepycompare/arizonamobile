package com.miami.game.feature.download.screen.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.miami.game.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProgressBar.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0000\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"ProgressBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "progress", "", "(Landroidx/compose/ui/Modifier;DLandroidx/compose/runtime/Composer;I)V", "CustomLinerProgressBar", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCustomLine", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "weight", "border", "Lcom/miami/game/feature/download/screen/ui/compose/Border;", "PreviewCustomProgressBar", "(Landroidx/compose/runtime/Composer;I)V", "download-screen_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProgressBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomLinerProgressBar$lambda$4(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CustomLinerProgressBar(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewCustomProgressBar$lambda$10(int i, Composer composer, int i2) {
        PreviewCustomProgressBar(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PreviewCustomProgressBar$lambda$9$lambda$8$lambda$7() {
        return 0.12f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressBar$lambda$1(Modifier modifier, double d, int i, Composer composer, int i2) {
        ProgressBar(modifier, d, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProgressBar(final Modifier modifier, final double d, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-220773208);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProgressBar)31@1220L1133:ProgressBar.kt#k3v2wi");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-220773208, i2, -1, "com.miami.game.feature.download.screen.ui.compose.ProgressBar (ProgressBar.kt:29)");
            }
            Modifier m771height3ABfNKs = SizeKt.m771height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Dp.m6684constructorimpl(20));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m771height3ABfNKs);
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
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1880654975, "C37@1353L244,63@2252L11,56@1976L371:ProgressBar.kt#k3v2wi");
            float f = 12;
            BoxKt.Box(BackgroundKt.m246backgroundbw27NRU(SizeKt.fillMaxWidth$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), 0.0f, 1, null), Color.Companion.m4104getBlack0d7_KjU(), new ProgressBarShape()), startRestartGroup, 0);
            BoxKt.Box(BackgroundKt.m246backgroundbw27NRU(SizeKt.fillMaxWidth(SizeKt.m771height3ABfNKs(BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.m6684constructorimpl(f)), (float) d), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), new ProgressBarShape()), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.ProgressBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProgressBar$lambda$1;
                    ProgressBar$lambda$1 = ProgressBarKt.ProgressBar$lambda$1(Modifier.this, d, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProgressBar$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CustomLinerProgressBar(final Function0<Float> progress, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        final Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer startRestartGroup = composer.startRestartGroup(1973590290);
        ComposerKt.sourceInformation(startRestartGroup, "C(CustomLinerProgressBar)P(1)114@3962L11,119@4091L856,115@4005L942:ProgressBar.kt#k3v2wi");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(progress) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if (startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1973590290, i3, -1, "com.miami.game.feature.download.screen.ui.compose.CustomLinerProgressBar (ProgressBar.kt:113)");
                }
                final long m4077copywmQWz5c$default = Color.m4077copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                Modifier m771height3ABfNKs = SizeKt.m771height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m6684constructorimpl(10));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1755266614, "CC(remember):ProgressBar.kt#9igjgp");
                boolean changed = startRestartGroup.changed(m4077copywmQWz5c$default) | ((i3 & 14) == 4);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.download.screen.ui.compose.ProgressBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit CustomLinerProgressBar$lambda$3$lambda$2;
                            CustomLinerProgressBar$lambda$3$lambda$2 = ProgressBarKt.CustomLinerProgressBar$lambda$3$lambda$2(Function0.this, m4077copywmQWz5c$default, (DrawScope) obj2);
                            return CustomLinerProgressBar$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(m771height3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.ProgressBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit CustomLinerProgressBar$lambda$4;
                        CustomLinerProgressBar$lambda$4 = ProgressBarKt.CustomLinerProgressBar$lambda$4(Function0.this, companion, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return CustomLinerProgressBar$lambda$4;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomLinerProgressBar$lambda$3$lambda$2(Function0 function0, long j, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        drawCustomLine(Canvas, Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 0L, 0, 14, (Object) null), 1.0f);
        try {
            drawCustomLine(Canvas, Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(ColorKt.getPink()), Color.m4068boximpl(Color.Companion.m4115getWhite0d7_KjU())}), Offset.m3829constructorimpl((Float.floatToRawIntBits((Float.intBitsToFloat((int) (Canvas.mo4640getSizeNHjbRc() >> 32)) * ((Number) function0.invoke()).floatValue()) / 1.5f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.mo4640getSizeNHjbRc() >> 32)) * ((Number) function0.invoke()).floatValue()) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), 0, 8, (Object) null), ((Number) function0.invoke()).floatValue(), new Border(20.0f, j, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    public static final void drawCustomLine(DrawScope drawScope, Brush brush, float f) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(brush, "brush");
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() & 4294967295L)) / 2;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() >> 32)) * f;
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(intBitsToFloat, 0.0f);
        Path.lineTo(intBitsToFloat2, 0.0f);
        Path.lineTo(intBitsToFloat2 - intBitsToFloat, Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() & 4294967295L)));
        Path.lineTo(0.0f, Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() & 4294967295L)));
        Path.close();
        DrawScope.m4629drawPathGBMwjPU$default(drawScope, Path, brush, 0.0f, Fill.INSTANCE, null, 0, 52, null);
    }

    public static final void drawCustomLine(DrawScope drawScope, Brush brush, float f, Border border) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(border, "border");
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() & 4294967295L)) / 2;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() >> 32)) * f;
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(intBitsToFloat, 0.0f);
        Path.lineTo(intBitsToFloat2, 0.0f);
        Path.lineTo(intBitsToFloat2 - intBitsToFloat, Float.intBitsToFloat((int) (drawScope.mo4640getSizeNHjbRc() & 4294967295L)));
        Path.lineTo(0.0f, Float.intBitsToFloat((int) (4294967295L & drawScope.mo4640getSizeNHjbRc())));
        Path.close();
        DrawScope.m4630drawPathLG529CI$default(drawScope, Path, border.m8374getColor0d7_KjU(), 0.0f, new Stroke(border.getWight(), 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        DrawScope.m4629drawPathGBMwjPU$default(drawScope, Path, brush, 0.0f, Fill.INSTANCE, null, 0, 52, null);
    }

    public static final void PreviewCustomProgressBar(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1324288721);
        ComposerKt.sourceInformation(startRestartGroup, "C(PreviewCustomProgressBar)199@6075L125:ProgressBar.kt#k3v2wi");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1324288721, i, -1, "com.miami.game.feature.download.screen.ui.compose.PreviewCustomProgressBar (ProgressBar.kt:198)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
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
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 678967340, "C200@6184L9,200@6150L44:ProgressBar.kt#k3v2wi");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1225022764, "CC(remember):ProgressBar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.screen.ui.compose.ProgressBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float PreviewCustomProgressBar$lambda$9$lambda$8$lambda$7;
                        PreviewCustomProgressBar$lambda$9$lambda$8$lambda$7 = ProgressBarKt.PreviewCustomProgressBar$lambda$9$lambda$8$lambda$7();
                        return Float.valueOf(PreviewCustomProgressBar$lambda$9$lambda$8$lambda$7);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CustomLinerProgressBar((Function0) rememberedValue, null, startRestartGroup, 6, 2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.ProgressBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewCustomProgressBar$lambda$10;
                    PreviewCustomProgressBar$lambda$10 = ProgressBarKt.PreviewCustomProgressBar$lambda$10(i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewCustomProgressBar$lambda$10;
                }
            });
        }
    }
}

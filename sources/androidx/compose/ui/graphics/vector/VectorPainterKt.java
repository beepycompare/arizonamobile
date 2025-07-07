package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.VectorProperty;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0096\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\b?H\u0082\b\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m4803rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -964365210, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)85@3804L207:VectorPainter.kt#huu6hf");
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) != 0 ? Float.NaN : f4;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long m4114getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.Companion.m4114getUnspecified0d7_KjU() : j;
        int m4018getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m4018getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:85)");
        }
        VectorPainter m4804rememberVectorPaintervIP8VLU = m4804rememberVectorPaintervIP8VLU(f, f2, f5, f6, str2, m4114getUnspecified0d7_KjU, m4018getSrcIn0nO6VwU, false, function4, composer, (i2 & 14) | 12582912 | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m4804rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0166, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final VectorPainter m4804rememberVectorPaintervIP8VLU(float f, float f2, float f3, float f4, String str, long j, int i, boolean z, final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        Object obj;
        ComposerKt.sourceInformationMarkerStart(composer, 1068590786, "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)130@5710L7,134@5911L82:VectorPainter.kt#huu6hf");
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) == 0 ? f4 : Float.NaN;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long m4114getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.Companion.m4114getUnspecified0d7_KjU() : j;
        int m4018getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m4018getSrcIn0nO6VwU() : i;
        boolean z2 = (i3 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:129)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long m4801obtainSizePxVpY3zN4 = m4801obtainSizePxVpY3zN4((Density) consume, f, f2);
        final long m4802obtainViewportSizePq9zytI = m4802obtainViewportSizePq9zytI(m4801obtainSizePxVpY3zN4, f5, f6);
        ComposerKt.sourceInformationMarkerStart(composer, -1837512596, "CC(remember):VectorPainter.kt#9igjgp");
        boolean z3 = z2;
        String str3 = str2;
        boolean z4 = ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(m4114getUnspecified0d7_KjU)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | ((((3670016 & i2) ^ 1572864) > 1048576 && composer.changed(m4018getSrcIn0nO6VwU)) || (i2 & 1572864) == 1048576);
        Object rememberedValue = composer.rememberedValue();
        if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = m4800createColorFilterxETnrds(m4114getUnspecified0d7_KjU, m4018getSrcIn0nO6VwU);
            composer.updateRememberedValue(rememberedValue);
        }
        ColorFilter colorFilter = (ColorFilter) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-1837507429);
        ComposerKt.sourceInformation(composer, "*135@6005L28,144@6352L28,146@6427L513,158@7019L39,158@6996L62");
        ComposerKt.sourceInformationMarkerStart(composer, -1837509642, "CC(remember):VectorPainter.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new VectorPainter(null, 1, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        VectorPainter vectorPainter = (VectorPainter) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        m4798configureVectorPainterT4PVSW8(vectorPainter, m4801obtainSizePxVpY3zN4, m4802obtainViewportSizePq9zytI, str3, colorFilter, z3);
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 904086938, "CC(remember):VectorPainter.kt#9igjgp");
        boolean z5 = ((((234881024 & i2) ^ 100663296) > 67108864 && composer.changed(function4)) || (i2 & 100663296) == 67108864) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(f5)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(f6)) || (i2 & 3072) == 2048);
        Object rememberedValue3 = composer.rememberedValue();
        if (!z5) {
            obj = rememberedValue3;
        }
        Composition composition$ui_release = vectorPainter.getComposition$ui_release();
        if (composition$ui_release == null || composition$ui_release.isDisposed()) {
            composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), rememberCompositionContext);
        }
        Composition composition = composition$ui_release;
        composition.setContent(ComposableLambdaKt.composableLambdaInstance(2008312779, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$composition$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                ComposerKt.sourceInformation(composer2, "C154@6855L40:VectorPainter.kt#huu6hf");
                if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2008312779, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:154)");
                }
                function4.invoke(Float.valueOf(Float.intBitsToFloat((int) (m4802obtainViewportSizePq9zytI >> 32))), Float.valueOf(Float.intBitsToFloat((int) (m4802obtainViewportSizePq9zytI & 4294967295L))), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        composer.updateRememberedValue(composition);
        obj = composition;
        final Composition composition2 = (Composition) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        vectorPainter.setComposition$ui_release(composition2);
        ComposerKt.sourceInformationMarkerStart(composer, 904105408, "CC(remember):VectorPainter.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(composition2);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Composition composition3 = Composition.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Composition.this.dispose();
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(vectorPainter, (Function1) rememberedValue4, composer, 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainter;
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1413834416, "C(rememberVectorPainter)170@7429L7,172@7513L187:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        float density2 = density.getDensity();
        long floatToRawIntBits = Float.floatToRawIntBits(imageVector.getGenId$ui_release());
        ComposerKt.sourceInformationMarkerStart(composer, -1837461227, "CC(remember):VectorPainter.kt#9igjgp");
        boolean changed = composer.changed((Float.floatToRawIntBits(density2) & 4294967295L) | (floatToRawIntBits << 32));
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            rememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(rememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainter;
    }

    /* renamed from: obtainSizePx-VpY3zN4  reason: not valid java name */
    private static final long m4801obtainSizePxVpY3zN4(Density density, float f, float f2) {
        return Size.m3897constructorimpl((Float.floatToRawIntBits(density.mo389toPx0680j_4(f)) << 32) | (Float.floatToRawIntBits(density.mo389toPx0680j_4(f2)) & 4294967295L));
    }

    /* renamed from: obtainViewportSize-Pq9zytI  reason: not valid java name */
    private static final long m4802obtainViewportSizePq9zytI(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if (Float.isNaN(f2)) {
            f2 = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return Size.m3897constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    /* renamed from: createColorFilter-xETnrds  reason: not valid java name */
    private static final ColorFilter m4800createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.Companion.m4122tintxETnrds(j, i);
        }
        return null;
    }

    /* renamed from: configureVectorPainter-T4PVSW8$default  reason: not valid java name */
    public static /* synthetic */ VectorPainter m4799configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = RootGroupName;
        }
        return m4798configureVectorPainterT4PVSW8(vectorPainter, j, j2, str, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* renamed from: configureVectorPainter-T4PVSW8  reason: not valid java name */
    public static final VectorPainter m4798configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z) {
        vectorPainter.m4796setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m4797setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long m4801obtainSizePxVpY3zN4 = m4801obtainSizePxVpY3zN4(density, imageVector.m4772getDefaultWidthD9Ej5fM(), imageVector.m4771getDefaultHeightD9Ej5fM());
        return m4798configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), m4801obtainSizePxVpY3zN4, m4802obtainViewportSizePq9zytI(m4801obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m4800createColorFilterxETnrds(imageVector.m4774getTintColor0d7_KjU(), imageVector.m4773getTintBlendMode0nO6VwU()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m4782setPathFillTypeoQ8Xj4U(vectorPath.m4805getPathFillTypeRgk1Os());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m4783setStrokeLineCapBeK7IIE(vectorPath.m4806getStrokeLineCapKaPHkGw());
                pathComponent.m4784setStrokeLineJoinWw9F2mQ(vectorPath.m4807getStrokeLineJoinLxFBmk8());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RenderVectorGroup(final VectorGroup vectorGroup, Map<String, ? extends VectorConfig> map, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        final Map<String, ? extends VectorConfig> map2;
        ScopeUpdateScope endRestartGroup;
        Iterator<VectorNode> it;
        final Map<String, ? extends VectorConfig> map3;
        Composer startRestartGroup = composer.startRestartGroup(-446179233);
        ComposerKt.sourceInformation(startRestartGroup, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(vectorGroup) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = map;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            if (!startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                Map<String, ? extends VectorConfig> emptyMap = i4 != 0 ? MapsKt.emptyMap() : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-446179233, i3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:428)");
                }
                Iterator<VectorNode> it2 = vectorGroup.iterator();
                while (it2.hasNext()) {
                    final VectorNode next = it2.next();
                    if (next instanceof VectorPath) {
                        startRestartGroup.startReplaceGroup(-23302778);
                        ComposerKt.sourceInformation(startRestartGroup, "432@16447L1297");
                        VectorPath vectorPath = (VectorPath) next;
                        VectorConfig vectorConfig = emptyMap.get(vectorPath.getName());
                        if (vectorConfig == null) {
                            vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                            };
                        }
                        it = it2;
                        Composer composer2 = startRestartGroup;
                        map3 = emptyMap;
                        VectorComposeKt.m4788Path9cdaXJ4((List) vectorConfig.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath.getPathData()), vectorPath.m4805getPathFillTypeRgk1Os(), vectorPath.getName(), (Brush) vectorConfig.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath.getFill()), ((Number) vectorConfig.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath.getFillAlpha()))).floatValue(), (Brush) vectorConfig.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath.getStroke()), ((Number) vectorConfig.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath.getStrokeLineWidth()))).floatValue(), vectorPath.m4806getStrokeLineCapKaPHkGw(), vectorPath.m4807getStrokeLineJoinLxFBmk8(), vectorPath.getStrokeLineMiter(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath.getTrimPathStart()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath.getTrimPathOffset()))).floatValue(), composer2, 0, 0, 0);
                        startRestartGroup = composer2;
                        startRestartGroup.endReplaceGroup();
                    } else {
                        it = it2;
                        map3 = emptyMap;
                        if (next instanceof VectorGroup) {
                            startRestartGroup.startReplaceGroup(-21889209);
                            ComposerKt.sourceInformation(startRestartGroup, "467@18739L88,455@17883L944");
                            VectorGroup vectorGroup2 = (VectorGroup) next;
                            VectorConfig vectorConfig2 = map3.get(vectorGroup2.getName());
                            if (vectorConfig2 == null) {
                                vectorConfig2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                                };
                            }
                            VectorComposeKt.Group(vectorGroup2.getName(), ((Number) vectorConfig2.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup2.getRotation()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup2.getPivotX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup2.getPivotY()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup2.getScaleX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup2.getScaleY()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup2.getTranslationX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup2.getTranslationY()))).floatValue(), (List) vectorConfig2.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup2.getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i5) {
                                    ComposerKt.sourceInformation(composer3, "C468@18757L56:VectorPainter.kt#huu6hf");
                                    if (!composer3.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1450046638, i5, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:468)");
                                    }
                                    VectorPainterKt.RenderVectorGroup((VectorGroup) VectorNode.this, map3, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, 805306368, 0);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-20884003);
                            startRestartGroup.endReplaceGroup();
                        }
                    }
                    emptyMap = map3;
                    it2 = it;
                }
                map2 = emptyMap;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                map2 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i5) {
                        VectorPainterKt.RenderVectorGroup(VectorGroup.this, map2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        obj = map;
        if (!startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long mo4639getCenterF1C5BW0 = drawScope.mo4639getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo4561getSizeNHjbRc = drawContext.mo4561getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4568scale0AR0LA0(-1.0f, 1.0f, mo4639getCenterF1C5BW0);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
        }
    }
}

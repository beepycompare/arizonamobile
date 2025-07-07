package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\f\u0010\f\u001a\u00020\u0006*\u00020\u0006H\u0007\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"LocalOverscrollFactory", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/OverscrollFactory;", "getLocalOverscrollFactory", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "overscroll", "Landroidx/compose/ui/Modifier;", "overscrollEffect", "withoutEventHandling", "withoutVisualEffect", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OverscrollKt {
    private static final ProvidableCompositionLocal<OverscrollFactory> LocalOverscrollFactory = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1<CompositionLocalAccessorScope, OverscrollFactory>() { // from class: androidx.compose.foundation.OverscrollKt$LocalOverscrollFactory$1
        @Override // kotlin.jvm.functions.Function1
        public final OverscrollFactory invoke(CompositionLocalAccessorScope compositionLocalAccessorScope) {
            return AndroidOverscroll_androidKt.defaultOverscrollFactory(compositionLocalAccessorScope);
        }
    });

    public static final OverscrollEffect withoutVisualEffect(OverscrollEffect overscrollEffect) {
        return new WrappedOverscrollEffect(false, true, overscrollEffect);
    }

    public static final OverscrollEffect withoutEventHandling(OverscrollEffect overscrollEffect) {
        return new WrappedOverscrollEffect(true, false, overscrollEffect);
    }

    public static final Modifier overscroll(Modifier modifier, OverscrollEffect overscrollEffect) {
        Modifier.Companion companion;
        if (overscrollEffect == null || (companion = overscrollEffect.getEffectModifier()) == null) {
            companion = Modifier.Companion;
        }
        if (companion == Modifier.Companion) {
            companion = new OverscrollModifierElement(overscrollEffect);
        }
        return modifier.then(companion);
    }

    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i) {
        composer.startReplaceGroup(282942128);
        ComposerKt.sourceInformation(composer, "C(rememberOverscrollEffect)345@15312L7,346@15346L74:Overscroll.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(282942128, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (Overscroll.kt:344)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalOverscrollFactory);
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverscrollFactory overscrollFactory = (OverscrollFactory) consume;
        if (overscrollFactory == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1852674691, "CC(remember):Overscroll.kt#9igjgp");
        boolean changed = composer.changed(overscrollFactory);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = overscrollFactory.createOverscrollEffect();
            composer.updateRememberedValue(rememberedValue);
        }
        OverscrollEffect overscrollEffect = (OverscrollEffect) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return overscrollEffect;
    }

    public static final ProvidableCompositionLocal<OverscrollFactory> getLocalOverscrollFactory() {
        return LocalOverscrollFactory;
    }
}

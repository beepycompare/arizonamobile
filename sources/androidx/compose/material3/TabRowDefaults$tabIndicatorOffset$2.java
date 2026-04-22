package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
/* compiled from: TabRow.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class TabRowDefaults$tabIndicatorOffset$2 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TabPosition $currentTabPosition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TabRowDefaults$tabIndicatorOffset$2(TabPosition tabPosition) {
        this.$currentTabPosition = tabPosition;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-1541271084);
        ComposerKt.sourceInformation(composer, "C1111@47460L7,1109@47309L177,1116@47688L7,1114@47538L176,1120@47822L53:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1108)");
        }
        State<Dp> m161animateDpAsStateAjpBEmI = AnimateAsStateKt.m161animateDpAsStateAjpBEmI(this.$currentTabPosition.m2608getWidthD9Ej5fM(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
        final State<Dp> m161animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m161animateDpAsStateAjpBEmI(this.$currentTabPosition.m2606getLeftD9Ej5fM(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
        Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.Companion.getBottomStart(), false, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, 602226121, "CC(remember):TabRow.kt#9igjgp");
        boolean changed = composer.changed(m161animateDpAsStateAjpBEmI2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    IntOffset m7674boximpl;
                    State state = State.this;
                    Density density = (Density) obj;
                    m7674boximpl = IntOffset.m7674boximpl(IntOffset.m7677constructorimpl(density.mo399roundToPx0680j_4(TabRowDefaults$tabIndicatorOffset$2.invoke$lambda$1(state)) << 32));
                    return m7674boximpl;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier m869width3ABfNKs = SizeKt.m869width3ABfNKs(OffsetKt.offset(wrapContentSize$default, (Function1) rememberedValue), invoke$lambda$0(m161animateDpAsStateAjpBEmI));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m869width3ABfNKs;
    }

    private static final float invoke$lambda$0(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }

    private static final float invoke$lambda$1(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }
}

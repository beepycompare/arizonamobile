package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopContent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ShopContent", "", "xdonate", "", "isArizona", "", "onClickShop", "Lkotlin/Function0;", "(IZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShopContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopContent$lambda$1(int i, boolean z, Function0 function0, int i2, Composer composer, int i3) {
        ShopContent(i, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ShopContent(final int i, final boolean z, Function0<Unit> onClickShop, Composer composer, final int i2) {
        int i3;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onClickShop, "onClickShop");
        Composer startRestartGroup = composer.startRestartGroup(-1974766742);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopContent)P(2)7@291L55,7@264L82:ShopContent.kt#dswm0d");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickShop) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            function0 = onClickShop;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1974766742, i3, -1, "com.miami.game.feature.home.ui.compose.ShopContent (ShopContent.kt:6)");
            }
            function0 = onClickShop;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(-1126410593, true, new Function3() { // from class: com.miami.game.feature.home.ui.compose.ShopContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopContent$lambda$0;
                    ShopContent$lambda$0 = ShopContentKt.ShopContent$lambda$0(i, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopContent$lambda$0;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 6) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ShopContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopContent$lambda$1;
                    ShopContent$lambda$1 = ShopContentKt.ShopContent$lambda$1(i, z, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopContent$lambda$0(int i, boolean z, BoxScope ScalingButton, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C8@301L39:ShopContent.kt#dswm0d");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1126410593, i2, -1, "com.miami.game.feature.home.ui.compose.ShopContent.<anonymous> (ShopContent.kt:8)");
            }
            ImagesKt.ShopImage(i, z, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

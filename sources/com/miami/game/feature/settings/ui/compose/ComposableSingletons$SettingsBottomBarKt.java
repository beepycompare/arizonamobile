package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.miami.game.feature.settings.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsBottomBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$SettingsBottomBarKt {
    public static final ComposableSingletons$SettingsBottomBarKt INSTANCE = new ComposableSingletons$SettingsBottomBarKt();

    /* renamed from: lambda$-13006014  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f84lambda$13006014 = ComposableLambdaKt.composableLambdaInstance(-13006014, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__13006014$lambda$0;
            lambda__13006014$lambda$0 = ComposableSingletons$SettingsBottomBarKt.lambda__13006014$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__13006014$lambda$0;
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$983320313 = ComposableLambdaKt.composableLambdaInstance(983320313, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_983320313$lambda$1;
            lambda_983320313$lambda$1 = ComposableSingletons$SettingsBottomBarKt.lambda_983320313$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_983320313$lambda$1;
        }
    });

    /* renamed from: lambda$-473092742  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f85lambda$473092742 = ComposableLambdaKt.composableLambdaInstance(-473092742, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__473092742$lambda$2;
            lambda__473092742$lambda$2 = ComposableSingletons$SettingsBottomBarKt.lambda__473092742$lambda$2((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__473092742$lambda$2;
        }
    });

    /* renamed from: getLambda$-13006014$settings_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8413getLambda$13006014$settings_release_web() {
        return f84lambda$13006014;
    }

    /* renamed from: getLambda$-473092742$settings_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8414getLambda$473092742$settings_release_web() {
        return f85lambda$473092742;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$983320313$settings_release_web() {
        return lambda$983320313;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__13006014$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C56@2040L38,55@1999L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-13006014, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$-13006014.<anonymous> (SettingsBottomBar.kt:55)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.bug_report, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_983320313$lambda$1(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C63@2356L38,62@2315L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(983320313, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$983320313.<anonymous> (SettingsBottomBar.kt:62)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.share_logs, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__473092742$lambda$2(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C70@2676L42,69@2635L236:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473092742, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$-473092742.<anonymous> (SettingsBottomBar.kt:69)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.privacy_policy, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

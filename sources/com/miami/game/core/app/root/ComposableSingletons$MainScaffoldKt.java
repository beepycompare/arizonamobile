package com.miami.game.core.app.root;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: MainScaffold.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$MainScaffoldKt {
    public static final ComposableSingletons$MainScaffoldKt INSTANCE = new ComposableSingletons$MainScaffoldKt();
    private static Function2<Composer, Integer, Unit> lambda$1170228028 = ComposableLambdaKt.composableLambdaInstance(1170228028, false, new Function2<Composer, Integer, Unit>() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$lambda$1170228028$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1170228028, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$1170228028.<anonymous> (MainScaffold.kt:12)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda$-863503316  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f69lambda$863503316 = ComposableLambdaKt.composableLambdaInstance(-863503316, false, new Function2<Composer, Integer, Unit>() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$lambda$-863503316$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-863503316, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$-863503316.<anonymous> (MainScaffold.kt:13)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda$-1632204659  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f68lambda$1632204659 = ComposableLambdaKt.composableLambdaInstance(-1632204659, false, new Function2<Composer, Integer, Unit>() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$lambda$-1632204659$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1632204659, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$-1632204659.<anonymous> (MainScaffold.kt:14)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-1632204659$app_root_release_web  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8298getLambda$1632204659$app_root_release_web() {
        return f68lambda$1632204659;
    }

    /* renamed from: getLambda$-863503316$app_root_release_web  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8299getLambda$863503316$app_root_release_web() {
        return f69lambda$863503316;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1170228028$app_root_release_web() {
        return lambda$1170228028;
    }
}

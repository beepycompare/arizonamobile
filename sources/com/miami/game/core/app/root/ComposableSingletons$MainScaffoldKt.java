package com.miami.game.core.app.root;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: MainScaffold.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$MainScaffoldKt {
    public static final ComposableSingletons$MainScaffoldKt INSTANCE = new ComposableSingletons$MainScaffoldKt();
    private static Function2<Composer, Integer, Unit> lambda$1170228028 = ComposableLambdaKt.composableLambdaInstance(1170228028, false, new Function2() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1170228028$lambda$0;
            lambda_1170228028$lambda$0 = ComposableSingletons$MainScaffoldKt.lambda_1170228028$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1170228028$lambda$0;
        }
    });

    /* renamed from: lambda$-863503316  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f69lambda$863503316 = ComposableLambdaKt.composableLambdaInstance(-863503316, false, new Function2() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__863503316$lambda$1;
            lambda__863503316$lambda$1 = ComposableSingletons$MainScaffoldKt.lambda__863503316$lambda$1((Composer) obj, ((Integer) obj2).intValue());
            return lambda__863503316$lambda$1;
        }
    });

    /* renamed from: lambda$-1632204659  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f68lambda$1632204659 = ComposableLambdaKt.composableLambdaInstance(-1632204659, false, new Function2() { // from class: com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1632204659$lambda$2;
            lambda__1632204659$lambda$2 = ComposableSingletons$MainScaffoldKt.lambda__1632204659$lambda$2((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1632204659$lambda$2;
        }
    });

    /* renamed from: getLambda$-1632204659$app_root_release_web  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8299getLambda$1632204659$app_root_release_web() {
        return f68lambda$1632204659;
    }

    /* renamed from: getLambda$-863503316$app_root_release_web  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8300getLambda$863503316$app_root_release_web() {
        return f69lambda$863503316;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1170228028$app_root_release_web() {
        return lambda$1170228028;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1170228028$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1170228028, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$1170228028.<anonymous> (MainScaffold.kt:12)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__863503316$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-863503316, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$-863503316.<anonymous> (MainScaffold.kt:13)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1632204659$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:MainScaffold.kt#v5ppa4");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632204659, i, -1, "com.miami.game.core.app.root.ComposableSingletons$MainScaffoldKt.lambda$-1632204659.<anonymous> (MainScaffold.kt:14)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

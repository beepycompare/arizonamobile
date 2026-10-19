package com.miami.game.core.design.system.component.dialog_frame;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogFrame.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$DialogFrameKt {
    public static final ComposableSingletons$DialogFrameKt INSTANCE = new ComposableSingletons$DialogFrameKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$2027032088 = ComposableLambdaKt.composableLambdaInstance(2027032088, false, new Function3() { // from class: com.miami.game.core.design.system.component.dialog_frame.ComposableSingletons$DialogFrameKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DialogFrameKt.lambda_2027032088$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$2027032088$design_system() {
        return lambda$2027032088;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2027032088$lambda$0(BoxScope boxScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        ComposerKt.sourceInformation(composer, "C:DialogFrame.kt#x951st");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027032088, i, -1, "com.miami.game.core.design.system.component.dialog_frame.ComposableSingletons$DialogFrameKt.lambda$2027032088.<anonymous> (DialogFrame.kt:34)");
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

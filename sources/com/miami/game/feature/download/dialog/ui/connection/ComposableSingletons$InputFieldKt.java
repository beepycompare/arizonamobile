package com.miami.game.feature.download.dialog.ui.connection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputField.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$InputFieldKt {
    public static final ComposableSingletons$InputFieldKt INSTANCE = new ComposableSingletons$InputFieldKt();

    /* renamed from: lambda$-1682333503  reason: not valid java name */
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f73lambda$1682333503 = ComposableLambdaKt.composableLambdaInstance(-1682333503, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$InputFieldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1682333503$lambda$0;
            lambda__1682333503$lambda$0 = ComposableSingletons$InputFieldKt.lambda__1682333503$lambda$0((Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1682333503$lambda$0;
        }
    });

    /* renamed from: getLambda$-1682333503$dialogs_release_web  reason: not valid java name */
    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m8333getLambda$1682333503$dialogs_release_web() {
        return f73lambda$1682333503;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1682333503$lambda$0(Function2 innerTextField, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation(composer, "C56@2159L16:InputField.kt#yp5s1q");
        if ((i & 6) == 0) {
            i |= composer.changedInstance(innerTextField) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682333503, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$InputFieldKt.lambda$-1682333503.<anonymous> (InputField.kt:56)");
            }
            innerTextField.invoke(composer, Integer.valueOf(i & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

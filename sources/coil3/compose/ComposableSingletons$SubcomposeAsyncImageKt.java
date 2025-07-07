package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ComposableSingletons$SubcomposeAsyncImageKt {
    public static final ComposableSingletons$SubcomposeAsyncImageKt INSTANCE = new ComposableSingletons$SubcomposeAsyncImageKt();
    private static Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> lambda$1938077476 = ComposableLambdaKt.composableLambdaInstance(1938077476, false, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt$lambda$1938077476$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
            invoke(subcomposeAsyncImageScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C309@13094L29:SubcomposeAsyncImage.kt#8xxpns");
            if ((i & 6) == 0) {
                i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1938077476, i2, -1, "coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda$1938077476.<anonymous> (SubcomposeAsyncImage.kt:309)");
                }
                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    public final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> getLambda$1938077476$coil_compose_core_release() {
        return lambda$1938077476;
    }
}

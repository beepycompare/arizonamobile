package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: singletonImageLoaders.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u00012%\u0010\u0002\u001a!\u0012\u0017\u0012\u00150\u0004j\u0002`\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0\u0003H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"setSingletonImageLoaderFactory", "", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Lcoil3/PlatformContext;", "Lcoil3/ImageLoader;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "coil-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SingletonImageLoadersKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSingletonImageLoaderFactory$lambda$0(Function1 function1, int i, Composer composer, int i2) {
        setSingletonImageLoaderFactory(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void setSingletonImageLoaderFactory(final Function1<? super Context, ? extends ImageLoader> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(505499498);
        ComposerKt.sourceInformation(startRestartGroup, "C(setSingletonImageLoaderFactory):singletonImageLoaders.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(505499498, i2, -1, "coil3.compose.setSingletonImageLoaderFactory (singletonImageLoaders.kt:13)");
            }
            SingletonImageLoader.setSafe(new SingletonImageLoadersKt$sam$coil3_SingletonImageLoader_Factory$0(function1));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SingletonImageLoadersKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit singletonImageLoaderFactory$lambda$0;
                    singletonImageLoaderFactory$lambda$0 = SingletonImageLoadersKt.setSingletonImageLoaderFactory$lambda$0(Function1.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return singletonImageLoaderFactory$lambda$0;
                }
            });
        }
    }
}

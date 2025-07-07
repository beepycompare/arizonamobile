package coil3.compose;

import android.content.Context;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: singletonImageLoaders.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SingletonImageLoadersKt$sam$coil3_SingletonImageLoader_Factory$0 implements SingletonImageLoader.Factory, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImageLoadersKt$sam$coil3_SingletonImageLoader_Factory$0(Function1 function1) {
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof SingletonImageLoader.Factory) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // coil3.SingletonImageLoader.Factory
    public final /* synthetic */ ImageLoader newImageLoader(Context context) {
        return (ImageLoader) this.function.invoke(context);
    }
}

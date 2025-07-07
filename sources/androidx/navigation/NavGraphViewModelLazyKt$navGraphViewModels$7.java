package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$7 implements Function0<CreationExtras> {
    final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
    final /* synthetic */ Function0<CreationExtras> $extrasProducer;

    /* JADX WARN: Multi-variable type inference failed */
    public NavGraphViewModelLazyKt$navGraphViewModels$7(Function0<? extends CreationExtras> function0, Lazy<NavBackStackEntry> lazy) {
        this.$extrasProducer = function0;
        this.$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreationExtras invoke() {
        NavBackStackEntry m7498navGraphViewModels$lambda3;
        CreationExtras invoke;
        Function0<CreationExtras> function0 = this.$extrasProducer;
        if (function0 == null || (invoke = function0.invoke()) == null) {
            m7498navGraphViewModels$lambda3 = NavGraphViewModelLazyKt.m7498navGraphViewModels$lambda3(this.$backStackEntry$delegate);
            return m7498navGraphViewModels$lambda3.getDefaultViewModelCreationExtras();
        }
        return invoke;
    }
}

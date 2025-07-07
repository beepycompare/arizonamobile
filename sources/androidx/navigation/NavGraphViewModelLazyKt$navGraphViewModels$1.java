package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 implements Function0<CreationExtras> {
    final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

    public NavGraphViewModelLazyKt$navGraphViewModels$1(Lazy<NavBackStackEntry> lazy) {
        this.$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreationExtras invoke() {
        NavBackStackEntry m7495navGraphViewModels$lambda0;
        m7495navGraphViewModels$lambda0 = NavGraphViewModelLazyKt.m7495navGraphViewModels$lambda0(this.$backStackEntry$delegate);
        return m7495navGraphViewModels$lambda0.getDefaultViewModelCreationExtras();
    }
}

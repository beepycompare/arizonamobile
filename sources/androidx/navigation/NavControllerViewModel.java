package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.internal.Utils_jvmCommonKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.UStringsKt;
/* compiled from: NavControllerViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/navigation/NavViewModelStoreProvider;", "<init>", "()V", "viewModelStores", "", "", "Landroidx/lifecycle/ViewModelStore;", "clear", "", "backStackEntryId", "onCleared", "getViewModelStore", "toString", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {
    public static final Companion Companion = new Companion(null);
    private final Map<String, ViewModelStore> viewModelStores = new LinkedHashMap();

    public final void clear(String backStackEntryId) {
        Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
        ViewModelStore remove = this.viewModelStores.remove(backStackEntryId);
        if (remove != null) {
            remove.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        for (ViewModelStore viewModelStore : this.viewModelStores.values()) {
            viewModelStore.clear();
        }
        this.viewModelStores.clear();
    }

    @Override // androidx.navigation.NavViewModelStoreProvider
    public ViewModelStore getViewModelStore(String backStackEntryId) {
        Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
        ViewModelStore viewModelStore = this.viewModelStores.get(backStackEntryId);
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = new ViewModelStore();
            this.viewModelStores.put(backStackEntryId, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(UStringsKt.m9811toStringV7xB4Y4(UInt.m8571constructorimpl(Utils_jvmCommonKt.identityHashCode(this)), 16));
        sb.append("} ViewModelStores (");
        Iterator<String> it = this.viewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* compiled from: NavControllerViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavControllerViewModel$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/navigation/NavControllerViewModel;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavControllerViewModel getInstance(ViewModelStore viewModelStore) {
            ViewModelProvider.Factory factory;
            Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
            ViewModelProvider.Companion companion = ViewModelProvider.Companion;
            factory = NavControllerViewModelKt.FACTORY;
            return (NavControllerViewModel) ViewModelProvider.Companion.create$default(companion, viewModelStore, factory, (CreationExtras) null, 4, (Object) null).get(Reflection.getOrCreateKotlinClass(NavControllerViewModel.class));
        }
    }
}

package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ToolbarOnDestinationChangedListener.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u001c\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/navigation/ui/ToolbarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "<init>", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/ui/AppBarConfiguration;)V", "toolbarWeakReference", "Ljava/lang/ref/WeakReference;", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "setTitle", "title", "", "setNavigationIcon", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", "navigation-ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference<Toolbar> toolbarWeakReference;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ToolbarOnDestinationChangedListener(Toolbar toolbar, AppBarConfiguration configuration) {
        super(r0, configuration);
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Context context = toolbar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.toolbarWeakReference = new WeakReference<>(toolbar);
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (this.toolbarWeakReference.get() == null) {
            controller.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(controller, destination, bundle);
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setTitle(CharSequence charSequence) {
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setNavigationIcon(Drawable drawable, int i) {
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            boolean z = drawable == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }
}

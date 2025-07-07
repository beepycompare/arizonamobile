package androidx.navigation.dynamicfeatures.fragment.ui;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.navigation.dynamicfeatures.fragment.R;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultProgressFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0014J\u0012\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0016H\u0014J\u0012\u0010\u001d\u001a\u00020\u000b2\b\b\u0001\u0010\u001e\u001a\u00020\u0016H\u0002J \u0010\u001f\u001a\u00020\u000b2\b\b\u0001\u0010\u001e\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/ui/DefaultProgressFragment;", "Landroidx/navigation/dynamicfeatures/fragment/ui/AbstractProgressFragment;", "<init>", "()V", "title", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "action", "Landroid/widget/Button;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setActivityIcon", "activityIcon", "Landroid/widget/ImageView;", "onProgress", NotificationCompat.CATEGORY_STATUS, "", "bytesDownloaded", "", "bytesTotal", "onCancelled", "onFailed", "errorCode", "displayErrorState", "text", "displayAction", "onClick", "Lkotlin/Function0;", "Companion", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultProgressFragment extends AbstractProgressFragment {
    public static final Companion Companion = new Companion(null);
    private static final int PROGRESS_MAX = 100;
    private static final String TAG = "DefaultProgressFragment";
    private Button action;
    private ProgressBar progressBar;
    private TextView title;

    public DefaultProgressFragment() {
        super(R.layout.dynamic_feature_install_fragment);
    }

    /* compiled from: DefaultProgressFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/navigation/dynamicfeatures/fragment/ui/DefaultProgressFragment$Companion;", "", "<init>", "()V", "PROGRESS_MAX", "", "TAG", "", "navigation-dynamic-features-fragment_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.title = (TextView) view.findViewById(R.id.progress_title);
        this.progressBar = (ProgressBar) view.findViewById(R.id.installation_progress);
        View findViewById = view.findViewById(R.id.progress_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setActivityIcon((ImageView) findViewById);
        this.action = (Button) view.findViewById(R.id.progress_action);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.title = null;
        this.progressBar = null;
        this.action = null;
    }

    private final void setActivityIcon(ImageView imageView) {
        Drawable defaultActivityIcon;
        PackageManager packageManager = requireContext().getPackageManager();
        try {
            defaultActivityIcon = packageManager.getActivityIcon(new ComponentName(requireContext(), requireActivity().getClass()));
        } catch (PackageManager.NameNotFoundException unused) {
            defaultActivityIcon = packageManager.getDefaultActivityIcon();
        }
        Intrinsics.checkNotNull(defaultActivityIcon);
        imageView.setImageDrawable(defaultActivityIcon);
    }

    @Override // androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment
    protected void onProgress(int i, long j, long j2) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            if (j2 == 0) {
                progressBar.setIndeterminate(true);
                return;
            }
            progressBar.setProgress((int) ((100 * j) / j2));
            progressBar.setIndeterminate(false);
        }
    }

    @Override // androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment
    protected void onCancelled() {
        displayErrorState(R.string.installation_cancelled);
        displayAction(R.string.retry, new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.DefaultProgressFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onCancelled$lambda$3;
                onCancelled$lambda$3 = DefaultProgressFragment.onCancelled$lambda$3(DefaultProgressFragment.this);
                return onCancelled$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCancelled$lambda$3(DefaultProgressFragment defaultProgressFragment) {
        defaultProgressFragment.navigate$navigation_dynamic_features_fragment_release();
        return Unit.INSTANCE;
    }

    @Override // androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment
    protected void onFailed(int i) {
        Log.w(TAG, "Installation failed with error " + i);
        displayErrorState(R.string.installation_failed);
        displayAction(R.string.ok, new Function0() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.DefaultProgressFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onFailed$lambda$4;
                onFailed$lambda$4 = DefaultProgressFragment.onFailed$lambda$4(DefaultProgressFragment.this);
                return onFailed$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFailed$lambda$4(DefaultProgressFragment defaultProgressFragment) {
        FragmentKt.findNavController(defaultProgressFragment).popBackStack();
        return Unit.INSTANCE;
    }

    private final void displayErrorState(int i) {
        TextView textView = this.title;
        if (textView != null) {
            textView.setText(i);
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    private final void displayAction(int i, final Function0<Unit> function0) {
        Button button = this.action;
        if (button != null) {
            button.setText(i);
            button.setOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.dynamicfeatures.fragment.ui.DefaultProgressFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function0.this.invoke();
                }
            });
            button.setVisibility(0);
        }
    }
}

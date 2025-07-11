package com.arizona.launcher;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import com.arizona.game.R;
import com.arizona.game.databinding.ActivityMainBinding;
import com.arizona.launcher.util.FlavorUtilKt;
import com.arizona.launcher.util.UtilsKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0015J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "navController", "Landroidx/navigation/NavController;", "binding", "Lcom/arizona/game/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "navigateToMain", "navigateToServers", "navigateToSettings", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class MainActivity extends Hilt_MainActivity {
    public static final int $stable = 8;
    private ActivityMainBinding binding;
    private NavController navController;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arizona.launcher.Hilt_MainActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityMainBinding activityMainBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        this.navController = ActivityKt.findNavController(this, R.id.nav_host_fragment);
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding2;
        }
        activityMainBinding.homeButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.launcher.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$3$lambda$0(MainActivity.this, view);
            }
        });
        activityMainBinding.playButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.launcher.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$3$lambda$1(MainActivity.this, view);
            }
        });
        activityMainBinding.settingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.launcher.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$3$lambda$2(MainActivity.this, view);
            }
        });
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        UtilsKt.checkItemsName(applicationContext, FlavorUtilKt.isArizona());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$0(MainActivity mainActivity, View view) {
        NavController navController = mainActivity.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        if (navController.popBackStack(R.id.informationPageFragment, false)) {
            return;
        }
        mainActivity.navigateToMain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$1(MainActivity mainActivity, View view) {
        NavController navController = mainActivity.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        if (navController.popBackStack(R.id.serversFragment, false)) {
            return;
        }
        mainActivity.navigateToServers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(MainActivity mainActivity, View view) {
        NavController navController = mainActivity.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        if (navController.popBackStack(R.id.settingsPageFragment, false)) {
            return;
        }
        mainActivity.navigateToSettings();
    }

    private final void navigateToMain() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.informationPageFragment, Bundle.EMPTY, new NavOptions.Builder().setLaunchSingleTop(true).build());
    }

    private final void navigateToServers() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.serversFragment, Bundle.EMPTY, new NavOptions.Builder().setLaunchSingleTop(true).build());
    }

    private final void navigateToSettings() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.settingsPageFragment, Bundle.EMPTY, new NavOptions.Builder().setLaunchSingleTop(true).build());
    }
}

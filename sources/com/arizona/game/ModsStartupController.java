package com.arizona.game;

import android.app.Activity;
import android.graphics.Color;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.arizona.game.ModsStartup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.mods.ModsPreferences;
import com.miami.game.core.settings.mods.ModsSynchronizer;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ModsStartup.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0018\u001a\u00020\fH\u0002J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u001e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006\""}, d2 = {"Lcom/arizona/game/ModsStartupController;", "", "activity", "Landroid/app/Activity;", "parent", "Landroid/widget/FrameLayout;", "ready", "Ljava/util/function/Consumer;", "", "<init>", "(Landroid/app/Activity;Landroid/widget/FrameLayout;Ljava/util/function/Consumer;)V", "panel", "Landroid/widget/LinearLayout;", "title", "Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "buttons", "completed", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/arizona/game/ModsStartup$State;", "", "showPanel", "destroy", "render", RemoteConfigConstants.ResponseFieldKey.STATE, "button", Constants.ScionAnalytics.PARAM_LABEL, "", "action", "Lkotlin/Function0;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModsStartupController {
    private static Boolean enabledForSession;
    private final Activity activity;
    private LinearLayout buttons;
    private boolean completed;
    private final Function1<ModsStartup.State, Unit> listener;
    private LinearLayout panel;
    private final FrameLayout parent;
    private ProgressBar progress;
    private final Consumer<String> ready;
    private TextView title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ ModsStartupController(Activity activity, FrameLayout frameLayout, Consumer consumer, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, frameLayout, consumer);
    }

    @JvmStatic
    public static final ModsStartupController create(Activity activity, FrameLayout frameLayout, Consumer<String> consumer) {
        return Companion.create(activity, frameLayout, consumer);
    }

    private ModsStartupController(Activity activity, FrameLayout frameLayout, Consumer<String> consumer) {
        this.activity = activity;
        this.parent = frameLayout;
        this.ready = consumer;
        Function1<ModsStartup.State, Unit> function1 = new Function1() { // from class: com.arizona.game.ModsStartupController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModsStartupController.listener$lambda$0(ModsStartupController.this, (ModsStartup.State) obj);
            }
        };
        this.listener = function1;
        ModsStartup.INSTANCE.attach(activity, function1);
    }

    /* compiled from: ModsStartup.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007b\u0002\b\u0010R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/arizona/game/ModsStartupController$Companion;", "", "<init>", "()V", "enabledForSession", "", "Ljava/lang/Boolean;", "create", "Lcom/arizona/game/ModsStartupController;", "activity", "Landroid/app/Activity;", "parent", "Landroid/widget/FrameLayout;", "ready", "Ljava/util/function/Consumer;", "", "Lkotlin/jvm/JvmStatic;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ModsStartupController create(Activity activity, FrameLayout parent, Consumer<String> ready) {
            boolean z;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(ready, "ready");
            Boolean bool = ModsStartupController.enabledForSession;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = ModsPreferences.INSTANCE.prefs(activity).getBoolean(ModsPreferences.ENABLED, false);
                Companion companion = ModsStartupController.Companion;
                ModsStartupController.enabledForSession = Boolean.valueOf(z);
            }
            if (!z) {
                ready.accept("{}");
                return null;
            }
            return new ModsStartupController(activity, parent, ready, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit listener$lambda$0(ModsStartupController modsStartupController, ModsStartup.State it) {
        Intrinsics.checkNotNullParameter(it, "it");
        modsStartupController.render(it);
        return Unit.INSTANCE;
    }

    private final LinearLayout showPanel() {
        LinearLayout linearLayout = this.panel;
        if (linearLayout == null) {
            linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.rgb(20, 23, 29));
            int dimensionPixelSize = linearLayout.getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._16sdp);
            linearLayout.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            TextView textView = new TextView(this.activity);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setTextSize(0, textView.getResources().getDimension(ru.mrlargha.commonui.R.dimen._14sdp));
            this.title = textView;
            LinearLayout linearLayout2 = null;
            ProgressBar progressBar = new ProgressBar(this.activity, null, 16842872);
            progressBar.setMax(1000);
            this.progress = progressBar;
            LinearLayout linearLayout3 = new LinearLayout(this.activity);
            linearLayout3.setGravity(17);
            this.buttons = linearLayout3;
            TextView textView2 = this.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            ProgressBar progressBar2 = this.progress;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
                progressBar2 = null;
            }
            linearLayout.addView(progressBar2, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout4 = this.buttons;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttons");
            } else {
                linearLayout2 = linearLayout4;
            }
            linearLayout.addView(linearLayout2);
            this.parent.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            this.panel = linearLayout;
        }
        return linearLayout;
    }

    public final void destroy() {
        ModsStartup.INSTANCE.detach(this.listener);
        LinearLayout linearLayout = this.panel;
        if (linearLayout != null) {
            this.parent.removeView(linearLayout);
        }
    }

    private final void render(ModsStartup.State state) {
        String string;
        if (this.completed || this.activity.isDestroyed() || this.activity.isFinishing()) {
            return;
        }
        String config = state.getConfig();
        boolean z = true;
        if (config != null) {
            this.completed = true;
            destroy();
            this.ready.accept(config);
        } else if (!state.getHasPreparationUi()) {
            LinearLayout linearLayout = this.panel;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            showPanel().setVisibility(0);
            LinearLayout linearLayout2 = this.buttons;
            ProgressBar progressBar = null;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttons");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            if (state.getError() != null) {
                TextView textView = this.title;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView = null;
                }
                textView.setText(this.activity.getString(com.miami.game.core.settings.R.string.mods_prepare_failed));
                ProgressBar progressBar2 = this.progress;
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progress");
                } else {
                    progressBar = progressBar2;
                }
                progressBar.setVisibility(8);
                button(com.miami.game.core.settings.R.string.mods_retry, new ModsStartupController$render$2(ModsStartup.INSTANCE));
                button(com.miami.game.core.settings.R.string.mods_start_without, new ModsStartupController$render$3(ModsStartup.INSTANCE));
                if (state.getPrevious() != null) {
                    button(com.miami.game.core.settings.R.string.mods_use_previous, new ModsStartupController$render$4(ModsStartup.INSTANCE));
                    return;
                }
                return;
            }
            ProgressBar progressBar3 = this.progress;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
                progressBar3 = null;
            }
            progressBar3.setVisibility(0);
            ModsSynchronizer.Progress progress = state.getProgress();
            if (progress == null) {
                progress = new ModsSynchronizer.Progress(true, null, 0, 0L, 0L, 30, null);
            }
            TextView textView2 = this.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            if (progress.getChecking() && progress.getFiles() == null) {
                string = this.activity.getString(com.miami.game.core.settings.R.string.mods_checking_start);
            } else {
                boolean checking = progress.getChecking();
                Activity activity = this.activity;
                if (checking) {
                    string = activity.getString(com.miami.game.core.settings.R.string.mods_checking, new Object[]{progress.getFiles()});
                } else {
                    string = activity.getString(com.miami.game.core.settings.R.string.mods_copying, new Object[]{progress.getFiles(), Integer.valueOf(progress.getTotalFiles()), Formatter.formatShortFileSize(this.activity, progress.getBytes())});
                }
            }
            textView2.setText(string);
            ProgressBar progressBar4 = this.progress;
            if (progressBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
                progressBar4 = null;
            }
            if (!progress.getChecking() && progress.getTotalBytes() > 0) {
                z = false;
            }
            progressBar4.setIndeterminate(z);
            ProgressBar progressBar5 = this.progress;
            if (progressBar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
                progressBar5 = null;
            }
            if (progressBar5.isIndeterminate()) {
                return;
            }
            ProgressBar progressBar6 = this.progress;
            if (progressBar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progress");
            } else {
                progressBar = progressBar6;
            }
            progressBar.setProgress(RangesKt.coerceIn((int) ((progress.getBytes() / progress.getTotalBytes()) * 1000.0d), 0, 1000));
        }
    }

    private final void button(int i, final Function0<Unit> function0) {
        LinearLayout linearLayout = this.buttons;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            linearLayout = null;
        }
        Button button = new Button(this.activity);
        button.setText(i);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.game.ModsStartupController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0.this.invoke();
            }
        });
        linearLayout.addView(button);
    }
}

package com.arizona.game;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.mods.ModsPreferences;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: ModsOverlayController.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\nH\u0002J\u001e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0/H\u0002J\b\u00100\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020#H\u0002J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0000¨\u00067"}, d2 = {"Lcom/arizona/game/ModsOverlayController;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "parent", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "full", "", "wrap", "size", TtmlNode.ATTR_ID, "gap", "padding", AdRevenueConstants.LAYER_KEY, "origin", "", "point", "menuAnchor", "Landroid/view/View;", "modal", FirebaseAnalytics.Param.CONTENT, "Landroid/widget/LinearLayout;", "rows", "revision", "", "lastRows", "", "details", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "sync", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", Constants.ScionAnalytics.PARAM_LABEL, "Landroid/widget/TextView;", "value", "", "color", "button", "text", "action", "Lkotlin/Function0;", "position", "render", RemoteConfigConstants.ResponseFieldKey.STATE, "isModalOpen", "", "destroy", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModsOverlayController {
    private final Activity activity;
    private final LinearLayout content;
    private final CustomCardView details;
    private final int full;
    private final int gap;
    private String lastRows;
    private final FrameLayout layer;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private final Function1<JSONObject, Unit> listener;
    private View menuAnchor;
    private final FrameLayout modal;
    private final int[] origin;
    private final int padding;
    private final FrameLayout parent;
    private final int[] point;
    private long revision;
    private final LinearLayout rows;
    private final CustomCardView sync;
    private final int wrap;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ ModsOverlayController(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    @JvmStatic
    public static final ModsOverlayController create(Activity activity, String str) {
        return Companion.create(activity, str);
    }

    /* compiled from: ModsOverlayController.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007b\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/arizona/game/ModsOverlayController$Companion;", "", "<init>", "()V", "create", "Lcom/arizona/game/ModsOverlayController;", "activity", "Landroid/app/Activity;", "config", "", "Lkotlin/jvm/JvmStatic;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ModsOverlayController create(Activity activity, String config) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(config, "config");
            if (ModsPreferences.INSTANCE.hotReloadCapable(activity) && new JSONObject(config).optBoolean("hotReload")) {
                return new ModsOverlayController(activity, null);
            }
            return null;
        }
    }

    private ModsOverlayController(Activity activity) {
        this.activity = activity;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.parent = frameLayout;
        this.full = -1;
        this.wrap = -2;
        int size = size(ru.mrlargha.commonui.R.dimen._8sdp);
        this.gap = size;
        int size2 = size(ru.mrlargha.commonui.R.dimen._12sdp);
        this.padding = size2;
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setElevation(size(ru.mrlargha.commonui.R.dimen._100sdp));
        this.layer = frameLayout2;
        this.origin = new int[2];
        this.point = new int[2];
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.setBackgroundColor(-1291845632);
        frameLayout3.setClickable(true);
        frameLayout3.setFocusable(true);
        frameLayout3.setVisibility(8);
        this.modal = frameLayout3;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(size2, size2, size2, size2);
        this.content = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        this.rows = linearLayout2;
        this.lastRows = "";
        CustomCardView button = button(com.miami.game.core.settings.R.string.mods_reload_details, new Function0() { // from class: com.arizona.game.ModsOverlayController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModsOverlayController.details$lambda$0();
            }
        });
        this.details = button;
        CustomCardView button2 = button(com.miami.game.core.settings.R.string.mods_reload_sync, new Function0() { // from class: com.arizona.game.ModsOverlayController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModsOverlayController.sync$lambda$0();
            }
        });
        this.sync = button2;
        ModsOverlayController$listener$1 modsOverlayController$listener$1 = new ModsOverlayController$listener$1(this);
        this.listener = modsOverlayController$listener$1;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.arizona.game.ModsOverlayController$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ModsOverlayController.this.position();
            }
        };
        this.layoutListener = onGlobalLayoutListener;
        frameLayout2.addView(button, new FrameLayout.LayoutParams(-2, -2));
        CustomCardView customCardView = new CustomCardView(activity, null);
        customCardView.setBackground(Color.rgb(17, 23, 33));
        customCardView.setCorners(size2);
        customCardView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        String string = activity.getString(com.miami.game.core.settings.R.string.mods_reload_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView label$default = label$default(this, string, 0, 2, null);
        label$default.setTypeface(label$default.getTypeface(), 1);
        linearLayout.addView(label$default);
        String string2 = activity.getString(com.miami.game.core.settings.R.string.mods_reload_explanation);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        TextView label$default2 = label$default(this, string2, 0, 2, null);
        label$default2.setPadding(0, size, 0, size);
        linearLayout.addView(label$default2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = size;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(button2, layoutParams);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.addView(linearLayout2);
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = size;
        layoutParams2.gravity = GravityCompat.END;
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(button(com.miami.game.core.settings.R.string.mods_reload_acknowledge, new Function0() { // from class: com.arizona.game.ModsOverlayController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModsOverlayController._init_$lambda$5(ModsOverlayController.this);
            }
        }), layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams3.setMargins(size2 * 3, size2, size2 * 3, size2);
        Unit unit3 = Unit.INSTANCE;
        frameLayout3.addView(customCardView, layoutParams3);
        frameLayout2.addView(frameLayout3, new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.setVisibility(8);
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        ModsRuntime.INSTANCE.attach(modsOverlayController$listener$1);
    }

    private final int size(int i) {
        return this.activity.getResources().getDimensionPixelSize(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit details$lambda$0() {
        natives.openResourceOverlayDetails();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit sync$lambda$0() {
        natives.requestResourceOverlaySync();
        return Unit.INSTANCE;
    }

    private final TextView label(CharSequence charSequence, int i) {
        TextView textView = new TextView(this.activity);
        textView.setText(charSequence);
        textView.setTextColor(i);
        textView.setTextSize(0, textView.getResources().getDimension(ru.mrlargha.commonui.R.dimen._12sdp));
        return textView;
    }

    static /* synthetic */ TextView label$default(ModsOverlayController modsOverlayController, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return modsOverlayController.label(charSequence, i);
    }

    private final CustomCardView button(int i, final Function0<Unit> function0) {
        CustomCardView customCardView = new CustomCardView(this.activity, null);
        customCardView.setBackground(Color.rgb(24, 30, 40));
        customCardView.setCorners(this.gap);
        customCardView.setClickable(true);
        customCardView.setFocusable(true);
        customCardView.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.game.ModsOverlayController$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0.this.invoke();
            }
        });
        String string = this.activity.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView label$default = label$default(this, string, 0, 2, null);
        label$default.setGravity(17);
        int i2 = this.padding;
        int i3 = this.gap;
        label$default.setPadding(i2, i3, i2, i3);
        int i4 = this.wrap;
        customCardView.addView(label$default, new FrameLayout.LayoutParams(i4, i4));
        customCardView.setContentDescription(this.activity.getString(i));
        return customCardView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$5(ModsOverlayController modsOverlayController) {
        natives.acknowledgeResourceOverlay(modsOverlayController.revision);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void position() {
        if (this.layer.getVisibility() != 0) {
            return;
        }
        View view = this.menuAnchor;
        if (view == null || !view.isAttachedToWindow()) {
            view = this.parent.findViewById(ru.mrlargha.commonui.R.id.btn_open_battle_pass);
            this.menuAnchor = view;
        }
        ViewParent parent = view != null ? view.getParent() : null;
        View view2 = parent instanceof View ? (View) parent : null;
        this.parent.getLocationInWindow(this.origin);
        if (view2 != null && view2.isShown()) {
            view2.getLocationInWindow(this.point);
            this.details.setX(this.point[0] - this.origin[0]);
            this.details.setY((this.point[1] - this.origin[1]) + view2.getHeight() + (this.gap * 2));
        } else {
            this.details.setX(this.padding);
            this.details.setY(this.parent.getHeight() * 0.4f);
        }
        FrameLayout frameLayout = this.parent;
        View childAt = frameLayout.getChildAt(frameLayout.getChildCount() - 1);
        FrameLayout frameLayout2 = this.layer;
        if (childAt != frameLayout2) {
            frameLayout2.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render(JSONObject jSONObject) {
        int i;
        if (this.activity.isDestroyed() || this.activity.isFinishing()) {
            return;
        }
        this.revision = jSONObject.optLong("revision");
        boolean optBoolean = jSONObject.optBoolean(TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
        int i2 = 8;
        this.details.setVisibility((jSONObject.optBoolean("restart") || jSONObject.optBoolean("restream") || jSONObject.optBoolean("failed") || jSONObject.optBoolean("waiting") || jSONObject.optBoolean("canSync")) ? 0 : 8);
        this.sync.setVisibility(jSONObject.optBoolean("canSync") ? 0 : 8);
        this.sync.setEnabled(!jSONObject.optBoolean("syncRunning"));
        View childAt = this.sync.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt).setText(this.sync.isEnabled() ? com.miami.game.core.settings.R.string.mods_reload_sync : com.miami.game.core.settings.R.string.mods_reload_syncing);
        CustomCardView customCardView = this.sync;
        customCardView.setAlpha(customCardView.isEnabled() ? 1.0f : 0.6f);
        this.modal.setVisibility(optBoolean ? 0 : 8);
        this.layer.setVisibility((optBoolean || this.details.getVisibility() == 0) ? 0 : 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        String jSONArray = optJSONArray != null ? optJSONArray.toString() : null;
        if (jSONArray == null) {
            jSONArray = "";
        }
        if (!Intrinsics.areEqual(jSONArray, this.lastRows)) {
            this.lastRows = jSONArray;
            this.rows.removeAllViews();
            int length = optJSONArray != null ? optJSONArray.length() : 0;
            for (int i3 = 0; i3 < length; i3++) {
                Intrinsics.checkNotNull(optJSONArray);
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                int optInt = jSONObject2.optInt(RemoteConfigConstants.ResponseFieldKey.STATE);
                if (optInt == 1) {
                    i = com.miami.game.core.settings.R.string.mods_reload_waiting;
                } else if (optInt == 2) {
                    i = com.miami.game.core.settings.R.string.mods_reload_applied;
                } else if (optInt == 3) {
                    String optString = jSONObject2.optString("path");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    if (StringsKt.endsWith(optString, ".ipl", true)) {
                        i = com.miami.game.core.settings.R.string.mods_reload_ipl_restream;
                    } else {
                        String optString2 = jSONObject2.optString("path");
                        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                        i = StringsKt.endsWith(optString2, ".ifp", true) ? com.miami.game.core.settings.R.string.mods_reload_animation_restream : com.miami.game.core.settings.R.string.mods_reload_restream_reason;
                    }
                } else if (optInt == 4) {
                    i = com.miami.game.core.settings.R.string.mods_reload_restart_reason;
                } else if (optInt == 5) {
                    i = com.miami.game.core.settings.R.string.mods_reload_failed;
                } else {
                    i = com.miami.game.core.settings.R.string.mods_reload_preparing;
                }
                LinearLayout linearLayout = this.rows;
                String optString3 = jSONObject2.optString("path");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                linearLayout.addView(label$default(this, optString3, 0, 2, null));
                LinearLayout linearLayout2 = this.rows;
                String string = this.activity.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                linearLayout2.addView(label(string, Color.rgb(255, 200, 100)));
                String optString4 = jSONObject2.optString("reason");
                Intrinsics.checkNotNull(optString4);
                String str = optString4;
                if (str.length() > 0) {
                    this.rows.addView(label(str, -3355444));
                }
                LinearLayout linearLayout3 = this.rows;
                View view = new View(this.activity);
                view.setBackgroundColor(-12038048);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.full, size(ru.mrlargha.commonui.R.dimen._1sdp));
                int i4 = this.gap;
                layoutParams.setMargins(0, i4, 0, i4);
                Unit unit = Unit.INSTANCE;
                linearLayout3.addView(view, layoutParams);
            }
        }
        if (optBoolean) {
            this.modal.requestFocus();
        }
        position();
    }

    public final boolean isModalOpen() {
        return this.modal.getVisibility() == 0;
    }

    public final void destroy() {
        ModsRuntime.INSTANCE.detach(this.listener);
        if (this.parent.getViewTreeObserver().isAlive()) {
            this.parent.getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
        }
        this.parent.removeView(this.layer);
    }
}

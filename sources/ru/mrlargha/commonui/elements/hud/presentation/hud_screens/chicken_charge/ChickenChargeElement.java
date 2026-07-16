package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementChickenChargeBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: ChickenCharge.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020!0\fJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$J,\u0010%\u001a\u001e\u0012\f\u0012\n '*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n '*\u0004\u0018\u00010(0(0&2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001c\u0010*\u001a\u00020\u0011*\u00020\r2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0014\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u00020$H\u0002J\u0016\u00105\u001a\u00020$2\f\b\u0001\u00106\u001a\u00020$:\u0002\b7H\u0002J/\u00108\u001a\u00020\u00132\f\b\u0001\u00106\u001a\u00020$:\u0002\b92\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010;\"\u00020\u0001H\u0002¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020\u00132\f\b\u0001\u00106\u001a\u00020$:\u0002\b9H\u0002J\b\u0010>\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010,\u001a\u00020\r*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00020\r*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.¨\u0006@"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "animator1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/PercentMover;", "animator2", "sideImages", "", "Landroid/widget/ImageView;", "currentVariant", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeVariant;", "setVisibility", "", "data", "", "setInfo", "setData", "info", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageState;", "renderAction", "renderStage", "renderPlayerOne", "renderPlayerTwo", "renderTargetZone", "", "renderTurnState", "showMainState", "setResult", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/HudChickenChargeResult;", "setType", "type", "", "applyVariant", "Lcom/bumptech/glide/request/target/ViewTarget;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "variant", "applySideImage", "isRight", "leftSideImage", "getLeftSideImage", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeVariant;)Landroid/widget/ImageView;", "rightSideImage", "getRightSideImage", "percentToX", "", "Landroid/view/View;", "percent", "dimen", "resId", "Landroidx/annotation/DimenRes;", TypedValues.Custom.S_STRING, "Landroidx/annotation/StringRes;", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "stringOrEmpty", "stopAnimations", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChickenChargeElement {
    public static final int CHICKEN = 0;
    private static final int CLICK_CLOSE = 92;
    private static final int CLICK_START = 90;
    private static final int CLICK_STOP = 91;
    private static final float DISABLED_ALPHA = 0.2f;
    private static final float ENABLED_ALPHA = 1.0f;
    public static final int HAY = 2;
    public static final int SAFE = 3;
    public static final int SAWMILL = 1;
    private final PercentMover animator1;
    private final PercentMover animator2;
    private final HudElementChickenChargeBinding binding;
    private ChickenChargeVariant currentVariant;
    private final SAMPUIElement notifier;
    private final List<ImageView> sideImages;
    public static final Companion Companion = new Companion(null);
    private static final int BUTTON_BG_MAIN = Color.parseColor("#000B22");
    private static final int BUTTON_START_BG = Color.parseColor("#1C692D");
    private static final int BUTTON_START_BORDER = Color.parseColor("#50DA59");
    private static final int BUTTON_STOP_BG = Color.parseColor("#D81C45");
    private static final int BUTTON_STOP_BORDER = Color.parseColor("#E2254E");
    private static final int RESULT_SUCCESS_COLOR = Color.parseColor("#BFFF64");
    private static final int RESULT_FAIL_COLOR = Color.parseColor("#E83C3C");

    public ChickenChargeElement(HudElementChickenChargeBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        CustomCardView player1progressbar = binding.player1progressbar;
        Intrinsics.checkNotNullExpressionValue(player1progressbar, "player1progressbar");
        FrameLayout player1target = binding.player1target;
        Intrinsics.checkNotNullExpressionValue(player1target, "player1target");
        this.animator1 = new PercentMover(player1progressbar, player1target);
        CustomCardView player2progressbar = binding.player2progressbar;
        Intrinsics.checkNotNullExpressionValue(player2progressbar, "player2progressbar");
        FrameLayout player2target = binding.player2target;
        Intrinsics.checkNotNullExpressionValue(player2target, "player2target");
        this.animator2 = new PercentMover(player2progressbar, player2target);
        this.sideImages = CollectionsKt.listOf((Object[]) new ImageView[]{binding.ivBgLeftVariant, binding.ivBgRightVariant});
        ChickenChargeVariant fromType = ChickenChargeVariant.Companion.fromType(0);
        this.currentVariant = fromType;
        applyVariant(fromType);
    }

    public final void setVisibility(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data, "1")) {
            showMainState();
            this.binding.getRoot().setVisibility(0);
            return;
        }
        stopAnimations();
        this.binding.getRoot().setVisibility(8);
    }

    private final void setData(List<StageState> list) {
        StageState stageState = (StageState) CollectionsKt.getOrNull(list, 0);
        if (stageState == null) {
            return;
        }
        renderAction(stageState);
        renderStage(stageState);
        renderPlayerOne(stageState);
        renderPlayerTwo(stageState);
        renderTargetZone(stageState);
        renderTurnState(stageState);
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(ChickenChargeElement.this.notifier, ChickenChargeElement.CLICK_CLOSE, ChickenChargeElement.CLICK_CLOSE, null, 4, null);
            }
        });
    }

    private final void renderAction(final StageState stageState) {
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        boolean z = stageState.isMyState() == 1;
        StageUserInfo stageUserInfo = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0);
        boolean z2 = stageUserInfo != null && stageUserInfo.getMoving() == 1;
        if (z && z2) {
            hudElementChickenChargeBinding.action.setEnabled(true);
            hudElementChickenChargeBinding.action.setAlpha(1.0f);
            CustomCardView action = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action, "action");
            CustomCardView.setBackground$default(action, BUTTON_BG_MAIN, BUTTON_STOP_BG, null, null, 12, null);
            CustomCardView customCardView = hudElementChickenChargeBinding.action;
            int i = BUTTON_STOP_BORDER;
            customCardView.setBorder(i);
            hudElementChickenChargeBinding.actionText.setText(string(R.string.chicken_charge_stop, new Object[0]));
            hudElementChickenChargeBinding.actionIc.setImageTintList(ColorStateList.valueOf(i));
            hudElementChickenChargeBinding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenChargeElement.renderAction$lambda$0$0(ChickenChargeElement.this, stageState, view);
                }
            });
        } else if (z) {
            hudElementChickenChargeBinding.action.setEnabled(true);
            hudElementChickenChargeBinding.action.setAlpha(1.0f);
            CustomCardView action2 = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action2, "action");
            CustomCardView.setBackground$default(action2, BUTTON_BG_MAIN, BUTTON_START_BG, null, null, 12, null);
            hudElementChickenChargeBinding.action.setBorder(BUTTON_START_BORDER);
            hudElementChickenChargeBinding.actionText.setText(string(R.string.chicken_charge_start, new Object[0]));
            hudElementChickenChargeBinding.actionIc.setImageTintList(null);
            hudElementChickenChargeBinding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenChargeElement.renderAction$lambda$0$1(ChickenChargeElement.this, view);
                }
            });
        } else {
            hudElementChickenChargeBinding.action.setEnabled(false);
            hudElementChickenChargeBinding.action.setAlpha(0.2f);
            CustomCardView action3 = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action3, "action");
            CustomCardView.setBackground$default(action3, BUTTON_BG_MAIN, BUTTON_START_BG, null, null, 12, null);
            hudElementChickenChargeBinding.action.setBorder(BUTTON_START_BORDER);
            hudElementChickenChargeBinding.actionText.setText(string(R.string.chicken_charge_start, new Object[0]));
            hudElementChickenChargeBinding.actionIc.setImageTintList(null);
            hudElementChickenChargeBinding.action.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderAction$lambda$0$0(ChickenChargeElement chickenChargeElement, StageState stageState, View view) {
        float stop$default = PercentMover.stop$default(chickenChargeElement.animator1, false, 1, null);
        float start = stageState.getWidth() != 0 ? ((stop$default - stageState.getStart()) / stageState.getWidth()) * 100.0f : 0.0f;
        chickenChargeElement.notifier.notifyClick(CLICK_STOP, CLICK_STOP, MathKt.roundToInt(stop$default) + ", " + MathKt.roundToInt(start));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderAction$lambda$0$1(ChickenChargeElement chickenChargeElement, View view) {
        SAMPUIElement.notifyClick$default(chickenChargeElement.notifier, 90, 90, null, 4, null);
    }

    private final void renderStage(StageState stageState) {
        this.binding.stage.setText(string(R.string.chicken_charge_stage_format, Integer.valueOf(stageState.getStage()), Integer.valueOf(stageState.getStageTotal())));
    }

    private final void renderPlayerOne(StageState stageState) {
        StageUserInfo stageUserInfo = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0);
        if (stageUserInfo == null) {
            return;
        }
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        this.animator1.setCurrentPercent(stageUserInfo.getCurrentPosition());
        FrameLayout frameLayout = hudElementChickenChargeBinding.player1target;
        CustomCardView player1progressbar = hudElementChickenChargeBinding.player1progressbar;
        Intrinsics.checkNotNullExpressionValue(player1progressbar, "player1progressbar");
        frameLayout.setTranslationX(percentToX(player1progressbar, stageUserInfo.getCurrentPosition()));
        hudElementChickenChargeBinding.chance1.setText(string(R.string.chicken_charge_chance_value, Integer.valueOf(stageUserInfo.getChance())));
        hudElementChickenChargeBinding.name1.setText(stageUserInfo.getName());
        if (stageUserInfo.getMoving() == 1) {
            hudElementChickenChargeBinding.chickenGif.setVisibility(0);
            PercentMover.start$default(this.animator1, stageState.getSpeed(), 0L, 2, null);
            return;
        }
        hudElementChickenChargeBinding.chickenGif.setVisibility(8);
        this.animator1.stop(false);
    }

    private final void renderPlayerTwo(StageState stageState) {
        if (!this.currentVariant.getShowSecondPlayer()) {
            this.binding.chickenGif2.setVisibility(8);
            this.animator2.stop(false);
            return;
        }
        StageUserInfo stageUserInfo = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 1);
        if (stageUserInfo == null) {
            return;
        }
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        this.animator2.setCurrentPercent(stageUserInfo.getCurrentPosition());
        FrameLayout frameLayout = hudElementChickenChargeBinding.player2target;
        CustomCardView player2progressbar = hudElementChickenChargeBinding.player2progressbar;
        Intrinsics.checkNotNullExpressionValue(player2progressbar, "player2progressbar");
        frameLayout.setTranslationX(percentToX(player2progressbar, stageUserInfo.getCurrentPosition()));
        hudElementChickenChargeBinding.chance2.setText(string(R.string.chicken_charge_chance_value, Integer.valueOf(stageUserInfo.getChance())));
        hudElementChickenChargeBinding.name2.setText(stageUserInfo.getName());
        if (stageUserInfo.getMoving() == 1 && stageState.isMyState() != 1) {
            hudElementChickenChargeBinding.chickenGif2.setVisibility(0);
            PercentMover.start$default(this.animator2, stageState.getSpeed(), 0L, 2, null);
            return;
        }
        hudElementChickenChargeBinding.chickenGif2.setVisibility(8);
        this.animator2.stop(false);
    }

    private final boolean renderTargetZone(final StageState stageState) {
        final HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        return hudElementChickenChargeBinding.player1progressbar.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ChickenChargeElement.renderTargetZone$lambda$0$0(HudElementChickenChargeBinding.this, stageState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderTargetZone$lambda$0$0(HudElementChickenChargeBinding hudElementChickenChargeBinding, StageState stageState) {
        float width = hudElementChickenChargeBinding.player1progressbar.getWidth();
        float start = (stageState.getStart() * width) / 100.0f;
        float width2 = (width * stageState.getWidth()) / 100.0f;
        hudElementChickenChargeBinding.zone.setTranslationX(start);
        FrameLayout zone = hudElementChickenChargeBinding.zone;
        Intrinsics.checkNotNullExpressionValue(zone, "zone");
        FrameLayout frameLayout = zone;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            int i = (int) width2;
            layoutParams.width = i;
            frameLayout.setLayoutParams(layoutParams);
            hudElementChickenChargeBinding.zone2.setTranslationX(start);
            FrameLayout zone2 = hudElementChickenChargeBinding.zone2;
            Intrinsics.checkNotNullExpressionValue(zone2, "zone2");
            FrameLayout frameLayout2 = zone2;
            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i;
                frameLayout2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void renderTurnState(StageState stageState) {
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        boolean z = true;
        boolean z2 = stageState.isMyState() == 1;
        hudElementChickenChargeBinding.player1tooltip.setAlpha(z2 ? 1.0f : 0.2f);
        hudElementChickenChargeBinding.player1progressbar.setAlpha(z2 ? 1.0f : 0.2f);
        hudElementChickenChargeBinding.player1target.setAlpha(z2 ? 1.0f : 0.2f);
        hudElementChickenChargeBinding.player2tooltip.setAlpha(!z2 ? 1.0f : 0.2f);
        hudElementChickenChargeBinding.player2progressbar.setAlpha(z2 ? 0.2f : 1.0f);
        TextView tvWaitingYou = hudElementChickenChargeBinding.tvWaitingYou;
        Intrinsics.checkNotNullExpressionValue(tvWaitingYou, "tvWaitingYou");
        tvWaitingYou.setVisibility(z2 && this.currentVariant.getWaitingYourTurnTextRes() != 0 ? 0 : 8);
        TextView tvYouWaiting = hudElementChickenChargeBinding.tvYouWaiting;
        Intrinsics.checkNotNullExpressionValue(tvYouWaiting, "tvYouWaiting");
        TextView textView = tvYouWaiting;
        if (z2 || !this.currentVariant.getShowSecondPlayer()) {
            z = false;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    private final void showMainState() {
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        applyVariant(this.currentVariant);
        LinearLayout main = hudElementChickenChargeBinding.main;
        Intrinsics.checkNotNullExpressionValue(main, "main");
        main.setVisibility(0);
        LinearLayout main2 = hudElementChickenChargeBinding.main2;
        Intrinsics.checkNotNullExpressionValue(main2, "main2");
        main2.setVisibility(0);
        FrameLayout hided = hudElementChickenChargeBinding.hided;
        Intrinsics.checkNotNullExpressionValue(hided, "hided");
        hided.setVisibility(0);
        hudElementChickenChargeBinding.hided.setAlpha(1.0f);
        LinearLayout finalContainer = hudElementChickenChargeBinding.finalContainer;
        Intrinsics.checkNotNullExpressionValue(finalContainer, "finalContainer");
        finalContainer.setVisibility(8);
        applySideImage(getLeftSideImage(this.currentVariant), this.currentVariant, false);
        getRightSideImage(this.currentVariant).setVisibility(8);
    }

    public final void setResult(List<HudChickenChargeResult> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HudChickenChargeResult hudChickenChargeResult = (HudChickenChargeResult) CollectionsKt.getOrNull(data, 0);
        if (hudChickenChargeResult == null) {
            return;
        }
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        stopAnimations();
        hudElementChickenChargeBinding.ivBgMain.setImageResource(this.currentVariant.getFinalBgRes());
        ImageView ivBgMain = hudElementChickenChargeBinding.ivBgMain;
        Intrinsics.checkNotNullExpressionValue(ivBgMain, "ivBgMain");
        ImageView imageView = ivBgMain;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = dimen(this.currentVariant.getFinalBgHeightRes());
            imageView.setLayoutParams(layoutParams);
            applySideImage(getLeftSideImage(this.currentVariant), this.currentVariant, false);
            applySideImage(getRightSideImage(this.currentVariant), this.currentVariant, true);
            LinearLayout main = hudElementChickenChargeBinding.main;
            Intrinsics.checkNotNullExpressionValue(main, "main");
            main.setVisibility(8);
            hudElementChickenChargeBinding.hided.setAlpha(0.2f);
            LinearLayout finalContainer = hudElementChickenChargeBinding.finalContainer;
            Intrinsics.checkNotNullExpressionValue(finalContainer, "finalContainer");
            finalContainer.setVisibility(0);
            TextView tvWaitingYou = hudElementChickenChargeBinding.tvWaitingYou;
            Intrinsics.checkNotNullExpressionValue(tvWaitingYou, "tvWaitingYou");
            tvWaitingYou.setVisibility(8);
            TextView tvYouWaiting = hudElementChickenChargeBinding.tvYouWaiting;
            Intrinsics.checkNotNullExpressionValue(tvYouWaiting, "tvYouWaiting");
            tvYouWaiting.setVisibility(8);
            hudElementChickenChargeBinding.tvPercentSuccess.setText(string(R.string.chicken_charge_total_chance_format, Integer.valueOf(hudChickenChargeResult.getChance())));
            if (hudChickenChargeResult.getSuccess() == 1) {
                hudElementChickenChargeBinding.tvResult.setText(string(this.currentVariant.getSuccessTextRes(), new Object[0]));
                hudElementChickenChargeBinding.tvResult.setTextColor(RESULT_SUCCESS_COLOR);
                return;
            }
            hudElementChickenChargeBinding.tvResult.setText(string(this.currentVariant.getFailTextRes(), new Object[0]));
            hudElementChickenChargeBinding.tvResult.setTextColor(RESULT_FAIL_COLOR);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setType(int i) {
        this.currentVariant = ChickenChargeVariant.Companion.fromType(i);
        showMainState();
        this.binding.getRoot().setVisibility(0);
    }

    private final ViewTarget<ImageView, Drawable> applyVariant(ChickenChargeVariant chickenChargeVariant) {
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        Iterator<T> it = this.sideImages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ((ImageView) it.next()).setVisibility(8);
        }
        hudElementChickenChargeBinding.ivBgText.setImageResource(chickenChargeVariant.getTitleRes());
        hudElementChickenChargeBinding.ivBgMain.setImageResource(chickenChargeVariant.getMainBgRes());
        ImageView ivBgMain = hudElementChickenChargeBinding.ivBgMain;
        Intrinsics.checkNotNullExpressionValue(ivBgMain, "ivBgMain");
        ImageView imageView = ivBgMain;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = dimen(chickenChargeVariant.getMainBgHeightRes());
            imageView.setLayoutParams(layoutParams);
            ImageView ivBgMain2 = hudElementChickenChargeBinding.ivBgMain;
            Intrinsics.checkNotNullExpressionValue(ivBgMain2, "ivBgMain");
            ivBgMain2.setVisibility(0);
            hudElementChickenChargeBinding.ivBgMain.setImageTintList(null);
            FrameLayout player2target = hudElementChickenChargeBinding.player2target;
            Intrinsics.checkNotNullExpressionValue(player2target, "player2target");
            player2target.setVisibility(chickenChargeVariant.getShowSecondPlayer() ? 0 : 8);
            TextView chance2 = hudElementChickenChargeBinding.chance2;
            Intrinsics.checkNotNullExpressionValue(chance2, "chance2");
            chance2.setVisibility(chickenChargeVariant.getShowSecondPlayer() ? 0 : 8);
            LinearLayout player2Info = hudElementChickenChargeBinding.player2Info;
            Intrinsics.checkNotNullExpressionValue(player2Info, "player2Info");
            player2Info.setVisibility(chickenChargeVariant.getShowSecondPlayer() ? 0 : 8);
            hudElementChickenChargeBinding.tvWaitingYou.setText(stringOrEmpty(chickenChargeVariant.getWaitingYourTurnTextRes()));
            hudElementChickenChargeBinding.tvYouWaiting.setText(string(R.string.chicken_charge_waiting_partner_turn, new Object[0]));
            hudElementChickenChargeBinding.player1progressbar.setBackground(chickenChargeVariant.getProgressColor());
            hudElementChickenChargeBinding.player2progressbar.setBackground(chickenChargeVariant.getProgressColor());
            Glide.with(hudElementChickenChargeBinding.chickenGif.getContext()).load(Integer.valueOf(chickenChargeVariant.getPlayerGifRes())).into(hudElementChickenChargeBinding.chickenGif);
            ViewTarget<ImageView, Drawable> into = Glide.with(hudElementChickenChargeBinding.chickenGif2.getContext()).load(Integer.valueOf(chickenChargeVariant.getOpponentGifRes())).into(hudElementChickenChargeBinding.chickenGif2);
            Intrinsics.checkNotNullExpressionValue(into, "with(...)");
            return into;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void applySideImage(ImageView imageView, ChickenChargeVariant chickenChargeVariant, boolean z) {
        imageView.setImageResource(chickenChargeVariant.getSideImageRes());
        ImageView imageView2 = imageView;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        layoutParams3.width = dimen(chickenChargeVariant.getSideWidthRes());
        layoutParams3.height = dimen(chickenChargeVariant.getSideHeightRes());
        layoutParams3.leftMargin = z ? dimen(chickenChargeVariant.getSideMarginRes()) : 0;
        layoutParams3.rightMargin = z ? 0 : dimen(chickenChargeVariant.getSideMarginRes());
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setVisibility(0);
    }

    private final ImageView getLeftSideImage(ChickenChargeVariant chickenChargeVariant) {
        ImageView ivBgLeftVariant = this.binding.ivBgLeftVariant;
        Intrinsics.checkNotNullExpressionValue(ivBgLeftVariant, "ivBgLeftVariant");
        return ivBgLeftVariant;
    }

    private final ImageView getRightSideImage(ChickenChargeVariant chickenChargeVariant) {
        ImageView ivBgRightVariant = this.binding.ivBgRightVariant;
        Intrinsics.checkNotNullExpressionValue(ivBgRightVariant, "ivBgRightVariant");
        return ivBgRightVariant;
    }

    private final float percentToX(View view, int i) {
        return (view.getWidth() * i) / 100.0f;
    }

    private final int dimen(int i) {
        return this.binding.getRoot().getResources().getDimensionPixelSize(i);
    }

    private final String string(int i, Object... objArr) {
        String string = this.binding.getRoot().getContext().getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String stringOrEmpty(int i) {
        return i == 0 ? "" : string(i, new Object[0]);
    }

    private final void stopAnimations() {
        this.animator1.stop(false);
        this.animator2.stop(false);
    }

    /* compiled from: ChickenCharge.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0015\u0010\u000f\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0011\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0013\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0015\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\u00020\u00058\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0010¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement$Companion;", "", "<init>", "()V", "CHICKEN", "", "SAWMILL", "HAY", "SAFE", "CLICK_START", "CLICK_STOP", "CLICK_CLOSE", "ENABLED_ALPHA", "", "DISABLED_ALPHA", "BUTTON_BG_MAIN", "Landroidx/annotation/ColorInt;", "BUTTON_START_BG", "BUTTON_START_BORDER", "BUTTON_STOP_BG", "BUTTON_STOP_BORDER", "RESULT_SUCCESS_COLOR", "RESULT_FAIL_COLOR", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setInfo(String data) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                JsonArray asJsonArray = ((JsonElement) MapperKt.getGson().fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                Intrinsics.checkNotNull(asJsonArray);
                JsonArray<JsonElement> jsonArray = asJsonArray;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                for (JsonElement jsonElement : jsonArray) {
                    arrayList2.add(MapperKt.getGson().fromJson(jsonElement, (Class<Object>) StageState.class));
                }
                arrayList = arrayList2;
            } else {
                arrayList = CollectionsKt.emptyList();
            }
            setData(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            stopAnimations();
            this.binding.getRoot().setVisibility(8);
        }
    }
}

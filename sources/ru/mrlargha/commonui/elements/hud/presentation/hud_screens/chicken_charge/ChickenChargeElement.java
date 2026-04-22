package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018J\u0016\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0014\u0010#\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020$0 J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "animator1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/PercentMover;", "animator2", "mainBg", "", "finalBg", "playerGif", "opponentGif", "leftImg", "Landroid/widget/ImageView;", "rightImg", "successText", "", "failText", "setVisibility", "", "data", "setInfo", "setData", "info", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageState;", "firstOpen", "setResult", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/HudChickenChargeResult;", "setType", "type", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChickenChargeElement {
    public static final int CHICKEN = 0;
    public static final Companion Companion = new Companion(null);
    public static final int HAY = 2;
    public static final int SAWMILL = 1;
    private final PercentMover animator1;
    private final PercentMover animator2;
    private final HudElementChickenChargeBinding binding;
    private String failText;
    private int finalBg;
    private ImageView leftImg;
    private int mainBg;
    private final SAMPUIElement notifier;
    private int opponentGif;
    private int playerGif;
    private ImageView rightImg;
    private String successText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$2(View view) {
    }

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
        ImageView ivBgLeftChiken = binding.ivBgLeftChiken;
        Intrinsics.checkNotNullExpressionValue(ivBgLeftChiken, "ivBgLeftChiken");
        this.leftImg = ivBgLeftChiken;
        ImageView ivBgRightChiken = binding.ivBgRightChiken;
        Intrinsics.checkNotNullExpressionValue(ivBgRightChiken, "ivBgRightChiken");
        this.rightImg = ivBgRightChiken;
        this.successText = "УСПЕХ";
        this.failText = "ПРОВАЛ";
    }

    public final HudElementChickenChargeBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final void setVisibility(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        firstOpen();
        boolean areEqual = Intrinsics.areEqual(data, "1");
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        if (areEqual) {
            hudElementChickenChargeBinding.getRoot().setVisibility(0);
        } else {
            hudElementChickenChargeBinding.getRoot().setVisibility(8);
        }
    }

    private final void setData(List<StageState> list) {
        StageUserInfo stageUserInfo;
        StageUserInfo stageUserInfo2;
        final StageState stageState = (StageState) CollectionsKt.getOrNull(list, 0);
        if (stageState == null) {
            return;
        }
        final HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        if (stageState.isMyState() == 1 && (stageUserInfo2 = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0)) != null && stageUserInfo2.getMoving() == 1) {
            hudElementChickenChargeBinding.action.setAlpha(1.0f);
            CustomCardView action = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action, "action");
            CustomCardView.setBackground$default(action, Color.parseColor("#000B22"), Color.parseColor("#D81C45"), null, null, 12, null);
            hudElementChickenChargeBinding.action.setBorder(Color.parseColor("#E2254E"));
            hudElementChickenChargeBinding.actionText.setText("стоп");
            hudElementChickenChargeBinding.actionIc.setImageTintList(ColorStateList.valueOf(Color.parseColor("#E2254E")));
            hudElementChickenChargeBinding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenChargeElement.setData$lambda$0$0(ChickenChargeElement.this, stageState, view);
                }
            });
        } else if (stageState.isMyState() == 1 && ((stageUserInfo = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0)) == null || stageUserInfo.getMoving() != 1)) {
            hudElementChickenChargeBinding.action.setAlpha(1.0f);
            CustomCardView action2 = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action2, "action");
            CustomCardView.setBackground$default(action2, Color.parseColor("#000B22"), Color.parseColor("#1C692D"), null, null, 12, null);
            hudElementChickenChargeBinding.action.setBorder(Color.parseColor("#50DA59"));
            hudElementChickenChargeBinding.actionText.setText("Запуск");
            hudElementChickenChargeBinding.actionIc.setImageTintList(null);
            hudElementChickenChargeBinding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenChargeElement.setData$lambda$0$1(ChickenChargeElement.this, view);
                }
            });
        } else {
            hudElementChickenChargeBinding.action.setAlpha(0.2f);
            CustomCardView action3 = hudElementChickenChargeBinding.action;
            Intrinsics.checkNotNullExpressionValue(action3, "action");
            CustomCardView.setBackground$default(action3, Color.parseColor("#000B22"), Color.parseColor("#1C692D"), null, null, 12, null);
            hudElementChickenChargeBinding.action.setBorder(Color.parseColor("#50DA59"));
            hudElementChickenChargeBinding.actionText.setText("Запуск");
            hudElementChickenChargeBinding.actionIc.setImageTintList(null);
            hudElementChickenChargeBinding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenChargeElement.setData$lambda$0$2(view);
                }
            });
        }
        hudElementChickenChargeBinding.stage.setText("Этап " + stageState.getStage() + "/" + stageState.getStageTotal());
        Glide.with(hudElementChickenChargeBinding.chickenGif.getContext()).load(Integer.valueOf(this.playerGif)).into(hudElementChickenChargeBinding.chickenGif);
        Glide.with(hudElementChickenChargeBinding.chickenGif.getContext()).load(Integer.valueOf(this.opponentGif)).into(hudElementChickenChargeBinding.chickenGif2);
        StageUserInfo stageUserInfo3 = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0);
        if (stageUserInfo3 != null) {
            this.animator1.setCurrentPercent(stageUserInfo3.getCurrentPosition());
            hudElementChickenChargeBinding.player1target.setTranslationX((this.binding.player1progressbar.getWidth() * stageUserInfo3.getCurrentPosition()) / 100.0f);
            hudElementChickenChargeBinding.chance1.setText(stageUserInfo3.getChance() + "%");
            hudElementChickenChargeBinding.name1.setText(stageUserInfo3.getName());
            if (stageUserInfo3.getMoving() == 1) {
                hudElementChickenChargeBinding.chickenGif.setVisibility(0);
                PercentMover.start$default(this.animator1, stageState.getSpeed(), 0L, 2, null);
            } else {
                hudElementChickenChargeBinding.chickenGif.setVisibility(8);
                this.animator1.stop();
            }
        }
        StageUserInfo stageUserInfo4 = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 1);
        if (stageUserInfo4 != null) {
            this.animator2.setCurrentPercent(stageUserInfo4.getCurrentPosition());
            hudElementChickenChargeBinding.player2target.setTranslationX((this.binding.player1progressbar.getWidth() * stageUserInfo4.getCurrentPosition()) / 100.0f);
            hudElementChickenChargeBinding.chance2.setText(stageUserInfo4.getChance() + "%");
            hudElementChickenChargeBinding.name2.setText(stageUserInfo4.getName());
            if (stageUserInfo4.getMoving() == 1) {
                hudElementChickenChargeBinding.chickenGif2.setVisibility(0);
                PercentMover.start$default(this.animator2, stageState.getSpeed(), 0L, 2, null);
            } else {
                this.animator2.stop();
            }
            if (stageState.isMyState() == 1) {
                hudElementChickenChargeBinding.chickenGif2.setVisibility(8);
            }
        }
        this.binding.player1progressbar.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ChickenChargeElement.setData$lambda$0$5(ChickenChargeElement.this, stageState, hudElementChickenChargeBinding);
            }
        });
        if (stageState.isMyState() == 1) {
            hudElementChickenChargeBinding.player2tooltip.setAlpha(0.2f);
            hudElementChickenChargeBinding.player1tooltip.setAlpha(1.0f);
            hudElementChickenChargeBinding.player1progressbar.setAlpha(1.0f);
            hudElementChickenChargeBinding.player2progressbar.setAlpha(0.2f);
            hudElementChickenChargeBinding.player1target.setAlpha(1.0f);
            TextView tvWaitingYou = hudElementChickenChargeBinding.tvWaitingYou;
            Intrinsics.checkNotNullExpressionValue(tvWaitingYou, "tvWaitingYou");
            tvWaitingYou.setVisibility(0);
            TextView tvYouWaiting = hudElementChickenChargeBinding.tvYouWaiting;
            Intrinsics.checkNotNullExpressionValue(tvYouWaiting, "tvYouWaiting");
            tvYouWaiting.setVisibility(8);
        } else {
            hudElementChickenChargeBinding.player2tooltip.setAlpha(1.0f);
            hudElementChickenChargeBinding.player1tooltip.setAlpha(0.2f);
            hudElementChickenChargeBinding.player1target.setAlpha(0.2f);
            hudElementChickenChargeBinding.player1progressbar.setAlpha(0.2f);
            hudElementChickenChargeBinding.player2progressbar.setAlpha(1.0f);
            TextView tvWaitingYou2 = hudElementChickenChargeBinding.tvWaitingYou;
            Intrinsics.checkNotNullExpressionValue(tvWaitingYou2, "tvWaitingYou");
            tvWaitingYou2.setVisibility(8);
            TextView tvYouWaiting2 = hudElementChickenChargeBinding.tvYouWaiting;
            Intrinsics.checkNotNullExpressionValue(tvYouWaiting2, "tvYouWaiting");
            tvYouWaiting2.setVisibility(0);
        }
        hudElementChickenChargeBinding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChickenChargeElement.setData$lambda$0$6(ChickenChargeElement.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$0(ChickenChargeElement chickenChargeElement, StageState stageState, View view) {
        float stop = chickenChargeElement.animator1.stop();
        SAMPUIElement sAMPUIElement = chickenChargeElement.notifier;
        int roundToInt = MathKt.roundToInt(stop);
        sAMPUIElement.notifyClick(91, 91, roundToInt + ", " + MathKt.roundToInt(((stop - stageState.getStart()) / stageState.getWidth()) * 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$1(ChickenChargeElement chickenChargeElement, View view) {
        SAMPUIElement.notifyClick$default(chickenChargeElement.notifier, 90, 90, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$5(ChickenChargeElement chickenChargeElement, StageState stageState, HudElementChickenChargeBinding hudElementChickenChargeBinding) {
        float width = chickenChargeElement.binding.player1progressbar.getWidth();
        float start = (stageState.getStart() * width) / 100.0f;
        hudElementChickenChargeBinding.zone.setTranslationX(start);
        hudElementChickenChargeBinding.zone2.setTranslationX(start);
        float width2 = (width * stageState.getWidth()) / 100.0f;
        FrameLayout zone = hudElementChickenChargeBinding.zone;
        Intrinsics.checkNotNullExpressionValue(zone, "zone");
        FrameLayout frameLayout = zone;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            int i = (int) width2;
            layoutParams.width = i;
            frameLayout.setLayoutParams(layoutParams);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$6(ChickenChargeElement chickenChargeElement, View view) {
        SAMPUIElement.notifyClick$default(chickenChargeElement.notifier, 92, 92, null, 4, null);
    }

    private final void firstOpen() {
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        hudElementChickenChargeBinding.ivBgMain.setImageResource(this.mainBg);
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
        this.rightImg.setVisibility(8);
        this.leftImg.setVisibility(0);
        hudElementChickenChargeBinding.ivBgMain.setImageTintList(null);
    }

    public final void setResult(List<HudChickenChargeResult> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        HudChickenChargeResult hudChickenChargeResult = (HudChickenChargeResult) CollectionsKt.getOrNull(data, 0);
        if (hudChickenChargeResult == null) {
            return;
        }
        hudElementChickenChargeBinding.ivBgMain.setImageResource(this.finalBg);
        this.rightImg.setVisibility(0);
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
        hudElementChickenChargeBinding.tvPercentSuccess.setText("Общий шанс успеха - " + hudChickenChargeResult.getChance() + "%");
        if (hudChickenChargeResult.getSuccess() == 1) {
            hudElementChickenChargeBinding.tvResult.setText(this.successText);
            hudElementChickenChargeBinding.tvResult.setTextColor(Color.parseColor("#BFFF64"));
            return;
        }
        hudElementChickenChargeBinding.tvResult.setText(this.failText);
        hudElementChickenChargeBinding.tvResult.setTextColor(Color.parseColor("#E83C3C"));
    }

    public final void setType(int i) {
        this.binding.ivBgLeftChiken.setVisibility(8);
        this.binding.ivBgRightChiken.setVisibility(8);
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        hudElementChickenChargeBinding.player2target.setVisibility(0);
        hudElementChickenChargeBinding.chance2.setVisibility(0);
        hudElementChickenChargeBinding.player2Info.setVisibility(0);
        hudElementChickenChargeBinding.ivBgMain2.setVisibility(8);
        hudElementChickenChargeBinding.ivBgMain.setVisibility(0);
        if (i == 0) {
            HudElementChickenChargeBinding hudElementChickenChargeBinding2 = this.binding;
            hudElementChickenChargeBinding2.ivBgText.setImageResource(R.drawable.hud_element_chicken_charging_bg_text);
            this.mainBg = R.drawable.hud_element_chicken_charging_bg_main;
            this.finalBg = R.drawable.hud_element_chicken_charge_final_bg;
            this.playerGif = R.drawable.hud_chicken_charge;
            this.opponentGif = R.drawable.hud_chicken_charge_game_target2_ic;
            ImageView ivBgLeftChiken = this.binding.ivBgLeftChiken;
            Intrinsics.checkNotNullExpressionValue(ivBgLeftChiken, "ivBgLeftChiken");
            this.leftImg = ivBgLeftChiken;
            ImageView ivBgRightChiken = this.binding.ivBgRightChiken;
            Intrinsics.checkNotNullExpressionValue(ivBgRightChiken, "ivBgRightChiken");
            this.rightImg = ivBgRightChiken;
            hudElementChickenChargeBinding2.tvWaitingYou.setText("ОЖИДАЕТ ВАШЕГО ХОДА");
            hudElementChickenChargeBinding2.player1progressbar.setBackground(Color.parseColor("#AA5A34B1"));
            hudElementChickenChargeBinding2.player2progressbar.setBackground(Color.parseColor("#AA5A34B1"));
            this.successText = "УСПЕХ";
            this.failText = "ПРОВАЛ";
        } else if (i == 1) {
            HudElementChickenChargeBinding hudElementChickenChargeBinding3 = this.binding;
            hudElementChickenChargeBinding3.ivBgText.setImageResource(R.drawable.hud_element_chicken_charging_bg_text_sawmill);
            this.mainBg = R.drawable.hud_element_chicken_charging_bg_main_sawmill;
            this.finalBg = R.drawable.hud_element_chicken_charge_final_bg_sawmill;
            this.playerGif = R.drawable.hud_chicken_charge_saw;
            this.opponentGif = R.drawable.hud_chicken_charge_saw;
            ImageView ivBgLeftSawmill = this.binding.ivBgLeftSawmill;
            Intrinsics.checkNotNullExpressionValue(ivBgLeftSawmill, "ivBgLeftSawmill");
            this.leftImg = ivBgLeftSawmill;
            ImageView ivBgRightSawmill = this.binding.ivBgRightSawmill;
            Intrinsics.checkNotNullExpressionValue(ivBgRightSawmill, "ivBgRightSawmill");
            this.rightImg = ivBgRightSawmill;
            hudElementChickenChargeBinding3.tvWaitingYou.setText("ВАША ОЧЕРЕДЬ РЕЗАТЬ");
            hudElementChickenChargeBinding3.player1progressbar.setBackground(Color.parseColor("#AAA97950"));
            hudElementChickenChargeBinding3.player2progressbar.setBackground(Color.parseColor("#AAA97950"));
            this.successText = "УСПЕШНЫЙ НАДРЕЗ";
            this.failText = "БЕНЗОПИЛА ЗАГЛОХЛА";
        } else if (i == 2) {
            HudElementChickenChargeBinding hudElementChickenChargeBinding4 = this.binding;
            hudElementChickenChargeBinding4.ivBgMain.setVisibility(8);
            hudElementChickenChargeBinding4.ivBgMain2.setVisibility(0);
            hudElementChickenChargeBinding4.player2target.setVisibility(8);
            hudElementChickenChargeBinding4.chance2.setVisibility(8);
            hudElementChickenChargeBinding4.player2Info.setVisibility(8);
            hudElementChickenChargeBinding4.ivBgText.setImageResource(R.drawable.hud_element_chicken_charging_bg_text_hay);
            this.playerGif = R.drawable.hud_chicken_charge_hay;
            this.opponentGif = R.drawable.hud_chicken_charge_hay;
            ImageView ivBgLeftHay = this.binding.ivBgLeftHay;
            Intrinsics.checkNotNullExpressionValue(ivBgLeftHay, "ivBgLeftHay");
            this.leftImg = ivBgLeftHay;
            ImageView ivBgRightHay = this.binding.ivBgRightHay;
            Intrinsics.checkNotNullExpressionValue(ivBgRightHay, "ivBgRightHay");
            this.rightImg = ivBgRightHay;
            hudElementChickenChargeBinding4.tvWaitingYou.setText("");
            hudElementChickenChargeBinding4.player1progressbar.setBackground(Color.parseColor("#B17634"));
            this.successText = "Успешное измельчение";
            this.failText = "Измельчитель заглох";
        }
        setVisibility("1");
    }

    /* compiled from: ChickenCharge.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement$Companion;", "", "<init>", "()V", "CHICKEN", "", "SAWMILL", "HAY", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
            this.binding.getRoot().setVisibility(8);
        }
    }
}

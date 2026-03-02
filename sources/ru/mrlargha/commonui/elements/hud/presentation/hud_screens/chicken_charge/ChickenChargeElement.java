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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementChickenChargeBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: ChickenCharge.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0014\u0010\u0019\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementChickenChargeBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "animator1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/PercentMover;", "animator2", "setVisibility", "", "data", "", "setInfo", "setData", "info", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageState;", "firstOpen", "setResult", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/HudChickenChargeResult;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChickenChargeElement {
    private final PercentMover animator1;
    private final PercentMover animator2;
    private final HudElementChickenChargeBinding binding;
    private final SAMPUIElement notifier;

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
        Glide.with(hudElementChickenChargeBinding.chickenGif.getContext()).load(Integer.valueOf(R.drawable.hud_chicken_charge)).into(hudElementChickenChargeBinding.chickenGif);
        Glide.with(hudElementChickenChargeBinding.chickenGif.getContext()).load(Integer.valueOf(R.drawable.hud_chicken_charge_game_target2_ic)).into(hudElementChickenChargeBinding.chickenGif2);
        StageUserInfo stageUserInfo3 = (StageUserInfo) CollectionsKt.getOrNull(stageState.getInfoUser(), 0);
        if (stageUserInfo3 != null) {
            this.animator1.setCurrentPercent(stageUserInfo3.getCurrentPosition());
            hudElementChickenChargeBinding.player1target.setTranslationX((this.binding.player1progressbar.getWidth() * stageUserInfo3.getCurrentPosition()) / 100);
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
            hudElementChickenChargeBinding.player2target.setTranslationX((this.binding.player1progressbar.getWidth() * stageUserInfo4.getCurrentPosition()) / 100);
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
        float start = ((stop - stageState.getStart()) / stageState.getWidth()) * 100;
        SAMPUIElement sAMPUIElement = chickenChargeElement.notifier;
        int roundToInt = MathKt.roundToInt(stop);
        sAMPUIElement.notifyClick(91, 91, roundToInt + ", " + MathKt.roundToInt(start));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$1(ChickenChargeElement chickenChargeElement, View view) {
        SAMPUIElement.notifyClick$default(chickenChargeElement.notifier, 90, 90, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0$5(ChickenChargeElement chickenChargeElement, StageState stageState, HudElementChickenChargeBinding hudElementChickenChargeBinding) {
        float width = chickenChargeElement.binding.player1progressbar.getWidth();
        float f = 100;
        float start = (stageState.getStart() * width) / f;
        hudElementChickenChargeBinding.zone.setTranslationX(start);
        hudElementChickenChargeBinding.zone2.setTranslationX(start);
        float width2 = (width * stageState.getWidth()) / f;
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
        ImageView ivBg = hudElementChickenChargeBinding.ivBg;
        Intrinsics.checkNotNullExpressionValue(ivBg, "ivBg");
        ivBg.setVisibility(0);
        ImageView ivBgFinal = hudElementChickenChargeBinding.ivBgFinal;
        Intrinsics.checkNotNullExpressionValue(ivBgFinal, "ivBgFinal");
        ivBgFinal.setVisibility(8);
        LinearLayout main = hudElementChickenChargeBinding.main;
        Intrinsics.checkNotNullExpressionValue(main, "main");
        main.setVisibility(0);
        LinearLayout finalContainer = hudElementChickenChargeBinding.finalContainer;
        Intrinsics.checkNotNullExpressionValue(finalContainer, "finalContainer");
        finalContainer.setVisibility(8);
    }

    public final void setResult(List<HudChickenChargeResult> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HudElementChickenChargeBinding hudElementChickenChargeBinding = this.binding;
        HudChickenChargeResult hudChickenChargeResult = (HudChickenChargeResult) CollectionsKt.getOrNull(data, 0);
        if (hudChickenChargeResult == null) {
            return;
        }
        ImageView ivBg = hudElementChickenChargeBinding.ivBg;
        Intrinsics.checkNotNullExpressionValue(ivBg, "ivBg");
        ivBg.setVisibility(8);
        ImageView ivBgFinal = hudElementChickenChargeBinding.ivBgFinal;
        Intrinsics.checkNotNullExpressionValue(ivBgFinal, "ivBgFinal");
        ivBgFinal.setVisibility(0);
        LinearLayout main = hudElementChickenChargeBinding.main;
        Intrinsics.checkNotNullExpressionValue(main, "main");
        main.setVisibility(8);
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
        if (hudChickenChargeResult.isSuccessful()) {
            hudElementChickenChargeBinding.tvResult.setText("УСПЕХ");
            hudElementChickenChargeBinding.tvResult.setTextColor(Color.parseColor("#BFFF64"));
            return;
        }
        hudElementChickenChargeBinding.tvResult.setText("ПРОВАЛ");
        hudElementChickenChargeBinding.tvResult.setTextColor(Color.parseColor("#E83C3C"));
    }

    public final void setInfo(String data) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                Gson create = new GsonBuilder().setLenient().create();
                JsonArray asJsonArray = ((JsonElement) create.fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                Intrinsics.checkNotNull(asJsonArray);
                JsonArray<JsonElement> jsonArray = asJsonArray;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                for (JsonElement jsonElement : jsonArray) {
                    arrayList2.add(create.fromJson(jsonElement, (Class<Object>) StageState.class));
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

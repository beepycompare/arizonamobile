package com.arizonagames.feature.minigames.blueprint;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintLayoutAkBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintLayoutPmBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintLayoutRpgBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintPipeFiveBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintPipeFourBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintPipeOneBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintPipeThreeBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintPipeTwoBinding;
import com.arizonagames.feature.minigames.blueprint.databinding.BlueprintScreenBinding;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: BlueprintScreen.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J&\u0010'\u001a\u00020\u0015*\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J&\u0010+\u001a\u00020\u0015*\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/arizonagames/feature/minigames/blueprint/BlueprintScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "blueprintScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "blueprintBinding", "Lcom/arizonagames/feature/minigames/blueprint/databinding/BlueprintScreenBinding;", "showLastAreaTimer", "Landroid/os/CountDownTimer;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "soundId", "topHalloweenAdapter", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenAdapter;", "startLastAreaTimer", "", "onFinish", "Lkotlin/Function0;", "closeScreen", "showBlueprintScreen", "response", "Lcom/arizonagames/feature/minigames/blueprint/BlueprintResponse;", "showHalloween", "showSnowmen", "rewardsPanelInitialize", "showAkWeapon", "showRpgWeapon", "showPMWeapon", "showPipeOne", "showPipeTwo", "showPipeThree", "showPipeFour", "showPipeFive", "clickOnPipe", "Landroid/view/View;", "touch", "onClick", "clickOnWeapon", "invisibleOtherWeaponPages", "onBackendMessageHandled", "data", "", "subId", "setSelectedItem", "setVisibility", "visible", "", "Spawner", "blueprint"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlueprintScreen extends SAMPUIElement {
    private final BlueprintScreenBinding blueprintBinding;
    private final ConstraintLayout blueprintScreen;
    private CountDownTimer showLastAreaTimer;
    private final int soundId;
    private final SoundPool soundPool;
    private final HalloweenAdapter topHalloweenAdapter;

    /* compiled from: BlueprintScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WeaponType.values().length];
            try {
                iArr[WeaponType.RPG_WEAPON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WeaponType.AK_WEAPON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WeaponType.PM_WEAPON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WeaponType.RIFLE_WEAPON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WeaponType.SNIPE_WEAPON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WeaponType.PIPE_ONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WeaponType.PIPE_TWO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[WeaponType.PIPE_THREE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[WeaponType.PIPE_FOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[WeaponType.PIPE_FIVE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[WeaponType.HALLOWEEN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[WeaponType.SNOWMEN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueprintScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.blueprint_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.blueprintScreen = constraintLayout;
        BlueprintScreenBinding bind = BlueprintScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.blueprintBinding = bind;
        SoundPool build = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).build();
        this.soundPool = build;
        this.soundId = build.load(targetActivity, R.raw.road_pipe_click, 1);
        this.topHalloweenAdapter = new HalloweenAdapter(new Function1() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlueprintScreen.topHalloweenAdapter$lambda$0(BlueprintScreen.this, ((Integer) obj).intValue());
            }
        }, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlueprintScreen.topHalloweenAdapter$lambda$1(BlueprintScreen.this);
            }
        });
        addViewToConstraintLayout(constraintLayout, -1, -1);
        if (UtilsKt.isArizonaType()) {
            bind.imgMoney.setImageResource(ru.mrlargha.commonui.R.drawable.ic_dollar);
        } else {
            bind.imgMoney.setImageResource(ru.mrlargha.commonui.R.drawable.blueprint_ic_rub);
        }
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlueprintScreen.lambda$0$0(BlueprintScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit topHalloweenAdapter$lambda$0(BlueprintScreen blueprintScreen, int i) {
        blueprintScreen.soundPool.play(blueprintScreen.soundId, 1.0f, 1.0f, 0, 0, 1.0f);
        SAMPUIElement.notifyClick$default(blueprintScreen, 2, i, null, 4, null);
        Log.d("blueprint", "item id: " + i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit topHalloweenAdapter$lambda$1(final BlueprintScreen blueprintScreen) {
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BlueprintScreen.topHalloweenAdapter$lambda$1$0(BlueprintScreen.this);
                return unit;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit topHalloweenAdapter$lambda$1$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(BlueprintScreen blueprintScreen, View view) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 0, -1, null, 4, null);
        blueprintScreen.closeScreen();
    }

    private final void startLastAreaTimer(final Function0<Unit> function0) {
        CountDownTimer countDownTimer = this.showLastAreaTimer;
        if (countDownTimer == null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.showLastAreaTimer = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$startLastAreaTimer$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1000L, 500L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                function0.invoke();
            }
        };
        this.showLastAreaTimer = countDownTimer2;
        Intrinsics.checkNotNull(countDownTimer2);
        countDownTimer2.start();
    }

    private final void closeScreen() {
        getNotifier().setUIElementVisible(UIElementID.BLUEPRINT.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    private final void showBlueprintScreen(BlueprintResponse blueprintResponse) {
        BlueprintScreenBinding blueprintScreenBinding = this.blueprintBinding;
        invisibleOtherWeaponPages();
        rewardsPanelInitialize(blueprintResponse);
        blueprintScreenBinding.weaponTitle.setText(blueprintResponse.getTitle());
        blueprintScreenBinding.getRoot().setBackgroundResource(R.drawable.blueprint_bg);
        switch (WhenMappings.$EnumSwitchMapping$0[WeaponType.Companion.fromWeaponId(blueprintResponse.getWeaponId()).ordinal()]) {
            case 1:
                showRpgWeapon();
                return;
            case 2:
                showAkWeapon();
                return;
            case 3:
                showPMWeapon();
                return;
            case 4:
            case 5:
                return;
            case 6:
                showPipeOne();
                return;
            case 7:
                showPipeTwo();
                return;
            case 8:
                showPipeThree();
                return;
            case 9:
                showPipeFour();
                return;
            case 10:
                showPipeFive();
                return;
            case 11:
                showHalloween();
                return;
            case 12:
                showSnowmen();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void showHalloween() {
        BlueprintScreenBinding blueprintScreenBinding = this.blueprintBinding;
        blueprintScreenBinding.getRoot().setBackgroundResource(R.drawable.blueprint_halloween_bg);
        blueprintScreenBinding.halloween.getRoot().setVisibility(0);
        blueprintScreenBinding.halloween.topRv.setAdapter(this.topHalloweenAdapter);
        this.topHalloweenAdapter.setItemList(HalloweeenKt.getHalloweenList());
        this.topHalloweenAdapter.addItems(((HalloweenGameVariation) CollectionsKt.random(HalloweeenKt.getGamesVariations(), Random.Default)).getList());
    }

    private final void showSnowmen() {
        BlueprintScreenBinding blueprintScreenBinding = this.blueprintBinding;
        blueprintScreenBinding.getRoot().setBackgroundResource(R.drawable.blueprint_snowmen_bg);
        LinearLayout root = blueprintScreenBinding.halloween.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        blueprintScreenBinding.halloween.topRv.setAdapter(this.topHalloweenAdapter);
        this.topHalloweenAdapter.setItemList(SnowmenKt.getSnowmenList());
        this.topHalloweenAdapter.addItems(((HalloweenGameVariation) CollectionsKt.random(SnowmenKt.getSnowmenGamesVariations(), Random.Default)).getList());
    }

    private final void rewardsPanelInitialize(BlueprintResponse blueprintResponse) {
        BlueprintScreenBinding blueprintScreenBinding = this.blueprintBinding;
        blueprintScreenBinding.moneyText.setText(String.valueOf(blueprintResponse.getMoney()));
        blueprintScreenBinding.experienceText.setText(blueprintResponse.getExperience() + " опыта");
        blueprintScreenBinding.blueprintsText.setText(blueprintResponse.getDrafts() + " чертежей");
        boolean z = true;
        boolean z2 = blueprintResponse.getMoney() == 0;
        boolean z3 = blueprintResponse.getExperience() == 0;
        boolean z4 = blueprintResponse.getDrafts() == 0;
        LinearLayout moneyContainer = blueprintScreenBinding.moneyContainer;
        Intrinsics.checkNotNullExpressionValue(moneyContainer, "moneyContainer");
        moneyContainer.setVisibility(z2 ? 8 : 0);
        LinearLayout containerExperience = blueprintScreenBinding.containerExperience;
        Intrinsics.checkNotNullExpressionValue(containerExperience, "containerExperience");
        containerExperience.setVisibility(z3 ? 8 : 0);
        LinearLayout containerDrawing = blueprintScreenBinding.containerDrawing;
        Intrinsics.checkNotNullExpressionValue(containerDrawing, "containerDrawing");
        containerDrawing.setVisibility(z4 ? 8 : 0);
        LinearLayout rewardsPanelContainer = blueprintScreenBinding.rewardsPanelContainer;
        Intrinsics.checkNotNullExpressionValue(rewardsPanelContainer, "rewardsPanelContainer");
        LinearLayout linearLayout = rewardsPanelContainer;
        if (!z2 || !z3 || !z4) {
            z = false;
        }
        linearLayout.setVisibility(z ? 8 : 0);
    }

    private final void showAkWeapon() {
        final BlueprintLayoutAkBinding blueprintLayoutAkBinding = this.blueprintBinding.akContainer;
        RelativeLayout akTouchAreaStage1 = blueprintLayoutAkBinding.akTouchAreaStage1;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage1, "akTouchAreaStage1");
        clickOnWeapon(akTouchAreaStage1, blueprintLayoutAkBinding.akTouchAreaStage2, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$0;
                showAkWeapon$lambda$0$0 = BlueprintScreen.showAkWeapon$lambda$0$0(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$0$0;
            }
        });
        RelativeLayout akTouchAreaStage2 = blueprintLayoutAkBinding.akTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage2, "akTouchAreaStage2");
        clickOnWeapon(akTouchAreaStage2, blueprintLayoutAkBinding.akTouchAreaStage3, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$1;
                showAkWeapon$lambda$0$1 = BlueprintScreen.showAkWeapon$lambda$0$1(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$0$1;
            }
        });
        RelativeLayout akTouchAreaStage3 = blueprintLayoutAkBinding.akTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage3, "akTouchAreaStage3");
        clickOnWeapon(akTouchAreaStage3, blueprintLayoutAkBinding.akTouchAreaStage4, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$2;
                showAkWeapon$lambda$0$2 = BlueprintScreen.showAkWeapon$lambda$0$2(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$0$2;
            }
        });
        RelativeLayout akTouchAreaStage4 = blueprintLayoutAkBinding.akTouchAreaStage4;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage4, "akTouchAreaStage4");
        clickOnWeapon(akTouchAreaStage4, blueprintLayoutAkBinding.akTouchAreaStage5, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$3;
                showAkWeapon$lambda$0$3 = BlueprintScreen.showAkWeapon$lambda$0$3(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$0$3;
            }
        });
        RelativeLayout akTouchAreaStage5 = blueprintLayoutAkBinding.akTouchAreaStage5;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage5, "akTouchAreaStage5");
        clickOnWeapon$default(this, akTouchAreaStage5, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$4;
                showAkWeapon$lambda$0$4 = BlueprintScreen.showAkWeapon$lambda$0$4(BlueprintLayoutAkBinding.this, this);
                return showAkWeapon$lambda$0$4;
            }
        }, 1, null);
        blueprintLayoutAkBinding.getRoot().setVisibility(0);
        blueprintLayoutAkBinding.akTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$0(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$1(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$2(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$3(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$4(BlueprintLayoutAkBinding blueprintLayoutAkBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_5);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$0$4$0;
                showAkWeapon$lambda$0$4$0 = BlueprintScreen.showAkWeapon$lambda$0$4$0(BlueprintScreen.this);
                return showAkWeapon$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showRpgWeapon() {
        final BlueprintLayoutRpgBinding blueprintLayoutRpgBinding = this.blueprintBinding.rpgContainer;
        RelativeLayout rpgTouchAreaStage1 = blueprintLayoutRpgBinding.rpgTouchAreaStage1;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage1, "rpgTouchAreaStage1");
        clickOnWeapon(rpgTouchAreaStage1, blueprintLayoutRpgBinding.rpgTouchAreaStage2, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$0$0;
                showRpgWeapon$lambda$0$0 = BlueprintScreen.showRpgWeapon$lambda$0$0(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$0$0;
            }
        });
        RelativeLayout rpgTouchAreaStage2 = blueprintLayoutRpgBinding.rpgTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage2, "rpgTouchAreaStage2");
        clickOnWeapon(rpgTouchAreaStage2, blueprintLayoutRpgBinding.rpgTouchAreaStage3, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$0$1;
                showRpgWeapon$lambda$0$1 = BlueprintScreen.showRpgWeapon$lambda$0$1(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$0$1;
            }
        });
        RelativeLayout rpgTouchAreaStage3 = blueprintLayoutRpgBinding.rpgTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage3, "rpgTouchAreaStage3");
        clickOnWeapon(rpgTouchAreaStage3, blueprintLayoutRpgBinding.rpgTouchAreaStage4, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$0$2;
                showRpgWeapon$lambda$0$2 = BlueprintScreen.showRpgWeapon$lambda$0$2(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$0$2;
            }
        });
        RelativeLayout rpgTouchAreaStage4 = blueprintLayoutRpgBinding.rpgTouchAreaStage4;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage4, "rpgTouchAreaStage4");
        clickOnWeapon$default(this, rpgTouchAreaStage4, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$0$3;
                showRpgWeapon$lambda$0$3 = BlueprintScreen.showRpgWeapon$lambda$0$3(BlueprintLayoutRpgBinding.this, this);
                return showRpgWeapon$lambda$0$3;
            }
        }, 1, null);
        blueprintLayoutRpgBinding.getRoot().setVisibility(0);
        blueprintLayoutRpgBinding.rpgTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$0$0(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$0$1(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$0$2(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$0$3(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_4);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$0$3$0;
                showRpgWeapon$lambda$0$3$0 = BlueprintScreen.showRpgWeapon$lambda$0$3$0(BlueprintScreen.this);
                return showRpgWeapon$lambda$0$3$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$0$3$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPMWeapon() {
        final BlueprintLayoutPmBinding blueprintLayoutPmBinding = this.blueprintBinding.pmContainer;
        RelativeLayout pmTouchAreaStage1 = blueprintLayoutPmBinding.pmTouchAreaStage1;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage1, "pmTouchAreaStage1");
        clickOnWeapon(pmTouchAreaStage1, blueprintLayoutPmBinding.pmTouchAreaStage2, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$0$0;
                showPMWeapon$lambda$0$0 = BlueprintScreen.showPMWeapon$lambda$0$0(BlueprintLayoutPmBinding.this);
                return showPMWeapon$lambda$0$0;
            }
        });
        RelativeLayout pmTouchAreaStage2 = blueprintLayoutPmBinding.pmTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage2, "pmTouchAreaStage2");
        clickOnWeapon(pmTouchAreaStage2, blueprintLayoutPmBinding.pmTouchAreaStage3, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$0$1;
                showPMWeapon$lambda$0$1 = BlueprintScreen.showPMWeapon$lambda$0$1(BlueprintLayoutPmBinding.this);
                return showPMWeapon$lambda$0$1;
            }
        });
        RelativeLayout pmTouchAreaStage3 = blueprintLayoutPmBinding.pmTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage3, "pmTouchAreaStage3");
        clickOnWeapon$default(this, pmTouchAreaStage3, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$0$2;
                showPMWeapon$lambda$0$2 = BlueprintScreen.showPMWeapon$lambda$0$2(BlueprintLayoutPmBinding.this, this);
                return showPMWeapon$lambda$0$2;
            }
        }, 1, null);
        blueprintLayoutPmBinding.getRoot().setVisibility(0);
        blueprintLayoutPmBinding.pmTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$0$0(BlueprintLayoutPmBinding blueprintLayoutPmBinding) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$0$1(BlueprintLayoutPmBinding blueprintLayoutPmBinding) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$0$2(BlueprintLayoutPmBinding blueprintLayoutPmBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_3);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$0$2$0;
                showPMWeapon$lambda$0$2$0 = BlueprintScreen.showPMWeapon$lambda$0$2$0(BlueprintScreen.this);
                return showPMWeapon$lambda$0$2$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$0$2$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeOne() {
        final BlueprintPipeOneBinding blueprintPipeOneBinding = this.blueprintBinding.pipeOne;
        FrameLayout touchOne = blueprintPipeOneBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeOneBinding.touchTwo, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$0;
                showPipeOne$lambda$0$0 = BlueprintScreen.showPipeOne$lambda$0$0(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$0$0;
            }
        });
        FrameLayout touchTwo = blueprintPipeOneBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeOneBinding.touchThree, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$1;
                showPipeOne$lambda$0$1 = BlueprintScreen.showPipeOne$lambda$0$1(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$0$1;
            }
        });
        FrameLayout touchThree = blueprintPipeOneBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeOneBinding.touchFour, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$2;
                showPipeOne$lambda$0$2 = BlueprintScreen.showPipeOne$lambda$0$2(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$0$2;
            }
        });
        FrameLayout touchFour = blueprintPipeOneBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeOneBinding.touchFive, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$3;
                showPipeOne$lambda$0$3 = BlueprintScreen.showPipeOne$lambda$0$3(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$0$3;
            }
        });
        FrameLayout touchFive = blueprintPipeOneBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$4;
                showPipeOne$lambda$0$4 = BlueprintScreen.showPipeOne$lambda$0$4(BlueprintPipeOneBinding.this, this);
                return showPipeOne$lambda$0$4;
            }
        }, 1, null);
        ConstraintLayout root = blueprintPipeOneBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout touchOne2 = blueprintPipeOneBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne2, "touchOne");
        touchOne2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$0(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$1(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$2(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$3(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$4(BlueprintPipeOneBinding blueprintPipeOneBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$0$4$0;
                showPipeOne$lambda$0$4$0 = BlueprintScreen.showPipeOne$lambda$0$4$0(BlueprintScreen.this);
                return showPipeOne$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeTwo() {
        final BlueprintPipeTwoBinding blueprintPipeTwoBinding = this.blueprintBinding.pipeTwo;
        FrameLayout touchOne = blueprintPipeTwoBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeTwoBinding.touchTwo, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$0;
                showPipeTwo$lambda$0$0 = BlueprintScreen.showPipeTwo$lambda$0$0(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$0$0;
            }
        });
        FrameLayout touchTwo = blueprintPipeTwoBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeTwoBinding.touchThree, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$1;
                showPipeTwo$lambda$0$1 = BlueprintScreen.showPipeTwo$lambda$0$1(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$0$1;
            }
        });
        FrameLayout touchThree = blueprintPipeTwoBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeTwoBinding.touchFour, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$2;
                showPipeTwo$lambda$0$2 = BlueprintScreen.showPipeTwo$lambda$0$2(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$0$2;
            }
        });
        FrameLayout touchFour = blueprintPipeTwoBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeTwoBinding.touchFive, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$3;
                showPipeTwo$lambda$0$3 = BlueprintScreen.showPipeTwo$lambda$0$3(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$0$3;
            }
        });
        FrameLayout touchFive = blueprintPipeTwoBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$4;
                showPipeTwo$lambda$0$4 = BlueprintScreen.showPipeTwo$lambda$0$4(BlueprintPipeTwoBinding.this, this);
                return showPipeTwo$lambda$0$4;
            }
        }, 1, null);
        ConstraintLayout root = blueprintPipeTwoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout touchOne2 = blueprintPipeTwoBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne2, "touchOne");
        touchOne2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$0(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$1(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$2(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$3(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$4(BlueprintPipeTwoBinding blueprintPipeTwoBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$0$4$0;
                showPipeTwo$lambda$0$4$0 = BlueprintScreen.showPipeTwo$lambda$0$4$0(BlueprintScreen.this);
                return showPipeTwo$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeThree() {
        final BlueprintPipeThreeBinding blueprintPipeThreeBinding = this.blueprintBinding.pipeThree;
        FrameLayout touchOne = blueprintPipeThreeBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeThreeBinding.touchTwo, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$0;
                showPipeThree$lambda$0$0 = BlueprintScreen.showPipeThree$lambda$0$0(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$0$0;
            }
        });
        FrameLayout touchTwo = blueprintPipeThreeBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeThreeBinding.touchThree, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$1;
                showPipeThree$lambda$0$1 = BlueprintScreen.showPipeThree$lambda$0$1(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$0$1;
            }
        });
        FrameLayout touchThree = blueprintPipeThreeBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeThreeBinding.touchFour, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$2;
                showPipeThree$lambda$0$2 = BlueprintScreen.showPipeThree$lambda$0$2(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$0$2;
            }
        });
        FrameLayout touchFour = blueprintPipeThreeBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeThreeBinding.touchFive, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$3;
                showPipeThree$lambda$0$3 = BlueprintScreen.showPipeThree$lambda$0$3(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$0$3;
            }
        });
        FrameLayout touchFive = blueprintPipeThreeBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$4;
                showPipeThree$lambda$0$4 = BlueprintScreen.showPipeThree$lambda$0$4(BlueprintPipeThreeBinding.this, this);
                return showPipeThree$lambda$0$4;
            }
        }, 1, null);
        ConstraintLayout root = blueprintPipeThreeBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout touchOne2 = blueprintPipeThreeBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne2, "touchOne");
        touchOne2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$0(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$1(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$2(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$3(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$4(BlueprintPipeThreeBinding blueprintPipeThreeBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$0$4$0;
                showPipeThree$lambda$0$4$0 = BlueprintScreen.showPipeThree$lambda$0$4$0(BlueprintScreen.this);
                return showPipeThree$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeFour() {
        final BlueprintPipeFourBinding blueprintPipeFourBinding = this.blueprintBinding.pipeFour;
        FrameLayout touchOne = blueprintPipeFourBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeFourBinding.touchTwo, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$0;
                showPipeFour$lambda$0$0 = BlueprintScreen.showPipeFour$lambda$0$0(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$0$0;
            }
        });
        FrameLayout touchTwo = blueprintPipeFourBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeFourBinding.touchThree, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$1;
                showPipeFour$lambda$0$1 = BlueprintScreen.showPipeFour$lambda$0$1(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$0$1;
            }
        });
        FrameLayout touchThree = blueprintPipeFourBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeFourBinding.touchFour, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$2;
                showPipeFour$lambda$0$2 = BlueprintScreen.showPipeFour$lambda$0$2(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$0$2;
            }
        });
        FrameLayout touchFour = blueprintPipeFourBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeFourBinding.touchFive, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$3;
                showPipeFour$lambda$0$3 = BlueprintScreen.showPipeFour$lambda$0$3(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$0$3;
            }
        });
        FrameLayout touchFive = blueprintPipeFourBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$4;
                showPipeFour$lambda$0$4 = BlueprintScreen.showPipeFour$lambda$0$4(BlueprintPipeFourBinding.this, this);
                return showPipeFour$lambda$0$4;
            }
        }, 1, null);
        ConstraintLayout root = blueprintPipeFourBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout touchOne2 = blueprintPipeFourBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne2, "touchOne");
        touchOne2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$0(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$1(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$2(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$3(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$4(BlueprintPipeFourBinding blueprintPipeFourBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$0$4$0;
                showPipeFour$lambda$0$4$0 = BlueprintScreen.showPipeFour$lambda$0$4$0(BlueprintScreen.this);
                return showPipeFour$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeFive() {
        final BlueprintPipeFiveBinding blueprintPipeFiveBinding = this.blueprintBinding.pipeFive;
        FrameLayout touchOne = blueprintPipeFiveBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeFiveBinding.touchTwo, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$0;
                showPipeFive$lambda$0$0 = BlueprintScreen.showPipeFive$lambda$0$0(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$0$0;
            }
        });
        FrameLayout touchTwo = blueprintPipeFiveBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeFiveBinding.touchThree, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$1;
                showPipeFive$lambda$0$1 = BlueprintScreen.showPipeFive$lambda$0$1(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$0$1;
            }
        });
        FrameLayout touchThree = blueprintPipeFiveBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeFiveBinding.touchFour, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$2;
                showPipeFive$lambda$0$2 = BlueprintScreen.showPipeFive$lambda$0$2(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$0$2;
            }
        });
        FrameLayout touchFour = blueprintPipeFiveBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeFiveBinding.touchFive, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$3;
                showPipeFive$lambda$0$3 = BlueprintScreen.showPipeFive$lambda$0$3(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$0$3;
            }
        });
        FrameLayout touchFive = blueprintPipeFiveBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$4;
                showPipeFive$lambda$0$4 = BlueprintScreen.showPipeFive$lambda$0$4(BlueprintPipeFiveBinding.this, this);
                return showPipeFive$lambda$0$4;
            }
        }, 1, null);
        ConstraintLayout root = blueprintPipeFiveBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout touchOne2 = blueprintPipeFiveBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne2, "touchOne");
        touchOne2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$0(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$1(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$2(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$3(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$4(BlueprintPipeFiveBinding blueprintPipeFiveBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$0$4$0;
                showPipeFive$lambda$0$4$0 = BlueprintScreen.showPipeFive$lambda$0$4$0(BlueprintScreen.this);
                return showPipeFive$lambda$0$4$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$0$4$0(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    static /* synthetic */ void clickOnPipe$default(BlueprintScreen blueprintScreen, View view, View view2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            view2 = null;
        }
        blueprintScreen.clickOnPipe(view, view2, function0);
    }

    private final void clickOnPipe(View view, View view2, final Function0<Unit> function0) {
        final int load = this.soundPool.load(view.getContext(), R.raw.road_pipe_click, 1);
        clickOnWeapon(view, view2, new Function0() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlueprintScreen.clickOnPipe$lambda$0(Function0.this, this, load);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit clickOnPipe$lambda$0(Function0 function0, BlueprintScreen blueprintScreen, int i) {
        function0.invoke();
        blueprintScreen.soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void clickOnWeapon$default(BlueprintScreen blueprintScreen, View view, View view2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            view2 = null;
        }
        blueprintScreen.clickOnWeapon(view, view2, function0);
    }

    private final void clickOnWeapon(View view, final View view2, final Function0<Unit> function0) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.blueprint.BlueprintScreen$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BlueprintScreen.clickOnWeapon$lambda$0(view2, function0, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void clickOnWeapon$lambda$0(View view, Function0 function0, View view2) {
        Intrinsics.checkNotNull(view2);
        view2.setVisibility(8);
        if (view != null) {
            view.setVisibility(0);
        }
        function0.invoke();
    }

    private final void invisibleOtherWeaponPages() {
        BlueprintScreenBinding blueprintScreenBinding = this.blueprintBinding;
        blueprintScreenBinding.rpgContainer.getRoot().setVisibility(8);
        blueprintScreenBinding.akContainer.getRoot().setVisibility(8);
        blueprintScreenBinding.pmContainer.getRoot().setVisibility(8);
        blueprintScreenBinding.rifleContainer.getRoot().setVisibility(8);
        blueprintScreenBinding.snipeContainer.getRoot().setVisibility(8);
        blueprintScreenBinding.pipeOne.getRoot().setVisibility(8);
        blueprintScreenBinding.pipeTwo.getRoot().setVisibility(8);
        blueprintScreenBinding.pipeThree.getRoot().setVisibility(8);
        blueprintScreenBinding.pipeFour.getRoot().setVisibility(8);
        blueprintScreenBinding.pipeFive.getRoot().setVisibility(8);
        blueprintScreenBinding.halloween.getRoot().setVisibility(8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            showBlueprintScreen((BlueprintResponse) MapperKt.toModel(data, BlueprintResponse.class));
        } else if (i != 2) {
        } else {
            setSelectedItem(data);
        }
    }

    private final void setSelectedItem(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.removeSuffix(StringsKt.removePrefix(str, (CharSequence) "["), (CharSequence) "]"), new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) str2).toString())));
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<HalloweenObject> itemList = this.topHalloweenAdapter.getItemList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(itemList, 10));
        for (HalloweenObject halloweenObject : itemList) {
            arrayList2.add(HalloweenObject.copy$default(halloweenObject, 0, 0, 0, set.contains(Integer.valueOf(halloweenObject.getId())), 7, null));
        }
        this.topHalloweenAdapter.setItemList(arrayList2);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            super.setVisibility(false);
        } else {
            super.setVisibility(true);
        }
    }

    /* compiled from: BlueprintScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/minigames/blueprint/BlueprintScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "blueprint"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.BLUEPRINT);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BlueprintScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

package ru.mrlargha.commonui.elements.blueprint;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.BlueprintLayoutAkBinding;
import ru.mrlargha.commonui.databinding.BlueprintLayoutPmBinding;
import ru.mrlargha.commonui.databinding.BlueprintLayoutRpgBinding;
import ru.mrlargha.commonui.databinding.BlueprintPipeFiveBinding;
import ru.mrlargha.commonui.databinding.BlueprintPipeFourBinding;
import ru.mrlargha.commonui.databinding.BlueprintPipeOneBinding;
import ru.mrlargha.commonui.databinding.BlueprintPipeThreeBinding;
import ru.mrlargha.commonui.databinding.BlueprintPipeTwoBinding;
import ru.mrlargha.commonui.databinding.BlueprintScreenBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: BlueprintScreen.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002J&\u0010&\u001a\u00020\u0016*\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J&\u0010*\u001a\u00020\u0016*\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/blueprint/BlueprintScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "blueprintScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "blueprintBinding", "Lru/mrlargha/commonui/databinding/BlueprintScreenBinding;", "showLastAreaTimer", "Landroid/os/CountDownTimer;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "soundPool", "Landroid/media/SoundPool;", "startLastAreaTimer", "", "onFinish", "Lkotlin/Function0;", "closeScreen", "showBlueprintScreen", "response", "Lru/mrlargha/commonui/elements/blueprint/BlueprintResponse;", "rewardsPanelInitialize", "showAkWeapon", "showRpgWeapon", "showPMWeapon", "showPipeOne", "showPipeTwo", "showPipeThree", "showPipeFour", "showPipeFive", "clickOnPipe", "Landroid/view/View;", "touch", "onClick", "clickOnWeapon", "invisibleOtherWeaponPages", "onBackendMessage", "data", "", "subId", "setVisibility", "visible", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlueprintScreen extends SAMPUIElement {
    private final BlueprintScreenBinding blueprintBinding;
    private final ConstraintLayout blueprintScreen;
    private final boolean isArizonaType;
    private final SharedPreferences sharedPref;
    private CountDownTimer showLastAreaTimer;
    private final SoundPool soundPool;

    /* compiled from: BlueprintScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.soundPool = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).build();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        if (z) {
            bind.imgMoney.setImageResource(R.drawable.ic_dollar);
        } else {
            bind.imgMoney.setImageResource(R.drawable.blueprint_ic_rub);
        }
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlueprintScreen.lambda$1$lambda$0(BlueprintScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$1$lambda$0(BlueprintScreen blueprintScreen, View view) {
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
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$startLastAreaTimer$1
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
            default:
                throw new NoWhenBranchMatchedException();
        }
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
        clickOnWeapon(akTouchAreaStage1, blueprintLayoutAkBinding.akTouchAreaStage2, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$4;
                showAkWeapon$lambda$10$lambda$4 = BlueprintScreen.showAkWeapon$lambda$10$lambda$4(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$10$lambda$4;
            }
        });
        RelativeLayout akTouchAreaStage2 = blueprintLayoutAkBinding.akTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage2, "akTouchAreaStage2");
        clickOnWeapon(akTouchAreaStage2, blueprintLayoutAkBinding.akTouchAreaStage3, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$5;
                showAkWeapon$lambda$10$lambda$5 = BlueprintScreen.showAkWeapon$lambda$10$lambda$5(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$10$lambda$5;
            }
        });
        RelativeLayout akTouchAreaStage3 = blueprintLayoutAkBinding.akTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage3, "akTouchAreaStage3");
        clickOnWeapon(akTouchAreaStage3, blueprintLayoutAkBinding.akTouchAreaStage4, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$6;
                showAkWeapon$lambda$10$lambda$6 = BlueprintScreen.showAkWeapon$lambda$10$lambda$6(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$10$lambda$6;
            }
        });
        RelativeLayout akTouchAreaStage4 = blueprintLayoutAkBinding.akTouchAreaStage4;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage4, "akTouchAreaStage4");
        clickOnWeapon(akTouchAreaStage4, blueprintLayoutAkBinding.akTouchAreaStage5, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$7;
                showAkWeapon$lambda$10$lambda$7 = BlueprintScreen.showAkWeapon$lambda$10$lambda$7(BlueprintLayoutAkBinding.this);
                return showAkWeapon$lambda$10$lambda$7;
            }
        });
        RelativeLayout akTouchAreaStage5 = blueprintLayoutAkBinding.akTouchAreaStage5;
        Intrinsics.checkNotNullExpressionValue(akTouchAreaStage5, "akTouchAreaStage5");
        clickOnWeapon$default(this, akTouchAreaStage5, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$9;
                showAkWeapon$lambda$10$lambda$9 = BlueprintScreen.showAkWeapon$lambda$10$lambda$9(BlueprintLayoutAkBinding.this, this);
                return showAkWeapon$lambda$10$lambda$9;
            }
        }, 1, null);
        blueprintLayoutAkBinding.getRoot().setVisibility(0);
        blueprintLayoutAkBinding.akTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$4(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$5(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$6(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$7(BlueprintLayoutAkBinding blueprintLayoutAkBinding) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$9(BlueprintLayoutAkBinding blueprintLayoutAkBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutAkBinding.akImage.setImageResource(R.drawable.ak_stage_5);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showAkWeapon$lambda$10$lambda$9$lambda$8;
                showAkWeapon$lambda$10$lambda$9$lambda$8 = BlueprintScreen.showAkWeapon$lambda$10$lambda$9$lambda$8(BlueprintScreen.this);
                return showAkWeapon$lambda$10$lambda$9$lambda$8;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAkWeapon$lambda$10$lambda$9$lambda$8(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showRpgWeapon() {
        final BlueprintLayoutRpgBinding blueprintLayoutRpgBinding = this.blueprintBinding.rpgContainer;
        RelativeLayout rpgTouchAreaStage1 = blueprintLayoutRpgBinding.rpgTouchAreaStage1;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage1, "rpgTouchAreaStage1");
        clickOnWeapon(rpgTouchAreaStage1, blueprintLayoutRpgBinding.rpgTouchAreaStage2, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$16$lambda$11;
                showRpgWeapon$lambda$16$lambda$11 = BlueprintScreen.showRpgWeapon$lambda$16$lambda$11(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$16$lambda$11;
            }
        });
        RelativeLayout rpgTouchAreaStage2 = blueprintLayoutRpgBinding.rpgTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage2, "rpgTouchAreaStage2");
        clickOnWeapon(rpgTouchAreaStage2, blueprintLayoutRpgBinding.rpgTouchAreaStage3, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$16$lambda$12;
                showRpgWeapon$lambda$16$lambda$12 = BlueprintScreen.showRpgWeapon$lambda$16$lambda$12(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$16$lambda$12;
            }
        });
        RelativeLayout rpgTouchAreaStage3 = blueprintLayoutRpgBinding.rpgTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage3, "rpgTouchAreaStage3");
        clickOnWeapon(rpgTouchAreaStage3, blueprintLayoutRpgBinding.rpgTouchAreaStage4, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$16$lambda$13;
                showRpgWeapon$lambda$16$lambda$13 = BlueprintScreen.showRpgWeapon$lambda$16$lambda$13(BlueprintLayoutRpgBinding.this);
                return showRpgWeapon$lambda$16$lambda$13;
            }
        });
        RelativeLayout rpgTouchAreaStage4 = blueprintLayoutRpgBinding.rpgTouchAreaStage4;
        Intrinsics.checkNotNullExpressionValue(rpgTouchAreaStage4, "rpgTouchAreaStage4");
        clickOnWeapon$default(this, rpgTouchAreaStage4, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$16$lambda$15;
                showRpgWeapon$lambda$16$lambda$15 = BlueprintScreen.showRpgWeapon$lambda$16$lambda$15(BlueprintLayoutRpgBinding.this, this);
                return showRpgWeapon$lambda$16$lambda$15;
            }
        }, 1, null);
        blueprintLayoutRpgBinding.getRoot().setVisibility(0);
        blueprintLayoutRpgBinding.rpgTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$16$lambda$11(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$16$lambda$12(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$16$lambda$13(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$16$lambda$15(BlueprintLayoutRpgBinding blueprintLayoutRpgBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutRpgBinding.rpgImage.setImageResource(R.drawable.rpg_stage_4);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showRpgWeapon$lambda$16$lambda$15$lambda$14;
                showRpgWeapon$lambda$16$lambda$15$lambda$14 = BlueprintScreen.showRpgWeapon$lambda$16$lambda$15$lambda$14(BlueprintScreen.this);
                return showRpgWeapon$lambda$16$lambda$15$lambda$14;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRpgWeapon$lambda$16$lambda$15$lambda$14(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPMWeapon() {
        final BlueprintLayoutPmBinding blueprintLayoutPmBinding = this.blueprintBinding.pmContainer;
        RelativeLayout pmTouchAreaStage1 = blueprintLayoutPmBinding.pmTouchAreaStage1;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage1, "pmTouchAreaStage1");
        clickOnWeapon(pmTouchAreaStage1, blueprintLayoutPmBinding.pmTouchAreaStage2, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$21$lambda$17;
                showPMWeapon$lambda$21$lambda$17 = BlueprintScreen.showPMWeapon$lambda$21$lambda$17(BlueprintLayoutPmBinding.this);
                return showPMWeapon$lambda$21$lambda$17;
            }
        });
        RelativeLayout pmTouchAreaStage2 = blueprintLayoutPmBinding.pmTouchAreaStage2;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage2, "pmTouchAreaStage2");
        clickOnWeapon(pmTouchAreaStage2, blueprintLayoutPmBinding.pmTouchAreaStage3, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$21$lambda$18;
                showPMWeapon$lambda$21$lambda$18 = BlueprintScreen.showPMWeapon$lambda$21$lambda$18(BlueprintLayoutPmBinding.this);
                return showPMWeapon$lambda$21$lambda$18;
            }
        });
        RelativeLayout pmTouchAreaStage3 = blueprintLayoutPmBinding.pmTouchAreaStage3;
        Intrinsics.checkNotNullExpressionValue(pmTouchAreaStage3, "pmTouchAreaStage3");
        clickOnWeapon$default(this, pmTouchAreaStage3, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$21$lambda$20;
                showPMWeapon$lambda$21$lambda$20 = BlueprintScreen.showPMWeapon$lambda$21$lambda$20(BlueprintLayoutPmBinding.this, this);
                return showPMWeapon$lambda$21$lambda$20;
            }
        }, 1, null);
        blueprintLayoutPmBinding.getRoot().setVisibility(0);
        blueprintLayoutPmBinding.pmTouchAreaStage1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$21$lambda$17(BlueprintLayoutPmBinding blueprintLayoutPmBinding) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$21$lambda$18(BlueprintLayoutPmBinding blueprintLayoutPmBinding) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$21$lambda$20(BlueprintLayoutPmBinding blueprintLayoutPmBinding, final BlueprintScreen blueprintScreen) {
        blueprintLayoutPmBinding.pmImage.setImageResource(R.drawable.pm_stage_3);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPMWeapon$lambda$21$lambda$20$lambda$19;
                showPMWeapon$lambda$21$lambda$20$lambda$19 = BlueprintScreen.showPMWeapon$lambda$21$lambda$20$lambda$19(BlueprintScreen.this);
                return showPMWeapon$lambda$21$lambda$20$lambda$19;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPMWeapon$lambda$21$lambda$20$lambda$19(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeOne() {
        final BlueprintPipeOneBinding blueprintPipeOneBinding = this.blueprintBinding.pipeOne;
        FrameLayout touchOne = blueprintPipeOneBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeOneBinding.touchTwo, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$22;
                showPipeOne$lambda$28$lambda$22 = BlueprintScreen.showPipeOne$lambda$28$lambda$22(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$28$lambda$22;
            }
        });
        FrameLayout touchTwo = blueprintPipeOneBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeOneBinding.touchThree, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$23;
                showPipeOne$lambda$28$lambda$23 = BlueprintScreen.showPipeOne$lambda$28$lambda$23(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$28$lambda$23;
            }
        });
        FrameLayout touchThree = blueprintPipeOneBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeOneBinding.touchFour, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$24;
                showPipeOne$lambda$28$lambda$24 = BlueprintScreen.showPipeOne$lambda$28$lambda$24(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$28$lambda$24;
            }
        });
        FrameLayout touchFour = blueprintPipeOneBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeOneBinding.touchFive, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$25;
                showPipeOne$lambda$28$lambda$25 = BlueprintScreen.showPipeOne$lambda$28$lambda$25(BlueprintPipeOneBinding.this);
                return showPipeOne$lambda$28$lambda$25;
            }
        });
        FrameLayout touchFive = blueprintPipeOneBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$27;
                showPipeOne$lambda$28$lambda$27 = BlueprintScreen.showPipeOne$lambda$28$lambda$27(BlueprintPipeOneBinding.this, this);
                return showPipeOne$lambda$28$lambda$27;
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
    public static final Unit showPipeOne$lambda$28$lambda$22(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$28$lambda$23(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$28$lambda$24(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$28$lambda$25(BlueprintPipeOneBinding blueprintPipeOneBinding) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$28$lambda$27(BlueprintPipeOneBinding blueprintPipeOneBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeOneBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_one_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeOne$lambda$28$lambda$27$lambda$26;
                showPipeOne$lambda$28$lambda$27$lambda$26 = BlueprintScreen.showPipeOne$lambda$28$lambda$27$lambda$26(BlueprintScreen.this);
                return showPipeOne$lambda$28$lambda$27$lambda$26;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeOne$lambda$28$lambda$27$lambda$26(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeTwo() {
        final BlueprintPipeTwoBinding blueprintPipeTwoBinding = this.blueprintBinding.pipeTwo;
        FrameLayout touchOne = blueprintPipeTwoBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeTwoBinding.touchTwo, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$29;
                showPipeTwo$lambda$35$lambda$29 = BlueprintScreen.showPipeTwo$lambda$35$lambda$29(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$35$lambda$29;
            }
        });
        FrameLayout touchTwo = blueprintPipeTwoBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeTwoBinding.touchThree, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$30;
                showPipeTwo$lambda$35$lambda$30 = BlueprintScreen.showPipeTwo$lambda$35$lambda$30(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$35$lambda$30;
            }
        });
        FrameLayout touchThree = blueprintPipeTwoBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeTwoBinding.touchFour, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$31;
                showPipeTwo$lambda$35$lambda$31 = BlueprintScreen.showPipeTwo$lambda$35$lambda$31(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$35$lambda$31;
            }
        });
        FrameLayout touchFour = blueprintPipeTwoBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeTwoBinding.touchFive, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$32;
                showPipeTwo$lambda$35$lambda$32 = BlueprintScreen.showPipeTwo$lambda$35$lambda$32(BlueprintPipeTwoBinding.this);
                return showPipeTwo$lambda$35$lambda$32;
            }
        });
        FrameLayout touchFive = blueprintPipeTwoBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$34;
                showPipeTwo$lambda$35$lambda$34 = BlueprintScreen.showPipeTwo$lambda$35$lambda$34(BlueprintPipeTwoBinding.this, this);
                return showPipeTwo$lambda$35$lambda$34;
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
    public static final Unit showPipeTwo$lambda$35$lambda$29(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$35$lambda$30(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$35$lambda$31(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$35$lambda$32(BlueprintPipeTwoBinding blueprintPipeTwoBinding) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$35$lambda$34(BlueprintPipeTwoBinding blueprintPipeTwoBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeTwoBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_two_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeTwo$lambda$35$lambda$34$lambda$33;
                showPipeTwo$lambda$35$lambda$34$lambda$33 = BlueprintScreen.showPipeTwo$lambda$35$lambda$34$lambda$33(BlueprintScreen.this);
                return showPipeTwo$lambda$35$lambda$34$lambda$33;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeTwo$lambda$35$lambda$34$lambda$33(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeThree() {
        final BlueprintPipeThreeBinding blueprintPipeThreeBinding = this.blueprintBinding.pipeThree;
        FrameLayout touchOne = blueprintPipeThreeBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeThreeBinding.touchTwo, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$36;
                showPipeThree$lambda$42$lambda$36 = BlueprintScreen.showPipeThree$lambda$42$lambda$36(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$42$lambda$36;
            }
        });
        FrameLayout touchTwo = blueprintPipeThreeBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeThreeBinding.touchThree, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$37;
                showPipeThree$lambda$42$lambda$37 = BlueprintScreen.showPipeThree$lambda$42$lambda$37(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$42$lambda$37;
            }
        });
        FrameLayout touchThree = blueprintPipeThreeBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeThreeBinding.touchFour, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$38;
                showPipeThree$lambda$42$lambda$38 = BlueprintScreen.showPipeThree$lambda$42$lambda$38(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$42$lambda$38;
            }
        });
        FrameLayout touchFour = blueprintPipeThreeBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeThreeBinding.touchFive, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$39;
                showPipeThree$lambda$42$lambda$39 = BlueprintScreen.showPipeThree$lambda$42$lambda$39(BlueprintPipeThreeBinding.this);
                return showPipeThree$lambda$42$lambda$39;
            }
        });
        FrameLayout touchFive = blueprintPipeThreeBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$41;
                showPipeThree$lambda$42$lambda$41 = BlueprintScreen.showPipeThree$lambda$42$lambda$41(BlueprintPipeThreeBinding.this, this);
                return showPipeThree$lambda$42$lambda$41;
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
    public static final Unit showPipeThree$lambda$42$lambda$36(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$42$lambda$37(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$42$lambda$38(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$42$lambda$39(BlueprintPipeThreeBinding blueprintPipeThreeBinding) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$42$lambda$41(BlueprintPipeThreeBinding blueprintPipeThreeBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeThreeBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_three_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeThree$lambda$42$lambda$41$lambda$40;
                showPipeThree$lambda$42$lambda$41$lambda$40 = BlueprintScreen.showPipeThree$lambda$42$lambda$41$lambda$40(BlueprintScreen.this);
                return showPipeThree$lambda$42$lambda$41$lambda$40;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeThree$lambda$42$lambda$41$lambda$40(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeFour() {
        final BlueprintPipeFourBinding blueprintPipeFourBinding = this.blueprintBinding.pipeFour;
        FrameLayout touchOne = blueprintPipeFourBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeFourBinding.touchTwo, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$43;
                showPipeFour$lambda$49$lambda$43 = BlueprintScreen.showPipeFour$lambda$49$lambda$43(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$49$lambda$43;
            }
        });
        FrameLayout touchTwo = blueprintPipeFourBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeFourBinding.touchThree, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$44;
                showPipeFour$lambda$49$lambda$44 = BlueprintScreen.showPipeFour$lambda$49$lambda$44(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$49$lambda$44;
            }
        });
        FrameLayout touchThree = blueprintPipeFourBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeFourBinding.touchFour, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$45;
                showPipeFour$lambda$49$lambda$45 = BlueprintScreen.showPipeFour$lambda$49$lambda$45(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$49$lambda$45;
            }
        });
        FrameLayout touchFour = blueprintPipeFourBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeFourBinding.touchFive, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$46;
                showPipeFour$lambda$49$lambda$46 = BlueprintScreen.showPipeFour$lambda$49$lambda$46(BlueprintPipeFourBinding.this);
                return showPipeFour$lambda$49$lambda$46;
            }
        });
        FrameLayout touchFive = blueprintPipeFourBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$48;
                showPipeFour$lambda$49$lambda$48 = BlueprintScreen.showPipeFour$lambda$49$lambda$48(BlueprintPipeFourBinding.this, this);
                return showPipeFour$lambda$49$lambda$48;
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
    public static final Unit showPipeFour$lambda$49$lambda$43(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$49$lambda$44(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$49$lambda$45(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$49$lambda$46(BlueprintPipeFourBinding blueprintPipeFourBinding) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$49$lambda$48(BlueprintPipeFourBinding blueprintPipeFourBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeFourBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_four_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFour$lambda$49$lambda$48$lambda$47;
                showPipeFour$lambda$49$lambda$48$lambda$47 = BlueprintScreen.showPipeFour$lambda$49$lambda$48$lambda$47(BlueprintScreen.this);
                return showPipeFour$lambda$49$lambda$48$lambda$47;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFour$lambda$49$lambda$48$lambda$47(BlueprintScreen blueprintScreen) {
        SAMPUIElement.notifyClick$default(blueprintScreen, 1, -1, null, 4, null);
        blueprintScreen.closeScreen();
        return Unit.INSTANCE;
    }

    private final void showPipeFive() {
        final BlueprintPipeFiveBinding blueprintPipeFiveBinding = this.blueprintBinding.pipeFive;
        FrameLayout touchOne = blueprintPipeFiveBinding.touchOne;
        Intrinsics.checkNotNullExpressionValue(touchOne, "touchOne");
        clickOnPipe(touchOne, blueprintPipeFiveBinding.touchTwo, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$50;
                showPipeFive$lambda$56$lambda$50 = BlueprintScreen.showPipeFive$lambda$56$lambda$50(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$56$lambda$50;
            }
        });
        FrameLayout touchTwo = blueprintPipeFiveBinding.touchTwo;
        Intrinsics.checkNotNullExpressionValue(touchTwo, "touchTwo");
        clickOnPipe(touchTwo, blueprintPipeFiveBinding.touchThree, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$51;
                showPipeFive$lambda$56$lambda$51 = BlueprintScreen.showPipeFive$lambda$56$lambda$51(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$56$lambda$51;
            }
        });
        FrameLayout touchThree = blueprintPipeFiveBinding.touchThree;
        Intrinsics.checkNotNullExpressionValue(touchThree, "touchThree");
        clickOnPipe(touchThree, blueprintPipeFiveBinding.touchFour, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$52;
                showPipeFive$lambda$56$lambda$52 = BlueprintScreen.showPipeFive$lambda$56$lambda$52(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$56$lambda$52;
            }
        });
        FrameLayout touchFour = blueprintPipeFiveBinding.touchFour;
        Intrinsics.checkNotNullExpressionValue(touchFour, "touchFour");
        clickOnPipe(touchFour, blueprintPipeFiveBinding.touchFive, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$53;
                showPipeFive$lambda$56$lambda$53 = BlueprintScreen.showPipeFive$lambda$56$lambda$53(BlueprintPipeFiveBinding.this);
                return showPipeFive$lambda$56$lambda$53;
            }
        });
        FrameLayout touchFive = blueprintPipeFiveBinding.touchFive;
        Intrinsics.checkNotNullExpressionValue(touchFive, "touchFive");
        clickOnPipe$default(this, touchFive, null, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$55;
                showPipeFive$lambda$56$lambda$55 = BlueprintScreen.showPipeFive$lambda$56$lambda$55(BlueprintPipeFiveBinding.this, this);
                return showPipeFive$lambda$56$lambda$55;
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
    public static final Unit showPipeFive$lambda$56$lambda$50(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_one);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$56$lambda$51(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_two);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$56$lambda$52(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_three);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$56$lambda$53(BlueprintPipeFiveBinding blueprintPipeFiveBinding) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_four);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$56$lambda$55(BlueprintPipeFiveBinding blueprintPipeFiveBinding, final BlueprintScreen blueprintScreen) {
        blueprintPipeFiveBinding.ivDrawing.setImageResource(R.drawable.blueprint_pipe_five_stage_five);
        blueprintScreen.startLastAreaTimer(new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit showPipeFive$lambda$56$lambda$55$lambda$54;
                showPipeFive$lambda$56$lambda$55$lambda$54 = BlueprintScreen.showPipeFive$lambda$56$lambda$55$lambda$54(BlueprintScreen.this);
                return showPipeFive$lambda$56$lambda$55$lambda$54;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPipeFive$lambda$56$lambda$55$lambda$54(BlueprintScreen blueprintScreen) {
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
        clickOnWeapon(view, view2, new Function0() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit clickOnPipe$lambda$57;
                clickOnPipe$lambda$57 = BlueprintScreen.clickOnPipe$lambda$57(Function0.this, this, load);
                return clickOnPipe$lambda$57;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickOnPipe$lambda$57(Function0 function0, BlueprintScreen blueprintScreen, int i) {
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
        view.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.blueprint.BlueprintScreen$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BlueprintScreen.clickOnWeapon$lambda$59(view2, function0, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickOnWeapon$lambda$59(View view, Function0 function0, View view2) {
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
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            showBlueprintScreen((BlueprintResponse) MapperKt.toModel(data, BlueprintResponse.class));
        }
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/blueprint/BlueprintScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BlueprintScreen(targetActivity, i);
        }
    }
}

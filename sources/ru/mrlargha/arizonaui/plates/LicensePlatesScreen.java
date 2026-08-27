package ru.mrlargha.arizonaui.plates;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.AzAmericanPlateNumberScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzArizonaPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzByPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzChooseRegionScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzKzPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzLicencePlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzRusPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzUaPlateScreenBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: LicensePlatesScreen.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 J2\u00020\u0001:\u0002JKB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J1\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u001f\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u0016H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020\u0016H\u0002J\b\u0010;\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002J\b\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020\u0016H\u0002J\b\u0010?\u001a\u00020\u0016H\u0002J\b\u0010@\u001a\u00020\u0016H\u0002J\u0016\u0010A\u001a\u00020\u00162\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0018\u0010E\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u0005H\u0016J\u0010\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020IH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "platesScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "platesBinding", "Lru/mrlargha/arizonaui/databinding/AzLicencePlateScreenBinding;", "currentRegion", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlatesRegion;", "currentUiMode", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlateUiMode;", "usaPlates", "Ljava/util/LinkedList;", FirebaseAnalytics.Param.INDEX, "activeGenerationAnimation", "Landroid/animation/AnimatorSet;", "usaPlatesAction", "", "chooseRegionAction", "installPlateNumber", "data", "", "getStandardPlateNumberView", "Landroid/widget/TextView;", "startGenerationAnimation", "numberView", "regionView", "number", "regionIndex", "(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;)V", "buildNumberAnimationFrame", TypedValues.AttributesType.S_FRAME, "fixedCharacterCount", "setFinalRegion", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "parseGeneratedPlate", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$GeneratedPlateResponse;", "rusPlatesAction", "uaPlatesAction", "byPlatesAction", "kzPlatesAction", "showUiMode", UpdateActivity.UPDATE_MODE, "hideAllPlateScreens", "resetArizonaPlate", "cancelGenerationAnimation", "showKzPlatesScreen", "hideKzPlatesScreen", "showUaPlatesScreen", "hideUaPlatesScreen", "showByPlatesScreen", "hideByPlatesScreen", "showRusPlatesScreen", "hideRusPlatesScreen", "showChooseRegionScreen", "hideChooseRegionScreen", "showUSAPlatesScreen", "hideUSAPlatesScreen", "hideMainScreen", "showMainScreen", "updatePrices", "response", "", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$UpdatePricesResponse;", "onBackendMessageHandled", "subId", "setVisibility", "visible", "", "Companion", "Spawner", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LicensePlatesScreen extends SAMPUIElement {
    private static final String ARIZONA_COUNTRY_CODE = "arz";
    private static final long GENERATION_ANIMATION_DURATION_MS = 4000;
    private static final int GENERATION_ANIMATION_FRAMES = 48;
    private static final String NUMBER_CHARACTER_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String REGION_EMOJI_COLOR = "#3D83BE";
    private static final String UNKNOWN_REGION_COLOR = "#E11A1A";
    private AnimatorSet activeGenerationAnimation;
    private Companion.LicensePlatesRegion currentRegion;
    private Companion.LicensePlateUiMode currentUiMode;
    private int index;
    private final AzLicencePlateScreenBinding platesBinding;
    private final ConstraintLayout platesScreen;
    private final LinkedList<Integer> usaPlates;
    public static final Companion Companion = new Companion(null);
    private static final List<String> REGION_EMOJI_POOL = CollectionsKt.listOf((Object[]) new String[]{":boom:", ":rocket:", ":red_flag:", ":moai:", ":gun:", ":soccer:", ":eyes:", ":eye:", ":skull:", ":u2620:", ":ghost:", ":goblin:", ":alien:", ":clown:", ":u1f4b2:", ":u1f51e:", ":na:", ":nb:", ":nc:", ":nd:", ":ne:", ":nf:", ":ng:", ":nh:", ":ni:", ":nj:"});

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Companion.LicensePlatesRegion.values().length];
            try {
                iArr[Companion.LicensePlatesRegion.COUNTRY_RUSSIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.LicensePlatesRegion.COUNTRY_UKRAINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.LicensePlatesRegion.COUNTRY_KAZAKHSTAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Companion.LicensePlatesRegion.COUNTRY_BELARUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Companion.LicensePlatesRegion.COUNTRY_USA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Companion.LicensePlateUiMode.values().length];
            try {
                iArr2[Companion.LicensePlateUiMode.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Companion.LicensePlateUiMode.ARIZONA.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LicensePlatesScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.az_licence_plate_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.platesScreen = constraintLayout;
        final AzLicencePlateScreenBinding bind = AzLicencePlateScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.platesBinding = bind;
        this.currentRegion = Companion.LicensePlatesRegion.COUNTRY_RUSSIA;
        this.currentUiMode = Companion.LicensePlateUiMode.STANDARD;
        LinkedList<Integer> linkedList = new LinkedList<>();
        this.usaPlates = linkedList;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        linkedList.addAll(SetsKt.linkedSetOf(Integer.valueOf(R.drawable.number_usa), Integer.valueOf(R.drawable.number_alabama), Integer.valueOf(R.drawable.number_alaska), Integer.valueOf(R.drawable.number_arizona), Integer.valueOf(R.drawable.number_arkansas), Integer.valueOf(R.drawable.number_colorado), Integer.valueOf(R.drawable.number_connecticut), Integer.valueOf(R.drawable.number_delaware), Integer.valueOf(R.drawable.number_florida), Integer.valueOf(R.drawable.number_georgia), Integer.valueOf(R.drawable.number_hawaii), Integer.valueOf(R.drawable.number_idaho), Integer.valueOf(R.drawable.number_illinois), Integer.valueOf(R.drawable.number_indiana), Integer.valueOf(R.drawable.number_iowa), Integer.valueOf(R.drawable.number_kansas), Integer.valueOf(R.drawable.number_louisiane), Integer.valueOf(R.drawable.number_maine), Integer.valueOf(R.drawable.number_maryland), Integer.valueOf(R.drawable.number_massachusetts), Integer.valueOf(R.drawable.number_michigan), Integer.valueOf(R.drawable.number_minnesota), Integer.valueOf(R.drawable.number_mississippi), Integer.valueOf(R.drawable.number_missouri), Integer.valueOf(R.drawable.number_montana), Integer.valueOf(R.drawable.number_nebraska), Integer.valueOf(R.drawable.number_nevada), Integer.valueOf(R.drawable.number_new_hampshire), Integer.valueOf(R.drawable.number_new_jersey), Integer.valueOf(R.drawable.number_new_mexico), Integer.valueOf(R.drawable.number_new_york), Integer.valueOf(R.drawable.number_north_carolina), Integer.valueOf(R.drawable.number_north_dakota), Integer.valueOf(R.drawable.number_ohio), Integer.valueOf(R.drawable.number_oklahoma), Integer.valueOf(R.drawable.number_oregon), Integer.valueOf(R.drawable.number_pennsylvania), Integer.valueOf(R.drawable.number_rhode_island), Integer.valueOf(R.drawable.number_south_carolina), Integer.valueOf(R.drawable.number_south_dakota), Integer.valueOf(R.drawable.number_tennessee), Integer.valueOf(R.drawable.number_texas), Integer.valueOf(R.drawable.number_utah), Integer.valueOf(R.drawable.number_vermont), Integer.valueOf(R.drawable.number_virginia), Integer.valueOf(R.drawable.number_washington), Integer.valueOf(R.drawable.number_west_virginia), Integer.valueOf(R.drawable.number_wisconsin), Integer.valueOf(R.drawable.number_wyoming)));
        ChatEmoji.INSTANCE.init(targetActivity);
        bind.usaPlateMainButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.lambda$0$0(AzLicencePlateScreenBinding.this, this, view);
            }
        });
        bind.sngPlateMainButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.lambda$0$1(AzLicencePlateScreenBinding.this, this, view);
            }
        });
        bind.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(LicensePlatesScreen.this, 0, 0, null, 4, null);
            }
        });
        bind.arizonaPlateScreen.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(LicensePlatesScreen.this, 0, 0, null, 4, null);
            }
        });
        bind.arizonaPlateScreen.getNumberButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.lambda$0$4(LicensePlatesScreen.this, view);
            }
        });
        showUiMode(Companion.LicensePlateUiMode.STANDARD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(AzLicencePlateScreenBinding azLicencePlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azLicencePlateScreenBinding.usaPlateMainButton.setAlpha(1.0f);
        azLicencePlateScreenBinding.sngPlateMainButton.setAlpha(0.4f);
        licensePlatesScreen.hideMainScreen();
        licensePlatesScreen.showUSAPlatesScreen();
        licensePlatesScreen.usaPlatesAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(AzLicencePlateScreenBinding azLicencePlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azLicencePlateScreenBinding.sngPlateMainButton.setAlpha(1.0f);
        azLicencePlateScreenBinding.usaPlateMainButton.setAlpha(0.4f);
        licensePlatesScreen.hideMainScreen();
        licensePlatesScreen.showChooseRegionScreen();
        licensePlatesScreen.chooseRegionAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$4(LicensePlatesScreen licensePlatesScreen, View view) {
        licensePlatesScreen.resetArizonaPlate();
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest(ARIZONA_COUNTRY_CODE, "")));
    }

    private final void usaPlatesAction() {
        final AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding = this.platesBinding.usaPlatesScreen;
        azAmericanPlateNumberScreenBinding.swipeLeftButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$0$0(LicensePlatesScreen.this, azAmericanPlateNumberScreenBinding, view);
            }
        });
        azAmericanPlateNumberScreenBinding.swipeRightButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$0$1(LicensePlatesScreen.this, azAmericanPlateNumberScreenBinding, view);
            }
        });
        azAmericanPlateNumberScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$0$2(LicensePlatesScreen.this, view);
            }
        });
        azAmericanPlateNumberScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$0$3(AzAmericanPlateNumberScreenBinding.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$0$0(LicensePlatesScreen licensePlatesScreen, AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, View view) {
        int i = licensePlatesScreen.index;
        if (i == 0) {
            azAmericanPlateNumberScreenBinding.swipeLeftButton.setAlpha(0.4f);
        } else {
            licensePlatesScreen.index = i - 1;
            azAmericanPlateNumberScreenBinding.swipeLeftButton.setAlpha(1.0f);
        }
        ConstraintLayout constraintLayout = azAmericanPlateNumberScreenBinding.plate;
        Integer num = licensePlatesScreen.usaPlates.get(licensePlatesScreen.index);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        constraintLayout.setBackgroundResource(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$0$1(LicensePlatesScreen licensePlatesScreen, AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, View view) {
        int size = licensePlatesScreen.usaPlates.size() - 1;
        int i = licensePlatesScreen.index;
        if (size == i) {
            azAmericanPlateNumberScreenBinding.swipeRightButton.setAlpha(0.4f);
        } else {
            licensePlatesScreen.index = i + 1;
            azAmericanPlateNumberScreenBinding.swipeRightButton.setAlpha(1.0f);
        }
        ConstraintLayout constraintLayout = azAmericanPlateNumberScreenBinding.plate;
        Integer num = licensePlatesScreen.usaPlates.get(licensePlatesScreen.index);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        constraintLayout.setBackgroundResource(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$0$2(LicensePlatesScreen licensePlatesScreen, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_USA;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("usa", String.valueOf(licensePlatesScreen.index))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$0$3(AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azAmericanPlateNumberScreenBinding.plateNumber.setText((CharSequence) null);
        licensePlatesScreen.hideUSAPlatesScreen();
        licensePlatesScreen.showMainScreen();
    }

    private final void chooseRegionAction() {
        final AzChooseRegionScreenBinding azChooseRegionScreenBinding = this.platesBinding.chooseRegionScreen;
        azChooseRegionScreenBinding.chooseRusNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$0(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseByNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$1(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseKzNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$2(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseUaNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$3(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$4(AzChooseRegionScreenBinding.this, this, view);
            }
        });
        azChooseRegionScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$0$5(LicensePlatesScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$0(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$1(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$2(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$3(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$4(AzChooseRegionScreenBinding azChooseRegionScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        if (azChooseRegionScreenBinding.chooseRusNumbers.getAlpha() == 1.0f) {
            licensePlatesScreen.hideChooseRegionScreen();
            licensePlatesScreen.showRusPlatesScreen();
            licensePlatesScreen.rusPlatesAction();
        } else if (azChooseRegionScreenBinding.chooseByNumbers.getAlpha() == 1.0f) {
            licensePlatesScreen.hideChooseRegionScreen();
            licensePlatesScreen.showByPlatesScreen();
            licensePlatesScreen.byPlatesAction();
        } else if (azChooseRegionScreenBinding.chooseKzNumbers.getAlpha() == 1.0f) {
            licensePlatesScreen.hideChooseRegionScreen();
            licensePlatesScreen.showKzPlatesScreen();
            licensePlatesScreen.kzPlatesAction();
        } else if (azChooseRegionScreenBinding.chooseUaNumbers.getAlpha() == 1.0f) {
            licensePlatesScreen.hideChooseRegionScreen();
            licensePlatesScreen.showUaPlatesScreen();
            licensePlatesScreen.uaPlatesAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$0$5(LicensePlatesScreen licensePlatesScreen, View view) {
        licensePlatesScreen.hideChooseRegionScreen();
        licensePlatesScreen.showMainScreen();
    }

    private final void installPlateNumber(String str) {
        String number;
        TextView standardPlateNumberView;
        Companion.GeneratedPlateResponse parseGeneratedPlate = parseGeneratedPlate(str);
        if (parseGeneratedPlate == null || (number = parseGeneratedPlate.getNumber()) == null) {
            return;
        }
        if (StringsKt.isBlank(number)) {
            number = null;
        }
        if (number == null) {
            return;
        }
        boolean z = this.currentUiMode == Companion.LicensePlateUiMode.ARIZONA || parseGeneratedPlate.getRegion() != null;
        if (z && this.currentUiMode != Companion.LicensePlateUiMode.ARIZONA) {
            showUiMode(Companion.LicensePlateUiMode.ARIZONA);
        }
        if (z) {
            standardPlateNumberView = this.platesBinding.arizonaPlateScreen.plateNumber;
        } else {
            standardPlateNumberView = getStandardPlateNumberView();
        }
        Intrinsics.checkNotNull(standardPlateNumberView);
        startGenerationAnimation(standardPlateNumberView, z ? this.platesBinding.arizonaPlateScreen.plateRegion : null, number, parseGeneratedPlate.getRegion());
    }

    private final TextView getStandardPlateNumberView() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentRegion.ordinal()];
        if (i == 1) {
            TextView plateNumber = this.platesBinding.rusPlateScreen.plateNumber;
            Intrinsics.checkNotNullExpressionValue(plateNumber, "plateNumber");
            return plateNumber;
        } else if (i == 2) {
            TextView plateNumber2 = this.platesBinding.uaPlateScreen.plateNumber;
            Intrinsics.checkNotNullExpressionValue(plateNumber2, "plateNumber");
            return plateNumber2;
        } else if (i == 3) {
            TextView plateNumber3 = this.platesBinding.kzPlateScreen.plateNumber;
            Intrinsics.checkNotNullExpressionValue(plateNumber3, "plateNumber");
            return plateNumber3;
        } else if (i == 4) {
            TextView plateNumber4 = this.platesBinding.byPlateScreen.plateNumber;
            Intrinsics.checkNotNullExpressionValue(plateNumber4, "plateNumber");
            return plateNumber4;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            TextView plateNumber5 = this.platesBinding.usaPlatesScreen.plateNumber;
            Intrinsics.checkNotNullExpressionValue(plateNumber5, "plateNumber");
            return plateNumber5;
        }
    }

    private final void startGenerationAnimation(final TextView textView, final TextView textView2, final String str, final Integer num) {
        ValueAnimator valueAnimator;
        cancelGenerationAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 48);
        ofInt.setDuration(GENERATION_ANIMATION_DURATION_MS);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                LicensePlatesScreen.startGenerationAnimation$lambda$0$0(str, textView, this, valueAnimator2);
            }
        });
        if (textView2 != null) {
            valueAnimator = ValueAnimator.ofInt(0, 48);
            valueAnimator.setDuration(GENERATION_ANIMATION_DURATION_MS);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda16
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    LicensePlatesScreen.startGenerationAnimation$lambda$1$0$0(textView2, valueAnimator2);
                }
            });
        } else {
            valueAnimator = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new ValueAnimator[]{ofInt, valueAnimator});
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        animatorSet.playTogether(listOfNotNull);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$startGenerationAnimation$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Ref.BooleanRef.this.element = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimatorSet animatorSet2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                animatorSet2 = this.activeGenerationAnimation;
                if (animatorSet2 == animation) {
                    this.activeGenerationAnimation = null;
                }
                if (Ref.BooleanRef.this.element) {
                    return;
                }
                textView.setText(str);
                TextView textView3 = textView2;
                if (textView3 != null) {
                    this.setFinalRegion(textView3, num);
                }
                SAMPUIElement.notifyClick$default(this, 0, 2, null, 4, null);
            }
        });
        this.activeGenerationAnimation = animatorSet;
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGenerationAnimation$lambda$0$0(String str, TextView textView, LicensePlatesScreen licensePlatesScreen, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        textView.setText(licensePlatesScreen.buildNumberAnimationFrame(str, ((Integer) animatedValue).intValue(), RangesKt.coerceIn((int) (animator.getAnimatedFraction() * str.length()), 0, str.length())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGenerationAnimation$lambda$1$0$0(TextView textView, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        List<String> list = REGION_EMOJI_POOL;
        int size = intValue % list.size();
        textView.setTextColor(Color.parseColor(REGION_EMOJI_COLOR));
        textView.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, list.get(size), 0.0f, null, 3, null));
    }

    private final String buildNumberAnimationFrame(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        int i3 = 0;
        int i4 = 0;
        while (i3 < str2.length()) {
            char charAt = str2.charAt(i3);
            int i5 = i4 + 1;
            if (i4 < i2) {
                sb.append(charAt);
            } else {
                sb.append(NUMBER_CHARACTER_POOL.charAt(((i * 3) + (i4 * 7)) % 36));
            }
            i3++;
            i4 = i5;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFinalRegion(TextView textView, Integer num) {
        String str = num != null ? (String) CollectionsKt.getOrNull(REGION_EMOJI_POOL, num.intValue()) : null;
        if (str == null) {
            textView.setTextColor(Color.parseColor(UNKNOWN_REGION_COLOR));
            textView.setText(R.string.plate_unknown_region);
            return;
        }
        textView.setTextColor(Color.parseColor(REGION_EMOJI_COLOR));
        textView.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str, 0.0f, null, 3, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Companion.GeneratedPlateResponse parseGeneratedPlate(String str) {
        Object m9919constructorimpl;
        String number;
        String removeSurrounding;
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            LicensePlatesScreen licensePlatesScreen = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (MapperKt.isJsonValid(str) && !Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL) && !Intrinsics.areEqual(str, "{}") && str.length() != 0) {
            obj = MapperKt.getGson().fromJson(str, (Class<Object>) Companion.GeneratedPlateResponse.class);
            m9919constructorimpl = Result.m9919constructorimpl((Companion.GeneratedPlateResponse) obj);
            if (Result.m9925isFailureimpl(m9919constructorimpl)) {
                m9919constructorimpl = null;
            }
            Companion.GeneratedPlateResponse generatedPlateResponse = (Companion.GeneratedPlateResponse) m9919constructorimpl;
            number = generatedPlateResponse == null ? generatedPlateResponse.getNumber() : null;
            if (number != null || StringsKt.isBlank(number)) {
                removeSurrounding = StringsKt.removeSurrounding(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "\"");
                if (!StringsKt.isBlank(removeSurrounding) || StringsKt.startsWith$default(removeSurrounding, "{", false, 2, (Object) null) || StringsKt.startsWith$default(removeSurrounding, "[", false, 2, (Object) null)) {
                    removeSurrounding = null;
                }
                if (removeSurrounding == null) {
                    return new Companion.GeneratedPlateResponse(removeSurrounding, null, 2, null);
                }
                return null;
            }
            return generatedPlateResponse;
        }
        obj = null;
        m9919constructorimpl = Result.m9919constructorimpl((Companion.GeneratedPlateResponse) obj);
        if (Result.m9925isFailureimpl(m9919constructorimpl)) {
        }
        Companion.GeneratedPlateResponse generatedPlateResponse2 = (Companion.GeneratedPlateResponse) m9919constructorimpl;
        number = generatedPlateResponse2 == null ? generatedPlateResponse2.getNumber() : null;
        if (number != null) {
        }
        removeSurrounding = StringsKt.removeSurrounding(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "\"");
        if (!StringsKt.isBlank(removeSurrounding)) {
        }
        removeSurrounding = null;
        if (removeSurrounding == null) {
        }
    }

    private final void rusPlatesAction() {
        final AzRusPlateScreenBinding azRusPlateScreenBinding = this.platesBinding.rusPlateScreen;
        azRusPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.rusPlatesAction$lambda$0$0(AzRusPlateScreenBinding.this, this, view);
            }
        });
        azRusPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.rusPlatesAction$lambda$0$1(LicensePlatesScreen.this, azRusPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rusPlatesAction$lambda$0$0(AzRusPlateScreenBinding azRusPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azRusPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azRusPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideRusPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rusPlatesAction$lambda$0$1(LicensePlatesScreen licensePlatesScreen, AzRusPlateScreenBinding azRusPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_RUSSIA;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("rus", azRusPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void uaPlatesAction() {
        final AzUaPlateScreenBinding azUaPlateScreenBinding = this.platesBinding.uaPlateScreen;
        azUaPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.uaPlatesAction$lambda$0$0(AzUaPlateScreenBinding.this, this, view);
            }
        });
        azUaPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.uaPlatesAction$lambda$0$1(LicensePlatesScreen.this, azUaPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uaPlatesAction$lambda$0$0(AzUaPlateScreenBinding azUaPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azUaPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azUaPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideUaPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uaPlatesAction$lambda$0$1(LicensePlatesScreen licensePlatesScreen, AzUaPlateScreenBinding azUaPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_UKRAINE;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("ua", azUaPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void byPlatesAction() {
        final AzByPlateScreenBinding azByPlateScreenBinding = this.platesBinding.byPlateScreen;
        azByPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.byPlatesAction$lambda$0$0(AzByPlateScreenBinding.this, this, view);
            }
        });
        azByPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.byPlatesAction$lambda$0$1(LicensePlatesScreen.this, azByPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byPlatesAction$lambda$0$0(AzByPlateScreenBinding azByPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azByPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azByPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideByPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byPlatesAction$lambda$0$1(LicensePlatesScreen licensePlatesScreen, AzByPlateScreenBinding azByPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_BELARUS;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("by", azByPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void kzPlatesAction() {
        final AzKzPlateScreenBinding azKzPlateScreenBinding = this.platesBinding.kzPlateScreen;
        azKzPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.kzPlatesAction$lambda$0$0(AzKzPlateScreenBinding.this, this, view);
            }
        });
        azKzPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.kzPlatesAction$lambda$0$1(LicensePlatesScreen.this, azKzPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kzPlatesAction$lambda$0$0(AzKzPlateScreenBinding azKzPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azKzPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azKzPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideKzPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kzPlatesAction$lambda$0$1(LicensePlatesScreen licensePlatesScreen, AzKzPlateScreenBinding azKzPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_KAZAKHSTAN;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("kz", azKzPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void showUiMode(Companion.LicensePlateUiMode licensePlateUiMode) {
        this.currentUiMode = licensePlateUiMode;
        cancelGenerationAnimation();
        hideAllPlateScreens();
        int i = WhenMappings.$EnumSwitchMapping$1[licensePlateUiMode.ordinal()];
        if (i == 1) {
            showMainScreen();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            resetArizonaPlate();
            this.platesBinding.arizonaPlateScreen.getRoot().setVisibility(0);
        }
    }

    private final void hideAllPlateScreens() {
        AzLicencePlateScreenBinding azLicencePlateScreenBinding = this.platesBinding;
        azLicencePlateScreenBinding.mainPlatesScreen.setVisibility(8);
        azLicencePlateScreenBinding.chooseRegionScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.rusPlateScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.uaPlateScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.byPlateScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.kzPlateScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.usaPlatesScreen.getRoot().setVisibility(8);
        azLicencePlateScreenBinding.arizonaPlateScreen.getRoot().setVisibility(8);
    }

    private final void resetArizonaPlate() {
        cancelGenerationAnimation();
        AzArizonaPlateScreenBinding azArizonaPlateScreenBinding = this.platesBinding.arizonaPlateScreen;
        azArizonaPlateScreenBinding.plateNumber.setText(R.string.plate_unknown_number);
        azArizonaPlateScreenBinding.plateRegion.setTextColor(Color.parseColor(UNKNOWN_REGION_COLOR));
        azArizonaPlateScreenBinding.plateRegion.setText(R.string.plate_unknown_region);
    }

    private final void cancelGenerationAnimation() {
        AnimatorSet animatorSet = this.activeGenerationAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.activeGenerationAnimation = null;
    }

    private final void showKzPlatesScreen() {
        this.platesBinding.kzPlateScreen.getRoot().setVisibility(0);
    }

    private final void hideKzPlatesScreen() {
        this.platesBinding.kzPlateScreen.getRoot().setVisibility(8);
    }

    private final void showUaPlatesScreen() {
        this.platesBinding.uaPlateScreen.getRoot().setVisibility(0);
    }

    private final void hideUaPlatesScreen() {
        this.platesBinding.uaPlateScreen.getRoot().setVisibility(8);
    }

    private final void showByPlatesScreen() {
        this.platesBinding.byPlateScreen.getRoot().setVisibility(0);
    }

    private final void hideByPlatesScreen() {
        this.platesBinding.byPlateScreen.getRoot().setVisibility(8);
    }

    private final void showRusPlatesScreen() {
        this.platesBinding.rusPlateScreen.getRoot().setVisibility(0);
    }

    private final void hideRusPlatesScreen() {
        this.platesBinding.rusPlateScreen.getRoot().setVisibility(8);
    }

    private final void showChooseRegionScreen() {
        this.platesBinding.chooseRegionScreen.getRoot().setVisibility(0);
    }

    private final void hideChooseRegionScreen() {
        this.platesBinding.chooseRegionScreen.getRoot().setVisibility(8);
    }

    private final void showUSAPlatesScreen() {
        this.platesBinding.usaPlatesScreen.getRoot().setVisibility(0);
    }

    private final void hideUSAPlatesScreen() {
        this.platesBinding.usaPlatesScreen.getRoot().setVisibility(8);
    }

    private final void hideMainScreen() {
        this.platesBinding.mainPlatesScreen.setVisibility(8);
    }

    private final void showMainScreen() {
        this.platesBinding.mainPlatesScreen.setVisibility(0);
    }

    private final void updatePrices(List<Companion.UpdatePricesResponse> list) {
        AzLicencePlateScreenBinding azLicencePlateScreenBinding = this.platesBinding;
        for (Companion.UpdatePricesResponse updatePricesResponse : list) {
            if (Intrinsics.areEqual(updatePricesResponse.getCountry(), "usa")) {
                if (Intrinsics.areEqual(updatePricesResponse.getCurrency(), "AZ")) {
                    azLicencePlateScreenBinding.usaPriceText.setText(getTargetActivity().getString(R.string.plate_price_from_dynamic_coin, new Object[]{updatePricesResponse.getSum(), updatePricesResponse.getCurrency()}));
                } else {
                    azLicencePlateScreenBinding.usaPriceText.setText(getTargetActivity().getString(R.string.plate_price_from_dynamic, new Object[]{updatePricesResponse.getSum(), updatePricesResponse.getCurrency()}));
                }
            } else if (Intrinsics.areEqual(updatePricesResponse.getCurrency(), "AZ")) {
                azLicencePlateScreenBinding.cisPriceText.setText(getTargetActivity().getString(R.string.plate_price_from_dynamic_coin, new Object[]{updatePricesResponse.getSum(), updatePricesResponse.getCurrency()}));
            } else {
                azLicencePlateScreenBinding.cisPriceText.setText(getTargetActivity().getString(R.string.plate_price_from_dynamic, new Object[]{updatePricesResponse.getSum(), updatePricesResponse.getCurrency()}));
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            installPlateNumber(data);
        } else if (i == 1) {
            updatePrices(MapperKt.toListModel(data, Companion.UpdatePricesResponse.class));
        } else if (i != 2) {
        } else {
            String removeSurrounding = StringsKt.removeSurrounding(StringsKt.trim((CharSequence) data).toString(), (CharSequence) "\"");
            if (Intrinsics.areEqual(removeSurrounding, "0")) {
                showUiMode(Companion.LicensePlateUiMode.STANDARD);
            } else if (Intrinsics.areEqual(removeSurrounding, "1")) {
                showUiMode(Companion.LicensePlateUiMode.ARIZONA);
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            cancelGenerationAnimation();
        }
        super.setVisibility(z);
    }

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion;", "", "<init>", "()V", "ARIZONA_COUNTRY_CODE", "", "GENERATION_ANIMATION_DURATION_MS", "", "GENERATION_ANIMATION_FRAMES", "", "NUMBER_CHARACTER_POOL", "REGION_EMOJI_COLOR", "UNKNOWN_REGION_COLOR", "REGION_EMOJI_POOL", "", "LicensePlateUiMode", "LicensePlatesRegion", "UpdatePricesResponse", "BuyNumberRequest", "GeneratedPlateResponse", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlateUiMode;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "ARIZONA", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class LicensePlateUiMode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ LicensePlateUiMode[] $VALUES;
            public static final LicensePlateUiMode STANDARD = new LicensePlateUiMode("STANDARD", 0);
            public static final LicensePlateUiMode ARIZONA = new LicensePlateUiMode("ARIZONA", 1);

            private static final /* synthetic */ LicensePlateUiMode[] $values() {
                return new LicensePlateUiMode[]{STANDARD, ARIZONA};
            }

            public static EnumEntries<LicensePlateUiMode> getEntries() {
                return $ENTRIES;
            }

            public static LicensePlateUiMode valueOf(String str) {
                return (LicensePlateUiMode) Enum.valueOf(LicensePlateUiMode.class, str);
            }

            public static LicensePlateUiMode[] values() {
                return (LicensePlateUiMode[]) $VALUES.clone();
            }

            private LicensePlateUiMode(String str, int i) {
            }

            static {
                LicensePlateUiMode[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlatesRegion;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "COUNTRY_RUSSIA", "COUNTRY_UKRAINE", "COUNTRY_BELARUS", "COUNTRY_KAZAKHSTAN", "COUNTRY_USA", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class LicensePlatesRegion {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ LicensePlatesRegion[] $VALUES;
            private final int number;
            public static final LicensePlatesRegion COUNTRY_RUSSIA = new LicensePlatesRegion("COUNTRY_RUSSIA", 0, 0);
            public static final LicensePlatesRegion COUNTRY_UKRAINE = new LicensePlatesRegion("COUNTRY_UKRAINE", 1, 1);
            public static final LicensePlatesRegion COUNTRY_BELARUS = new LicensePlatesRegion("COUNTRY_BELARUS", 2, 2);
            public static final LicensePlatesRegion COUNTRY_KAZAKHSTAN = new LicensePlatesRegion("COUNTRY_KAZAKHSTAN", 3, 3);
            public static final LicensePlatesRegion COUNTRY_USA = new LicensePlatesRegion("COUNTRY_USA", 4, 4);

            private static final /* synthetic */ LicensePlatesRegion[] $values() {
                return new LicensePlatesRegion[]{COUNTRY_RUSSIA, COUNTRY_UKRAINE, COUNTRY_BELARUS, COUNTRY_KAZAKHSTAN, COUNTRY_USA};
            }

            public static EnumEntries<LicensePlatesRegion> getEntries() {
                return $ENTRIES;
            }

            public static LicensePlatesRegion valueOf(String str) {
                return (LicensePlatesRegion) Enum.valueOf(LicensePlatesRegion.class, str);
            }

            public static LicensePlatesRegion[] values() {
                return (LicensePlatesRegion[]) $VALUES.clone();
            }

            private LicensePlatesRegion(String str, int i, int i2) {
                this.number = i2;
            }

            public final int getNumber() {
                return this.number;
            }

            static {
                LicensePlatesRegion[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$UpdatePricesResponse;", "", "country", "", "sum", FirebaseAnalytics.Param.CURRENCY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getSum", "getCurrency", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class UpdatePricesResponse {
            private final String country;
            private final String currency;
            private final String sum;

            public static /* synthetic */ UpdatePricesResponse copy$default(UpdatePricesResponse updatePricesResponse, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updatePricesResponse.country;
                }
                if ((i & 2) != 0) {
                    str2 = updatePricesResponse.sum;
                }
                if ((i & 4) != 0) {
                    str3 = updatePricesResponse.currency;
                }
                return updatePricesResponse.copy(str, str2, str3);
            }

            public final String component1() {
                return this.country;
            }

            public final String component2() {
                return this.sum;
            }

            public final String component3() {
                return this.currency;
            }

            public final UpdatePricesResponse copy(String country, String sum, String currency) {
                Intrinsics.checkNotNullParameter(country, "country");
                Intrinsics.checkNotNullParameter(sum, "sum");
                Intrinsics.checkNotNullParameter(currency, "currency");
                return new UpdatePricesResponse(country, sum, currency);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UpdatePricesResponse) {
                    UpdatePricesResponse updatePricesResponse = (UpdatePricesResponse) obj;
                    return Intrinsics.areEqual(this.country, updatePricesResponse.country) && Intrinsics.areEqual(this.sum, updatePricesResponse.sum) && Intrinsics.areEqual(this.currency, updatePricesResponse.currency);
                }
                return false;
            }

            public int hashCode() {
                return (((this.country.hashCode() * 31) + this.sum.hashCode()) * 31) + this.currency.hashCode();
            }

            public String toString() {
                String str = this.country;
                String str2 = this.sum;
                return "UpdatePricesResponse(country=" + str + ", sum=" + str2 + ", currency=" + this.currency + ")";
            }

            public UpdatePricesResponse(String country, String sum, String currency) {
                Intrinsics.checkNotNullParameter(country, "country");
                Intrinsics.checkNotNullParameter(sum, "sum");
                Intrinsics.checkNotNullParameter(currency, "currency");
                this.country = country;
                this.sum = sum;
                this.currency = currency;
            }

            public final String getCountry() {
                return this.country;
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getSum() {
                return this.sum;
            }
        }

        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$BuyNumberRequest;", "", "country", "", TtmlNode.TAG_REGION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getRegion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class BuyNumberRequest {
            private final String country;
            private final String region;

            public static /* synthetic */ BuyNumberRequest copy$default(BuyNumberRequest buyNumberRequest, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = buyNumberRequest.country;
                }
                if ((i & 2) != 0) {
                    str2 = buyNumberRequest.region;
                }
                return buyNumberRequest.copy(str, str2);
            }

            public final String component1() {
                return this.country;
            }

            public final String component2() {
                return this.region;
            }

            public final BuyNumberRequest copy(String country, String region) {
                Intrinsics.checkNotNullParameter(country, "country");
                Intrinsics.checkNotNullParameter(region, "region");
                return new BuyNumberRequest(country, region);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BuyNumberRequest) {
                    BuyNumberRequest buyNumberRequest = (BuyNumberRequest) obj;
                    return Intrinsics.areEqual(this.country, buyNumberRequest.country) && Intrinsics.areEqual(this.region, buyNumberRequest.region);
                }
                return false;
            }

            public int hashCode() {
                return (this.country.hashCode() * 31) + this.region.hashCode();
            }

            public String toString() {
                String str = this.country;
                return "BuyNumberRequest(country=" + str + ", region=" + this.region + ")";
            }

            public BuyNumberRequest(String country, String region) {
                Intrinsics.checkNotNullParameter(country, "country");
                Intrinsics.checkNotNullParameter(region, "region");
                this.country = country;
                this.region = region;
            }

            public final String getCountry() {
                return this.country;
            }

            public final String getRegion() {
                return this.region;
            }
        }

        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$GeneratedPlateResponse;", "", "number", "", TtmlNode.TAG_REGION, "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getNumber", "()Ljava/lang/String;", "getRegion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$GeneratedPlateResponse;", "equals", "", "other", "hashCode", "toString", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class GeneratedPlateResponse {
            private final String number;
            private final Integer region;

            public GeneratedPlateResponse() {
                this(null, null, 3, null);
            }

            public static /* synthetic */ GeneratedPlateResponse copy$default(GeneratedPlateResponse generatedPlateResponse, String str, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = generatedPlateResponse.number;
                }
                if ((i & 2) != 0) {
                    num = generatedPlateResponse.region;
                }
                return generatedPlateResponse.copy(str, num);
            }

            public final String component1() {
                return this.number;
            }

            public final Integer component2() {
                return this.region;
            }

            public final GeneratedPlateResponse copy(String str, Integer num) {
                return new GeneratedPlateResponse(str, num);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GeneratedPlateResponse) {
                    GeneratedPlateResponse generatedPlateResponse = (GeneratedPlateResponse) obj;
                    return Intrinsics.areEqual(this.number, generatedPlateResponse.number) && Intrinsics.areEqual(this.region, generatedPlateResponse.region);
                }
                return false;
            }

            public int hashCode() {
                String str = this.number;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Integer num = this.region;
                return hashCode + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                String str = this.number;
                return "GeneratedPlateResponse(number=" + str + ", region=" + this.region + ")";
            }

            public GeneratedPlateResponse(String str, Integer num) {
                this.number = str;
                this.region = num;
            }

            public /* synthetic */ GeneratedPlateResponse(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
            }

            public final String getNumber() {
                return this.number;
            }

            public final Integer getRegion() {
                return this.region;
            }
        }
    }

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_VEHICLE_PLATE);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new LicensePlatesScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

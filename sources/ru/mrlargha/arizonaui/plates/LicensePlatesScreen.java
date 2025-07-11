package ru.mrlargha.arizonaui.plates;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.AzAmericanPlateNumberScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzByPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzChooseRegionScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzKzPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzLicencePlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzRusPlateScreenBinding;
import ru.mrlargha.arizonaui.databinding.AzUaPlateScreenBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: LicensePlatesScreen.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u000201B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0012H\u0002J\u0016\u0010)\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "platesScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "platesBinding", "Lru/mrlargha/arizonaui/databinding/AzLicencePlateScreenBinding;", "currentRegion", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlatesRegion;", "usaPlates", "Ljava/util/LinkedList;", FirebaseAnalytics.Param.INDEX, "usaPlatesAction", "", "chooseRegionAction", "installPlateNumber", "number", "", "rusPlatesAction", "uaPlatesAction", "byPlatesAction", "kzPlatesAction", "showKzPlatesScreen", "hideKzPlatesScreen", "showUaPlatesScreen", "hideUaPlatesScreen", "showByPlatesScreen", "hideByPlatesScreen", "showRusPlatesScreen", "hideRusPlatesScreen", "showChooseRegionScreen", "hideChooseRegionScreen", "showUSAPlatesScreen", "hideUSAPlatesScreen", "hideMainScreen", "showMainScreen", "updatePrices", "response", "", "Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$UpdatePricesResponse;", "onBackendMessage", "data", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LicensePlatesScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private Companion.LicensePlatesRegion currentRegion;
    private int index;
    private final AzLicencePlateScreenBinding platesBinding;
    private final ConstraintLayout platesScreen;
    private final LinkedList<Integer> usaPlates;

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        this.usaPlates = linkedList;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        linkedList.addAll(SetsKt.linkedSetOf(Integer.valueOf(R.drawable.number_usa), Integer.valueOf(R.drawable.number_alabama), Integer.valueOf(R.drawable.number_alaska), Integer.valueOf(R.drawable.number_arizona), Integer.valueOf(R.drawable.number_arkansas), Integer.valueOf(R.drawable.number_colorado), Integer.valueOf(R.drawable.number_connecticut), Integer.valueOf(R.drawable.number_delaware), Integer.valueOf(R.drawable.number_florida), Integer.valueOf(R.drawable.number_georgia), Integer.valueOf(R.drawable.number_hawaii), Integer.valueOf(R.drawable.number_idaho), Integer.valueOf(R.drawable.number_illinois), Integer.valueOf(R.drawable.number_indiana), Integer.valueOf(R.drawable.number_iowa), Integer.valueOf(R.drawable.number_kansas), Integer.valueOf(R.drawable.number_louisiane), Integer.valueOf(R.drawable.number_maine), Integer.valueOf(R.drawable.number_maryland), Integer.valueOf(R.drawable.number_massachusetts), Integer.valueOf(R.drawable.number_michigan), Integer.valueOf(R.drawable.number_minnesota), Integer.valueOf(R.drawable.number_mississippi), Integer.valueOf(R.drawable.number_missouri), Integer.valueOf(R.drawable.number_montana), Integer.valueOf(R.drawable.number_nebraska), Integer.valueOf(R.drawable.number_nevada), Integer.valueOf(R.drawable.number_new_hampshire), Integer.valueOf(R.drawable.number_new_jersey), Integer.valueOf(R.drawable.number_new_mexico), Integer.valueOf(R.drawable.number_new_york), Integer.valueOf(R.drawable.number_north_carolina), Integer.valueOf(R.drawable.number_north_dakota), Integer.valueOf(R.drawable.number_ohio), Integer.valueOf(R.drawable.number_oklahoma), Integer.valueOf(R.drawable.number_oregon), Integer.valueOf(R.drawable.number_pennsylvania), Integer.valueOf(R.drawable.number_rhode_island), Integer.valueOf(R.drawable.number_south_carolina), Integer.valueOf(R.drawable.number_south_dakota), Integer.valueOf(R.drawable.number_tennessee), Integer.valueOf(R.drawable.number_texas), Integer.valueOf(R.drawable.number_utah), Integer.valueOf(R.drawable.number_vermont), Integer.valueOf(R.drawable.number_virginia), Integer.valueOf(R.drawable.number_washington), Integer.valueOf(R.drawable.number_west_virginia), Integer.valueOf(R.drawable.number_wisconsin), Integer.valueOf(R.drawable.number_wyoming)));
        bind.usaPlateMainButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.lambda$3$lambda$0(AzLicencePlateScreenBinding.this, this, view);
            }
        });
        bind.sngPlateMainButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.lambda$3$lambda$1(AzLicencePlateScreenBinding.this, this, view);
            }
        });
        bind.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(LicensePlatesScreen.this, 0, 0, null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$3$lambda$0(AzLicencePlateScreenBinding azLicencePlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azLicencePlateScreenBinding.usaPlateMainButton.setAlpha(1.0f);
        azLicencePlateScreenBinding.sngPlateMainButton.setAlpha(0.4f);
        licensePlatesScreen.hideMainScreen();
        licensePlatesScreen.showUSAPlatesScreen();
        licensePlatesScreen.usaPlatesAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$3$lambda$1(AzLicencePlateScreenBinding azLicencePlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azLicencePlateScreenBinding.sngPlateMainButton.setAlpha(1.0f);
        azLicencePlateScreenBinding.usaPlateMainButton.setAlpha(0.4f);
        licensePlatesScreen.hideMainScreen();
        licensePlatesScreen.showChooseRegionScreen();
        licensePlatesScreen.chooseRegionAction();
    }

    private final void usaPlatesAction() {
        final AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding = this.platesBinding.usaPlatesScreen;
        azAmericanPlateNumberScreenBinding.swipeLeftButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$8$lambda$4(LicensePlatesScreen.this, azAmericanPlateNumberScreenBinding, view);
            }
        });
        azAmericanPlateNumberScreenBinding.swipeRightButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$8$lambda$5(LicensePlatesScreen.this, azAmericanPlateNumberScreenBinding, view);
            }
        });
        azAmericanPlateNumberScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$8$lambda$6(LicensePlatesScreen.this, view);
            }
        });
        azAmericanPlateNumberScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.usaPlatesAction$lambda$8$lambda$7(AzAmericanPlateNumberScreenBinding.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$8$lambda$4(LicensePlatesScreen licensePlatesScreen, AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, View view) {
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
    public static final void usaPlatesAction$lambda$8$lambda$5(LicensePlatesScreen licensePlatesScreen, AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, View view) {
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
    public static final void usaPlatesAction$lambda$8$lambda$6(LicensePlatesScreen licensePlatesScreen, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_USA;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("usa", String.valueOf(licensePlatesScreen.index))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void usaPlatesAction$lambda$8$lambda$7(AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azAmericanPlateNumberScreenBinding.plateNumber.setText((CharSequence) null);
        licensePlatesScreen.hideUSAPlatesScreen();
        licensePlatesScreen.showMainScreen();
    }

    private final void chooseRegionAction() {
        final AzChooseRegionScreenBinding azChooseRegionScreenBinding = this.platesBinding.chooseRegionScreen;
        azChooseRegionScreenBinding.chooseRusNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$9(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseByNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$10(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseKzNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$11(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.chooseUaNumbers.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$12(AzChooseRegionScreenBinding.this, view);
            }
        });
        azChooseRegionScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$13(AzChooseRegionScreenBinding.this, this, view);
            }
        });
        azChooseRegionScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.chooseRegionAction$lambda$15$lambda$14(LicensePlatesScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$15$lambda$9(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$15$lambda$10(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$15$lambda$11(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(1.0f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$15$lambda$12(AzChooseRegionScreenBinding azChooseRegionScreenBinding, View view) {
        azChooseRegionScreenBinding.chooseRusNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseKzNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseByNumbers.setAlpha(0.4f);
        azChooseRegionScreenBinding.chooseUaNumbers.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chooseRegionAction$lambda$15$lambda$13(AzChooseRegionScreenBinding azChooseRegionScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
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
    public static final void chooseRegionAction$lambda$15$lambda$14(LicensePlatesScreen licensePlatesScreen, View view) {
        licensePlatesScreen.hideChooseRegionScreen();
        licensePlatesScreen.showMainScreen();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ru.mrlargha.arizonaui.plates.LicensePlatesScreen$installPlateNumber$1$timer$1] */
    private final void installPlateNumber(String str) {
        final TextView textView;
        AzLicencePlateScreenBinding azLicencePlateScreenBinding = this.platesBinding;
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentRegion.ordinal()];
        if (i == 1) {
            textView = azLicencePlateScreenBinding.rusPlateScreen.plateNumber;
        } else if (i == 2) {
            textView = azLicencePlateScreenBinding.uaPlateScreen.plateNumber;
        } else if (i == 3) {
            textView = azLicencePlateScreenBinding.kzPlateScreen.plateNumber;
        } else if (i == 4) {
            textView = azLicencePlateScreenBinding.byPlateScreen.plateNumber;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            textView = azLicencePlateScreenBinding.usaPlatesScreen.plateNumber;
        }
        Intrinsics.checkNotNull(textView);
        final char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        int length = charArray.length;
        String str2 = "";
        if (1 <= length) {
            do {
                length--;
                str2 = str2 + "X";
            } while (1 <= length);
            final char[] charArray2 = str2.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
            textView.setText(new String(charArray2));
            final ValueAnimator ofInt = ValueAnimator.ofInt(0, str.length());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LicensePlatesScreen.installPlateNumber$lambda$17$lambda$16(charArray2, charArray, textView, valueAnimator);
                }
            });
            ofInt.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            ofInt.start();
            new CountDownTimer() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$installPlateNumber$1$timer$1
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 1000L);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    ofInt.cancel();
                    SAMPUIElement.notifyClick$default(this, 0, 2, null, 4, null);
                }
            }.start();
        }
        final char[] charArray22 = str2.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray22, "toCharArray(...)");
        textView.setText(new String(charArray22));
        final ValueAnimator ofInt2 = ValueAnimator.ofInt(0, str.length());
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LicensePlatesScreen.installPlateNumber$lambda$17$lambda$16(charArray22, charArray, textView, valueAnimator);
            }
        });
        ofInt2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        ofInt2.start();
        new CountDownTimer() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$installPlateNumber$1$timer$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ofInt2.cancel();
                SAMPUIElement.notifyClick$default(this, 0, 2, null, 4, null);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installPlateNumber$lambda$17$lambda$16(char[] cArr, char[] cArr2, TextView textView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (intValue != cArr.length) {
            cArr[intValue] = cArr2[intValue];
            textView.setText(new String(cArr));
        }
    }

    private final void rusPlatesAction() {
        final AzRusPlateScreenBinding azRusPlateScreenBinding = this.platesBinding.rusPlateScreen;
        azRusPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.rusPlatesAction$lambda$20$lambda$18(AzRusPlateScreenBinding.this, this, view);
            }
        });
        azRusPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.rusPlatesAction$lambda$20$lambda$19(LicensePlatesScreen.this, azRusPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rusPlatesAction$lambda$20$lambda$18(AzRusPlateScreenBinding azRusPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azRusPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azRusPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideRusPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rusPlatesAction$lambda$20$lambda$19(LicensePlatesScreen licensePlatesScreen, AzRusPlateScreenBinding azRusPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_RUSSIA;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("rus", azRusPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void uaPlatesAction() {
        final AzUaPlateScreenBinding azUaPlateScreenBinding = this.platesBinding.uaPlateScreen;
        azUaPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.uaPlatesAction$lambda$23$lambda$21(AzUaPlateScreenBinding.this, this, view);
            }
        });
        azUaPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.uaPlatesAction$lambda$23$lambda$22(LicensePlatesScreen.this, azUaPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uaPlatesAction$lambda$23$lambda$21(AzUaPlateScreenBinding azUaPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azUaPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azUaPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideUaPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uaPlatesAction$lambda$23$lambda$22(LicensePlatesScreen licensePlatesScreen, AzUaPlateScreenBinding azUaPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_UKRAINE;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("ua", azUaPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void byPlatesAction() {
        final AzByPlateScreenBinding azByPlateScreenBinding = this.platesBinding.byPlateScreen;
        azByPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.byPlatesAction$lambda$26$lambda$24(AzByPlateScreenBinding.this, this, view);
            }
        });
        azByPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.byPlatesAction$lambda$26$lambda$25(LicensePlatesScreen.this, azByPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byPlatesAction$lambda$26$lambda$24(AzByPlateScreenBinding azByPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azByPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azByPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideByPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byPlatesAction$lambda$26$lambda$25(LicensePlatesScreen licensePlatesScreen, AzByPlateScreenBinding azByPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_BELARUS;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("by", azByPlateScreenBinding.enterRegion.getText().toString())));
    }

    private final void kzPlatesAction() {
        final AzKzPlateScreenBinding azKzPlateScreenBinding = this.platesBinding.kzPlateScreen;
        azKzPlateScreenBinding.previousButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.kzPlatesAction$lambda$29$lambda$27(AzKzPlateScreenBinding.this, this, view);
            }
        });
        azKzPlateScreenBinding.completeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.plates.LicensePlatesScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LicensePlatesScreen.kzPlatesAction$lambda$29$lambda$28(LicensePlatesScreen.this, azKzPlateScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kzPlatesAction$lambda$29$lambda$27(AzKzPlateScreenBinding azKzPlateScreenBinding, LicensePlatesScreen licensePlatesScreen, View view) {
        azKzPlateScreenBinding.plateNumber.setText((CharSequence) null);
        azKzPlateScreenBinding.enterRegion.getText().clear();
        licensePlatesScreen.hideKzPlatesScreen();
        licensePlatesScreen.showChooseRegionScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kzPlatesAction$lambda$29$lambda$28(LicensePlatesScreen licensePlatesScreen, AzKzPlateScreenBinding azKzPlateScreenBinding, View view) {
        licensePlatesScreen.currentRegion = Companion.LicensePlatesRegion.COUNTRY_KAZAKHSTAN;
        licensePlatesScreen.notifyClick(0, 1, StringKt.toStringJson(new Companion.BuyNumberRequest("kz", azKzPlateScreenBinding.enterRegion.getText().toString())));
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
                    TextView textView = azLicencePlateScreenBinding.usaPriceText;
                    String sum = updatePricesResponse.getSum();
                    textView.setText("От " + sum + " " + updatePricesResponse.getCurrency() + "-coin");
                } else {
                    TextView textView2 = azLicencePlateScreenBinding.usaPriceText;
                    String sum2 = updatePricesResponse.getSum();
                    textView2.setText("От " + sum2 + " " + updatePricesResponse.getCurrency());
                }
            } else if (Intrinsics.areEqual(updatePricesResponse.getCurrency(), "AZ")) {
                TextView textView3 = azLicencePlateScreenBinding.cisPriceText;
                String sum3 = updatePricesResponse.getSum();
                textView3.setText("От " + sum3 + " " + updatePricesResponse.getCurrency() + "-coin");
            } else {
                TextView textView4 = azLicencePlateScreenBinding.cisPriceText;
                String sum4 = updatePricesResponse.getSum();
                textView4.setText("От " + sum4 + " " + updatePricesResponse.getCurrency());
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            installPlateNumber(data);
        } else if (i != 1) {
        } else {
            updatePrices(MapperKt.toListModel(data, Companion.UpdatePricesResponse.class));
        }
    }

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion;", "", "<init>", "()V", "LicensePlatesRegion", "UpdatePricesResponse", "BuyNumberRequest", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: LicensePlatesScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$LicensePlatesRegion;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "COUNTRY_RUSSIA", "COUNTRY_UKRAINE", "COUNTRY_BELARUS", "COUNTRY_KAZAKHSTAN", "COUNTRY_USA", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
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
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$UpdatePricesResponse;", "", "country", "", "sum", FirebaseAnalytics.Param.CURRENCY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getSum", "getCurrency", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
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
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Companion$BuyNumberRequest;", "", "country", "", TtmlNode.TAG_REGION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getRegion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
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
    }

    /* compiled from: LicensePlatesScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/plates/LicensePlatesScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new LicensePlatesScreen(targetActivity, i);
        }
    }
}

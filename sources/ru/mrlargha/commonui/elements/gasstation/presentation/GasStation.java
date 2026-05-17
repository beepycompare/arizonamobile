package ru.mrlargha.commonui.elements.gasstation.presentation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.GasStationBinding;
import ru.mrlargha.commonui.elements.gasstation.domain.GasStationFuel;
import ru.mrlargha.commonui.elements.gasstation.domain.GasStationShop;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: GasStation.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006."}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/presentation/GasStation;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "gasStation", "Landroidx/constraintlayout/widget/ConstraintLayout;", "gasStationBinding", "Lru/mrlargha/commonui/databinding/GasStationBinding;", "gasStationAdapter", "Lru/mrlargha/commonui/elements/gasstation/presentation/GasStationAdapter;", "commonBorderSize", "gasNow", "fuelType", "Ljava/lang/Integer;", "fuelAmount", FirebaseAnalytics.Param.PRICE, "", "choseFuelCount", "yellowActive", "", "yellowDisable", "greenActive", "greenDisable", "blueActive", "blueDisable", "redActive", "redDisable", "addShopItem", "data", "", "addFuelType", "mapFuelType", "Lru/mrlargha/commonui/elements/gasstation/domain/GasStationFuel;", "onBackendMessageHandled", "subId", "intToBoolean", "", "int", "resetSettings", "Companion", "Spawner", "FuelType", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GasStation extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "GAS STATION";
    private Integer choseFuelCount;
    private final int commonBorderSize;
    private int fuelAmount;
    private Integer fuelType;
    private int gasNow;
    private final ConstraintLayout gasStation;
    private final GasStationAdapter gasStationAdapter;
    private final GasStationBinding gasStationBinding;
    private long price;

    private final boolean intToBoolean(int i) {
        return i != 0 && i == 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GasStation(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.gas_station, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.gasStation = constraintLayout;
        GasStationBinding bind = GasStationBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.gasStationBinding = bind;
        GasStationAdapter gasStationAdapter = new GasStationAdapter(targetActivity);
        this.gasStationAdapter = gasStationAdapter;
        this.commonBorderSize = ConverterKt.dpToPx(1, targetActivity);
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        if (!UtilsKt.isArizonaType()) {
            bind.gsLogoRed.setText("ЛУКОЙЛ");
            bind.gsLogoWhite.setVisibility(8);
            bind.gsFuelCountCurrencyIc.setImageResource(R.drawable.currency_rubble);
        }
        bind.gsShopList.setAdapter(gasStationAdapter);
        bind.gsShopList.setLayoutManager(new LinearLayoutManager(targetActivity, 0, false));
        yellowDisable();
        redDisable();
        blueDisable();
        greenDisable();
        Drawable mutate = bind.gsFuelCountButton.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#58D744"));
        Drawable mutate2 = bind.gsNowContainer.getBackground().mutate();
        Intrinsics.checkNotNull(mutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate2).setColor(Color.parseColor("#10FFFFFF"));
        Drawable mutate3 = bind.gsShopContainer.getBackground().mutate();
        Intrinsics.checkNotNull(mutate3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate3).setCornerRadius(20.0f);
        bind.gsFuelSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ru.mrlargha.commonui.elements.gasstation.presentation.GasStation.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                GasStation.this.gasStationBinding.gsFuelCounter.setText("+" + i2 + "l.");
                GasStation.this.gasStationBinding.gsFuelNowCount.setText((GasStation.this.gasNow + i2) + "l.");
                GasStation.this.gasStationBinding.gsFuelTotalPrice.setText(MoneyElementKt.toMoneyFormattedSpannable$default(i2 * GasStation.this.price, false, null, null, 7, null));
                AppCompatImageView gsFuelCountCurrencyIc = GasStation.this.gasStationBinding.gsFuelCountCurrencyIc;
                Intrinsics.checkNotNullExpressionValue(gsFuelCountCurrencyIc, "gsFuelCountCurrencyIc");
                gsFuelCountCurrencyIc.setVisibility(UtilsKt.isArizonaType() ? 8 : 0);
                GasStation.this.choseFuelCount = Integer.valueOf(i2);
            }
        });
        bind.gsFuelCountButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.gasstation.presentation.GasStation$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GasStation._init_$lambda$1(GasStation.this, view);
            }
        });
        bind.gsCloseButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.gasstation.presentation.GasStation$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GasStation._init_$lambda$2(GasStation.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(GasStation gasStation, View view) {
        Integer num = gasStation.fuelType;
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = gasStation.choseFuelCount;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                Log.i("BUY_FUEL", intValue + StringUtils.COMMA + intValue2);
                IBackendNotifier notifier = gasStation.getNotifier();
                int id = UIElementID.ARIZONA_GAS_STATION.getId();
                byte[] bytes = (intValue + StringUtils.COMMA + intValue2).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                notifier.clickedWrapper(id, -1, 0, bytes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$2(GasStation gasStation, View view) {
        SAMPUIElement.notifyClick$default(gasStation, -1, 2, null, 4, null);
        gasStation.resetSettings();
        gasStation.setVisibility(false);
    }

    private final void yellowActive() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer92.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#FFCB5A");
        gradientDrawable.setColor(Color.parseColor("#10FFCB5A"));
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater92.setColorFilter(parseColor);
        this.gasStationBinding.gsFuelName92.setTextColor(parseColor);
        greenDisable();
        blueDisable();
        redDisable();
        this.fuelType = Integer.valueOf(FuelType.FUEL_92.getId());
    }

    private final void yellowDisable() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer92.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#10FFCB5A");
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater92.setColorFilter(Color.parseColor("#50FFCB5A"));
        this.gasStationBinding.gsFuelName92.setTextColor(parseColor);
    }

    private final void greenActive() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer95.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#8FFF5A");
        gradientDrawable.setColor(Color.parseColor("#108FFF5A"));
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater95.setColorFilter(parseColor);
        this.gasStationBinding.gsFuelName95.setTextColor(parseColor);
        yellowDisable();
        blueDisable();
        redDisable();
        this.fuelType = Integer.valueOf(FuelType.FUEL_95.getId());
    }

    private final void greenDisable() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer95.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#108FFF5A");
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater95.setColorFilter(Color.parseColor("#508FFF5A"));
        this.gasStationBinding.gsFuelName95.setTextColor(parseColor);
    }

    private final void blueActive() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer100.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#5AFFEC");
        gradientDrawable.setColor(Color.parseColor("#105AFFEC"));
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater100.setColorFilter(parseColor);
        this.gasStationBinding.gsFuelName100.setTextColor(parseColor);
        greenDisable();
        yellowDisable();
        redDisable();
        this.fuelType = Integer.valueOf(FuelType.FUEL_98.getId());
    }

    private final void blueDisable() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainer100.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#105AFFEC");
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWater100.setColorFilter(Color.parseColor("#505AFFEC"));
        this.gasStationBinding.gsFuelName100.setTextColor(parseColor);
    }

    private final void redActive() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainerDiesel.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#FF785A");
        gradientDrawable.setColor(Color.parseColor("#10FF785A"));
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWaterDiesel.setColorFilter(parseColor);
        this.gasStationBinding.gsFuelNameDiesel.setTextColor(parseColor);
        greenDisable();
        blueDisable();
        yellowDisable();
        this.fuelType = Integer.valueOf(FuelType.FUEL_DIESEL.getId());
    }

    private final void redDisable() {
        Drawable mutate = this.gasStationBinding.gsFuelTypeContainerDiesel.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        int parseColor = Color.parseColor("#10FF785A");
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(this.commonBorderSize, parseColor);
        this.gasStationBinding.gsWaterDiesel.setColorFilter(Color.parseColor("#50FF785A"));
        this.gasStationBinding.gsFuelNameDiesel.setTextColor(parseColor);
    }

    private final void addShopItem(String str) {
        try {
            this.gasStationAdapter.addShopItem(MapperKt.toListModel(str, GasStationShop.class));
        } catch (Exception unused) {
            Log.w(TAG, "Ошибка при попытке распарсить список магазина");
        }
    }

    private final void addFuelType(String str) {
        try {
            for (GasStationFuel gasStationFuel : MapperKt.toListModel(str, GasStationFuel.class)) {
                mapFuelType(gasStationFuel);
            }
        } catch (Exception unused) {
            Log.w(TAG, "Ошибка при попытке распарсить список магазина");
        }
    }

    private final void mapFuelType(GasStationFuel gasStationFuel) {
        String lowerCase = gasStationFuel.getTitle().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = "АИ-92".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            this.gasStationBinding.gsFuelName92.setText(gasStationFuel.getTitle());
            this.gasStationBinding.gsFuelTypePrice92.setText(getTargetActivity().getString(R.string.common_unavailable_capitalized));
            GasStationBinding gasStationBinding = this.gasStationBinding;
            if (intToBoolean(gasStationFuel.getAvailable())) {
                if (UtilsKt.isArizonaType()) {
                    gasStationBinding.gsFuelTypePrice92.setText(MoneyElementKt.toMoneyFormattedSpannable$default(gasStationFuel.getPrice(), false, null, " /1l.", 3, null));
                } else {
                    gasStationBinding.gsFuelTypePrice92.setText(gasStationFuel.getPrice() + "₽ /1l.");
                }
                this.price = gasStationFuel.getPrice();
                yellowActive();
                return;
            }
            return;
        }
        String lowerCase3 = "АИ-95".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase3)) {
            this.gasStationBinding.gsFuelName95.setText(gasStationFuel.getTitle());
            this.gasStationBinding.gsFuelTypePrice95.setText(getTargetActivity().getString(R.string.common_unavailable_capitalized));
            GasStationBinding gasStationBinding2 = this.gasStationBinding;
            if (intToBoolean(gasStationFuel.getAvailable())) {
                if (UtilsKt.isArizonaType()) {
                    gasStationBinding2.gsFuelTypePrice95.setText(MoneyElementKt.toMoneyFormattedSpannable$default(gasStationFuel.getPrice(), false, null, " /1l.", 3, null));
                } else {
                    gasStationBinding2.gsFuelTypePrice95.setText(gasStationFuel.getPrice() + "₽ /1l.");
                }
                this.price = gasStationFuel.getPrice();
                greenActive();
                return;
            }
            return;
        }
        String lowerCase4 = "АИ-98".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase4)) {
            this.gasStationBinding.gsFuelName100.setText(gasStationFuel.getTitle());
            this.gasStationBinding.gsFuelTypePrice100.setText(getTargetActivity().getString(R.string.common_unavailable_capitalized));
            GasStationBinding gasStationBinding3 = this.gasStationBinding;
            if (intToBoolean(gasStationFuel.getAvailable())) {
                if (UtilsKt.isArizonaType()) {
                    gasStationBinding3.gsFuelTypePrice100.setText(MoneyElementKt.toMoneyFormattedSpannable$default(gasStationFuel.getPrice(), false, null, " /1l.", 3, null));
                } else {
                    gasStationBinding3.gsFuelTypePrice100.setText(gasStationFuel.getPrice() + "₽ /1l.");
                }
                this.price = gasStationFuel.getPrice();
                blueActive();
                return;
            }
            return;
        }
        String lowerCase5 = "Дизель".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase5)) {
            this.gasStationBinding.gsFuelNameDiesel.setText(gasStationFuel.getTitle());
            this.gasStationBinding.gsFuelTypePriceDiesel.setText(getTargetActivity().getString(R.string.common_unavailable_capitalized));
            GasStationBinding gasStationBinding4 = this.gasStationBinding;
            if (intToBoolean(gasStationFuel.getAvailable())) {
                if (UtilsKt.isArizonaType()) {
                    gasStationBinding4.gsFuelTypePriceDiesel.setText(MoneyElementKt.toMoneyFormattedSpannable$default(gasStationFuel.getPrice(), false, null, " /1l.", 3, null));
                } else {
                    gasStationBinding4.gsFuelTypePriceDiesel.setText(gasStationFuel.getPrice() + "₽ /1l.");
                }
                this.price = gasStationFuel.getPrice();
                redActive();
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addFuelType(data);
        } else if (i == 1) {
            addShopItem(data);
        } else if (i == 2) {
            this.gasStationBinding.gsFuelSliderEnd.setText(Integer.parseInt(data) + "l.");
            this.fuelAmount = Integer.parseInt(data);
        } else if (i != 3) {
        } else {
            this.gasStationBinding.gsFuelNowCount.setText(Integer.parseInt(data) + "l.");
            int parseInt = Integer.parseInt(data);
            this.gasNow = parseInt;
            this.fuelAmount -= parseInt;
            this.gasStationBinding.gsFuelSliderEnd.setText(this.fuelAmount + "l.");
            this.gasStationBinding.gsFuelSlider.setMax(this.fuelAmount);
        }
    }

    private final void resetSettings() {
        GasStationBinding gasStationBinding = this.gasStationBinding;
        gasStationBinding.gsFuelSlider.setProgress(0);
        gasStationBinding.gsFuelSliderEnd.setText("100l.");
        gasStationBinding.gsFuelNowCount.setText("0l.");
        gasStationBinding.gsFuelTotalPrice.setText("0");
        blueDisable();
        redDisable();
        greenDisable();
        yellowDisable();
    }

    /* compiled from: GasStation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/presentation/GasStation$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: GasStation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/presentation/GasStation$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_GAS_STATION);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new GasStation(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: GasStation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/presentation/GasStation$FuelType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "FUEL_DIESEL", "FUEL_92", "FUEL_95", "FUEL_98", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class FuelType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FuelType[] $VALUES;
        private final int id;
        public static final FuelType FUEL_DIESEL = new FuelType("FUEL_DIESEL", 0, 0);
        public static final FuelType FUEL_92 = new FuelType("FUEL_92", 1, 1);
        public static final FuelType FUEL_95 = new FuelType("FUEL_95", 2, 2);
        public static final FuelType FUEL_98 = new FuelType("FUEL_98", 3, 3);

        private static final /* synthetic */ FuelType[] $values() {
            return new FuelType[]{FUEL_DIESEL, FUEL_92, FUEL_95, FUEL_98};
        }

        public static EnumEntries<FuelType> getEntries() {
            return $ENTRIES;
        }

        public static FuelType valueOf(String str) {
            return (FuelType) Enum.valueOf(FuelType.class, str);
        }

        public static FuelType[] values() {
            return (FuelType[]) $VALUES.clone();
        }

        private FuelType(String str, int i, int i2) {
            this.id = i2;
        }

        public final int getId() {
            return this.id;
        }

        static {
            FuelType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}

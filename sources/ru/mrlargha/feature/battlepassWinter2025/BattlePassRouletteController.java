package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ru.mrlargha.feature.battlepassWinter2025.data.RouletteData;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRouletteMainScreenBinding;
import ru.mrlargha.feature.battlepassWinter2025.roulette.OldPriseAdapter;
import ru.mrlargha.feature.battlepassWinter2025.roulette.PriseAdapter;
import ru.mrlargha.feature.battlepassWinter2025.roulette.PriseModel;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RoulettePrisesPicasso;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.OldPrise;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.PossiblePrise;
/* compiled from: BattlePassRouletteController.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 92\u00020\u0001:\u00019Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u001e\u001a\u00020\u000fJ\u0014\u0010\u001f\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0014\u0010#\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070!J\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u001aJ\u0014\u0010'\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020(0!J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\"H\u0002J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020.H\u0002J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020.H\u0002J\u0018\u00103\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020.H\u0002J(\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u0010\f\u001a\u00020.2\u0006\u00108\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassRouletteController;", "", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "isArizona", "", "colorText", "", "whiteColor", "notifyClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", TtmlNode.ATTR_ID, "subId", "", "onRouletteOpenChanged", "Lkotlin/Function1;", "<init>", "(Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;ZIILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "priseAdapter", "Lru/mrlargha/feature/battlepassWinter2025/roulette/PriseAdapter;", "oldPriseAdapter", "Lru/mrlargha/feature/battlepassWinter2025/roulette/OldPriseAdapter;", "possiblePrisesList", "", "Lru/mrlargha/feature/battlepassWinter2025/roulette/data/PossiblePrise;", "multiplierBuyRoulette", "isPremRoulette", "rouletteCount", "clear", "setup", "data", "", "Lru/mrlargha/feature/battlepassWinter2025/data/RouletteData;", "spinPrises", "list", "addPossiblePrise", "prise", "updateOldPrises", "Lru/mrlargha/feature/battlepassWinter2025/roulette/data/OldPrise;", "openRoulette", "isPremium", "initRouletteView", "startRoulette", "calcRoulettePrice", "", FirebaseAnalytics.Param.PRICE, "multiplier", FirebaseAnalytics.Param.CURRENCY, "setupRouletteBuySelect", "setupRouletteBuyButton", "showPriseName", "offsetX", "", "offsetY", "width", "Companion", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassRouletteController {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String PRISE_NAME_TAG = "winterbp_prise_name";
    private final WinterBattlepassLayoutBinding binding;
    private final int colorText;
    private boolean isPremRoulette;
    private int multiplierBuyRoulette;
    private final Function2<Integer, Integer, Unit> notifyClick;
    private final OldPriseAdapter oldPriseAdapter;
    private final Function1<Boolean, Unit> onRouletteOpenChanged;
    private List<PossiblePrise> possiblePrisesList;
    private final PriseAdapter priseAdapter;
    private int rouletteCount;
    private final int whiteColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void spinPrises$lambda$1(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BattlePassRouletteController(WinterBattlepassLayoutBinding binding, boolean z, int i, int i2, Function2<? super Integer, ? super Integer, Unit> notifyClick, Function1<? super Boolean, Unit> onRouletteOpenChanged) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifyClick, "notifyClick");
        Intrinsics.checkNotNullParameter(onRouletteOpenChanged, "onRouletteOpenChanged");
        this.binding = binding;
        this.colorText = i;
        this.whiteColor = i2;
        this.notifyClick = notifyClick;
        this.onRouletteOpenChanged = onRouletteOpenChanged;
        this.priseAdapter = new PriseAdapter(new BattlePassRouletteController$priseAdapter$1(this));
        this.oldPriseAdapter = new OldPriseAdapter();
        this.possiblePrisesList = new ArrayList();
        this.multiplierBuyRoulette = 1;
        RoulettePrisesPicasso.INSTANCE.isArizona(z);
    }

    public final void clear() {
        RoulettePrisesPicasso.INSTANCE.clear();
    }

    public final void setup(List<RouletteData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            final RouletteData rouletteData = data.get(0);
            final RouletteData rouletteData2 = data.get(1);
            WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.binding;
            winterBattlepassLayoutBinding.battlepassRoulettePage.roulettePageSaleText.setText(rouletteData2.getDescription());
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRouletteUsualCount.setText(String.valueOf(rouletteData.getTotal()));
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRoulettePremCount.setText(String.valueOf(rouletteData2.getTotal()));
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRouletteUsualButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BattlePassRouletteController.this.openRoulette(false, rouletteData);
                }
            });
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRoulettePremButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BattlePassRouletteController.this.openRoulette(true, rouletteData2);
                }
            });
            if (this.isPremRoulette) {
                winterBattlepassLayoutBinding.battlepassRouletteView.attempsCount.setText(String.valueOf(rouletteData2.getTotal()));
                this.rouletteCount = rouletteData2.getTotal();
                return;
            }
            winterBattlepassLayoutBinding.battlepassRouletteView.attempsCount.setText(String.valueOf(rouletteData.getTotal()));
            this.rouletteCount = rouletteData.getTotal();
        } catch (Exception unused) {
        }
    }

    public final void spinPrises(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Number number : list2) {
            arrayList.add(new PriseModel(number.intValue()));
        }
        this.binding.clickBlocker.setVisibility(0);
        this.binding.clickBlocker.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.spinPrises$lambda$1(view);
            }
        });
        this.binding.battlepassRouletteView.rouletteView.start(arrayList, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BattlePassRouletteController.spinPrises$lambda$2(BattlePassRouletteController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit spinPrises$lambda$2(BattlePassRouletteController battlePassRouletteController) {
        battlePassRouletteController.notifyClick.invoke(0, 18);
        battlePassRouletteController.binding.clickBlocker.setVisibility(8);
        return Unit.INSTANCE;
    }

    public final void addPossiblePrise(PossiblePrise prise) {
        Intrinsics.checkNotNullParameter(prise, "prise");
        PossiblePrise copy$default = PossiblePrise.copy$default(prise, 0, null, null, 0, StringsKt.replace$default(prise.getImage(), ".webp", "", false, 4, (Object) null), 15, null);
        RoulettePrisesPicasso.INSTANCE.addPrise(copy$default);
        this.possiblePrisesList.add(copy$default);
        this.priseAdapter.addPrise(copy$default);
        this.binding.battlepassRouletteView.rouletteView.notifyAdapter();
    }

    public final void updateOldPrises(List<OldPrise> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.battlepassRouletteView.oldPriseEmpty.setVisibility(8);
        this.binding.battlepassRouletteView.oldPriseRv.setVisibility(0);
        OldPriseAdapter oldPriseAdapter = this.oldPriseAdapter;
        List<OldPrise> list = data;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (OldPrise oldPrise : list) {
            arrayList.add(OldPrise.copy$default(oldPrise, 0, null, null, 0, StringsKt.replace$default(oldPrise.getImage(), ".webp", "", false, 4, (Object) null), 0L, 47, null));
        }
        oldPriseAdapter.setPriseList(CollectionsKt.reversed(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openRoulette(boolean z, RouletteData rouletteData) {
        this.possiblePrisesList.clear();
        RoulettePrisesPicasso.INSTANCE.clear();
        this.priseAdapter.clearPriseList();
        this.notifyClick.invoke(Integer.valueOf(z ? 1 : 0), 12);
        this.binding.battlepassRoulettePage.getRoot().setVisibility(8);
        this.binding.battlepassRouletteView.getRoot().setVisibility(0);
        initRouletteView(z, rouletteData);
        this.isPremRoulette = z;
    }

    private final void initRouletteView(boolean z, RouletteData rouletteData) {
        this.onRouletteOpenChanged.invoke(true);
        WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding = this.binding.battlepassRouletteView;
        if (z) {
            String name = rouletteData.getName();
            if (name != null && name.length() != 0) {
                winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setText(rouletteData.getName());
                winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setText(rouletteData.getName());
            }
            winterBattlepassRouletteMainScreenBinding.btnBuy.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_blue);
            winterBattlepassRouletteMainScreenBinding.tvBuy.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setTextColor(this.whiteColor);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIcon.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIconTop.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
            winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
            winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
        } else {
            winterBattlepassRouletteMainScreenBinding.btnBuy.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_white);
            winterBattlepassRouletteMainScreenBinding.tvBuy.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIcon.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIconTop.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
            winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
            winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        }
        winterBattlepassRouletteMainScreenBinding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.initRouletteView$lambda$0$0(BattlePassRouletteController.this, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btnSprint.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.this.startRoulette();
            }
        });
        if (z) {
            TextView textView = winterBattlepassRouletteMainScreenBinding.buttonPrice;
            int price = rouletteData.getPrice();
            int i = this.multiplierBuyRoulette;
            String name2 = rouletteData.getName();
            if (name2 == null) {
                name2 = "";
            }
            textView.setText(calcRoulettePrice(price, i, name2));
            TextView textView2 = winterBattlepassRouletteMainScreenBinding.textPrice;
            int price2 = rouletteData.getPrice();
            String name3 = rouletteData.getName();
            if (name3 == null) {
                name3 = "";
            }
            textView2.setText(calcRoulettePrice(price2, 1, name3));
        } else {
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(String.valueOf(rouletteData.getPrice()));
            winterBattlepassRouletteMainScreenBinding.textPrice.setText(String.valueOf(rouletteData.getPrice()));
        }
        winterBattlepassRouletteMainScreenBinding.attempsCount.setText(String.valueOf(rouletteData.getTotal()));
        this.rouletteCount = rouletteData.getTotal();
        winterBattlepassRouletteMainScreenBinding.rouletteView.isPremium(z, new Function1() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initRouletteView$lambda$0$2;
                initRouletteView$lambda$0$2 = BattlePassRouletteController.initRouletteView$lambda$0$2(BattlePassRouletteController.this, ((Integer) obj).intValue());
                return initRouletteView$lambda$0$2;
            }
        });
        winterBattlepassRouletteMainScreenBinding.priseListRv.setAdapter(this.priseAdapter);
        int price3 = rouletteData.getPrice();
        String name4 = rouletteData.getName();
        if (name4 == null) {
            name4 = "";
        }
        setupRouletteBuySelect(price3, name4);
        int price4 = rouletteData.getPrice();
        String name5 = rouletteData.getName();
        setupRouletteBuyButton(price4, name5 != null ? name5 : "");
        winterBattlepassRouletteMainScreenBinding.oldPriseRv.setAdapter(this.oldPriseAdapter);
        this.oldPriseAdapter.setPriseList(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRouletteView$lambda$0$0(BattlePassRouletteController battlePassRouletteController, View view) {
        battlePassRouletteController.binding.battlepassRoulettePage.getRoot().setVisibility(0);
        battlePassRouletteController.binding.battlepassRouletteView.getRoot().setVisibility(8);
        battlePassRouletteController.notifyClick.invoke(2, 11);
        battlePassRouletteController.onRouletteOpenChanged.invoke(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRouletteView$lambda$0$2(BattlePassRouletteController battlePassRouletteController, int i) {
        battlePassRouletteController.notifyClick.invoke(Integer.valueOf(i), 14);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRoulette() {
        int i = this.rouletteCount;
        if (i > 0) {
            this.rouletteCount = i - 1;
            this.binding.battlepassRouletteView.attempsCount.setText(String.valueOf(this.rouletteCount));
            this.notifyClick.invoke(0, 13);
        }
    }

    private final String calcRoulettePrice(int i, int i2, String str) {
        int i3 = i * i2;
        String str2 = str;
        if ((str2.length() == 0) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "RUB", false, 2, (Object) null)) {
            return String.valueOf(i3);
        }
        if (i3 >= 1000000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1fкк", Arrays.copyOf(new Object[]{Double.valueOf(i3 / 1000000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return StringsKt.replace$default(format, StringUtils.COMMA, ".", false, 4, (Object) null);
        } else if (i3 >= 1000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1fк", Arrays.copyOf(new Object[]{Double.valueOf(i3 / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return StringsKt.replace$default(format2, StringUtils.COMMA, ".", false, 4, (Object) null);
        } else {
            return String.valueOf(i3);
        }
    }

    private final void setupRouletteBuySelect(final int i, final String str) {
        final int i2 = this.colorText;
        final int i3 = this.whiteColor;
        final WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding = this.binding.battlepassRouletteView;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i3);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i3);
        this.multiplierBuyRoulette = 1;
        winterBattlepassRouletteMainScreenBinding.btn1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.setupRouletteBuySelect$lambda$0$0(BattlePassRouletteController.this, winterBattlepassRouletteMainScreenBinding, i2, i3, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btn2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.setupRouletteBuySelect$lambda$0$1(BattlePassRouletteController.this, winterBattlepassRouletteMainScreenBinding, i3, i2, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btn3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.setupRouletteBuySelect$lambda$0$2(BattlePassRouletteController.this, winterBattlepassRouletteMainScreenBinding, i3, i2, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(calcRoulettePrice(i, this.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRouletteBuySelect$lambda$0$0(BattlePassRouletteController battlePassRouletteController, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        battlePassRouletteController.multiplierBuyRoulette = 1;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(battlePassRouletteController.calcRoulettePrice(i3, battlePassRouletteController.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRouletteBuySelect$lambda$0$1(BattlePassRouletteController battlePassRouletteController, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        battlePassRouletteController.multiplierBuyRoulette = 5;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(battlePassRouletteController.calcRoulettePrice(i3, battlePassRouletteController.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRouletteBuySelect$lambda$0$2(BattlePassRouletteController battlePassRouletteController, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        battlePassRouletteController.multiplierBuyRoulette = 10;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(battlePassRouletteController.calcRoulettePrice(i3, battlePassRouletteController.multiplierBuyRoulette, str));
    }

    private final void setupRouletteBuyButton(final int i, final String str) {
        this.binding.battlepassRouletteView.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.setupRouletteBuyButton$lambda$0$0(BattlePassRouletteController.this, i, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRouletteBuyButton$lambda$0$0(BattlePassRouletteController battlePassRouletteController, int i, String str, View view) {
        battlePassRouletteController.notifyClick.invoke(Integer.valueOf(battlePassRouletteController.multiplierBuyRoulette), 16);
        battlePassRouletteController.setupRouletteBuySelect(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPriseName(float f, float f2, String str, int i) {
        View findViewWithTag = this.binding.getRoot().findViewWithTag(PRISE_NAME_TAG);
        if (findViewWithTag == null) {
            View inflate = View.inflate(this.binding.getRoot().getContext(), R.layout.winter_battlepass_roulette_prise_name_item, null);
            inflate.setTag(PRISE_NAME_TAG);
            inflate.setX(f - this.binding.getRoot().getPaddingLeft());
            inflate.setY(f2 - this.binding.getRoot().getPaddingTop());
            inflate.setLayoutParams(new ViewGroup.LayoutParams(i, -2));
            ((TextView) inflate.findViewById(R.id.tv_prise_name)).setText(str);
            this.binding.getRoot().addView(inflate);
        } else {
            findViewWithTag.setVisibility(0);
            findViewWithTag.setX(f - 50.0f);
            findViewWithTag.setY(f2);
            ((TextView) findViewWithTag.findViewById(R.id.tv_prise_name)).setText(str);
        }
        this.binding.clickBlocker.setVisibility(0);
        this.binding.clickBlocker.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassRouletteController.showPriseName$lambda$0(BattlePassRouletteController.this, r2, view);
            }
        });
        this.binding.battlepassRouletteView.priseListRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassRouletteController$showPriseName$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                WinterBattlepassLayoutBinding winterBattlepassLayoutBinding;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                winterBattlepassLayoutBinding = BattlePassRouletteController.this.binding;
                View findViewWithTag2 = winterBattlepassLayoutBinding.getRoot().findViewWithTag(r2);
                if (findViewWithTag2 != null) {
                    findViewWithTag2.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showPriseName$lambda$0(BattlePassRouletteController battlePassRouletteController, String str, View view) {
        View findViewWithTag = battlePassRouletteController.binding.getRoot().findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
        battlePassRouletteController.binding.clickBlocker.setVisibility(8);
    }

    /* compiled from: BattlePassRouletteController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassRouletteController$Companion;", "", "<init>", "()V", "PRISE_NAME_TAG", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

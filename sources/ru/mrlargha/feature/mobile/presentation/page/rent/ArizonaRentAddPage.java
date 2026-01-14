package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.graphics.Color;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.compose.runtime.ComposerImplKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import com.arizona.common.utils.EasyAnimation;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
import ru.mrlargha.commonui.utils.ui.EditTextValidationBuilder;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAddPageBinding;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.feature.mobile.presentation.HistoryManager;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.MobilePage;
import ru.mrlargha.feature.mobile.presentation.MobilePhoneGetSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentRealEstateAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentCreateAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentLimitModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel;
/* compiled from: ArizonaRentAddPage.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentAddPage;", "Lru/mrlargha/feature/mobile/presentation/MobilePage;", "<init>", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "binding", "Lru/mrlargha/feature/mobile/databinding/MpArizonaRentAddPageBinding;", "isFully", "", "inputFormat", "Lkotlin/Pair;", "", "inputFormatCost", "scope", "Lkotlinx/coroutines/CoroutineScope;", "adState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentCreateAdModel;", "adJob", "Lkotlinx/coroutines/Job;", "currentRealEstate", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentRealEstateModel;", "isFirstOpen", "sendEvent", "", "subId", "Lru/mrlargha/feature/mobile/presentation/MobilePhoneGetSubIds;", "data", "", "setLimits", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentLimitModel;", "setAvailableRealEstateList", "", "hidePage", "renderPage", "initialize", "setDefaultPage", "setupListeners", "setDefaultButtons", "checkIsFully", "checkIsRoom", "checkToFrom", "isError", "showError", "customCardView", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "checkSelectedRealEstate", "setupControllers", "updateLimitData", "Lru/mrlargha/commonui/utils/ui/EditTextValidationBuilder;", "checkEditTexts", "Companion", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentAddPage extends MobilePage {
    private Job adJob;
    private final MutableStateFlow<ArizonaRentCreateAdModel> adState;
    private final MpArizonaRentAddPageBinding binding;
    private ArizonaRentRealEstateModel currentRealEstate;
    private Pair<Integer, Integer> inputFormat;
    private Pair<Integer, Integer> inputFormatCost;
    private boolean isFirstOpen;
    private boolean isFully;
    private final CoroutineScope scope;
    private final View view;
    public static final Companion Companion = new Companion(null);
    private static int MAX_CHAR_COUNT = 70;
    private static Pair<Integer, Integer> DATA_INPUT_LIMIT_FULLY = TuplesKt.to(1, 90);
    private static Pair<Integer, Integer> DATA_INPUT_LIMIT_ROOM = TuplesKt.to(1, 720);
    private static Pair<Integer, Integer> DATA_INPUT_LIMIT_COST_FULLY = TuplesKt.to(200000, 50000000);
    private static Pair<Integer, Integer> DATA_INPUT_LIMIT_COST_ROOM = TuplesKt.to(10000, 1000000);

    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MobilePhoneGetSubIds.values().length];
            try {
                iArr[MobilePhoneGetSubIds.RENT_REAL_ESTATE_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArizonaRentAddPage() {
        super(MobilePhonePage.ARIZONA_RENT_ADD.getId());
        this.isFully = true;
        this.inputFormat = DATA_INPUT_LIMIT_FULLY;
        this.inputFormatCost = DATA_INPUT_LIMIT_COST_FULLY;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.adState = StateFlowKt.MutableStateFlow(new ArizonaRentCreateAdModel(null, null, null, null, null, null, 63, null));
        this.currentRealEstate = new ArizonaRentRealEstateModel(0, null, 0, 0, 0, 0, 0, 127, null);
        this.isFirstOpen = true;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONA_RENT_ADD.getId());
        View inflate = getContext().getLayoutInflater().inflate(R.layout.mp_arizona_rent_add_page, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.view = inflate;
        MpArizonaRentAddPageBinding bind = MpArizonaRentAddPageBinding.bind(getView());
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        bind.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        ImageView btnAdd = bind.topBar.btnAdd;
        Intrinsics.checkNotNullExpressionValue(btnAdd, "btnAdd");
        btnAdd.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public View getView() {
        return this.view;
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void sendEvent(MobilePhoneGetSubIds subId, String data) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(data, "data");
        int i = WhenMappings.$EnumSwitchMapping$0[subId.ordinal()];
        if (i == 1) {
            setAvailableRealEstateList(MapperKt.toListModel(data, ArizonaRentRealEstateModel.class));
        } else if (i != 2) {
        } else {
            if (MapperKt.isJsonValid(data)) {
                setLimits((ArizonaRentLimitModel) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) ArizonaRentLimitModel.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        }
    }

    private final void setLimits(ArizonaRentLimitModel arizonaRentLimitModel) {
        MAX_CHAR_COUNT = arizonaRentLimitModel.getDescMax();
        DATA_INPUT_LIMIT_FULLY = TuplesKt.to(Integer.valueOf(arizonaRentLimitModel.getFullValueMin()), Integer.valueOf(arizonaRentLimitModel.getFullValueMax()));
        DATA_INPUT_LIMIT_ROOM = TuplesKt.to(Integer.valueOf(arizonaRentLimitModel.getRoomValueMin()), Integer.valueOf(arizonaRentLimitModel.getRoomValueMax()));
        DATA_INPUT_LIMIT_COST_FULLY = TuplesKt.to(Integer.valueOf(arizonaRentLimitModel.m12519getFullostMin()), Integer.valueOf(arizonaRentLimitModel.getFullCostMax()));
        DATA_INPUT_LIMIT_COST_ROOM = TuplesKt.to(Integer.valueOf(arizonaRentLimitModel.m12520getRoomostMin()), Integer.valueOf(arizonaRentLimitModel.getRoomCostMax()));
    }

    private final void setAvailableRealEstateList(List<ArizonaRentRealEstateModel> list) {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        String string = getContext().getString(R.string.open_list);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ArizonaRentRealEstateModel arizonaRentRealEstateModel = new ArizonaRentRealEstateModel(0, string, 0, 0, 0, 0, 0, ComposerImplKt.nodeKey, null);
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(arizonaRentRealEstateModel);
        mpArizonaRentAddPageBinding.spinnerRealEstate.setAdapter((SpinnerAdapter) new ArizonaRentRealEstateAdapter(getContext(), mutableList));
        mpArizonaRentAddPageBinding.spinnerRealEstate.setSelection(mutableList.size() - 1);
        mpArizonaRentAddPageBinding.spinnerRealEstate.setPopupBackgroundResource(R.drawable.mp_arizona_rent_spinner_bg);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void hidePage() {
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage, ru.mrlargha.feature.mobile.presentation.MobileController
    public void renderPage() {
        super.renderPage();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        this.isFirstOpen = true;
        initialize();
    }

    private final void initialize() {
        getMobilePhone().getBinding().phoneBackground.setBackgroundColor(Color.parseColor("#131516"));
        setupListeners();
        setupControllers();
        setDefaultPage();
        setDefaultButtons();
    }

    private final void setDefaultPage() {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        this.isFully = true;
        this.inputFormat = DATA_INPUT_LIMIT_FULLY;
        this.inputFormatCost = DATA_INPUT_LIMIT_COST_FULLY;
        mpArizonaRentAddPageBinding.tvDescOutOf.setText(getContext().getString(R.string.out_of, new Object[]{0, Integer.valueOf(MAX_CHAR_COUNT)}));
        mpArizonaRentAddPageBinding.spinnerRealEstate.clearFocus();
        mpArizonaRentAddPageBinding.etDesc.setText((CharSequence) null);
        mpArizonaRentAddPageBinding.etFrom.setText((CharSequence) null);
        mpArizonaRentAddPageBinding.etTo.setText((CharSequence) null);
        mpArizonaRentAddPageBinding.etCost.setText((CharSequence) null);
        mpArizonaRentAddPageBinding.tvDesc.setText((CharSequence) null);
        checkSelectedRealEstate();
        for (CustomCardView customCardView : CollectionsKt.listOf((Object[]) new CustomCardView[]{mpArizonaRentAddPageBinding.descContainer, mpArizonaRentAddPageBinding.toContainer, mpArizonaRentAddPageBinding.fromContainer, mpArizonaRentAddPageBinding.costContainer})) {
            Intrinsics.checkNotNull(customCardView);
            isError(false, customCardView);
        }
        for (TextView textView : CollectionsKt.listOf((Object[]) new TextView[]{mpArizonaRentAddPageBinding.tvCostError, mpArizonaRentAddPageBinding.tvDataError, mpArizonaRentAddPageBinding.tvDescError})) {
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
        }
    }

    private final void setupListeners() {
        final MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView btnBack = mpArizonaRentAddPageBinding.topBar.btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack, "btnBack");
        EasyAnimation.animateClick$default(easyAnimation, btnBack, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$0(ArizonaRentAddPage.this);
                return unit;
            }
        }, 3, null);
        mpArizonaRentAddPageBinding.btnFully.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaRentAddPage.setupListeners$lambda$0$1(ArizonaRentAddPage.this, view);
            }
        });
        mpArizonaRentAddPageBinding.btnRoom.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaRentAddPage.setupListeners$lambda$0$2(ArizonaRentAddPage.this, view);
            }
        });
        CustomEditText etDesc = mpArizonaRentAddPageBinding.etDesc;
        Intrinsics.checkNotNullExpressionValue(etDesc, "etDesc");
        CustomCardView descContainer = mpArizonaRentAddPageBinding.descContainer;
        Intrinsics.checkNotNullExpressionValue(descContainer, "descContainer");
        TextView tvDescError = mpArizonaRentAddPageBinding.tvDescError;
        Intrinsics.checkNotNullExpressionValue(tvDescError, "tvDescError");
        ArizonaRentResponseKt.onChangeListeners$default(etDesc, false, 0, 0, descContainer, tvDescError, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$3(MpArizonaRentAddPageBinding.this, this, (Editable) obj);
                return unit;
            }
        }, 7, null);
        CustomEditText etCost = mpArizonaRentAddPageBinding.etCost;
        Intrinsics.checkNotNullExpressionValue(etCost, "etCost");
        int intValue = this.inputFormatCost.getSecond().intValue();
        int intValue2 = this.inputFormatCost.getFirst().intValue();
        CustomCardView costContainer = mpArizonaRentAddPageBinding.costContainer;
        Intrinsics.checkNotNullExpressionValue(costContainer, "costContainer");
        TextView tvCostError = mpArizonaRentAddPageBinding.tvCostError;
        Intrinsics.checkNotNullExpressionValue(tvCostError, "tvCostError");
        ArizonaRentResponseKt.onChangeListeners$default(etCost, false, intValue2, intValue, costContainer, tvCostError, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$4(ArizonaRentAddPage.this, (Editable) obj);
                return unit;
            }
        }, 1, null);
        CustomEditText etFrom = mpArizonaRentAddPageBinding.etFrom;
        Intrinsics.checkNotNullExpressionValue(etFrom, "etFrom");
        int intValue3 = this.inputFormat.getSecond().intValue();
        int intValue4 = this.inputFormat.getFirst().intValue();
        CustomCardView fromContainer = mpArizonaRentAddPageBinding.fromContainer;
        Intrinsics.checkNotNullExpressionValue(fromContainer, "fromContainer");
        TextView tvDataError = mpArizonaRentAddPageBinding.tvDataError;
        Intrinsics.checkNotNullExpressionValue(tvDataError, "tvDataError");
        ArizonaRentResponseKt.onChangeListeners$default(etFrom, false, intValue4, intValue3, fromContainer, tvDataError, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$5(ArizonaRentAddPage.this, (Editable) obj);
                return unit;
            }
        }, 1, null);
        CustomEditText etTo = mpArizonaRentAddPageBinding.etTo;
        Intrinsics.checkNotNullExpressionValue(etTo, "etTo");
        int intValue5 = this.inputFormat.getSecond().intValue();
        int intValue6 = this.inputFormat.getFirst().intValue();
        CustomCardView toContainer = mpArizonaRentAddPageBinding.toContainer;
        Intrinsics.checkNotNullExpressionValue(toContainer, "toContainer");
        TextView tvDataError2 = mpArizonaRentAddPageBinding.tvDataError;
        Intrinsics.checkNotNullExpressionValue(tvDataError2, "tvDataError");
        ArizonaRentResponseKt.onChangeListeners$default(etTo, false, intValue6, intValue5, toContainer, tvDataError2, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$6(ArizonaRentAddPage.this, (Editable) obj);
                return unit;
            }
        }, 1, null);
        mpArizonaRentAddPageBinding.spinnerRealEstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$setupListeners$1$8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long j) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(parent, "parent");
                coroutineScope = ArizonaRentAddPage.this.scope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ArizonaRentAddPage$setupListeners$1$8$onItemSelected$1(mpArizonaRentAddPageBinding, ArizonaRentAddPage.this, null), 3, null);
            }
        });
        mpArizonaRentAddPageBinding.btnCreateAd.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaRentAddPage.setupListeners$lambda$0$7(ArizonaRentAddPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$0(ArizonaRentAddPage arizonaRentAddPage) {
        arizonaRentAddPage.navigateTo(MobilePhonePage.ARIZONA_RENT.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(ArizonaRentAddPage arizonaRentAddPage, View view) {
        arizonaRentAddPage.isFirstOpen = false;
        arizonaRentAddPage.checkIsFully();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(ArizonaRentAddPage arizonaRentAddPage, View view) {
        arizonaRentAddPage.isFirstOpen = false;
        arizonaRentAddPage.checkIsRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$3(final MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, final ArizonaRentAddPage arizonaRentAddPage, Editable editable) {
        String valueOf = String.valueOf(editable);
        int length = valueOf.length();
        int i = MAX_CHAR_COUNT;
        if (length > i) {
            String take = StringsKt.take(valueOf, i);
            mpArizonaRentAddPageBinding.etDesc.setText(take);
            mpArizonaRentAddPageBinding.etDesc.setSelection(take.length());
        }
        if (String.valueOf(editable).length() == 0) {
            mpArizonaRentAddPageBinding.tvDescOutOf.setText(arizonaRentAddPage.getContext().getString(R.string.out_of, new Object[]{0, Integer.valueOf(MAX_CHAR_COUNT)}));
        } else {
            mpArizonaRentAddPageBinding.tvDescOutOf.setText(arizonaRentAddPage.getContext().getString(R.string.out_of, new Object[]{Integer.valueOf(valueOf.length()), Integer.valueOf(MAX_CHAR_COUNT)}));
        }
        if (editable == null) {
            mpArizonaRentAddPageBinding.tvDesc.setText("");
        } else {
            mpArizonaRentAddPageBinding.tvDesc.setText(StringsKt.replace$default(StringsKt.replace$default(editable.toString(), "\n", " ", false, 4, (Object) null), "\r", " ", false, 4, (Object) null));
        }
        CustomEditText etDesc = mpArizonaRentAddPageBinding.etDesc;
        Intrinsics.checkNotNullExpressionValue(etDesc, "etDesc");
        ArizonaRentResponseKt.checkAvailableData$default(etDesc, null, null, false, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = ArizonaRentAddPage.setupListeners$lambda$0$3$0(ArizonaRentAddPage.this, mpArizonaRentAddPageBinding, (EditTextCheckResult) obj);
                return unit;
            }
        }, 7, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$3$0(ArizonaRentAddPage arizonaRentAddPage, MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding, EditTextCheckResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.launch$default(arizonaRentAddPage.scope, null, null, new ArizonaRentAddPage$setupListeners$1$4$1$1(result, arizonaRentAddPage, mpArizonaRentAddPageBinding, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$4(ArizonaRentAddPage arizonaRentAddPage, Editable editable) {
        BuildersKt__Builders_commonKt.launch$default(arizonaRentAddPage.scope, null, null, new ArizonaRentAddPage$setupListeners$1$5$1(arizonaRentAddPage, editable, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$5(ArizonaRentAddPage arizonaRentAddPage, Editable editable) {
        BuildersKt__Builders_commonKt.launch$default(arizonaRentAddPage.scope, null, null, new ArizonaRentAddPage$setupListeners$1$6$1(arizonaRentAddPage, editable, null), 3, null);
        arizonaRentAddPage.checkToFrom();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$6(ArizonaRentAddPage arizonaRentAddPage, Editable editable) {
        BuildersKt__Builders_commonKt.launch$default(arizonaRentAddPage.scope, null, null, new ArizonaRentAddPage$setupListeners$1$7$1(arizonaRentAddPage, editable, null), 3, null);
        arizonaRentAddPage.checkToFrom();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$7(ArizonaRentAddPage arizonaRentAddPage, View view) {
        MobilePage.sendFrontendMessage$default(arizonaRentAddPage, MobilePHoneSendSubIds.RENT_ADD_AD.getSubIds(), 0, StringKt.toStringJson(arizonaRentAddPage.adState.getValue()), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDefaultButtons() {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        mpArizonaRentAddPageBinding.btnRoom.setEnabled(true);
        mpArizonaRentAddPageBinding.btnFully.setEnabled(true);
        mpArizonaRentAddPageBinding.btnRoom.setAlpha(1.0f);
        mpArizonaRentAddPageBinding.btnFully.setAlpha(1.0f);
    }

    private final void checkIsFully() {
        if (this.currentRealEstate.isApartment() || this.isFully) {
            return;
        }
        this.isFully = true;
        checkSelectedRealEstate();
    }

    private final void checkIsRoom() {
        if (this.currentRealEstate.getRoomCount() > 0 && this.currentRealEstate.getAvailableRoomCount() > 0) {
            if (this.isFully) {
                this.isFully = false;
                checkSelectedRealEstate();
                return;
            }
            return;
        }
        Toast.makeText(getContext(), getContext().getString(R.string.not_room), 0).show();
    }

    private final boolean checkToFrom() {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(mpArizonaRentAddPageBinding.etFrom.getText()));
        Integer intOrNull2 = StringsKt.toIntOrNull(String.valueOf(mpArizonaRentAddPageBinding.etTo.getText()));
        if (intOrNull != null && intOrNull2 != null) {
            if (intOrNull.intValue() > intOrNull2.intValue()) {
                TextView tvDataError = mpArizonaRentAddPageBinding.tvDataError;
                Intrinsics.checkNotNullExpressionValue(tvDataError, "tvDataError");
                tvDataError.setVisibility(0);
                CustomCardView fromContainer = mpArizonaRentAddPageBinding.fromContainer;
                Intrinsics.checkNotNullExpressionValue(fromContainer, "fromContainer");
                isError(true, fromContainer);
                CustomCardView toContainer = mpArizonaRentAddPageBinding.toContainer;
                Intrinsics.checkNotNullExpressionValue(toContainer, "toContainer");
                isError(true, toContainer);
                BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new ArizonaRentAddPage$checkToFrom$1$1(this, null), 2, null);
                return true;
            }
            TextView tvDataError2 = mpArizonaRentAddPageBinding.tvDataError;
            Intrinsics.checkNotNullExpressionValue(tvDataError2, "tvDataError");
            tvDataError2.setVisibility(8);
            CustomCardView fromContainer2 = mpArizonaRentAddPageBinding.fromContainer;
            Intrinsics.checkNotNullExpressionValue(fromContainer2, "fromContainer");
            isError(false, fromContainer2);
            CustomCardView toContainer2 = mpArizonaRentAddPageBinding.toContainer;
            Intrinsics.checkNotNullExpressionValue(toContainer2, "toContainer");
            isError(false, toContainer2);
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new ArizonaRentAddPage$checkToFrom$1$2(this, intOrNull2, intOrNull, null), 2, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void isError(boolean z, CustomCardView customCardView) {
        Log.d("arizona_rent", "isError: " + z + " " + customCardView);
        if (z) {
            customCardView.setBorder(SupportMenu.CATEGORY_MASK);
        } else {
            customCardView.setBorder(Color.parseColor("#1AFFFFFF"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job checkSelectedRealEstate() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ArizonaRentAddPage$checkSelectedRealEstate$1$1(this, this.binding, null), 3, null);
        return launch$default;
    }

    private final void setupControllers() {
        Job launch$default;
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        Job job = this.adJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ArizonaRentAddPage$setupControllers$1$1(this, mpArizonaRentAddPageBinding, null), 3, null);
        this.adJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditTextValidationBuilder updateLimitData() {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        Log.d("arizona_rent", "updateLimitData: " + this.inputFormat);
        mpArizonaRentAddPageBinding.etCost.getEditTextValidationBuilder().setMaxInputCount(this.inputFormatCost.getSecond().intValue()).setMinInputCount(this.inputFormatCost.getFirst().intValue());
        mpArizonaRentAddPageBinding.etTo.getEditTextValidationBuilder().setMaxInputCount(this.inputFormat.getSecond().intValue()).setMinInputCount(this.inputFormat.getFirst().intValue());
        return mpArizonaRentAddPageBinding.etFrom.getEditTextValidationBuilder().setMaxInputCount(this.inputFormat.getSecond().intValue()).setMinInputCount(this.inputFormat.getFirst().intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkEditTexts() {
        MpArizonaRentAddPageBinding mpArizonaRentAddPageBinding = this.binding;
        CustomEditText etCost = mpArizonaRentAddPageBinding.etCost;
        Intrinsics.checkNotNullExpressionValue(etCost, "etCost");
        CustomCardView costContainer = mpArizonaRentAddPageBinding.costContainer;
        Intrinsics.checkNotNullExpressionValue(costContainer, "costContainer");
        TextView tvCost = mpArizonaRentAddPageBinding.tvCost;
        Intrinsics.checkNotNullExpressionValue(tvCost, "tvCost");
        ArizonaRentResponseKt.checkValidate(etCost, costContainer, tvCost, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit checkEditTexts$lambda$0$0;
                checkEditTexts$lambda$0$0 = ArizonaRentAddPage.checkEditTexts$lambda$0$0((Editable) obj);
                return checkEditTexts$lambda$0$0;
            }
        });
        CustomEditText etTo = mpArizonaRentAddPageBinding.etTo;
        Intrinsics.checkNotNullExpressionValue(etTo, "etTo");
        CustomCardView toContainer = mpArizonaRentAddPageBinding.toContainer;
        Intrinsics.checkNotNullExpressionValue(toContainer, "toContainer");
        TextView tvDataError = mpArizonaRentAddPageBinding.tvDataError;
        Intrinsics.checkNotNullExpressionValue(tvDataError, "tvDataError");
        ArizonaRentResponseKt.checkValidate(etTo, toContainer, tvDataError, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit checkEditTexts$lambda$0$1;
                checkEditTexts$lambda$0$1 = ArizonaRentAddPage.checkEditTexts$lambda$0$1((Editable) obj);
                return checkEditTexts$lambda$0$1;
            }
        });
        CustomEditText etFrom = mpArizonaRentAddPageBinding.etFrom;
        Intrinsics.checkNotNullExpressionValue(etFrom, "etFrom");
        CustomCardView fromContainer = mpArizonaRentAddPageBinding.fromContainer;
        Intrinsics.checkNotNullExpressionValue(fromContainer, "fromContainer");
        TextView tvDataError2 = mpArizonaRentAddPageBinding.tvDataError;
        Intrinsics.checkNotNullExpressionValue(tvDataError2, "tvDataError");
        ArizonaRentResponseKt.checkValidate(etFrom, fromContainer, tvDataError2, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentAddPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit checkEditTexts$lambda$0$2;
                checkEditTexts$lambda$0$2 = ArizonaRentAddPage.checkEditTexts$lambda$0$2((Editable) obj);
                return checkEditTexts$lambda$0$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkEditTexts$lambda$0$0(Editable editable) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkEditTexts$lambda$0$1(Editable editable) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkEditTexts$lambda$0$2(Editable editable) {
        return Unit.INSTANCE;
    }

    /* compiled from: ArizonaRentAddPage.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentAddPage$Companion;", "", "<init>", "()V", "MAX_CHAR_COUNT", "", "getMAX_CHAR_COUNT", "()I", "setMAX_CHAR_COUNT", "(I)V", "DATA_INPUT_LIMIT_FULLY", "Lkotlin/Pair;", "getDATA_INPUT_LIMIT_FULLY", "()Lkotlin/Pair;", "setDATA_INPUT_LIMIT_FULLY", "(Lkotlin/Pair;)V", "DATA_INPUT_LIMIT_ROOM", "getDATA_INPUT_LIMIT_ROOM", "setDATA_INPUT_LIMIT_ROOM", "DATA_INPUT_LIMIT_COST_FULLY", "getDATA_INPUT_LIMIT_COST_FULLY", "setDATA_INPUT_LIMIT_COST_FULLY", "DATA_INPUT_LIMIT_COST_ROOM", "getDATA_INPUT_LIMIT_COST_ROOM", "setDATA_INPUT_LIMIT_COST_ROOM", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMAX_CHAR_COUNT() {
            return ArizonaRentAddPage.MAX_CHAR_COUNT;
        }

        public final void setMAX_CHAR_COUNT(int i) {
            ArizonaRentAddPage.MAX_CHAR_COUNT = i;
        }

        public final Pair<Integer, Integer> getDATA_INPUT_LIMIT_FULLY() {
            return ArizonaRentAddPage.DATA_INPUT_LIMIT_FULLY;
        }

        public final void setDATA_INPUT_LIMIT_FULLY(Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(pair, "<set-?>");
            ArizonaRentAddPage.DATA_INPUT_LIMIT_FULLY = pair;
        }

        public final Pair<Integer, Integer> getDATA_INPUT_LIMIT_ROOM() {
            return ArizonaRentAddPage.DATA_INPUT_LIMIT_ROOM;
        }

        public final void setDATA_INPUT_LIMIT_ROOM(Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(pair, "<set-?>");
            ArizonaRentAddPage.DATA_INPUT_LIMIT_ROOM = pair;
        }

        public final Pair<Integer, Integer> getDATA_INPUT_LIMIT_COST_FULLY() {
            return ArizonaRentAddPage.DATA_INPUT_LIMIT_COST_FULLY;
        }

        public final void setDATA_INPUT_LIMIT_COST_FULLY(Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(pair, "<set-?>");
            ArizonaRentAddPage.DATA_INPUT_LIMIT_COST_FULLY = pair;
        }

        public final Pair<Integer, Integer> getDATA_INPUT_LIMIT_COST_ROOM() {
            return ArizonaRentAddPage.DATA_INPUT_LIMIT_COST_ROOM;
        }

        public final void setDATA_INPUT_LIMIT_COST_ROOM(Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(pair, "<set-?>");
            ArizonaRentAddPage.DATA_INPUT_LIMIT_COST_ROOM = pair;
        }
    }
}

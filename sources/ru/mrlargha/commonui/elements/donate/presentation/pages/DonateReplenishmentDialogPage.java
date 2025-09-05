package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBonusAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateType;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\u0017\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0017\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0002\u0010)J\u0010\u00100\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u00101\u001a\u00020 H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateReplenishmentDialogPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "closePage", "Lkotlin/Function0;", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "getClosePage", "()Lkotlin/jvm/functions/Function0;", "adapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "willReceiveState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "upp", "rateType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateType;", "getAmount", "rateJob", "Lkotlinx/coroutines/Job;", "onBackendMessage", "subId", "data", "", "setupListeners", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "dialogInit", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;)Lkotlin/Unit;", "setRateType", "setExpType", "setBuyAzType", "moneyIc", "setExchangeRub", "setBoost", "setupControllers", "clearPage", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogPage extends DonatePage {
    private final DonateBonusAdapter adapter;
    private final DonateReplenishmentDialogBinding binding;
    private final Function0<Unit> closePage;
    private long getAmount;
    private Job rateJob;
    private DonateRateType rateType;
    private final CoroutineScope scope;
    private long upp;
    private final MutableStateFlow<Pair<Long, Integer>> willReceiveState;

    /* compiled from: DonateReplenishmentDialogPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DonateRateType.values().length];
            try {
                iArr[DonateRateType.BUY_AZ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DonateRateType.EXCHANGER_RUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DonateRateType.EXCHANGER_EXP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$3$lambda$0(View view) {
    }

    public final DonateReplenishmentDialogBinding getBinding() {
        return this.binding;
    }

    public final Function0<Unit> getClosePage() {
        return this.closePage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateReplenishmentDialogPage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonateReplenishmentDialogBinding binding, Function0<Unit> closePage) {
        super(i, targetActivity, onItemCompleteListeners);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(closePage, "closePage");
        this.binding = binding;
        this.closePage = closePage;
        this.adapter = new DonateBonusAdapter();
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.willReceiveState = StateFlowKt.MutableStateFlow(TuplesKt.to(0L, 0));
        this.rateType = DonateRateType.BUY_AZ;
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.DIALOG_INIT.getSubIds()) {
            clearPage();
            dialogInit((DonateBoostModelUi) MapperKt.toModel(data, DonateBoostModelUi.class));
            getOnItemCompleteListeners().itemReadyToShow();
        }
    }

    private final void setupListeners(DonateBoostModelUi donateBoostModelUi) {
        final DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$3$lambda$0(view);
            }
        });
        donateReplenishmentDialogBinding.etReplenishmentSum.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupListeners$1$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CoroutineScope coroutineScope;
                CoroutineScope coroutineScope2;
                CoroutineScope coroutineScope3;
                String obj = charSequence != null ? charSequence.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                String obj2 = StringsKt.trim((CharSequence) obj).toString();
                if (obj2.length() == 0) {
                    DonateReplenishmentDialogPage.this.upp = 0L;
                    coroutineScope3 = DonateReplenishmentDialogPage.this.scope;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$1(DonateReplenishmentDialogPage.this, null), 3, null);
                    return;
                }
                try {
                    long parseLong = Long.parseLong(obj2);
                    DonateReplenishmentDialogPage.this.upp = parseLong;
                    coroutineScope2 = DonateReplenishmentDialogPage.this.scope;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2(DonateReplenishmentDialogPage.this, parseLong, null), 3, null);
                } catch (NumberFormatException unused) {
                    DonateReplenishmentDialogPage.this.upp = 0L;
                    coroutineScope = DonateReplenishmentDialogPage.this.scope;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$number$1(DonateReplenishmentDialogPage.this, null), 3, null);
                }
            }
        });
        donateReplenishmentDialogBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$3$lambda$1(DonateReplenishmentDialogPage.this, view);
            }
        });
        donateReplenishmentDialogBinding.btnUpp.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$3$lambda$2(DonateReplenishmentDialogPage.this, donateReplenishmentDialogBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$3$lambda$1(DonateReplenishmentDialogPage donateReplenishmentDialogPage, View view) {
        donateReplenishmentDialogPage.closePage.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$3$lambda$2(DonateReplenishmentDialogPage donateReplenishmentDialogPage, DonateReplenishmentDialogBinding donateReplenishmentDialogBinding, View view) {
        long j = donateReplenishmentDialogPage.getAmount;
        if (j <= 0) {
            Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Введите сумму больше нуля", 0).show();
            return;
        }
        if (j >= 1500000000) {
            Context context = donateReplenishmentDialogBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (UtilsKt.getArizonaType(context)) {
                Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Слишком большое число за раз", 0).show();
                return;
            }
        }
        if (donateReplenishmentDialogPage.upp >= 1000000) {
            Context context2 = donateReplenishmentDialogBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            if (!UtilsKt.getArizonaType(context2)) {
                Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Введите сумму меньше 1 000 000", 0).show();
                return;
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[donateReplenishmentDialogPage.rateType.ordinal()];
        if (i == 1) {
            donateReplenishmentDialogPage.getNotifier().clickedWrapper(donateReplenishmentDialogPage.getBackendId(), (int) donateReplenishmentDialogPage.upp, 7);
        } else if (i == 2) {
            donateReplenishmentDialogPage.getNotifier().clickedWrapper(donateReplenishmentDialogPage.getBackendId(), (int) donateReplenishmentDialogPage.upp, 5);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            donateReplenishmentDialogPage.getNotifier().clickedWrapper(donateReplenishmentDialogPage.getBackendId(), (int) donateReplenishmentDialogPage.upp, 8);
        }
    }

    private final Unit dialogInit(DonateBoostModelUi donateBoostModelUi) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        setupListeners(donateBoostModelUi);
        this.rateType = donateBoostModelUi.getRateType();
        this.adapter.setInputMoney(0L);
        donateReplenishmentDialogBinding.etReplenishmentSum.setText((CharSequence) null);
        donateReplenishmentDialogBinding.rvReplenishment.setAdapter(this.adapter);
        donateReplenishmentDialogBinding.tvAzCoins.setText(String.valueOf(donateBoostModelUi.getRate().getTo()));
        this.adapter.submitList(donateBoostModelUi.getBonusPercentList());
        LinearLayout linearLayout = donateReplenishmentDialogBinding.receiveContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        linearLayout.setBackground(DonateUtilsKt.getDialogItemDrawable(context, "#1AFFFFFF", "#0DFFFFFF", 1));
        setupControllers(donateBoostModelUi);
        setRateType(donateBoostModelUi);
        return setBoost(donateBoostModelUi);
    }

    private final void setRateType(DonateBoostModelUi donateBoostModelUi) {
        int i;
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        if (!UtilsKt.getArizonaType(getTargetActivity()) || this.rateType == DonateRateType.BUY_AZ) {
            i = R.drawable.blueprint_ic_rub;
        } else {
            i = R.drawable.ic_dollar;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.rateType.ordinal()];
        if (i2 == 1) {
            donateReplenishmentDialogBinding.tvMoney.setText(String.valueOf(donateBoostModelUi.getRate().getFrom()));
            setBuyAzType(i);
        } else if (i2 == 2) {
            donateReplenishmentDialogBinding.tvMoney.setText(String.valueOf(donateBoostModelUi.getRate().getFrom()));
            setExchangeRub(i);
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            setExpType();
        }
    }

    private final void setExpType() {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.ivMoney.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoney.setImageTintList(null);
        donateReplenishmentDialogBinding.ivMoneyIc.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoneyIc.setImageTintList(null);
        ImageView ivAzCoin = donateReplenishmentDialogBinding.ivAzCoin;
        Intrinsics.checkNotNullExpressionValue(ivAzCoin, "ivAzCoin");
        ivAzCoin.setVisibility(8);
        ImageView ivAzCoinIc = donateReplenishmentDialogBinding.ivAzCoinIc;
        Intrinsics.checkNotNullExpressionValue(ivAzCoinIc, "ivAzCoinIc");
        ivAzCoinIc.setVisibility(8);
        donateReplenishmentDialogBinding.tvAzCoins.setText(((Object) donateReplenishmentDialogBinding.tvAzCoins.getText()) + " exp");
        FrameLayout frameLayout = donateReplenishmentDialogBinding.titleContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        frameLayout.setBackground(DonateUtilsKt.getDialogButtonGradient(context, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        TextView textView = donateReplenishmentDialogBinding.tvBtnTitle;
        Context context2 = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setBackground(DonateUtilsKt.getDialogButtonGradient(context2, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        LinearLayout bonusContainer = donateReplenishmentDialogBinding.bonusContainer;
        Intrinsics.checkNotNullExpressionValue(bonusContainer, "bonusContainer");
        bonusContainer.setVisibility(8);
        RecyclerView rvReplenishment = donateReplenishmentDialogBinding.rvReplenishment;
        Intrinsics.checkNotNullExpressionValue(rvReplenishment, "rvReplenishment");
        rvReplenishment.setVisibility(8);
        donateReplenishmentDialogBinding.tvTitle.setText("ОБМЕН AZ COINS НА EXP");
        donateReplenishmentDialogBinding.tvBtnTitle.setText("ОБМЕНЯТЬ");
        donateReplenishmentDialogBinding.etReplenishmentSum.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(6)});
    }

    private final void setBuyAzType(int i) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.ivMoneyIc.setImageResource(i);
        donateReplenishmentDialogBinding.ivMoneyIc.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        donateReplenishmentDialogBinding.ivMoney.setImageResource(i);
        donateReplenishmentDialogBinding.ivMoney.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageTintList(null);
        donateReplenishmentDialogBinding.ivAzCoin.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivAzCoin.setImageTintList(null);
        FrameLayout frameLayout = donateReplenishmentDialogBinding.titleContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        frameLayout.setBackground(DonateUtilsKt.getDialogButtonGradient(context, CollectionsKt.listOf((Object[]) new String[]{"#845514", "#E8B11C"})));
        TextView textView = donateReplenishmentDialogBinding.tvBtnTitle;
        Context context2 = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setBackground(DonateUtilsKt.getDialogButtonGradient(context2, CollectionsKt.listOf((Object[]) new String[]{"#845514", "#E8B11C"})));
        LinearLayout bonusContainer = donateReplenishmentDialogBinding.bonusContainer;
        Intrinsics.checkNotNullExpressionValue(bonusContainer, "bonusContainer");
        bonusContainer.setVisibility(0);
        RecyclerView rvReplenishment = donateReplenishmentDialogBinding.rvReplenishment;
        Intrinsics.checkNotNullExpressionValue(rvReplenishment, "rvReplenishment");
        rvReplenishment.setVisibility(0);
        donateReplenishmentDialogBinding.tvTitle.setText("пополнение az коинов");
        donateReplenishmentDialogBinding.tvBtnTitle.setText("Пополнить");
        donateReplenishmentDialogBinding.etReplenishmentSum.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(9)});
    }

    private final void setExchangeRub(int i) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.ivMoneyIc.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoneyIc.setImageTintList(null);
        donateReplenishmentDialogBinding.ivMoney.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoney.setImageTintList(null);
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageResource(i);
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        donateReplenishmentDialogBinding.ivAzCoin.setImageResource(i);
        donateReplenishmentDialogBinding.ivAzCoin.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        FrameLayout frameLayout = donateReplenishmentDialogBinding.titleContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        frameLayout.setBackground(DonateUtilsKt.getDialogButtonGradient(context, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        TextView textView = donateReplenishmentDialogBinding.tvBtnTitle;
        Context context2 = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setBackground(DonateUtilsKt.getDialogButtonGradient(context2, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        LinearLayout bonusContainer = donateReplenishmentDialogBinding.bonusContainer;
        Intrinsics.checkNotNullExpressionValue(bonusContainer, "bonusContainer");
        bonusContainer.setVisibility(8);
        RecyclerView rvReplenishment = donateReplenishmentDialogBinding.rvReplenishment;
        Intrinsics.checkNotNullExpressionValue(rvReplenishment, "rvReplenishment");
        rvReplenishment.setVisibility(8);
        donateReplenishmentDialogBinding.tvTitle.setText("обмен az coins");
        donateReplenishmentDialogBinding.tvBtnTitle.setText("ОБМЕНЯТЬ");
        donateReplenishmentDialogBinding.etReplenishmentSum.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(6)});
    }

    private final Unit setBoost(DonateBoostModelUi donateBoostModelUi) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        if (donateBoostModelUi.getX() > 3) {
            CardView boostContainer = donateReplenishmentDialogBinding.boostContainer;
            Intrinsics.checkNotNullExpressionValue(boostContainer, "boostContainer");
            boostContainer.setVisibility(0);
            donateReplenishmentDialogBinding.tvBoost.setText("x" + donateBoostModelUi.getX());
        } else {
            CardView boostContainer2 = donateReplenishmentDialogBinding.boostContainer;
            Intrinsics.checkNotNullExpressionValue(boostContainer2, "boostContainer");
            boostContainer2.setVisibility(8);
        }
        if (donateBoostModelUi.getEndLeftTime() > 0) {
            CardView timeContainer = donateReplenishmentDialogBinding.timeContainer;
            Intrinsics.checkNotNullExpressionValue(timeContainer, "timeContainer");
            timeContainer.setVisibility(0);
            String timeHMS = DonateUtilsKt.getTimeHMS(donateBoostModelUi.getEndLeftTime());
            if (timeHMS != null) {
                donateReplenishmentDialogBinding.tvTime.setText(timeHMS);
                return Unit.INSTANCE;
            }
            return null;
        }
        CardView timeContainer2 = donateReplenishmentDialogBinding.timeContainer;
        Intrinsics.checkNotNullExpressionValue(timeContainer2, "timeContainer");
        timeContainer2.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void setupControllers(DonateBoostModelUi donateBoostModelUi) {
        Job launch$default;
        Job job = this.rateJob;
        if (job != null) {
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.rateJob = null;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateReplenishmentDialogPage$setupControllers$1(this, donateBoostModelUi, null), 3, null);
        this.rateJob = launch$default;
    }

    private final Job clearPage() {
        Job launch$default;
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        ImageView ivAzCoinIc = donateReplenishmentDialogBinding.ivAzCoinIc;
        Intrinsics.checkNotNullExpressionValue(ivAzCoinIc, "ivAzCoinIc");
        ivAzCoinIc.setVisibility(0);
        ImageView ivAzCoin = donateReplenishmentDialogBinding.ivAzCoin;
        Intrinsics.checkNotNullExpressionValue(ivAzCoin, "ivAzCoin");
        ivAzCoin.setVisibility(0);
        this.upp = 0L;
        this.getAmount = 0L;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateReplenishmentDialogPage$clearPage$1$1(this, null), 3, null);
        return launch$default;
    }
}

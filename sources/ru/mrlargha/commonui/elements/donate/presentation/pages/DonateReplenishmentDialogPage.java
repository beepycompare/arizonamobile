package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBonusAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0002J\u0017\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateReplenishmentDialogPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "closePage", "Lkotlin/Function0;", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "getClosePage", "()Lkotlin/jvm/functions/Function0;", "adapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "willReceiveState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "upp", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "isReverse", "getAmount", "onBackendMessage", "subId", "data", "", "setupListeners", "hideKeyboard", "dialogInit", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "setReverse", "setBoost", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;)Lkotlin/Unit;", "setupControllers", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogPage extends DonatePage {
    private final DonateBonusAdapter adapter;
    private final DonateReplenishmentDialogBinding binding;
    private final Function0<Unit> closePage;
    private long getAmount;
    private final boolean isArizonaType;
    private boolean isReverse;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPref;
    private long upp;
    private final MutableStateFlow<Pair<Long, Integer>> willReceiveState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$4$lambda$0(View view) {
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
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        setupListeners();
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.DIALOG_INIT.getSubIds()) {
            dialogInit((DonateBoostModelUi) MapperKt.toModel(data, DonateBoostModelUi.class));
            getOnItemCompleteListeners().itemReadyToShow();
        }
    }

    private final void setupListeners() {
        final DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$4$lambda$0(view);
            }
        });
        donateReplenishmentDialogBinding.etReplenishmentSum.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = DonateReplenishmentDialogPage.setupListeners$lambda$4$lambda$1(DonateReplenishmentDialogBinding.this, this, textView, i, keyEvent);
                return z;
            }
        });
        donateReplenishmentDialogBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$4$lambda$2(DonateReplenishmentDialogPage.this, view);
            }
        });
        donateReplenishmentDialogBinding.btnUpp.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$4$lambda$3(DonateReplenishmentDialogPage.this, donateReplenishmentDialogBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupListeners$lambda$4$lambda$1(DonateReplenishmentDialogBinding donateReplenishmentDialogBinding, DonateReplenishmentDialogPage donateReplenishmentDialogPage, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            Editable text = donateReplenishmentDialogBinding.etReplenishmentSum.getText();
            String obj = text != null ? text.toString() : null;
            if (obj == null) {
                obj = "";
            }
            String obj2 = StringsKt.trim((CharSequence) obj).toString();
            String str = obj2;
            if (str.length() == 0) {
                Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Введите сумму", 0).show();
                return true;
            } else if (!new Regex("^\\d+$").matches(str)) {
                Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Допустимы только цифры", 0).show();
                return true;
            } else {
                try {
                    long parseLong = Long.parseLong(obj2);
                    if (parseLong <= 0) {
                        Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Введите сумму больше нуля", 0).show();
                    } else if (parseLong >= 1500000000) {
                        Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Слишком большая сумма за раз", 0).show();
                    } else {
                        donateReplenishmentDialogPage.upp = parseLong;
                        BuildersKt__Builders_commonKt.launch$default(donateReplenishmentDialogPage.scope, null, null, new DonateReplenishmentDialogPage$setupListeners$1$2$1(donateReplenishmentDialogPage, parseLong, null), 3, null);
                    }
                    donateReplenishmentDialogPage.hideKeyboard();
                    return true;
                } catch (NumberFormatException unused) {
                    Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Слишком большая сумма", 0).show();
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$4$lambda$2(DonateReplenishmentDialogPage donateReplenishmentDialogPage, View view) {
        donateReplenishmentDialogPage.closePage.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$4$lambda$3(DonateReplenishmentDialogPage donateReplenishmentDialogPage, DonateReplenishmentDialogBinding donateReplenishmentDialogBinding, View view) {
        long j = donateReplenishmentDialogPage.getAmount;
        if (j <= 0) {
            Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Введите сумму", 0).show();
        } else if (j >= 1500000000) {
            Toast.makeText(donateReplenishmentDialogBinding.getRoot().getContext(), "Слишком большая сумма за раз", 0).show();
        } else if (donateReplenishmentDialogPage.isReverse) {
            donateReplenishmentDialogPage.getNotifier().clickedWrapper(donateReplenishmentDialogPage.getBackendId(), (int) donateReplenishmentDialogPage.upp, 7);
        } else {
            donateReplenishmentDialogPage.getNotifier().clickedWrapper(donateReplenishmentDialogPage.getBackendId(), (int) donateReplenishmentDialogPage.upp, 5);
        }
    }

    private final void hideKeyboard() {
        Object systemService = this.binding.getRoot().getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.binding.etReplenishmentSum.getWindowToken(), 0);
        }
    }

    private final void dialogInit(DonateBoostModelUi donateBoostModelUi) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateReplenishmentDialogPage$dialogInit$1$1(this, null), 3, null);
        this.adapter.setInputMoney(0L);
        donateReplenishmentDialogBinding.etReplenishmentSum.setText((CharSequence) null);
        setReverse(donateBoostModelUi);
        setBoost(donateBoostModelUi);
        donateReplenishmentDialogBinding.rvReplenishment.setAdapter(this.adapter);
        this.adapter.submitList(donateBoostModelUi.getBonusPercentList());
        donateReplenishmentDialogBinding.tvMoney.setText(String.valueOf(donateBoostModelUi.getRate().getFrom()));
        donateReplenishmentDialogBinding.tvAzCoins.setText(String.valueOf(donateBoostModelUi.getRate().getTo()));
        LinearLayout linearLayout = donateReplenishmentDialogBinding.receiveContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        linearLayout.setBackground(DonateUtilsKt.getDialogItemDrawable(context, "#1AFFFFFF", "#0DFFFFFF", 1));
        setupControllers(donateBoostModelUi);
    }

    private final void setReverse(DonateBoostModelUi donateBoostModelUi) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        boolean reverse = donateBoostModelUi.getReverse();
        this.isReverse = reverse;
        int i = !reverse ? R.drawable.ic_dollar : R.drawable.blueprint_ic_rub;
        if (donateBoostModelUi.getReverse()) {
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
            return;
        }
        donateReplenishmentDialogBinding.ivMoneyIc.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoneyIc.setImageTintList(null);
        donateReplenishmentDialogBinding.ivMoney.setImageResource(R.drawable.ic_az_coins);
        donateReplenishmentDialogBinding.ivMoney.setImageTintList(null);
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageResource(i);
        donateReplenishmentDialogBinding.ivAzCoinIc.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        donateReplenishmentDialogBinding.ivAzCoin.setImageResource(i);
        donateReplenishmentDialogBinding.ivAzCoin.setImageTintList(ColorStateList.valueOf(Color.parseColor("#99FFFFFF")));
        FrameLayout frameLayout2 = donateReplenishmentDialogBinding.titleContainer;
        Context context3 = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        frameLayout2.setBackground(DonateUtilsKt.getDialogButtonGradient(context3, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        TextView textView2 = donateReplenishmentDialogBinding.tvBtnTitle;
        Context context4 = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        textView2.setBackground(DonateUtilsKt.getDialogButtonGradient(context4, CollectionsKt.listOf((Object[]) new String[]{"#265006", "#90C739"})));
        LinearLayout bonusContainer2 = donateReplenishmentDialogBinding.bonusContainer;
        Intrinsics.checkNotNullExpressionValue(bonusContainer2, "bonusContainer");
        bonusContainer2.setVisibility(8);
        RecyclerView rvReplenishment2 = donateReplenishmentDialogBinding.rvReplenishment;
        Intrinsics.checkNotNullExpressionValue(rvReplenishment2, "rvReplenishment");
        rvReplenishment2.setVisibility(8);
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateReplenishmentDialogPage$setupControllers$1(this, donateBoostModelUi, null), 3, null);
    }
}

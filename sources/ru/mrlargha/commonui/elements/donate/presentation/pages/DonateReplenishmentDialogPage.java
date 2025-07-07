package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBonusAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateReplenishmentDialogModel;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateReplenishmentDialogPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateReplenishmentDialogBinding;", "adapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "willReceiveState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "onBackendMessage", "", "subId", "data", "", "setupListeners", "dialogInit", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateReplenishmentDialogModel;", "setupControllers", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogPage extends DonatePage {
    private final DonateBonusAdapter adapter;
    private final DonateReplenishmentDialogBinding binding;
    private final CoroutineScope scope;
    private final MutableStateFlow<Pair<Integer, Integer>> willReceiveState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$1$lambda$0(View view) {
    }

    public final DonateReplenishmentDialogBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateReplenishmentDialogPage(int i, Activity targetActivity, DonateReplenishmentDialogBinding binding) {
        super(i, targetActivity);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.adapter = new DonateBonusAdapter();
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.willReceiveState = StateFlowKt.MutableStateFlow(TuplesKt.to(0, 0));
        setupListeners();
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.DIALOG_INIT.getSubIds()) {
            dialogInit((DonateReplenishmentDialogModel) MapperKt.toModel(data, DonateReplenishmentDialogModel.class));
        }
    }

    private final void setupListeners() {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateReplenishmentDialogPage.setupListeners$lambda$1$lambda$0(view);
            }
        });
        donateReplenishmentDialogBinding.etReplenishmentSum.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupListeners$1$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                DonateBonusAdapter donateBonusAdapter;
                CoroutineScope coroutineScope;
                String obj = editable != null ? editable.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                Integer intOrNull = StringsKt.toIntOrNull(obj);
                int intValue = intOrNull != null ? intOrNull.intValue() : 0;
                donateBonusAdapter = DonateReplenishmentDialogPage.this.adapter;
                int inputMoney = donateBonusAdapter.setInputMoney(intValue);
                coroutineScope = DonateReplenishmentDialogPage.this.scope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DonateReplenishmentDialogPage$setupListeners$1$2$afterTextChanged$1(DonateReplenishmentDialogPage.this, intValue, inputMoney, null), 3, null);
            }
        });
    }

    private final void dialogInit(DonateReplenishmentDialogModel donateReplenishmentDialogModel) {
        DonateReplenishmentDialogBinding donateReplenishmentDialogBinding = this.binding;
        donateReplenishmentDialogBinding.rvReplenishment.setAdapter(this.adapter);
        this.adapter.submitList(donateReplenishmentDialogModel.getBonusPercentList());
        donateReplenishmentDialogBinding.tvMoney.setText(String.valueOf(donateReplenishmentDialogModel.getRate().getFrom()));
        donateReplenishmentDialogBinding.tvAzCoins.setText(String.valueOf(donateReplenishmentDialogModel.getRate().getTo()));
        LinearLayout linearLayout = donateReplenishmentDialogBinding.receiveContainer;
        Context context = donateReplenishmentDialogBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        linearLayout.setBackground(DonateUtilsKt.getDialogItemDrawable(context, "#1AFFFFFF", "#0DFFFFFF", 1));
        setupControllers(donateReplenishmentDialogModel);
    }

    private final void setupControllers(DonateReplenishmentDialogModel donateReplenishmentDialogModel) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateReplenishmentDialogPage$setupControllers$1(this, donateReplenishmentDialogModel, null), 3, null);
    }
}

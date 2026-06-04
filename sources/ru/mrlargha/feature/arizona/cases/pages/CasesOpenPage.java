package ru.mrlargha.feature.arizona.cases.pages;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
import ru.mrlargha.feature.arizona.cases.CasesId;
import ru.mrlargha.feature.arizona.cases.CasesResponseKt;
import ru.mrlargha.feature.arizona.cases.CasesUsedType;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesOpenPageBinding;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter;
/* compiled from: CasesOpenPage.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/CasesOpenPage;", "Lru/mrlargha/feature/arizona/cases/pages/CasesBasePage;", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenPageBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "<init>", "(Landroid/app/Activity;Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenPageBinding;Lru/mrlargha/commonui/core/IBackendNotifier;)V", "getTargetActivity", "()Landroid/app/Activity;", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenPageBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "diamondCountState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "openAdapter", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter;", "cost", "createPage", "", "sendEvent", "data", "", "subId", "setupListeners", "setupCollectors", "Lkotlinx/coroutines/Job;", "setWinCases", "winList", "", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "setDefaultPage", "onItemClick", "updateCost", "destroyPage", "Companion", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesOpenPage implements CasesBasePage {
    public static final Companion Companion = new Companion(null);
    private static final MutableStateFlow<Boolean> isOpenState = StateFlowKt.MutableStateFlow(false);
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final ArizonaCasesOpenPageBinding binding;
    private int cost;
    private final MutableStateFlow<Integer> diamondCountState;
    private final IBackendNotifier notifier;
    private final CasesOpenAdapter openAdapter;
    private final Activity targetActivity;

    public CasesOpenPage(Activity targetActivity, ArizonaCasesOpenPageBinding binding, IBackendNotifier notifier) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.notifier = notifier;
        this.diamondCountState = StateFlowKt.MutableStateFlow(0);
        CasesOpenAdapter casesOpenAdapter = new CasesOpenAdapter(new CasesOpenPage$openAdapter$1(this), new CasesOpenPage$openAdapter$2(this));
        this.openAdapter = casesOpenAdapter;
        binding.rvWinnerPrizes.setAdapter(casesOpenAdapter);
        setupListeners();
        setupCollectors();
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public final ArizonaCasesOpenPageBinding getBinding() {
        return this.binding;
    }

    public final IBackendNotifier getNotifier() {
        return this.notifier;
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void createPage() {
        Log.i(CasesResponseKt.CASES_TAG, "createPage: " + getClass().getName());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CasesOpenPage$createPage$1(this, null), 3, null);
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void sendEvent(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.cost = 0;
        if (i == CasesId.SET_WIN_CASES.getSubId()) {
            Companion.switchOpenPrizes(false);
            setWinCases(MapperKt.toListModel(data, CasesGuaranteedPrizeModel.class));
        } else if (i == CasesId.UPDATE_DIAMOND_COUNT.getSubId()) {
            this.openAdapter.clearSelectList(CasesUsedType.SCHISM);
            onItemClick(0);
        }
    }

    private final void setupListeners() {
        final ArizonaCasesOpenPageBinding arizonaCasesOpenPageBinding = this.binding;
        arizonaCasesOpenPageBinding.tvOpenAll.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesOpenPage.setupListeners$lambda$0$0(CasesOpenPage.this, arizonaCasesOpenPageBinding, view);
            }
        });
        arizonaCasesOpenPageBinding.tvGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesOpenPage.setupListeners$lambda$0$1(CasesOpenPage.this, view);
            }
        });
        arizonaCasesOpenPageBinding.schismContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesOpenPage.setupListeners$lambda$0$2(CasesOpenPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(CasesOpenPage casesOpenPage, ArizonaCasesOpenPageBinding arizonaCasesOpenPageBinding, View view) {
        casesOpenPage.openAdapter.switchIsOpen();
        LinearLayout openContainer = arizonaCasesOpenPageBinding.openContainer;
        Intrinsics.checkNotNullExpressionValue(openContainer, "openContainer");
        openContainer.setVisibility(8);
        LinearLayout getContainer = arizonaCasesOpenPageBinding.getContainer;
        Intrinsics.checkNotNullExpressionValue(getContainer, "getContainer");
        getContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(CasesOpenPage casesOpenPage, View view) {
        casesOpenPage.updateCost(0);
        IBackendNotifier iBackendNotifier = casesOpenPage.notifier;
        int id = UIElementID.CASES.getId();
        byte[] bytes = CollectionsKt.joinToString$default(casesOpenPage.openAdapter.getSelectList(), StringUtils.COMMA, null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, 0, 1, bytes);
        casesOpenPage.openAdapter.clearSelectList(CasesUsedType.GET);
        casesOpenPage.cost = 0;
        casesOpenPage.onItemClick(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(CasesOpenPage casesOpenPage, View view) {
        casesOpenPage.updateCost(0);
        IBackendNotifier iBackendNotifier = casesOpenPage.notifier;
        int id = UIElementID.CASES.getId();
        byte[] bytes = CollectionsKt.joinToString$default(casesOpenPage.openAdapter.getSelectList(), StringUtils.COMMA, null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, 0, 2, bytes);
    }

    private final Job setupCollectors() {
        Job launch$default;
        ArizonaCasesOpenPageBinding arizonaCasesOpenPageBinding = this.binding;
        CoroutineScope coroutineScope = scope;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CasesOpenPage$setupCollectors$1$1(arizonaCasesOpenPageBinding, null), 3, null);
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CasesOpenPage$setupCollectors$1$2(this, arizonaCasesOpenPageBinding, null), 3, null);
        return launch$default;
    }

    private final void setWinCases(List<CasesGuaranteedPrizeModel> list) {
        setDefaultPage();
        this.openAdapter.submitList(list);
    }

    private final void setDefaultPage() {
        ArizonaCasesOpenPageBinding arizonaCasesOpenPageBinding = this.binding;
        updateCost(0);
        LinearLayout openContainer = arizonaCasesOpenPageBinding.openContainer;
        Intrinsics.checkNotNullExpressionValue(openContainer, "openContainer");
        openContainer.setVisibility(0);
        LinearLayout getContainer = arizonaCasesOpenPageBinding.getContainer;
        Intrinsics.checkNotNullExpressionValue(getContainer, "getContainer");
        getContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemClick(int i) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CasesOpenPage$onItemClick$1(this, i, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCost(int i) {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CasesOpenPage$updateCost$1(this, i, null), 3, null);
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void destroyPage() {
        this.openAdapter.submitList(null);
        RecyclerView rvWinnerPrizes = this.binding.rvWinnerPrizes;
        Intrinsics.checkNotNullExpressionValue(rvWinnerPrizes, "rvWinnerPrizes");
        rvWinnerPrizes.setVisibility(4);
    }

    /* compiled from: CasesOpenPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/CasesOpenPage$Companion;", "", "<init>", "()V", "isOpenState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "switchOpenPrizes", "", "isOpen", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void switchOpenPrizes(boolean z) {
            BuildersKt__Builders_commonKt.launch$default(CasesOpenPage.scope, null, null, new CasesOpenPage$Companion$switchOpenPrizes$1(z, null), 3, null);
        }
    }
}

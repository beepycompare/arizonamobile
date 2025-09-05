package ru.mrlargha.commonui.elements.donate.presentation;

import android.util.Log;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.elements.donate.data.remote.DonateRetrofitClient;
import ru.mrlargha.commonui.elements.donate.data.repositories.DonateRepositoryImpl;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetCategoriesUseCase;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUiKt;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.ProjectType;
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020.H\u0002J\u0016\u00102\u001a\u00020.2\u0006\u0010/\u001a\u0002032\u0006\u00104\u001a\u00020%J\u0016\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020%J\u001e\u00108\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u00109\u001a\u00020%2\u0006\u00107\u001a\u00020%J$\u0010:\u001a\b\u0012\u0004\u0012\u0002030\u00172\u0006\u00106\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u0002030\u0017H\u0002J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u0002030\u00172\f\u0010;\u001a\b\u0012\u0004\u0012\u0002030\u0017H\u0002J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u0002030\u00172\f\u0010;\u001a\b\u0012\u0004\u0012\u0002030\u0017H\u0002J\b\u0010>\u001a\u00020.H\u0002J\u0006\u0010?\u001a\u00020.R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00170\u00160\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00170\u00160\u001a¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateStates;", "", "token", "", "serverId", "", "project", "Lru/mrlargha/commonui/utils/ProjectType;", "<init>", "(Ljava/lang/String;ILru/mrlargha/commonui/utils/ProjectType;)V", "retrofitClient", "Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;", "repository", "Lru/mrlargha/commonui/elements/donate/data/repositories/DonateRepositoryImpl;", "getCategoriesUseCase", "Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetCategoriesUseCase;", "getItemsUseCase", "Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetItemUseCase;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_categoriesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/commonui/elements/donate/presentation/UiState;", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "categoriesState", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoriesState", "()Lkotlinx/coroutines/flow/StateFlow;", "_itemsState", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "itemState", "getItemState", "itemJob", "Lkotlinx/coroutines/Job;", "updateItemJob", "isWorkingMainItemSet", "", "_boostState", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "boostState", "getBoostState", "badgesTime", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBadgesModel;", "currentCategory", "updateCategories", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "setCategories", "updateItems", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "isHasUpdate", "setItemsArizona", "categoriesId", "isActionCategory", "setItemsRodina", "isLimitCategory", "filterItemOrdinary", "itemList", "filterItemByAction", "filterItemByLimit", "setBoosts", "clearJobs", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateStates {
    private final MutableStateFlow<UiState<List<DonateBoostModelUi>>> _boostState;
    private final MutableStateFlow<UiState<List<DonateCategoryModelUi>>> _categoriesState;
    private final MutableStateFlow<UiState<List<DonateItemModelUi>>> _itemsState;
    private final DonateBadgesModel badgesTime;
    private final StateFlow<UiState<List<DonateBoostModelUi>>> boostState;
    private final StateFlow<UiState<List<DonateCategoryModelUi>>> categoriesState;
    private int currentCategory;
    private final DonateGetCategoriesUseCase getCategoriesUseCase;
    private final DonateGetItemUseCase getItemsUseCase;
    private boolean isWorkingMainItemSet;
    private Job itemJob;
    private final StateFlow<UiState<List<DonateItemModelUi>>> itemState;
    private final DonateRepositoryImpl repository;
    private final DonateRetrofitClient retrofitClient;
    private final CoroutineScope scope;
    private Job updateItemJob;

    public DonateStates(String token, int i, ProjectType project) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(project, "project");
        DonateRetrofitClient donateRetrofitClient = new DonateRetrofitClient(token);
        this.retrofitClient = donateRetrofitClient;
        DonateRepositoryImpl donateRepositoryImpl = new DonateRepositoryImpl(donateRetrofitClient, i, project);
        this.repository = donateRepositoryImpl;
        this.getCategoriesUseCase = new DonateGetCategoriesUseCase(donateRepositoryImpl);
        this.getItemsUseCase = new DonateGetItemUseCase(donateRepositoryImpl);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        MutableStateFlow<UiState<List<DonateCategoryModelUi>>> MutableStateFlow = StateFlowKt.MutableStateFlow(UiState.Loading.INSTANCE);
        this._categoriesState = MutableStateFlow;
        this.categoriesState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<UiState<List<DonateItemModelUi>>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(UiState.Loading.INSTANCE);
        this._itemsState = MutableStateFlow2;
        this.itemState = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<UiState<List<DonateBoostModelUi>>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(UiState.Loading.INSTANCE);
        this._boostState = MutableStateFlow3;
        this.boostState = FlowKt.asStateFlow(MutableStateFlow3);
        this.badgesTime = new DonateBadgesModel(CollectionsKt.listOf((Object[]) new String[]{"", ""}), "", "TIME");
        setCategories();
        setBoosts();
    }

    public final StateFlow<UiState<List<DonateCategoryModelUi>>> getCategoriesState() {
        return this.categoriesState;
    }

    public final StateFlow<UiState<List<DonateItemModelUi>>> getItemState() {
        return this.itemState;
    }

    public final StateFlow<UiState<List<DonateBoostModelUi>>> getBoostState() {
        return this.boostState;
    }

    public final void updateCategories(DonateCategoryModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        UiState<List<DonateCategoryModelUi>> value = this._categoriesState.getValue();
        if (value instanceof UiState.Successful) {
            List<DonateCategoryModelUi> list = (List) ((UiState.Successful) value).getData();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DonateCategoryModelUi donateCategoryModelUi : list) {
                if (donateCategoryModelUi.getId() == model.getKey()) {
                    donateCategoryModelUi = DonateCategoryModelUi.copy$default(donateCategoryModelUi, 0, null, null, null, 0, 0, false, DonateCategoryModelUiKt.toUi(model).getVisible(), 0, false, false, 1919, null);
                }
                arrayList.add(donateCategoryModelUi);
            }
            this._categoriesState.setValue(new UiState.Successful(arrayList));
        }
    }

    private final void setCategories() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateStates$setCategories$1(this, null), 3, null);
    }

    public final void updateItems(DonateItemModel model, boolean z) {
        Intrinsics.checkNotNullParameter(model, "model");
        Log.e(DonateUtilsKt.DONATE_TAG, "collected update");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateStates$updateItems$1(this, model, null), 3, null);
    }

    public final void setItemsArizona(int i, boolean z) {
        Job launch$default;
        this.isWorkingMainItemSet = true;
        this.currentCategory = i;
        Job job = this.itemJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.itemJob = null;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateStates$setItemsArizona$1(this, z, i, null), 3, null);
        this.itemJob = launch$default;
    }

    public final void setItemsRodina(int i, boolean z, boolean z2) {
        Job launch$default;
        this.isWorkingMainItemSet = true;
        this.currentCategory = i;
        Job job = this.itemJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.itemJob = null;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateStates$setItemsRodina$1(this, i, z2, z, null), 3, null);
        this.itemJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DonateItemModel> filterItemOrdinary(int i, List<DonateItemModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((DonateItemModel) obj).getCategory() == i) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((DonateItemModel) obj2).getVisible() == 1) {
                arrayList2.add(obj2);
            }
        }
        List<DonateItemModel> sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$filterItemOrdinary$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DonateItemModel) t).getPosition()), Integer.valueOf(((DonateItemModel) t2).getPosition()));
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (DonateItemModel donateItemModel : sortedWith) {
            if (donateItemModel.getLeftUnixTime() > 0) {
                List<DonateBadgesModel> badges = donateItemModel.getBadges();
                donateItemModel = DonateItemModel.copy$default(donateItemModel, 0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, badges != null ? CollectionsKt.plus((Collection<? extends DonateBadgesModel>) badges, DonateBadgesModel.copy$default(this.badgesTime, null, String.valueOf(donateItemModel.getLeftUnixTime()), null, 5, null)) : null, 0, null, 0, 0, 0, null, 0, 0, 0, 134086655, null);
            }
            arrayList3.add(donateItemModel);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DonateItemModel> filterItemByAction(List<DonateItemModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DonateItemModel donateItemModel = (DonateItemModel) obj;
            if (donateItemModel.getDiscount() > 0 || donateItemModel.getCategory() == this.currentCategory) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((DonateItemModel) obj2).getVisible() == 1) {
                arrayList2.add(obj2);
            }
        }
        List<DonateItemModel> sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$filterItemByAction$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DonateItemModel) t).getPosition()), Integer.valueOf(((DonateItemModel) t2).getPosition()));
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (DonateItemModel donateItemModel2 : sortedWith) {
            if (donateItemModel2.getLeftUnixTime() > 0) {
                List<DonateBadgesModel> badges = donateItemModel2.getBadges();
                donateItemModel2 = DonateItemModel.copy$default(donateItemModel2, 0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, badges != null ? CollectionsKt.plus((Collection<? extends DonateBadgesModel>) badges, DonateBadgesModel.copy$default(this.badgesTime, null, String.valueOf(donateItemModel2.getLeftUnixTime()), null, 5, null)) : null, 0, null, 0, 0, 0, null, 0, 0, 0, 134086655, null);
            }
            arrayList3.add(donateItemModel2);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DonateItemModel> filterItemByLimit(List<DonateItemModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DonateItemModel donateItemModel = (DonateItemModel) obj;
            if (donateItemModel.getLimited() > 0 || donateItemModel.getCategory() == this.currentCategory) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((DonateItemModel) obj2).getVisible() == 1) {
                arrayList2.add(obj2);
            }
        }
        List<DonateItemModel> sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$filterItemByLimit$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DonateItemModel) t).getPosition()), Integer.valueOf(((DonateItemModel) t2).getPosition()));
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (DonateItemModel donateItemModel2 : sortedWith) {
            if (donateItemModel2.getLeftUnixTime() > 0) {
                List<DonateBadgesModel> badges = donateItemModel2.getBadges();
                donateItemModel2 = DonateItemModel.copy$default(donateItemModel2, 0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, badges != null ? CollectionsKt.plus((Collection<? extends DonateBadgesModel>) badges, DonateBadgesModel.copy$default(this.badgesTime, null, String.valueOf(donateItemModel2.getLeftUnixTime()), null, 5, null)) : null, 0, null, 0, 0, 0, null, 0, 0, 0, 134086655, null);
            }
            arrayList3.add(donateItemModel2);
        }
        return arrayList3;
    }

    private final void setBoosts() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateStates$setBoosts$1(this, null), 3, null);
    }

    public final void clearJobs() {
        Job job = this.itemJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.itemJob = null;
        Job job2 = this.updateItemJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.updateItemJob = null;
    }
}

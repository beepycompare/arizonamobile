package ru.mrlargha.commonui.elements.donate.domain.repositories;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.utils.ProjectType;
/* compiled from: DonateRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u0005H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u0005H¦@¢\u0006\u0002\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "", "getProjectType", "Lru/mrlargha/commonui/utils/ProjectType;", "getCategories", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItems", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "getBoost", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface DonateRepository {
    Object getBoost(Continuation<? super ResultState<? extends List<DonateBoostModel>>> continuation);

    Object getCategories(Continuation<? super ResultState<? extends List<DonateCategoryModel>>> continuation);

    Object getItems(Continuation<? super ResultState<? extends List<DonateItemModel>>> continuation);

    ProjectType getProjectType();
}

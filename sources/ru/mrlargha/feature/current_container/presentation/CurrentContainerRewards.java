package ru.mrlargha.feature.current_container.presentation;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.feature.current_container.R;
import ru.mrlargha.feature.current_container.databinding.ContainerGetPrizeBinding;
import ru.mrlargha.feature.current_container.domain.obj.ContainerPrize;
/* compiled from: CurrentContainerRewards.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainerRewards;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "currentContainerAwards", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentContainerRewardsAdapter", "Lru/mrlargha/feature/current_container/presentation/CurrentContainerRewardsAdapter;", "binding", "Lru/mrlargha/feature/current_container/databinding/ContainerGetPrizeBinding;", "addItems", "", "message", "", "onBackendMessageHandled", "data", "subId", "Spawner", "current-container"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CurrentContainerRewards extends SAMPUIElement {
    private final ContainerGetPrizeBinding binding;
    private final ConstraintLayout currentContainerAwards;
    private final CurrentContainerRewardsAdapter currentContainerRewardsAdapter;
    private final IBackendNotifier sendServerEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentContainerRewards(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.sendServerEvent = (IBackendNotifier) targetActivity;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.container_get_prize, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.currentContainerAwards = constraintLayout;
        CurrentContainerRewardsAdapter currentContainerRewardsAdapter = new CurrentContainerRewardsAdapter(targetActivity, i);
        this.currentContainerRewardsAdapter = currentContainerRewardsAdapter;
        ContainerGetPrizeBinding bind = ContainerGetPrizeBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(false);
        bind.cgpExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainerRewards$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainerRewards._init_$lambda$0(CurrentContainerRewards.this, i, view);
            }
        });
        bind.ccRcView.setAdapter(currentContainerRewardsAdapter);
        bind.ccRcView.setLayoutManager(new GridLayoutManager(constraintLayout.getContext()) { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainerRewards.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(CurrentContainerRewards currentContainerRewards, int i, View view) {
        currentContainerRewards.sendServerEvent.clickedWrapper(i, 0, 1);
        currentContainerRewards.setVisibility(false);
    }

    public final void addItems(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        List<ContainerPrize> listModel = MapperKt.toListModel(message, ContainerPrize.class);
        if (!listModel.isEmpty()) {
            this.currentContainerRewardsAdapter.addItems(listModel);
        }
        this.currentContainerRewardsAdapter.notifyDataSetChanged();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addItems(data);
        }
    }

    /* compiled from: CurrentContainerRewards.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainerRewards$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "current-container"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_CONTAINER_REWARDS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CurrentContainerRewards(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

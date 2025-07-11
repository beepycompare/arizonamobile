package ru.mrlargha.arizonaui.container.presentation;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.container.domain.obj.ContainerPrize;
import ru.mrlargha.arizonaui.databinding.ContainerGetPrizeBinding;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CurrentContainerRewards.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainerRewards;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "currentContainerAwards", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentContainerRewardsAdapter", "Lru/mrlargha/arizonaui/container/presentation/CurrentContainerRewardsAdapter;", "containerGetPrizeBinding", "Lru/mrlargha/arizonaui/databinding/ContainerGetPrizeBinding;", "addItems", "", "message", "", "onBackendMessage", "data", "subId", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentContainerRewards extends SAMPUIElement {
    private final ContainerGetPrizeBinding containerGetPrizeBinding;
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
        this.containerGetPrizeBinding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(false);
        bind.cgpExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainerRewards$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainerRewards._init_$lambda$0(CurrentContainerRewards.this, i, view);
            }
        });
        bind.ccRcView.setAdapter(currentContainerRewardsAdapter);
        bind.ccRcView.setLayoutManager(new GridLayoutManager(constraintLayout.getContext()) { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainerRewards.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addItems(data);
        }
    }

    /* compiled from: CurrentContainerRewards.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainerRewards$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CurrentContainerRewards(targetActivity, i);
        }
    }
}

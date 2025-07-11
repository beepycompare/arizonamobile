package ru.mrlargha.arizonaui.new_container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.NewContainerAwardItemBinding;
import ru.mrlargha.arizonaui.new_container.NewContainerScreen;
/* compiled from: NewContainerAwardsAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerAwardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/new_container/NewContainerAwardsAdapter$AwardsViewHolder;", "<init>", "()V", "awardsInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion$AwardInfo;", "Lkotlin/collections/ArrayList;", "loadImageJob", "Lkotlinx/coroutines/Job;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addWinnerInfo", "infoList", "", "AwardsViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewContainerAwardsAdapter extends RecyclerView.Adapter<AwardsViewHolder> {
    private final ArrayList<NewContainerScreen.Companion.AwardInfo> awardsInfoList = new ArrayList<>();
    private Job loadImageJob;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AwardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_container_award_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new AwardsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AwardsViewHolder holder, int i) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(holder, "holder");
        NewContainerScreen.Companion.AwardInfo awardInfo = this.awardsInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(awardInfo, "get(...)");
        NewContainerScreen.Companion.AwardInfo awardInfo2 = awardInfo;
        NewContainerAwardItemBinding binding = holder.getBinding();
        binding.count.setText(String.valueOf(awardInfo2.getCount()));
        binding.title.setText(awardInfo2.getTitle());
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NewContainerAwardsAdapter$onBindViewHolder$1$1(awardInfo2, binding, null), 3, null);
        this.loadImageJob = launch$default;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.awardsInfoList.size();
    }

    /* compiled from: NewContainerAwardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerAwardsAdapter$AwardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/NewContainerAwardItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/NewContainerAwardItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AwardsViewHolder extends RecyclerView.ViewHolder {
        private final NewContainerAwardItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AwardsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            NewContainerAwardItemBinding bind = NewContainerAwardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final NewContainerAwardItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addWinnerInfo(List<NewContainerScreen.Companion.AwardInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.awardsInfoList.clear();
        this.awardsInfoList.addAll(infoList);
        notifyDataSetChanged();
    }
}

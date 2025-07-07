package ru.mrlargha.arizonaui.situation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.SituationAwardItemBinding;
import ru.mrlargha.arizonaui.situation.SituationScreen;
/* compiled from: AwardsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/situation/AwardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/situation/AwardsAdapter$AwardsViewHolder;", "<init>", "()V", "winnerInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$WinnerInfo;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addWinnerInfo", "infoList", "", "AwardsViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AwardsAdapter extends RecyclerView.Adapter<AwardsViewHolder> {
    private final ArrayList<SituationScreen.Companion.WinnerInfo> winnerInfoList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AwardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.situation_award_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new AwardsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AwardsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SituationScreen.Companion.WinnerInfo winnerInfo = this.winnerInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(winnerInfo, "get(...)");
        SituationScreen.Companion.WinnerInfo winnerInfo2 = winnerInfo;
        SituationAwardItemBinding binding = holder.getBinding();
        int position = winnerInfo2.getPosition();
        if (position == 1) {
            binding.positionIc.setImageResource(R.drawable.situation_first_pos_ic);
        } else if (position == 2) {
            binding.positionIc.setImageResource(R.drawable.situation_second_pos_ic);
        } else if (position == 3) {
            binding.positionIc.setImageResource(R.drawable.situation_third_pos_ic);
        } else if (position == 4) {
            binding.positionIc.setImageResource(R.drawable.situation_fourth_pos_ic);
        }
        binding.awardType.setText(winnerInfo2.getTitle());
        binding.awardSum.setText("$" + winnerInfo2.getMoney());
        binding.awardRp.setText(winnerInfo2.getPoints());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.winnerInfoList.size();
    }

    /* compiled from: AwardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/situation/AwardsAdapter$AwardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/SituationAwardItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/SituationAwardItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AwardsViewHolder extends RecyclerView.ViewHolder {
        private final SituationAwardItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AwardsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            SituationAwardItemBinding bind = SituationAwardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final SituationAwardItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addWinnerInfo(List<SituationScreen.Companion.WinnerInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.winnerInfoList.clear();
        this.winnerInfoList.addAll(infoList);
        notifyDataSetChanged();
    }
}

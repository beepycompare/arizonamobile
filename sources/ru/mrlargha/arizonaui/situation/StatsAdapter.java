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
import ru.mrlargha.arizonaui.databinding.SituationStatItemBinding;
import ru.mrlargha.arizonaui.situation.SituationScreen;
/* compiled from: StatsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/situation/StatsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/situation/StatsAdapter$StatsViewHolder;", "<init>", "()V", "statInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$StatInfo;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addStatInfo", "infoList", "", "StatsViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatsAdapter extends RecyclerView.Adapter<StatsViewHolder> {
    private final ArrayList<SituationScreen.Companion.StatInfo> statInfoList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StatsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.situation_stat_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new StatsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(StatsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SituationScreen.Companion.StatInfo statInfo = this.statInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(statInfo, "get(...)");
        SituationScreen.Companion.StatInfo statInfo2 = statInfo;
        SituationStatItemBinding binding = holder.getBinding();
        binding.title.setText(statInfo2.getTitle());
        binding.value.setText(statInfo2.getValue());
        if (statInfo2.getSubValue().length() == 0) {
            binding.subValue.setVisibility(8);
        } else {
            binding.subValue.setVisibility(0);
            binding.subValue.setText(statInfo2.getSubValue());
        }
        String icon = statInfo2.getIcon();
        switch (icon.hashCode()) {
            case 99044836:
                if (icon.equals("hands")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_hands_ic);
                    return;
                }
                return;
            case 99151942:
                if (icon.equals("heart")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_heart_ic);
                    return;
                }
                return;
            case 104079552:
                if (icon.equals("money")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_money_ic);
                    return;
                }
                return;
            case 108704329:
                if (icon.equals("route")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_route_ic);
                    return;
                }
                return;
            case 110364485:
                if (icon.equals("timer")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_clock_ic);
                    return;
                }
                return;
            case 1006309824:
                if (icon.equals("mafia-killed")) {
                    binding.statIc.setImageResource(R.drawable.situation_stat_mafia_ic);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.statInfoList.size();
    }

    /* compiled from: StatsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/situation/StatsAdapter$StatsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/SituationStatItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/SituationStatItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StatsViewHolder extends RecyclerView.ViewHolder {
        private final SituationStatItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StatsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            SituationStatItemBinding bind = SituationStatItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final SituationStatItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addStatInfo(List<SituationScreen.Companion.StatInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.statInfoList.clear();
        this.statInfoList.addAll(infoList);
        notifyDataSetChanged();
    }
}

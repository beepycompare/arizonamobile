package ru.mrlargha.commonui.elements.hud.mission_progress;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemMissionProgressBinding;
/* compiled from: MissionProgressAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/mission_progress/MissionProgressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionProgressViewHolder;", "<init>", "()V", "missionList", "", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionData;", "setItems", "", FirebaseAnalytics.Param.ITEMS, "", "clear", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissionProgressAdapter extends RecyclerView.Adapter<MissionProgressViewHolder> {
    private final List<MissionData> missionList = new ArrayList();

    public final void setItems(List<MissionData> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.missionList.clear();
        this.missionList.addAll(items);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.missionList.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MissionProgressViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemMissionProgressBinding inflate = ItemMissionProgressBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MissionProgressViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.missionList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MissionProgressViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MissionData missionData = (MissionData) CollectionsKt.getOrNull(this.missionList, i);
        if (missionData != null) {
            holder.bind(missionData);
        }
    }
}
